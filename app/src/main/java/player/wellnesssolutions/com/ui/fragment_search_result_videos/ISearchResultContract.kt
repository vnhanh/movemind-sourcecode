package player.wellnesssolutions.com.ui.fragment_search_result_videos

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener

interface ISearchResultContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun showUIBeforeLoadResultData(chosenOptions: SPSearchedOption?)
        fun showUIBeforeLoadResultData()
        fun showUIBeforeLoadResultData(instructor: MMInstructor)
        fun displaySearchReuslt(searchList: ArrayList<MMVideo>)
        fun openPlayingVideosScreen(data: ArrayList<MMVideo>)
        fun onRequestFailed(message: String)
        fun onAnyVideoSelected(isAnyVideoNotDownloaded: Boolean)
        fun onNoVideoSelected()
        fun onAllVideosSelected()
        fun onNoAllVideosSelected()
        fun onShowPlayingVideoDialog(data: MMVideo)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun inputData(chosenOptions: SPSearchedOption?)
        fun inputData(answers: ArrayList<MMHelpMeChooseAnswer>, brandId: Int)
        fun inputData(instructor: MMInstructor)
        fun onPlaySearchedVideos()
        fun onReshowUI(view: View)
        fun getVideos(): ArrayList<MMVideo>
        fun getVideosFromRange(begin: Int, range: Int): ArrayList<MMVideo>
        fun loadData(view: View)
        fun selectVideoToPlay(video: MMVideo?, isSelected: Boolean)
        fun isVideoSelected(video: MMVideo?): Boolean
        fun hasSelectedVideos(): Boolean
        fun addItemListener(listener: ISearchResultItemListener)
        fun isAllVideosSelected(): Boolean
        fun selectAllVideos()
        fun unselectAllVideos()
        fun checkSelectedVideo()
        fun onShowPlayingVideoDialog(data: MMVideo)
    }
}