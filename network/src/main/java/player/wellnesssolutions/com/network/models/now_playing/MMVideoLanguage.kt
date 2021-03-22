package player.wellnesssolutions.com.network.models.now_playing

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MMVideoLanguage(@SerializedName("id") var id:Int?=null,
                      @SerializedName("name") var name:String?=null,
                      @SerializedName("code") var code:String?=null) : Parcelable {
    constructor(parcel : Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel : Parcel, flags : Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(code)
    }

    override fun describeContents() : Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMVideoLanguage> {
        override fun createFromParcel(parcel : Parcel) : MMVideoLanguage {
            return MMVideoLanguage(parcel)
        }

        override fun newArray(size : Int) : Array<MMVideoLanguage?> {
            return arrayOfNulls(size)
        }
    }
}