package player.wellnesssolutions.com.services

//import android.support.v4.app.NotificationCompat
//import android.support.v4.app.NotificationManagerCompat
import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.application.MyApplication
import player.wellnesssolutions.com.ui.fragment_presentation.services.NotificationButtonListener

class MMPresentationService : Service(), MMPresentationBinder.BinderListener {

    companion object {
        const val TAG = "MMPresentationService"
        const val DESCRIPTION = "Move Mind"
        const val TITLE = "Move Mind"
    }

    private var mManager: NotificationManager? = null
    private var mBinder = MMPresentationBinder(this)
    private var mIsNormalColor = true

    private var mReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(arg0: Context?, arg1: Intent?) {
            val action = arg1?.getStringExtra(NotificationButtonListener.ACTION)
                    ?: NotificationButtonListener.ACTION_PLAY
            when (action) {
                NotificationButtonListener.ACTION_PLAY -> {
                    this@MMPresentationService.onPlayOrPauseVideo()
                }
                NotificationButtonListener.ACTION_NEXT -> {
                    this@MMPresentationService.onNextVideo()
                }
                NotificationButtonListener.ACTION_CLOSE_CAPTION -> {
                    this@MMPresentationService.onClosedCaption()
                }
                else -> {
                    this@MMPresentationService.onShowNextVideos()
                }
            }
        }
    }

    override fun onCreateNotificationRemote() {
        registerReceiver(mReceiver, IntentFilter(NotificationButtonListener.ACTION))

        showNormalNotification(mIsNormalColor)
    }

    private fun showNormalNotification(isNormalColor: Boolean = true) {
        val clickIntent = Intent(this, NotificationButtonListener::class.java)
        val pendingPlay = PendingIntent.getBroadcast(this, 0,
                clickIntent.setAction(NotificationButtonListener.ACTION_PLAY), 0)

        val pendingNext = PendingIntent.getBroadcast(this, 0,
                clickIntent.setAction(NotificationButtonListener.ACTION_NEXT), 0)

        val pendingClosedCaption = PendingIntent.getBroadcast(this, 0,
                clickIntent.setAction(NotificationButtonListener.ACTION_CLOSE_CAPTION), 0)

        val pendingShowNext = PendingIntent.getBroadcast(this, 0,
                clickIntent.setAction(NotificationButtonListener.ACTION_SHOW_NEXT), 0)

        val remoteViews = RemoteViews(packageName, R.layout.remote_view)
        remoteViews.setOnClickPendingIntent(R.id.playButton, pendingPlay)
        remoteViews.setOnClickPendingIntent(R.id.nextButton, pendingNext)
        remoteViews.setOnClickPendingIntent(R.id.ccButton, pendingClosedCaption)
        remoteViews.setOnClickPendingIntent(R.id.showNextButton, pendingShowNext)

        if (!isNormalColor) {
            remoteViews.setImageViewResource(R.id.playButton, R.drawable.ic_pause_play_button_2)
            remoteViews.setImageViewResource(R.id.nextButton, R.drawable.ic_play_next_37dp_2)
        } else {
            remoteViews.setImageViewResource(R.id.playButton, R.drawable.ic_pause_play_button)
            remoteViews.setImageViewResource(R.id.nextButton, R.drawable.ic_play_next_37dp)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notification = Notification.Builder(this, MyApplication.CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(TITLE)
                    .setCustomContentView(remoteViews)
                    .setOngoing(true)
                    .build()
            try {
                mManager?.notify(1, notification)
            } catch (e: Exception) {
                e.printStackTrace()
                val notification1 = Notification.Builder(this, MyApplication.CHANNEL_ID)
                        .setContentTitle(TITLE)
                        .setCustomContentView(remoteViews)
                        .setOngoing(true)
                        .build()
                try {
                    mManager?.notify(1, notification1)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } else {
            val notification = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(TITLE)
                    .setCustomContentView(remoteViews)
                    .setOngoing(true)
                    .build()
            try {
                mManager?.notify(1, notification)
            } catch (e: Exception) {
                e.printStackTrace()
                val notification1 = NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentTitle(TITLE)
                        .setCustomContentView(remoteViews)
                        .setOngoing(true)
                        .build()
                try {
                    mManager?.notify(1, notification1)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onDestroyNotification() {
        try {
            unregisterReceiver(mReceiver)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        mManager?.cancelAll()
    }

    override fun onGetService(): MMPresentationService {
        return this
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        mManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun onDestroy() {
        mBinder.onDestroy()
        mManager?.cancelAll()
        super.onDestroy()
    }

    fun onPlayOrPauseVideo() {
        mBinder.pauseOrPlay()
    }

    fun onNextVideo() {
        mBinder.nextVideo()
    }

    fun onShowNextVideos() {
        mBinder.showNextVideo()
    }

    private fun onClosedCaption() {
        mBinder.showClosedCaption()
        mIsNormalColor = !mIsNormalColor
        showNormalNotification(mIsNormalColor)
    }

    fun changeToNormalMode() {
        mIsNormalColor = true
        showNormalNotification(mIsNormalColor)
    }
}