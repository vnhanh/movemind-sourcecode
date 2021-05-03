package player.wellnesssolutions.com.ui.fragment_home

import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import java.util.*

interface IHomeContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView, IScheduleContract.View {
        fun showUI(loadedConfig: MMConfigData?)
        fun openNowPlayingScreen(videos: ArrayList<MMVideo>)
        fun showPopUp(messagePopUpOnStart: String)
        fun showSnackbar(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setScheduleCurrent(videos: ArrayList<MMVideo>)
        fun onTimePlayAlreadySchedule()
        fun setupShowPopUpOnStartScreen(message: String)
        fun setupShowSnackbarOnStartScreen(message: String)
    }
}