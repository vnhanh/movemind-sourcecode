package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import player.wellnesssolutions.com.network.datasource.now_playing.NowPlayingRequest
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface NowPlayingService {
    @POST("/api/v1/nowPlaying")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getScheduler(@Header("Authorization") authoTokenHeader: String,
                     @Header("X-Device") deviceId: String,
                     @Body input: NowPlayingRequest): Observable<Response<ResponseValue<ArrayList<MMVideo>>>>
}