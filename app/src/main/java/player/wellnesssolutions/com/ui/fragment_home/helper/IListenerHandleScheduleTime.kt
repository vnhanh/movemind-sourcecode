package player.wellnesssolutions.com.ui.fragment_home.helper

interface IListenerHandleScheduleTime {
    fun onHaveNowPlayingVideo(playedPosition: Long)
    fun onHaveVideoAfter(playedPosition: Long) {}

    fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?)
    fun onVideoExpiredTime() {}
    fun onProcessVideoError()
}

enum class STATE_CALCULATING_VIDEO_SCHEDULE_NOW(private val state: String) {
    NORMAL("NORMAL"),
    ON_PLAY_VIDEO_SCHEDULE_NOW("ON_PLAY_VIDEO_SCHEDULE_NOW"),
    VIDEO_EXPIRED("VIDEO_EXPIRED"),
    HAVE_VIDEO_AFTER("HAVE_VIDEO_AFTER"),
    VIDEO_ERROR("VIDEO_ERROR")
}

data class DataCachedVideoScheduleCalculated(
        val state: STATE_CALCULATING_VIDEO_SCHEDULE_NOW = STATE_CALCULATING_VIDEO_SCHEDULE_NOW.NORMAL,
        val playedPosition: Long = 0L
)