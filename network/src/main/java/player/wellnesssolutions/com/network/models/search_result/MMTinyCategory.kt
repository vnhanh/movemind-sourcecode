package player.wellnesssolutions.com.network.models.search_result

import com.google.gson.annotations.SerializedName

data class MMTinyCategory(
        @SerializedName("id") var _id: Int?= 0,
        @SerializedName("name") var name: String?="",
        @SerializedName("color") var colorStr: String?=""){

    fun getColor(): String {
        return if (colorStr.isNullOrEmpty()) {
            "#979797"
        } else {
            colorStr!!
        }
    }
}