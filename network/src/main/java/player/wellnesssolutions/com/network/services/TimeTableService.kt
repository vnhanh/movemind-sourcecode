package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import player.wellnesssolutions.com.network.models.request.DeviceIDRequest
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.response.TimeTableResponse

interface TimeTableService {

    @POST("/api/v1/getTimeTable")
    fun getTimetable(@Header("Content-Type") contentType: String, @Header("Accept") acceptData: String,
                     @Header("Authorization") authTokenHeader: String, @Header("X-Device") deviceId: String,
                     @Body params: DeviceIDRequest): Observable<Response<ResponseValue<TimeTableResponse>>>
}