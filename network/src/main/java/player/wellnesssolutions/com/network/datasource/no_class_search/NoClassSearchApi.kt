package player.wellnesssolutions.com.network.datasource.no_class_search

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.no_class_search.MMNoClass
import player.wellnesssolutions.com.network.models.response.ResponseValue

class NoClassSearchApi {
    private var noClassSearchService = ApiUtil.getNoClassSearchService()

    fun getData(token:String, deviceId:String) : Observable<Response<ResponseValue<MMNoClass>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return noClassSearchService.getData(tokenHeader, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}