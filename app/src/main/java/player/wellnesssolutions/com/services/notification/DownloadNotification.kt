package player.wellnesssolutions.com.services.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.google.firebase.crashlytics.FirebaseCrashlytics
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.R
import player.wellnesssolutions.com.services.download.DownloadTask


class DownloadNotification(private var context: Context?) : DownloadTask.Callback {
    private var mNotiManager: NotificationManagerCompat? = null
    private val CHANNEL_ID = "DOWNLOAD CHANNEL"
    private var mLayout: RemoteViews? = null
    private val NOTI_ID = 10
    private var mBuilder: NotificationCompat.Builder? = null

    init {
        createNotificationChannel()
    }

    override fun onDownloadStarted(id: Int?, name: String?) {
        FirebaseCrashlytics.getInstance().log("noti: start $name")
        create(0, name)
    }

    override fun onInsufficientSpace(videoId: Int?, name: String?, availableSpace: Long, fileSize: Long) {
        FirebaseCrashlytics.getInstance().log("noti: not enough space for video $name")
        cancelNoti()
    }

    override fun onDownloadUpdate(id: Int?, name: String?, progress: Int) {
        //create(progress, name)
        try {
            mLayout?.let {
                context?.also { context ->
                    it.setTextViewText(R.id.tvProgress, context.getString(R.string.progress, progress))
                    if (mBuilder == null) return
                    mNotiManager?.notify(NOTI_ID, mBuilder!!.build())
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
        }
        //Log.e("onDownloadUpdate", "onDownloadUpdate" + progress.toString())
    }

    override fun onDownloadFailed(id: Int?, name: String?, reason: String, url: String?) {
        FirebaseCrashlytics.getInstance().log("noti: failed $name")
        FirebaseCrashlytics.getInstance().log("noti: failed reason $reason")
        cancelNoti()
    }

    override fun onDownloadCompleted(id: Int?, name: String?) {
        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | fileName: ${name}")
        cancelNoti()
    }

    private fun cancelNoti() {
        mNotiManager?.cancel(NOTI_ID)
    }


    private fun createNotificationChannel() {
        context?.also { context ->
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = context.getString(R.string.channel_download_name)
                val description = context.getString(R.string.channel_description)
                val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_LOW).also {
                    it.description = description
                    it.enableLights(true)
                    it.enableVibration(false)
                    it.setSound(null, null)
                    it.lightColor = Color.parseColor("#00c3b3")
                }
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                getSystemService(context, NotificationManager::class.java)?.also { notificationManager ->
                    notificationManager.createNotificationChannel(channel)
                }
            }
            mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
        }
    }

    fun create(progress: Int, name: String?) {
        context?.also { context ->
            if (mLayout == null) {
                mLayout = RemoteViews(context.packageName, R.layout.noti_download)
            }
            mLayout?.setTextViewText(R.id.tvProgress, context.getString(R.string.progress, progress))
            mLayout?.setTextViewText(R.id.tvFilename, name ?: "The downloaded file")
            val data = VideoDBUtil.countRecordInTable(tag = Constant.TAG_VIDEO_DOWNLOAD)
            mLayout?.setTextViewText(R.id.tvRestOfDownload, "Downloaded ${data.second} videos. There are ${data.first} videos left.")

            if (mNotiManager == null) mNotiManager = NotificationManagerCompat.from(context)

            mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(name ?: "The downloaded file")
                    .setContentText(context.getString(R.string.progress, progress))
                    .setCustomContentView(mLayout)
                    .setSound(null)
                    .setVibrate(null)
                    .setAutoCancel(false)
                    .setOngoing(true)

            try {

                if (mBuilder == null) return
                mNotiManager?.notify(NOTI_ID, mBuilder!!.build())
                FirebaseCrashlytics.getInstance().log("noti: init $name")
            } catch (e: Exception) {
                e.printStackTrace()
                mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                        .setPriority(NotificationCompat.PRIORITY_LOW)
                        .setContentTitle(name ?: "The downloaded file")
                        .setContentText(context.getString(R.string.progress, progress))
                        .setCustomContentView(mLayout)
                        .setSound(null)
                        .setVibrate(null)
                        .setAutoCancel(false)
                        .setOngoing(true)
                try {
                    if (mBuilder == null) return
                    mNotiManager?.notify(NOTI_ID, mBuilder!!.build())
                    FirebaseCrashlytics.getInstance().log("noti: init $name")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun stop() {
        FirebaseCrashlytics.getInstance().log("noti: stop")
        mNotiManager?.cancel(NOTI_ID)
    }

    fun release() {
        FirebaseCrashlytics.getInstance().log("noti: release")
        context = null
    }
}