package player.wellnesssolutions.com.network.datasource.videos

import com.google.gson.annotations.SerializedName

data class SearchVideosOnHelpMeChooseRequestData(
        @SerializedName("brand_id")
        val brandId:Int,
        @SerializedName("answers")
        val answers:List<Int>
)