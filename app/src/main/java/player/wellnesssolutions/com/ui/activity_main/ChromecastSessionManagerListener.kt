package player.wellnesssolutions.com.ui.activity_main

import android.content.Context
import com.google.android.gms.cast.framework.*
import java.lang.ref.WeakReference

class ChromecastSessionManagerListener(listener: IListener) : SessionManagerListener<CastSession> {
    private var mWeakListener = WeakReference(listener)
    private lateinit var mCastContext: CastContext
    private var mSessionManager: SessionManager? = null
    private var mCastStateListener: CastStateListener? = null
    private var mCastSession: CastSession? = null

    fun onCreate(context: Context) {
        mCastContext = CastContext.getSharedInstance(context)

        mCastStateListener = CastStateListener { newState ->
            if (newState != CastState.NO_DEVICES_AVAILABLE) {
                mWeakListener.get()?.onSessionStarted()
            }
        }

        mSessionManager = mCastContext.sessionManager
    }

    fun onSetup(context: Context) {
        mCastContext.addCastStateListener(mCastStateListener)
        mCastContext.sessionManager.addSessionManagerListener(this, CastSession::class.java)

        if (mCastSession == null) {
            mCastSession = CastContext.getSharedInstance(context).sessionManager?.currentCastSession
        }
    }

    fun onUnInstall() {
        mCastContext.removeCastStateListener(mCastStateListener)
        mSessionManager?.removeSessionManagerListener(this, CastSession::class.java)
    }

    override fun onSessionStarted(session: CastSession?, sessionId: String?) {
        mCastSession = session
        mWeakListener.get()?.onSessionStarted()
    }

    override fun onSessionResumed(session: CastSession?, p1: Boolean) {
        mCastSession = session
        mWeakListener.get()?.onSessionStarted()
    }

    override fun onSessionEnded(session: CastSession?, p1: Int) {
        if (session == mCastSession) {
            mCastSession = null
        }
        mWeakListener.get()?.onSessionEnd()
    }

    override fun onSessionResumeFailed(session: CastSession?, p1: Int) {
    }

    override fun onSessionSuspended(session: CastSession?, p1: Int) {
    }

    override fun onSessionStarting(session: CastSession?) {
    }

    override fun onSessionResuming(session: CastSession?, p1: String?) {
    }

    override fun onSessionEnding(session: CastSession?) {
    }

    override fun onSessionStartFailed(session: CastSession?, p1: Int) {
    }

    interface IListener {
        fun onSessionStarted()

        fun onSessionEnd()
    }
}