package player.wellnesssolutions.com.network.models.response

import com.google.gson.annotations.SerializedName
import player.wellnesssolutions.com.common.utils.StrUtil
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory

class TimeTableResponse(var today : Session? = null, var tomorrow : Session? = null)


class Session(var morning : ArrayList<SessionVideo>? = null,
              var afternoon : ArrayList<SessionVideo>? = null,
              var evening : ArrayList<SessionVideo>? = null)

class SessionVideo(@SerializedName("id") var idSession : Int? = null,
                   @SerializedName("brand_id") var brandID : Int? = null,
                   @SerializedName("duration_id") var durationID : Int? = null,
                   @SerializedName("duration_name") var durationName : String? = null,
                   @SerializedName("language_id") var languageID : Int? = null,
                   @SerializedName("name") var nameOfVideo : String? = null,
                   @SerializedName("instructor") var instructorOfVideo : Int? = null,
                   @SerializedName("video") var videoUrl : String? = null,
                   @SerializedName("trailer") var trailer : String? = null,
                   @SerializedName("thumbnail657x369") var thumbnail657 : String? = null,
                   @SerializedName("thumbnail575x235") var thumbnail575 : String? = null,
                   @SerializedName("thumbnail342x205") var thumbnail342 : String? = null,
                   @SerializedName("length") var length : Double? = null,
                   @SerializedName("size") var sizeVideo : Int? = null,
                   @SerializedName("collections") var collections : ArrayList<MMTinyCategory>? = null,
                   @SerializedName("levels") var levels : ArrayList<MMTinyCategory>? = null,
                   @SerializedName("instructor_name") var instructorName : String? = null,
                   @SerializedName("play_time") var playTime : String? = null,
                   @SerializedName("logo") var logo : String? = null) {
    fun getTime() : String {
        return StrUtil.getTimeStartFromDate(playTime ?: "")
    }

    fun getDuration() : String {
        return StrUtil.getDurationFromSecond(length ?: 0.0)
    }

    fun getDurationValue() : String = if (durationName.isNullOrEmpty()) getDuration() else durationName!!
}

class SubVideo(@SerializedName("id") var idSub : Int? = null,
               @SerializedName("name") var nameOfSub : String? = null,
               @SerializedName("color") var colorOfSub : String? = null)