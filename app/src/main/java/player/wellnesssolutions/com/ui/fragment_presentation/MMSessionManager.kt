package player.wellnesssolutions.com.ui.fragment_presentation

import android.app.PendingIntent
import android.net.Uri
import player.wellnesssolutions.com.common.media_router.models.PlaylistItem
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_presentation.players.MMPlayer

class MMSessionManager(private val mName: String) : MMPlayer.Callback {
    private var mSessionId: Int = 0
    var mItemId: Int = 0
    var mPaused: Boolean = false
    private var mSessionValid: Boolean = false
    private var mPlayer: MMPlayer? = null
    private var mCallback: Callback? = null
    private var mPlaylist: MutableList<MMVideo> = ArrayList()

    val sessionId: String?
        get() = if (mSessionValid) mSessionId.toString() else null

    // Updates the playlist asynchronously, calls onPlaylistReady() when finished.
    private fun updateStatus() {
        checkPlayer()
        // update the statistics first, so that the stats string is valid when
        // onPlaylistReady() gets called in the end
        mPlayer?.updateStatistics()

        when {
            mPlaylist.isEmpty() -> // If queue is empty, don't forget to call onPlaylistReady()!
                onPlaylistReady()
//            mPlayer?.isQueuingSupported() == true -> // If player supports queuing, get status of each item. Player is
                // responsible to call onPlaylistReady() after last getStatus().
                // (update=1 requires player to callback onPlaylistReady())
//                for (i in mPlaylist.indices) {
//                    val item = mPlaylist[i]
//                }
            else -> {
            }// Otherwise, only need to get status for current item. Player is
            // responsible to call onPlaylistReady() when finished.
//                mPlayer!!.getStatus(currentItem!!, true /* update */)
        }
    }

    fun isPresentationAvailable(): Boolean {
        return mPlayer?.isScreenSupported() ?: false
    }

    fun add(mode: PlayMode, videos: ArrayList<*>, playedPosition: Long?) {
//        Log.d("LOG", this.javaClass.simpleName + " add() | mPlayer: $mPlayer | videos number: ${videos.size}")
        mPlayer?.play(mode = mode, item = videos, lastPosition = playedPosition ?: 0L)
    }

    override fun isPlayingNowPlaying(): Boolean = mPlayer?.isPlayingNowPlaying() ?: false

    override fun isPlayingSearchVideos(): Boolean = mPlayer?.isPlayingSearchVideos() ?: false

    override fun isPlayingPresentaion(): Boolean = mPlayer?.isPlayingPresentation() ?: false

    fun getPlayingMode(): PlayMode = mPlayer?.getMode() ?: PlayMode.ON_DEMAND

    fun onPlayPresentationVideoAt(position: Int) {
        mPlayer?.onPlayPresentationVideoAt(position)
    }

    override fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
        mCallback?.onUpdateVideos(nowPlayVideo = nowPlayVideo, comingUpVideos = comingUpVideos)
    }

    override fun onClearVideos() {
        mCallback?.onClearVideos()
    }

    @JvmOverloads
    fun add(uri: Uri, mime: String, receiver: PendingIntent? = null): PlaylistItem {
        // create new session if needed
        startSession()
        checkPlayerAndSession()

        // append new item with initial status PLAYBACK_STATE_PENDING
        val item = PlaylistItem(
                mSessionId.toString(), mItemId.toString(), uri, mime, receiver)
        return item
    }

    fun remove(): PlaylistItem? {
        checkPlayerAndSession()
        return removeItem()
    }

    fun getStatus(): PlaylistItem? {
        checkPlayerAndSession()
        return null
    }

    fun showNextVideo() {
        mPlayer?.showNext()
    }

    fun pauseOrResume(): Boolean {
        if (mPaused) {
            mPaused = false
            mPlayer?.resume()
        } else {
            mPaused = true
            mPlayer?.pause()
        }

        return mPaused
    }

    fun pause() {
        mPaused = true
    }

    fun resume() {
        mPaused = false
    }

    fun stop() {
        mPlayer?.stop()
        mPlaylist.clear()
        mPaused = false
        updateStatus()
    }

    fun startSession(): String? {
        if (!mSessionValid) {
            mSessionId++
            mItemId = 0
            mPaused = false
            mSessionValid = true
            return mSessionId.toString()
        }
        return null
    }

    // Player.Callback
    override fun onError() {

    }

    override fun onCompletion() {

    }

    override fun onPlaylistChanged() {
        // Playlist has changed, update the cached playlist
        updateStatus()
    }

    override fun onPlaylistReady() {
        // Notify activity to update Ui
        mCallback?.onStatusChanged()
    }

    private fun checkPlayer() {
        if (mPlayer == null) {
            throw IllegalStateException("Player not set!")
        }
    }

    private fun checkSession() {
        if (!mSessionValid) {
            throw IllegalStateException("Session not set!")
        }
    }

    private fun checkPlayerAndSession() {
        checkPlayer()
        checkSession()
    }

    private fun removeItem(): PlaylistItem? {
        return null
    }

    // set the Player that this playback manager will interact with
    fun setPlayer(player: MMPlayer) {
        mPlayer = player
        checkPlayer()
        mPlayer?.setCallback(this)
    }

    // provide a callback interface to tell the UI when significant state changes occur
    fun setCallback(callback: Callback) {
        mCallback = callback
    }

    override fun toString(): String {
        var result = "Media Queue: "
        if (!mPlaylist.isEmpty()) {
            for (item: MMVideo in mPlaylist) {
                result += "\n" + item.toString()
            }
        } else {
            result += "<empty>"
        }
        return result
    }

    fun getVideos(): ArrayList<MMVideo> = mPlayer?.getVideos() ?: ArrayList()

    fun clearAllVideos() {
        mPlayer?.clearAllVideos()
    }

    interface Callback {
        fun onStatusChanged()

        fun onItemChanged(item: PlaylistItem)

        fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>)
        fun onClearVideos()
    }
}