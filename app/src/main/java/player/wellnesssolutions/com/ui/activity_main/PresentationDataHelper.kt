package player.wellnesssolutions.com.ui.activity_main

import android.content.Context
import android.util.Log
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo

object PresentationDataHelper {
    const val VIDEO_TAG = "TV Presentation"

    fun save(context: Context?, mode: PlayMode?, videos: ArrayList<MMVideo>?) {
        Log.d("LOG", this.javaClass.simpleName + " save() | mode: $mode | videos number: ${videos?.size ?: 0}")
        if (context != null) {
            PreferenceHelper.getInstance(context).putInt(ConstantPreference.MODE_PLAY_VIDEO, mode?.value?: PlayMode.UNKNOWN.value)
        }

        // save videos to database
        videos?.also {
            VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
            VideoDBUtil.saveVideosToDB(it, VIDEO_TAG)
        }
    }

    fun clearCacheLastVideos() {
        VideoDBUtil.deleteVideosFromDB(VIDEO_TAG)
    }
}