package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface DurationService {
    @GET("/api/v1/durations")
    fun getDurations(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                     @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<ArrayList<MMDuration>>>>

    @GET("/api/v1/getDurationByBrandId/{brand_id}")
    fun getDurationsByBrandId(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                  @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brand_id") brandId:Int):
            Observable<Response<ResponseValue<ArrayList<MMDuration>>>>
}