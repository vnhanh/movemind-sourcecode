package player.wellnesssolutions.com.network.models.search_result

import com.google.gson.annotations.SerializedName
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

data class MMSearchResultRootPage(@SerializedName("listMMVideo")var listMMVideo : ArrayList<MMVideo>)