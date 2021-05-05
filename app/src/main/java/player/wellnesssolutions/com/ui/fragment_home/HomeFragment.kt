package player.wellnesssolutions.com.ui.fragment_home

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
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
import player.wellnesssolutions.com.common.utils.DialogUtil
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
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_no_class.NoClassFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment

class HomeFragment : BaseScheduleFragment(), IHomeContract.View {
    private var presenter: IHomeContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("LOG", this.javaClass.simpleName + " onActivityCreated() ")
        readArguments()
        setupUI()
    }

    private fun readArguments() {
        arguments?.also { bundle ->
            val sourceLoadSchedule = bundle.getString(Constant.BUNDLE_SOURCE_SCHEDULE).orEmpty()

            when {
                sourceLoadSchedule != SOURCE_LOAD_SCHEDULE.REMOTE.toString() -> {
                    btnGetStarted?.isEnabled = true
                }
            }
            bundle.remove(Constant.BUNDLE_SOURCE_SCHEDULE)

            val message = bundle.getString(Constant.BUNDLE_SHOW_POPUP, "").orEmpty()
            Log.d("LOG", this.javaClass.simpleName + " onCreateView() | sourceLoadSChedule: ${sourceLoadSchedule} | " +
                    "message for popup: ${message} | button getStarted state: ${btnGetStarted?.isEnabled}")
            when {
                message.isNotBlank() -> presenter?.setupShowPopUpOnStartScreen(message)
            }
            bundle.remove(Constant.BUNDLE_SHOW_POPUP)

            val messageSnackbar = bundle.getString(Constant.BUNDLE_SHOW_SNACKBAR, "").also { messageSnackbar ->
                if (messageSnackbar.isNotBlank()) {
                    presenter?.setupShowSnackbarOnStartScreen(messageSnackbar)
                }
                bundle.remove(Constant.BUNDLE_SHOW_SNACKBAR)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        PreferenceHelper.getInstance()?.putBoolean(ConstantPreference.IS_IN_BACKGROUND, false)
        Log.d("LOG", this.javaClass.simpleName + " onResume() | isNewScreen: $isNewScreen")
        if (isNewScreen) {
            handler.postDelayed(runnableAttachPresenterFirstTime, Constant.TIME_POST_DELAY_DEFAULT)
        } else {
            presenter?.onAttach(this)
        }

        setOldScreen()
    }

    override fun onPause() {
        presenter?.onDetach()
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LOG", this.javaClass.simpleName + " onSaveInstanceState()")
        PreferenceHelper.getInstance()?.putBoolean(ConstantPreference.IS_IN_BACKGROUND, true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            handler.removeCallbacks(null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    override fun showPopUp(messagePopUpOnStart: String) {
        handler.post {
            dialog?.dismiss()
            context?.also { context ->
                dialog = DialogUtil.createDialogOnlyOneButton(context, messagePopUpOnStart, R.string.btn_ok,
                        object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                                dialogInterface?.dismiss()
                                dialog = null
                            }

                        }).apply { show() }
            }
        }
    }

    override fun showSnackbar(message: String) {
        if (message.isNotBlank()) {
            handler.post {
                MessageUtils.showSnackBar(
                        snackView = btnLogoBottom,
                        message = message,
                        colorRes = R.color.white
                )
            }
        }
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */

    private val runnableAttachPresenterFirstTime = Runnable {
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
        presenter?.onAttach(this)
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
        Log.d("LOG", "HomeFragment - getAllVideosForDownload()")
        val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            DownloadApi().getAllVideosFromServer(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<ArrayList<MMVideo>>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
                            super.onResponseSuccess(data)
                            Log.d("LOG", "HomeFragment - getAllVideosForDownload() | current thread: ${Thread.currentThread()} | name: ${Thread.currentThread().name}")
                            if (data == null) return
                            VideoDBUtil.saveDVideosToDB(data = data.data, tag = Constant.TAG_VIDEO_DOWNLOAD)
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
        btnLogoBottom?.setOnClickListener {
            it.isEnabled = false
            loadSchedule(true)
            it.isEnabled = true
        }
        btnGetStarted?.setOnClickListener { onClickedButtonGetStarted() }
    }

    override fun openNowPlayingScreen(videos: ArrayList<MMVideo>) {
        loadNowPlayingScreen()
    }

    private fun onClickedButtonGetStarted() {
        //btnGetStarted?.isEnabled = false
        SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
        HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        viewCoverGetStarted?.visibility = View.VISIBLE

        loadControlScreen()
    }

    override fun onNoClassVideosForNow(scheduleVideos: ArrayList<MMVideo>, message: String, @ColorRes msgColor: Int, isLoadScheduleManually: Boolean) {
        if (btnGetStarted == null) return
        if (message == Constant.ERROR_CANT_CONNECT_SERVER) {
            val text = String.format("%s %s", context?.getString(R.string.request_class_video_failed).orEmpty(), message)
            MessageUtils.showSnackBar(btnGetStarted, text, msgColor)
        } else if (scheduleVideos.size > 0) {
            val isCasted = playVideoPresentationable(scheduleVideos)
            if (isCasted) {
                loadControlScreen()
            }
        }
        //loadNoClassScreen()
    }

    override fun onHaveClassVideos(scheduleVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {
        activity?.also { activity ->
            if (activity is MainActivity && activity.isPresentationAvailable()) {
                MessageUtils.showSnackBar(snackView = btnGetStarted, message = context?.getString(R.string.now_playing_class).orEmpty(), colorRes = R.color.white)
                activity.playVideo(PlayMode.SCHEDULE, scheduleVideos)
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

    private val runnableOpenNowPlayingWithSchedule = Runnable {
        activity?.supportFragmentManager?.also { fm ->
            if (!isStartedOpenNewScreen) {
                isStartedOpenNewScreen = true
                NowPlayingVideoSetupHelper.openNowPlayingWithSchedule(fm)
            }
        }
    }

    private fun loadNowPlayingScreen() {
        Log.d("LOG", this.javaClass.simpleName + " loadNowPlayingScreen() | isStartedOpenNewScreen: $isStartedOpenNewScreen")
        handler.post(runnableOpenNowPlayingWithSchedule)
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

        fun getInstanceNotLoadSchedule(): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
            }
        }

        fun getInstanceNotLoadScheduleAndShowPopUp(message: String): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
                putString(Constant.BUNDLE_SHOW_POPUP, message)
            }
        }

        fun getInstanceNotLoadScheduleAndShowSnackbar(message: String): HomeFragment = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
                putString(Constant.BUNDLE_SHOW_SNACKBAR, message)
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

        fun updateAlreadyInstanceWithNotLoadScheduleAndShowPopUp(fragment: HomeFragment, message: String): Fragment = fragment.apply {
            arguments = Bundle().apply {
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
                putString(Constant.BUNDLE_SHOW_POPUP, message)
            }
        }

    }
}