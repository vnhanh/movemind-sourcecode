package player.wellnesssolutions.com.network.datasource.help_me_choose

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion
import player.wellnesssolutions.com.network.models.response.ResponseValue

class HelpMeChooseApi {
    private val service = ApiUtil.getHelpMeChooseService()

    fun loadQuestions(token:String, deviceId:String) : Observable<Response<ResponseValue<ArrayList<MMHelpMeChooseQuestion>>>> {
        val tokenHeader = RequestUtil.getTokenHeader(token)
        return service.getQuestions(RequestUtil.APP_JSON, RequestUtil.APP_JSON, tokenHeader, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
    }
}