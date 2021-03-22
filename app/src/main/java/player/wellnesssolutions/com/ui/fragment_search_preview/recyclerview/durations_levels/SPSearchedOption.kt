package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels

import android.os.Parcel
import android.os.Parcelable
import player.wellnesssolutions.com.network.models.screen_search.MMBrand

class SPSearchedOption() : Parcelable {
    var brand: MMBrand? = null
    var searchByData: SearchedOption? = null

    var collections: ArrayList<SearchedOption> = ArrayList()
    var instructors: ArrayList<SearchedOption> = ArrayList()
    var durations: ArrayList<SearchedOption> = ArrayList()
    var levels: ArrayList<SearchedOption> = ArrayList()

    constructor(parcel: Parcel) : this() {
        brand = parcel.readParcelable(MMBrand::class.java.classLoader) ?: MMBrand.getEmptyBrand()
        searchByData = parcel.readParcelable(SearchedOption::class.java.classLoader)
                ?: SearchedOption.getEmptyData()
        collections = arrayListOf<SearchedOption>().apply {
            parcel.readList(this as List<*>, SearchedOption::class.java.classLoader)
        }
        durations = arrayListOf<SearchedOption>().apply {
            parcel.readList(this as List<*>, SearchedOption::class.java.classLoader)
        }
        levels = arrayListOf<SearchedOption>().apply {
            parcel.readList(this as List<*>, SearchedOption::class.java.classLoader)
        }
        instructors = arrayListOf<SearchedOption>().apply {
            parcel.readList(this as List<*>, SearchedOption::class.java.classLoader)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(brand, flags)
        parcel.writeParcelable(searchByData, flags)
        parcel.writeList(collections as List<*>?)
        parcel.writeList(durations as List<*>?)
        parcel.writeList(levels as List<*>?)
        parcel.writeList(instructors as List<*>?)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun isEmptyOption(): Boolean = collections.size == 0 && instructors.size == 0 && durations.size == 0 && levels.size == 0

    companion object CREATOR : Parcelable.Creator<SPSearchedOption> {
        override fun createFromParcel(parcel: Parcel): SPSearchedOption {
            return SPSearchedOption(parcel)
        }

        override fun newArray(size: Int): Array<SPSearchedOption?> {
            return arrayOfNulls(size)
        }
    }

    fun clear() {
        collections.clear()
        durations.clear()
        levels.clear()
        instructors.clear()
    }
}