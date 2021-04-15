package player.wellnesssolutions.com.base.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import androidx.annotation.StringRes

object StringUtil {
    fun isEmpty(str: String?): Boolean = str == null || "".equals(str)

    fun isNotEmpty(str: String?): Boolean = !isEmpty(str)

    fun getString(context: Context, @StringRes idRes: Int): String = context.getString(idRes)

    fun convertDurationToString(duration: Int /*seconds unit*/): String {
        if (duration < 0) return ""
        when (duration) {
            in 0..59 -> {
                return if (duration < 10)
                    String.format("0 : 0%d", duration)
                else
                    String.format("0 : %d", duration)
            }
            in 60..3559 -> {
                val minute = duration / 60
                val sec = duration % 60

                return if (sec < 10)
                    String.format("%d : 0%d", minute, sec)
                else
                    String.format("%d : %d", minute, sec)
            }
            else -> {
                val hour = duration / 3600
                val minute = (duration % 3600) / 60
                val sec = duration % 60

                val secStr = if (sec < 10) String.format("0%d", sec) else sec.toString()
                val minStr = if (minute < 10) String.format("0%d", minute) else minute.toString()

                return String.format("%d : %s : %d", hour, minStr, secStr)
            }
        }
    }

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