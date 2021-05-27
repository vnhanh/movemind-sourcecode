package player.wellnesssolutions.com.services

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Intent
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver

@SuppressLint("Registered")
class ScheduleVideosService : IntentService(ScheduleVideosService::class.java.name) {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.getStringExtra(Constant.SCHEDULE_INTENT)) {
            Constant.SCHEDULE_ALARM_EVERY -> {
                val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.SCHEDULE_BROAD_CAST_EVERY)
                application?.let {
                    it.sendBroadcast(intentSend)
                }
            }
            Constant.SCHEDULE_ALARM_TIME -> {
                val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.SCHEDULE_BROAD_CAST_TIME)
                application?.let {
                    it.sendBroadcast(intentSend)
                }
            }
        }

    }

}