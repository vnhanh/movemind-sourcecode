package player.wellnesssolutions.com.ui.fragment_now_playing

import android.content.Context
import com.google.android.exoplayer2.Player
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController
import player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract
import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.custom_exoplayer.PlayerState
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler

interface INowPlayingConstruct {

    interface View : IProgressView, ILoadBrandHandler.Callback, IShowMessageView, IScheduleContract.View, IPlayVideoContract.ViewCallback, Player.EventListener {
        fun showUIForPlayingVideo(videoData: MMVideo, comingUpVideos: ArrayList<MMVideo>) {}
        fun openNoClassSearchScreen(isClickedButtonHome: Boolean?) {}
        fun hideGroupViewsComingUpNext() {}
        fun setupViewFloatMenu(configData: MMConfigData) {}
        fun onLoadingVideoDelay(playedPosition: Long) {}
        fun showCountDownPlayTime(millisUntilFinished: Long)
        fun onVideoEnded()
        fun onStartInitializePlayer()
        fun onIntermediateStage()
        fun reloadScheduledVideo()
        fun openTimeTableScreen() {}
        fun hideCountDownTimer() {}
        fun hideControlWhenNextVideoSchedule() {}
        fun showDialogAskWantToLoadSchedule() {}
        fun onLoadScheduleWhilePlaySearchedVideos() {}
        fun backToHomeScreenWithNotLoadSchedule() {}
        fun isCastableOnTV(): Boolean
        fun castingAndBackToHome() {}
    }

    interface Presenter : ILifeCycle.Presenter<View>, IComingUpNextClickListener, IListenerHandleScheduleTime {
        fun onChangeVolume(context: Context, progress: Int)
        fun pausePlayer()
        fun getPlayerManager(): IPlayVideoContract.Manager
        fun getAllVideos(): ArrayList<MMVideo>?
        fun onReconnectNetwork()
        fun replayVideo()

        fun playNextVideo(): Boolean
        fun pauseVideo()
        fun resumeOrReplay()
        fun setVideos(videos: ArrayList<MMVideo>, playMode: PlayMode)
        fun setPlayedPosition(position: Long)

        fun setSubtitleController(closedCaptionController: ClosedCaptionController)
        fun switchToPlayScheduleVideos(scheduleVideos: ArrayList<MMVideo>)

        fun onClickedComingUpNextItem()

        fun showClosedCaptionView()
        fun hideClosedCaptionView()
        fun slideNextLanguageCCOption()
        fun selectLanguageCCOption()

        fun isPlayingVideo(): Boolean
        fun isPlayerError(): Boolean
        fun getCurrentPlayedPosition(): Long
        fun onPlayerEnded(videoId: Int?)
        fun isPlayingCC(): Boolean
        fun isShowClosedCaptionView(): Boolean
        fun getNowPlayVideo(): MMVideo?
        fun getPlayerState(): PlayerState

        // load brands
        fun loadBrands(tag: String)

        fun openTimeTableScreen()

        fun stopCountdown()

        fun getIsCountDown(): Boolean
        fun startToPlayScheduleVideo() {}
        fun clickToCallServiceLoadSchedule()
        fun stopPlayNext()
        fun onCastRouterConnected()
    }
}