package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

class MMLogoView : ImageView {

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

    private fun init() {
        val strLogo = PreferenceHelper.getInstance(context).getString(ConstantPreference.SS_COMPANY_LOGO, "")
        val strPrimaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if(strLogo.isEmpty()) return

        val width = resources.getDimensionPixelSize(R.dimen.width_bottom_logo)
        val height = resources.getDimensionPixelSize(R.dimen.height_bottom_logo)

        Glide.with(context).load(strLogo).override(width, height).centerInside()
                .placeholder(R.drawable.bottom_logo).error(R.drawable.bottom_logo)
                .into(this)

        if (!strPrimaryColor.isEmpty()) {
            this.setColorFilter(Color.parseColor(strPrimaryColor), PorterDuff.Mode.MULTIPLY)
        }

        this.requestLayout()
    }
}