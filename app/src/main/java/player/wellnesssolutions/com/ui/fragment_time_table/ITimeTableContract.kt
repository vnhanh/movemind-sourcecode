package player.wellnesssolutions.com.ui.fragment_time_table

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.network.models.response.SessionVideo

interface ITimeTableContract {
    interface View : ILifeCycle.View, IProgressView {
        fun setupUI(data: ArrayList<SessionVideo>?)
        fun showDialog(message: String, buttonColor: Int)
        fun showDialog(message: String)
        fun onRequestFailed()
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun onGetSessionVideo(typeDay: String = "", typeSession: String = ""): ArrayList<SessionVideo>?
        fun onGetTimetable()
    }
}