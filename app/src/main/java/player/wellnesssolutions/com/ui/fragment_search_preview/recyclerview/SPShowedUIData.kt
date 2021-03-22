package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview

import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption

class SPShowedUIData {
    var brand: MMBrand? = null
    var searchByData: SearchedOption? = null
    var collections: ArrayList<MMCollection>? = null
    var instructors: ArrayList<MMInstructor>? = null
    var durations: ArrayList<SearchedOption>? = null
    var levels: ArrayList<SearchedOption>? = null

    fun clear() {
        collections?.clear()
        instructors?.clear()
        durations?.clear()
        levels?.clear()
    }
}