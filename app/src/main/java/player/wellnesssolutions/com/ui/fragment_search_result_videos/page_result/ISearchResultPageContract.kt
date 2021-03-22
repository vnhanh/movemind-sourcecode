package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener

interface ISearchResultPageContract {
    interface View : ILifeCycle.View, IShowMessageView {
        fun showUI(inputData: ArrayList<MMVideo>)
        fun onShowPlayingVideoDialog(data: MMVideo)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setPassedData(data: ArrayList<MMVideo>)
        fun onClickedResultItem(data: MMVideo?)
        fun selectVideoToPlay(video: MMVideo?, isSelected: Boolean)
        fun setParentPresenter(parentPresenter: ISearchResultContract.Presenter?)
        fun isVideoSelected(video: MMVideo?): Boolean?
        fun addItemListener(listener: ISearchResultItemListener)
        fun getVideos(): ArrayList<MMVideo>
        fun getPageIndex(): Int
    }
}