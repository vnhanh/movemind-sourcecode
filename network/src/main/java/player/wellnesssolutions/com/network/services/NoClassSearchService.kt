package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import player.wellnesssolutions.com.network.models.no_class_search.MMNoClass
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface NoClassSearchService {
    @GET("/api/v1/checkHelpMeChoose")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getData(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<MMNoClass>>>
}