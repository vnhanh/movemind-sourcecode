package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

class MMView : View {
    private var mShape: GradientDrawable? = null

    constructor(context: Context?) : super(context) {
        context?.let {
            init()
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        context?.let {
            init()
        }
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        context?.let {
            init()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val parentWidth = View.MeasureSpec.getSize(widthMeasureSpec)

        mShape?.apply {
            gradientRadius = parentWidth.toFloat() * 0.5f
        }
        background = mShape
        requestLayout()
    }

    private fun init() {
        val strColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if (!strColor.isEmpty()) {
            val colors = arrayOf(transparentColor("99", strColor),
                    transparentColor("60", strColor),
                    transparentColor("00", strColor)).toIntArray()
            mShape = GradientDrawable(GradientDrawable.Orientation.TL_BR, colors)
            mShape?.apply {
                shape = GradientDrawable.OVAL
                gradientType = GradientDrawable.RADIAL_GRADIENT
            }
        }
    }

    private fun transparentColor(transparent: String, color: String): Int {
        val string = String.format("#%s%s", transparent, color.trim('#'))
        return Color.parseColor(string)
    }
}
