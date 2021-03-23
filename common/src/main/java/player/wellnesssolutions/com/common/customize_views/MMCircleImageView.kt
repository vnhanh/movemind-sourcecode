package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.widget.ImageView
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.enums.StyleEnumInner
import player.wellnesssolutions.com.common.enums.StyleEnumSelect
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

class MMCircleImageView : ImageView {
    private var selectStyle: StyleEnumSelect? = StyleEnumSelect.UNSELECTED
    private var innerStyle: StyleEnumInner? = StyleEnumInner.CIRCLE_FIT_INNER
    private var unselectedStrokeColor = -1
    private var hasBgColor = false
    var bgColor = -1
    set(value) {
        hasBgColor = true
        field = value
    }

    private var strokeWidth = -1

    private var mShape: GradientDrawable?=null

    var mPadding = 0
        set(value) {
            field = value
            setPadding(mPadding, mPadding, mPadding, mPadding)
        }


    private val DEF_STROKE_COLOR = "#e7e7e7"

    fun setStrokeColor(color:Int){
        unselectedStrokeColor = color

        setupBackground()
    }

    fun setInnerStyle(style:StyleEnumInner){
        this.innerStyle = style

        if(strokeWidth < 0 || width == 0) return

        when(style){
            StyleEnumInner.CIRCLE_FIT_INNER -> {
                mPadding = strokeWidth
            }

            StyleEnumInner.SQUARE_INNER_CIRCLE -> {
                mPadding = getPaddingForSquareInnerCircle(width)
            }
        }

        setPadding(mPadding, mPadding, mPadding, mPadding)
    }

    constructor(context: Context?) : super(context){
        context?.also {
            init(null)
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        context?.also {
            init(attrs)
        }
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        context?.also {
            init(attrs)
        }
    }

    private fun init(attrs: AttributeSet?) {
        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.MMOptionView)

            selectStyle = StyleEnumSelect.getEnum(ta.getInt(R.styleable.MMOptionView_selectType, 0))
            innerStyle = StyleEnumInner.getEnum(ta.getInt(R.styleable.MMOptionView_innerType, 0))

            strokeWidth = ta.getDimensionPixelSize(R.styleable.MMOptionView_stroke, -1)
            unselectedStrokeColor = ta.getColor(R.styleable.MMOptionView_unselectedColor, Color.parseColor(DEF_STROKE_COLOR))

            hasBgColor = ta.hasValue(R.styleable.MMOptionView_bgColor)
            if(hasBgColor)
                bgColor = ta.getColor(R.styleable.MMOptionView_bgColor, Color.WHITE)

            ta.recycle()
        }

        setupBackground()
    }

    fun setupBackground() {
        if(selectStyle == null || innerStyle == null) return

        var shape = mShape

        if(shape == null){
            shape = GradientDrawable()
            shape.shape = GradientDrawable.OVAL
            mShape = shape
        }

        if(strokeWidth < 0) return

        val strPrimaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        val strSecondaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if (strSecondaryColor.isEmpty() || strPrimaryColor.isEmpty() || unselectedStrokeColor == -1) return

        when(selectStyle){
            StyleEnumSelect.UNSELECTED -> {
                shape.setStroke(strokeWidth, unselectedStrokeColor)
            }

            StyleEnumSelect.SELECTED -> {
                shape.setStroke(strokeWidth, Color.parseColor(strPrimaryColor))
            }

            else -> {}
        }

        when(innerStyle){
            StyleEnumInner.SQUARE_INNER_CIRCLE -> {
                if(hasBgColor)
                    shape.color = ColorStateList.valueOf(bgColor)
                else
                    shape.color = ColorStateList.valueOf(Color.parseColor(strSecondaryColor))
            }

            StyleEnumInner.CIRCLE_FIT_INNER -> {
                shape.color = ColorStateList.valueOf(Color.WHITE)
            }
        }

        this.background = shape
        this.requestLayout()
    }

    fun isSelect(isSelected: Boolean){
        this.selectStyle =
            when(isSelected){
                true -> StyleEnumSelect.SELECTED
                false -> StyleEnumSelect.UNSELECTED
            }

        setupBackground()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if(strokeWidth > 0 && mPadding > 0) return

        val strokeRatio = 0.065f

        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        strokeWidth = (parentWidth * strokeRatio).toInt()

        when(innerStyle){
            StyleEnumInner.SQUARE_INNER_CIRCLE -> {
                mPadding = getPaddingForSquareInnerCircle(parentWidth)
            }

            StyleEnumInner.CIRCLE_FIT_INNER -> {
                mPadding = strokeWidth
            }
        }

        setPadding(mPadding, mPadding, mPadding, mPadding)

        setupBackground()
    }

    private fun getPaddingForSquareInnerCircle(parentWidth:Int) : Int = parentWidth/2 - ((parentWidth/2 - strokeWidth) / 1.42f).toInt()

    fun changeBgColorOnClick() {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL

        shape.color = ColorStateList.valueOf(Color.LTGRAY)
        shape.alpha = 200
        this.background = LayerDrawable(arrayOf(mShape, shape))

        this.postDelayed({
            this.background = mShape
        }, 200L)
    }
}