package player.wellnesssolutions.com.common.sharedpreferences

import player.wellnesssolutions.com.common.constant.Constant

object PreferenceManager {
    fun clearSchedulePref(){
        PreferenceHelper.getInstance()?.delete(Constant.SCHEDULE_CURRENT_ID)
        PreferenceHelper.getInstance()?.delete(Constant.SCHEDULE_CURRENT_TIME_START)
    }
}