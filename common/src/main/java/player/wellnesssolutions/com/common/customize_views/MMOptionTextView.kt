package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.content.ContextCompat
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.enums.StyleEnumSelect
import player.wellnesssolutions.com.common.enums.StyleEnumShape
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMOptionTextView : TextView {
    private var selectStyle: StyleEnumSelect? = StyleEnumSelect.UNSELECTED
    private var shapeStyle: StyleEnumShape? = StyleEnumShape.RECTANGLE
    private var cornerRadius: Float = 0f
    private var strokeWidth = 0
    private var unselectedTextColor = 0
    private var hasBgColor = false
    private var bgColor = Color.WHITE

    private var mShape: GradientDrawable? = null

    var mPadding = 0


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
        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.MMOptionView)
            selectStyle = StyleEnumSelect.getEnum(ta.getInt(R.styleable.MMOptionView_selectType, 0))
            shapeStyle = StyleEnumShape.getEnum(ta.getInt(R.styleable.MMOptionView_shapeType, 0))

            strokeWidth = ta.getDimensionPixelSize(R.styleable.MMOptionView_stroke, -1)
            cornerRadius = ta.getDimensionPixelSize(R.styleable.MMOptionView_cornerRad, 0).toFloat()
            unselectedTextColor = ta.getColor(R.styleable.MMOptionView_unselectedColor, ContextCompat.getColor(context, android.R.color.white))

            hasBgColor = ta.hasValue(R.styleable.MMOptionView_bgColor)
            bgColor = ta.getColor(R.styleable.MMOptionView_bgColor, Color.WHITE)

            ta.getString(R.styleable.MMOptionView_cusFont)?.also { fontName ->
                if (!fontName.isEmpty()) {
                    val tf = TypefaceUtil.getTypeface(context, fontName)
                    setTypeface(tf)
                }
            }

            ta.recycle()
        }

        setupBackground()
    }

    fun setSelect(isSelected: Boolean) {
        selectStyle =
                when (isSelected) {
                    true -> StyleEnumSelect.SELECTED
                    else -> StyleEnumSelect.UNSELECTED
                }

        setupBackground()
    }

    private fun setupBackground() {
        if (selectStyle == null || shapeStyle == null) return

        if (strokeWidth < 0) return

        var shape = mShape
        if (shape == null) {
            shape = GradientDrawable()
            shape.shape =
                    when (shapeStyle) {
                        StyleEnumShape.CIRCLE -> GradientDrawable.OVAL
                        else -> GradientDrawable.RECTANGLE
                    }

            if (shapeStyle == StyleEnumShape.RECTANGLE) {
                shape.cornerRadius = cornerRadius
            }
        }

        val strSecondaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        val strPrimaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)

        if (strSecondaryColor.isEmpty() || strPrimaryColor.isEmpty()) return

        if (!hasBgColor)
            bgColor = Color.parseColor(strSecondaryColor)

        shape.color = if (isChangeBG) {
            var color = "#d7d7d7"
            when (colorBand) {
                1 -> color = "#00C3B3"
                2 -> color = "#FFEB3B"
            }
            ColorStateList.valueOf(Color.parseColor(color))

        } else {
            ColorStateList.valueOf(bgColor)
        }

        when (selectStyle) {
            StyleEnumSelect.UNSELECTED -> {
                this.setTextColor(unselectedTextColor)
                this.setTypeface(null, Typeface.NORMAL)

                shape.setStroke(strokeWidth, bgColor)
            }

            StyleEnumSelect.SELECTED -> {
                this.setTextColor(Color.parseColor(strPrimaryColor))
                this.setTypeface(null, Typeface.BOLD)

                shape.setStroke(strokeWidth, Color.parseColor(strPrimaryColor))
            }

            else -> {

                return
            }
        }
        mShape = shape
        this.background = shape
        this.requestLayout()
    }

    companion object {
        var isChangeBG = false
        var colorBand = 1
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (strokeWidth > 0 && mPadding > 0) return

        shapeStyle?.also {
            if (it == StyleEnumShape.CIRCLE) {
                val strokeRatio = 0.065f
                val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
                strokeWidth = (parentWidth * strokeRatio).toInt()

                mPadding = strokeWidth

                setupBackground()
            }
        }
    }

    fun changeBgColorOnClick() {
        val coverDrawable = GradientDrawable().also {
            it.shape = GradientDrawable.OVAL
            it.alpha = 200
            it.color = ColorStateList.valueOf(Color.LTGRAY)
        }
        this.background = LayerDrawable(arrayOf(mShape, coverDrawable))

        this.postDelayed({
            this.background = mShape
        }, 200L)
    }

}