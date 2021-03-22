package player.wellnesssolutions.com.network.models.fcm

import com.google.gson.annotations.SerializedName

class FireBaseModel(@SerializedName("device_id") var device_id: String? = null,
                    @SerializedName("device_token") var device_token: String? = null )