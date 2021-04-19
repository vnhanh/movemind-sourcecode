package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.vh_search_result.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.common.constant.Constant.DEF_SECONDARY_COLOR
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion.mVideosToPlay
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil


class VideosSearchResultPageVH(view: View, val mItemWidth: Int, val mItemHeight: Int, private var presenter: ISearchResultPageContract.Presenter?) :
        RecyclerView.ViewHolder(view), View.OnClickListener, ISearchResultItemListener {

    companion object {
        private var mTypeLogoWidth = 0
        private var mTypeLogoHeight = 0
        private var mDownloadButtonSize = 0
        private var mThumbnailWidth = 0
        private var mThumbnailHeight = 0
    }

    private var mVideo: MMVideo? = null
    private var mExtraViews: ArrayList<TextView>? = ArrayList()

    //private var mDownloadButtonManager = DownloadButtonManager(itemView.btnDownload)
    // flag check if this item is selected or not
    private var mIsSelected = false

    private var mView:View? = view

    init {
        when (mItemWidth == 0 || mItemHeight == 0) {
            true -> {
                mThumbnailWidth = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_thumbnail_width)
                        ?: 0
                mThumbnailHeight = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_thumbnail_height)
                        ?: 0
            }

            false -> {
                val density = view.resources?.displayMetrics?.density ?: 0
                val itemPadding = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_padding)
                        ?: 0
                mThumbnailWidth = mItemWidth - itemPadding * 2
                mThumbnailHeight = if (density == 1.5f) {
                    try {
                        val dm = DisplayMetrics()
                        view.context?.also { context ->
                            if (context is MainActivity) context.windowManager.defaultDisplay.getMetrics(dm)
                        }
                        when (dm.xdpi) {
                            240.0f -> mThumbnailWidth * 5 / 12
                            480.0f -> mThumbnailWidth * 5 / 14
                            else -> mThumbnailWidth * 5 / 14
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        mThumbnailWidth * 5 / 14
                    }
                } else {
                    mThumbnailWidth * 5 / 12
                }
            }
        }

        itemView.videoThumbnail?.also { thumbnail ->
            val thumbnailParams: ConstraintLayout.LayoutParams = thumbnail.layoutParams as ConstraintLayout.LayoutParams
            thumbnailParams.width = mThumbnailWidth
            thumbnailParams.height = mThumbnailHeight
            thumbnail.layoutParams = thumbnailParams
        }

        mTypeLogoWidth = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_width)
                ?: 0
        mTypeLogoHeight = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_height)
                ?: 0

        if (mDownloadButtonSize == 0) {
            val buttonSize = itemView.resources?.getDimensionPixelSize(R.dimen.size_btn_download_item_video_result_search)
                    ?: 0
            val buttonPadding = itemView.resources?.getDimensionPixelSize(R.dimen.padding_btn_download_item_video_result_search)
                    ?: 0
            mDownloadButtonSize = buttonSize - buttonPadding * 2
        }

        itemView.videoThumbnail?.setOnClickListener(this)

        setupThumbnailSelectedView()

        setupTitleVideo()
        loadDownloadIcon()
        loadPreviewIcon()

        presenter?.addItemListener(this)
    }

    private fun setupTitleVideo() {
        itemView.tvVideoTitle?.also { textView ->
            val tf: Typeface = TypefaceUtil.getTypeface(textView.context, textView.context.getString(R.string.font_made_evolve_sans))
            textView.setTypeface(tf, Typeface.ITALIC)
            textView.setOnClickListener(this)
        }
    }

    private fun setupThumbnailSelectedView() {
        try {
            val shape: GradientDrawable = GradientDrawable().also {
                it.shape = GradientDrawable.RECTANGLE
                it.color = ColorStateList.valueOf(Color.TRANSPARENT)
                it.cornerRadius = (itemView.resources?.getDimensionPixelSize(R.dimen.corner_2dp)
                        ?: 0) * 1f
                val itemSize = Math.min(mItemWidth, mItemHeight)
                val strokeWidth = (itemSize * 0.02f).toInt()
                it.setStroke(strokeWidth, Color.parseColor(PreferenceHelper.getInstance()?.getString(ConstantPreference.SECONDARY_COLOR, DEF_SECONDARY_COLOR)
                        ?: DEF_SECONDARY_COLOR))
            }
            itemView.thumbnailSelectedView?.background = shape
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun release() {
        //mDownloadButtonManager.release()
        mView = null
        presenter = null
        mVideo = null
        mExtraViews?.clear()
        mExtraViews = null
    }

    override fun onClick(view: View) {
        when (view.id) {
            itemView.videoThumbnail?.id, itemView.tvVideoTitle?.id -> {
                toggleSelectVideo()
            }

            else -> {
                itemView.blurThumbnail?.visibility = View.VISIBLE
                presenter?.onClickedResultItem(mVideo)
                view.postDelayed({
                    itemView.blurThumbnail?.visibility = View.GONE
                }, 200L)
            }
        }
    }

    private fun loadDownloadIcon() {
        itemView.btnDownload?.also { button ->
            Glide.with(button).load(R.drawable.ic_download)
                    .override(mDownloadButtonSize).into(button)
        }
    }

    // show TRAILER VIDEO PREVIEW icon
    private fun loadPreviewIcon() {
        itemView.btnPreview?.also { button ->
            button.setOnClickListener(this)
            Glide.with(button).load(R.drawable.ic_preview_trailer)
                    .override(mDownloadButtonSize).into(button)
        }
    }

    fun bind(data: MMVideo) {
        this.mVideo = data

        presenter?.also { presenter ->

            when (presenter.isVideoSelected(data)) {
                true -> {
                    selectVideo()
                }

                else -> {
                    unselectVideo()
                }
            }
        }

        displayContent(data)

        checkToggleItemSelected(data)
    }

    private fun checkToggleItemSelected(data: MMVideo) {
        if (mVideosToPlay.size > 0) {
            mVideosToPlay.forEach {
                if (it.id == data.id) {
                    mIsSelected = true
                    itemView.tvVideoTitle?.setTextColor(
                            Color.parseColor(
                                    PreferenceHelper.getInstance()?.getString(ConstantPreference.SECONDARY_COLOR, DEF_SECONDARY_COLOR)
                                            ?: DEF_SECONDARY_COLOR
                            )
                    )
                    itemView.thumbnailSelectedView?.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun loadBrandTypeLogo(icTypeLogo: ImageView?, brandTypeLogo: String?) {
        icTypeLogo?.also { imageView ->
            Glide.with(imageView).load(brandTypeLogo)
                    .override(mTypeLogoWidth, mTypeLogoHeight)
                    .into(imageView)
        }
    }

    private fun displayContent(data: MMVideo) {
        // thumbnail video
        itemView.videoThumbnail?.also { thumbnail ->
            Glide.with(thumbnail).load(data.thumbnailMediumUrl)
                    .override(mThumbnailWidth, mThumbnailHeight)
                    .transform(CenterCrop(), RoundedCorners(itemView.resources?.getDimensionPixelSize(R.dimen.corner_4dp)
                            ?: 4))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.bg_rectangle_ltgray_corner_4dp)
                    .error(R.drawable.bg_rectangle_ltgray_corner_4dp)
                    .into(thumbnail)
        }

        // displaying icon type logo
        loadBrandTypeLogo(itemView.icTypeLogo, data.brandTypeLogo)

        // set video data and display whether video is downloading or downloaded
        //mDownloadButtonManager.setVideoData(data)

        // displaying video title
        itemView.tvVideoTitle?.text = data.getVideoTitle()

        itemView.tvVideoDuration?.text = data.getDurationValue()

        showCollections(itemView.icTypeLogo, data.collections)

        resizeWidthHeightItem(itemView)

    }

    private fun resizeWidthHeightItem(itemView: View) {
        mView?.also { view->
            val density = view.resources.displayMetrics.density
            if (density == 1.5f) {
                try {
                    val dm = DisplayMetrics()
                    (view.context as MainActivity).windowManager.defaultDisplay.getMetrics(dm)
                    if (dm.xdpi == 480.0f) {

                        val paramsTv = itemView.tvVideoDuration.layoutParams
                        paramsTv.height = view.context.resources.getDimensionPixelSize(R.dimen.dip_39)
                        paramsTv.width = view.context.resources.getDimensionPixelSize(R.dimen.dip_39)
                        itemView.tvVideoDuration.layoutParams = paramsTv

                        val paramsBtnDownload = itemView.btnDownload.layoutParams
                        paramsBtnDownload.height = view.context.resources.getDimensionPixelSize(R.dimen.dip_35)
                        paramsBtnDownload.width = view.context.resources.getDimensionPixelSize(R.dimen.dip_35)
                        itemView.btnDownload.layoutParams = paramsBtnDownload

                        val paramsBtnPreview = itemView.btnPreview.layoutParams
                        paramsBtnPreview.height = view.context.resources.getDimensionPixelSize(R.dimen.dip_35)
                        paramsBtnPreview.width = view.context.resources.getDimensionPixelSize(R.dimen.dip_35)
                        itemView.btnPreview.layoutParams = paramsBtnPreview

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun showCollections(icTypeLogo: ImageView?, collections: ArrayList<MMTinyCategory>?) {
        val layout: View? = itemView
        layout?.also { view ->
            if (view is ConstraintLayout)
                mExtraViews = SearchCollectionUtil.displayCollections(
                        parentView = view.groupCollections,
                        leftView = icTypeLogo,
                        collections = collections,
                        collectionCountMax = 2,
                        extraCollectionTextViews = mExtraViews
                )
        }
    }

    fun toggleSelectVideo() {
        when (mIsSelected) {
            true -> {
                itemView.tvVideoTitle?.setTextColor(Color.BLACK)
                itemView.thumbnailSelectedView?.visibility = View.INVISIBLE
            }
            false -> {
                itemView.tvVideoTitle?.setTextColor(
                        Color.parseColor(PreferenceHelper.getInstance()?.getString(ConstantPreference.SECONDARY_COLOR, DEF_SECONDARY_COLOR)
                                ?: DEF_SECONDARY_COLOR)
                )
                itemView.thumbnailSelectedView?.visibility = View.VISIBLE
            }
        }

        mIsSelected = !mIsSelected
        presenter?.selectVideoToPlay(mVideo, mIsSelected)
    }

    override fun selectVideo() {
        if (mIsSelected) return
        mIsSelected = false
        toggleSelectVideo()
    }

    override fun unselectVideo() {
        if (!mIsSelected) return
        mIsSelected = true
        toggleSelectVideo()
    }

    override fun download() {
//        itemView.btnDownload?.also { downloadBtn ->
//            if(!mDownloadButtonManager.isDownloaded()){
//                downloadBtn.performClick()
//            }
//        }
    }

    override fun isDownloaded(): Boolean = false

    override fun getVideo(): MMVideo? = mVideo
}