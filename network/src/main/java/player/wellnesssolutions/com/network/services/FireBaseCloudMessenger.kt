package player.wellnesssolutions.com.network.services

import io.reactivex.Single
import player.wellnesssolutions.com.network.models.fcm.FireBaseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface FireBaseCloudMessenger {
    @POST("/api/v1/saveDeviceToken")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun sendTokenFireBaseID(@Header("Authorization") authoTokenHeader: String,
                            @Header("X-Device") deviceId: String,
                            @Body params: FireBaseModel): Single<Response<Any>>
}