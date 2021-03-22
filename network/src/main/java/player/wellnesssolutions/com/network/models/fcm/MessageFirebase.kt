package player.wellnesssolutions.com.network.models.fcm

import com.google.gson.annotations.SerializedName

class MessageFirebase(@SerializedName("event_type") val event_type: String,
                      @SerializedName("modal") val modal: String? = "",
                      @SerializedName("videoIds") val videoIds: String = "")