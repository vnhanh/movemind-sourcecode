package player.wellnesssolutions.com.ui.fragment_presentation.players

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.ViewGroup
import androidx.mediarouter.media.MediaRouter
import com.google.firebase.crashlytics.FirebaseCrashlytics
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.MMPresentationBinder
import player.wellnesssolutions.com.services.MMPresentationService

class MMDrawOnTopPlayer(context: Context) : MMLocalPlayer(context), SurfaceHolder.Callback {
    private var mRoute: MediaRouter.RouteInfo? = null
    private var mPresentation: MMPresentationBinder? = null

    private var mService: MMPresentationService? = null
    private var mBound: Boolean = false
    private var modePlay = PlayMode.UNKNOWN
    private val videosBuffer = ArrayList<MMVideo>()
    private var lastPosition = 0L

    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            mPresentation = service as MMPresentationBinder
            Log.d("LOG", "MMDrawOnTopPlayer - onServiceConnected() | inited mPresentation")
            mPresentation?.addCallback(mPresentationCallback)

            mService = mPresentation!!.getService()
            mBound = true

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.presentation_now_playing, null) as ViewGroup
            mPresentation?.setContentView(view)
            mRoute?.let {
                mPresentation?.setRouter(it)
            }
            mPresentation?.onCreate()

            if (modePlay != PlayMode.UNKNOWN && videosBuffer.size > 0) {
                play(modePlay, videosBuffer, lastPosition)
            }
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    private val mPresentationCallback: MMPresentationBinder.Callback = object : MMPresentationBinder.Callback {
        override fun onClearVideos() {
            mCallback?.onClearVideos()
        }

        override fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
            mCallback?.onUpdateVideos(nowPlayVideo, comingUpVideos)
        }
    }

    override fun isScreenSupported(): Boolean {
        return mPresentation != null
    }

    override fun onAppViewVisible() {
        mPresentation?.onAppViewVisible()
    }

    override fun onAppViewInVisible() {
        mPresentation?.onAppViewInVisible()
    }

    override fun play(mode: PlayMode, item: ArrayList<*>, lastPosition: Long) {
        Log.d("LOG", this.javaClass.simpleName + " play()")
        if (ParameterUtils.isClearVideoOnPresentation) {
            if (mPresentation != null) {
                Log.d("LOG", this.javaClass.simpleName + " play() | is clear videos | call setupPlayVideo() on TV | mPresentation: $mPresentation")
                mPresentation?.setupPlayVideo(mode, item as ArrayList<MMVideo>, lastPosition)
                modePlay = PlayMode.UNKNOWN
                this.lastPosition = 0L
            } else {
                modePlay = mode
                videosBuffer.addAll(item as ArrayList<MMVideo>)
                this.lastPosition = lastPosition
//                Log.d("LOG", this.javaClass.simpleName + " play() | videosBuffer size: ${videosBuffer.size} | thread: ${Thread.currentThread()}")
            }
        }
    }

    override fun isPlayingNowPlaying(): Boolean = mPresentation?.isPlayingSchedule() ?: false

    override fun isPlayingSearchVideos(): Boolean = mPresentation?.isPlayingSearchVideos() ?: false

    override fun isPlayingPresentation(): Boolean = mPresentation?.isPlaying() ?: false

    override fun connect(route: MediaRouter.RouteInfo?) {
        super.connect(route)
        mRoute = route
    }

    private fun startService() {
        if (mBound || mService != null) return
        context.startService(Intent(context, MMPresentationService::class.java).also { intent ->
            context.bindService(intent, connection, Context.BIND_AUTO_CREATE)
            mBound = true
        })
    }

    private fun stopService() {
        try {
            context.unbindService(connection)
            context.stopService(Intent(context, MMPresentationService::class.java))
        } catch (ex: Exception) {
            ex.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(ex)
            FirebaseCrashlytics.getInstance().log("casting-stop service: erro")
        }
        mBound = false
        mService = null
    }

    override fun release() {
        // dismiss presentation display
        mPresentation?.onDestroy()
        mPresentation?.mDisplay = null
        mPresentation = null

        stopService()
        super.release()
    }

    override fun updatePresentation(route: MediaRouter.RouteInfo) {
        mRoute = route
        // Get the current route and its presentation display.
        val presentationDisplay = mRoute?.presentationDisplay

        // Dismiss the current presentation if the display has changed.
        if (mPresentation != null && mPresentation?.mDisplay != presentationDisplay) {
            mPresentation?.onDestroy()
            mPresentation?.mDisplay = null
            mPresentation = null
            stopService()
        }

        // Show a new presentation if needed.
        if (mPresentation == null && presentationDisplay != null) {
            startService()
        }
    }

    override fun resume() {
        mPresentation?.resume()
    }

    override fun pause() {
        mPresentation?.pause()
    }

    override fun next() {
        mPresentation?.nextVideo()
    }

    override fun showNext() {
        mPresentation?.showNextVideo()
    }

    // SurfaceHolder.Callback
    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {
        setSurface(holder)
    }

    override fun updateSize() {

    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        setSurface(holder)
        updateSize()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        removeSurface(holder)
    }


    override fun getMode(): PlayMode? = mPresentation?.getPlayMode()

    override fun getVideos(): ArrayList<MMVideo> = mPresentation?.getVideos()
            ?: ArrayList<MMVideo>()

    override fun getLastPosition(): Long = mPresentation?.getCurrentVideoPosition() ?: 0L

    override fun onPlayPresentationVideoAt(position: Int) {
        mPresentation?.onPlayPresentationVideoAt(position)
    }

    override fun clearAllVideos() {
        mPresentation?.clearAllVideos()
    }

    companion object {
        const val TAG = "MMDrawOnTopPlayer"
    }
}