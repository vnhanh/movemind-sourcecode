package player.wellnesssolutions.com.network.models.screen_search

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MMBrand (
        @SerializedName("id") val id:Int?=null,
        @SerializedName("name") val name:String?=null,
        @SerializedName("description") val description:String?=null,
        @SerializedName("has_level") val hasLevel:Int?=null,
        @SerializedName("helper_text_player") val helperText:String?=null,
        @SerializedName("image") val image:String?=null,
        @SerializedName("logo") val logo:String?=null) : Serializable, Cloneable, Parcelable {
        constructor(parcel: Parcel) : this(
                id = parcel.readInt(),
                name = parcel.readString()?:"",
                description = parcel.readString()?:"",
                hasLevel = parcel.readInt(),
                helperText = parcel.readString()?:"",
                image = parcel.readString()?:"",
                logo = parcel.readString()?:"") {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(id?:-1)
                parcel.writeString(name)
                parcel.writeString(description)
                parcel.writeValue(hasLevel)
                parcel.writeString(helperText)
                parcel.writeString(image)
                parcel.writeString(logo)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<MMBrand> {
                override fun createFromParcel(parcel: Parcel): MMBrand {
                        return MMBrand(parcel)
                }

                override fun newArray(size: Int): Array<MMBrand?> {
                        return arrayOfNulls(size)
                }

            fun getEmptyBrand(): MMBrand = MMBrand(-1, "", "", 0, "", "", "")
        }

}