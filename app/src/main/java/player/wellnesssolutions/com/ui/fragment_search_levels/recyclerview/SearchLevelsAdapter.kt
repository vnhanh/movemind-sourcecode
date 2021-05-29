package player.wellnesssolutions.com.ui.fragment_search_levels.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.viewholder_search_video_level.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter
import player.wellnesssolutions.com.network.models.screen_search.MMLevel
import player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract


class SearchLevelsAdapter(listener: ISearchLevelsContract.Presenter?, list: ArrayList<MMLevel>, val itemCountInRow: Int) :
        BaseSearchVideosAdapter<SearchLevelVH, ISearchLevelsContract.Presenter, MMLevel>(listener, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchLevelVH {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.viewholder_search_video_level, parent, false)

        setupLayoutForItemView(view, view.viewWrapper)

        return SearchLevelVH(
            view = view,
            listener = listener,
            itemWidth = itemWidth,
            itemHeight = itemHeight,
            itemCountInRow = itemCountInRow
        )
    }
}