package player.wellnesssolutions.com.ui.fragment_presentation.players

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import android.os.SystemClock
import android.view.Surface
import android.view.SurfaceHolder
import androidx.mediarouter.media.MediaItemStatus
import androidx.mediarouter.media.MediaRouter
import com.google.firebase.crashlytics.FirebaseCrashlytics
import player.wellnesssolutions.com.common.media_router.models.PlaylistItem
import java.io.IOException
import java.lang.RuntimeException

abstract class MMLocalPlayer(protected val context: Context) : MMPlayer(),
        MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener {
    private val mHandler = Handler()
    private var mediaPlayer: MediaPlayer? = null

    //    private var mediaPlayer:  SimpleExoPlayer? = null
    var mState = STATE_IDLE
    private var mSeekToPos: Int = 0
    protected var videoWidth: Int = 0
        private set
    protected var videoHeight: Int = 0
        private set
    private var mSurface: Surface? = null
    private var mSurfaceHolder: SurfaceHolder? = null

    override fun isQueuingSupported(): Boolean {
        return false
    }

    override fun isRemotePlayback(): Boolean {
        return false
    }

    init {
        // reset media player
        reset()
    }

    override fun connect(route: MediaRouter.RouteInfo?) {

    }

    override fun release() {

        // release media player
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    // Player
    override fun play(item: PlaylistItem) {
        reset()
        mSeekToPos = item.position.toInt()
        try {
            mediaPlayer!!.setDataSource(context, item.uri!!)
            mediaPlayer!!.prepareAsync()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("casting-local player: illegal state error")
        } catch (e: IOException) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("casting-local player: IO error")
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("casting-local player: ILlegal error")
        } catch (e: SecurityException) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("casting-local player: security error")
        }

        if (item.state == MediaItemStatus.PLAYBACK_STATE_PLAYING) {
            resume()
        } else {
            pause()
        }
    }

    override fun seek(item: PlaylistItem) {
        val pos = item.position.toInt()
        if (mState == STATE_PLAYING || mState == STATE_PAUSED) {
            mediaPlayer!!.seekTo(pos)
            mSeekToPos = pos
        } else if (mState == STATE_IDLE || mState == STATE_PLAY_PENDING) {
            // Seek before onPrepared() arrives,
            // need to performed delayed seek in onPrepared()
            mSeekToPos = pos
        }
    }

    override fun getStatus(item: PlaylistItem, update: Boolean) {
        if (mState == STATE_PLAYING || mState == STATE_PAUSED) {
            // use mSeekToPos if we're currently seeking (mSeekToPos is reset
            // when seeking is completed)
            item.duration = mediaPlayer!!.duration.toLong()
            item.position = if (mSeekToPos > 0)
                mSeekToPos.toLong()
            else
                mediaPlayer!!.currentPosition.toLong()
            item.timestamp = SystemClock.elapsedRealtime()
        }
        if (update && mCallback != null) {
            mCallback!!.onPlaylistReady()
        }
    }

    override fun pause() {
        if (mState == STATE_PLAYING) {
            mediaPlayer!!.pause()
            mState = STATE_PAUSED
        }
    }

    override fun resume() {
        if (mState == STATE_READY || mState == STATE_PAUSED) {
            mediaPlayer!!.start()
            mState = STATE_PLAYING
        } else if (mState == STATE_IDLE) {
            mState = STATE_PLAY_PENDING
        }
    }

    override fun stop() {
        if (mState == STATE_PLAYING || mState == STATE_PAUSED) {
            mediaPlayer!!.stop()
            mState = STATE_IDLE
        }
    }

    override fun enqueue(item: PlaylistItem) {
        throw UnsupportedOperationException("LocalPlayer doesn't support enqueue!")
    }

    override fun remove(itemId: String): PlaylistItem {
        throw UnsupportedOperationException("LocalPlayer doesn't support remove!")
    }

    //MediaPlayer Listeners
    override fun onPrepared(mp: MediaPlayer) {
        mHandler.post {
            if (mState == STATE_IDLE) {
                mState = STATE_READY
                updateVideoRect()
            } else if (mState == STATE_PLAY_PENDING) {
                mState = STATE_PLAYING
                updateVideoRect()
                if (mSeekToPos > 0) {
                    mediaPlayer!!.seekTo(mSeekToPos)
                }
                mediaPlayer!!.start()
            }
            mCallback?.onPlaylistChanged()
        }
    }

    override fun onCompletion(mp: MediaPlayer) {
        mHandler.post {
            mCallback?.onCompletion()
        }
    }

    override fun onError(mp: MediaPlayer, what: Int, extra: Int): Boolean {
        mHandler.post {
            mCallback?.onError()
        }
        // return true so that onCompletion is not called
        return true
    }

    override fun onSeekComplete(mp: MediaPlayer) {
        mHandler.post {
            mSeekToPos = 0
            mCallback?.onPlaylistChanged()
        }
    }

    protected fun setSurface(surface: Surface) {
        mSurface = surface
        mSurfaceHolder = null
        updateSurface()
    }

    protected fun setSurface(surfaceHolder: SurfaceHolder?) {
        mSurface = null
        mSurfaceHolder = surfaceHolder
        updateSurface()
    }

    protected fun removeSurface(surfaceHolder: SurfaceHolder) {
        if (surfaceHolder === mSurfaceHolder) {
            setSurface(null as SurfaceHolder?)
        }
    }

    private fun updateSurface() {
        if (mediaPlayer == null) {
            // just return if media player is already gone
            return
        }
        when {
            mSurface != null -> ICSMediaPlayer.setSurface(mediaPlayer!!, mSurface!!)
            mSurfaceHolder != null -> mediaPlayer!!.setDisplay(mSurfaceHolder)
            else -> mediaPlayer!!.setDisplay(null)
        }
    }

    protected abstract fun updateSize()

    private fun reset() {
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer!!.release()
            mediaPlayer = null
        }
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setOnPreparedListener(this)
        mediaPlayer!!.setOnCompletionListener(this)
        mediaPlayer!!.setOnErrorListener(this)
        mediaPlayer!!.setOnSeekCompleteListener(this)
        updateSurface()
        mState = STATE_IDLE
        mSeekToPos = 0
    }

    private fun updateVideoRect() {
        if (mState != STATE_IDLE && mState != STATE_PLAY_PENDING) {
            val width = mediaPlayer!!.videoWidth
            val height = mediaPlayer!!.videoHeight
            if (width > 0 && height > 0) {
                videoWidth = width
                videoHeight = height
                updateSize()
            } else {
                videoHeight = 0
                videoWidth = videoHeight
            }
        }
    }

    private object ICSMediaPlayer {
        fun setSurface(player: MediaPlayer, surface: Surface) {
            player.setSurface(surface)
        }
    }

    companion object {
        const val TAG = "MMLocalPlayer"

        const val STATE_IDLE = 0
        const val STATE_PLAY_PENDING = 1
        const val STATE_READY = 2
        const val STATE_PLAYING = 3
        const val STATE_PAUSED = 4
    }
}