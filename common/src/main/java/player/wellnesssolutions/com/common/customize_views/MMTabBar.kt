package player.wellnesssolutions.com.common.customize_views

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.enums.TextStyle
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

open class MMTabBar : LinearLayout, View.OnClickListener {
    private var mTabBarListener: TabBarListener? = null
    private var mFocus: Boolean = false
    private var mSecondaryColor: Int = Color.parseColor(Constant.DEF_SECONDARY_COLOR)
    private var mBtnColor: Int = Color.WHITE
    private var textViews = arrayListOf<TextView>()


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

    fun getState(): String {
        return textViews.firstOrNull {
            !it.isEnabled
        }?.text?.toString() ?: ""
    }

    fun setTabBarListener(mTabBarListener: TabBarListener?) {
        this.mTabBarListener = mTabBarListener
    }


    @SuppressLint("CustomViewStyleable")
    private fun init(attrs: AttributeSet?) {
        val strSecondaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        val strPrimaryColor = PreferenceHelper.getInstance(context).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
        if (strSecondaryColor.isEmpty() || strPrimaryColor.isEmpty()) return

        mSecondaryColor = Color.parseColor(strSecondaryColor)
        mBtnColor = Color.parseColor(strPrimaryColor)
        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.MMAttributes)
            val id = ta.getResourceId(R.styleable.MMAttributes_strings, 0)
            val strings = ta.resources.getStringArray(id)
            val padding : Float = ta.getDimension(R.styleable.MMAttributes_string_padding, 0f)
            val textSize : Float = ta.getDimension(R.styleable.MMAttributes_text_size, 0f)
            val textStyle : TextStyle = TextStyle.getEnum(ta.getInt(R.styleable.MMAttributes_textStyle, TextStyle.BOLD.value))
            mFocus = ta.getBoolean(R.styleable.MMAttributes_focus_main, false)
            ta.recycle()
            initView(strings, padding, textSize, textStyle)
        }
    }

    private fun initView(strings : Array<String>, padding : Float, textSize : Float, textStyle : TextStyle) {
        for (string : String in strings) {
            val textView = TextView(context)
            textView.setPadding(24, 8, 24, 8)

            textView.text =
                when(textStyle){
                    TextStyle.BOLD_ITALIC -> String.format(" %s ", string)
                    else -> string
                }

            textView.textSize = textSize

            textView.setTypeface(textView.typeface, textStyle.value)

            textView.setOnClickListener(this)
            textViews.add(textView)
            this.addView(textView)
            val index = strings.indexOf(string)
            textView.tag = index

            when (index) {
                0 -> {
                    initSpacing(padding, textSize)

                    setSelectedColor(textView)
                    textView.isEnabled = false
                }
                strings.lastIndex -> {
                    setUnSelectedColor(textView)
                }
                else -> {
                    setUnSelectedColor(textView)
                    initSpacing(padding, textSize)
                }
            }
        }
    }

    private fun initSpacing(padding: Float, textSize: Float) {
        val textView = TextView(context)
        textView.text = "/"
        textView.textSize = textSize
        textView.setTextColor(Color.BLACK)
        textView.setPadding(padding.toInt(), 0, padding.toInt(), 0)
        this.addView(textView)
    }

    private fun setSelectedColor(textView: TextView) {
        when (mFocus) {
            true -> {
                val mShape = GradientDrawable()
                mShape.cornerRadius = context.resources.getDimension(R.dimen.radius_button_tab_session)
                GradientDrawable.RECTANGLE
                mShape.color = ColorStateList.valueOf(mBtnColor)
                textView.background = mShape
                textView.setTextColor(mSecondaryColor)
            }
            else ->  textView.setTextColor(Color.BLACK)
        }
    }

    private fun setUnSelectedColor(textView: TextView) {
        when (mFocus) {
            true -> {
                textView.setTextColor(mSecondaryColor)
                textView.background = null
            }
            else ->  textView.setTextColor(mSecondaryColor)
        }
    }

    override fun onClick(v: View?) {
        var stringID = ""
        textViews.forEach {
            if (it.tag == v?.tag) {
                setSelectedColor(it)
                it.isEnabled = false
                stringID = it.text.toString()
            } else {
                it.isEnabled = true
                //reset the text view was unselected
                setUnSelectedColor(it)
            }
//            it.requestLayout()
        }

        mTabBarListener?.onTabChanged(stringID)
    }

    fun release(){
        mTabBarListener = null

        textViews.clear()
    }

    interface TabBarListener {
        fun onTabChanged(stringID: String)
    }
}
