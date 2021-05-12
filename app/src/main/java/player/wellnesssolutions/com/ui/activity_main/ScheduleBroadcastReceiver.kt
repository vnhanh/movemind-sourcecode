package player.wellnesssolutions.com.ui.activity_main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Message
import android.util.Log
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment

class ScheduleBroadcastReceiver : BroadcastReceiver() {
    companion object {

        const val ACTION_SCHEDULE = "player.wellnesssolution.com.au.schedule"
        const val SCHEDULE_PLAY_VIDEO = "schedule_play_video"
        private var instance: ScheduleBroadcastReceiver? = null

        fun getInstance(): ScheduleBroadcastReceiver {
            if (instance == null) {
                instance = ScheduleBroadcastReceiver()
            }
            return instance!!
        }
    }

    private val scheduleBroadcastReceiver = this
    private val handler = MyHandle(scheduleBroadcastReceiver)

    class MyHandle(private var scheduleBroadcastReceiver: ScheduleBroadcastReceiver?) : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                1 -> {
                    scheduleBroadcastReceiver?.onUpdateSchedule()
                }
            }
        }

        fun release() {
            this.removeMessages(1)
            scheduleBroadcastReceiver = null
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
        handler.release()
        handler.removeCallbacks(null)
    }

    fun isRegistered(listener: ScheduleListener): Boolean = mScheduleListeners.contains(listener)

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent == null) return
        when (intent.action) {
            ACTION_SCHEDULE -> readScheduleIntent(intent)
        }
    }

    private fun readScheduleIntent(intent: Intent) {
        counterTry = 0
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

    private var counterTry = 0
    private val MAX_NUM_TRY = 5
    private val runnablePlaySchedule = Runnable { onPLaySchedule() }
    private val TIME_DELAY = 1000L

    private fun onPLaySchedule() {
        Log.d("LOG", this.javaClass.simpleName + " onPLaySchedule() | counterTry: ${counterTry}")
        counterTry++
        if (counterTry > MAX_NUM_TRY) return
        try {
            mScheduleListeners.forEach { listener ->
                listener.onReceivePlayVideoScheduleFromUI()
                Log.d("LOG", this.javaClass.simpleName + " onPLaySchedule() | listener: ${listener}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handler.postDelayed(runnablePlaySchedule, TIME_DELAY)
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
        if (mScheduleListeners.contains(listener)) return
        mScheduleListeners.add(listener)
        Log.d("LOG", this.javaClass.simpleName + " addListener() | " +
                "listeners number: ${mScheduleListeners.size} | listener class name: ${listener.javaClass.simpleName}")
    }

    fun removeListener(listener: ScheduleListener) {
        val iterator = mScheduleListeners.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == listener) {
                iterator.remove()
            }
        }
    }
}