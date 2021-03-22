package player.wellnesssolutions.com.services.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DownloadNotiReceiver : BroadcastReceiver() {
    companion object {
        val ACTION_CANCEL = "ACTION CANCEL"
        val ACTION = "MOVEMIND - DOWNLOAD ACTION"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val sendingIntent: Intent = Intent(ACTION).also {
            it.putExtra(ACTION, intent?.action ?: "")
        }
        context?.sendBroadcast(sendingIntent)
    }
}