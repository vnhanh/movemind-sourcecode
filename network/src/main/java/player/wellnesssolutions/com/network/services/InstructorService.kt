package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface InstructorService {
    @GET("/api/v1/instructorsByBrand/{brand_id}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getInstructors(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brand_id") brandId:Int): Observable<Response<ResponseValue<ArrayList<MMInstructor>>>>
}