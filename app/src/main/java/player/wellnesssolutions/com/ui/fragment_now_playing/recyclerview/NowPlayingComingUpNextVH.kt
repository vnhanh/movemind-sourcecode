package player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.vh_now_playing.view.*
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVHDisplayHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoInfoDisplayHelper

class NowPlayingComingUpNextVH(view: View, private var presenter: IComingUpNextClickListener?, isPresentation: Boolean = false) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    //private var mDownloadButtonManager = DownloadButtonManager(itemView.btnDownload)
    private var mExtraCollectionViews: ArrayList<TextView>? = null

    private var mPosition = 0
    private var mVideo: MMVideo? = null

    init {
        ViewUtil.setupButton(view, this::onClickedItemView)
        if (isPresentation) itemView.btnDownload.visibility = View.GONE
    }

    private fun onClickedItemView() {
        presenter?.also { presenter ->
            presenter.onClickedComingUpNextVideo(mPosition)
        }
    }

    fun bind(video: MMVideo, position: Int) {
        this.mVideo = video
        this.mPosition = position

        loadThumbnail(video)
        displayTypeLogo(video.brandTypeLogo, itemView.icTypeLogoGCU)
        //bindDownloadData(video)
        displayTimeStart(video.getStartTime())
        displayTitleVideo(video.getVideoTitle(), itemView.tvTitleVideo)
        displayDurationVideo(video.getDurationValue(), itemView.tvTimeDuration)
        displayCollections(video.collections, itemView.icTypeLogoGCU)
    }

    private fun loadThumbnail(video: MMVideo) {
        NowPlayingVHDisplayHelper.displayThumbnail(itemView.thumbnailVideo, video.thumbnailSmallUrl)
    }

//    private fun bindDownloadData(video : MMVideo) {
//        mDownloadButtonManager.setVideoData(video)
//    }

    private fun displayTimeStart(playTime: String) {
        if (presenter?.getPlayMode() == PlayMode.SCHEDULE)
            NowPlayingVHDisplayHelper.displayTimeStart(itemView.tvTimeStart, playTime)
        else
            itemView.tvTimeStart?.visibility = View.GONE
    }

    private fun displayDurationVideo(durationValue: String, tvTimeDuration: TextView?) {
        if (tvTimeDuration == null) return
        tvTimeDuration.text = durationValue
    }

    private fun displayTitleVideo(videoName: String, tvTitleVideo: TextView?) {
        tvTitleVideo?.text = videoName
    }

    private fun displayTypeLogo(typeLogo: String?, iconView: ImageView) {
        NowPlayingVideoInfoDisplayHelper.displayTypeLogoBrand(typeLogo, iconView)
    }

    private fun displayCollections(collections: ArrayList<MMTinyCategory>?, icTypeLogo: ImageView) {
        if (itemView !is ConstraintLayout) return

        mExtraCollectionViews =
                SearchCollectionUtil.displayCollections(parentView = itemView.lineCollections, leftView = icTypeLogo,
                        collections = collections, collectionCountMax = 2, extraCollectionTextViews = mExtraCollectionViews)
    }

    fun release() {
        //mDownloadButtonManager.release()
        presenter = null
        mVideo = null
        mExtraCollectionViews?.clear()
    }
}