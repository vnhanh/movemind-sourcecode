package player.wellnesssolutions.com.network.models.request

import com.google.gson.annotations.SerializedName

class ActiveRequest(var email: String? = null,
                    var model: String? = null,
                    @SerializedName("device_id") var deviceID: String? = null,
                    @SerializedName("available_space") var availableSpace: Long? = null,
                    @SerializedName("total_space") var totalSpace: Long? = null)