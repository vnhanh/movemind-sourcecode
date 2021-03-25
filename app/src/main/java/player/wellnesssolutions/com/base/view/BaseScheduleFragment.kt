package player.wellnesssolutions.com.base.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.common.load_scheduled_videos.SchedulePresenter
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.SOURCE_LOAD_SCHEDULE
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver

open class BaseScheduleFragment : BaseFragment(), ILifeCycle.View, IScheduleContract.View, ScheduleBroadcastReceiver.ScheduleListener {
    private var schedulePresenter: IScheduleContract.Presenter? = null
    protected var isNewScreen = true
    protected var dialog: Dialog? = null
    protected var isStartedOpenNewScreen = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isNewScreen = true
        isStartedOpenNewScreen = false
        schedulePresenter = SchedulePresenter(context!!)

//        if (isNewScreen) {
        Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | arguments is: ${arguments ?: "null"}")
        arguments?.also { bundle ->
            val sourceLoadSchedule = bundle.getString(Constant.BUNDLE_SOURCE_SCHEDULE).orEmpty()
            Log.d("LOG", this.javaClass.simpleName + " onCreateView() | sourceLoadSchedule: ${sourceLoadSchedule}")
            when {
                sourceLoadSchedule == SOURCE_LOAD_SCHEDULE.LOCAL.toString() -> {
                    val videos: ArrayList<MMVideo> = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
                    Log.d("LOG", this.javaClass.simpleName + " onCreateView() | contains BUNDLE_SCHEDULE | isNewScreen: $isNewScreen | videos number: ${videos.size}")
                    when {
                        videos.size > 0 -> schedulePresenter?.setScheduleCurrentAndWaitNextVideo(videos)
                        else -> {
                            Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | load remote schedule")
                            schedulePresenter?.setStateLoadScheduleOnStart()
                        }
                    }
                }

                sourceLoadSchedule == SOURCE_LOAD_SCHEDULE.REMOTE.toString() -> {
                    Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | load remote schedule")
                    schedulePresenter?.setStateLoadScheduleOnStart()
                }
            }

        }
//        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        schedulePresenter?.onAttach(this)
    }

    override fun onPause() {
        super.onPause()
        schedulePresenter?.onDetach()
    }

    override fun onStop() {
        super.onStop()
        Log.d("LOG", this.javaClass.simpleName + " onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isNewScreen = true
        schedulePresenter?.onDestroy()
    }

    protected fun loadSchedule(isClickedFromBtnBottom: Boolean) {
        schedulePresenter?.onLoadSchedule(view = this, isClickedFromBtnBottom = isClickedFromBtnBottom)
    }

    protected fun setOldScreen() {
        isNewScreen = false
    }

    protected fun onHandleSchedule() {
        schedulePresenter?.onTimePlaySchedule()
    }

    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */

    override fun onReceivePlayVideoScheduleFromUI() {
        Log.d("LOG", this.javaClass.simpleName + " onReceivePlayVideoScheduleFromUI()")
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        schedulePresenter?.onTimePlaySchedule()
    }

    override fun onReceiveResetScheduleFromUI() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveResetScheduleFromUI()")
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        schedulePresenter?.onLoadSchedule(this, false, true)
    }

    override fun onReceiveUpdateScheduleFromUI() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveUpdateScheduleFromUI()")
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        schedulePresenter?.onLoadSchedule(view = this, isClickedFromBtnBottom = false, mustLoad = true)
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