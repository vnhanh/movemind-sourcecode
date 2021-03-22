package player.wellnesssolutions.com.base.customs.views

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import com.google.android.exoplayer2.ui.DefaultTimeBar

class CustomTimebar : DefaultTimeBar {
    var wasEnable = true

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (wasEnable)
            return super.onTouchEvent(event)
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (wasEnable)
            return super.onKeyDown(keyCode, event)
        return true
    }
}