package player.wellnesssolutions.com.network.models.screen_search

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class MMInstructor (
        @SerializedName("id") val id:Int?,
        @SerializedName("name") var name:String?,
        @SerializedName("profile_information") val profileInformation:String?,
        @SerializedName("image") var image:String?=null) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(name)
        parcel.writeString(profileInformation)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMInstructor> {
        override fun createFromParcel(parcel: Parcel): MMInstructor {
            return MMInstructor(parcel)
        }

        override fun newArray(size: Int): Array<MMInstructor?> {
            return arrayOfNulls(size)
        }
    }
}