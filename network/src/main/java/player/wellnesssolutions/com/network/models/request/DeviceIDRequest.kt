package player.wellnesssolutions.com.network.models.request

import com.google.gson.annotations.SerializedName

class DeviceIDRequest(@SerializedName("device_id") var deviceID: String? = null, @SerializedName("timezoneOffset") var timezone: String? = null)