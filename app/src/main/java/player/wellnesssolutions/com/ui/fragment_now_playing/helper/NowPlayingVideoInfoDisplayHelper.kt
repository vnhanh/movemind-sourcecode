package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.android.synthetic.main.fragment_now_playing.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory

object NowPlayingVideoInfoDisplayHelper {
    private var mTypeLogoWidth = 0
    private var mTypeLogoHeight = 0

    fun displayPlayingVideo(parentView: ConstraintLayout, groupMainControllers: LinearLayout, videoData: MMVideo, extraCollectionViews: ArrayList<TextView>?): ArrayList<TextView>? {
        /* parentView.btnDownload?.let {
             if (it.visibility != View.VISIBLE)
                 it.visibility = View.VISIBLE
         }*/

        return displayVideoInfo(parentView, groupMainControllers, videoData.getVideoTitle(), videoData.brandTypeLogo, videoData.collections, extraCollectionViews)
    }

    fun setupVideo(parentView: View, player: SimpleExoPlayer) {
        parentView.videoPlayer?.player = player
        parentView.seekbarVolume?.progress = (player.volume * 100).toInt()
    }

    fun displayVideoInfo(parentView: ConstraintLayout, groupMainControllers: LinearLayout, videoName: String, brandTypeLogo: String?, collections: ArrayList<MMTinyCategory>?, collectionViews: ArrayList<TextView>?): ArrayList<TextView>? {
        parentView.tvTitleVideo?.text = StringBuilder(videoName).append(Constant.WHITE_SPACE).toString()
        displayTypeLogoBrand(brandTypeLogo, parentView.icTypeLogoVideoPlaying)

        return SearchCollectionUtil.displayCollections(parentView = parentView.groupMainCollections, leftView = parentView.icTypeLogoVideoPlaying,
                collections = collections, collectionCountMax = 2, extraCollectionTextViews = collectionViews)
    }

    fun displayTypeLogoBrand(typeLogo: String?, iconView: ImageView?) {
        if (iconView == null) return
        if (mTypeLogoWidth == 0 || mTypeLogoHeight == 0) initTypeLogoDimens(iconView)

        Glide.with(iconView).load(typeLogo).override(mTypeLogoWidth, mTypeLogoHeight).into(iconView)
    }

    private fun initTypeLogoDimens(iconView: ImageView) {
        mTypeLogoWidth = iconView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_width)
                ?: 50
        mTypeLogoHeight = iconView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_height)
                ?: 16
    }
}