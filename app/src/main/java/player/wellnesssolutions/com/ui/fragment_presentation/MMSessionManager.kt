package player.wellnesssolutions.com.ui.fragment_presentation

import android.app.PendingIntent
import android.net.Uri
import android.util.Log
import androidx.mediarouter.media.MediaItemStatus
import androidx.mediarouter.media.MediaSessionStatus
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

    fun hasSession(): Boolean {
        return mSessionValid
    }

    // Updates the playlist asynchronously, calls onPlaylistReady() when finished.
    private fun updateStatus() {
        checkPlayer()
        // update the statistics first, so that the stats string is valid when
        // onPlaylistReady() gets called in the end
        mPlayer!!.updateStatistics()

        when {
            mPlaylist.isEmpty() -> // If queue is empty, don't forget to call onPlaylistReady()!
                onPlaylistReady()
            mPlayer!!.isQueuingSupported() -> // If player supports queuing, get status of each item. Player is
                // responsible to call onPlaylistReady() after last getStatus().
                // (update=1 requires player to callback onPlaylistReady())
                for (i in mPlaylist.indices) {
                    val item = mPlaylist[i]
//                    mPlayer!!.getStatus(item, i == mPlaylist.size - 1 /* update */)
                }
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
        Log.d("LOG", this.javaClass.simpleName + " add() | mPlayer: $mPlayer | videos number: ${videos.size}")
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
//        mPlaylist.add(item)
//        mItemId++
//
//        // if player supports queuing, enqueue the item now
//        if (mPlayer?.isQueuingSupported() == true) {
//            mPlayer?.enqueue(item)
//        }
//        updatePlaybackState()
        return item
    }

    fun remove(iid: String): PlaylistItem? {
        checkPlayerAndSession()
        return removeItem(iid, MediaItemStatus.PLAYBACK_STATE_CANCELED)
    }

    fun seek(iid: String, pos: Long): PlaylistItem? {
//        if (DEBUG) {
//            log("seek: iid=$iid, pos=$pos")
//        }
//        checkPlayerAndSession()
//        // seeking on pending items are not yet supported
//        checkItemCurrent(iid)
//
//        val item = currentItem
//        if (pos != item!!.position) {
//            item.position = pos
//            if (item.state == MediaItemStatus.PLAYBACK_STATE_PLAYING || item.state == MediaItemStatus.PLAYBACK_STATE_PAUSED) {
//                mPlayer!!.seek(item)
//            }
//        }
        return null
    }

    fun getStatus(iid: String): PlaylistItem? {
        checkPlayerAndSession()

        // This should only be called for local player. Remote player is
        // asynchronous, need to use updateStatus() instead.
//        if (mPlayer?.isRemotePlayback() == true) {
//            throw IllegalStateException(
//                    "getStatus should not be called on remote player!")
//        }
//
//        for (item in mPlaylist) {
//            if (item.itemId == iid) {
//                if (item == currentItem) {
//                    mPlayer!!.getStatus(item, false)
//                }
//                return item
//            }
//        }
        return null
    }

    fun nextVideo() {
        mPlayer?.next()
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
        if (DEBUG) {
            log("pause")
        }
        mPaused = true
        updatePlaybackState()
    }

    fun resume() {
        if (DEBUG) {
            log("resume")
        }
        mPaused = false
        updatePlaybackState()
    }

    fun stop() {
        mPlayer!!.stop()
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

    fun endSession(): Boolean {
        if (mSessionValid) {
            mSessionValid = false
            return true
        }
        return false
    }

    fun getSessionStatus(sid: String?): MediaSessionStatus? {
        val sessionState = if (sid != null && sid.toInt() == mSessionId)
            MediaSessionStatus.SESSION_STATE_ACTIVE
        else
            MediaSessionStatus.SESSION_STATE_INVALIDATED

        return MediaSessionStatus.Builder(sessionState)
                .setQueuePaused(mPaused)
                .build()
    }


    // UnSuspend the playback manager. Restart playback on new player (route).
    // This will resume playback of current item. Furthermore, if the new player
    // supports queuing, playlist will be re-established on the remote player.
    fun unSuspend() {
//        if (DEBUG) {
//            log("unSuspend")
//        }
//        if (mPlayer?.isQueuingSupported() == true) {
//            for (item in mPlaylist) {
//                mPlayer?.enqueue(item)
//            }
//        }
        updatePlaybackState()
    }

    // Player.Callback
    override fun onError() {
        finishItem(true)
    }

    override fun onCompletion() {
        finishItem(false)
    }

    override fun onPlaylistChanged() {
        // Playlist has changed, update the cached playlist
        updateStatus()
    }

    override fun onPlaylistReady() {
        // Notify activity to update Ui
        if (mCallback != null) {
            mCallback!!.onStatusChanged()
        }
    }

    private fun log(message: String) {
        Log.d(TAG, "$mName: $message")
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

    private fun updatePlaybackState() {
//        mPlayer?.resume()
//        updateStatus()
    }

    private fun removeItem(iid: String, state: Int): PlaylistItem? {

        return null
    }

    private fun finishItem(error: Boolean) {
//        val item = currentItem
//        if (item != null) {
//            removeItem(item.itemId ?: "", if (error)
//                MediaItemStatus.PLAYBACK_STATE_ERROR
//            else
//                MediaItemStatus.PLAYBACK_STATE_FINISHED)
//            updateStatus()
//        }
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

    companion object {
        const val TAG = "MMSessionManager"
        private val DEBUG = true//Log.isLoggable(TAG, Log.DEBUG)
    }
}