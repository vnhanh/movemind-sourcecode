package player.wellnesssolutions.com.base.view

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.common.load_scheduled_videos.SchedulePresenter
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.SOURCE_LOAD_SCHEDULE
import player.wellnesssolutions.com.common.utils.DialogUtil
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
        schedulePresenter = SchedulePresenter(context)
        registerScheduleBroadcast()

        Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | arguments is: ${arguments ?: "null"}")
        arguments?.also { bundle ->
            val sourceLoadSchedule = bundle.getString(Constant.BUNDLE_SOURCE_SCHEDULE).orEmpty()
            Log.d("LOG", this.javaClass.simpleName + " onCreateView() | sourceLoadSchedule: ${sourceLoadSchedule}")
            when {
                sourceLoadSchedule == SOURCE_LOAD_SCHEDULE.REMOTE.toString() -> {
                    Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | load remote schedule")
                    schedulePresenter?.setStateLoadScheduleOnStart()
                }

                else -> {
                    val videos: ArrayList<MMVideo> = VideoDBUtil.getScheduleVideos(false)
                    Log.d("LOG", this.javaClass.simpleName + " onCreateView() | contains BUNDLE_SCHEDULE | isNewScreen: $isNewScreen | videos number: ${videos.size}")
                    when {
                        videos.size > 0 -> schedulePresenter?.setScheduleCurrentAndWaitNextVideo(videos)
                        else -> {
                            Log.d("LOG", this.javaClass.simpleName + " onCreateView() | isNewScreen | load remote schedule")
//                            schedulePresenter?.setStateLoadScheduleOnStart()
                        }
                    }
                }

            }

        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
//        Log.d("LOG", this.javaClass.simpleName + " onResume()")

        schedulePresenter?.onAttach(this)
    }

    override fun onPause() {
        super.onPause()
//        Log.d("LOG", this.javaClass.simpleName + " onPause()")
        schedulePresenter?.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("LOG", this.javaClass.simpleName + " onDestroyView()")
        unregisterScheduleBroadcast()
        isNewScreen = true
        schedulePresenter?.onDestroy()
    }

    private fun registerScheduleBroadcast() {
        // register casting TV (presentation) broadcast receiver
        activity?.also { _ ->
            ScheduleBroadcastReceiver.getInstance().addListener(this)
        }
    }

    private fun unregisterScheduleBroadcast() {
        ScheduleBroadcastReceiver.getInstance().removeListener(this)
    }

    protected fun loadSchedule(isClickedFromBtnBottom: Boolean) {
        Log.d("LOG", this.javaClass.simpleName + " loadSchedule() | isClickedFromBtnBottom: $isClickedFromBtnBottom | presenter: $schedulePresenter")
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
//        AlarmManagerSchedule.cancelAlarmScheduleTime()
        schedulePresenter?.onTimePlaySchedule()
    }

    override fun onReceiveResetScheduleFromUI() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveResetScheduleFromUI()")
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        schedulePresenter?.onLoadSchedule(this, false, true)
    }

    override fun onReceiveUpdateScheduleFromUI() {
        Log.d("LOG", this.javaClass.simpleName + " onReceiveUpdateScheduleFromUI() | schedulePresenter: $schedulePresenter")
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        val _context = context
        when {
            _context == null -> {
                schedulePresenter?.onLoadSchedule(view = this, isClickedFromBtnBottom = false, mustLoad = true)
                Log.d("LOG", this.javaClass.simpleName + " onReceiveUpdateScheduleFromUI() | context's null")
            }
            else -> {
                Log.d("LOG", this.javaClass.simpleName + " onReceiveUpdateScheduleFromUI() | context's not null | show dialog")
                dialog?.dismiss()
                dialog = DialogUtil.createDialogOnlyOneButton(
                        _context, R.string.schedule_just_update,
                        R.string.btn_ok, object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                        dialogInterface?.dismiss()
                        dialog = null
                        schedulePresenter?.onLoadSchedule(view = this@BaseScheduleFragment, isClickedFromBtnBottom = false, mustLoad = true)
                    }
                }
                ).apply { show() }
            }
        }

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

    protected fun isUpdatingNewSchedule(): Boolean = schedulePresenter?.isUpdatingNewSchedule()
            ?: false
}