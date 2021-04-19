package player.wellnesssolutions.com.ui.activity_main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * This BroadcastReceiver helps to transfer the data and actions between the Casting TV Service and the UI
 */
class CastingBroadcastReceiver : BroadcastReceiver() {
    companion object {
        const val ACTION_TV = "com.tma.movemind.TV_STATUS_CHANGE"
        const val ACTION_UI = "com.tma.movemind.UI_COMMAND"

        const val EXTRA_COOKIE_EXPIRED = "EXTRA_COOKIE_EXPIRED"
        const val EXTRA_LOADING_VIDEO_STATE_ON_TV = "EXTRA_LOADING_VIDEO_STATE_ON_TV"
        const val EXTRA_READY_VIDEO_STATE_ON_TV = "EXTRA_READY_VIDEO_STATE_ON_TV"
        const val EXTRA_ENDED_VIDEO_STATE_ON_TV = "EXTRA_ENDED_VIDEO_STATE_ON_TV"
        const val EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE = "EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE"
        const val EXTRA_DURATION_VIDEO_ON_TV = "EXTRA_DURATION_VIDEO_ON_TV"
        const val EXTRA_UPDATE_PROGRESS = "EXTRA_UPDATE_PROGRESS"
        const val EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV = "EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV"
        const val EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON = "EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON"

        const val EXTRA_PLAY_VIDEO = "EXTRA_PLAY_VIDEO"
        const val EXTRA_PAUSE_VIDEO = "EXTRA_PAUSE_VIDEO"

        private var mInstance: CastingBroadcastReceiver? = null

        fun getInstance(): CastingBroadcastReceiver {
            if (mInstance == null) {
                mInstance = CastingBroadcastReceiver()
            }
            return mInstance!!
        }

    }

    interface TVListener {
        fun onPlayerReady(isShowPlayPauseButton: Boolean = false, isPlaying: Boolean = false, currentPosition: Long = 0L, duration: Long) {}
        fun onUpdateProgress(isShowPlayPauseButton: Boolean = false, isPlaying: Boolean = true, position: Long) {}
        fun onCookieExpired() {}
        fun onUpdateEndedVideoState() {}
        fun onUpdateEndedVideoStateSchedule() {}
        fun onUpdateLoadingVideoState() {}
        fun onUpdateTranslatedVideoState() {}
    }

    interface UIListener {
        fun onReceivePlayVideoFromUI()
        fun onReceivePauseVideoFromUI()
    }

    private val mUIListeners: ArrayList<UIListener> = ArrayList()
    private val mTVListeners: ArrayList<TVListener> = ArrayList()

    fun addListener(listener: TVListener) {
        if(mTVListeners.contains(listener)) return
        mTVListeners.add(listener)
    }

    fun removeListener(listener: TVListener) {
        val iterator = mTVListeners.iterator()
        while (iterator.hasNext()){
            if(listener == iterator.next()){
                iterator.remove()
            }
        }
//        mTVListeners.remove(listener)
    }

    fun addListener(listener: UIListener) {
        mUIListeners.add(listener)
    }

    fun removeListener(listener: UIListener) {
        mUIListeners.remove(listener)
    }

    fun release() {
        mUIListeners.clear()
        mTVListeners.clear()
    }

    fun isRegistered(listener: TVListener): Boolean = mTVListeners.contains(listener)
    fun isRegistered(listener: UIListener): Boolean = mUIListeners.contains(listener)

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        when (intent.action) {
            ACTION_TV -> readTVIntent(intent)
            ACTION_UI -> readUIIntent(intent)
        }
    }

    private fun readTVIntent(intent: Intent) {
        when {
            intent.hasExtra(EXTRA_DURATION_VIDEO_ON_TV) -> onPlayerInitialized(intent)
            intent.hasExtra(EXTRA_UPDATE_PROGRESS) -> onUpdateVideoProgress(intent)
            intent.hasExtra(EXTRA_ENDED_VIDEO_STATE_ON_TV) -> onUpdateEndedVideoState()
            intent.hasExtra(EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE) -> onUpdateEndedVideoStateSchedule()
            intent.hasExtra(EXTRA_LOADING_VIDEO_STATE_ON_TV) -> onUpdateLoadingVideoState()
            intent.hasExtra(EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV) -> onUpdateTranslatedVideoState()
            intent.hasExtra(EXTRA_COOKIE_EXPIRED) -> onCookieExpired()
        }
    }

    private fun onUpdateEndedVideoState() {
        for (listener: TVListener in mTVListeners) {
            listener.onUpdateEndedVideoState()
        }

    }

    private fun onUpdateEndedVideoStateSchedule() {
        for (listener: TVListener in mTVListeners) {
            listener.onUpdateEndedVideoStateSchedule()
        }

    }

    private fun onUpdateLoadingVideoState() {
        for (listener: TVListener in mTVListeners) {
            listener.onUpdateLoadingVideoState()
        }

    }

    private fun onUpdateTranslatedVideoState() {
        for (listener: TVListener in mTVListeners) {
            listener.onUpdateTranslatedVideoState()
        }

    }

    private fun readUIIntent(intent: Intent) {
        if (intent.hasExtra(EXTRA_PLAY_VIDEO)) {
            onPlayVideoOnTV()
        } else if (intent.hasExtra(EXTRA_PAUSE_VIDEO)) {
            onPauseVideoOnTV()
        }
    }

    private fun onPlayVideoOnTV() {
        for (listener: UIListener in mUIListeners) {
            listener.onReceivePlayVideoFromUI()
        }
    }

    private fun onPauseVideoOnTV() {
        for (listener: UIListener in mUIListeners) {
            listener.onReceivePauseVideoFromUI()
        }

    }

    private fun onPlayerInitialized(intent: Intent) {
        val isShowPlayPauseButton: Boolean = intent.getBooleanExtra(EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON, false)
        val isPlaying: Boolean = intent.getBooleanExtra(EXTRA_READY_VIDEO_STATE_ON_TV, false)
        val progress: Long = intent.getLongExtra(EXTRA_UPDATE_PROGRESS, 0L)
        val duration: Long = intent.getLongExtra(EXTRA_DURATION_VIDEO_ON_TV, 0L)
        for (listener: TVListener in mTVListeners) {
            listener.onPlayerReady(isShowPlayPauseButton, isPlaying, progress, duration)
        }
    }

    private fun onUpdateVideoProgress(intent: Intent) {
        val isShowPlayPauseButton: Boolean = intent.getBooleanExtra(EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON, false)
        val isPlaying: Boolean = intent.getBooleanExtra(EXTRA_READY_VIDEO_STATE_ON_TV, false)
        val progress: Long = intent.getLongExtra(EXTRA_UPDATE_PROGRESS, 0L)
        for (listener: TVListener in mTVListeners) {
            listener.onUpdateProgress(isShowPlayPauseButton, isPlaying, progress)
        }
    }

    private fun onCookieExpired() {
        for (listener: TVListener in mTVListeners) {
            listener.onCookieExpired()
        }
    }
}