package player.wellnesssolutions.com.network.models.storage_status

import com.google.gson.annotations.SerializedName

class StorageStatus(
        @SerializedName("device_id") var device_id: String?,
        @SerializedName("available_space") var available_space: Long?=null,
        @SerializedName("total_space") var total_space: Long?=null,
        @SerializedName("sd_available_space") var sd_available_space: Long?=null,
        @SerializedName("sd_total_space") var sd_total_space: Long?=null
)