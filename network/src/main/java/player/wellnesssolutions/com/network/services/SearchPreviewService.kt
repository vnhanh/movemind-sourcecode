package player.wellnesssolutions.com.network.services

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.search_preview.MMSearchPreviewResponse

interface SearchPreviewService {
    @GET("/api/v1/searchPreview/{brandId}/collection/{selectedId}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getSuggestSearchDataByCollection(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brandId") brandId:Int,
                                         @Path("selectedId") selectedId:Int):
            Observable<Response<ResponseValue<MMSearchPreviewResponse>>>


    @GET("/api/v1/searchPreview/{brandId}/duration/{selectedId}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getSuggestSearchDataByDuration(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brandId") brandId:Int,
                                       @Path("selectedId") selectedId:Int):
            Observable<Response<ResponseValue<MMSearchPreviewResponse>>>


    @GET("/api/v1/searchPreview/{brandId}/level/{selectedId}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getSuggestSearchDataByLevel(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brandId") brandId:Int,
                                    @Path("selectedId") selectedId:Int):
            Observable<Response<ResponseValue<MMSearchPreviewResponse>>>


    @GET("/api/v1/searchPreview/{brandId}/instructor/{selectedId}")
    @Headers("Content-Type: application/json", "Accept: application/json")
    fun getSuggestSearchDataByInstructor(@Header("Authorization")authoTokenHeader:String, @Header("X-Device") deviceId:String, @Path("brandId") brandId:Int,
                                         @Path("selectedId") selectedId:Int):
            Observable<Response<ResponseValue<MMSearchPreviewResponse>>>
}