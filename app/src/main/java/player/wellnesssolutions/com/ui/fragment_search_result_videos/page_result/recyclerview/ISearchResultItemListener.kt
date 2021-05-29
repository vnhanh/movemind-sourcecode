package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import player.wellnesssolutions.com.network.models.now_playing.MMVideo

interface ISearchResultItemListener {
    fun selectVideo()
    fun unselectVideo()
    fun getVideo(): MMVideo?
}