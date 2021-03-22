package player.wellnesssolutions.com.ui.fragment_presentation.presentation

import com.google.android.exoplayer2.SimpleExoPlayer
import player.wellnesssolutions.com.base.view.ILifeCycle

interface MMPreInterface {
    interface View : ILifeCycle.View {
        fun initUI() {}
        fun setUpPlayer(player: SimpleExoPlayer) {}
        fun isPlayingSchedule(): Boolean
        fun isPlayingSearchVideos(): Boolean
        fun isPlaying(): Boolean
    }
}