package player.wellnesssolutions.com.custom_exoplayer

enum class PlayerState(value:Int) {
     NOTHING(-1), COUNTDOWN(0), INITIALIZING(1), PLAYING(2), PAUSED(3), ENDED(4)
}