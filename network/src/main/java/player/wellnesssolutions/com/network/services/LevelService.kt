package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMLevel

interface LevelService {
    @GET("/api/v1/workouts/{brand_id}")
    fun getBrands(@Header("Content-Type") contentType: String,
                  @Header("Accept") acceptData: String,
                  @Header("Authorization") authoTokenHeader: String,
                  @Header("X-Device") deviceId: String,
                  @Path("brand_id") brandId: Int): Observable<Response<ResponseValue<ArrayList<MMLevel>>>>
}