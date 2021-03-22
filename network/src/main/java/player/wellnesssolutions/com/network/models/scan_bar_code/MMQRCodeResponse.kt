package player.wellnesssolutions.com.network.models.scan_bar_code

import com.google.gson.annotations.SerializedName

class MMQRCodeResponse(var email:String?=null,
                       @SerializedName("login_token") var loginToken:String?=null,
                       @SerializedName("device_id") var deviceId: String?=null,
                       var time: Long?=null)