package player.wellnesssolutions.com.network.services

import android.app.usage.StorageStats
import io.reactivex.Observable
import player.wellnesssolutions.com.network.models.download_status.DownLoadStatus
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.storage_status.StorageStatus
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DownloadService {
    @GET("/api/v1/getAllVideos")
    fun getVideosForDownload(@Header("Content-Type") contentType: String,
                             @Header("Accept") acceptData: String,
                             @Header("Authorization") authoTokenHeader: String,
                             @Header("X-Device") deviceId: String):
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>>

    @POST("/api/v1/download-status")
    fun sendDownloadVideoStatus(@Header("Content-Type") contentType: String,
                                @Header("Accept") acceptData: String,
                                @Header("Authorization") authoTokenHeader: String,
                                @Header("X-Device") deviceId: String,
                                @Body params: DownLoadStatus):
            Observable<Response<ResponseValue<Any>>>


    @POST("/api/v1/storage-status")
    fun sendStorageStatus(@Header("Content-Type") contentType: String,
                                @Header("Accept") acceptData: String,
                                @Header("Authorization") authoTokenHeader: String,
                                @Header("X-Device") deviceId: String,
                                @Body params: StorageStatus):
            Observable<Response<ResponseValue<Any>>>
}
