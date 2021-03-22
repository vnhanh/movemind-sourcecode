package player.wellnesssolutions.com.base.utils.check_header_api_util

import android.content.Context
import androidx.fragment.app.Fragment
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

object CheckHeaderApiUtil {
    fun checkData(sharedPref: SharedPreferencesCustomized?, fragment: Fragment?): HeaderData? {
        if (sharedPref == null) return null
        if (fragment !is BaseFragment) return null

        val context = fragment.context
        val token = sharedPref.getString(SPrefConstant.TOKEN, "")
        if ("" == token) {
            fragment.onExpired(context?.getString(R.string.error_no_token) ?: "")
            return null
        }

        val deviceId = sharedPref.getString(SPrefConstant.DEVICE_ID, "")
        if ("" == deviceId) {
            fragment.onExpired(context?.getString(R.string.no_device_id) ?: "")
            return null
        }

        return HeaderData(token, deviceId)
    }

    fun getExpiredData(context: Context): HeaderData? {
        val token = SharedPreferencesCustomized.getInstance(context = context).getString(SPrefConstant.TOKEN, "")

        val deviceId = SharedPreferencesCustomized.getInstance(context = context).getString(SPrefConstant.DEVICE_ID, "")

        return HeaderData(token, deviceId)
    }
}