package player.wellnesssolutions.com.base.common.download

import android.content.Context
import android.util.Log
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.download.DownloadApi
import player.wellnesssolutions.com.network.datasource.storage.StorageApi
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.download.DownloadManagerCustomized

object DownloadVideoHelper {
    private val links = ArrayList<String>()

    init {
        links.add("http://mirrors.standaloneinstaller.com/video-sample/star_trails.mov")
//        links.add("http://mirrors.standaloneinstaller.com/video-sample/page18-movie-4.avi")
//        links.add("http://mirrors.standaloneinstaller.com/video-sample/TRA3106.wmv")
        links.add("http://mirrors.standaloneinstaller.com/video-sample/video-sample.wmv")
        links.add("http://mirrors.standaloneinstaller.com/video-sample/star_trails.wmv")
        links.add("http://mirrors.standaloneinstaller.com/video-sample/page18-movie-4.mpg")
        links.add("http://mirrors.standaloneinstaller.com/video-sample/Panasonic_HDC_TM_700_P_50i.mpg")
    }

    fun download(context: Context, data: MMVideo?, hasPermission: Boolean) {
        if (data?.id == null || data.downloadUrl.isNullOrEmpty()) {
            MessageUtils.showToast(context, R.string.download_failed_video_id_empty, R.color.yellow)
            return
        }

        DownloadManagerCustomized.getInstance(context)
                .queueTask(
                        videoId = data.id!!,
                        url = data.downloadUrl,
                        name = data.videoName,
                        folder = Constant.FOLDER_DOWNLOADED_VIDEOS,
                        hasPermission = hasPermission
                )
    }

    fun sendDownloadStatusToServer(context: Context, status: String) {
        try {
            val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
            val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
            DownloadApi().sendDownloadVideoStatusToServer(tokenAu, status, deviceId)
                    .subscribe(object : BaseResponseObserver<Any>() {
                        override fun onExpired(error: String) {
                        }

                        override fun onExpiredUnauthenticated(error: String) {
                        }

                    })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("DOWNLOAD", "catched error uploading downloaded video status to server: ${e.message}")
        }
    }

    fun senStorageStatusToServer(context: Context, availableSpace: Long, totalSpace: Long, sdAvailableSpace: Long, sdTotalSpace: Long) {
        try {
            val tokenAu: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.TOKEN, "")
            val deviceId = PreferenceHelper.getInstance(context).getString(ConstantPreference.DEVICE_ID, "")
//            Log.d("LOG", this.javaClass.simpleName + " senStorageStatusToServer() | tokenAu: $tokenAu | deviceId: $deviceId")
            StorageApi().sendStorageStatusToServer(tokenAu, deviceId, availableSpace, totalSpace, sdAvailableSpace, sdTotalSpace)
                    .subscribe(object : BaseResponseObserver<Any>() {
                        override fun onExpired(error: String) {
                        }

                        override fun onExpiredUnauthenticated(error: String) {
                        }

                    })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("DOWNLOAD", "catched error uploading storage status to server: ${e.message}")
        }
    }

}