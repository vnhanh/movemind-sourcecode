package player.wellnesssolutions.com.ui.fragment_presentation

import androidx.mediarouter.app.MediaRouteDiscoveryFragment
import androidx.mediarouter.media.MediaRouter

class MMDiscoveryFragment : MediaRouteDiscoveryFragment() {
    private var mCallback: MediaRouter.Callback? = null

    init {
        mCallback = null
    }

    fun setCallback(cb: MediaRouter.Callback) {
        mCallback = cb
    }

    override fun onCreateCallback(): MediaRouter.Callback? {
        return mCallback
    }

    override fun onPrepareCallbackFlags(): Int {
        // Add the CALLBACK_FLAG_UNFILTERED_EVENTS flag to ensure that we will
        // observe and log all route events including those that are for routes
        // that do not match our selector.  This is only for demonstration purposes
        // and should not be needed by most applications.
        return super.onPrepareCallbackFlags() or MediaRouter.CALLBACK_FLAG_UNFILTERED_EVENTS
    }

    companion object {
        const val TAG = "MMDiscoveryFragment"
    }
}