package player.wellnesssolutions.com.network.models.screen_search

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MMDuration (
        @SerializedName("id") val id:Int?,
        @SerializedName("title") val title:String?,
        @SerializedName("min") val min:Int?,
        @SerializedName("max") val max:Int?) : Parcelable {
    constructor(parcel: Parcel) : this(
            id = parcel.readInt(),
            title = parcel.readString()?:"",
            min = parcel.readInt(),
            max = parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeValue(min)
        parcel.writeValue(max)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMDuration> {
        override fun createFromParcel(parcel: Parcel): MMDuration {
            return MMDuration(parcel)
        }

        override fun newArray(size: Int): Array<MMDuration?> {
            return arrayOfNulls(size)
        }
    }
}