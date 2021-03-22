package player.wellnesssolutions.com.network.datasource.fcm

import io.reactivex.Single
import player.wellnesssolutions.com.network.ApiUtil
import player.wellnesssolutions.com.network.datasource.RequestUtil
import player.wellnesssolutions.com.network.models.fcm.FireBaseModel
import player.wellnesssolutions.com.network.services.FireBaseCloudMessenger
import retrofit2.Response


class FirebaseApi {
    private var fireBaseService: FireBaseCloudMessenger = ApiUtil.getFCMService()

    fun sendTokenFCMToServer(author: String, deviceId: String, deviceToken: String): Single<Response<Any>> {
        val tokenHeader = RequestUtil.getTokenHeader(author)
        val map = FireBaseModel(deviceId, deviceToken)
        return fireBaseService.sendTokenFireBaseID(tokenHeader, deviceId, map)
    }
}