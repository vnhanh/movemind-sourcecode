package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import player.wellnesssolutions.com.network.datasource.videos.SearchVideosOnHelpMeChooseRequestData
import player.wellnesssolutions.com.network.datasource.videos.SearchVideosOnSearchByRequestData
import player.wellnesssolutions.com.network.datasource.videos.UpdateViewVideoRequest
import player.wellnesssolutions.com.network.datasource.videos.VideoViewResponse
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue

interface SearchResultService {
    @POST("/api/v1/search")
    fun getVideosSearchResultOnSearchBy(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                                        @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String,
                                        @Body params:SearchVideosOnSearchByRequestData):
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>>

    @POST("/api/v1/helpMeChoose")
    fun getVideosSearchResultOnHelpMeChooseAnswers(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                                         @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String,
                                                   @Body params: SearchVideosOnHelpMeChooseRequestData):
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>>

    @GET("/api/v1/getVideosByInstructor/{instructor_id}")
    fun getVideosSearchResultOnInstructor(@Header("Content-Type") contentType:String, @Header("Accept") acceptData:String,
                                         @Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String,
                                          @Path("instructor_id") instructorId:Int):
            Observable<Response<ResponseValue<ArrayList<MMVideo>>>>

    @POST("/api/v1/videos/views/{video_id}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun updateViewNumber(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String,
               @Path("video_id") videoId:String, @Body input: UpdateViewVideoRequest) : Observable<Response<ResponseValue<VideoViewResponse>>>
}