package player.wellnesssolutions.com.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import player.wellnesssolutions.com.common.constant.Constant
import java.util.*

object AlarmManagerSchedule {
    private const val codeScheduleRequest = 14
    private const val codeScheduleRequestEvery = 16
    private var alarm: AlarmManager? = null
    private var intentPending: PendingIntent? = null

    fun setupTimeWakeSchedule(context: Context, secondStart: Int) {
        alarm = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, ScheduleVideosService::class.java)
        intent.putExtra(Constant.SCHEDULE_INTENT, Constant.SCHEDULE_ALARM_TIME)
        intentPending = PendingIntent.getService(context, codeScheduleRequest, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, secondStart)
        alarm?.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, intentPending)
    }

    fun setupAlarmTimeCallEveryDay(context: Context) {
        val alarm = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, ScheduleVideosService::class.java)
        intent.putExtra(Constant.SCHEDULE_INTENT, Constant.SCHEDULE_ALARM_EVERY)
        val pendingIntent = PendingIntent.getService(context, codeScheduleRequestEvery,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            //set(Calendar.HOUR_OF_DAY, 15)
            set(Calendar.HOUR_OF_DAY, 1)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (Calendar.getInstance().after(calendar)) {
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY, pendingIntent)
    }

    fun cancelAlarmScheduleTime() {
        if (alarm != null && intentPending != null) {
            alarm?.cancel(intentPending)
        }
    }
}