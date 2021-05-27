package player.wellnesssolutions.com.base.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import androidx.annotation.StringRes

object StringUtil {
    fun isEmpty(str: String?): Boolean = str == null || "".equals(str)

    fun isNotEmpty(str: String?): Boolean = !isEmpty(str)

    fun getString(context: Context, @StringRes idRes: Int): String = context.getString(idRes)

    fun getTypefaceMadeEvolveSans(context: Context?): Typeface {
        return if (context == null) {
            Typeface.DEFAULT
        } else {
            val fontName = context.getString(player.wellnesssolutions.fontsizelibrary.R.string.font_made_evolve_sans)
            Typeface.createFromAsset(context.assets, fontName)
        }
    }

    fun setupFontMadeESNormal(textView: TextView) {
        val tf = getTypefaceMadeEvolveSans(textView.context)
        textView.typeface = tf
    }
}