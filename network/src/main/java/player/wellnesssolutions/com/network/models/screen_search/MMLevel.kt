package player.wellnesssolutions.com.network.models.screen_search

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MMLevel (
        @SerializedName("id") val id:Int?,
        @SerializedName("name") val name:String?,
        @SerializedName("level") val level:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            id = parcel.readInt(),
            name = parcel.readString()?:"",
            level = parcel.readString()?:"") {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(level)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMLevel> {
        override fun createFromParcel(parcel: Parcel): MMLevel {
            return MMLevel(parcel)
        }

        override fun newArray(size: Int): Array<MMLevel?> {
            return arrayOfNulls(size)
        }
    }

}