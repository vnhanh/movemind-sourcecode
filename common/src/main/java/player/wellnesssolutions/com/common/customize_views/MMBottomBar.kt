package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import java.util.*

class MMBottomBar : View {
    constructor(context: Context?) : super(context) {
        context?.let {
            checkData()
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        context?.let {
            checkData()
        }
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        context?.let {
            checkData()
        }
    }

    private fun checkData() {
        val strColor1 = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        val strColor2 = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        val strColor3 = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        if (strColor1.isEmpty() || strColor2.isEmpty() || strColor3.isEmpty()) return

        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.orientation = GradientDrawable.Orientation.TOP_BOTTOM
        shape.colors = Arrays.asList(Color.parseColor(strColor1), Color.parseColor(strColor2), Color.parseColor(strColor3)).toIntArray()

        this.background = shape
        this.requestLayout()
    }
}