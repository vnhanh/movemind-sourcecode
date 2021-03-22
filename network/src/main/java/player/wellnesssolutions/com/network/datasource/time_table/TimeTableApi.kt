package player.wellnesssolutions.com.network.datasource.time_table

import io.reactivex.Observable
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.request.DeviceIDRequest
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.response.TimeTableResponse
import player.wellnesssolutions.com.network.services.TimeTableService
import retrofit2.Response
import java.util.*

class TimeTableApi() {
    private var mService: TimeTableService = ApiUtil.getTimeTableService()

    fun getTimeTable(token: String, deviceId: String): Observable<Response<ResponseValue<TimeTableResponse>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        //get timezone
        val tz = TimeZone.getDefault()
        val map = DeviceIDRequest(deviceId, tz.getOffset(System.currentTimeMillis()).toString())
        return mService.getTimetable(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId, map)
    }
}