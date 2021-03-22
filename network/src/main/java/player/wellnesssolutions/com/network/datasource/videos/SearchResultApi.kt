package player.wellnesssolutions.com.network.datasource.videos

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.services.SearchResultService

class SearchResultApi {
    private var mService:SearchResultService = ApiUtil.getSearchResultService()

    fun getSearchResultOnSearchBy(token:String, deviceId: String, brandId:Int, searchBy:String, searchValue:Int, options:SearchVideosRequestOptions) :
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>> {

        val tokenHeader = RequestUtil.getTokenHeader(token)

        val requestData = SearchVideosOnSearchByRequestData(brandId = brandId, searchBy = searchBy, searchValue = searchValue, options = options)

        return mService.getVideosSearchResultOnSearchBy(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, requestData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSearchResultOnHelpMeChooseAnswers(token:String, deviceId: String, brandId:Int, answers: ArrayList<Int>) :
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>> {

        val tokenHeader = RequestUtil.getTokenHeader(token)
        val requestData = SearchVideosOnHelpMeChooseRequestData(brandId, answers)

        return mService.getVideosSearchResultOnHelpMeChooseAnswers(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, requestData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSearchResultOnInstructor(token:String, deviceId:String, instructorId:Int) : Observable<Response<ResponseValue<ArrayList<MMVideo>>>> {

        val tokenHeader = RequestUtil.getTokenHeader(token)

        return mService.getVideosSearchResultOnInstructor(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, instructorId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun updateViewNumber(token:String, deviceId:String, videoId:Int, type:String) : Observable<Response<ResponseValue<VideoViewResponse>>> {
        return  mService.updateViewNumber(RequestUtil.getTokenHeader(token), deviceId, videoId.toString(), UpdateViewVideoRequest(type))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}