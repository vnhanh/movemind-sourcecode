package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMTextView

object NowPlayingVHDisplayHelper {
    private var mThumbnailCorner = 0
    private var mThumbnailWidth = 0
    private var mThumbnailHeight = 0

    fun displayTimeStart(tvTimeStart: MMTextView, playTime: String) {
        tvTimeStart.visibility = View.VISIBLE
        val timeStr = GCUDisplayHelper.convertDateStrToAMPMFormat(playTime).toUpperCase()
        tvTimeStart.text = StringBuilder(timeStr).append(Constant.WHITE_SPACE).toString()
    }

    fun displayThumbnail(thumbnailVideo: ImageView?, url: String?) {
        if (thumbnailVideo == null) return
        if (mThumbnailCorner == 0 || mThumbnailWidth == 0 || mThumbnailHeight == 0) initThumbnailDimens(thumbnailVideo.resources)

        Glide.with(thumbnailVideo).load(url)
                .override(mThumbnailWidth, mThumbnailHeight)
                .transform(CenterCrop(), RoundedCorners(mThumbnailCorner))
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.bg_rectangle_ltgray_corner_4dp).error(R.drawable.bg_rectangle_ltgray_corner_4dp)
                .into(thumbnailVideo)
    }

    private fun initThumbnailDimens(resources: Resources?) {
        if (resources == null) return
        mThumbnailCorner = resources.getDimensionPixelSize(R.dimen.corner_4dp)
        mThumbnailWidth = resources.getDimensionPixelSize(R.dimen.width_thumbnail_vh_now_playing_coming_up_next)
        mThumbnailHeight = resources.getDimensionPixelSize(R.dimen.height_thumbnail_vh_now_playing_coming_up_next)
    }
}