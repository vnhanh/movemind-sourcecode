package player.wellnesssolutions.com.base.common.play_video

import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage


interface IPlayVideoContract {
    interface ViewCallback {
        fun onPlayerInitialized(player: SimpleExoPlayer, isReload: Boolean = false)
        fun onCookieExpired()
    }

    interface Manager {
        fun addListener(listener: Player.EventListener)
        fun removeListener(listener: Player.EventListener)

        // manipulation
        fun resumeOrIntialize(playedVideoPosition: Long, typeVideo: EnumTypeViewVideo, isUpdateViewNumber: Boolean = false, isSupportCC: Boolean)
        fun onInitialize(playedVideoPosition: Long = 0L, typeVideo: EnumTypeViewVideo, isUpdateViewNumber: Boolean = false, isSupportCC: Boolean = false)

        fun addVideos(videos: ArrayList<MMVideo>)
        fun addVideo(video: MMVideo)
        fun playVideoAt(index: Int)
        fun onChangedVolume(progress: Int)
        fun setSubtitleController(closedCaptionController: ClosedCaptionController)
        fun onClickedLanguageSubtitle(value: MMVideoLanguage)
        fun replay()
        fun handleOnEnded()

        fun getClosedCaptionController(): ClosedCaptionController?
        fun slideNextLanguageCCOption()
        fun selectLanguageCCOption()

        // lifecycle
        fun onPause()

        fun onResume()
        fun onReleasePlayer(isKeepPosition: Boolean = false, keepPlayWhenReady: Boolean)
        fun onDestroy()

        // check status
        fun getCurrentPosition(): Long

        fun isPlaying(): Boolean
        fun hasPlayer(): Boolean = false
        fun isPlayerError(): Boolean
        fun getPlaybackState(): Int
        fun isPlayingCC(): Boolean
        fun getPlayer(): SimpleExoPlayer?

        interface Callback {
            fun onStartIntializePlayer()
            fun onPlayerInitialized(player: SimpleExoPlayer)

            //            fun onChangedPlaybackState(playbackState:Int)
            fun onPlayNext() {}
            fun onReload() {}
            fun onCookieExpired()
        }
    }
}