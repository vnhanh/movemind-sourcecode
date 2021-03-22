package player.wellnesssolutions.com.network.datasource.login

import io.reactivex.Observable
import retrofit2.Response
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.models.login.MMLoginResponseData
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.request.ActiveRequest
import player.wellnesssolutions.com.network.services.LoginService

class LoginApi {

    private var loginService: LoginService = ApiUtil.getLoginService()

    fun activeDevice(email: String, model: String, deviceId: String, availableSpace: Long,
                              totalSpace: Long): Observable<Response<ResponseValue<Any>>> {
        val map = ActiveRequest(email, model, deviceId, availableSpace, totalSpace)
        return loginService.active(map)
    }

    fun login(email: String, password: String, deviceId: String): Observable<Response<ResponseValue<MMLoginResponseData>>> {
        val map = HashMap<String, String>().apply {
            put("email", email)
            put("password", password)
        }

        return loginService.login(deviceId, map)
    }
}