package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import kotlinx.android.synthetic.main.layout_back_ground_image.view.*
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.enums.StyleEnum
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

class MMBackGroundView : ConstraintLayout {
    companion object{
        private const val DEF_ALPHA = 0.76f
    }

    private var mWidth = 0
    private var mHeight = 0
    private var mAlpha = DEF_ALPHA
    private var mDimColor = Color.WHITE
    private var mFixedDrawable : Drawable? = null

    constructor(context : Context?) : super(context) {
        context?.let {
            init(null)
        }
    }

    constructor(context : Context?, attrs : AttributeSet?) : super(context, attrs) {
        context?.let {
            init(attrs)
        }
    }

    constructor(context : Context?, attrs : AttributeSet?, defStyleAttr : Int) : super(context, attrs, defStyleAttr) {
        context?.let {
            init(attrs)
        }
    }

    private fun init(attrs : AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
        val style = StyleEnum.getEnum(ta.getInt(R.styleable.MMAttributes_style, 0))
        mAlpha = ta.getFloat(R.styleable.MMAttributes_opacity, mAlpha)
        mDimColor = ta.getColor(R.styleable.MMAttributes_dimBackground, Color.WHITE)
        mFixedDrawable = ta.getDrawable(R.styleable.MMAttributes_drawableFixed)

        ta.recycle()

        if (style == StyleEnum.BORDER) {
            generateBGWithBorder()
            return
        }

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as? LayoutInflater
        layoutInflater?.let {
            val viewChild = layoutInflater.inflate(R.layout.layout_back_ground_image, null)

            this.addView(viewChild)
        }

        setupDimBackground(attrs)
    }

    // for menu
    private fun generateBGWithBorder() {
        var strPrimaryColor = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        if (strPrimaryColor.isEmpty()) {
            strPrimaryColor = Constant.DEF_PRIMARY_COLOR
        }
        val shapeBG = GradientDrawable()
        shapeBG.shape = GradientDrawable.RECTANGLE
        shapeBG.color = ColorStateList.valueOf(Color.WHITE)

        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.setStroke(10, ColorStateList.valueOf(Color.parseColor(strPrimaryColor)))
        shape.color = ColorStateList.valueOf(Color.TRANSPARENT)

        val menuDrawable = AppCompatResources.getDrawable(context, R.drawable.bg_float_menu)

        val layer = LayerDrawable(arrayOf(shapeBG, menuDrawable, shape))

        this.background = layer
    }

    private fun setupDimBackground(attrs : AttributeSet?) {
        attrs?.let {
            viewDim.setBackgroundColor(mDimColor)
            viewDim.alpha = mAlpha
            viewDim.requestLayout()
            this.requestLayout()
        }
    }

    override fun onSizeChanged(w : Int, h : Int, oldw : Int, oldh : Int) {
        super.onSizeChanged(w, h, oldw, oldh)
//        val density = resources.displayMetrics.density
        // 1120
        // 2240
        if (mWidth == w && mHeight == h) return
        mWidth = w
        mHeight = h
        setupImageBackground(w, h)
    }

    private fun setupImageBackground(width : Int, height : Int) {

        if (width == 0 || height == 0 || imgBackground == null) return

        when(mFixedDrawable == null){
            true -> loadBgImageRandom()

            false -> loadBgImageFixed(mFixedDrawable!!)
        }

    }

    private fun loadBgImageFixed(fixedDrawable : Drawable) {
        Glide.with(context).load(fixedDrawable).override(width, height).format(DecodeFormat.PREFER_RGB_565)
                .into(imgBackground)
    }

    private fun loadBgImageRandom() {
        val strBG : Array<String> = SharedPreferencesCustomized.getInstance(context).getStrings(SPrefConstant.SS_BACKGROUND_PICTURES)
        val curBG : String = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SS_CURRENT_BACKGROUND, "")

        val bg : String? =
                when (strBG.size == 1) {
                    true -> {
                        strBG[0]
                    }
                    false -> {
                        strBG.toMutableList().shuffled().firstOrNull { !it.equals(curBG, true) }
                    }
                }

        when (bg.isNullOrEmpty()) {
            true -> loadDefaultImage(width, height)
            false -> loadImage(bg, width, height)
        }
    }

    private fun loadImage(bg : String, width : Int, height : Int) {
        SharedPreferencesCustomized.getInstance(context).putString(SPrefConstant.SS_CURRENT_BACKGROUND, bg)

        Glide.with(context).load(bg).override(width, height)
                .into(imgBackground)

    }

    private fun loadDefaultImage(width : Int, height : Int) {
        viewDim.alpha = 0.2f
        Glide.with(context).load(R.drawable.default_background).override(width, height)
                .into(imgBackground)
    }
}