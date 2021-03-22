package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import player.wellnesssolutions.com.network.datasource.videos.PlayMode

interface IComingUpNextClickListener {
    fun onClickedComingUpNextVideo(position: Int)
    fun onTapGroupComingUpNext()
    fun getPlayMode(): PlayMode
}