package player.wellnesssolutions.com.network.datasource.videos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchVideosRequestOptions(
        @SerializedName("durations")
        @Expose
        var durations:List<Int>?=null,
        @SerializedName("levels")
        @Expose
        var levels:List<Int> ?= null,
        @SerializedName("instructors")
        @Expose
        var instructors:List<Int> ?= null,
        @SerializedName("collections")
        @Expose
        var collections:List<Int> ?= null
)