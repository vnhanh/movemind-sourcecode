package player.wellnesssolutions.com.network.models.search_preview

import com.google.gson.annotations.SerializedName
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.network.models.screen_search.MMLevel

class MMSearchPreviewResponse(
        @SerializedName("levels") var levels : ArrayList<MMLevel>?,
        @SerializedName("durations") var durations : ArrayList<MMDuration>?,
        @SerializedName("instructors") var instructors : ArrayList<MMInstructor>?,
        @SerializedName("collections") var collections : ArrayList<MMCollection>?
)