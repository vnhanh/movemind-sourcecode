package player.wellnesssolutions.com.base.common.download

import android.content.Context
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.download.DownloadApi
import player.wellnesssolutions.com.network.datasource.storage.StorageApi
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
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
                .addTask(
                        videoId = data.id!!,
                        url = data.downloadUrl,
                        name = data.videoName,
                        folder = Constant.FOLDER_DOWNLOADED_VIDEOS,
                        hasPermission = hasPermission
                )
    }

    fun sendDownloadStatusToServer(context: Context, status: String) {
        val tokenAu: String = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.TOKEN, "")
        val deviceId = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.DEVICE_ID, "")
        DownloadApi().sendDownloadVideoStatusToServer(tokenAu, status, deviceId)
                .subscribe(object : BaseResponseObserver<Any>() {
                    override fun onExpired(error: String) {
                    }

                    override fun onExpiredUnauthenticated(error: String) {
                    }

                    override fun onResponseSuccess(data: ResponseValue<Any>?) {
                        super.onResponseSuccess(data)
                    }

                })
    }

    fun senStorageStatusToServer(context: Context, availableSpace: Long, totalSpace: Long, sdAvailableSpace: Long, sdTotalSpace: Long) {
        val tokenAu: String = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.TOKEN, "")
        val deviceId = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.DEVICE_ID, "")
        StorageApi().sendStorageStatusToServer(tokenAu, deviceId, availableSpace, totalSpace, sdAvailableSpace, sdTotalSpace)
                .subscribe(object : BaseResponseObserver<Any>() {
                    override fun onExpired(error: String) {
                    }

                    override fun onExpiredUnauthenticated(error: String) {
                    }

                    override fun onResponseSuccess(data: ResponseValue<Any>?) {
                        super.onResponseSuccess(data)
                    }
                })
    }


}