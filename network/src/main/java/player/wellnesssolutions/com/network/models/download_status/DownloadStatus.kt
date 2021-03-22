package player.wellnesssolutions.com.network.models.download_status

import com.google.gson.annotations.SerializedName

class DownLoadStatus(
    @SerializedName("status") var status: String?= null,
    @SerializedName("device_id") var device_id: String? = null
)