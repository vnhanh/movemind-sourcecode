package player.wellnesssolutions.com.base.common.load_scheduled_videos

import androidx.annotation.ColorRes
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

interface IScheduleContract {
    interface View : ILifeCycle.View, IProgressView, IShowMessageView {
        fun onNoClassVideosForNow(message: String = "", @ColorRes msgColor: Int = R.color.yellow, isClickedFromBtnBottom: Boolean) {}
        fun onHaveClassVideos(scheduleVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {}
        fun onHaveClassVideosWithTimeWaiting(videos: ArrayList<MMVideo>) {}
        fun onTimePlaySchedule() {}
        fun showDialogAskWantToBackToHome(isLoadSchedule: Boolean) {}
    }

    interface Presenter {
        fun onLoadSchedule(view: View, isClickedFromBtnBottom: Boolean, mustLoad: Boolean = false)
        fun onDetach()
        fun onDestroy()
        fun onAttach(view: View)
        fun setScheduleCurrentAndWaitNextVideo(videos: ArrayList<MMVideo>)
        fun onTimePlaySchedule()
        fun setStateLoadScheduleOnStart()
    }
}

interface ICallBackNextScheduleVideo {
    fun onResult(index: Int, timeWait: Long)
    fun onNotFound()
}