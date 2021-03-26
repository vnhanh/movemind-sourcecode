package player.wellnesssolutions.com.ui.fragment_now_playing

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
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
import player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo
import player.wellnesssolutions.com.custom_exoplayer.PlayerState
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.PresentationDataHelper
import player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.HandlerTimeScheduleHelper
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import player.wellnesssolutions.com.ui.fragment_search_brands.module.LoadBrandsHandler
import java.lang.ref.WeakReference

class NowPlayingPresenter(context: Context, playMode: PlayMode) :
        INowPlayingConstruct.Presenter, IPlayVideoContract.Manager.Callback, Player.EventListener {
    private var mWeakContext: WeakReference<Context> = WeakReference(context)
    private var mView: INowPlayingConstruct.View? = null

    private var mPlayedMode: PlayMode = PlayMode.ON_DEMAND

    // for PlayerManager
    private var mPlayerManager: IPlayVideoContract.Manager = PlayerManager(this, context)
    private var mPlayerState = PlayerState.NOTHING
    private var mVideos: ArrayList<MMVideo> = ArrayList()
    private var mInitPlayedPosition: Long = 0L
    private var mIsReload = false // flag check if video is replayed

    // for loading class videos
    private var handlerScheduleTimePlay: HandlerScheduleTime = HandlerScheduleTime(viewContext = context, listener = this)

    // for Countdown Timer
    private var mCountDownTimerPlayVideo: CountDownTimer? = null


    // for loading brands once tapping menu item
    private var mLoadBrandsHandler: ILoadBrandHandler? = null

    // flag check if rendered UI or not yet
    private var mIsRenderedData = false

    private val weakContext = WeakReference(context)

    private var isOnCountDown = false

    init {
        mPlayerManager.addListener(this)

        this.mPlayedMode = playMode

        //initCountDownTimer()
    }

    private fun initCountDownTimer() {
        Log.d("LOG", this.javaClass.simpleName + " initCountDownTime()")
        isPlayNewList = false
        try {
            mCountDownTimerPlayVideo?.cancel()
            isOnCountDown = true
            mCountDownTimerPlayVideo = null
        } catch (e: Exception) {
            e.printStackTrace()
        }

        weakContext.get()?.also { context ->
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
                initializeSearchPlayer()
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

        view.getViewContext()?.also {
            HandlerTimeScheduleHelper.readSharePrefData(PreferenceHelper.getInstance(it), view)
        }

        checkPlayMode()
    }

    private fun checkPlayMode() {
        Log.d("LOG", this.javaClass.simpleName + " checkPlayMode() | mPlayedMode: $mPlayedMode")
        when (mPlayedMode) {
            PlayMode.ON_DEMAND -> processPlayerBaseOnState()
            else -> scanScheduleVideos()
        }
    }

    override fun startToPlayScheduleVideo() {
        super.startToPlayScheduleVideo()

        when {
            mPlayedMode == PlayMode.SCHEDULE && mPlayerState == PlayerState.ENDED -> scanScheduleVideos()
        }
    }

    override fun playNextVideo(): Boolean {
        if (mVideos.size <= 1) {
            return true
        }

        onClickedComingUpNextVideo(0)
        return false
    }

    override fun pauseVideo() {
        mPlayerManager.onPause()
    }

    override fun resumeOrReplay() {
        Log.d("LOG", this.javaClass.simpleName + " resumeOrReplay() | mPlayerState: $mPlayerState | player: ${mPlayerManager.getPlayer()}")
        if (mPlayedMode != PlayMode.ON_DEMAND) return
        when (mPlayerState == PlayerState.PAUSED && mPlayerManager.getPlayer() != null) {
            true -> mPlayerManager.onResume()
            false -> {
                initializeSearchPlayer()
            }
        }
    }

    override fun pausePlayer() {
        mPlayerManager.onPause()
    }

    override fun onChangeVolume(context: Context, progress: Int) {
        mPlayerManager.onChangedVolume(progress)
    }

    override fun setVideos(videos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " setVideos() | videos number: ${videos.size}")
        this.mVideos = videos
        mPlayerManager.addVideos(mVideos)
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
        mView?.hideGroupViewsComingUpNext()
        if (mPlayedMode == PlayMode.ON_DEMAND)
            mPlayerManager.playVideoAt(position + 1)
    }

    private fun isPlayerInitialized(): Boolean = mPlayerManager.getPlayer() != null

    private fun processPlayerBaseOnState() {
        Log.d("LOG", this.javaClass.simpleName + " processPlayerBaseOnState() | videos number: ${mVideos.size} | mPlayerState: $mPlayerState")
        // player has been initialized
        // return
        if (isPlayerInitialized()) return

        when (mPlayerState) {
            PlayerState.NOTHING -> {
                mView?.onIntermediateStage()
                mView?.hideCountDownTimer()
                renderVideosData()

                weakContext.get()?.also { context ->
                    val currentPosition: Long = PreferenceHelper.getInstance(context = context).getLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION, 0L)
                    if (mVideos.size > 0 && currentPosition <= 0) {
                        runCountDownTimer()
                    } else if (mVideos.size > 0) {
                        PreferenceHelper.getInstance(context = context).delete(ConstantPreference.LAST_PLAYED_VIDEO_POSITION)
                        initializeSearchPlayer()
                    }

                }
            }

            PlayerState.INITIALIZING -> {
                renderVideosData()

                initializeSearchPlayer()
            }

        }

    }

    private fun runCountDownTimer() {
        Log.d("LOG", this.javaClass.simpleName + " runCountDownTimer()")
        mCountDownNumber =
                when (mCountDownNumber) {
                    0L -> countTime
                    else -> mCountDownNumber
                }

        initCountDownTimer()
        mCountDownTimerPlayVideo?.start()
        mPlayerState = PlayerState.COUNTDOWN
    }

    private fun renderVideosData() {
        if (mIsRenderedData) return

        mVideos.also { videos ->
            if (videos.size == 0) return@also
            renderVideosInfo(videos)
            mIsRenderedData = true
        }
    }

    private fun renderVideosInfo(videos: ArrayList<MMVideo>) {
        val videoNowPlaying: MMVideo = videos[0]

        // display video now playing data for coming up next
        val comingUpVideos: ArrayList<MMVideo> = getComingUpNextVideos(videos)

        mView?.showUIForPlayingVideo(videoNowPlaying, comingUpVideos)
    }

    private fun initializeSearchPlayer() {
        Log.d("LOG", this.javaClass.simpleName + " initializeSearchPlayer()")
        if (mPlayedMode != PlayMode.ON_DEMAND) return
        if (mView == null) return

        when (mVideos.size > 0) {
            true -> {
                mPlayerState = PlayerState.INITIALIZING
                // play searched videos with startTask position > 0
                mPlayerManager.resumeOrIntialize(playedVideoPosition = mInitPlayedPosition,
                        typeVideo = EnumTypeViewVideo.NORMAL, isUpdateViewNumber = true, isSupportCC = true)
                mInitPlayedPosition = -1L
            }

            false -> {
                onDontHaveNowPlayingVideo(null)
            }
        }
    }

    override fun onStartIntializePlayer() {
        Log.d("LOG", this.javaClass.simpleName + " onStartIntializePlayer()")
        mView?.onStartInitializePlayer()

        if (mPlayedMode == PlayMode.SCHEDULE) {
            mVideos.also {
                renderVideosInfo(videos = it)
            }
        }
    }

    override fun onPlayerInitialized(player: SimpleExoPlayer) {
        Log.d("LOG", this.javaClass.simpleName + " onPlayerInitialized()")
        // class video always play once init
        if (mPlayedMode == PlayMode.SCHEDULE) player.playWhenReady = true
        mView?.onPlayerInitialized(player = player)
        mPlayerState = PlayerState.PLAYING

        // if video is reloaded, not need to update title and collections of video on UI
        if (mIsReload) {
            mIsReload = false
            return
        }
    }

    override fun onPlayNext() {
        Log.d("LOG", this.javaClass.simpleName + " onPlayNext()")
//        mPlayerManager.onInitialize(0L, EnumTypeViewVideo.NORMAL, isPlayCC = true)
        mInitPlayedPosition = 0L
        if (mVideos.size > 0) {
            mPlayerState = PlayerState.NOTHING
            mIsRenderedData = false
        }
        checkPlayMode()
    }

    override fun onReload() {
        Log.d("LOG", this.javaClass.simpleName + " onReload()")
        mInitPlayedPosition = -1L
//        checkPlayMode()
        mIsReload = true
        openNowPlayingVideo(-1L)
    }

    override fun onCookieExpired() {
        mView?.onCookieExpired()
    }

    override fun onReconnectNetwork() {
        if (mPlayerManager.isPlayerError()) {
            checkPlayMode()
        }
    }

    override fun onPlayerEnded(videoId: Int?) {
        if (videoId == null || mVideos.size == 0) return
        val video: MMVideo = mVideos[0]
        if (video.id != videoId) return

        mPlayerState = PlayerState.ENDED
        mCountDownTimerPlayVideo?.cancel()

        when (mVideos.size) {
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
        when (mPlayedMode) {
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
        Log.d("LOG", this.javaClass.simpleName + " scanScheduleVideos() | videos number: ${mVideos.size}")
        val videos: ArrayList<MMVideo> = mVideos
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

    private var isRequestFromUser = false

    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    override fun onHaveNowPlayingVideo(playedPosition: Long) {
        Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | playedPosition: ${playedPosition / 1000}s | mode: $mPlayedMode")
        when (mPlayedMode) {
            PlayMode.SCHEDULE -> {
                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | SCHEDULE | " +
                        "isCastableOnTV: ${mView?.isCastableOnTV()}")
                mView?.hideLoadingProgress()
                val player: SimpleExoPlayer? = mPlayerManager.getPlayer()
                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() |  player: $player")
//                when (player != null) {
//                    true -> {
//                        player.seekTo(playedPosition)
//                        player.playWhenReady = true
//                        mView?.reloadScheduledVideo()
//                    }
//                    false -> {
//                        openNowPlayingVideo(playedPosition)
//                    }
//                }
                openNowPlayingVideo(playedPosition)

            }

            PlayMode.ON_DEMAND -> {
                Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | ON_DEMAND")
                onDontHaveNowPlayingVideo(null)
            }
        }
    }

    override fun onHaveVideoAfter(playedPosition: Long) {
        if (playedPosition > 0L) {
            mView?.hideLoadingProgress()
            mView?.hideControlWhenNextVideoSchedule()

            when {
                // not for presentation screen
                mPlayedMode == PlayMode.SCHEDULE && playedPosition >= Constant.TIME_CHANGE_SCREEN -> {
                    VideoDBUtil.createOrUpdateVideos(mVideos, Constant.MM_SCHEDULE)
                    mView?.backToHomeScreenWithNotLoadSchedule()
                }

                mPlayedMode == PlayMode.SCHEDULE && playedPosition < Constant.TIME_CHANGE_SCREEN -> {
                    // do nothing
                }
            }

            //mView?.onLoadingVideoDelay(playedPosition)
        } else {
            onHaveNowPlayingVideo(0L)
        }
    }

    override fun onVideoExpiredTime() {
        when (mVideos.size < 2) {
            true -> onDontHaveNowPlayingVideo(null)
            false -> {
                mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)
                mVideos.removeAt(0)
                scanScheduleVideos()
            }
        }
    }

    override fun onProcessVideoError() {
        mView?.showMessage(R.string.encountered_error_handling_class_video_data, R.color.red)
    }

    override fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?) {
        Log.d("LOG", this.javaClass.simpleName + " onDontHaveNowPlayingVideo() ")
        mView?.hideLoadingProgress()
        mView?.openNoClassSearchScreen(isClickedButtonHome)
    }

    private fun openNowPlayingVideo(playedVideoPosition: Long) {
        Log.d("LOG", this.javaClass.simpleName + " openNowPlayingVideo() ")
        mPlayerManager.onInitialize(playedVideoPosition = playedVideoPosition, typeVideo = EnumTypeViewVideo.SCHEDULE, isUpdateViewNumber = true, isSupportCC = true)
    }

    override fun setPlayedPosition(position: Long) {
        this.mInitPlayedPosition = position
    }

    override fun switchToPlayScheduleVideos(scheduleVideos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " switchToPlayScheduleVideos() | videos number: ${mVideos.size}")
        mVideos = scheduleVideos
        mPlayedMode = PlayMode.SCHEDULE
        mInitPlayedPosition = -1L
        mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)

        setVideos(scheduleVideos)
        scanScheduleVideos()
    }

    override fun onDetach() {
        mView = null
        // video if could be played at the next onAttach(), would be played from its last position
        mInitPlayedPosition = -1L
        when (mPlayedMode) {
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
                when (mPlayedMode) {
                    PlayMode.SCHEDULE -> true
                    else -> false
                }

        mPlayerManager.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = keepPlayWhenReady)

        if (mPlayedMode == PlayMode.ON_DEMAND) {
            mPlayerState =
                    when (mPlayerManager.getCurrentPosition() > 0) {
                        true -> PlayerState.INITIALIZING
                        else -> PlayerState.NOTHING
                    }
            mIsRenderedData = false
        }
    }

    override fun onDestroy() {
        if (mPlayerManager.getCurrentPosition() > 0 && !isPlayNewList) {
            PresentationDataHelper.save(context = mWeakContext.get(), mode = mPlayedMode, videos = mVideos,
                    currentPosition = mPlayerManager.getCurrentPosition(),
                    timeCountDown = mCountDownNumber)
        }

        handlerScheduleTimePlay.release()
        mPlayerManager.onDestroy()
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
        if (mVideos.size == 0) return null
        return mVideos[0]
    }

    /**
     * @interface Player.EventListener
     */
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        when (playbackState) {
            Player.STATE_BUFFERING -> {

                mPlayerState = PlayerState.PAUSED
            }

            Player.STATE_READY -> {
                mPlayerState =
                        when (playWhenReady) {
                            true -> PlayerState.PLAYING
                            false -> PlayerState.PAUSED
                        }
            }

            Player.STATE_ENDED -> {
                mPlayerState = PlayerState.ENDED
                when {
                    mVideos.size == 0 -> {
                        when {
                            mPlayedMode == PlayMode.ON_DEMAND -> {

                            }

                            mPlayedMode == PlayMode.SCHEDULE -> {
                                onDontHaveNowPlayingVideo(isClickedButtonHome = false)
                            }
                        }
                    }

                    else -> {
//                        mVideos.removeAt(0)
//                        scanScheduledVideo()
                    }
                }

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

    override fun getAllVideos(): ArrayList<MMVideo> = mVideos

    override fun isPlayingVideo(): Boolean = mPlayerManager.isPlaying()

    override fun getPlayMode(): PlayMode = mPlayedMode

    override fun isPlayerError(): Boolean = mPlayerManager.isPlayerError()

    override fun getCurrentPlayedPosition(): Long = mPlayerManager.getCurrentPosition()

    override fun isPlayingCC(): Boolean = mPlayerManager.isPlayingCC()

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