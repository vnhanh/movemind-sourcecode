package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface HomeService {
    @GET("/api/v1/checkConfig")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getConfigData(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<MMConfigData>>>

    @GET("api/v1/getUserSubscription")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getUserSubscription(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<Int>>>
}