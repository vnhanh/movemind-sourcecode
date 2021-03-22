package player.wellnesssolutions.com.network.models.screen_search

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MMCollection (@SerializedName("id") val id:Int?,
                         @SerializedName("brand_id") val brandId:Int?,
                         @SerializedName("parent_id") val parentId:Int?,
                         @SerializedName("name") val name:String?,
                         @SerializedName("description") val description:String?,
                         @SerializedName("image") val image:String?,
                         @SerializedName("color") val color:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            id = parcel.readInt(),
            brandId = parcel.readInt(),
            parentId = parcel.readValue(Int::class.java.classLoader) as? Int,
            name = parcel.readString()?:"",
            description = parcel.readString()?:"",
            image = parcel.readString()?:"",
            color = parcel.readString()?:"#000000") {
    }

    fun getColorStr():String = if(color.isNullOrEmpty()) "#000000" else color

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(brandId)
        parcel.writeValue(parentId)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeString(color)
    }


    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMCollection> {
        override fun createFromParcel(parcel: Parcel): MMCollection {
            return MMCollection(parcel)
        }

        override fun newArray(size: Int): Array<MMCollection?> {
            return arrayOfNulls(size)
        }
    }
}