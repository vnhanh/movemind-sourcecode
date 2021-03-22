package player.wellnesssolutions.com.ui.activity_main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment
import java.lang.ref.WeakReference

class ScheduleBroadcastReceiver : BroadcastReceiver() {
    companion object {

        const val ACTION_SCHEDULE = "player.wellnesssolution.com.au.schedule"
        const val SCHEDULE_PLAY_VIDEO = "schedule_play_video"
        private var mInstance: ScheduleBroadcastReceiver? = null

        fun getInstance(): ScheduleBroadcastReceiver {
            if (mInstance == null) {
                mInstance = ScheduleBroadcastReceiver()
            }
            return mInstance!!
        }
    }

    private val scheduleBroadcastReceiver = WeakReference<ScheduleBroadcastReceiver>(this)
    private val handler = MyHandle(scheduleBroadcastReceiver)

    class MyHandle(private val scheduleBroadcastReceiver: WeakReference<ScheduleBroadcastReceiver>) : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                1 -> {
                    scheduleBroadcastReceiver.get()?.onUpdateSchedule()
                }
            }
        }
    }

    private val mScheduleListeners: ArrayList<ScheduleListener> = ArrayList()

    interface ScheduleListener {
        fun onReceivePlayVideoScheduleFromUI()
        fun onReceiveResetScheduleFromUI()
        fun onReceiveUpdateScheduleFromUI()
        fun onReceiveChangeApiBackToHome()
        fun onReceiveChangeApiBackToHomeGetConfigApi()
        fun onReceiveChangeApiGetConfigApi()
        fun onReceiveChangeSub() {}
    }

    fun release() {
        mScheduleListeners.clear()
    }

    fun isRegistered(listener: ScheduleListener): Boolean = mScheduleListeners.contains(listener)


    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        when (intent.action) {
            ACTION_SCHEDULE -> readScheduleIntent(intent)
        }
    }

    private fun readScheduleIntent(intent: Intent) {
        when (intent.getStringExtra(SCHEDULE_PLAY_VIDEO)) {
            Constant.SCHEDULE_BROAD_CAST_EVERY -> onPLayScheduleEvery()
            Constant.SCHEDULE_BROAD_CAST_TIME -> onPLaySchedule()
            Constant.SCHEDULE_BROAD_CAST_UPDATE -> {
                handler.sendEmptyMessageDelayed(1, 1000)
            }
            Constant.API_CHANGE_BACK_TO_HOME -> onBackToHome()
            Constant.API_CHANGE_BACK_TO_HOME_GET_CONFIG -> onBackToHomeGetConfigApi()
            Constant.API_CHANGE_GET_CONFIG -> onGetConfigApi()
            Constant.API_CHANGE_SUB -> onChangeSubs()
        }
    }

    private fun onChangeSubs() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceiveChangeSub()
        }
    }

    private fun onPLaySchedule() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceivePlayVideoScheduleFromUI()
        }
    }

    private fun onBackToHome() {
        for (listener: ScheduleListener in mScheduleListeners) {
            if (listener is ControlFragment || listener is NowPlayingFragment) {
                listener.onReceiveChangeApiBackToHome()
            }
        }
    }

    private fun onBackToHomeGetConfigApi() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceiveChangeApiBackToHomeGetConfigApi()
        }
    }

    private fun onGetConfigApi() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceiveChangeApiGetConfigApi()
        }
    }

    private fun onPLayScheduleEvery() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceiveResetScheduleFromUI()
        }
    }

    private fun onUpdateSchedule() {
        for (listener: ScheduleListener in mScheduleListeners) {
            listener.onReceiveUpdateScheduleFromUI()
        }
    }

    fun addListener(listener: ScheduleListener) {
        mScheduleListeners.add(listener)
    }

    fun removeListener(listener: ScheduleListener) {
        mScheduleListeners.remove(listener)
    }

    private fun checkListenerHomeAndControl(): Boolean {
        for (listener: ScheduleListener in mScheduleListeners) {
            if (listener is HomeFragment || listener is ControlFragment) {
                return true
            }
        }
        return false
    }
}