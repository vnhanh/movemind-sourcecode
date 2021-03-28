package player.wellnesssolutions.com.ui.fragment_now_playing

import android.content.DialogInterface
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.android.synthetic.main.custom_controller_player_screen_now_playing.*
import kotlinx.android.synthetic.main.custom_controller_player_screen_now_playing.view.*
import kotlinx.android.synthetic.main.exo_simple_player_view.view.*
import kotlinx.android.synthetic.main.fragment_control.*
import kotlinx.android.synthetic.main.fragment_now_playing.*
import kotlinx.android.synthetic.main.layout_float_menu.*
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.*
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.btnCloseMenuFloat
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.btnLogoBottom
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.btnMenuFloat
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.constraintArrowDown
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.constraintArrowUp
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.frameOverlay
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.menuFloat
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.viewBgGroupControllers
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.wrapperMenuFloat
import kotlinx.android.synthetic.main.merge_load_brand.*
import kotlinx.android.synthetic.main.merge_now_playing_coming_up_next.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController
import player.wellnesssolutions.com.base.common.play_video.PlayVideoDisplayHelper
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils.mCountDownNumber
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.SOURCE_LOAD_SCHEDULE
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.custom_exoplayer.PlayerState
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import player.wellnesssolutions.com.ui.activity_main.IRouterChanged
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.PresentationDataHelper
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.*
import player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextAdapter
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment
import player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil

class NowPlayingFragment : BaseScheduleFragment(), INowPlayingConstruct.View, IRouterChanged,
        NetworkReceiver.IStateListener, ScheduleBroadcastReceiver.ScheduleListener {
    private var mPresenter: INowPlayingConstruct.Presenter? = null

    // for handle operations related to menu
    private var mMenuSetupHelper = NowPlayingFloatMenuHelper()

    // list of collections that will be showed on the playing video in main screen
    private var mExtraMainCollectionViews: ArrayList<TextView>? = ArrayList()

    // list of collections that will be showed on the playing video in group views coming up next
    private var mExtraItemCollectionViews: ArrayList<TextView>? = ArrayList()

    // manage download task of playing video
    //private var mMainDownloadButtonManager: DownloadButtonManager? = null

    private var mIsTranslateCompleted = false

    private var mNowVideo: MMVideo? = null
    private var mNowVideoLength = 0L

    private var mComingUpVideos: ArrayList<MMVideo>? = null

    // async task check player position of playing video
    // help to check if playing video is ended or not
    private var mCheckVideoPositionRunnable: MonitorVideoAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LOG", this.javaClass.simpleName + " onCreate()")

        readArguments()
    }

    private fun readArguments() {
        arguments?.also { extras ->
            when {
                extras.containsKey(Constant.BUNDLE_SCHEDULE) -> {
                    val videos: ArrayList<MMVideo> = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
                    Log.d("LOG", this.javaClass.simpleName + " onCreate() | read arguments | SCHEDULE | videos number: ${videos.size}")
                    mPresenter = NowPlayingPresenter(
                            context = context!!,
                            playMode = PlayMode.SCHEDULE
                    ).apply {
                        setVideos(videos)
                    }
                }

                extras.containsKey(KEY_DATA_PLAYING_VIDEO) -> {
                    val videos: ArrayList<MMVideo> = VideoDBUtil.getVideosFromDB(TAG, true)
                    Log.d("LOG", this.javaClass.simpleName + " readArguments() | PLAY VIDEO SEARCHED | videos number: ${videos.size}")
                    mPresenter = NowPlayingPresenter(
                            context = context!!,
                            playMode = PlayMode.ON_DEMAND
                    ).apply {
                        setVideos(videos)
                    }
                }
            }

            extras.clear()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_now_playing, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("LOG", this.javaClass.simpleName + " onActivityCreated()")
        if (arguments != null && arguments?.isEmpty == false) {
            readArguments()
        }

        // create the animation handler (@mAnimHelper) and reset all flags to make the menu animations run smoothly
        // once fragment is created or be backed from another screen
        mMenuSetupHelper.onInit()

        registerMediaRouterConnected()
        registerNetworkConnecting()
        setupUI()

        // prevent lag on translating fragment
        mIsTranslateCompleted = false

//        view?.postDelayed({
        mIsTranslateCompleted = true
        mNowVideo?.also { video ->
            mComingUpVideos?.also { comingUpVideos ->
                showUI(video, comingUpVideos)
            }
        }
//        }, 400L)
    }

    override fun onResume() {
        super.onResume()
        attachPresenter()
        setOldScreen()
    }

    private fun attachPresenter() {
        mPresenter?.onAttach(this)
    }

    override fun onPause() {
//        mIsStop = true
        mCheckVideoPositionRunnable?.stopTask()
        detachPresenters()
        super.onPause()
    }

    override fun onDestroyView() {
        unRegisterMediaRouterConnected()

        unregisterNetworkConnecting()

        //releaseDownloadButtonManager()

        releaseExtraViews()

        videoPlayer?.setControllerVisibilityListener(null)

        releaseAdapters()

        releasePresenters()

        //save time countdown for backing from other screen
        context?.let {
            PreferenceHelper.getInstance(it).putLong(ConstantPreference.LAST_TIME_COUNT_DOWN, mCountDownNumber)
        }

        super.onDestroyView()
    }

    private fun releasePresenters() {
        mPresenter?.onStop()
    }

    override fun onDestroy() {
        mMenuSetupHelper.onRelease()

        destroyPresenters()

        super.onDestroy()
    }

    //    private fun releaseDownloadButtonManager() {
//        mMainDownloadButtonManager?.release()
//        mMainDownloadButtonManager = null
//    }

    private fun releaseExtraViews() {
        mExtraMainCollectionViews?.clear()
        mExtraMainCollectionViews = null
        mExtraItemCollectionViews?.clear()
        mExtraItemCollectionViews = null
    }

    private fun releaseAdapters() {
        rvComingUpNext?.adapter?.also {
            if (it is NowPlayingComingUpNextAdapter)
                it.release()
        }
    }

    private fun detachPresenters() {
        mPresenter?.onDetach()
    }

    private fun destroyPresenters() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    private fun setupUI() {
        setupMenuFloat()

        //setupButtonDownload()

        setupVideoPlayerController()

        setupVideoPlayerOnMode()

        setupButtonLogo()

        setupTextViewCountdownTime()

        setupBtnPrevious()
    }

    private fun setupBtnPrevious() {
        btnPrevious?.also { button ->
            button.visibility = View.VISIBLE
            button.setOnClickListener {
                PreferenceHelper.getInstance(context = button.context).delete(ConstantPreference.LAST_PLAYED_VIDEO_POSITION)
                onBackPressed(button)
            }
        }
    }

    private fun setupTextViewCountdownTime() {
        context?.also {
            // set NORMAL MADE_EVOLVE_SANS font
            val tf: Typeface = TypefaceUtil.getTypeface(it, getString(R.string.font_made_evolve_sans))
            tvCountdownTimerUntilPlay.setTypeface(tf, Typeface.BOLD)
        }
    }

//    private fun setupButtonDownload() {
//        mMainDownloadButtonManager = DownloadButtonManager(parentView.btnDownload, groupViewsComingUpNext.btnDownloadPlaying)
//    }

    private fun setupVideoPlayerOnMode() {
        view?.also { parentView ->

            if (btnPlayVideo.visibility != View.GONE)
                btnPlayVideo.visibility = View.GONE

            if (btnPauseVideo.visibility != View.GONE)
                btnPauseVideo.visibility = View.GONE

            NowPlayingVideoSetupHelper.setupViewsForPlayer(parentView, mPresenter)
            NowPlayingVideoSetupHelper.setupComingUpNext(parentView, mMenuSetupHelper, mPresenter)

            mPresenter?.getPlayMode()?.also { mode ->
                when (mode) {
                    PlayMode.SCHEDULE -> {
                        videoPlayer.exo_play?.setOnClickListener(null)
                        videoPlayer.exo_pause?.setOnClickListener(null)
                        videoPlayer.exo_progress?.wasEnable = false
                    }

                    PlayMode.ON_DEMAND -> {
                        videoPlayer.exo_play?.setOnClickListener {
                            if (mCheckVideoPositionRunnable?.isStop() == true && mPresenter?.isPlayingCC() == true) {
                                postDelayCheckVideoPosition()
                            }
//                            if(mTimer.isCancel()) scheduleCheckVideoEndedTask()

                            mPresenter?.resumeOrReplay()
                        }

                        videoPlayer.exo_pause?.setOnClickListener {
                            mPresenter?.pauseVideo()
                            mCheckVideoPositionRunnable?.stopTask()
                        }

                        videoPlayer.exo_progress?.wasEnable = true
                    }
                }
            }
        }
    }

    private fun setupButtonLogo() {
        btnLogoBottom?.setOnClickListener {
            it.isEnabled = false
            mPresenter?.clickToCallServiceLoadSchedule()
            it.isEnabled = true
        }
    }

    override fun showDialogAskWantToLoadSchedule() {
        context?.also { context ->
            val message = context.getString(R.string.do_you_wan_to_reload_schedule)
            val okButtonListener = DialogInterface.OnClickListener { _, _ ->
                Log.d("LOG", "NowPlayingFragment | clicked button logo")
                mPresenter?.stopCountdown()
                mCheckVideoPositionRunnable?.stopTask()
                loadSchedule(true)
                SearchResultFragment.mVideosToPlay.clear()
            }

            dialog = DialogUtil.createDialogTwoButtons(context = context, message = message, titleLeftButton = R.string.btn_no,
                    leftButtonClickListener = null, titleRightButton = R.string.btn_yes, rightButtonClickListener = okButtonListener).apply { show() }
        }
    }

    override fun onLoadScheduleWhilePlaySearchedVideos() {
        mPresenter?.stopCountdown()
        mCheckVideoPositionRunnable?.stopTask()
        loadSchedule(true)
        SearchResultFragment.mVideosToPlay.clear()
    }


    // vars help for determining swipe or click on video player
    private var mVideoPlayerTouchedX = 0f
    private var mVideoPlayerTouchedY = 0f

    private fun hideGroupViewComingUpNext() {
        groupViewsComingUpNext?.also {
            if (it.visibility != View.GONE)
                it.visibility = View.GONE
        }
    }

    private fun setupVideoPlayerController() {
        mPresenter?.setSubtitleController(ClosedCaptionController(playerControllerView, videoPlayer.exo_subtitles))
        videoPlayer.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mVideoPlayerTouchedX = event.x
                    mVideoPlayerTouchedY = event.y
                }

                MotionEvent.ACTION_UP -> {
                    val translatedX: Float = event.x - mVideoPlayerTouchedX
                    val translatedY: Float = event.y - mVideoPlayerTouchedY
                    if (translatedX < 10f && translatedY < 10f) {
                        hideGroupViewComingUpNext()
                    }
                }
            }

            return@setOnTouchListener false
        }

        videoPlayer.exo_subtitles.setFixedTextSize(TypedValue.COMPLEX_UNIT_DIP,
                NowPlayingVideoSetupHelper.SUBTITLES_TEXTSIZE * 1f)

        videoPlayer.setControllerVisibilityListener { visibleId ->

            val playerState: PlayerState? = mPresenter?.getPlayerState()
            val isPreparingOnDemandVideo = mPresenter?.getPlayMode() == PlayMode.ON_DEMAND &&
                    (playerState == PlayerState.NOTHING || playerState == PlayerState.COUNTDOWN)
            val isLoadingVideo = progressLoadingVideo?.visibility == View.VISIBLE

            when (visibleId) {
                View.VISIBLE -> {
                    showVideoTitleAndCollections()

                    if (isLoadingVideo || isPreparingOnDemandVideo) {
                        PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)
                        videoPlayer.hideController()
                    } else {
                        videoPlayer.player?.let { players ->
                            when (players.playbackState) {
                                Player.STATE_IDLE -> {
                                    // do nothing
                                }
                                Player.STATE_ENDED -> {
                                    PlayVideoDisplayHelper.displayOnEnded(progressLoadingVideo, btnPlayVideo, btnPauseVideo)
                                    hideGroupViewComingUpNext()
                                    btnComingUpNext.visibility = View.INVISIBLE
                                    constraintArrowDown.visibility = View.INVISIBLE
                                    constraintArrowUp.visibility = View.INVISIBLE
                                    if (mPresenter?.getPlayMode() == PlayMode.SCHEDULE) {

                                    } else if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND && mPresenter?.getAllVideos()?.size ?: 0 == 0) {
                                        // TODO: check case play searched videos from control screen
                                        btnPrevious?.performClick()
                                    } else {

                                    }
                                }
                                else -> {
                                    val isPlaying: Boolean = players.playWhenReady
                                    PlayVideoDisplayHelper.displayControllerPlayViews(isPlaying, btnPlayVideo, btnPauseVideo)
                                }
                            }
                        }
                    }
                }

                else -> {
                    frameExoVoume?.also { layout ->
                        if (layout.visibility != View.GONE)
                            layout.visibility = View.GONE
                    }

                    if (isLoadingVideo || isPreparingOnDemandVideo) {
                        showVideoTitleAndCollections()
                    } else {
                        hideVideoTitleAndCollections()
                    }

                    PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)

                    playerControllerView.findViewById<View>(R.id.closedCaptionController)?.visibility = View.GONE
                }
            }
        }
    }

    private fun setupMenuFloat() {
        activity?.supportFragmentManager?.also { _ ->
            mMenuSetupHelper.setupFloatMenu(btnMenuFloat, btnCloseMenuFloat, wrapperMenuFloat, menuFloat,
                    frameOverlay, viewBgGroupControllers, mPresenter)
        }
    }

    /**
     *
     */
    override fun showMessage(messageRes: Int, color: Int) {
        if (videoPlayer != null) {
            MessageUtils.showSnackBar(videoPlayer, messageRes, color)
        }
    }

    override fun showMessage(message: String, color: Int) {
        if (videoPlayer != null) {
            MessageUtils.showSnackBar(videoPlayer, message, color)
        }
    }

    override fun returnPrevScreen() {
        activity?.onBackPressed()
    }

    override fun showLoadingProgress() {
        progressLoadingVideo?.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        if (isUpdatingNewSchedule()) return
        progressLoadingVideo?.visibility = View.GONE
    }

    override fun onStartInitializePlayer() {
        hideCountDown()
        showLoadingProgress()
    }

    override fun reloadScheduledVideo() {
        postDelayCheckVideoPosition()
    }

    override fun onPlayerInitialized(player: SimpleExoPlayer, isReload: Boolean) {
        parentView?.also { rootView ->

            NowPlayingVideoInfoDisplayHelper.setupVideo(rootView, player)
            seekbarVolume.progress = (player.volume * 100).toInt()
            if (player.volume == 0f) exo_volume.setImageResource(R.drawable.ic_volume_mute_white_28dp)

            if (mPresenter?.isPlayingCC() == true) {
                postDelayCheckVideoPosition()
            }
        }
    }

    override fun onIntermediateStage() {
        mCheckVideoPositionRunnable?.stopTask()
        showCountDown()
    }

    override fun onReceiveChangeApiBackToHome() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveChangeApiBackToHome()")
        activity?.let {
            if (it is MainActivity) {
                mPresenter?.stopCountdown()
                SearchResultFragment.mVideosToPlay.clear()
                it.showDialogBackToHome()
                Handler().postDelayed({
                    it.hideDialogBackToHome()
                    NowPlayingVideoSetupHelper.openHomeFragmentWithLoadSchedule(fm = it.supportFragmentManager)
                }, 3000)
            }
        }

    }

    override fun onReceiveChangeSub() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveChangeSub()")
        activity?.let {
            if (it is MainActivity) {
                mPresenter?.stopCountdown()
                SearchResultFragment.mVideosToPlay.clear()
                it.showDialogBackToHome()
                if (it.appVisible) {
                    Handler().postDelayed({
                        NowPlayingVideoSetupHelper.openHomeFragmentWithLoadSchedule(fm = it.supportFragmentManager)
                    }, 3000)
                }
            }
            DownloadVideoHelper.senStorageStatusToServer(it,
                    FileUtil.getAvailableInternalMemorySize(),
                    FileUtil.getTotalInternalMemorySize(),
                    FileUtil.getAvailableExternalMemorySize(it),
                    FileUtil.getTotalExternalMemorySize(it))
        }
    }

    override fun onReceiveChangeApiBackToHomeGetConfigApi() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveChangeApiBackToHomeGetConfigApi()")
        activity?.let {
            if (it is MainActivity) {
                mPresenter?.stopCountdown()
                SearchResultFragment.mVideosToPlay.clear()
                it.showDialogBackToHome()
                it.getApiConfigData()
                Handler().postDelayed({
                    //it.hideDialogBackToHome()
                    NowPlayingVideoSetupHelper.openHomeFragmentWithLoadSchedule(fm = it.supportFragmentManager)
                }, 3000)
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

    private fun showVideoTitleAndCollections() {
        tvTitleVideo?.visibility = View.VISIBLE
        groupMainCollections?.visibility = View.VISIBLE
    }

    private fun hideVideoTitleAndCollections() {
        tvTitleVideo?.visibility = View.GONE
        groupMainCollections?.visibility = View.GONE
    }

    private fun showCountDown() {
        hideLoadingProgress()
        imageBgHomeScreen?.visibility = View.VISIBLE
        videoPlayer?.hideController()
        videoPlayer?.visibility = View.INVISIBLE
    }

    private fun hideCountDown() {
        videoPlayer?.visibility = View.VISIBLE
        imageBgHomeScreen?.visibility = View.INVISIBLE
        tvCountdownTimerUntilPlay?.visibility = View.GONE
        videoPlayer?.hideController()
    }

    override fun showUIForPlayingVideo(videoData: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " showUIForPlayingVideo()")
        activity?.also { activity ->
            if (activity is MainActivity && activity.isPresentationAvailable()) {

            } else {
                this.mNowVideo = videoData
                this.mNowVideoLength = ((videoData.videoLength ?: 0f) * 1000).toLong()
                this.mComingUpVideos = comingUpVideos

                if (mIsTranslateCompleted) {
                    showUI(videoData, comingUpVideos)
                }
            }
        }
    }

    private fun showUI(video: MMVideo, comingUpNextVideos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " showUI() | video name: ${video.videoName} | coming videos number: ${comingUpNextVideos.size}")
        videoPlayer?.let {
            it.useController = true
        }

        parentView?.also { rootView ->
            // mMainDownloadButtonManager?.setVideoData(video)

            NowPlayingVideoInfoDisplayHelper.displayPlayingVideo(rootView,
                    groupMainCollections, video,
                    mExtraMainCollectionViews).also {
                mExtraMainCollectionViews = it
            }

            // show video nowplaying data in group views coming up next
            mExtraItemCollectionViews = GCUDisplayHelper.showPlayingVideoInfo(groupViewsComingUpNext, video, mExtraItemCollectionViews)
            GCUDisplayHelper.showVideosComingUpNext(comingUpNextVideos, rvComingUpNext, mPresenter)
        }

        tvTitleVideo?.let {
            it.visibility = View.VISIBLE
        }

        groupMainCollections?.let {
            it.visibility = View.VISIBLE
        }
    }

    private fun postDelayCheckVideoPosition() {
        mCheckVideoPositionRunnable?.stopTask()
        mCheckVideoPositionRunnable = MonitorVideoAsyncTask(view, mPresenter).also {
            it.startTask()
        }
    }

    override fun isCastableOnTV(): Boolean {
        return activity?.let {
            activity is MainActivity && (activity as MainActivity).isPresentationAvailable()
        } ?: false
    }

    override fun backToHomeScreenWithNotLoadSchedule() {
        Log.d("LOG", this.javaClass.simpleName + " backToHomeScreenWithNotLoadSchedule()")
        handleMoveToNewScreenButUpdatingNewSchedule(true, {
            NowPlayingVideoSetupHelper.openHomeFragmentWithNotLoadSchedule(fm = activity?.supportFragmentManager)
        })
    }

    override fun openNoClassSearchScreen(isClickedFromBtnBottom: Boolean?) {
        Log.d("LOG", this.javaClass.simpleName + " openNoClassSearchScreen()")

        handleMoveToNewScreenButUpdatingNewSchedule(true, {
            NowPlayingVideoSetupHelper.openHomeFragmentWithNotLoadSchedule(fm = activity?.supportFragmentManager)
        })
    }

    private fun handleMoveToNewScreenButUpdatingNewSchedule(isBackToHomeScreen: Boolean, caseNotUpdating: () -> Unit) {
        Log.d("LOG", this.javaClass.simpleName + " handleMoveToNewScreenButUpdatingNewSchedule() | isUpdatingNewSchedule()")
        when {
            isUpdatingNewSchedule() -> {
                context?.also { context ->
                    val resMessage = when {
                        isBackToHomeScreen -> R.string.app_is_updating_new_schedule_can_not_back_to_get_started_screen
                        else -> R.string.app_is_updating_new_schedule_can_not_move_to_new_screen
                    }
                    Toast.makeText(context, resMessage, Toast.LENGTH_LONG)
                            .show()
                    Log.d("LOG", this.javaClass.simpleName + " handleMoveToNewScreenButUpdatingNewSchedule() | can not back to home screen")
                }
            }

            else -> caseNotUpdating.invoke()
        }
    }

    override fun hideGroupViewsComingUpNext() {
        groupViewsComingUpNext?.also {
            it.visibility = View.GONE
        }
    }

    override fun onLoadingVideoDelay(playedPosition: Long) {
        view?.postDelayed({
            mPresenter?.onHaveNowPlayingVideo(0L)
        }, playedPosition)
    }

    override fun onNoClassVideosForNow(message: String, @ColorRes msgColor: Int, isClickedFromBtnBottom: Boolean) {
        Log.d("LOG", this.javaClass.simpleName + " onNoClassVideosForNow()")
        btnLogoBottom.isEnabled = true

        when (mPresenter?.getPlayMode()) {
            PlayMode.SCHEDULE -> {
                handleMoveToNewScreenButUpdatingNewSchedule(isBackToHomeScreen = true, caseNotUpdating = {
                    Log.d("LOG", this.javaClass.simpleName + " onNoClassVideosForNow() | SCHEDULE | isClickedFromBtnBottom: $isClickedFromBtnBottom")
                    NowPlayingVideoSetupHelper
                            .openHomeFragmentWithNotLoadScheduleAndShowPopup(fm = activity?.supportFragmentManager, message = getString(R.string.no_class_now))
                    activity?.let {
                        if (it is MainActivity) {
                            it.getApiConfigData()
                        }
                    }
                })

            }

            PlayMode.ON_DEMAND -> {
                videoPlayer?.context?.let {
                    dialog?.dismiss()
                    context?.also { context ->
                        dialog = DialogUtil.createDialogTwoButtons(context, getString(R.string.confirm_stop_video_and_navigate_to_screen_get_started), R.string.cancel,
                                object : DialogInterface.OnClickListener {
                                    override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                                        dialogInterface?.dismiss()
                                        hideLoadingProgress()
                                    }

                                }, R.string.btn_ok, object : DialogInterface.OnClickListener {
                            override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                                dialogInterface?.dismiss()
                                backToHomeScreenWithNotLoadSchedule()

                            }

                        }).apply { show() }
                    }
                    activity?.let { ac ->
                        if (ac is MainActivity) {
                            ac.getApiConfigData()
                        }
                    }
                }
            }
        }

    }

//    override fun noScheduleForNow(isLoadSchedule: Boolean) {
//        Log.d("LOG", this.javaClass.simpleName + " showDialogAskWantToBackToHome()")
//        dialog?.dismiss()
//        context?.also { context ->
//            dialog = DialogUtil.createDialogTwoButtons(context, getString(R.string.confirm_stop_video_and_navigate_to_screen_get_started), R.string.cancel,
//                    object : DialogInterface.OnClickListener {
//                        override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
//                            dialogInterface?.dismiss()
//                            hideLoadingProgress()
//                        }
//
//                    }, R.string.btn_ok, object : DialogInterface.OnClickListener {
//                override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
//                    dialogInterface?.dismiss()
//                    when {
//                        isLoadSchedule -> NowPlayingVideoSetupHelper.openHomeFragmentWithLoadSchedule(fm = activity?.supportFragmentManager)
//                        else -> backToHomeScreenWithNotLoadSchedule()
//                    }
//
//                }
//
//            }).apply { show() }
//        }
//
//    }

    override fun onHaveClassVideos(scheduleVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {
        btnLogoBottom.isEnabled = true
//        if(scheduledVideos.size == 0) onNoClassVideos("", R.color.yellow, isClickedFromBtnBottom)
        Log.d("LOG", this.javaClass.simpleName + " onHaveClassVideos() | videos number: ${scheduleVideos.size} | play mode: ${mPresenter?.getPlayMode()}")
        hideLoadingProgress()
        videoPlayer?.context?.let {
            when (mPresenter?.getPlayMode()) {
                PlayMode.SCHEDULE -> switchToCurrentClass(scheduleVideos)

                // show dialog ask user want to play class video
                PlayMode.ON_DEMAND -> {
                    Log.d("LOG", this.javaClass.simpleName + " onHaveClassVideos() | isClickedFromBtnBottom: ${isClickedFromBtnBottom}")
                    if (isClickedFromBtnBottom) {
                        val message = it.getString(R.string.confirm_stop_video_and_open_current_class)
                        val okButtonListener = DialogInterface.OnClickListener { _, _ -> switchToCurrentClass(scheduleVideos) }
                        val cancelButtonListener = DialogInterface.OnClickListener { _, _ ->
                            mPresenter?.resumeOrReplay()
                        }

                        DialogUtil.createDialogTwoButtons(context = it, message = message, titleLeftButton = R.string.btn_no,
                                leftButtonClickListener = cancelButtonListener, titleRightButton = R.string.btn_yes, rightButtonClickListener = okButtonListener).show()
                    } else {
                        switchToCurrentClass(scheduleVideos)
                    }
                }
            }
        }
    }

    override fun onTimePlaySchedule() {
        // do nothing
    }

    private fun switchToCurrentClass(scheduleVideos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " switchToCurrentClass() | videos number: ${scheduleVideos.size}")
        activity?.also { activity ->
            if (activity is MainActivity && activity.isPresentationAvailable()) {
                Log.d("LOG", this.javaClass.simpleName + " switchToCurrentClass() | case presentation")
                MessageUtils.showSnackBar(snackView = btnLogoBottom, message = getString(R.string.now_playing_class),
                        colorRes = R.color.white)
                activity.playVideo(PlayMode.SCHEDULE, scheduleVideos)
                backToHomeScreenWithNotLoadSchedule()
            } else {
                rvComingUpNext?.adapter?.also {
                    if (it is NowPlayingComingUpNextAdapter)
                        it.release()
                }

                context?.also {
                    mPresenter?.switchToPlayScheduleVideos(scheduleVideos = scheduleVideos)
                    setupVideoPlayerOnMode()
                }
            }
        }
    }

    override fun setupViewFloatMenu(configData: MMConfigData) {
        when (configData.hasHelpMeChoose) {
            0 -> {
                menuItemHelpMeChoose.visibility = View.GONE
            }

            1 -> {
                menuItemHelpMeChoose.visibility = View.VISIBLE

                val buttonText: String = configData.helpmeChooseButtonText
                if (buttonText.isNotEmpty())
                    menuItemHelpMeChoose.text = buttonText
            }
        }
    }

    override fun onVideoEnded() {
        hideLoadingProgress()
        videoPlayer?.player = null
        tvTitleVideo?.visibility = View.GONE
        groupMainCollections?.visibility = View.GONE
    }

    /**
     * @IRouterChangedListener
     */

    override fun onMediaRouterConnected() {
        Log.d("LOG", this.javaClass.simpleName + " onMediaRouterConnected() ")
//        when{
//            mPresenter?.getPlayMode() == PlayMode.ON_DEMAND -> {
//
//            }
//        }
        val videos: ArrayList<MMVideo>? = mPresenter?.getAllVideos()

        val lastPosition: Long? = mPresenter?.getPlayerManager()?.getCurrentPosition()
        mPresenter?.getPlayerManager()?.getCurrentPosition()?.let {
            if (it > 0) {
                PresentationDataHelper.save(context = activity, mode = mPresenter?.getPlayMode(),
                        videos = videos, currentPosition = lastPosition,
                        timeCountDown = mCountDownNumber)
            }
        }

        view?.also {
            MessageUtils.showSnackBar(snackView = it, message = getString(R.string.detect_connecting_to_tv),
                    colorRes = R.color.white, isLongTime = true, btnRes = R.string.btn_ok)
        }
        openNoClassSearchScreen(null)
    }

    private fun registerMediaRouterConnected() {
        activity?.also {
            if (it is MainActivity) it.addRouterChangedListener(listener = this)
        }
    }

    private fun unRegisterMediaRouterConnected() {
        activity?.also {
            if (it is MainActivity) it.removeRouterChangedListener(this)
        }
    }

    override fun onCookieExpired() {
        activity?.also {
            if (it is MainActivity) {
                it.onCookieExpired()
            }
        }
    }


    override fun showCountDownPlayTime(millisUntilFinished: Long) {
        tvCountdownTimerUntilPlay?.also { tv ->
            when (millisUntilFinished >= 0L) {
                true -> {
                    tv.visibility = View.VISIBLE
                    tv.text = (millisUntilFinished / 1000).toString()
                }

                false -> {
                    tv.visibility = View.GONE
                }
            }
        }
    }

    /**
     * implemented @Player.EventListener
     */
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (progressLoadingVideo == null || btnPlayVideo == null || btnPauseVideo == null) return

        when (playbackState) {
            Player.STATE_BUFFERING -> {

                PlayVideoDisplayHelper.displayViewsOnBuffering(progressLoadingVideo, btnPlayVideo, btnPauseVideo)
            }

            Player.STATE_READY -> {
                if (!videoPlayer.isControllerVisible)
                    hideVideoTitleAndCollections()

                videoPlayer.player?.let { _ ->
                    val isControllerVisible = videoPlayer.isControllerVisible

                    PlayVideoDisplayHelper.displayOnReady(isControllerVisible, playWhenReady,
                            progressLoadingVideo, btnPlayVideo, btnPauseVideo)
                }
            }

            Player.STATE_ENDED -> {
                PlayVideoDisplayHelper.displayOnEnded(progressLoadingVideo, btnPlayVideo, btnPauseVideo)
            }

            Player.STATE_IDLE -> {
                hideLoadingProgress()
                PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)

                when (mPresenter?.getPlayerState()) {
                    PlayerState.COUNTDOWN -> {
                        btnPlayVideo.visibility = View.GONE
                    }
                    else -> {
                        btnPlayVideo.visibility = View.VISIBLE
                    }
                }
            }
        }
    }


    /**
     * implemented @NetworkReceiver.IStateListener
     */
    override fun onChangedState(isConnected: Boolean) {
        if (isConnected) {
            mPresenter?.onReconnectNetwork()
        }
    }

    private fun registerNetworkConnecting() {
        NetworkReceiver.getInstance().addListener(this)
    }

    private fun unregisterNetworkConnecting() {
        NetworkReceiver.getInstance().removeListener(this)
    }

    /**
     * LOAD BRANDS FROM BACKEND
     */
    override fun onLoadingBrands() {
        showLoadingBrand()
    }

    override fun onEndLoadingBrands() {
        hideLoadingBrand()
    }

    private fun showLoadingBrand() {
        dimBgScreen?.visibility = View.VISIBLE
        boxLoading?.visibility = View.VISIBLE
        progressLoadBrand?.visibility = View.VISIBLE
        tvLoading?.visibility = View.VISIBLE
    }

    private fun hideLoadingBrand() {
        dimBgScreen?.visibility = View.GONE
        boxLoading?.visibility = View.GONE
        progressLoadBrand?.visibility = View.GONE
        tvLoading?.visibility = View.GONE
    }

    override fun onGetBrands(brands: ArrayList<MMBrand>, searchBrandFlowTag: String) {
        val newFragment = ControlFragment.getInstance(brands, searchBrandFlowTag)

        openControlScreen(newFragment)
    }

    override fun onGetOnlyOneBrand(brand: MMBrand, nextScreenTag: String) {
        val newFragment: ControlFragment = ControlFragment.getInstance(brand, nextScreenTag)

        openControlScreen(newFragment)
    }

    private fun openControlScreen(newFragment: Fragment) {
        handleMoveToNewScreenButUpdatingNewSchedule(isBackToHomeScreen = false, caseNotUpdating = {
            val fm: FragmentManager? = activity?.supportFragmentManager

            FragmentUtil.replaceFragment(fm, newFragment, ControlFragment.TAG, R.id.frameLayoutHome, isAddToBackStack = true)
        })
    }

    override fun onLoadBrandsFailed(message: String) {
        MessageUtils.showToast(context, message, R.color.red, isLongTime = true)?.show()
    }

    override fun openTimeTableScreen() {
        handleMoveToNewScreenButUpdatingNewSchedule(isBackToHomeScreen = false, caseNotUpdating = {
            activity?.supportFragmentManager?.also { fm ->
                context?.also {
                    PreferenceHelper.getInstance(it).putBoolean(ConstantPreference.IS_SHOW_BUTTON_PREVIOUS, true)
                }

                val containerTag: String = ControlFragment.TAG

                val fragment: ControlFragment = ControlFragment.getInstance(TimeTableFragment.TAG)

                FragmentUtil.replaceFragment(fm = fm, newFragment = fragment, newFragmentTag = containerTag,
                        frameId = R.id.frameLayoutHome, isAddToBackStack = true)
            }
        })

    }

    /**
     * -------------
     */

    companion object {
        const val TAG = "NowPlayingFragment"

        const val KEY_DATA_PLAYING_VIDEO = "KEY DATA PLAYING VIDEO"
        const val KEY_DATA_NOW_PLAYING = "KEY DATA NOW PLAYING"

        fun getInstanceForSearchedVideos(data: ArrayList<MMVideo>): NowPlayingFragment =
                NowPlayingFragment().apply {
                    VideoDBUtil.createOrUpdateVideos(data, TAG)

                    arguments = Bundle().apply {
                        putBoolean(KEY_DATA_PLAYING_VIDEO, true)
                        putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
                    }
                }

        fun getBundleBySearchedVideos(data: ArrayList<MMVideo>): Bundle {
            VideoDBUtil.createOrUpdateVideos(data, TAG)

            return Bundle().apply {
                putBoolean(KEY_DATA_PLAYING_VIDEO, true)
                putString(Constant.BUNDLE_SOURCE_SCHEDULE, SOURCE_LOAD_SCHEDULE.LOCAL.name)
            }
        }

        fun getInstancePlaySchedule(): NowPlayingFragment = NowPlayingFragment().apply {
            arguments = Bundle().also {
                it.putBoolean(Constant.BUNDLE_SCHEDULE, true)
            }
        }

        fun updateAlreadyInstanceWithSchedule(fragment: NowPlayingFragment): Fragment = fragment.apply {
            arguments = Bundle().also {
                it.putBoolean(Constant.BUNDLE_SCHEDULE, true)
            }
        }
    }

}