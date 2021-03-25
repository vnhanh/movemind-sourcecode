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
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.StringUtil
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.SOURCE_LOAD_SCHEDULE
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.download.DownloadApi
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.services.DownloadService
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_no_class.NoClassFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment

class HomeFragment : BaseScheduleFragment(), IHomeContract.View {
    private var presenter: IHomeContract.Presenter? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(context!!)
        btnGetStarted?.isEnabled = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        if (ParameterUtils.isFragmentHomeOpen) {
//            context?.let {
//                if (PreferenceHelper.getInstance(it).getBoolean(ConstantPreference.IS_DOWNLOAD_VIDEOS, true)) {
//                    getAllVideosForDownload(it)
//                } else {
//                    checkSubIsChange(it)
//                }
//            }
//            ParameterUtils.isFragmentHomeOpen = false
//        }

//        arguments?.also { arguments ->
//            isLoadScheduleOnScreenRefresh = arguments.getBoolean(Constant.BUNDLE_SCHEDULE, false)
//            arguments.clear()
//        }
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        registerScheduleBroadcast()
        Log.d("LOG", this.javaClass.simpleName + " onResume() | isNewScreen: $isNewScreen")
        if (isNewScreen) {
            btnLogoBottom?.setOnClickListener {
                it.isEnabled = false
                loadSchedule(true)
                it.isEnabled = true
            }

            handler.postDelayed(runnableAttachPresenterFirstTime, Constant.TIME_TRANSITION_SCREEN)
        } else {
            presenter?.onAttach(this)
        }

        setOldScreen()
    }

    override fun onPause() {
        presenter?.onDetach()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("LOG", this.javaClass.simpleName + " onDestroyView()")
        unregisterScheduleBroadcast()
        handler.removeCallbacks(runnableAttachPresenterFirstTime)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LOG", this.javaClass.simpleName + " onDestroy()")
        presenter?.onDestroy()
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */

    private val runnableAttachPresenterFirstTime = Runnable {
        if (isNewScreen) return@Runnable

        if (ParameterUtils.isFragmentHomeOpen) {
            context?.let {
                if (PreferenceHelper.getInstance(it).getBoolean(ConstantPreference.IS_DOWNLOAD_VIDEOS, true)) {
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
        val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            HomeApi().getUserSubscription(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<Int>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<Int>?) {
                            super.onResponseSuccess(data)
                            if (data == null) return
                            if (PreferenceHelper.getInstance(context).getInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, -1) == -1) {
                                PreferenceHelper.getInstance(context).putInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                            }
                            if (PreferenceHelper.getInstance(context).getInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, -1) != data.data) {
                                PreferenceHelper.getInstance(context).putInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                                val intent = Intent().apply {
                                    action = DownloadService.ACTION_DOWNLOAD
                                    putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.API_CHANGE_SUB_SERVICE)
                                }
                                context.sendBroadcast(intent)
                            } else {
                                PreferenceHelper.getInstance(context).putInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, data.data)
                                continueDownload(context)
                            }
                        }

                        override fun onExpired(error: String) {

                        }
                    })
        }
    }

    private fun getAllVideosForDownload(context: Context) {
        val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            DownloadApi().getAllVideosFromServer(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<ArrayList<MMVideo>>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
                            super.onResponseSuccess(data)
                            if (data == null) return
                            VideoDBUtil.saveDVideosToDB(data = data.data, tag = Constant.DownloadTag)
                            PreferenceHelper.getInstance(context).putBoolean(ConstantPreference.IS_DOWNLOAD_VIDEOS, false)
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
        btnGetStarted?.setOnClickListener { onClickedButtonGetStarted() }
    }

    override fun openNowPlayingScreen(videos: ArrayList<MMVideo>) {
        loadNowPlayingScreen()
    }

    override fun onHaveClassVideosWithTimeWaiting(videos: ArrayList<MMVideo>) {
//        mHomePresenter?.setScheduleCurrent(videos)
    }

    private fun registerScheduleBroadcast() {
        // register casting TV (presentation) broadcast receiver
        ScheduleBroadcastReceiver.getInstance().addListener(this)
    }

    private fun unregisterScheduleBroadcast() {
        if (ScheduleBroadcastReceiver.getInstance().isRegistered(this)) {
            try {
                ScheduleBroadcastReceiver.getInstance().removeListener(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun onClickedButtonGetStarted() {
        //btnGetStarted?.isEnabled = false
        SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
        HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        viewCoverGetStarted?.visibility = View.VISIBLE

        loadControlScreen()
    }

    override fun onNoClassVideosForNow(message: String, @ColorRes msgColor: Int, isClickedFromBtnBottom: Boolean) {
        if (btnGetStarted == null) return
        if (message == Constant.ERROR_CANT_CONNECT_SERVER) {
            val text = String.format("%s %s", getString(R.string.request_class_video_failed), message)
            MessageUtils.showSnackBar(btnGetStarted, text, msgColor)
        }
        //loadNoClassScreen()
    }

    override fun onHaveClassVideos(scheduleVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {
        activity?.also { act ->
            if (act is MainActivity && act.isPresentationAvailable()) {
                MessageUtils.showSnackBar(snackView = btnGetStarted, message = getString(R.string.now_playing_class), colorRes = R.color.white)
                act.playVideo(PlayMode.SCHEDULE, scheduleVideos)

                loadControlScreen()
            } else {
                loadNowPlayingScreen()
            }
        }
    }

    override fun onTimePlaySchedule() {
        loadNowPlayingScreen()
    }

    private fun loadControlScreen() {
        Log.d("LOG", this.javaClass.simpleName + " loadControlScreen() | isStartedOpenNewScreen: $isStartedOpenNewScreen")
        if (isStartedOpenNewScreen) return
        isStartedOpenNewScreen = true
        FragmentUtil.replaceFragment(
                fm = activity?.supportFragmentManager,
                newFragment = ControlFragment.getInstance(NoClassFragment.TAG),
                newFragmentTag = ControlFragment.TAG,
                frameId = R.id.frameLayoutHome,
                isAddToBackStack = false
        )
    }

    private fun loadNowPlayingScreen() {
        Log.d("LOG", this.javaClass.simpleName + " loadNowPlayingScreen() | isStartedOpenNewScreen: $isStartedOpenNewScreen")
        if (isStartedOpenNewScreen) return
        activity?.supportFragmentManager?.also { fm ->
            isStartedOpenNewScreen = true
            NowPlayingVideoSetupHelper.openNowPlayingWithSchedule(fm)
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

        fun getInstanceWithLoadSchedule(): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.REMOTE.name)
            }
        }

        fun updateAlreadyInstanceWithLoadSchedule(fragment: HomeFragment): HomeFragment = fragment.apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.REMOTE.name)
            }
        }

        fun getInstanceNoLoadSchedule(): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
            }
        }

        fun updateAlreadyInstanceWithNoSchedule(fragment: HomeFragment): Fragment = fragment.apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
            }
        }

        fun updateAlreadyInstanceWithNotLoadSchedule(fragment: HomeFragment): Fragment = fragment.apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
            }
        }

    }
}