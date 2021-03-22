package player.wellnesssolutions.com.network.models.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MMLoginResponseData(@SerializedName("token") @Expose val token: String? = null,
                          @SerializedName("branding") @Expose val branding: MMBranding? = null,
                          @SerializedName("cookies") @Expose val cookie: MMCookie? = null)


class MMBranding(@SerializedName("bottom_bar_color") val bottomBarColor: String? = null,
                 @SerializedName("primary_color") val primaryColor: String? = null,
                 @SerializedName("secondary_color") val textColor: String? = null,
                 @SerializedName("company_logo") val companyLogo: String? = null,
                 @SerializedName("background_pictures") val backgroundPictures: Array<String>? = null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MMBranding

        if (bottomBarColor != other.bottomBarColor) return false
        if (primaryColor != other.primaryColor) return false
        if (textColor != other.textColor) return false
        if (companyLogo != other.companyLogo) return false
        if (backgroundPictures != null) {
            if (other.backgroundPictures == null) return false
            if (!backgroundPictures.contentEquals(other.backgroundPictures)) return false
        } else if (other.backgroundPictures != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = bottomBarColor?.hashCode() ?: 0
        result = 31 * result + (primaryColor?.hashCode() ?: 0)
        result = 31 * result + (textColor?.hashCode() ?: 0)
        result = 31 * result + (companyLogo?.hashCode() ?: 0)
        result = 31 * result + (backgroundPictures?.contentHashCode() ?: 0)
        return result
    }
}