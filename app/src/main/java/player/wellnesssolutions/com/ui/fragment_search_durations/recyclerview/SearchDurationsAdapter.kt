package player.wellnesssolutions.com.ui.fragment_search_durations.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.viewholder_search_video_duration.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract

class SearchDurationsAdapter(listener: ISearchDurationContract.Presenter?, list: ArrayList<MMDuration>, val countItemInRow: Int)
    : BaseSearchVideosAdapter<SearchDurationVH, ISearchDurationContract.Presenter, MMDuration>(listener, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDurationVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_search_video_duration, parent, false)

        setupLayoutForItemView(view, view.viewWrapper)

        val vh = SearchDurationVH(view, listener, itemWidth, itemHeight, countItemInRow)
        mHolders?.add(vh)

        return vh
    }
}