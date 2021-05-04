package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.util.Log
import com.google.gson.Gson
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

interface ICallbackNowScheduleVideo {
    fun onResult(state: STATE_TIME_PLAY_SCHEDULE, timePlay: Long)
}

enum class STATE_TIME_PLAY_SCHEDULE(val state: String) {
    TIME_PLAY("TIME_PLAY"),
    TIME_WAIT("TIME_WAIT"),
    TIME_EXPIRED("EXPIRED_TIME_PLAY"),
    TIME_ERROR("TIME_ERROR")
}

object HandlerTimeScheduleHelper {
    private const val TIME_PLAY_MAX_ROUND = 2000L
    private const val ROUND_TIME_DIFFER_CAN_PLAY = 2000L

    fun calculateTimePlayVideo(video: MMVideo, callback: ICallbackNowScheduleVideo) {
        try {
            val timeStart: Long = convertTime(video.getStartTime())
            val length = ((video.videoLength ?: 0f) * 1000).toInt()
            val timeEnd = timeStart + length
            Log.d("LOG", this.javaClass.simpleName + " calculateTimePlayVideo() | " +
                    "curent time: ${convertCurrentTimeToDateStr(System.currentTimeMillis())} | " +
                    "time start: ${convertCurrentTimeToDateStr(timeStart)} | " +
                    "time end: ${convertCurrentTimeToDateStr(timeEnd)}")
            val currentTime = System.currentTimeMillis()

            when {
                currentTime < timeEnd -> {
                    var timePlay = currentTime - timeStart
                    Log.d("LOG", this.javaClass.simpleName + " calculateTimePlayVideo() | timplay: $timePlay")
                    when {
                        timePlay < -1 * ROUND_TIME_DIFFER_CAN_PLAY -> {
                            callback.onResult(STATE_TIME_PLAY_SCHEDULE.TIME_WAIT, -1 * timePlay)
                        }
                        else -> {
                            if (timePlay < TIME_PLAY_MAX_ROUND) timePlay = 0L
                            callback.onResult(STATE_TIME_PLAY_SCHEDULE.TIME_PLAY, timePlay)
                        }
                    }
                }

                else -> {
                    callback.onResult(STATE_TIME_PLAY_SCHEDULE.TIME_EXPIRED, 0L)
                }
            }
        } catch (parseException: ParseException) {
            parseException.printStackTrace()
            callback.onResult(STATE_TIME_PLAY_SCHEDULE.TIME_ERROR, 0L)
        } catch (e: Exception) {
            e.printStackTrace()
            callback.onResult(STATE_TIME_PLAY_SCHEDULE.TIME_ERROR, 0L)
        }
    }

    // keep this for logging
    private fun convertCurrentTimeToDateStr(time: Long): String {
        val sdf = SimpleDateFormat("H:mm:ss")
        return sdf.format(Date(time))
    }

    fun convertTime(dateTimeStr: String): Long {
        val df = SimpleDateFormat("yyyy-MM-dd H:mm:ss", Locale.getDefault())

        return df.parse(dateTimeStr).time
    }


    fun readSharePrefData(ss: PreferenceHelper, view: INowPlayingConstruct.View): Boolean {
        val userConfigJson = ss.getString(ConstantPreference.SS_CONFIG, "")

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