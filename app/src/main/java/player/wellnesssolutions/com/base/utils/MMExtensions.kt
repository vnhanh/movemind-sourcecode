package player.wellnesssolutions.com.base.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


fun String.convertToStrDateFormat12hrs(): String {
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US)
    val newFormatter = SimpleDateFormat("hh:mm a", Locale.US)
    var isContains12h = false

    if (this.contains(Regex(" 12(:)([0-9]{2})(:)"))) {
        isContains12h = true
    }

    try {
        val time: Long? = dateFormatter.parse(this)?.time
        when {
            time == null -> return ""
            else -> {
                val dateStrFormatted = newFormatter.format(Date(time))
                when {
                    isContains12h -> return dateStrFormatted.replace("AM", "PM")
                    else -> return dateStrFormatted
                }
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Log.e("ParseTime", "encountered parsing date time string from the input $this")
        return "###"
    }

}