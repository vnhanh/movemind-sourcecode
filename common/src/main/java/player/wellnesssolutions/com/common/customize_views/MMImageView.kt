package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.ImageView
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMImageView : ImageView {
    private var isTintBackground = false
    private var deactiveBackground = Color.GRAY

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
        val strSecondaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
        isTintBackground = ta.getBoolean(R.styleable.MMAttributes_tintBackground, false)
        deactiveBackground = ta.getColor(R.styleable.MMAttributes_deactiveBackground, Color.GRAY)
        ta.recycle()

        if (!strSecondaryColor.isEmpty()) {
            if (isTintBackground) {
                activeBackground(strSecondaryColor)
            }else {
                this.imageTintList = ColorStateList.valueOf(Color.parseColor(strSecondaryColor))
            }
        }

        this.requestLayout()
    }

    private fun activeBackground(strPrimaryColor: String) {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.color = ColorStateList.valueOf(Color.parseColor(strPrimaryColor))
        this.background = shape
    }

    private fun activeBackground() {
        val strSecondaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.color = ColorStateList.valueOf(Color.parseColor(strSecondaryColor))
        this.background = shape
    }

    private fun deactiveBackground() {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.color = ColorStateList.valueOf(deactiveBackground)
        this.background = shape
    }

    fun setActive(isActive:Boolean){
        when(isActive){
            true -> activeBackground()
            false -> deactiveBackground()
        }
    }
}