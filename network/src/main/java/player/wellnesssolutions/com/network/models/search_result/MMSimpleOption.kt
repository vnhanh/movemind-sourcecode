package player.wellnesssolutions.com.network.models.search_result

import com.google.gson.annotations.SerializedName

data class MMSimpleOption(
        @SerializedName("id") var _id: Int?=0,
        @SerializedName("name") var name: String?=""
)