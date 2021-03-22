package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.view.View
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import java.lang.ref.WeakReference

class MonitorVideoAsyncTask(view: View?, presenter: INowPlayingConstruct.Presenter?, listener: Listener? = null) : Runnable {
    interface Listener {
        fun onUpdateVideoProgress(isPlaying: Boolean, position: Long)
    }

    private val mWeakView: WeakReference<View?> = WeakReference(view)
    private val mWeakPresenter: WeakReference<INowPlayingConstruct.Presenter?> = WeakReference(presenter)
    private val mWeakListener: WeakReference<Listener?> = WeakReference(listener)
    private var mPlayer: SimpleExoPlayer? = null
    private var mVideoId: Int? = null
    private var mVideoLength = 0L
    private var mIsStop = false

    init {
        mPlayer = presenter?.getPlayerManager()?.getPlayer()
        presenter?.getNowPlayVideo()?.also { video ->
            this.mVideoId = video.id
            this.mVideoLength = ((video.videoLength ?: 0f) * 1000).toLong()
        }
    }

    fun stopTask() {
        mIsStop = true
        mPlayer = null
    }

    override fun run() {
        mWeakView.get()?.also { view ->
            mWeakPresenter.get()?.also { presenter ->
                if (mIsStop) {
                    return@also
                }
                val player = mPlayer ?: return
                mWeakListener.get()?.also { listener ->
                    listener.onUpdateVideoProgress(player.playWhenReady, player.currentPosition)
                }

                if (player.playbackState == Player.STATE_ENDED || player.currentPosition >= mVideoLength) {
                    presenter.getNowPlayVideo()?.also {
                        if (it.id == mVideoId) {
                            mIsStop = true
                            presenter.onPlayerEnded(videoId = mVideoId)
                        }
                    }
                } else if (!mIsStop) {
                    view.postDelayed(this, 1000L)
                }
            }
        }
    }

    fun startTask() {
        mIsStop = false
        mWeakView.get()?.postDelayed(this, 1000L)
    }

    fun isStop(): Boolean = mIsStop
}