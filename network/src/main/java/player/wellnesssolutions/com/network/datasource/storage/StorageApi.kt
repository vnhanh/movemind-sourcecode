package player.wellnesssolutions.com.network.datasource.storage

import android.util.Log
import com.google.gson.Gson
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
        val tokenHeader: String = RequestUtil.getTokenHeader(token)
        val params: StorageStatus = StorageStatus(deviceId, availableSpace, totalSpace, sdAvailableSpace, sdTotalSpace)
        val gson = Gson()

        Log.d("LOG", this.javaClass.simpleName + " sendStorageStatusToServer() | tokenHeader: $tokenHeader | params: ${gson.toJson(params)}")
        return mService.sendStorageStatus(contentType = RequestUtil.APP_JSON, acceptData = RequestUtil.APP_JSON, authoTokenHeader = tokenHeader, deviceId = deviceId, params = params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}