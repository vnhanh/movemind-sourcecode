package player.wellnesssolutions.com.network.datasource.brand

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil.APP_JSON
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.services.BrandService

class BrandApi() {
    private val brandService : BrandService = ApiUtil.getBrandService()

    fun getAllBrands(token : String, deviceId : String) : Observable<Response<ResponseValue<ArrayList<MMBrand>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return brandService.getBrands(APP_JSON, APP_JSON, tokenHeader, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}