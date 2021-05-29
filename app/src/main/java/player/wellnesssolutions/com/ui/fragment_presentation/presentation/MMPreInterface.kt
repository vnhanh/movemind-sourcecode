package player.wellnesssolutions.com.ui.fragment_presentation.presentation

import player.wellnesssolutions.com.base.view.ILifeCycle

interface MMPreInterface {
    interface View : ILifeCycle.View {
        fun isPlayingSchedule(): Boolean
        fun isPlayingSearchVideos(): Boolean
        fun isPlaying(): Boolean
    }
}