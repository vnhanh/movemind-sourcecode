package player.wellnesssolutions.com.network.models.screen_search

import com.google.gson.annotations.SerializedName


open class SearchByOption(
        @SerializedName("tag") val tag: String,
        @SerializedName("title") val title: String)