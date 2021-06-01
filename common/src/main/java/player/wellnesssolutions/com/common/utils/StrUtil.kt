@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package player.wellnesssolutions.com.common.utils

import android.content.Context
import androidx.annotation.StringRes
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.nextUp

object StrUtil {
    fun isEmpty(str: String?): Boolean = str == null || "".equals(str)

    fun isNotEmpty(str: String?): Boolean = !isEmpty(str)

    fun getString(context: Context, @StringRes idRes: Int): String = context.getString(idRes)

    fun convertTimeValueToString(value: Long /*seconds unit*/): String {
        if (value < 0) return ""
        when (value) {
            in 0..59 -> {
                return String.format("00:%s", if(value < 10) String.format("0%d", value) else value.toString())
            }
            in 60..3559 -> {
                val minute = value / 60
                val sec = value % 60
                val secStr : String = if(sec < 10) String.format("0%d", sec) else sec.toString()
                return String.format("%d:%s", minute, secStr)
            }
            else -> {
                val hour = value / 3600
                val minute = (value % 3600) / 60
                val minuteStr : String = if(minute < 10) String.format("0%d", minute) else minute.toString()
                val sec = value % 60
                val secStr : String = if(sec < 10) String.format("0%d", sec) else sec.toString()
                return String.format("%d:%s:%s", hour, minuteStr, secStr)
            }
        }
    }

    fun getFilenameFromUrl(url: String?): String {
        if (url == null || "".equals(url))
            return ""

        val slashIndex = url.lastIndexOf("/")

        if (slashIndex < 0)
            return ""

        return url.substring(slashIndex + 1, url.length)
    }

    fun getDurationFromSecond(second: Double): String {
//        val hour = second.nextUp() / 3600
        val minutes = second.nextUp() / 60
//        val seconds = second.nextUp() % 60
        return minutes.toInt().toString()
//        return when (hour.toInt()) {
//            0 -> {
//                String.format("%d:%02d", minutes.toInt(), seconds.toInt())
//            }
//            else -> {
//                String.format("%d:%02d:%03d", hour.toInt(), minutes.toInt(), seconds.toInt())
//            }
//        }
    }

    fun getTimeStartFromDate(date: String): String{
        val dateFormatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US)
        val newFormatter = SimpleDateFormat("hh:mm a", Locale.US)
        var isContains12h = false

        if(date.contains(Regex(" 12(:)([0-9]{2})(:)"))){
            isContains12h = true
        }

        try {
            val time: Long? = dateFormatter.parse(date)?.time
            when{
                time == null -> return ""
                else -> {
                    val dateStrFormatted = newFormatter.format(Date(time))
                    when{
                        isContains12h -> return dateStrFormatted.replace("AM", "PM")
                        else -> return dateStrFormatted
                    }
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
//            Log.e("ParseTime", "encountered parsing date time string from the input $date")
            return "###"
        }

    }
}