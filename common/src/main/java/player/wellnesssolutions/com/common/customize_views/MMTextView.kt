package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.InsetDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil
import player.wellnesssolutions.com.common.utils.DrawableUtils
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.enums.StyleEnum
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

open class MMTextView : TextView {
    private var style: StyleEnum? = StyleEnum.NORMAL
    private var cornerRad = 2f
    private var strokeWidth = 2
    private var unactivedColor = Color.GRAY
    private var isActived = false
    private var tbPad = 0 // padding top and bottom
    private var lrPad = 0 // padding left and right

    constructor(context: Context?, style:StyleEnum) : super(context){
        context?.let {
            this.style = style
            init(null)
        }
    }

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
        val strPrimaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        val strSecondaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if (strSecondaryColor.isEmpty() || strPrimaryColor.isEmpty()) return

        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
            style = StyleEnum.getEnum(ta.getInt(R.styleable.MMAttributes_style, 0))
            ta.getDimensionPixelSize(R.styleable.MMAttributes_cornerRadius, 2).also {
                cornerRad = it.toFloat()
            }
            strokeWidth = ta.getDimensionPixelSize(R.styleable.MMAttributes_strokeWidth, 2)
            unactivedColor = ta.getColor(R.styleable.MMAttributes_unactivedColor, Color.GRAY)

            ta.getString(R.styleable.MMAttributes_customFont)?.also { fontName ->
                if(!fontName.isEmpty()){
                    val tf = TypefaceUtil.getTypeface(context, fontName)
                    typeface = tf
                }
            }

            tbPad = ta.getDimensionPixelSize(R.styleable.MMAttributes_padTB, 0)
            lrPad = ta.getDimensionPixelSize(R.styleable.MMAttributes_padLR, 0)

            ta.recycle()
        }

        when (style) {
            StyleEnum.NORMAL -> {
                this.setTextColor(Color.parseColor(strSecondaryColor))
            }
            StyleEnum.BORDER -> {
                val shape = GradientDrawable()
                shape.shape = GradientDrawable.RECTANGLE
                shape.cornerRadius = cornerRad
                shape.setStroke(strokeWidth, Color.parseColor(strSecondaryColor))
                this.background = shape
            }
            StyleEnum.BORDER_HALF -> {
                generateBorder(strSecondaryColor, strPrimaryColor)
            }
            StyleEnum.BORDER_ACTIVED -> {
                generateBorderDeactivated()
            }
            StyleEnum.BACKGROUND -> {
                when (Build.VERSION.SDK_INT) {
                    Build.VERSION_CODES.LOLLIPOP ->
                        this.background = DrawableUtils.getBackgroundPrimary(strSecondaryColor, context)
                    else ->
                        this.backgroundTintList = ColorStateList.valueOf(Color.parseColor(strSecondaryColor))
                }

            }
            StyleEnum.BTN_COLOR -> {
                this.setTextColor(Color.parseColor(strPrimaryColor))
            }
            else -> {
            }
        }
        this.requestLayout()
    }

    private fun generateBorder(primaryColor: String, textColor: String) {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.color = ColorStateList.valueOf(Color.parseColor(primaryColor))
        shape.cornerRadii = arrayOf(0f, 0f, cornerRad, cornerRad, cornerRad, cornerRad, 0f, 0f).toFloatArray()

        val shapeShadow = GradientDrawable()
        shapeShadow.shape = GradientDrawable.RECTANGLE
        shapeShadow.color = ColorStateList.valueOf(Color.parseColor(textColor))
        shapeShadow.cornerRadii = arrayOf(0f, 0f, cornerRad, cornerRad, cornerRad, cornerRad, 0f, 0f).toFloatArray()


        val inset = InsetDrawable(shape, 0, 0, 0, 4)
        val layer = LayerDrawable(arrayOf(shapeShadow, inset))

        this.background = layer
        this.setPadding(lrPad, tbPad, lrPad, tbPad)
        this.setTextColor(Color.parseColor(textColor))
    }

    fun changeColorOnClick() {
        if(style == StyleEnum.BTN_COLOR){
            val strBtnColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
            if(strBtnColor.isEmpty()) return
            this.setBackgroundColor(Color.parseColor(strBtnColor))
            this.setTextColor(Color.WHITE)

            this.postDelayed({
                this.setBackgroundColor(Color.TRANSPARENT)
                this.setTextColor(Color.parseColor(strBtnColor))
            }, 200L)
        }
    }

    fun active() {
        if(isActived) return
        isActived = true
        generateBorderActive()
    }

    fun deactivate(){
        if(!isActived) return
        isActived = false
        generateBorderDeactivated()
    }

    fun isActive() : Boolean = isActived

    private fun generateBorderActive(){
        val primaryColor = Color.parseColor(PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR))
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = cornerRad
        shape.setStroke(strokeWidth, primaryColor)
        this.background = shape
        this.setTextColor(primaryColor)
    }

    private fun generateBorderDeactivated(){
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = cornerRad
        shape.setStroke(strokeWidth, unactivedColor)
        this.background = shape
        this.setTextColor(unactivedColor)
    }
}