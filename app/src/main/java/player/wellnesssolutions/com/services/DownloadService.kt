package player.wellnesssolutions.com.services

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.services.download.DownloadManagerCustomized
import player.wellnesssolutions.database.manager.DownloadDBManager
import player.wellnesssolutions.database.manager.IProgressListener

class DownloadService : Service(), IProgressListener, DownloadBinder.BinderDownloadListener {
    companion object {
        const val ACTION_DOWNLOAD = "player.wellnesssolution.com.au.download"
        const val ACTION_DOWNLOAD_UI = "player.wellnesssolution.com.au.download.ui"
        const val DOWNLOAD_VIDEO = "download_video"

        //        const val CHANGE_SUB_SERVICE = "change_sub_service"
        const val DOWNLOAD_VIDEO_UI = "download_video_ui"
        const val DATA_VIDEOS = "data_videos"
    }


    private val mBinder: DownloadBinder = DownloadBinder(this)

    private val mBroadcast: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("LOG", "DownloadService - mBroadcast - onReceive() | current thread: ${Thread.currentThread()}")
            if (context == null || intent == null) return
            when (intent.action) {
                ACTION_DOWNLOAD -> readScheduleIntent(intent)
            }
        }
    }

    private fun readScheduleIntent(intent: Intent) {
        when (intent.getStringExtra(DOWNLOAD_VIDEO)) {
            Constant.DOWNLOAD_START -> startDownload()
            Constant.API_CHANGE_SUB_SERVICE -> changeSubAPi()
            Constant.API_REMOVE_VIDEO_SERVICE -> removeVideoApi(intent)
            Constant.API_ADD_VIDEO_SERVICE -> addVideosApi(intent)
            Constant.CANCEL_DOWNLOAD -> cancelDownloadByBarCode()
        }

    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun addVideosApi(intent: Intent) {
        val data = intent.getIntArrayExtra(DATA_VIDEOS)
        mBinder.updateDataDVideos(data)
        DownloadVideoHelper.senStorageStatusToServer(this,
                FileUtil.getAvailableInternalMemorySize(),
                FileUtil.getTotalInternalMemorySize(),
                FileUtil.getAvailableExternalMemorySize(this),
                FileUtil.getTotalExternalMemorySize(this))
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun removeVideoApi(intent: Intent) {
        val data = intent.getIntArrayExtra(DATA_VIDEOS)
        mBinder.removeVideoWithId(data)
        DownloadVideoHelper.senStorageStatusToServer(this,
                FileUtil.getAvailableInternalMemorySize(),
                FileUtil.getTotalInternalMemorySize(),
                FileUtil.getAvailableExternalMemorySize(this),
                FileUtil.getTotalExternalMemorySize(this))

    }

    private fun changeSubAPi() {
        onChangeSub()
        clearAllDataDownload()
        mBinder.getAllVideosForDownloadChangeSubs(this)
        DownloadVideoHelper.senStorageStatusToServer(this,
                FileUtil.getAvailableInternalMemorySize(),
                FileUtil.getTotalInternalMemorySize(),
                FileUtil.getAvailableExternalMemorySize(this),
                FileUtil.getTotalExternalMemorySize(this))
    }

    private fun clearAllDataDownload() {
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED_VIDEOS)
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED)
        DownloadDBManager.getInstance().clearAll()
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("onCreate", "Download start......")
        try {
            registerReceive()
            DownloadManagerCustomized.getInstance(this).addListener(DownloadDBManager.getInstance())
            DownloadManagerCustomized.getInstance(this).addListener(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "Destroy download....")
        try {
            unregisterReceiver(mBroadcast)
            mBinder.cancelNotifyWhenServiceKilled(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }


    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        DownloadManagerCustomized.getInstance(this).release()
        //stopSelf()
    }

    override fun onGetService(): DownloadService {
        return this
    }

    private fun registerReceive() {
        val filter = IntentFilter().apply {
            addAction(ACTION_DOWNLOAD)
        }
        registerReceiver(mBroadcast, filter)
    }

    private fun startDownload() {
        Observable.fromCallable { }.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe {
                    mBinder.getListDoesNotDownloaded(this, true)
                }
    }

    override fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String) {
        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | filename: $fileName")
//        VideoDBUtil.addDownloadedVideo(videoId, Constant.MM_VIDEO_DOWNLOADED)
        //onUpDateDownload()
    }

    override fun onDoesNotEnoughMemory() {
        super.onDoesNotEnoughMemory()
        onDownLoadMemory()
    }

    override fun onDownloaded() {
        super.onDownloaded()
        Log.d("LOG", this.javaClass.simpleName + " onDownloaded() | current thread: ${Thread.currentThread()}")
        mBinder.getListDoesNotDownloaded(this, false)
    }

    override fun deleteVideoIdWhenDownloadFailed(videoId: Int, fileName: String?, url: String?) {
        super.deleteVideoIdWhenDownloadFailed(videoId, fileName, url)
        mBinder.deleteFileWithId(this, videoId, fileName, url)
    }

    fun onDownloadStart() {
        val intent = Intent().apply {
            action = ACTION_DOWNLOAD_UI
            putExtra(DOWNLOAD_VIDEO_UI, Constant.DOWNLOAD_START_UI)
        }
        this.sendBroadcast(intent)
    }

    private fun onUpDateDownload() {
        val intent = Intent().apply {
            action = ACTION_DOWNLOAD_UI
            putExtra(DOWNLOAD_VIDEO_UI, Constant.DOWNLOAD_UPDATE_UI)
        }
        this.sendBroadcast(intent)
    }

    fun onDownloadEnd() {
        val intent = Intent().apply {
            action = ACTION_DOWNLOAD_UI
            putExtra(DOWNLOAD_VIDEO_UI, Constant.DOWNLOAD_END_UI)
        }
        this.sendBroadcast(intent)
        DownloadVideoHelper.sendDownloadStatusToServer(this, Constant.DOWNLOAD_COMPLETED)
    }

    private fun onChangeSub() {
        val intent = Intent().apply {
            action = ACTION_DOWNLOAD_UI
            putExtra(DOWNLOAD_VIDEO_UI, Constant.DOWNLOAD_CHANGE_SUB_UI)
        }
        this.sendBroadcast(intent)
    }

    private fun onDownLoadMemory() {
        val intent = Intent().apply {
            action = ACTION_DOWNLOAD_UI
            putExtra(DOWNLOAD_VIDEO_UI, Constant.DOWNLOAD_END_UI_MEMORY)
        }
        this.sendBroadcast(intent)
        DownloadVideoHelper.sendDownloadStatusToServer(this, Constant.DOWNLOAD_FAILIED)
    }

    private fun cancelDownloadByBarCode() {
        mBinder.cancelDownloadByScanBarcode(this)
    }
}