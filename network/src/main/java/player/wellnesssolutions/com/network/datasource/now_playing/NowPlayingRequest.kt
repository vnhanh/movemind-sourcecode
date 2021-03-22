package player.wellnesssolutions.com.network.datasource.now_playing

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NowPlayingRequest(
        @SerializedName("device_id")
        @Expose
        val deviceId: String,
        @SerializedName("timezoneOffset")
        @Expose
        val timezone: String
)