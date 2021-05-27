package player.wellnesssolutions.com.network.datasource.duration

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil.APP_JSON
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.services.DurationService

class DurationApi {
    private var durationService: DurationService = ApiUtil.getDurationService()

    fun getDurations(token: String, deviceId:String): Observable<Response<ResponseValue<ArrayList<MMDuration>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return durationService.getDurations(APP_JSON, APP_JSON, tokenHeader, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getDurationsByBrandId(token: String, deviceId:String, brandId:Int): Observable<Response<ResponseValue<ArrayList<MMDuration>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return durationService.getDurationsByBrandId(APP_JSON, APP_JSON, tokenHeader, deviceId, brandId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}