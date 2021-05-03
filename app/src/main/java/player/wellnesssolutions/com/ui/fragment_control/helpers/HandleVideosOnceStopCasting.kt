package player.wellnesssolutions.com.ui.fragment_control.helpers

import android.app.Activity
import android.os.Handler
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper.openNowPlayingPlayVideoSearched

object HandleVideosOnceStopCasting {

    fun handlePlayingVideos(activity: Activity?, handler: Handler) {
        handler.post(object: Runnable{
            override fun run() {
                activity?.also { activity ->
                    PreferenceHelper.getInstance(activity).getInt(ConstantPreference.MODE_PLAY_VIDEO, PlayMode.UNKNOWN.value).also { modeCasting ->
                        if(modeCasting == PlayMode.ON_DEMAND.value){
                            VideoDBUtil.getVideosFromDB(Constant.MM_VIDEO_SEARCHED).also { videos ->
                                if (videos.size > 1 && activity is MainActivity){
                                    val videosNext = ArrayList<MMVideo>()
                                    for (i in 1 until videos.size){
                                        videosNext.add(videos[i])
                                    }
                                    videos.clear()
                                    openNowPlayingPlayVideoSearched(activity.supportFragmentManager, videosNext)
                                }
                            }
                        }
                    }
                }// end activity block

            }// end run()

        })
    }
}