package player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

class MMVideoNowPlayingView : View {
    private var isTintBackground = false

    constructor(context: Context?) : super(context) {
        context?.let {
            init(null)
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        context?.let {
            init(attrs)
        }
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        context?.let {
            init(attrs)
        }
    }


    private fun init(attrs: AttributeSet?) {
        val strSecondaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
        isTintBackground = ta.getBoolean(R.styleable.MMAttributes_tintBackground, false)
        ta.recycle()

        if (strSecondaryColor.isNotEmpty()) {
            val shape = GradientDrawable()
            shape.shape = GradientDrawable.RECTANGLE
            shape.color = ColorStateList.valueOf(Color.parseColor(strSecondaryColor))
            this.background = shape
        }

        this.requestLayout()
    }
}