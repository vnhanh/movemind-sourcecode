package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels

import android.os.Parcel
import android.os.Parcelable

data class SearchedOption(var id: Int? = null,
                          var name: String? = null,
                          var typeOptionId: Int? = null,
                          var imgCollection: String? = null,
                          var imgStrokeColor: String? = null) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString() ?: "",
            parcel.readInt(),
            parcel.readString() ?: "",
            parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id ?: -1)
        parcel.writeString(name ?: "")
        parcel.writeInt(typeOptionId ?: -1)
        parcel.writeString(imgCollection ?: "")
        parcel.writeString(imgStrokeColor ?: "")
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchedOption> {
        override fun createFromParcel(parcel: Parcel): SearchedOption {
            return SearchedOption(parcel)
        }

        override fun newArray(size: Int): Array<SearchedOption?> {
            return arrayOfNulls(size)
        }

        fun getEmptyData(): SearchedOption = SearchedOption(-1, "", -1, "", "")
    }
}