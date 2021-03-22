package player.wellnesssolutions.com.network.datasource.videos

import com.google.gson.annotations.SerializedName

data class SearchVideosOnSearchByRequestData(
     @SerializedName("brand_id")
     val brandId:Int,
     @SerializedName("search_by")
     val searchBy:String,
     @SerializedName("search_value")
     val searchValue:Int,
     @SerializedName("options")
     val options:SearchVideosRequestOptions
)