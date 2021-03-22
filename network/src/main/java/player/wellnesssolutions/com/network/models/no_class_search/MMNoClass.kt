package player.wellnesssolutions.com.network.models.no_class_search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MMNoClass(
        @SerializedName("help_me_choose") @Expose val hasHelpMeChoose:Int,
        @SerializedName("help_me_choose_helptext") @Expose val helpMeChooseHelperText:String,
        @SerializedName("skip_and_search_helptext") @Expose val skipAndSearchHelperText:String)