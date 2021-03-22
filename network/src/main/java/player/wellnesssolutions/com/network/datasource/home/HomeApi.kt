package player.wellnesssolutions.com.network.datasource.home

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.response.ResponseValue

class HomeApi {
    private val homeService = ApiUtil.getHomeService()

    fun getConfigData(token:String, deviceId:String) : Observable<Response<ResponseValue<MMConfigData>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return homeService.getConfigData(tokenHeader, deviceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getUserSubscription(token:String, deviceId:String) : Observable<Response<ResponseValue<Int>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return homeService.getUserSubscription(tokenHeader, deviceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}