package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import com.google.gson.Gson
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object NowPlayingPresenterHelper {
    /**
     * @param videos: list of videos that got from server
     * @param timeDiff: the time different between time of the local system and the network
     * @return
     *         firstReturn < 0 : time to play next video
     *         firstReturn  > 0 : begin position of played video
     *         secondReturn == 0L: not error
     *         secondReturn == -1L: count error or next video is no longer played (current time > end time)
     */
    const val EXPIRED_TIME_PLAY = 2L
    const val TIME_PLAY = 1L
    const val ERROR = 0L

    fun calculateTimePlayVideo(video: MMVideo, timeDiff: Long): Array<Long> {
        try {
            val playTime: Long = convertTime(video.getStartTime())
            val length = ((video.videoLength ?: 0f) * 1000).toInt()
            val endTime = playTime + length
            val currentTime = System.currentTimeMillis()
            return if (currentTime <= endTime) {
                arrayOf(TIME_PLAY, currentTime - playTime) // 0L: isOK
            } else {
                arrayOf(EXPIRED_TIME_PLAY, 0)
            }
        } catch (parseException: ParseException) {
            parseException.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return arrayOf(ERROR, 0L) // 1L: count error or no longer play video
    }

    private fun convertCurrentTimeToDateStr(time: Long): String {
        val sdf = SimpleDateFormat("H:mm:ss")
        return sdf.format(Date(time))
    }

    fun convertTime(dateTimeStr: String): Long {
        val df = SimpleDateFormat("yyyy-MM-dd H:mm:ss", Locale.getDefault())

        return df.parse(dateTimeStr).time
    }


    fun readSharePrefData(ss: SharedPreferencesCustomized, view: INowPlayingConstruct.View): Boolean {
        val userConfigJson = ss.getString(SPrefConstant.SS_CONFIG, "")

        if (userConfigJson == "") {
            view.showMessage(R.string.msg_not_got_user_config_data, R.color.red)
            return false
        }

        val gSon = Gson()
        gSon.fromJson<MMConfigData>(userConfigJson, MMConfigData::class.java)?.also { configData ->
            view.setupViewFloatMenu(configData)
        }

        return true
    }
}