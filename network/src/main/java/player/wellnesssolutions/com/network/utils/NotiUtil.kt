package player.wellnesssolutions.com.network.utils

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat

object NotiUtil {
    val ACTION_NOTI_DOWNLOAD_STOP = "vn.com.tma.network.download.stop"

    fun createBuilder(context: Context, channelID:String, @DrawableRes smallIcon:Int, contentTitle:String) : NotificationCompat.Builder
            = NotificationCompat.Builder(context, channelID)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setSmallIcon(smallIcon)
            .setContentTitle(contentTitle)
            .setOngoing(true)
            .setAutoCancel(true)
}