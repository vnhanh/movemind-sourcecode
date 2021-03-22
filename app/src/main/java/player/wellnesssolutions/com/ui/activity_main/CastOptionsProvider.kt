package player.wellnesssolutions.com.ui.activity_main

import android.content.Context
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider
import player.wellnesssolutions.com.R

class CastOptionsProvider : OptionsProvider {
    val CUSTOM_NAMESPACE = "urn:x-cast:custom_namespace"

    override fun getCastOptions(context: Context): CastOptions {
        val supportedNamespaces = ArrayList<String>()
        supportedNamespaces.add(CUSTOM_NAMESPACE)

        return CastOptions.Builder()
                .setReceiverApplicationId(context.getString(R.string.app_id))
                .setSupportedNamespaces(supportedNamespaces)
                .build()
    }

    override fun getAdditionalSessionProviders(context: Context): List<SessionProvider>? {
        return null
    }
}