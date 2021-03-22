package player.wellnesssolutions.com.ui.fragment_presentation.players

import android.content.Context
import androidx.mediarouter.media.MediaRouter
import player.wellnesssolutions.com.common.media_router.models.PlaylistItem
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

abstract class MMPlayer {
    protected var mCallback: Callback? = null

    abstract fun isRemotePlayback(): Boolean
    abstract fun isQueuingSupported(): Boolean
    open fun isScreenSupported(): Boolean = false

    abstract fun connect(route: MediaRouter.RouteInfo?)
    abstract fun release()

    // basic operations that are always supported
    abstract fun play(item: PlaylistItem)

    open fun play(mode: PlayMode, item: ArrayList<*>, lastPosition: Long = 0L) {

    }

    abstract fun seek(item: PlaylistItem)
    abstract fun getStatus(item: PlaylistItem, update: Boolean)
    abstract fun pause()
    abstract fun resume()
    abstract fun stop()
    open fun next() {}
    open fun showNext() {}

    // advanced queuing (enqueue & remove) are only supported
    // if isQueuingSupported() returns true
    abstract fun enqueue(item: PlaylistItem)

    abstract fun remove(itemId: String): PlaylistItem?

    // route statistics
    open fun updateStatistics() {}

    open fun getStatistics(): String {
        return ""
    }

    // presentation display
    open fun updatePresentation(route: MediaRouter.RouteInfo) {}

    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    abstract fun isPlayingNowPlaying(): Boolean

    open fun isPlayingSearchVideos(): Boolean = false

    abstract fun isPlayingPresentation(): Boolean

    abstract fun getMode(): PlayMode?
    abstract fun getVideos(): ArrayList<MMVideo>
    open fun getLastPosition(): Long = 0L

    // on Activity onResume()...
    abstract fun onAppViewVisible()

    // on Activity onPause()...
    abstract fun onAppViewInVisible()

    open fun onPlayPresentationVideoAt(position: Int) {

    }

    abstract fun clearAllVideos()

    interface Callback {
        fun onError()
        fun onCompletion()
        fun onPlaylistChanged()
        fun onPlaylistReady()
        fun isPlayingNowPlaying(): Boolean
        fun isPlayingSearchVideos(): Boolean
        fun isPlayingPresentaion(): Boolean
        fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>)
        fun onClearVideos()
    }

    companion object {

        fun create(context: Context, route: MediaRouter.RouteInfo?): MMPlayer {
            val player: MMPlayer = MMDrawOnTopPlayer(context)
            player.connect(route)
            return player
        }
    }
}