package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import player.wellnesssolutions.com.network.models.login.MMLoginResponseData
import player.wellnesssolutions.com.network.models.request.ActiveRequest
import player.wellnesssolutions.com.network.models.response.ResponseValue

/**
 * An example for the service
 *
 */
interface LoginService {

    @POST("/api/v1/activateDevice")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun active(@Body params : ActiveRequest) : Observable<Response<ResponseValue<Any>>>

    @POST("/api/v1/login")
    @FormUrlEncoded
    fun login(@Header("X-Device") deviceId : String, @FieldMap params : Map<String, String>) : Observable<Response<ResponseValue<MMLoginResponseData>>>
}