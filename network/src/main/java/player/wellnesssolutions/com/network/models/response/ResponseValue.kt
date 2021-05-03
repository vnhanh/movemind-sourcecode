package player.wellnesssolutions.com.network.models.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * A base class. All Response objects will inheritance it.
 */
class ResponseValue<T>(
        @SerializedName("success") @Expose var success : Boolean = false,
        @SerializedName("message") @Expose var message : String = "",
        @SerializedName("data") @Expose var data : T
)