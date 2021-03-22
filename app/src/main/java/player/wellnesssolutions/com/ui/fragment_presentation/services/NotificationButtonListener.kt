package player.wellnesssolutions.com.ui.fragment_presentation.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationButtonListener : BroadcastReceiver() {
    companion object {
        const val ACTION = "REMOTE_VIDEO"
        const val ACTION_PLAY = "ACTION_PLAY"
        const val ACTION_NEXT = "ACTION_NEXT"
        const val ACTION_CLOSE_CAPTION = "ACTION_CLOSE_CAPTION"
        const val ACTION_SHOW_NEXT = "ACTION_SHOW_NEXT"
    }


    override fun onReceive(context: Context?, intent: Intent?) {
        val intentBack = Intent(ACTION)
        intentBack.putExtra(ACTION, intent?.action ?: "")
        context?.sendBroadcast(intentBack)
    }
}