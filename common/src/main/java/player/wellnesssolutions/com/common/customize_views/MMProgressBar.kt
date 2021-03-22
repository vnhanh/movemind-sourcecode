package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ProgressBar
import androidx.core.graphics.ColorUtils
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMProgressBar : ProgressBar {
    private var mScaleY = 1f

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

    private fun init(attrs : AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
        mScaleY = ta.getFloat(R.styleable.MMAttributes_scaleY, 1f)
        ta.recycle()

        var primaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        var secondaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        if(secondaryColor.isEmpty()) {
            secondaryColor = Constant.DEF_SECONDARY_COLOR
        }
        if (primaryColor.isEmpty()) {
            primaryColor = Constant.DEF_PRIMARY_COLOR
        }
        val indeterminateColor = ColorUtils.blendARGB(Color.parseColor(secondaryColor), Color.WHITE, 0.2f)
        this.indeterminateTintList = ColorStateList.valueOf(indeterminateColor)

        this.progressBackgroundTintList = ColorStateList.valueOf(Color.parseColor(primaryColor))
        this.secondaryProgressTintList = ColorStateList.valueOf(Color.parseColor(primaryColor))
        this.backgroundTintList = ColorStateList.valueOf(Color.parseColor(primaryColor))

        this.scaleY = mScaleY

        this.requestLayout()
    }
}