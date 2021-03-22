package player.wellnesssolutions.com.ui.activity_main

import android.content.Context
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

object PresentationDataHelper {
    const val VIDEO_TAG = "TV Presentation"

    fun save(context: Context?, mode: PlayMode?, videos: ArrayList<MMVideo>?, currentPosition: Long?, timeCountDown: Long?) {
        if (context != null) {
            SharedPreferencesCustomized.getInstance(context).putLong(SPrefConstant.LAST_PLAYED_VIDEO_POSITION, currentPosition
                    ?: 0L)
            SharedPreferencesCustomized.getInstance(context).putLong(SPrefConstant.LAST_TIME_COUNT_DOWN, timeCountDown
                    ?: 0L)
            SharedPreferencesCustomized.getInstance(context).putInt(SPrefConstant.PRESENTATION_PLAYED_MODE, mode?.value
                    ?: PlayMode.ON_DEMAND.value)
        }

        // save videos to database
        videos?.also {
            VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
            VideoDBUtil.saveVideosToDB(it, VIDEO_TAG)
        }
    }

    fun readVideos(): ArrayList<MMVideo> = VideoDBUtil.readVideosFromDB(VIDEO_TAG)

    fun clearCacheLastVideos(context: Context) {
        SharedPreferencesCustomized.getInstance(context).delete(SPrefConstant.LAST_PLAYED_VIDEO_POSITION)
        SharedPreferencesCustomized.getInstance(context).delete(SPrefConstant.PRESENTATION_PLAYED_MODE)
        SharedPreferencesCustomized.getInstance(context).delete(SPrefConstant.LAST_TIME_COUNT_DOWN)
        VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
    }
}