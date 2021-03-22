package player.wellnesssolutions.com.network.datasource.storage

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.storage_status.StorageStatus
import retrofit2.Response

class StorageApi {
    private var mService = ApiUtil.getDownloadService()
    fun sendStorageStatusToServer(token: String, deviceId: String, availableSpace: Long, totalSpace: Long, sdAvailableSpace: Long, sdTotalSpace: Long): Observable<Response<ResponseValue<Any>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        val params = StorageStatus(deviceId, availableSpace, totalSpace, sdAvailableSpace, sdTotalSpace)
        return mService.sendStorageStatus(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}