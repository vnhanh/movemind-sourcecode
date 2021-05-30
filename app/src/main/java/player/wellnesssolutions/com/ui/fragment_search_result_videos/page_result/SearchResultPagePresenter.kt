package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result

import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener

class SearchResultPagePresenter(pageIndex: Int) : ISearchResultPageContract.Presenter {
    private var mView: ISearchResultPageContract.View? = null
    private var mParentPresenter: ISearchResultContract.Presenter? = null
    private var mPageIndex = pageIndex
    private var mVideos: ArrayList<MMVideo>? = null
    private var mIsShown = false

    override fun setPassedData(data: ArrayList<MMVideo>) {
        this.mVideos = data
    }

    override fun onAttach(view: ISearchResultPageContract.View) {
        this.mView = view
        if (!mIsShown) mIsShown = true
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onDestroy() {
        onDetach()
        mParentPresenter = null
        mVideos?.clear()
        mVideos = null
    }

    override fun onClickedResultItem(data: MMVideo?) {
        data?.also {
            mParentPresenter?.onShowPlayingVideoDialog(it)
        }
    }

    override fun selectVideoToPlay(video: MMVideo?, isSelected: Boolean) {
        mParentPresenter?.selectVideoToPlay(video, isSelected)
    }

    override fun setParentPresenter(parentPresenter: ISearchResultContract.Presenter?) {
        mParentPresenter = parentPresenter
    }

    override fun addItemListener(listener: ISearchResultItemListener) {
        mParentPresenter?.addItemListener(listener)
    }

    override fun isVideoSelected(video: MMVideo?): Boolean? = mParentPresenter?.isVideoSelected(video)

    override fun getVideos(): ArrayList<MMVideo> = mVideos ?: ArrayList()

    override fun getPageIndex(): Int = mPageIndex
}