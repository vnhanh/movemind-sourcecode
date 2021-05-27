package player.wellnesssolutions.com.network.datasource.level

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMLevel
import player.wellnesssolutions.com.network.services.LevelService

class LevelApi() {
    private val levelService: LevelService = ApiUtil.getLevelService()

    fun getLevels(token: String, deviceId: String, brandId: Int): Observable<Response<ResponseValue<ArrayList<MMLevel>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return levelService.getBrands(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, brandId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}