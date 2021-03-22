package player.wellnesssolutions.com.network.models.now_playing

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import player.wellnesssolutions.com.common.utils.StrUtil
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.com.network.models.search_result.MMSimpleOption

data class MMVideo(
        @SerializedName("id") var id : Int? = null,
        @SerializedName("brand_id") var brandId : Int? = null,
        @SerializedName("logo") var brandTypeLogo : String? = null,
        @SerializedName("duration_id") var durationId : Int? = null,
        @SerializedName("duration_name") var durationName : String? = null,
        @SerializedName("language_id") var languageId : Int? = null,
        @SerializedName("name") var videoName : String? = null,
        @SerializedName("instructor") var instructorId : Int? = null,
        @SerializedName("instructor_name") var instructorName : String? = null,
        @SerializedName("video") var videoUrl : String? = null,
        @SerializedName("trailer") var trailerUrl : String? = null,
        @SerializedName("thumbnail657x369") var thumbnailLargeUrl : String? = null,
        @SerializedName("thumbnail575x235") var thumbnailMediumUrl : String? = null,
        @SerializedName("thumbnail342x205") var thumbnailSmallUrl : String? = null,
        @SerializedName("length") var videoLength : Float? = null,
        @SerializedName("size") var videoSize : Long? = null,
        @SerializedName("play_time") var playTime : String? = null,
        @SerializedName("orignal_video") var downloadUrl : String? = null,
        @SerializedName("languages") var languages : ArrayList<MMVideoLanguage>? = null,
        @SerializedName("subtitles") var subtitles : java.util.HashMap<String,String>? = null,
        var collections : ArrayList<MMTinyCategory>? = null,
        var levels : ArrayList<MMSimpleOption>? = null

) : Cloneable, Parcelable {
    constructor(parcel : Parcel) : this(
            id = parcel.readValue(Int::class.java.classLoader) as? Int,
            brandId = parcel.readValue(Int::class.java.classLoader) as? Int,
            brandTypeLogo = parcel.readString(),
            durationId = parcel.readValue(Int::class.java.classLoader) as? Int,
            durationName = parcel.readString(),
            languageId = parcel.readValue(Int::class.java.classLoader) as? Int,
            videoName = parcel.readString(),
            instructorId = parcel.readValue(Int::class.java.classLoader) as? Int,
            instructorName = parcel.readString(),
            videoUrl = parcel.readString(),
            trailerUrl = parcel.readString(),
            thumbnailLargeUrl = parcel.readString(),
            thumbnailMediumUrl = parcel.readString(),
            thumbnailSmallUrl = parcel.readString(),
            videoLength = parcel.readValue(Float::class.java.classLoader) as? Float,
            videoSize = parcel.readValue(Long::class.java.classLoader) as? Long,
            playTime = parcel.readString(),
            downloadUrl = parcel.readString(),
            languages = readLanguage(parcel),
            subtitles = readSubtitles(parcel),
            collections = arrayListOf<MMTinyCategory>().apply {
                parcel.readArrayList(MMTinyCategory::class.java.classLoader)
            },
            levels = arrayListOf<MMSimpleOption>().apply {
                parcel.readArrayList(MMSimpleOption::class.java.classLoader)
            }) {
    }

    fun getStartTime() : String = playTime ?: ""
    fun getVideoTitle() : String = videoName ?: ""
    fun getDurationValue() : String = if (durationName.isNullOrEmpty()) StrUtil.getDurationFromSecond(videoLength?.toDouble()
            ?: 0.0) else durationName!!

    override fun writeToParcel(parcel : Parcel, flags : Int) {
        parcel.writeValue(id)
        parcel.writeValue(brandId)
        parcel.writeString(brandTypeLogo)
        parcel.writeValue(durationId)
        parcel.writeString(durationName)
        parcel.writeValue(languageId)
        parcel.writeString(videoName)
        parcel.writeValue(instructorId)
        parcel.writeString(instructorName)
        parcel.writeString(videoUrl)
        parcel.writeString(trailerUrl)
        parcel.writeString(thumbnailLargeUrl)
        parcel.writeString(thumbnailMediumUrl)
        parcel.writeString(thumbnailSmallUrl)
        parcel.writeValue(videoLength)
        parcel.writeValue(videoSize)
        parcel.writeString(playTime)
        parcel.writeString(downloadUrl)
        parcel.writeList(collections as List<*>?)
        parcel.writeList(levels as List<*>?)
        parcel.writeTypedList(languages)
        parcel.writeMap(subtitles as Map<*, *>?)
    }

    override fun describeContents() : Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMVideo> {
        override fun createFromParcel(parcel : Parcel) : MMVideo {
            return MMVideo(parcel)
        }

        override fun newArray(size : Int) : Array<MMVideo?> {
            return arrayOfNulls(size)
        }

        fun readLanguage(parcel : Parcel) : ArrayList<MMVideoLanguage>{
            val list = parcel.readArrayList(ArrayList::class.java.classLoader)

            if(list!=null && list.size > 0){
                val result = ArrayList<MMVideoLanguage>()
                for (ele in list){
                    if(ele is MMVideoLanguage){
                        result.add(ele)
                    }
                }
                return result
            }
            return ArrayList()
        }

        fun readSubtitles(parcel : Parcel) : HashMap<String,String>{
            val map = parcel.readHashMap(HashMap::class.java.classLoader)
            if(map == null || map.size == 0) return HashMap()
            val result = HashMap<String,String>()
            for(ele : MutableMap.MutableEntry<Any, Any> in map){
                val key = ele.key
                val value = ele.value
                if(key is String && value is String){
                    result.put(key, value)
                }
            }

            return result
        }
    }
}