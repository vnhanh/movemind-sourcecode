package player.wellnesssolutions.com.network.models.login

import com.google.gson.annotations.SerializedName

class MMCookie(@SerializedName("CloudFront-Key-Pair-Id") val keyPairId:String?=null,
               @SerializedName("CloudFront-Policy") val policy:String?=null,
               @SerializedName("CloudFront-Signature") val signature:String?=null) {
}