package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface CollectionService {
    @GET("/api/v1/collections")
    fun getBrands(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                  @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String): Observable<Response<ResponseValue<ArrayList<MMCollection>>>>
}