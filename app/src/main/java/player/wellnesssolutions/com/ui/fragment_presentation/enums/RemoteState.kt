package player.wellnesssolutions.com.ui.fragment_presentation.enums

enum class RemoteState(var value: Int) {
    STATE_PLAY_PAUSED(1),
    STATE_NEXT(2),
    STATE_SHOW_NEXT(3);

    companion object {
        fun getEnum(value: Int): RemoteState? = RemoteState.values().find {
            it.value == value
        }
    }
}