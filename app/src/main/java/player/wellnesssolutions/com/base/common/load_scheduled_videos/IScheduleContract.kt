package player.wellnesssolutions.com.base.common.load_scheduled_videos

import androidx.annotation.ColorRes
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

interface IScheduleContract {
    interface View : ILifeCycle.View, IProgressView, IShowMessageView {
        fun onNoClassVideos(message: String = "", @ColorRes msgColor: Int = R.color.yellow, isClickedFromBtnBottom: Boolean) {}
        fun onHaveClassVideos(scheduledVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {}
        fun onHaveClassVideosWithTimeWaiting(videos: ArrayList<MMVideo>) {}
    }

    interface Presenter {
        fun onLoadSchedule(view: View, isClickedFromBtnBottom: Boolean)
        fun onDetach()
        fun onDestroy()
        fun onAttach(view: View)
    }
}