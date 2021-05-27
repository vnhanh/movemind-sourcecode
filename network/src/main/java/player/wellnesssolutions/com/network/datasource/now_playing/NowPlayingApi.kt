package player.wellnesssolutions.com.network.datasource.now_playing

import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import retrofit2.Response
import java.util.*

class NowPlayingApi {
    fun getSchedule(token: String, deviceId: String): Observable<Response<ResponseValue<ArrayList<MMVideo>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)

        //get timezone
        val tz = TimeZone.getDefault()
        val input = NowPlayingRequest(deviceId, tz.getOffset(System.currentTimeMillis()).toString())
//        val gson = Gson()
//        Log.d("LOG", this.javaClass.simpleName + " getSchedule() | tz: ${tz} | input: ${gson.toJson(input)}")
        return ApiUtil.getNowPlayingService().getScheduler(tokenHeader, deviceId, input)
                .observeOn(AndroidSchedulers.mainThread())
    }
}