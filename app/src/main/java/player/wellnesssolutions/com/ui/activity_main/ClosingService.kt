package player.wellnesssolutions.com.ui.activity_main

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * This service guarantee @MainActivity#onDestroy() would be called on kill app
 */
class ClosingService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)

        stopSelf()
    }
}