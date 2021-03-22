package player.wellnesssolutions.com.network.datasource.search_preview

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.search_preview.MMSearchPreviewResponse
import player.wellnesssolutions.com.network.services.SearchPreviewService

class SearchPreviewApi {
    private var searchPreviewService:SearchPreviewService = ApiUtil.getSearchPreviewService()

    fun getSearchPreviewDataByDuration(token:String, deviceId: String, brandId:Int, selectedId:Int): Observable<Response<ResponseValue<MMSearchPreviewResponse>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return searchPreviewService.getSuggestSearchDataByDuration(tokenHeader, deviceId, brandId, selectedId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSearchPreviewDataByLevel(token:String, deviceId: String, brandId:Int, selectedId:Int): Observable<Response<ResponseValue<MMSearchPreviewResponse>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return searchPreviewService.getSuggestSearchDataByLevel(tokenHeader, deviceId, brandId, selectedId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSearchPreviewDataByInstructor(token:String, deviceId: String, brandId:Int, selectedId:Int): Observable<Response<ResponseValue<MMSearchPreviewResponse>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return searchPreviewService.getSuggestSearchDataByInstructor(tokenHeader, deviceId, brandId, selectedId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSearchPreviewDataByCollection(token:String, deviceId:String, brandId:Int, selectedId:Int): Observable<Response<ResponseValue<MMSearchPreviewResponse>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        return searchPreviewService.getSuggestSearchDataByCollection(tokenHeader, deviceId, brandId, selectedId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}