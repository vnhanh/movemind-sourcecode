package player.wellnesssolutions.com.services.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
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
        create(0, name)
    }

    override fun onInsufficientSpace(videoId: Int?, name: String?, availableSpace: Long, fileSize: Long) {
        cancelNoti()
    }

    override fun onDownloadUpdate(id: Int?, name: String?, progress: Int) {
//        Log.d("LOG", "onDownloadUpdate() ${progress} | mBuilder is not null: ${mBuilder != null} | mLayout is not null: ${mLayout != null}")
        try {
            mLayout?.also {
                mBuilder?.also { builder ->
                    it.setTextViewText(R.id.tvProgress, context?.getString(R.string.progress, progress))
                    it.setTextViewText(R.id.tvRestOfDownload, "Downloaded ${data?.second} videos. There are ${data?.first} videos left.")
                    mNotiManager?.notify(NOTI_ID, builder.build())
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("download noti upated exception")
        }
    }

    override fun onDownloadFailed(id: Int?, name: String?, reason: String, url: String?) {
        cancelNoti()
    }

    override fun onDownloadCompleted(id: Int?, name: String?) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | fileName: ${name}")
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
                val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT).also {
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
        }
    }
    private var data: Pair<Int, Int>? = null
    fun create(progress: Int, name: String?) {
        context?.also { context ->
            try {
                if (mNotiManager == null) mNotiManager = NotificationManagerCompat.from(context)

                mLayout = RemoteViews(context.packageName, R.layout.noti_download).also { layout ->
                    layout.setTextViewText(R.id.tvProgress, context.getString(R.string.progress, progress))
                    layout.setTextViewText(R.id.tvFilename, name ?: "The downloaded file")
                    data = VideoDBUtil.countRecordInTable(tag = Constant.TAG_VIDEO_DOWNLOAD).also { data ->
//                        Log.d("LOG", this.javaClass.simpleName + " create() | thread: ${Thread.currentThread()}")
//                        Log.d("LOG", this.javaClass.simpleName + " Downloaded ${data.second} videos. There are ${data.first} videos left")

                        layout.setTextViewText(R.id.tvRestOfDownload, "Downloaded ${data.second} videos. There are ${data.first} videos left.")

                        mBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setStyle(null)
                            .setCustomContentView(layout)
                            .setSound(null)
                            .setVibrate(null)
                            .setAutoCancel(false)
                            .setOngoing(true).also {
                                mNotiManager?.notify(NOTI_ID, it.build())
                            }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
//                Log.d("LOG", "create() | exception: ${e.message}")
                FirebaseCrashlytics.getInstance().recordException(e)
                FirebaseCrashlytics.getInstance().log("download noti create exception")
            }
        }
    }

    fun stop() {
        mNotiManager?.cancel(NOTI_ID)
        mLayout = null
        mBuilder = null
    }

    fun release() {
        context = null
        mLayout = null
        mBuilder = null
    }
}