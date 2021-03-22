package player.wellnesssolutions.com.ui.fragment_control.helpers

import androidx.fragment.app.FragmentActivity
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment

object ControlFragmentSetupUIHelper {

    fun passScheduleAndOpenScreenPlay(activity: FragmentActivity, scheduleVideos: ArrayList<MMVideo>) {
        val fm = activity.supportFragmentManager
        val newFragment = NowPlayingFragment.getInstancePlaySchedule(scheduleVideos)
        val newTag = NowPlayingFragment.TAG
        FragmentUtil.replaceFragment(fm, newFragment, newTag, R.id.frameLayoutHome, isAddToBackStack = true, isRemoveOlds = false)
        //FragmentUtil.printActivityFragmentList(fm)
    }
}