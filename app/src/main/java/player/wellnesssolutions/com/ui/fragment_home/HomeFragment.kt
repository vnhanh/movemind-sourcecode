package player.wellnesssolutions.com.ui.fragment_home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import kotlinx.android.synthetic.main.fragment_home.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.common.load_scheduled_videos.ScheduledVideosPresenter
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.StringUtil
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.download.DownloadApi
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.services.DownloadService
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_no_class.NoClassFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment

class HomeFragment : BaseFragment(), IHomeContract.View, ScheduleBroadcastReceiver.ScheduleListener {
    private var mHomePresenter: IHomeContract.Presenter? = null
    private var mSchedulePresenter: IScheduleContract.Presenter? = null

    // Home screen only load schedule automatically only 1 time from start this app
    private var isBeginShowScreen = true

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        restoreStates(savedInstanceState)
        mHomePresenter = HomePresenter(context!!)
        mSchedulePresenter = ScheduledVideosPresenter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.also { arguments ->

            if (arguments.containsKey(Constant.BUNDLE_SCHEDULE)) {
                val videos: ArrayList<MMVideo> = VideoDBUtil.readVideosFromDB(Constant.MM_SCHEDULE, false)
                isBeginShowScreen = false
                mHomePresenter?.setScheduleRemain(videos)
                arguments.clear()
            }

        }
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putBoolean(Constant.STATE_IS_BEGIN_SHOW_SCREEN, true)
//    }

    override fun onResume() {
        super.onResume()

        registerScheduleBroadcast()

        if (isBeginShowScreen) {

            btnLogoBottom?.setOnClickListener {
                if (isBeginShowScreen) return@setOnClickListener
                it.isEnabled = false
                mSchedulePresenter?.onLoadSchedule(view = this@HomeFragment, isClickedFromBtnBottom = true)
                it.isEnabled = true
            }

            handler.postDelayed(runnableAttachPresenterFirstTime, Constant.TIME_TRANSITION_SCREEN)
        } else {
            mHomePresenter?.onAttach(this)
            mSchedulePresenter?.onAttach(this)
        }
    }

    override fun onPause() {
        mHomePresenter?.onDetach()
        mSchedulePresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnableAttachPresenterFirstTime)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterScheduleBroadcast()
        mHomePresenter?.onDestroy()
        //mSchedulePresenter?.onDestroy()
        //mSchedulePresenter = null
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */

    private val runnableAttachPresenterFirstTime = Runnable {
        if (!isBeginShowScreen) return@Runnable
        isBeginShowScreen = false
        mSchedulePresenter?.onLoadSchedule(this, false)

        if (ParameterUtils.isFragmentHomeOpen) {
            context?.let {
                if (SharedPreferencesCustomized.getInstance(it).getBoolean(SPrefConstant.IS_DOWNLOAD_VIDEOS, true)) {
                    getAllVideosForDownload(it)
                } else {
                    checkSubIsChange(it)
                }
            }
            ParameterUtils.isFragmentHomeOpen = false
        }
    }

    private fun continueDownload(it: Context) {
        if (context is MainActivity) {
            (it as MainActivity).checkFileStorageDownloaded()
        }
        val intent = Intent().apply {
            action = DownloadService.ACTION_DOWNLOAD
            putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.DOWNLOAD_START)
        }
        it.sendBroadcast(intent)
    }

    private fun checkSubIsChange(context: Context) {
        val tokenAu: String = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.TOKEN, "")
        val deviceId = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            HomeApi().getUserSubscription(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<Int>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<Int>?) {
                            super.onResponseSuccess(data)
                            if (data == null) return
                            if (SharedPreferencesCustomized.getInstance(context).getInt(SPrefConstant.DOWNLOAD_VIDEOS_SUBS_ID, -1) == -1) {
                                SharedPreferencesCustomized.getInstance(context).putInt(SPrefConstant.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                            }
                            if (SharedPreferencesCustomized.getInstance(context).getInt(SPrefConstant.DOWNLOAD_VIDEOS_SUBS_ID, -1) != data.data) {
                                SharedPreferencesCustomized.getInstance(context).putInt(SPrefConstant.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                                val intent = Intent().apply {
                                    action = DownloadService.ACTION_DOWNLOAD
                                    putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.API_CHANGE_SUB_SERVICE)
                                }
                                context.sendBroadcast(intent)
                            } else {
                                SharedPreferencesCustomized.getInstance(context).putInt(SPrefConstant.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                                continueDownload(context)
                            }
                        }

                        override fun onExpired(error: String) {

                        }
                    })
        }
    }

    private fun getAllVideosForDownload(context: Context) {
        val tokenAu: String = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.TOKEN, "")
        val deviceId = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            DownloadApi().getAllVideosFromServer(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<ArrayList<MMVideo>>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
                            super.onResponseSuccess(data)
                            if (data == null) return
                            VideoDBUtil.saveDVideosToDB(data = data.data, tag = Constant.DownloadTag)
                            SharedPreferencesCustomized.getInstance(context).putBoolean(SPrefConstant.IS_DOWNLOAD_VIDEOS, false)
                            val intent = Intent().apply {
                                action = DownloadService.ACTION_DOWNLOAD
                                putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.DOWNLOAD_START)
                            }
                            context.sendBroadcast(intent)
                        }

                        override fun onExpired(error: String) {

                        }

                    })
        }

    }

    private fun setupUI() {
        btnGetStarted.setOnClickListener { onClickedButtonGetStarted() }
    }

    override fun openNowPlayingScreen(videos: ArrayList<MMVideo>) {
        loadNowPlayingScreen(videos)
    }

    override fun onHaveClassVideosWithTimeWaiting(videos: ArrayList<MMVideo>) {
        mHomePresenter?.setScheduleRemain(videos)
    }

    override fun onReceivePlayVideoScheduleFromUI() {
        mHomePresenter?.onTimePlayAlreadySchedule()
    }

    override fun onReceiveResetScheduleFromUI() {
        mSchedulePresenter?.onLoadSchedule(this, false)
    }

    override fun onReceiveUpdateScheduleFromUI() {
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        mSchedulePresenter?.onLoadSchedule(this, false)
    }

    override fun onReceiveChangeApiBackToHome() {

    }

    override fun onReceiveChangeApiBackToHomeGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                it.getApiConfigData()
            }
        }
    }

    override fun onReceiveChangeApiGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                it.getApiConfigData()
            }
        }
    }

    private fun registerScheduleBroadcast() {
        // register casting TV (presentation) broadcast receiver
        activity?.also { _ ->
            ScheduleBroadcastReceiver.getInstance().addListener(this)
        }
    }

    private fun unregisterScheduleBroadcast() {
        activity?.also { _ ->
            if (ScheduleBroadcastReceiver.getInstance().isRegistered(this)) {
                try {
                    ScheduleBroadcastReceiver.getInstance().removeListener(this)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun onClickedButtonGetStarted() {
        //btnGetStarted?.isEnabled = false
        SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
        HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        viewCoverGetStarted?.visibility = View.VISIBLE
        loadNoClassScreen()
    }

    override fun onNoClassVideos(message: String, @ColorRes msgColor: Int, isClickedFromBtnBottom: Boolean) {
        if (btnGetStarted == null) return
        if (message == Constant.ERROR_CANT_CONNECT_SERVER) {
            val text = String.format("%s %s", getString(R.string.request_class_video_failed), message)
            MessageUtils.showSnackBar(btnGetStarted, text, msgColor)
        }
        //loadNoClassScreen()
    }

    override fun onHaveClassVideos(scheduledVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {
        activity?.also { act ->
            if (act is MainActivity && act.isPresentationAvailable()) {
                MessageUtils.showSnackBar(snackView = btnGetStarted, message = getString(R.string.now_playing_class), colorRes = R.color.white)
                act.playVideo(PlayMode.SCHEDULE, scheduledVideos)

                loadNoClassScreen()
            } else {
                loadNowPlayingScreen(scheduledVideos)
            }
        }
    }

    private fun loadNoClassScreen() {
        FragmentUtil.replaceFragment(
                fm = activity?.supportFragmentManager,
                newFragment = ControlFragment.getInstance(NoClassFragment.TAG),
                newFragmentTag = ControlFragment.TAG,
                frameId = R.id.frameLayoutHome,
                isAddToBackStack = false
        )
    }

    private fun loadNowPlayingScreen(scheduleVideos: ArrayList<MMVideo>) {
        activity?.supportFragmentManager?.also { fm ->
            NowPlayingVideoSetupHelper.openNowPlayingWithSchedule(fm, scheduleVideos)
        }
    }

    override fun showMessage(message: String, color: Int) {
        if (btnGetStarted != null)
            MessageUtils.showSnackBar(btnGetStarted, message, color)
    }

    override fun showMessage(messageRes: Int, color: Int) {
        if (btnGetStarted != null)
            MessageUtils.showSnackBar(btnGetStarted, messageRes, color)
    }

    override fun showLoadingProgress() {
        if (btnGetStarted != null) {
            btnGetStarted.isEnabled = false
        }
    }

    override fun hideLoadingProgress() {
        if (btnGetStarted != null) {
            btnGetStarted.isEnabled = true
        }
    }

    override fun showUI(loadedConfig: MMConfigData?) {
        if (btnGetStarted != null) {
            if (btnGetStarted.visibility != View.INVISIBLE)
                btnGetStarted.visibility = View.INVISIBLE

            if (loadedConfig != null)
                btnGetStarted.text = convertButtonText(loadedConfig.getStartedButtonText)
            else
                btnGetStarted.text = getString(R.string.btn_title_get_started)

            btnGetStarted.visibility = View.VISIBLE
        }

        if (tvHelperText != null) {
            if (tvHelperText.visibility != View.INVISIBLE)
                tvHelperText.visibility = View.INVISIBLE

            if (loadedConfig != null) {
                StringUtil.setupFontMadeESNormal(tvHelperText)
                tvHelperText.text = loadedConfig.getStartedHelperText
            }

            tvHelperText.visibility = View.VISIBLE
        }
    }

    override fun onReceiveChangeSub() {
        super.onReceiveChangeSub()
        activity?.let {
            if (it is MainActivity) {
                it.showDialogBackToHome()
            }
            DownloadVideoHelper.senStorageStatusToServer(it,
                    FileUtil.getAvailableInternalMemorySize(),
                    FileUtil.getTotalInternalMemorySize(),
                    FileUtil.getAvailableExternalMemorySize(it),
                    FileUtil.getTotalExternalMemorySize(it))

        }
    }

    private fun convertButtonText(input: String): String {
        val str = input.trim()
        val firstBlank = str.indexOf(" ")

        return when (firstBlank > 0) {
            true -> {
                StringBuilder(str.substring(0, firstBlank)).append("\n").append(str.substring(firstBlank + 1)).toString()
            }

            false -> {
                str
            }
        }
    }

    /**
     * -------------------
     */

    companion object {
        const val TAG = "HomeFragment"

        fun getInstance(): HomeFragment = HomeFragment()

        fun getInstanceWithRemainSchedule(videos: ArrayList<MMVideo>): HomeFragment = HomeFragment().apply {
            VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
            val bundle = Bundle().apply {
                putBoolean(Constant.BUNDLE_SCHEDULE, true)
            }
            arguments = bundle
        }

        fun updateAlreadyInstance(fragment: HomeFragment, videos: ArrayList<MMVideo>): HomeFragment = fragment.apply {
            arguments = Bundle().apply {
                VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
                putBoolean(Constant.BUNDLE_SCHEDULE, true)
            }
        }
    }
}