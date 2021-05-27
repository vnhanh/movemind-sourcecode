package player.wellnesssolutions.com.network.datasource.instructor


import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor

class InstructorApi() {
    private var mService = ApiUtil.getInstructorService()

    fun getInstructors(token: String, deviceId:String, brandId:Int): Observable<Response<ResponseValue<ArrayList<MMInstructor>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return mService.getInstructors(tokenHeader, deviceId, brandId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}