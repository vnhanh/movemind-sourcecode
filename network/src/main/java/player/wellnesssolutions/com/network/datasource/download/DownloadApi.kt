package player.wellnesssolutions.com.network.datasource.download

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.download_status.DownLoadStatus
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.services.DownloadService
import retrofit2.Response

class DownloadApi {
    private var mService: DownloadService = ApiUtil.getDownloadService()
    fun getAllVideosFromServer(token: String, deviceId: String): Observable<Response<ResponseValue<ArrayList<MMVideo>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return mService.getVideosForDownload(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun sendDownloadVideoStatusToServer(token: String,statusDownload: String, deviceId: String): Observable<Response<ResponseValue<Any>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        val params = DownLoadStatus(statusDownload,deviceId)
        return  mService.sendDownloadVideoStatus(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, params)
                .subscribeOn(Schedulers.trampoline())
                .observeOn(AndroidSchedulers.mainThread())

    }
}