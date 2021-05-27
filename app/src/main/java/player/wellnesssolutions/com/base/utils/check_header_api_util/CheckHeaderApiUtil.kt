package player.wellnesssolutions.com.base.utils.check_header_api_util

import android.content.Context
import androidx.fragment.app.Fragment
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

object CheckHeaderApiUtil {
    fun checkData(sharedPref: PreferenceHelper?, fragment: Fragment?): HeaderData? {
        if (sharedPref == null || fragment !is BaseFragment) return null

        val context = fragment.context
        val token = sharedPref.getString(ConstantPreference.TOKEN, "")
        if ("" == token) {
            fragment.onExpired(context?.getString(R.string.error_no_token) ?: "")
            return null
        }

        val deviceId = sharedPref.getString(ConstantPreference.DEVICE_ID, "")
        if ("" == deviceId) {
            fragment.onExpired(context?.getString(R.string.no_device_id) ?: "")
            return null
        }

        return HeaderData(token, deviceId)
    }

    fun getExpiredData(context: Context): HeaderData {
        val token = PreferenceHelper.getInstance(context = context).getString(ConstantPreference.TOKEN, "")

        val deviceId = PreferenceHelper.getInstance(context = context).getString(ConstantPreference.DEVICE_ID, "")

        return HeaderData(token, deviceId)
    }
}