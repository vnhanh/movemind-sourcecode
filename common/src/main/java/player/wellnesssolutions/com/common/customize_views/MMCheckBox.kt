package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMCheckBox : CheckBox {
    private var mCheckedDrawable:Drawable?=null
    private var mUnCheckedDrawable:Drawable?=null

    constructor(context : Context?) : super(context) {
        context?.let {
            init()
        }
    }

    constructor(context : Context?, attrs : AttributeSet?) : super(context, attrs) {
        context?.let {
            init()
        }
    }

    constructor(context : Context?, attrs : AttributeSet?, defStyleAttr : Int) : super(context, attrs, defStyleAttr) {
        context?.let {
            init()
        }
    }


    private fun init() {
        var strPrimaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, "")
        if(strPrimaryColor.isEmpty()) strPrimaryColor = "#00c3b3"
        mCheckedDrawable = createCheckedDrawable(strPrimaryColor)
        mUnCheckedDrawable = createUnCheckedDrawable(strPrimaryColor)
        this.buttonTintList = ColorStateList.valueOf(Color.parseColor(strPrimaryColor))
        isChecked = isChecked
    }

//    override fun setChecked(checked : Boolean) {
//        super.setChecked(checked)
//        when(checked){
//            true -> this.background = mCheckedDrawable
//            false -> this.background = mUnCheckedDrawable
//        }
//    }

    private fun createCheckedDrawable(colorStr : String) : Drawable {
        val bgShape = GradientDrawable().also {
            it.shape = GradientDrawable.RECTANGLE
            it.cornerRadius = this.resources.getDimensionPixelSize(R.dimen.corner_4dp).toFloat()
            it.setStroke(this.resources.getDimensionPixelSize(R.dimen.stroke_1dp), ColorStateList.valueOf(Color.parseColor(colorStr)))
            it.color = ColorStateList.valueOf(Color.WHITE)
        }

        val checkIconShape =  GradientDrawable().also {
            ContextCompat.getDrawable(this.context, R.drawable.ic_check_white_24dp)?.also {drawable ->

                val canvas = Canvas()
                canvas.drawColor(Color.parseColor(colorStr))
                drawable.draw(canvas)
                it.draw(canvas)
            }
        }

        return LayerDrawable(arrayOf(bgShape, checkIconShape))
    }

    private fun createUnCheckedDrawable(colorStr : String) : Drawable {
        return GradientDrawable().also {
            it.shape = GradientDrawable.RECTANGLE
            it.cornerRadius = this.resources.getDimensionPixelSize(R.dimen.corner_4dp).toFloat()
            it.setStroke(this.resources.getDimensionPixelSize(R.dimen.stroke_1dp), ColorStateList.valueOf(Color.parseColor(colorStr)))
            it.color = ColorStateList.valueOf(Color.WHITE)
        }
    }
}