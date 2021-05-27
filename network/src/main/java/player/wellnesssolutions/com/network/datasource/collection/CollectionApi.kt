package player.wellnesssolutions.com.network.datasource.collection

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMCollection

class CollectionApi {
    private val collectionService = ApiUtil.getGymCollectionService()

    fun getCollections(token : String, deviceId : String) : Observable<Response<ResponseValue<ArrayList<MMCollection>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return collectionService.getBrands(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}