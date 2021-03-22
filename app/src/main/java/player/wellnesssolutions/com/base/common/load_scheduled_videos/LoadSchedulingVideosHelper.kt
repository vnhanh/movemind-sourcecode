package player.wellnesssolutions.com.base.common.load_scheduled_videos

import android.annotation.SuppressLint
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
object LoadSchedulingVideosHelper {
    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SimpleDateFormat")
    fun filterTodaySchedulingVideos(loadedVideos: ArrayList<MMVideo>) {
        val date = Date()
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, 1)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)

        val tomorrowTime = calendar.time.time

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")

        var index = 0

        while (index < loadedVideos.size) {
            val playTimeStr = loadedVideos[index].playTime
            val playTime = df.parse(playTimeStr).time
            if (playTime >= tomorrowTime) {
                loadedVideos.removeAt(index)
            } else {
                index++
            }
        }
    }
}