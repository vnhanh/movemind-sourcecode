package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.widget.Button
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMButton : Button {
    private var mShape: GradientDrawable? = null
    private var mDisableShape : GradientDrawable? = null
    private var isBorder: Boolean = false
    private var isCircle: Boolean = false
    private var mIsEnable = true
    private var mDisableTextColorStr = "#D3D3D3"
    private var mDisableBgColorStr = "#F1F1F1"
    private var isChangeBG = false
    private var bgColorString = ""
    companion object {
        var isClickToNowPlaying = false
    }


    constructor(context: Context?, isBorder: Boolean) : super(context) {
        context?.let {
            this.isBorder = isBorder
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
        val strPrimaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        val strTextColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if (strPrimaryColor.isEmpty() || strTextColor.isEmpty()) return

        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
            isBorder = ta.getBoolean(R.styleable.MMAttributes_border, false)
            isCircle = ta.getBoolean(R.styleable.MMAttributes_circle, false)
            mIsEnable = ta.getBoolean(R.styleable.MMAttributes_isEnable, true)
            bgColorString = ta.getString(R.styleable.MMAttributes_backGroundColorChange)?: "#ffffff"
            isChangeBG = ta.getBoolean(R.styleable.MMAttributes_isChangeBackGround,false)
            ta.recycle()
        }

        if (!isCircle || !isBorder) {
            mShape = GradientDrawable()
            mShape!!.shape = when (isCircle) {
                true -> GradientDrawable.OVAL
                else -> {
                    mShape!!.cornerRadius = context.resources.getDimension(R.dimen.radius_button)
                    GradientDrawable.RECTANGLE
                }
            }
            if (isChangeBG) {
                mShape!!.color = ColorStateList.valueOf(Color.parseColor(bgColorString))
                //this.setTextColor(Color.parseColor(strTextColor))
            } else {
                when (isBorder) {
                    true -> {
                        mShape!!.color = ColorStateList.valueOf(Color.parseColor(strPrimaryColor))
//                    mShape!!.setStroke(context.resources.getDimension(R.dimen.width_stroke_button).toInt(), Color.parseColor(strPrimaryColor))
                        this.setTextColor(Color.parseColor(strTextColor))

                    }
                    else -> {
                        mShape!!.color = ColorStateList.valueOf(Color.parseColor(strTextColor))
                        this.setTextColor(Color.parseColor(strPrimaryColor))
                    }
                }
            }
            this.background = mShape

            this.includeFontPadding = false

            this.requestLayout()

        } else {
            mShape = GradientDrawable().also {
                it.shape = GradientDrawable.OVAL
                it.color = ColorStateList.valueOf(Color.parseColor(strTextColor))
            }

            mDisableShape = GradientDrawable().also {
                it.shape = GradientDrawable.OVAL
                it.color = ColorStateList.valueOf(Color.parseColor(mDisableBgColorStr))
            }

            setTextColor()
        }
    }

    private fun setTextColor() {
        when(mIsEnable){
            true -> this.setTextColor(Color.parseColor(SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)))
            false -> this.setTextColor(Color.parseColor(mDisableTextColorStr))
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (isCircle && isBorder) {
            val strPrimaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
            val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
            val strokeWidth = (parentWidth * 0.065f).toInt()
            val padding = (strokeWidth * 1.1f).toInt()
            setPadding(padding, padding, padding, padding)

            if (isClickToNowPlaying) {
                mIsEnable = true
                isClickToNowPlaying = false
            }

            when(mIsEnable){
                true -> {
                    mShape?.apply {
                        setStroke(strokeWidth, Color.parseColor(strPrimaryColor))
                    }
                    this.background = mShape
                }

                false -> {
                    mDisableShape?.also {
                        it.setStroke(strokeWidth, Color.parseColor(mDisableTextColorStr))
                    }
                    this.background = mDisableShape
                }
            }

            this.requestLayout()
        }
    }

    fun disableButton(){
        mIsEnable = false
        this.background = mDisableShape
        setTextColor()
        this.requestLayout()
    }

    fun enableButton(){
        mIsEnable = true
        this.background = mShape
        setTextColor()
        this.requestLayout()
    }

    fun changeBgColor() {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL

        shape.color = ColorStateList.valueOf(Color.LTGRAY)
        shape.alpha = 200

        when(mIsEnable){
            true -> {
                this.background = LayerDrawable(arrayOf(mShape, shape))

                this.postDelayed({
                    this.background = mShape
                }, 200L)
            }

            false -> {
                this.background = LayerDrawable(arrayOf(mDisableShape, shape))

                this.postDelayed({
                    this.background = mDisableShape
                }, 200L)
            }
        }
    }
}