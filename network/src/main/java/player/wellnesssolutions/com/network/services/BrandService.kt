package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.response.ResponseValue


interface BrandService {
    @GET("/api/v1/brands")
    fun getBrands(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                  @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<ArrayList<MMBrand>>>>

    @GET
    fun getBrand() : Observable<ResponseValue<MMBrand>>
}