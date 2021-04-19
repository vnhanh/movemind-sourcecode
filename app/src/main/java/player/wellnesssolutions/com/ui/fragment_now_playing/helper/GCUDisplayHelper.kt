package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.merge_now_playing_coming_up_next.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.convertToStrDateFormat12hrs
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMTextView
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextAdapter
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * GCU: Group Coming Up next
 */
object GCUDisplayHelper {
    fun showPlayingVideoInfo(rootView: ConstraintLayout?,
                             videoData: MMVideo,
                             extraCollectionView: ArrayList<TextView>?,
                             presenter: IComingUpNextClickListener? = null,
                             isPresentation: Boolean = false): ArrayList<TextView>? {
        if(rootView == null) return null
        if (isPresentation) {
            rootView.btnDownloadPlaying?.visibility = View.GONE
        }

        if (!videoData.playTime.isNullOrEmpty())
            displayTimeStart(videoData.getStartTime(), rootView.tvTimeStartVideoPlaying)
        else {
            rootView.tvTimeStartVideoPlaying?.visibility = View.GONE
        }
        NowPlayingVideoInfoDisplayHelper.displayTypeLogoBrand(videoData.brandTypeLogo, rootView.icTypeLogoNPGCU)

        return showPlayingVideoInfo(rootView, videoData.getVideoTitle(), videoData.thumbnailMediumUrl, videoData.getDurationValue(), videoData.collections, extraCollectionView, presenter)
    }

    private fun displayTimeStart(playTime: String, tv: MMTextView?) {
        if (tv == null) return
        if (playTime.isEmpty()) {
            tv.text = ""
            return
        }

//        tv.text = StringBuilder(convertDateStrToAMPMFormat(playTime).toUpperCase()).append(Constant.WHITE_SPACE).toString()
        tv.text = StringBuilder(playTime.convertToStrDateFormat12hrs().toUpperCase()).append(Constant.WHITE_SPACE).toString()

        if (tv.visibility != View.VISIBLE)
            tv.visibility = View.VISIBLE
    }

    private fun showPlayingVideoInfo(rootView: ConstraintLayout, videoName: String, thumbnalUrl: String?, duration: String, collections: ArrayList<MMTinyCategory>?,
                                     extraCollectionViews: ArrayList<TextView>?, presenter: IComingUpNextClickListener? = null): ArrayList<TextView>? {

        loadThumbnail(thumbnalUrl, rootView.thumbnailVideoPlaying)
        displayDuration(duration, rootView.tvDurationPlaying)
        displayVideoTitle(videoName, rootView.tvTitleVideoNPGCU)
        hideGCUAfterTapped(rootView, presenter)

        return SearchCollectionUtil.displayCollections(parentView = rootView.groupCollections, leftView = rootView.icTypeLogoNPGCU,
                collections = collections, collectionCountMax = 2, extraCollectionTextViews = extraCollectionViews)
    }

    private fun hideGCUAfterTapped(groupViewsComingUpNext: View, presenter: IComingUpNextClickListener? = null) {
        groupViewsComingUpNext.containerNowPlayingGCU.setOnClickListener {
//            groupViewsComingUpNext.visibility = View.GONE
            presenter?.onTapGroupComingUpNext()
        }

        groupViewsComingUpNext.setOnClickListener {
//            groupViewsComingUpNext.visibility = View.GONE
            presenter?.onTapGroupComingUpNext()
        }
    }

    private fun displayVideoTitle(videoName: String, tvTitleVideo: TextView?) {
        tvTitleVideo?.text = videoName
    }

    private fun displayDuration(duration: String, tvVideoDuration: TextView?) {
        if (tvVideoDuration == null) return
        tvVideoDuration.text = duration
    }

    private var mThumbnailCorner = 0
    private var mThumbnailWidth = 0
    private var mThumbnailHeight = 0

    private fun loadThumbnail(thunmailUrl: String?, thumbnailVideo: ImageView?) {
        if(thumbnailVideo == null) return
        initThumbnailValues(thumbnailVideo.resources)

        Glide.with(thumbnailVideo).load(thunmailUrl)
                .override(mThumbnailWidth, mThumbnailHeight).transform(RoundedCorners(mThumbnailCorner))
                .placeholder(R.drawable.bg_rectangle_ltgray_corner_4dp).error(R.drawable.bg_rectangle_ltgray_corner_4dp)
                .into(thumbnailVideo)
    }

    private fun initThumbnailValues(resources: Resources) {
        if (mThumbnailWidth == 0) mThumbnailWidth = resources.getDimensionPixelSize(R.dimen.width_thumbnail_now_playing_group_coming_up_next)
        if (mThumbnailHeight == 0) mThumbnailHeight = resources.getDimensionPixelSize(R.dimen.height_thumbnail_video_now_playing_group_coming_up_next)
        if (mThumbnailCorner == 0) mThumbnailCorner = resources.getDimensionPixelSize(R.dimen.corner_4dp)
    }

    fun showVideosComingUpNext(videos: MutableList<MMVideo>,
                               recyclerview: androidx.recyclerview.widget.RecyclerView?,
                               presenter: IComingUpNextClickListener?,
                               isPresentation: Boolean = false) {
        if (recyclerview == null) return

        releaseAdapters(recyclerview)

        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(recyclerview.context, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false)
        recyclerview.adapter = NowPlayingComingUpNextAdapter(videos, presenter, isPresentation)
    }

    private fun releaseAdapters(recyclerview: androidx.recyclerview.widget.RecyclerView?) {
        recyclerview?.adapter?.also {
            if (it is NowPlayingComingUpNextAdapter)
                it.release()
        }
    }

    fun convertDateStrToAMPMFormat(time: String): String {
        return try {
            var df: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
            val date = df.parse(time)
            df = SimpleDateFormat("h:mm a", Locale.getDefault())
            df.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}