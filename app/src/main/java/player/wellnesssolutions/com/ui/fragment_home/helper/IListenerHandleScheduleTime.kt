package player.wellnesssolutions.com.ui.fragment_home.helper

interface IListenerHandleScheduleTime {
    fun onHaveNowPlayingVideo(playedPosition: Long)
    fun onHaveVideoAfter(playedPosition: Long) {}

    fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?)
    fun onVideoExpiredTime() {}
    fun onProcessVideoError()
}