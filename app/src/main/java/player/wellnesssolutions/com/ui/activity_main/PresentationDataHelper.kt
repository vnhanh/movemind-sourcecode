package player.wellnesssolutions.com.ui.activity_main

import android.content.Context
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

object PresentationDataHelper {
    const val VIDEO_TAG = "TV Presentation"

    fun save(context: Context?, mode: PlayMode?, videos: ArrayList<MMVideo>?, currentPosition: Long?, timeCountDown: Long?) {
        if (context != null) {
            PreferenceHelper.getInstance(context).putLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION, currentPosition
                    ?: 0L)
            PreferenceHelper.getInstance(context).putLong(ConstantPreference.LAST_TIME_COUNT_DOWN, timeCountDown
                    ?: 0L)
            PreferenceHelper.getInstance(context).putInt(ConstantPreference.PRESENTATION_PLAYED_MODE, mode?.value
                    ?: PlayMode.ON_DEMAND.value)
        }

        // save videos to database
        videos?.also {
            VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
            VideoDBUtil.saveVideosToDB(it, VIDEO_TAG)
        }
    }

    fun readVideos(): ArrayList<MMVideo> = VideoDBUtil.getVideosFromDB(VIDEO_TAG)

    fun clearCacheLastVideos(context: Context) {
        PreferenceHelper.getInstance(context).delete(ConstantPreference.LAST_PLAYED_VIDEO_POSITION)
        PreferenceHelper.getInstance(context).delete(ConstantPreference.PRESENTATION_PLAYED_MODE)
        PreferenceHelper.getInstance(context).delete(ConstantPreference.LAST_TIME_COUNT_DOWN)
        VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
    }
}