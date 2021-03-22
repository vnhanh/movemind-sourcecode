package player.wellnesssolutions.com.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.PixelFormat
import android.os.Binder
import android.os.Build
import android.util.TypedValue
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.mediarouter.media.MediaRouter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.android.synthetic.main.custom_controller_player_screen_now_playing.view.*
import kotlinx.android.synthetic.main.exo_simple_player_view.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController
import player.wellnesssolutions.com.base.common.play_video.PlayVideoDisplayHelper
import player.wellnesssolutions.com.base.common.play_video.ShowMode
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.customize_views.MMBackGroundView
import player.wellnesssolutions.com.common.customize_views.MMProgressBar
import player.wellnesssolutions.com.common.customize_views.MMTextView
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.custom_exoplayer.PlayerState
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver
import player.wellnesssolutions.com.ui.activity_main.PresentationDataHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingPresenter
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.GCUDisplayHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoInfoDisplayHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_presentation.presentation.MMPreInterface

class MMPresentationBinder(var listener: BinderListener) : Binder(), MMPreInterface.View,
        INowPlayingConstruct.View, MonitorVideoAsyncTask.Listener, CastingBroadcastReceiver.UIListener {
    interface BinderListener {
        fun onCreateNotificationRemote()
        fun onDestroyNotification()
        fun onGetService(): MMPresentationService
    }

    companion object {
        private const val TAG = "PresentationBinder"
    }

    var mDisplay: Display? = null
    private var isShowing: Boolean = false

    private var mService: MMPresentationService = listener.onGetService()
    private var mView: ViewGroup? = null
    private var mContext: Context? = null
    private var mRouter: MediaRouter.RouteInfo? = null

    private var mPresenter: INowPlayingConstruct.Presenter? = null

    private var mExtraPlayingCollectionViews: ArrayList<TextView>? = ArrayList()
    private var mExtraComingCollectionViews: ArrayList<TextView>? = ArrayList()

    private lateinit var imageBgHomeScreen: MMBackGroundView
    private lateinit var frameExoVolume: ViewGroup
    private lateinit var videoTitle: TextView
    private lateinit var groupCollections: LinearLayout
    private lateinit var btnPauseVideo: ImageView
    private lateinit var btnPlayVideo: ImageView
    private lateinit var groupViewsComingUpNext: ConstraintLayout
    private lateinit var btnComingUpNext: TextView
    private lateinit var rvComingUpNext: RecyclerView
    private lateinit var btnMenuFloat: View
    private lateinit var videoPlayer: PlayerView
    private lateinit var progressLoadingVideo: MMProgressBar
    private lateinit var tvCountdownTimerUntilPlay: MMTextView

    private var mNowVideo: MMVideo? = null
    private var mNowVideoLength = 0L
    private var mComingUpVideos: ArrayList<MMVideo>? = null
//    private var mIsStop = true

    private var mCallback: Callback? = null

    private var mMonitorVideoAsyncTask: MonitorVideoAsyncTask? = null

    private var mIsLoadingNewVideo = false

    /**
     * This function is highest priority.
     * Must be called before onCreate.
     *
     * */
    fun setRouter(router: MediaRouter.RouteInfo) {
        mRouter = router
    }

    fun getService(): MMPresentationService {
        return mService
    }

    /**
     * This function is highest priority.
     * Must be called before onCreate.
     *
     * */
    fun setContentView(view: ViewGroup) {
        mView = view
        mView?.also {
            imageBgHomeScreen = it.findViewById(R.id.imageBgHomeScreen)
            frameExoVolume = it.findViewById(R.id.frameExoVoume)
            videoTitle = it.findViewById(R.id.tvTitleVideo)
            groupCollections = it.findViewById(R.id.groupMainCollections)
            btnPauseVideo = it.findViewById(R.id.btnPauseVideo)
            btnPlayVideo = it.findViewById(R.id.btnPlayVideo)
            groupViewsComingUpNext = it.findViewById(R.id.groupViewsComingUpNext)
            btnComingUpNext = it.findViewById(R.id.btnComingUpNext)
            rvComingUpNext = it.findViewById(R.id.rvComingUpNext)
            btnMenuFloat = it.findViewById(R.id.btnMenuFloat)
            videoPlayer = it.findViewById(R.id.videoPlayer)
            progressLoadingVideo = it.findViewById(R.id.progressLoadingVideo)
            tvCountdownTimerUntilPlay = it.findViewById(R.id.tvCountdownTimerUntilPlay)
        }
    }

    fun onCreate() {
        val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        }

        val params = WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                type,
                0,
                //              WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                //                      | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.CENTER
        params.title = "Load Average"

        mDisplay = mRouter?.presentationDisplay ?: return

        mContext = mService.applicationContext.createDisplayContext(mDisplay!!)
        val wm: WindowManager = mContext!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.addView(mView, params)

        listener.onCreateNotificationRemote()

        videoPlayer.exo_subtitles.setFixedTextSize(TypedValue.COMPLEX_UNIT_DIP, NowPlayingVideoSetupHelper.SUBTITLES_TEXTSIZE * 1f)

        registerUICastingBroadcast()

        isShowing = true
    }

    private fun registerUICastingBroadcast() {
        val castingFilter = IntentFilter(CastingBroadcastReceiver.ACTION_UI)
        CastingBroadcastReceiver.getInstance().addListener(listener = this)
        mService.registerReceiver(CastingBroadcastReceiver.getInstance(), castingFilter)
    }

    fun onDestroy() {
        mMonitorVideoAsyncTask?.stopTask()
        unregisterUICastingBroadcast()
        mContext?.also { context ->
            val lastPosition: Long = mPresenter?.getCurrentPlayedPosition() ?: 0L
            SharedPreferencesCustomized.getInstance(context).putLong(SPrefConstant.LAST_PLAYED_VIDEO_POSITION, lastPosition)
        }

        if (mView != null) {
            (mContext?.getSystemService(Service.WINDOW_SERVICE) as? WindowManager)?.removeView(mView)
            mView = null
            mContext = null
            isShowing = false
        }
        listener.onDestroyNotification()
        releasePresenters()
    }

    private fun unregisterUICastingBroadcast() {
        if (CastingBroadcastReceiver.getInstance().isRegistered(this)) {
            try {
                mService.unregisterReceiver(CastingBroadcastReceiver.getInstance())
                CastingBroadcastReceiver.getInstance().removeListener(listener = this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun pauseOrPlay() {
        when (isShowClosedCaptionView()) {
            // is showing list of closed caption language views
            true -> {
                mPresenter?.selectLanguageCCOption()
                videoPlayer.controllerShowTimeoutMs = 3000
                mService.changeToNormalMode()
            }

            false -> {
                when (mPresenter?.getPlayMode()) {
                    PlayMode.SCHEDULE -> {
                        MessageUtils.showSnackBar(videoPlayer, R.string.class_video_cant_paused, R.color.yellow, isOnPresentation = true
                        )
                        videoPlayer.showController()
                    }

                    PlayMode.ON_DEMAND -> {
                        when (videoPlayer.player?.playbackState) {
                            Player.STATE_ENDED -> {
                                mPresenter?.replayVideo()
                            }
                        }
                        val isPlaying = mPresenter?.isPlayingVideo() ?: false

                        if (isPlaying)
                            pause()
                        else
                            resume()
                    }

                    else -> return
                }
            }
        }
    }

    fun pause() {
        btnPauseVideo.performClick()
    }

    fun resume() {
        btnPlayVideo.performClick()
    }

    fun nextVideo() {
        when (isShowClosedCaptionView()) {
            // switch language cc option
            true -> {
                mPresenter?.slideNextLanguageCCOption()
            }

            false -> {
                when (mPresenter?.getPlayMode()) {
                    PlayMode.SCHEDULE -> {
                        MessageUtils.showSnackBar(videoPlayer, R.string.class_video_cant_skip, R.color.yellow, isOnPresentation = true)
                    }

                    PlayMode.ON_DEMAND -> {
                        mIsLoadingNewVideo = true
                        mPresenter?.playNextVideo()?.also { isLastVideo ->
                            if (isLastVideo) {
                                mIsLoadingNewVideo = false
                                MessageUtils.showSnackBar(videoPlayer, R.string.final_video, R.color.white, isOnPresentation = true)
                            }
                        }
                    }
                }
            }
        }
    }

    fun showNextVideo() {
        mPresenter?.hideClosedCaptionView()
        when (mPresenter?.getAllVideos()?.size ?: 0 > 0) {
            true -> btnComingUpNext.performClick()
            false -> MessageUtils.showToast(mContext, R.string.cant_show_coming_up_videos_because_no_videos, R.color.white)?.show()
        }
    }

    fun showClosedCaption() {

        groupViewsComingUpNext.visibility = View.GONE

        when (mPresenter?.isShowClosedCaptionView()) {
            true -> {
                videoPlayer.controllerShowTimeoutMs = 3000
                mPresenter?.hideClosedCaptionView()
                videoPlayer.hideController()
            }
            false -> {
                videoPlayer.controllerShowTimeoutMs = -1
                videoPlayer.showController()
                mPresenter?.showClosedCaptionView()
            }
        }
    }

    fun setupPlayVideo(mode: PlayMode, videos: ArrayList<MMVideo>, lastPosition: Long) {
        releasePresenters()
        mPresenter?.onDestroy()

        mPresenter = NowPlayingPresenter(context = mContext!!, playMode = mode).also {
            it.setPlayedPosition(lastPosition)
            it.setSubtitleController(ClosedCaptionController(videoPlayer.playerControllerView, videoPlayer.exo_subtitles, ShowMode.TV))
        }

        setupUI()
        readPlayingVideoData(videos)
    }

    private fun releasePresenters() {
        mPresenter?.onDetach()
        mPresenter?.onDestroy()
    }

    private fun readPlayingVideoData(videos: ArrayList<MMVideo>?) {
        videos?.let {
            mPresenter?.setVideos(it)
            mPresenter?.onAttach(this)
        }
    }

    private fun setupUI() {
        setupButtonPlayPauseVideo()

        setupVideoPlayerController()
        setupVideoPlayerOnMode()
        btnMenuFloat.visibility = View.GONE
    }

    private fun setupVideoPlayerOnMode() {
        if (btnPlayVideo.visibility != View.GONE)
            btnPlayVideo.visibility = View.GONE

        if (btnPauseVideo.visibility != View.GONE)
            btnPauseVideo.visibility = View.GONE

        mView?.also { root ->
            NowPlayingVideoSetupHelper.setupViewsForPlayer(root, mPresenter, isPresentation = true)
            NowPlayingVideoSetupHelper.setupComingUpNext(view = root, menuSetupHelper = null)

            when (mPresenter?.getPlayMode()) {
                PlayMode.SCHEDULE -> {
                    videoPlayer.exo_play?.setOnClickListener {}
                    videoPlayer.exo_pause?.setOnClickListener {}
                    videoPlayer.exo_progress?.wasEnable = false
                }

                PlayMode.ON_DEMAND -> {
                    videoPlayer.exo_play?.setOnClickListener {
                        if (mMonitorVideoAsyncTask?.isStop() == true) {
                            postDelayCheckVideoPosition()
                        }

                        mPresenter?.resumeOrReplay()
                    }

                    videoPlayer.exo_pause?.setOnClickListener {
                        mPresenter?.pauseVideo()
                        mMonitorVideoAsyncTask?.stopTask()
                    }

                    videoPlayer.exo_progress?.wasEnable = true
                }
            }
        }
    }

    private fun setupVideoPlayerController() {
        videoPlayer.setControllerVisibilityListener {
            // if not loading video....
            if (it == View.VISIBLE) {
                videoTitle.visibility = View.VISIBLE
                groupCollections.visibility = View.VISIBLE

                videoPlayer.player?.let { players ->
                    when (players.playbackState) {
                        Player.STATE_BUFFERING -> {
                            showLoadingProgress()
                            PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)
                        }

                        Player.STATE_IDLE -> {
                            hideLoadingProgress()
                            btnPauseVideo.visibility = View.GONE

                            mPresenter?.getPlayMode()?.let {
                                if (it == PlayMode.SCHEDULE) {
                                    groupCollections.visibility = View.INVISIBLE
                                    videoTitle.visibility = View.INVISIBLE
                                    videoPlayer.visibility = View.INVISIBLE

                                }
                            }
                            mPresenter?.getPlayMode()?.let {
                                if (it == PlayMode.ON_DEMAND) {
                                    mPresenter?.getIsCountDown()?.let {
                                        if (!it) {
                                            groupCollections.visibility = View.INVISIBLE
                                            videoTitle.visibility = View.INVISIBLE
                                            videoPlayer.visibility = View.INVISIBLE
                                        }
                                    }

                                }
                            }

                            when (mPresenter?.getPlayerState()) {
                                PlayerState.COUNTDOWN -> {
                                    btnPlayVideo.visibility = View.GONE
                                }
                                PlayerState.ENDED -> {
                                    groupCollections.visibility = View.INVISIBLE
                                    videoTitle.visibility = View.INVISIBLE
                                    videoPlayer.visibility = View.INVISIBLE
                                }
                                else -> {
                                    btnPlayVideo.visibility = View.INVISIBLE
                                    imageBgHomeScreen.visibility = View.VISIBLE
                                }
                            }
                        }
                        Player.STATE_ENDED -> {
                            hideLoadingProgress()
                            groupCollections.visibility = View.INVISIBLE
                            videoTitle.visibility = View.INVISIBLE
                            videoPlayer.visibility = View.INVISIBLE
                            btnPlayVideo.visibility = View.INVISIBLE
                            btnPauseVideo.visibility = View.GONE
                            imageBgHomeScreen.visibility = View.VISIBLE
                        }

                        else -> {
                            hideLoadingProgress()
                            PlayVideoDisplayHelper.displayControllerPlayViews(playWhenReady = players.playWhenReady,
                                    btnPlayVideo = btnPlayVideo, btnPauseVideo = btnPauseVideo)
                        }
                    }

                }
            }
            // if the controller is hide or loading video ....
            // hide all buttons
            else {
                videoTitle.visibility = View.INVISIBLE
                groupCollections.visibility = View.INVISIBLE

                frameExoVolume.also { volumeFrame ->
                    volumeFrame.visibility = View.GONE
                }

                PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)
//                videoPlayer.playerControllerView.findViewById<View>(R.id.closedCaptionController)?.visibility = View.GONE
            }
        }
    }

    private fun setupButtonPlayPauseVideo() {
        ViewUtil.setupButton(btnPlayVideo, this::onClickedButtonPlayVideo)
        ViewUtil.setupButton(btnPauseVideo, this::onClickedButtonPauseVideo)
    }

    private fun onClickedButtonPlayVideo() {
        if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND) {
            videoPlayer.exo_play?.performClick()
        }
    }

    private fun onClickedButtonPauseVideo() {
        if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND) {
            videoPlayer.exo_pause?.performClick()
        }
    }

    override fun getFragment(): Fragment = Fragment()

    override fun getViewContext(): Context? = mContext


    override fun showLoadingProgress() {
        progressLoadingVideo.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        progressLoadingVideo.visibility = View.GONE
    }

    override fun onLoadingVideoDelay(playedPosition: Long) {
//        mView?.postDelayed({
//            //            if (mPresenter?.isPlayingVideo() == true) return@postDelayed
//            mPresenter?.onHaveNowPlayingVideo(0L)
//        }, playedPosition)

    }

    // the stage that ending old video and play new video
    override fun onIntermediateStage() {
        sendTranslatedVideoStateToUI()
        mMonitorVideoAsyncTask?.stopTask()
        showCountDown()
    }

    private fun showCountDown() {
        hideLoadingProgress()
        imageBgHomeScreen.visibility = View.VISIBLE
        videoPlayer.hideController()
        videoPlayer.visibility = View.INVISIBLE
        videoTitle.visibility = View.VISIBLE
        groupCollections.visibility = View.GONE
    }

    private fun hideCountDown() {
        tvCountdownTimerUntilPlay.visibility = View.GONE
        imageBgHomeScreen.visibility = View.INVISIBLE
        videoPlayer.visibility = View.VISIBLE
    }

    override fun reloadScheduledVideo() {
        postDelayCheckVideoPosition()
    }

    override fun onStartInitializePlayer() {
        hideCountDown()
        PlayVideoDisplayHelper.hideAllButtons(btnPlayVideo, btnPauseVideo)
        mIsLoadingNewVideo = true
        showLoadingProgress()
    }

    override fun hideCountDownTimer() {
        imageBgHomeScreen.visibility = View.VISIBLE
        groupCollections.visibility = View.INVISIBLE
        videoTitle.visibility = View.INVISIBLE
        videoPlayer.visibility = View.INVISIBLE
        tvCountdownTimerUntilPlay.visibility = View.INVISIBLE
    }

    private fun showTitleAndCollections() {
        videoTitle.visibility = View.VISIBLE
        groupCollections.visibility = View.VISIBLE
    }

    private fun hideTitleAndCollections() {
        videoTitle.visibility = View.GONE
        groupCollections.visibility = View.GONE
    }

    override fun onPlayerInitialized(players: SimpleExoPlayer, isReload: Boolean) {
        // reset controller state to normal

        videoPlayer.controllerShowTimeoutMs = 3000
        mView?.also { rootView ->
            mService.changeToNormalMode()
            NowPlayingVideoInfoDisplayHelper.setupVideo(rootView, players)
        }

        postDelayCheckVideoPosition()
    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        when (playbackState) {
            Player.STATE_BUFFERING -> {
                PlayVideoDisplayHelper.displayViewsOnBuffering(progress = progressLoadingVideo,
                        btnPlay = btnPlayVideo, btnPause = btnPauseVideo)
                sendLoadingVideoStateToUI()
            }

            Player.STATE_READY -> {
                mIsLoadingNewVideo = false

                videoPlayer.player?.let { _ ->
                    PlayVideoDisplayHelper.displayOnReady(videoPlayer.isControllerVisible,
                            playWhenReady, progressLoadingVideo, btnPlayVideo, btnPauseVideo)
                }

                if (!videoPlayer.isControllerVisible) {
                    hideTitleAndCollections()
                }

                sendReadyVideoStateToUI(playWhenReady)
            }

            Player.STATE_IDLE -> {
                showCountDown()
                //PlayVideoDisplayHelper.displayOnEnded(progressLoadingVideo, btnPlayVideo, btnPauseVideo)
            }

            Player.STATE_ENDED -> {
                //LogUtil.log(javaClass.simpleName + " | ended")
                //3
                showCountDown()
                //PlayVideoDisplayHelper.displayOnEnded(progressLoadingVideo, btnPlayVideo, btnPauseVideo)
                onVideoEnded()
                sendEndedVideoStateToUI()

            }
        }
    }

    private fun sendLoadingVideoStateToUI() {
        if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND) {
            val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
            intent.putExtra(CastingBroadcastReceiver.EXTRA_LOADING_VIDEO_STATE_ON_TV, true)
            mService.sendBroadcast(intent)
        }
    }

    private fun sendReadyVideoStateToUI(isPlaying: Boolean) {
        val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
        val isShowPlayPauseButton: Boolean = mPresenter?.getPlayMode() == PlayMode.ON_DEMAND
        intent.putExtra(CastingBroadcastReceiver.EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON, isShowPlayPauseButton)

        intent.putExtra(CastingBroadcastReceiver.EXTRA_READY_VIDEO_STATE_ON_TV, isPlaying)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_UPDATE_PROGRESS, videoPlayer.player?.currentPosition
                ?: 0L)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_DURATION_VIDEO_ON_TV, videoPlayer.player?.duration
                ?: 0L)
        mService.sendBroadcast(intent)
    }

    override fun hideControlWhenNextVideoSchedule() {
        super.hideControlWhenNextVideoSchedule()
        sendEndedVideoStateToUI()
    }

    private fun sendEndedVideoStateToUI() {
        when (mPresenter?.getPlayMode()) {
            PlayMode.ON_DEMAND -> {
                val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
                intent.putExtra(CastingBroadcastReceiver.EXTRA_ENDED_VIDEO_STATE_ON_TV, true)
                mService.sendBroadcast(intent)
            }
            PlayMode.SCHEDULE -> {
                val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
                intent.putExtra(CastingBroadcastReceiver.EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE, true)
                mService.sendBroadcast(intent)
            }
        }


    }

    private fun sendTranslatedVideoStateToUI() {
        val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV, true)
        mService.sendBroadcast(intent)
    }

    override fun showUIForPlayingVideo(videoData: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
        this.mNowVideo = videoData
        this.mNowVideoLength = ((videoData.videoLength ?: 0f) * 1000).toLong()
        this.mComingUpVideos = comingUpVideos

        mCallback?.onUpdateVideos(videoData, comingUpVideos)

        mView?.also { parentView ->
            showTitleAndCollections()
            mExtraPlayingCollectionViews = NowPlayingVideoInfoDisplayHelper.displayPlayingVideo(parentView as ConstraintLayout,
                    groupCollections, videoData, mExtraPlayingCollectionViews)

            // show video nowPlaying data in group views coming up next
            mExtraComingCollectionViews = GCUDisplayHelper.showPlayingVideoInfo(groupViewsComingUpNext, videoData,
                    mExtraComingCollectionViews, isPresentation = true)
            GCUDisplayHelper.showVideosComingUpNext(comingUpVideos, rvComingUpNext, mPresenter!!, isPresentation = true)
        }
    }

    private fun onNoVideoPlay() {
        videoPlayer.player = null
        progressLoadingVideo.visibility = View.GONE
        btnPlayVideo.visibility = View.INVISIBLE
        btnPauseVideo.visibility = View.INVISIBLE
        videoTitle.visibility = View.INVISIBLE
        groupCollections.visibility = View.INVISIBLE
        imageBgHomeScreen.visibility = View.VISIBLE
    }

    override fun onCookieExpired() {
        onNoVideoPlay()

        val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_COOKIE_EXPIRED, true)
        mService.sendBroadcast(intent)
    }

    override fun isPlayingSchedule(): Boolean = (mPresenter?.getPlayMode() == PlayMode.SCHEDULE && mPresenter?.isPlayingVideo() ?: false)

    override fun isPlayingSearchVideos(): Boolean = (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND && mPresenter?.isPlayingVideo() ?: false)

    override fun isPlaying(): Boolean = mPresenter?.isPlayingVideo() ?: false

    override fun hideGroupViewsComingUpNext() {
        groupViewsComingUpNext.also {
            it.visibility = View.GONE
        }
    }

    fun getPlayMode(): PlayMode? = mPresenter?.getPlayMode()

    fun getVideos(): ArrayList<MMVideo> = mPresenter?.getAllVideos() ?: ArrayList()

    fun getCurrentVideoPosition(): Long = mPresenter?.getCurrentPlayedPosition() ?: 0L

    private fun isShowClosedCaptionView(): Boolean = videoPlayer.isControllerVisible && mPresenter?.isShowClosedCaptionView() == true

    private fun postDelayCheckVideoPosition() {
        mMonitorVideoAsyncTask?.stopTask()
        mMonitorVideoAsyncTask = MonitorVideoAsyncTask(videoPlayer, mPresenter, this).also {
            it.startTask()
        }
    }

    override fun onVideoEnded() {
        mPresenter?.getAllVideos()?.also { videos ->
            if (videos.size == 1) {
                mService.changeToNormalMode()
                mPresenter?.hideClosedCaptionView()
            }
        }
    }

    override fun showCountDownPlayTime(millisUntilFinished: Long) {
        tvCountdownTimerUntilPlay.also { tv ->
            when (millisUntilFinished >= 0L) {
                true -> {
                    hideLoadingProgress()
                    tv.visibility = View.VISIBLE
                    tv.text = (millisUntilFinished / 1000).toString()
                }

                false -> {
                    tv.visibility = View.GONE
                }
            }
        }
    }

    fun onAppViewVisible() {
        mIsRunnableStop = false
    }

    fun onAppViewInVisible() {
        mIsRunnableStop = true
        mView?.postDelayed(mRunnable, 1000L)
    }

    private var mIsRunnableStop = false

    private var mRunnable = object : Runnable {
        @SuppressLint("RestrictedApi")
        override fun run() {
            if (mRouter?.presentationDisplayId == -1 || mRouter?.presentationDisplay?.isValid == false) {
                // stop service and pause video
                mService.stopSelf()
                mPresenter?.pauseVideo()

                mPresenter?.getCurrentPlayedPosition()?.let {
                    if (it > 0) {
                        PresentationDataHelper.save(context = mContext,
                                mode = mPresenter?.getPlayMode(),
                                videos = mPresenter?.getAllVideos(),
                                currentPosition = mPresenter?.getCurrentPlayedPosition(),
                                timeCountDown = null)
                    }
                }
                // save the current data (videos, currentPlayedPosition, playedMode)

            } else if (mIsRunnableStop) {
                mView?.postDelayed(this, 1000L)
            }
        }

    }

    fun addCallback(callback: Callback) {
        this.mCallback = callback
    }

    fun onPlayPresentationVideoAt(position: Int) {
        mPresenter?.onClickedComingUpNextVideo(position)
    }

    fun clearAllVideos() {
        showCountDown()
        setupPlayVideo(PlayMode.ON_DEMAND, ArrayList(), 0L)
        mCallback?.onClearVideos()
    }

    override fun openNoClassSearchScreen(isClickedButtonHome: Boolean?) {
        if (isClickedButtonHome != null) {
            if (isClickedButtonHome) {
                videoPlayer.player = null
                videoTitle.text = ""
                groupCollections.visibility = View.GONE
            }
        } else {
            videoPlayer.player = null
            videoTitle.text = ""
            groupCollections.visibility = View.GONE
        }
    }

    /**
     * interface @MonitorVideoAsyncTask.TVListener
     */
    override fun onUpdateVideoProgress(isPlaying: Boolean, position: Long) {
        val intent = Intent(CastingBroadcastReceiver.ACTION_TV)
        val isShowPlayPauseButton: Boolean = mPresenter?.getPlayMode() == PlayMode.ON_DEMAND
        intent.putExtra(CastingBroadcastReceiver.EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON, isShowPlayPauseButton)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_READY_VIDEO_STATE_ON_TV, isPlaying)
        intent.putExtra(CastingBroadcastReceiver.EXTRA_UPDATE_PROGRESS, position)
        mService.sendBroadcast(intent)
    }

    /**
     * -------------
     */

    /**
     * interface @CastingBroadcastReceiver.UIListener
     */

    override fun onReceivePlayVideoFromUI() {
        if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND) {
            mPresenter?.resumeOrReplay()
        }
    }

    override fun onReceivePauseVideoFromUI() {
        if (mPresenter?.getPlayMode() == PlayMode.ON_DEMAND) {
            mPresenter?.pauseVideo()
        }
    }

    /**
     * ---------------
     */

    interface Callback {
        fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>)
        fun onClearVideos()
    }
}