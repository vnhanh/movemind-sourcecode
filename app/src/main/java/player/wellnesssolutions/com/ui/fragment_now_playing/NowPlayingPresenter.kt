package player.wellnesssolutions.com.ui.fragment_now_playing

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController
import player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract
import player.wellnesssolutions.com.base.common.play_video.PlayerManager
import player.wellnesssolutions.com.base.utils.ParameterUtils.countTime
import player.wellnesssolutions.com.base.utils.ParameterUtils.isPlayNewList
import player.wellnesssolutions.com.base.utils.ParameterUtils.mCountDownNumber
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceManager
import player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo
import player.wellnesssolutions.com.custom_exoplayer.PlayerState
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.HandlerTimeScheduleHelper
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import player.wellnesssolutions.com.ui.fragment_search_brands.module.LoadBrandsHandler
import java.util.concurrent.TimeUnit

class NowPlayingPresenter(private var context: Context?, playMode: PlayMode) :
        INowPlayingConstruct.Presenter, IPlayVideoContract.Manager.Callback, Player.EventListener {
    private var mView: INowPlayingConstruct.View? = null

    private var playedMode: PlayMode = PlayMode.ON_DEMAND

    // for PlayerManager
    private var mPlayerManager: IPlayVideoContract.Manager = PlayerManager(this, context)
    private var mPlayerState = PlayerState.NOTHING
    private var videos: ArrayList<MMVideo> = ArrayList()
    private var mInitPlayedPosition: Long = 0L
    private var mIsReload = false // flag check if video is replayed

    // for loading class videos
    private var handlerScheduleTimePlay: HandlerScheduleTime = HandlerScheduleTime(context = context, listener = this)

    // for Countdown Timer
    private var mCountDownTimerPlayVideo: CountDownTimer? = null

    // for loading brands once tapping menu item
    private var mLoadBrandsHandler: ILoadBrandHandler? = null

    // flag check if rendered UI or not yet
    private var isRenderedData = false

    private var isOnCountDown = false
    private var isStopPlayNext = false

    init {
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_PLAYING_VIDEO, true)
        mPlayerManager.addListener(this)
        this.playedMode = playMode
        //initCountDownTimer()
    }

    private fun initCountDownTimer() {
//        Log.d("LOG", this.javaClass.simpleName + " initCountDownTime()")
        isPlayNewList = false
        try {
            mCountDownTimerPlayVideo?.cancel()
            isOnCountDown = true
            mCountDownTimerPlayVideo = null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        context?.also { context ->
            val timeFromLastCount = PreferenceHelper.getInstance(context = context).getLong(ConstantPreference.LAST_TIME_COUNT_DOWN, 0L)

            if (timeFromLastCount > 0) {
                mCountDownNumber = timeFromLastCount
                PreferenceHelper.getInstance(context = context).delete(ConstantPreference.LAST_TIME_COUNT_DOWN)
            } else {
                mCountDownNumber = countTime
            }

        }

        mCountDownTimerPlayVideo = object : CountDownTimer(mCountDownNumber, 1000) {
            /**
             * Callback fired when the time is up.
             */
            override fun onFinish() {
                mCountDownNumber = 0
                mPlayerState = PlayerState.INITIALIZING
                mView?.showCountDownPlayTime(-1000)
                isOnCountDown = false
                initPlayer()
            }

            /**
             * Callback fired on regular interval.
             * @param millisUntilFinished The amount of time until finished.
             */
            override fun onTick(millisUntilFinished: Long) {
                mCountDownNumber = millisUntilFinished
                mView?.showCountDownPlayTime(millisUntilFinished)
            }

        }
    }

    override fun onAttach(view: INowPlayingConstruct.View) {
        this.mView = view
        mPlayerManager.addListener(view)
        mPlayerManager.updateContext(view.getViewContext())

        if (mLoadBrandsHandler == null) mLoadBrandsHandler = LoadBrandsHandler(view)
        mLoadBrandsHandler?.onAttach(view)

        view.getViewContext()?.also {
            HandlerTimeScheduleHelper.readSharePrefData(PreferenceHelper.getInstance(it), view)
            handlerScheduleTimePlay.release()
            handlerScheduleTimePlay = HandlerScheduleTime(it, this)
        }

        checkPlayMode()
        if(havetoCastOnceResume){
            onCastRouterConnected()
        }
    }

    private fun checkPlayMode() {
//        Log.d("LOG", this.javaClass.simpleName + " checkPlayMode() | mPlayedMode: $playedMode")
        PreferenceHelper.getInstance()?.putInt(ConstantPreference.MODE_PLAY_VIDEO, playedMode.value)
        when (playedMode) {
            PlayMode.ON_DEMAND -> processPlayerBaseOnState()
            PlayMode.SCHEDULE -> scanScheduleVideos()
            PlayMode.UNKNOWN -> {
            } // do nothing
        }
    }

    override fun startToPlayScheduleVideo() {
        super.startToPlayScheduleVideo()

        when {
            playedMode == PlayMode.SCHEDULE && mPlayerState == PlayerState.ENDED -> scanScheduleVideos()
        }
    }

    override fun playNextVideo(): Boolean {
        if (videos.size <= 1) {
            return true
        }

        onClickedComingUpNextVideo(0)
        return false
    }

    override fun pauseVideo() {
        mPlayerManager.onPause()
    }

    override fun resumeOrReplay() {
//        Log.d("LOG", this.javaClass.simpleName + " resumeOrReplay() | playMode: $playedMode | playbackState: ${mPlayerManager.getPlaybackState()} | mPlayerState: $mPlayerState | player: ${mPlayerManager.getPlayer()}")
        if (playedMode != PlayMode.ON_DEMAND) return
        when {
            mPlayerState == PlayerState.PAUSED && mPlayerManager.getPlayer() != null -> mPlayerManager.onResume()

            mPlayerState == PlayerState.COUNTDOWN -> {
//                Log.d("LOG", this.javaClass.simpleName + " resumeOrReplay() | case COUNTDOWN")
                when {
                    mCountDownTimerPlayVideo == null -> runCountDownTimer()
                    else -> {
//                        Log.d("LOG", this.javaClass.simpleName + " resumeOrReplay() | case COUNTDOWN | start count down timer again")
                        mCountDownTimerPlayVideo?.start()
                    }
                }

            }

            false -> {
                resumeOrInitPlayer()
            }
        }
    }

    override fun pausePlayer() {
        when {
            playedMode == PlayMode.SCHEDULE -> {
                mPlayerManager.onReleasePlayer(false, true)
            }

            playedMode == PlayMode.ON_DEMAND -> mPlayerManager.onPause()
        }
    }

    override fun onChangeVolume(context: Context, progress: Int) {
        mPlayerManager.onChangedVolume(progress)
    }

    override fun setVideos(videos: ArrayList<MMVideo>, playMode: PlayMode) {
//        Log.d("LOG", this.javaClass.simpleName + " setVideos() | videos number: ${videos.size}")
        this.isOnCountDown = false
        try {
            this.mCountDownTimerPlayVideo?.cancel()
        } catch (e: RuntimeException) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("NowPlayingPresenter - countdown error")
//            Log.e("CountDownTimer", " NowPlayingPresenter - " + e.message)
        }
        this.mCountDownTimerPlayVideo = null
        this.videos = videos
        this.playedMode = playMode
        mPlayerState = PlayerState.NOTHING
        isStopPlayNext = false
        isRenderedData = false
        mPlayerManager.setVideos(this.videos)
    }

    override fun stopPlayNext() {
        isStopPlayNext = true
    }

    private fun getComingUpNextVideos(videos: ArrayList<MMVideo>): ArrayList<MMVideo> {
        val res = ArrayList<MMVideo>()
        val size: Int = videos.size
        for (i: Int in 1 until size) {
            res.add(videos[i])
        }

        return res
    }

    override fun onClickedComingUpNextVideo(position: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " onClickedComingUpNextVideo() | position: $position")
        mView?.hideGroupViewsComingUpNext()
        if (playedMode == PlayMode.ON_DEMAND)
            mPlayerManager.playVideoAt(position + 1)
    }

    private fun isPlayerInitialized(): Boolean = mPlayerManager.getPlayer() != null
    private val handler = Handler()

    private fun processPlayerBaseOnState() {
//        Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | videos number: ${videos.size} | mPlayerState: $mPlayerState")
        // player has been initialized
        if (isPlayerInitialized() && isKeepPlayerVideoSearchedAfterNetworkReconnect) {
//            Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | is inited player")
            isKeepPlayerVideoSearchedAfterNetworkReconnect = false
            mPlayerManager.onReleasePlayer(true, true)
        }

        when (mPlayerState) {
            PlayerState.NOTHING -> {
                VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_VIDEO_SEARCHED)
//                Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | player state nothing | context: $context")
                mView?.onIntermediateStage()
                mView?.hideCountDownTimer()
                renderVideosData()

                context?.also { context ->
                    val currentPosition: Long = PreferenceHelper.getInstance(context = context).getLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION, 0L)
//                    Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | videos number: ${videos.size} | currentPosition: $currentPosition")
                    if (videos.size > 0 && currentPosition <= 0) {
//                        Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | run count down")
                        runCountDownTimer()
                    } else if (videos.size > 0) {
//                        Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | initializeSearchPlayer")
                        initPlayer()
                        PreferenceHelper.getInstance(context = context).delete(ConstantPreference.LAST_PLAYED_VIDEO_POSITION)
                    }

                }
            }

            PlayerState.INITIALIZING -> {
                renderVideosData()

                initPlayer()
            }

        }

    }

    private fun runCountDownTimer() {
//        Log.d("LOG", this.javaClass.simpleName + " runCountDownTimer()")
        mCountDownNumber =
                when (mCountDownNumber) {
                    0L -> countTime
                    else -> mCountDownNumber
                }

        initCountDownTimer()
        try {
            mCountDownTimerPlayVideo?.start()
            mPlayerState = PlayerState.COUNTDOWN
        } catch (e: RuntimeException) {
            e.printStackTrace()
            Log.e("CountDownTimer", this.javaClass.simpleName + " runCountDownTimer - error: ${e.message}")
            Observable.timer(200, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.single())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        try {
                            mCountDownTimerPlayVideo?.start()
                            mPlayerState = PlayerState.COUNTDOWN
                        } catch (e: RuntimeException) {
                            e.printStackTrace()
                            Log.e("CountDownTimer", this.javaClass.simpleName + " runCountDownTimer again - error: ${e.message}")
                            mView?.showMessage(R.string.can_not_show_count_down, R.color.yellow)
                        }
                    }
        }
    }

    private fun renderVideosData() {
//        if (mIsRenderedData) return

        videos.also { videos ->
            if (videos.size == 0) return@also
            renderVideosInfo(videos)
            isRenderedData = true
        }
    }

    private fun renderVideosInfo(videos: ArrayList<MMVideo>) {
        val videoNowPlaying: MMVideo = videos[0]

        // display video now playing data for coming up next
        val comingUpVideos: ArrayList<MMVideo> = getComingUpNextVideos(videos)

        mView?.showUIForPlayingVideo(videoNowPlaying, comingUpVideos)
    }

    private fun resumeOrInitPlayer() {
//        Log.d("LOG", this.javaClass.simpleName + " initializeSearchPlayer() | playerState: $mPlayerState | positionPlayLast: $mInitPlayedPosition | " +
//                "player playback state: ${mPlayerManager.getPlaybackState()}")
        if (playedMode != PlayMode.ON_DEMAND) return
        if (mView == null) return

        when (videos.size > 0) {
            true -> {
                mPlayerState = PlayerState.INITIALIZING
                // play searched videos with startTask position > 0
                mPlayerManager.resumeOrIntialize(playedVideoPosition = mInitPlayedPosition,
                        typeVideo = EnumTypeViewVideo.NORMAL, isUpdateViewNumber = true, isSupportCC = true)
                mInitPlayedPosition = 0L
            }

            false -> {
                mView?.showMessage(R.string.no_searched_videos, R.color.red)
            }
        }
    }

    private fun initPlayer() {
//        Log.d("LOG", this.javaClass.simpleName + " initPlayer() | playerState: $mPlayerState | positionPlayLast: $mInitPlayedPosition | " +
//                "player playback state: ${mPlayerManager.getPlaybackState()} | mView: $mView | mode: $playedMode | videos number: ${videos.size}")
        if (playedMode != PlayMode.ON_DEMAND) return
        if (mView == null) return

        when (videos.size > 0) {
            true -> {
                mPlayerState = PlayerState.INITIALIZING
//                mInitPlayedPosition = 0L
                // play searched videos with startTask position > 0
                mPlayerManager.onInitialize(playedVideoPosition = mInitPlayedPosition,
                        typeVideo = EnumTypeViewVideo.NORMAL, isUpdateViewNumber = true, isSupportCC = true)
                mInitPlayedPosition = 0L
            }

            false -> {
                mView?.showMessage(R.string.no_searched_videos, R.color.red)
            }
        }
    }

    override fun onStartIntializePlayer() {
//        Log.d("LOG", this.javaClass.simpleName + " onStartIntializePlayer()")
        mView?.onStartInitializePlayer()

        if (playedMode == PlayMode.SCHEDULE) {
            videos.also {
                renderVideosInfo(videos = it)
            }
        }
    }

    override fun onPlayerInitialized(player: SimpleExoPlayer) {
//        Log.d("LOG", this.javaClass.simpleName + " onPlayerInitialized() | playWhenReady: ${player.playWhenReady}")
        // class video always play once init
//        if (playedMode == PlayMode.SCHEDULE) player.playWhenReady = true
        player.playWhenReady = true
        mView?.onPlayerInitialized(player = player)
        mPlayerState = PlayerState.PLAYING

        // if video is reloaded, not need to update title and collections of video on UI
        if (mIsReload) {
            mIsReload = false
        }
    }

    override fun onPlayNext() {
//        Log.d("LOG", this.javaClass.simpleName + " onPlayNext()")
        mInitPlayedPosition = 0L
        if (videos.size > 0) {
            mPlayerState = PlayerState.NOTHING
            isRenderedData = false
        }
        if (!isStopPlayNext) {
            checkPlayMode()
        }
    }

    override fun onReload() {
//        Log.d("LOG", this.javaClass.simpleName + " onReload()")
        mInitPlayedPosition = 0L
        mIsReload = true
        openNowPlayingVideo(0L)
    }

    override fun onCookieExpired() {
        mView?.onCookieExpired()
    }

    private var isKeepPlayerVideoSearchedAfterNetworkReconnect = false
    override fun onReconnectNetwork() {
        if (mPlayerManager.isPlayerError()) {
            isKeepPlayerVideoSearchedAfterNetworkReconnect = true
            checkPlayMode()
        }
    }

    override fun onPlayerEnded(videoId: Int?) {
//        Log.d("LOG", this.javaClass.simpleName + " onPlayerEnded() | videos number: ${videos.size}")
        if (videoId == null || videos.size == 0) return
        val video: MMVideo = videos[0]
        if (video.id != videoId) return

        mPlayerState = PlayerState.ENDED
        mCountDownTimerPlayVideo?.cancel()

        when (videos.size) {
            0 -> {
            }

            1 -> {
                mPlayerManager.onReleasePlayer(isKeepPosition = false, keepPlayWhenReady = true)
            }

            else -> {
                mPlayerManager.handleOnEnded()
            }
        }
    }

    override fun clickToCallServiceLoadSchedule() {
        when (playedMode) {
            PlayMode.SCHEDULE -> {
                mView?.showDialogAskWantToLoadSchedule()
            }

            PlayMode.ON_DEMAND -> {
                mView?.onLoadScheduleWhilePlaySearchedVideos()
            }
        }
    }

    /**
     * implementing the module playing scheduled videos
     */

    private fun scanScheduleVideos() {
//        Log.d("LOG", this.javaClass.simpleName + " scanScheduleVideos() | videos number: ${videos.size}")
        if (videos.isNullOrEmpty()) {
            onDontHaveNowPlayingVideo(null)
            return
        }

        handlerScheduleTimePlay.setupScheduleForNowVideo(videos)
    }

    override fun onClickedComingUpNextItem() {
        mView?.hideGroupViewsComingUpNext()
    }

    override fun setSubtitleController(closedCaptionController: ClosedCaptionController) {
        mPlayerManager.setSubtitleController(closedCaptionController)
    }

    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    override fun onHaveNowPlayingVideo(playedPosition: Long) {
//        Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | playedPosition: ${playedPosition / 1000}s | mode: $playedMode")
        when (playedMode) {
            PlayMode.SCHEDULE -> {
//                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | SCHEDULE | " +
//                        "isCastableOnTV: ${mView?.isCastableOnTV()}")
                PreferenceHelper.getInstance()?.getBoolean(Constant.IS_LOADING_SCHEDULE, false)?.also { isLoadingSchedule ->
                    if (!isLoadingSchedule) {
                        VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
                    }
                }
                mView?.hideLoadingProgress()
                val video = videos[0]
                PreferenceHelper.getInstance()?.putInt(Constant.SCHEDULE_CURRENT_ID, video.id ?: -1)
                PreferenceHelper.getInstance()?.putString(Constant.SCHEDULE_CURRENT_TIME_START, video.getStartTime())
//                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | saved current video ")
                mCountDownTimerPlayVideo?.cancel()
                openNowPlayingVideo(playedPosition)

            }

            PlayMode.ON_DEMAND -> {
//                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | ON_DEMAND")
                onDontHaveNowPlayingVideo(null)
            }
        }
    }

    override fun onHaveVideoAfter(playedPosition: Long) {
//        Log.d("LOG", this.javaClass.simpleName + "  onHaveVideoAfter()")
        if (playedPosition > 0L) {
            mView?.hideLoadingProgress()
            mView?.hideControlWhenNextVideoSchedule()

            when {
                // not for presentation screen
                playedMode == PlayMode.SCHEDULE && playedPosition >= Constant.TIME_CHANGE_SCREEN -> {
                    PreferenceHelper.getInstance()?.getBoolean(Constant.IS_LOADING_SCHEDULE, false)?.also { isLoadingSchedule ->
                        if (!isLoadingSchedule) {
                            VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
                        }
                    }
                    mCountDownTimerPlayVideo?.cancel()
                    mView?.backToHomeScreenWithNotLoadSchedule()
                }
            }

            //mView?.onLoadingVideoDelay(playedPosition)
        } else {
            onHaveNowPlayingVideo(0L)
        }
    }

    override fun onVideoExpiredTime() {
        when (videos.size < 2) {
            true -> onDontHaveNowPlayingVideo(null)
            false -> {
                mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)
                videos.removeAt(0)
                scanScheduleVideos()
            }
        }
    }

    override fun onProcessVideoError() {
//        Log.d("LOG", this.javaClass.simpleName + " onProcessVideoError()")
        mView?.showMessage(R.string.encountered_error_handling_class_data, R.color.red)
    }

    override fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?) {
//        Log.d("LOG", this.javaClass.simpleName + " onDontHaveNowPlayingVideo() ")
        mView?.hideLoadingProgress()
        PreferenceManager.clearSchedulePref()
        mView?.openNoClassSearchScreen(isClickedButtonHome)
    }

    private fun openNowPlayingVideo(playedVideoPosition: Long) {
//        Log.d("LOG", this.javaClass.simpleName + " openNowPlayingVideo() ")
        mPlayerManager.onInitialize(playedVideoPosition = playedVideoPosition, typeVideo = EnumTypeViewVideo.SCHEDULE, isUpdateViewNumber = true, isSupportCC = true)
    }

    override fun setPlayedPosition(position: Long) {
        this.mInitPlayedPosition = position
        if(position == 0L){
            mPlayerState = PlayerState.COUNTDOWN
        }else{
            mPlayerState = PlayerState.PLAYING
        }
    }

    override fun switchToPlayScheduleVideos(scheduleVideos: ArrayList<MMVideo>) {
//        Log.d("LOG", this.javaClass.simpleName + " switchToPlayScheduleVideos() | videos number: ${videos.size}")
        mInitPlayedPosition = 0L
        mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)

        setVideos(scheduleVideos, PlayMode.SCHEDULE)
        scanScheduleVideos()
    }

    override fun onDetach() {
        mView = null
        mLoadBrandsHandler?.onDetach()
        // video if could be played at the next onAttach(), would be played from its last position
        mInitPlayedPosition = 0L
        when (playedMode) {
            PlayMode.SCHEDULE -> {
//                mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)
                mPlayerManager.onPause()
            }
            PlayMode.ON_DEMAND -> {
                //mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = false)
                mPlayerManager.onPause()
            }
        }
    }

    override fun onStop() {
        mCountDownTimerPlayVideo?.cancel()
        mLoadBrandsHandler?.release()
        mLoadBrandsHandler = null

        val keepPlayWhenReady: Boolean =
                when (playedMode) {
                    PlayMode.SCHEDULE -> true
                    else -> false
                }

        mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = keepPlayWhenReady)

        if (playedMode == PlayMode.ON_DEMAND) {
            mPlayerState =
                    when (mPlayerManager.getCurrentPosition() > 0) {
                        true -> PlayerState.INITIALIZING
                        else -> PlayerState.NOTHING
                    }
            isRenderedData = false
        }
    }

    override fun onDestroy() {
//        if (mPlayerManager.getCurrentPosition() > 0 && !isPlayNewList) {
//            PresentationDataHelper.save(context = context, mode = playedMode, videos = videos)
//        }
        context = null
        try {
            handler.removeCallbacks(null)
            PreferenceHelper.getInstance()?.putBoolean(Constant.IS_PLAYING_VIDEO, false)
            mPlayerManager.onDestroy()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        handlerScheduleTimePlay.release()
    }

    override fun showClosedCaptionView() {
        mPlayerManager.getClosedCaptionController()?.also {
            it.showClosedCaptionView()
        }
    }

    override fun hideClosedCaptionView() {
        mPlayerManager.getClosedCaptionController()?.also {
            it.hideClosedCaptionView()
        }
    }

    override fun slideNextLanguageCCOption() {
        mPlayerManager.slideNextLanguageCCOption()
    }

    override fun selectLanguageCCOption() {
        mPlayerManager.selectLanguageCCOption()
        mPlayerManager.getClosedCaptionController()?.hideClosedCaptionView()
    }

    override fun onTapGroupComingUpNext() {
        mView?.hideGroupViewsComingUpNext()
    }

    override fun getNowPlayVideo(): MMVideo? {
        if (videos.size == 0) return null
        return videos[0]
    }

    /**
     * @interface Player.EventListener
     */
    private var isPlayingVideo = false

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " onPlayerStateChanged() | playbackState: $playbackState | playWhenReady: $playWhenReady")
        when (playbackState) {
            Player.STATE_BUFFERING -> {

                mPlayerState = PlayerState.PAUSED
            }

            Player.STATE_READY -> {
                isPlayingVideo = true
                mPlayerState =
                        when (playWhenReady) {
                            true -> PlayerState.PLAYING
                            false -> PlayerState.PAUSED
                        }
            }

            Player.STATE_ENDED -> {
                mPlayerState = PlayerState.ENDED
                if (videos.size <= 1 && playedMode == PlayMode.SCHEDULE && isPlayingVideo) {
                    onDontHaveNowPlayingVideo(isClickedButtonHome = false)
                }
                isPlayingVideo = false

            }

            Player.STATE_IDLE -> {
                mPlayerState = PlayerState.NOTHING

            }
        }
    }

    override fun getIsCountDown(): Boolean = isOnCountDown

    override fun getPlayerState(): PlayerState = mPlayerState

    override fun isShowClosedCaptionView(): Boolean = mPlayerManager.getClosedCaptionController()?.isShowClosedCaptionView()
            ?: false

    override fun replayVideo() = mPlayerManager.replay()

    override fun getPlayerManager(): IPlayVideoContract.Manager = mPlayerManager

    override fun getAllVideos(): ArrayList<MMVideo> = videos

    override fun isPlayingVideo(): Boolean = mPlayerManager.isPlaying()

    override fun getPlayMode(): PlayMode = playedMode

    override fun isPlayerError(): Boolean = mPlayerManager.isPlayerError()

    override fun getCurrentPlayedPosition(): Long = mPlayerManager.getCurrentPosition()

    override fun isPlayingCC(): Boolean = mPlayerManager.isPlayingCC()

    private var havetoCastOnceResume = false
    override fun onCastRouterConnected() {
//        Log.d("LOG", this.javaClass.simpleName + " onCastRouterConnected() | last position: ${mPlayerManager.getCurrentPosition()}")
        PreferenceHelper.getInstance()?.putLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION, getCurrentPlayedPosition())
        val view = mView
        if(view == null){
            havetoCastOnceResume = true
        }else{
            view.castingAndBackToHome()
            havetoCastOnceResume = false
        }
    }

    /**
     * LOAD BRANDS
     */
    override fun loadBrands(tag: String) {
        mLoadBrandsHandler?.loadBrands(tag)
    }

    override fun openTimeTableScreen() {
        mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = false)
        mView?.openTimeTableScreen()
    }

    override fun stopCountdown() {
        mCountDownTimerPlayVideo?.let {
            it.cancel()
        }
    }
}