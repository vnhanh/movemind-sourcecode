package player.wellnesssolutions.com.ui.fragment_search_collections.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_search_collection.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract

class SearchCollectionsAdapter(listener: ISearchCollectionContract.Presenter?, list: ArrayList<MMCollection>, val itemCountInRow: Int)
    : BaseSearchVideosAdapter<SearchCollectionVH, ISearchCollectionContract.Presenter, MMCollection>(listener, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCollectionVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_collection, parent, false)

        setupLayoutForItemView(view, view.imgCollectionLogo)

        val vh = SearchCollectionVH(view, listener, itemWidth, itemHeight, itemCountInRow)
        mHolders?.add(vh)
        return vh
    }
}