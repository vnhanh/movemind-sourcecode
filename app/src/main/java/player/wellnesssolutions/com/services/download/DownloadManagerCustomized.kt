package player.wellnesssolutions.com.services.download

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.webkit.MimeTypeMap
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import player.wellnesssolutions.com.services.notification.DownloadNotification
import player.wellnesssolutions.database.manager.IProgressListener
import java.io.File
import java.lang.ref.WeakReference
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
        const val ERR_USER_CANCEL = "The downloaded file has been canceled !"

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

    private val mQueue = ArrayList<DownloadData>()
    private val mQueueMap: HashMap<Int, Boolean> = HashMap()

    private val mListeners: ArrayList<IProgressListener> = ArrayList()

    private var mIsDownloading = false
    private var mapNotifiedNotEnoughSpace = ArrayList<IProgressListener>()

    private val mNotiManager = DownloadNotification(context)

    init {
        NetworkReceiver.getInstance().addListener(this)
    }

    fun cancelDownloadService() {
        mDownloadTask?.cancel(true)
        mIsDownloading = false
    }

    override fun onChangedState(isConnected: Boolean) {
        Log.d("LOG", this.javaClass.simpleName + " onChangedState() | isConnected: ${isConnected}")
        when (isConnected && ParameterUtils.isGoToMainActivity) {
            true -> {
                Log.d("LOG", this.javaClass.simpleName + " onChangedState() | startDownload()")
                startDownload()
            }

            false -> {
                Log.d("LOG", this.javaClass.simpleName + " onChangedState() | set data")
                ParameterUtils.isGoToMainActivity = true
            }
        }
    }

    override fun onDownloadStarted(id: Int?, name: String?) {
        Log.d("LOG", this.javaClass.simpleName + " onDownloadStarted() | fileName: ${name} | id: $id")
        if (id == null) return

        for (listener: IProgressListener in mListeners) {
            listener.onDownloadStarted(id)
        }
    }

    override fun onDownloadUpdate(id: Int?, name: String?, progress: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " onDownloadUpdate() | fileName: ${name} | progress: $progress")
    }

    override fun onInsufficientSpace(videoId: Int?, name: String?, availableSpace: Long, fileSize: Long) {
        for (listener: IProgressListener in mListeners) {
            listener.onDoesNotEnoughMemory()
        }
    }

    override fun onDownloadFailed(id: Int?, name: String?, reason: String, url: String?) {
        Log.d("LOG", this.javaClass.simpleName + " onDownloadFailed() | fileName: ${name} | reason: $reason")
        if (id == null) return
        when (reason) {
            DownloadTask.ERR_NETWORK_DISCONNECTED -> {
            }

            else -> {
                getDownloadDataByVideoId(id)?.also { data ->
                    resetData()
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
                mIsDownloading = false
                startDownload()
            }
        }
    }

    override fun onDownloadCompleted(id: Int?, name: String?) {
        Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | fileName: ${name}")
        if (id == null) return
        getDownloadDataByVideoId(id)?.also { data ->
            resetDataNotDelete()
            for (listener: IProgressListener in mListeners) {
                listener.onDownloadCompleted(
                        videoId = data.videoId,
                        fileName = data.name,
                        isSuccess = true,
                        message = "")
            }
            Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | context: $context")
            context?.let {
                Log.d("LOG", this.javaClass.simpleName + " onDownloadCompleted() | send storage info to server")
                DownloadVideoHelper.senStorageStatusToServer(it,
                        FileUtil.getAvailableInternalMemorySize(),
                        FileUtil.getTotalInternalMemorySize(),
                        FileUtil.getAvailableExternalMemorySize(it),
                        FileUtil.getTotalExternalMemorySize(it))
            }
        }
        if (mQueue.isEmpty()) {
            for (listener: IProgressListener in mListeners) {
                listener.onDownloaded()
            }
            return
        }
        mIsDownloading = false
        startDownload()
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

    fun isDownloading(videoId: Int?): Boolean = mQueueMap[videoId] ?: false

    fun release() {
        mNotiManager.stop()
        mNotiManager.release()
        mDownloadTask?.release()
        mQueue.clear()
        mQueueMap.clear()
        mListeners.clear()
        INSTANCE = null
    }

    fun stopNotify() {
        mNotiManager.stop()
    }

    /*
     * Add new download data into queue
     * and start download task if it is only
     */
    fun addTask(videoId: Int, url: String?, name: String?, folder: String, hasPermission: Boolean = true) {
//        Log.d("LOG", this.javaClass.simpleName + " addTask() | url: $url | name: $name")
        if (url.isNullOrEmpty() || name.isNullOrEmpty()) {
            return
        }

        // video downloading task exists
        if (checkIfTaskExist(videoId)) {
            return
        }

        //notifyOnDownloadStarted(videoId)

        val extension: String = MimeTypeMap.getFileExtensionFromUrl(url)

        val fileName: String = getSavedFileName(videoId.toString(), extension)
        val fileNameShowNotification: String = getSavedFileName(name, extension)

        val isFileExist = checkIfFileExist(videoId = videoId, fileName = fileName, path = String.format("%s/%s", folder, name))
//        Log.d("LOG", this.javaClass.simpleName + " addTask() | isFileExist: $isFileExist")
        if(isFileExist) return

        try {
            Observable.just(1L).subscribeOn(Schedulers.computation())
                    .flatMap { value: Long ->
                         Observable.fromCallable {
                             val connection: HttpURLConnection = URL(url).openConnection() as HttpURLConnection
                             connection.setRequestProperty("Cookie", mCookieValue)
                             connection.contentLength.toLong()
                         }.subscribeOn(Schedulers.trampoline())
                    }.observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Long?> {
                override fun onComplete() {}

                override fun onSubscribe(d: Disposable) {}

                override fun onNext(fileLength: Long) {
                    val availableSpaceExternal = FileUtil.getAvailableExternalMemorySize(context = context)
                    Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | start to calculate free space on device | fileLength: $fileLength | availableSpaceExternal: $availableSpaceExternal")
                    when (fileLength < availableSpaceExternal) {
                        true -> {
                            Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | store new downloaded video on external storage")
                            createDownloadTask(videoId, url, folder, hasPermission, fileName, fileNameShowNotification)
                        }
                        false -> {
                            val availableSpaceInternal: Long = FileUtil.getAvailableInternalMemorySize()
                            Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | start to calculate free space on device | fileLength: $fileLength | availableSpaceInternal: $availableSpaceInternal")
                            when (fileLength < availableSpaceInternal) {
                                true -> {
                                    Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | store new downloaded video on internal storage")
                                    createDownloadTaskInternal(videoId, url, folder, hasPermission, fileName, fileNameShowNotification)
                                }
                                false -> {
                                    Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | not enough space | emit listeners")
                                    for (listener: IProgressListener in mListeners) {
                                        if (!mapNotifiedNotEnoughSpace.contains(listener)){
                                            Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | listener: ${listener}")
                                            listener.onDoesNotEnoughMemory()
                                            mapNotifiedNotEnoughSpace.add(listener)
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

                override fun onError(e: Throwable) {
                    Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | can not start downloading video | error: ${e.message}")
                    notifyDownloadCannotStart(videoId, fileName)
                }

            })
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    private fun notifyDownloadCannotStart(videoId: Int, fileName: String) {
        nextDownload(videoId, fileName)
    }

    private fun createDownloadTask(videoId: Int, url: String, folder: String, hasPermission: Boolean = true,
                                   fileNameDownload: String, nameShowFile: String) {
        Log.d("LOG", this.javaClass.simpleName + " createDownloadTask() | queue size: ${mQueue.size}")
        val data: DownloadData = DownloadData(videoId = videoId, url = url).also {
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

        mQueue.add(data)
        mQueueMap[videoId] = true

        if (hasPermission && mQueue.size == 1)
            startDownload()
    }

    private fun createDownloadTaskInternal(videoId: Int, url: String, folder: String, hasPermission: Boolean = true,
                                           fileNameDownload: String, nameShowFile: String) {
        Log.d("LOG", this.javaClass.simpleName + " createDownloadTaskInternal() | queue size: ${mQueue.size} | ")
        val data: DownloadData = DownloadData(videoId = videoId, url = url).also {
            it.folder = folder
            it.name = nameShowFile

            val internalFolder = File(context?.filesDir, folder)
            if (!internalFolder.exists()) internalFolder.mkdir()

            val downloadedFolder = File(context?.filesDir, Constant.FOLDER_DOWNLOADED)
            if (!downloadedFolder.exists()) downloadedFolder.mkdir()

            it.filePath = File(context?.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED,
                    fileNameDownload)).absolutePath
        }

        mQueue.add(data)
        mQueueMap[videoId] = true

        if (hasPermission && mQueue.size == 1)
            startDownload()
    }

    // check if internal file exist
    private fun checkIfFileExist(videoId: Int, fileName: String, path: String) : Boolean {
        context?.also { context ->
            if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(context)) {
                val externalUrl = context.getExternalFilesDirs(null)
                if (externalUrl?.get(1) != null) {
                    if (File(externalUrl[1],
                                    String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).exists()) {
//                        File(externalUrl[1],
//                                String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).delete()
                        return true
                    } else if ((File(context.filesDir, String.format("%s/%s",
                                    Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
//                        File(context.filesDir, String.format("%s/%s",
//                                Constant.FOLDER_DOWNLOADED, fileName)).delete()
                        return true
                    }
                } else if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
//                    File(context.filesDir, String.format("%s/%s",
//                            Constant.FOLDER_DOWNLOADED, fileName)).delete()
                    return true
                }

            } else {
                if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
//                    File(context.filesDir, String.format("%s/%s",
//                            Constant.FOLDER_DOWNLOADED, fileName)).delete()
                    return true
                }
            }
        }
        return false
    }

    private fun checkIfTaskExist(videoId: Int): Boolean {
        if (mQueueMap.isNotEmpty() && mQueueMap.containsKey(videoId)) {
            return true
        }
        return false
    }

    private fun startDownload() {
        Log.d("LOG", this.javaClass.simpleName + " startDownloadIfIdle() | mIsDownloading: $mIsDownloading | queue size: ${mQueue.size}")
        if (mQueue.size == 0 || context == null) {
            for (listener: IProgressListener in mListeners) {
                listener.onDownloaded()
            }
            return
        }
        if (mIsDownloading) return
        val data: DownloadData = mQueue[0]
        Log.d("LOG", this.javaClass.simpleName + " startDownload()")
        addDownloadTask(downloadData = data)
    }

    private fun addDownloadTask(downloadData: DownloadData) {
        try {
            context?.also { context ->
                if (mDownloadTask != null) {
                    mDownloadTask?.cancel(true)
                    mDownloadTask = null
                }
                mDownloadTask = DownloadTask(context, this).apply {
                    mNotiManager.also {
                        addListener(it)
                    }
                    DownloadVideoHelper.sendDownloadStatusToServer(context, Constant.DOWNLOAD_DOWNLOADING)
                }
                Log.d("LOG", this.javaClass.simpleName + " addDownloadTask() | status: ${mDownloadTask?.status}")

                mIsDownloading = true
                mDownloadTask?.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, downloadData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("LOG", this.javaClass.simpleName + " addDownloadTask() | error: ${e.message}")
            mIsDownloading = false
            onDownloadFailed((downloadData.id?:0L).toInt(), downloadData.name, e.message.orEmpty(), downloadData.url)
        }

    }

    private fun notifyDownloadCompleted(data: DownloadData, isSuccess: Boolean, message: String = "") {
        // notify to Activity scope listener
        for (listener: IProgressListener in mListeners) {
            listener.onDownloadCompleted(videoId = data.videoId, fileName = data.name, isSuccess = isSuccess, message = message)
        }

    }

    private fun getDownloadDataByVideoId(id: Int): DownloadData? {
        for (data: DownloadData in mQueue) {
            if (data.videoId == id) {
                return data
            }
        }
        return null
    }

    // reset all init data for starting download task
    private fun resetData() {
        if (mQueue.size > 0) {
            mQueueMap.remove(key = mQueue[0].videoId)
            mQueue.removeAt(0)
        }
        deleteFileIfExist()
        mIsDownloading = false
    }

    private fun resetDataNotDelete() {
        if (mQueue.size > 0) {
            mQueueMap.remove(key = mQueue[0].videoId)
            mQueue.removeAt(0)
        }

        mIsDownloading = false
    }

    private fun deleteFileIfExist() {
        if (mQueue.size == 0) return
        val data = mQueue[0]
        data.filePath?.also { path ->
            val file = File(path)
            if (!file.exists()) return
            file.delete()
        }
    }

    private fun nextDownload(videoId: Int, name: String?) {
        for (listener: IProgressListener in mListeners) {
            listener.updateVideoIdWhenDownloadFailed(videoId = videoId)
            listener.onDownloaded()
        }
    }

    fun clearQueue() {
        if (mQueue.size > 0) {
            mQueue.clear()
        }
        if (mQueueMap.size > 0) {
            mQueueMap.clear()
        }
    }

    // get stored file name by video id
    private fun getSavedFileName(name: String, extension: String): String = String.format("%s.%s", name, extension)
}