package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_page_search_result.view.*
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract

class SearchResultRootVH(view: View) : RecyclerView.ViewHolder(view) {
    private var mListVideo: ArrayList<MMVideo> = ArrayList()
    private var mPresenter: ISearchResultPageContract.Presenter? = null
    private var mAdapter: VideosSearchResultPageAdapter? = null
    fun bind(data: ArrayList<MMVideo>, mPresenter: ISearchResultPageContract.Presenter?) {
        this.mListVideo = data
        this.mPresenter = mPresenter
        displayView()

    }

    private fun displayView() {
        val adapter = VideosSearchResultPageAdapter(this.mListVideo, mPresenter)
        itemView.rvVideoSearchResult.layoutManager = GridLayoutManager(itemView.context, Constant.COL_COUNT_SCREEN_SEARCH_RESULT, RecyclerView.VERTICAL, false)
        itemView.rvVideoSearchResult.setHasFixedSize(true)
        itemView.rvVideoSearchResult.setRowCount(Constant.ROW_COUNT_SCREEN_SEARCH_RESULT)
        itemView.rvVideoSearchResult.setVideosSearchResultPageAdapter(adapter)

        mAdapter = adapter

        itemView.progressLoadBrand?.visibility = View.GONE
    }
}