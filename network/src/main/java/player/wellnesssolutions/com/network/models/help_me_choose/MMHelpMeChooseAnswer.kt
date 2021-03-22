package player.wellnesssolutions.com.network.models.help_me_choose

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class MMHelpMeChooseAnswer(var id:Int?=null,
                           @SerializedName("question_id") var questionId:Int?,
                           var answer:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()?:"") {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(questionId)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MMHelpMeChooseAnswer> {
        override fun createFromParcel(parcel: Parcel): MMHelpMeChooseAnswer {
            return MMHelpMeChooseAnswer(parcel)
        }

        override fun newArray(size: Int): Array<MMHelpMeChooseAnswer?> {
            return arrayOfNulls(size)
        }
    }
}