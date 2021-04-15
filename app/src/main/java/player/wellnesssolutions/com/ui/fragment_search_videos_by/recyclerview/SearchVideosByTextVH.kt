package player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview

import android.view.View
import kotlinx.android.synthetic.main.vh_search_videos_by_text.view.*
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.model.SearchByOptionText

class SearchVideosByTextVH(view: View) : SearchVideosByVH(view) {

    override fun bind(data: SearchByOption) {
        super.bind(data)

        val title = data.title
        itemView.tvNameSVBItem?.text = title

        if (data is SearchByOptionText) {
            val content = data.content
            itemView.tvContentSVB?.text = content
        }
    }
}