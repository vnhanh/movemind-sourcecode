package player.wellnesssolutions.com.services.download

import android.content.Context
import android.os.AsyncTask
import android.webkit.MimeTypeMap
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import player.wellnesssolutions.com.services.notification.DownloadNotification
import player.wellnesssolutions.database.manager.IProgressListener
import java.io.File
import java.net.HttpURLConnection
import java.net.URL


/**
 * This manager class contain a queue download data and manage download work
 * It download one by one until the queue is empty
 * When download task completed, its download data would be removed from the queue
 * If network interrupted while download task running, this manager would restart downloading once network reconnect
 * If download data invalid, they would be deleted and the manager start the next download task (if exist)
 */
class DownloadManagerCustomized(private var context: Context?) : DownloadTask.Callback, NetworkReceiver.IStateListener {

    companion object {
        private var INSTANCE: DownloadManagerCustomized? = null

        fun getInstance(context: Context): DownloadManagerCustomized {
            if (INSTANCE == null) {
                INSTANCE = DownloadManagerCustomized(context.applicationContext)
            }
            return INSTANCE!!
        }
    }

    private var mCookieValue = PreferenceHelper.getInstance()?.getString(ConstantPreference.SP_COOKIE, "").orEmpty()
    private var mDownloadTask: DownloadTask? = null

//    private val mQueue = ArrayList<DownloadData>()
    private var downloadingData: DownloadData? = null

    private val mListeners: ArrayList<IProgressListener> = ArrayList()

//    private var mIsDownloading = false
    private var mapNotifiedNotEnoughSpace = ArrayList<IProgressListener>()

    private val mNotiManager = DownloadNotification(context?.applicationContext)
    private val disposable = CompositeDisposable()
    private var isConnecting: Boolean = NetworkReceiver.getInstance().isNetworkConnected()

    init {
        NetworkReceiver.getInstance().addListener(this)
    }

    fun cancelDownloadService() {
        mDownloadTask?.cancel(true)
        mDownloadTask?.release()
        downloadingData = null
    }

    override fun onChangedState(isConnected: Boolean) {
        if(isConnecting == isConnected) return
        isConnecting = isConnected
//        Log.d("LOG", this.javaClass.simpleName + " onChangedState() | isConnected: ${isConnected}")
        when (isConnected) {
            true -> {
                reDownloadAfterReconnect()
            }

            false -> {
//                Log.d("LOG", this.javaClass.simpleName + " onChangedState() | set data")
                ParameterUtils.isGoToMainActivity = true
                handleOnDisconnectNetwork()
            }
        }
    }

    private fun reDownloadAfterReconnect() {
//        Log.d("LOG", this.javaClass.simpleName + " onChangedState() | is downloading: ${downloadingData != null}")
        clearDownloadTask()
        addTaskFromQueueInit()
    }

    private fun handleOnDisconnectNetwork() {
//        Log.d("LOG", this.javaClass.simpleName + " handleOnDisconnectNetwork()")
    }

    private fun clearDownloadTask() {
//        Log.d("LOG", this.javaClass.simpleName + " clearDownloadTask()")
        mDownloadTask?.also { task ->
            if(task.status != AsyncTask.Status.FINISHED){
                task.cancel(true)
                task.release()
            }
        }
        resetDataNotDeleteFile()
    }

    override fun onDownloadStarted(id: Int?, name: String?) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadStarted() | fileName: ${name} | id: $id")
        if (id == null) return
        for (listener: IProgressListener in mListeners) {
            listener.onDownloadStarted(id)
        }
    }

    override fun onDownloadUpdate(id: Int?, name: String?, progress: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadUpdate() | fileName: ${name} | progress: $progress | current thread: ${Thread.currentThread()}")
    }

    override fun onInsufficientSpace(videoId: Int?, name: String?, availableSpace: Long, fileSize: Long) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadFailed()")
        mDownloadTask?.release()
        for (listener: IProgressListener in mListeners) {
            listener.onDoesNotEnoughMemory()
        }
        release()
    }

    override fun onDownloadFailed(id: Int?, name: String?, reason: String, url: String?) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadFailed() | fileName: ${name} | reason: $reason | isConnecting: $isConnecting")
        when {
            !NetworkReceiver.getInstance().checkConnectState(context) || reason == DownloadTask.ERR_NETWORK_DISCONNECTED -> {
//                Log.d("LOG", this.javaClass.simpleName + " onDownloadFailed() | recoveryDownload()")
                recoveryDownload()
            }

            else -> {
                mDownloadTask?.cancel(true)
                mDownloadTask?.release()
                downloadingData?.also { data ->
                    for (listener: IProgressListener in mListeners) {
                        listener.updateVideoIdWhenDownloadFailed(videoId = data.videoId)
                        listener.deleteVideoIdWhenDownloadFailed(
                                videoId = data.videoId,
                                fileName = data.name,
                                url = url)
                    }
                    context?.let {
                        DownloadVideoHelper.sendDownloadStatusToServer(it, Constant.DOWNLOAD_FAILIED)
                    }
                }
                recoveryDownload()

                for (listener: IProgressListener in mListeners) {
//                    Log.d("LOG", this.javaClass.simpleName + " onDownloadFailed() | listener: $listener")
                    listener.onDownloaded()
                }

                addTaskFromQueueInit()
            }
        }
    }

    override fun onDownloadCompleted(id: Int?, name: String?) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | context: $context |" +
//                " fileName: ${name} | id: $id")
        val d =
            Observable.just(id)
                .subscribeOn(Schedulers.single())
                .subscribe({ videoId ->
//                    Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | subscriber")
                    if (videoId != null) {
                        downloadingData?.also { data ->
                            for (listener: IProgressListener in mListeners) {
                                listener.onDownloadCompleted(
                                    videoId = data.videoId,
                                    fileName = data.name,
                                    isSuccess = true,
                                    message = "")
                            }
                            context?.let {
//                        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | send storage info to server |" +
//                            "is download completely: ${PreferenceHelper.getInstance()?.getBoolean(ConstantPreference.IS_DOWNLOAD_COMPLETELY, false)}")
                                DownloadVideoHelper.senStorageStatusToServer(it,
                                    FileUtil.getAvailableInternalMemorySize(),
                                    FileUtil.getTotalInternalMemorySize(),
                                    FileUtil.getAvailableExternalMemorySize(it),
                                    FileUtil.getTotalExternalMemorySize(it))
                            }
                        }
                        VideoDBUtil.updateTabledVideoDownloadedState(videoId)
                    }
                    resetDataNotDeleteFile()
                    for (listener: IProgressListener in mListeners) {
//            Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | listener: $listener")
                        listener.onDownloaded()
                    }
                    if(PreferenceHelper.getInstance()?.getBoolean(ConstantPreference.IS_DOWNLOAD_COMPLETELY, false) == true){
                        release()
                    } else {
                        addTaskFromQueueInit()
                    }
                }, {
                    it.printStackTrace()
//                    Log.d("LOG", "DownloadManagerCustomized onDownloadCompleted() | subscribe error: ${it.message}")
                    FirebaseCrashlytics.getInstance().recordException(it)
                    resetDataNotDeleteFile()
                    for (listener: IProgressListener in mListeners) {
                        listener.onDownloaded()
                    }
                    if(PreferenceHelper.getInstance()?.getBoolean(ConstantPreference.IS_DOWNLOAD_COMPLETELY, false) == true){
                        release()
                    } else {
                        addTaskFromQueueInit()
                    }
                })
        disposable.add(d)
    }

    /**
     * add, remove listeners and release
     */
    fun addListener(listener: IProgressListener) {
        mListeners.add(listener)
    }

    fun removeListener(listener: IProgressListener) {
        mListeners.remove(listener)
    }

    fun isDownloading(videoId: Int?): Boolean = downloadingData?.id == videoId?.toLong()

    fun release() {
//        Log.d("LOG", this.javaClass.simpleName + " release()")
        try{
            mapNotifiedNotEnoughSpace.clear()
            mListeners.clear()
        }catch (e:Exception){
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("download manager release")
        }
        disposable.dispose()
        mNotiManager.stop()
        mNotiManager.release()
        mDownloadTask?.release()
        queueInit.clear()
        downloadingData = null
        INSTANCE = null
    }

    fun stopNotify() {
        mNotiManager.stop()
    }

    /*
     * Add new download data into queue
     * and start download task if it is only
     */
    private class ModelDataInit(val videoId: Int, val url: String?, val name: String?, val folder: String, val hasPermission: Boolean = true)

    private val queueInit = ArrayList<ModelDataInit>()

    fun queueTask(videoId: Int, url: String?, name: String?, folder: String, hasPermission: Boolean = true) {
//        Log.d("LOG", this.javaClass.simpleName + " queueTask() | url: $url | name: $name | videoId: $videoId")
        if (url.isNullOrBlank() || name.isNullOrBlank()) {
            return
        }

        // video downloading task exists
        if (checkIfTaskExistInQueueInit(videoId)) {
            return
        }
        queueInit.add(ModelDataInit(videoId, url, name, folder, hasPermission))
//        Log.d("LOG", this.javaClass.simpleName + " queueTask() | queueInit size: ${queueInit.size}")
        if (queueInit.size > 1) {
            return
        }
//        Log.d("LOG", this.javaClass.simpleName + " queueTask() | continue")
        addTaskFromQueueInit()
    }

    private fun addTaskFromQueueInit() {
//        Log.d("LOG", this.javaClass.simpleName + " addTaskFromQueueInit() | queueInit size: ${queueInit.size}")
        if (queueInit.size == 0) {
            stopNotify()
            release()
            return
        }
        val dataInit = queueInit[0]
        addTask(dataInit.videoId, dataInit.url, dataInit.name, dataInit.folder, dataInit.hasPermission)
    }

    private fun addTask(videoId: Int, url: String?, name: String?, folder: String, hasPermission: Boolean = true) {
//        Log.d("LOG", this.javaClass.simpleName + " addTask() | url: $url | name: $name")
        if (url.isNullOrBlank() || name.isNullOrBlank()) {
            stopNotify()
            resetDataNotDeleteFile()
            addTaskFromQueueInit()
            return
        }

        // video downloading task exists
        if (downloadingData?.id == videoId.toLong()) {
//            Log.d("LOG", this.javaClass.simpleName + " addTask() | download task has been already existed | name: $name")
            if(mDownloadTask == null || mDownloadTask?.isCancelled == true){
                mDownloadTask?.release()
                downloadingData = null
                addTaskFromQueueInit()
            }
            return
        }

        val extension: String = MimeTypeMap.getFileExtensionFromUrl(url)

        val fileName: String = getSavedFileName(videoId.toString(), extension)
        val fileNameShowNotification: String = getSavedFileName(name, extension)

        val d =
            Observable.fromCallable {
                deleteIfExist(fileName = fileName)
//                Log.d("LOG", this.javaClass.simpleName + " addTask() | current thread: ${Thread.currentThread()} | name: ${Thread.currentThread().name}")
                val connection: HttpURLConnection = URL(url).openConnection() as HttpURLConnection
                connection.setRequestProperty("Cookie", mCookieValue)
                connection.connectTimeout = 60000
                connection.contentLength.toLong()
            }.subscribeOn(Schedulers.single())
                .subscribe({ fileLength ->
//                Log.d("LOG", this.javaClass.simpleName + " addTask() | inited connection")
                val availableSpaceExternal = FileUtil.getAvailableExternalMemorySize(context = context)
//                Log.d("LOG", this.javaClass.simpleName + " addTask() | start to calculate free space on device | fileLength: $fileLength | availableSpaceExternal: $availableSpaceExternal")
                when (fileLength < availableSpaceExternal) {
                    true -> {
//                        Log.d("LOG", this.javaClass.simpleName + " addTask() | store new downloaded video on external storage | current thread: ${Thread.currentThread()}")
                        createDownloadTask(videoId, url, folder, hasPermission, fileName, fileNameShowNotification)
                    }
                    false -> {
                        val availableSpaceInternal: Long = FileUtil.getAvailableInternalMemorySize()
//                        Log.d("LOG", this.javaClass.simpleName + " addTask() | start to calculate free space on device | fileLength: $fileLength | " +
//                                "availableSpaceInternal: $availableSpaceInternal | current thread: ${Thread.currentThread()}")
                        when (fileLength < availableSpaceInternal) {
                            true -> {
//                                Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | store new downloaded video on internal storage")
                                createDownloadTaskInternal(videoId, url, folder, hasPermission, fileName, fileNameShowNotification)
                            }
                            false -> {
//                                Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | not enough space | emit listeners")
                                for (listener: IProgressListener in mListeners) {
                                    if (!mapNotifiedNotEnoughSpace.contains(listener)) {
    //                                                    Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | listener: ${listener}")
                                        listener.onDoesNotEnoughMemory()
                                        mapNotifiedNotEnoughSpace.add(listener)
                                    }
                                }
                                release()
                            }
                        }
                    }
                }
            }, { e ->
//                Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | can not start downloading video | error: ${e} | ${e.message}")
                notifyDownloadCannotStart(videoId)
            })
        disposable.add(d)
    }

    private fun notifyDownloadCannotStart(videoId: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " notifyDownloadCannotStart() | videoId: $videoId")
        mNotiManager.stop()
        nextDownload(videoId)
    }

    private fun createDownloadTask(
        videoId: Int,
        url: String,
        folder: String,
        hasPermission: Boolean = true,
        fileNameDownload: String,
        nameShowFile: String
    ) {
//        Log.d("LOG", this.javaClass.simpleName + " createDownloadTask()")
        downloadingData = DownloadData(videoId = videoId, url = url).also {
            it.folder = folder
            it.name = nameShowFile

            val internalFolder = File(context?.filesDir, folder)
            if (!internalFolder.exists()) internalFolder.mkdir()

            val downloadedFolder = File(context?.filesDir, Constant.FOLDER_DOWNLOADED)
            if (!downloadedFolder.exists()) downloadedFolder.mkdir()

            if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(context)) {
                val externalUrl = context?.getExternalFilesDirs(null)
                externalUrl?.get(1)?.let { file ->
                    val externalFolder = File(file, folder)
                    if (!externalFolder.exists()) {
                        externalFolder.mkdir()
                    }
                    val downloadedFolderExternal = File(file,
                            Constant.FOLDER_DOWNLOADED)
                    if (!downloadedFolderExternal.exists()) {
                        downloadedFolderExternal.mkdir()
                    }
                    it.filePathExternal = File(file, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileNameDownload)).absolutePath
                }

            }

            it.filePath = File(context?.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED,
                    fileNameDownload)).absolutePath
        }

        if (hasPermission) startDownload()
    }

    private fun createDownloadTaskInternal(videoId: Int, url: String, folder: String, hasPermission: Boolean = true,
                                           fileNameDownload: String, nameShowFile: String) {
//        Log.d("LOG", this.javaClass.simpleName + " createDownloadTaskInternal()")
        downloadingData = DownloadData(videoId = videoId, url = url).also {
            it.folder = folder
            it.name = nameShowFile

            val internalFolder = File(context?.filesDir, folder)
            if (!internalFolder.exists()) internalFolder.mkdir()

            val downloadedFolder = File(context?.filesDir, Constant.FOLDER_DOWNLOADED)
            if (!downloadedFolder.exists()) downloadedFolder.mkdir()

            it.filePath = File(context?.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED,
                    fileNameDownload)).absolutePath
        }

        if (hasPermission)
            startDownload()
    }

    // check if internal file exist
    private fun deleteIfExist(fileName: String) {
        context?.also { context ->
            if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(context)) {
                val externalUrl = context.getExternalFilesDirs(null)
                if (externalUrl?.get(1) != null) {
                    if (File(externalUrl[1],
                                    String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).exists()) {
                        File(externalUrl[1],
                                String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).delete()
                    } else if ((File(context.filesDir, String.format("%s/%s",
                                    Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                        File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).delete()
                    }
                } else if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                    File(context.filesDir, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileName)).delete()
                }

            } else {
                if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                    File(context.filesDir, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileName)).delete()
                }
            }
        }
    }

    private fun checkIfTaskExistInQueueInit(videoId: Int): Boolean {
        for (queue in queueInit){
            if(queue.videoId == videoId){
                return true
            }
        }
        return false
    }

    private fun startDownload() {
//        Log.d("LOG", this.javaClass.simpleName + " startDownloadIfIdle() | " +
//                "queueInit size: ${queueInit.size}")
        if (context == null) {
//            Log.d("LOG", this.javaClass.simpleName + " startDownload() | mQueue: ${mQueue.size} | context: $context")
            for (listener: IProgressListener in mListeners) {
                listener.onDownloaded()
            }
            return
        }
        downloadingData?.also { data ->
            addDownloadTask(downloadData = data)
        }
    }

    private fun addDownloadTask(downloadData: DownloadData) {
        try {
            context?.also { context ->
                if (mDownloadTask != null) {
                    mDownloadTask?.cancel(true)
                    mDownloadTask?.release()
                    mDownloadTask = null
                }
                mDownloadTask = DownloadTask(context, this, downloadData).apply {
                    mNotiManager.also {
                        addListener(it)
                    }
                    DownloadVideoHelper.sendDownloadStatusToServer(context, Constant.DOWNLOAD_DOWNLOADING)
                }
//                Log.d("LOG", this.javaClass.simpleName + " addDownloadTask() | status: ${mDownloadTask?.status}")
                mDownloadTask?.execute()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("download-create task exception")
//            Log.d("LOG", this.javaClass.simpleName + " addDownloadTask() | error: ${e.message}")
            mNotiManager.stop()
            onDownloadFailed((downloadData.id ?: 0L).toInt(), downloadData.name, e.message.orEmpty(), downloadData.url)
        }

    }

    // reset all init data for starting download task
    private fun recoveryDownload() {
        deleteFileIfExist()
        resetDataNotDeleteFile()
    }

    private fun resetDataNotDeleteFile() {
//        Log.d("LOG", this.javaClass.simpleName + " resetDataNotDelete() | mQueue size: ${mQueue.size} | queueInit.size: ${queueInit.size} ")

        downloadingData = null
        if (queueInit.size > 0) {
            queueInit.removeAt(0)
        }
    }

    private fun deleteFileIfExist() {
        if (downloadingData == null) return
        downloadingData?.filePath?.also { path ->
            val file = File(path)
            if (!file.exists()) return
            file.delete()
        }
    }

    private fun nextDownload(videoId: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " nextDownload() | mQueue: ${mQueue.size} | videoId: $videoId")
        for (listener: IProgressListener in mListeners) {
            listener.updateVideoIdWhenDownloadFailed(videoId = videoId)
            listener.onDownloaded()
        }
        addTaskFromQueueInit()
    }

    fun clearQueue() {
        downloadingData = null
    }

    // get stored file name by video id
    private fun getSavedFileName(name: String, extension: String): String = String.format("%s.%s", name, extension)
}