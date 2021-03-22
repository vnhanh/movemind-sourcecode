package player.wellnesssolutions.com.base.common.play_video

import java.util.*

class CustomTimer : Timer() {
    private var mIsCancel = true

    override fun schedule(task: TimerTask?, delay: Long) {
        super.schedule(task, delay)
        mIsCancel = false
    }

    override fun schedule(task: TimerTask?, delay: Long, period: Long) {
        super.schedule(task, delay, period)
        mIsCancel = false
    }

    override fun cancel() {
        super.cancel()
        mIsCancel = true
    }

    fun isCancel(): Boolean = mIsCancel
}