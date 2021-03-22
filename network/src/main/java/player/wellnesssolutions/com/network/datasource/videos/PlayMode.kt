package player.wellnesssolutions.com.network.datasource.videos

enum class PlayMode(var value:Int) {
    ON_DEMAND(0),
    SCHEDULE(1);

    companion object {
        fun valueOf(value:Int) : PlayMode? = values().find { it.value == value }
    }
}