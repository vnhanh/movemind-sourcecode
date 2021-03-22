package player.wellnesssolutions.com.network.models.config

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import player.wellnesssolutions.com.network.models.login.MMBranding

class MMConfigData(@SerializedName("help_me_choose") @Expose val hasHelpMeChoose:Int,
                   @SerializedName("help_me_choose_button_text") @Expose val helpmeChooseButtonText:String,
                   @SerializedName("help_me_choose__helper_text") @Expose val helpMeChooseHelperText:String,
                   @SerializedName("skip_n_search_button_text") @Expose val skipAndSearchButtonText:String,
                   @SerializedName("skip_n_search_helper_text") @Expose val skipAndSearchHelperText:String,
                   @SerializedName("get_started_button_text") @Expose val getStartedButtonText:String,
                   @SerializedName("get_started_helper_text")@Expose val getStartedHelperText:String,
                   @SerializedName("branding") @Expose val branding: MMBranding? = null,
                   @SerializedName("count_down") @Expose val countDown: Long? = 1000
)