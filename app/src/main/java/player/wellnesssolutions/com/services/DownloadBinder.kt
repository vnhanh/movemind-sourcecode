package player.wellnesssolutions.com.services

import android.app.NotificationManager
import android.content.Context
import android.os.Binder
import android.webkit.MimeTypeMap
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.network.datasource.download.DownloadApi
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.services.download.DownloadData
import player.wellnesssolutions.com.services.download.DownloadManagerCustomized
import java.io.File


class DownloadBinder(var listener: BinderDownloadListener) : Binder() {
    interface BinderDownloadListener {
        fun onGetService(): DownloadService
    }

    private var mListDownload = ArrayList<MMVideo>()
    private var mListDownloadFailure = ArrayList<MMVideo>()
    private var mService: DownloadService = listener.onGetService()

    fun getListDoesNotDownloaded(context: Context, isCalledComeFromUI: Boolean) {
//        Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | current thread: ${Thread.currentThread()} | name: ${Thread.currentThread().name}")
        mListDownload = VideoDBUtil.readDVideosFromDB(tag = Constant.TAG_VIDEO_DOWNLOAD)
        mListDownloadFailure = VideoDBUtil.readDVideosFailureFromDB(tag = Constant.TAG_VIDEO_DOWNLOAD)
//        Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | downloaded video number: ${mListDownload.size} | list download failed size: ${mListDownloadFailure.size}")
        if (mListDownload.isEmpty()) {
            if (mListDownloadFailure.isEmpty()) {
//                Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | downloaded list is empty | failed downloaded list is also empty")
                PreferenceHelper.getInstance()?.putBoolean(ConstantPreference.IS_DOWNLOAD_COMPLETELY, true)
                mService.onDownloadEnd()
                return
            } else {
                if (isCalledComeFromUI) {
                    for (v: MMVideo in mListDownloadFailure) {
                        if (v.id == null || v.downloadUrl.isNullOrEmpty()) {
                            return
                        }
//                        Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | mListDownloadFailure is not empty: ${mListDownloadFailure.size}")

                        DownloadManagerCustomized.getInstance(context).queueTask(
                                videoId = v.id!!.toInt(),
                                url = v.downloadUrl,
                                name = v.videoName,
                                folder = Constant.FOLDER_DOWNLOADED_VIDEOS,
                                hasPermission = true)

                    }
                }
                return
            }
        }

//        Log.d("LOG", this.javaClass.simpleName + " getListDoesNotDownloaded() | listDownloadNow size: ${mListDownload.size}")
        for (v: MMVideo in mListDownload) {
            if (v.id == null || v.downloadUrl.isNullOrEmpty()) {
                return
            }
            DownloadManagerCustomized.getInstance(context).queueTask(
                    videoId = v.id!!.toInt(),
                    url = v.downloadUrl,
                    name = v.videoName,
                    folder = Constant.FOLDER_DOWNLOADED_VIDEOS,
                    hasPermission = true)

        }
        DownloadVideoHelper.sendDownloadStatusToServer(context, Constant.DOWNLOAD_DOWNLOADING)
        //mService.onDownloadStart()
    }

    fun removeVideoWithId(data: IntArray) {
        val videosFromData = VideoDBUtil.readAllDVideosFromDB(Constant.TAG_VIDEO_DOWNLOAD)
        for (v: MMVideo in videosFromData) {
            for (i in data) {
                v.id?.let {
                    if (it == i) {
                        if (v.id == null || v.videoName == null || v.downloadUrl == null) return
                        VideoDBUtil.deleteDVideosFromDB(Constant.TAG_VIDEO_DOWNLOAD, v.id!!)
                        deleteFileWithId(mService.applicationContext, v.id!!, v.videoName!!, v.downloadUrl!!)
                    }
                }
            }
        }
    }

    fun deleteFileWithId(context: Context, videoId: Int, nameShowFile: String?, url: String?) {
        if (url == null) {
            return
        }
        val extension: String = MimeTypeMap.getFileExtensionFromUrl(url)
        val fileName: String = getSavedFileName(videoId.toString(), extension)
        val data: DownloadData = DownloadData(videoId = videoId, url = url).also {
            it.folder = Constant.FOLDER_DOWNLOADED_VIDEOS
            it.name = nameShowFile

            val internalFolder = File(context.filesDir, Constant.FOLDER_DOWNLOADED_VIDEOS)
            if (!internalFolder.exists()) internalFolder.mkdir()

            val downloadedFolder = File(context.filesDir, Constant.FOLDER_DOWNLOADED)
            if (!downloadedFolder.exists()) downloadedFolder.mkdir()

            if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(context)) {
                val externalUrl = context.getExternalFilesDirs(null)
                externalUrl?.get(1)?.let { file ->
                    val externalFolder = File(file, Constant.FOLDER_DOWNLOADED_VIDEOS)
                    if (!externalFolder.exists()) {
                        externalFolder.mkdir()
                    }
                    val downloadedFolderExternal = File(file,
                            Constant.FOLDER_DOWNLOADED)
                    if (!downloadedFolderExternal.exists()) {
                        downloadedFolderExternal.mkdir()
                    }
                    it.filePathExternal = File(file, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileName)).absolutePath
                }

            }

            it.filePath = File(context.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).absolutePath
        }

        if (data.filePathExternal != null) {
            data.filePathExternal?.also {
                val exFile = File(it)
                if (!exFile.exists()) {
                    data.filePath?.also { path ->
                        val file = File(path)
                        if (!file.exists()) return
                        file.delete()
                    }
                } else {
                    exFile.delete()
                }
            }
        } else {
            data.filePath?.also { path ->
                val file = File(path)
                if (!file.exists()) return
                file.delete()
            }
        }

    }

    private fun getSavedFileName(name: String, extension: String): String = String.format("%s.%s", name, extension)

    fun updateDataDVideos(data: IntArray) {
//        Log.d("LOG", this.javaClass.simpleName + " updateDataDVideos()")
        getAllVideosForDownloadWithId(mService.applicationContext, data)
    }


    private fun getAllVideosForDownloadWithId(context: Context, dataInt: IntArray) {
        val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            DownloadApi().getAllVideosFromServer(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<ArrayList<MMVideo>>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
                            super.onResponseSuccess(data)
                            if (data == null || data.data.size == 0) return
                            val dataSaveToDB = ArrayList<MMVideo>()
                            for (i in 0 until data.data.size) {
                                for (j in dataInt) {
                                    if (j == data.data[i].id) {
                                        if (VideoDBUtil.checkVideoAvailable(data = data.data[i], tag = Constant.TAG_VIDEO_DOWNLOAD)) {
                                            dataSaveToDB.add(data.data[i])
                                        }
                                    }

                                }
                            }
                            VideoDBUtil.createOrUpdateVideos(data = dataSaveToDB, tag = Constant.TAG_VIDEO_DOWNLOAD)
                            getListDoesNotDownloaded(context, false)
                        }

                        override fun onExpired(error: String) {

                        }

                    })
        }

    }

    fun downloadWhenChangeSubs(context: Context) {
//        Log.d("LOG", this.javaClass.simpleName + " downloadWhenChangeSubs() | current thread: ${Thread.currentThread()}")
        DownloadManagerCustomized.getInstance(context).cancelDownloadService()
        DownloadManagerCustomized.getInstance(context).stopNotify()
        DownloadManagerCustomized.getInstance(context).clearQueue()
        val nMgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        nMgr!!.cancelAll()
        getListDoesNotDownloaded(mService.applicationContext, false)
    }


    fun cancelNotifyWhenServiceKilled(context: Context) {
        DownloadManagerCustomized.getInstance(context).cancelDownloadService()
        val nMgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        nMgr!!.cancelAll()
    }

    fun getAllVideosForDownloadChangeSubs(context: Context) {
        val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
        if (deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            DownloadApi().getAllVideosFromServer(tokenAu, deviceId)
                    .subscribe(object : BaseResponseObserver<ArrayList<MMVideo>>() {
                        override fun onExpiredUnauthenticated(error: String) {

                        }

                        override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
                            super.onResponseSuccess(data)
                            if (data == null || data.data.size == 0) return
                            VideoDBUtil.saveDVideosToDB(data = data.data, tag = Constant.TAG_VIDEO_DOWNLOAD)
                            downloadWhenChangeSubs(mService.applicationContext)
                        }

                        override fun onExpired(error: String) {

                        }

                    })
        }

    }

    fun cancelDownloadByScanBarcode(context: Context) {
        DownloadManagerCustomized.getInstance(context).cancelDownloadService()
        DownloadManagerCustomized.getInstance(context).stopNotify()
        DownloadManagerCustomized.getInstance(context).clearQueue()
    }


}