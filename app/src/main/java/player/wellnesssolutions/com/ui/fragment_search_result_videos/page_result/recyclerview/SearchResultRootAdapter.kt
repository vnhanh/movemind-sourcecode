package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage
import player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.SearchResultPagePresenter

class SearchResultRootAdapter(val list: ArrayList<MMSearchResultRootPage>) : RecyclerView.Adapter<SearchResultRootVH>() {

    private var mParentPresenter: ISearchResultContract.Presenter? = null
    private var mPresenter: ISearchResultPageContract.Presenter? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultRootVH {
        return SearchResultRootVH(LayoutInflater.from(parent.context).inflate(R.layout.fragment_page_search_result, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SearchResultRootVH, position: Int) {
        val brand = list[position].listMMVideo
        holder.bind(brand, mPresenter)
    }

    fun setParentPrenter(mParentPresenter: ISearchResultContract.Presenter?) {
        this.mParentPresenter = mParentPresenter
        if (mPresenter == null) {
            mPresenter = SearchResultPagePresenter(0).also {
                it.setParentPresenter(this.mParentPresenter)
            }
        }
    }
}