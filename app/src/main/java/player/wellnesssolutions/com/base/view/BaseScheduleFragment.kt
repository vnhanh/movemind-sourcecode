package player.wellnesssolutions.com.base.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.common.load_scheduled_videos.SchedulePresenter
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver

open class BaseScheduleFragment : BaseFragment(), ILifeCycle.View, IScheduleContract.View, ScheduleBroadcastReceiver.ScheduleListener {
    private var schedulePresenter: IScheduleContract.Presenter? = null
    protected var isNewScreen = true
    protected var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        schedulePresenter = SchedulePresenter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isNewScreen = true
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        if (isNewScreen) {
            val videos: ArrayList<MMVideo> = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
            if (videos.size > 0) {
                schedulePresenter?.setScheduleCurrentAndWaitNextVideo(videos)
            }
        }
        schedulePresenter?.onAttach(this)
        isNewScreen = false
    }

    override fun onPause() {
        super.onPause()
        schedulePresenter?.onDetach()
    }

    override fun onStop() {
        super.onStop()
        isNewScreen = true
    }

    override fun onDestroy() {
        super.onDestroy()
        schedulePresenter?.onDestroy()
    }

    protected fun loadSchedule(isClickedFromBtnBottom: Boolean) {
        schedulePresenter?.onLoadSchedule(view = this, isClickedFromBtnBottom = isClickedFromBtnBottom)
    }

    protected fun setOldScreen() {
        isNewScreen = false
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */

    override fun onReceivePlayVideoScheduleFromUI() {
        schedulePresenter?.onTimePlaySchedule()
    }

    override fun onReceiveResetScheduleFromUI() {
        schedulePresenter?.onLoadSchedule(this, false)
    }

    override fun onReceiveUpdateScheduleFromUI() {
        schedulePresenter?.onLoadSchedule(this, false)
    }

    override fun onReceiveChangeApiBackToHome() {

    }

    override fun onReceiveChangeApiBackToHomeGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                it.getApiConfigData()
            }
        }
    }

    override fun onReceiveChangeApiGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                it.getApiConfigData()
            }
        }
    }

    override fun showLoadingProgress() {

    }

    override fun hideLoadingProgress() {

    }

}