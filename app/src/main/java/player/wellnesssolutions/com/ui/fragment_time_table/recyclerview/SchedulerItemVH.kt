package player.wellnesssolutions.com.ui.fragment_time_table.recyclerview

import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.viewholder_timetable.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.network.models.response.SessionVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil

class SchedulerItemVH(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        private var THUMBNAIL_WIDTH = 0
        private var THUMBNAIL_HEIGHT = 0
        private var TYPE_BRAND_ICON_WIDTH = 0
        private var TYPE_BRAND_ICON_HEIGHT = 0
        private var MARGIN = 0
    }

    private var mData: SessionVideo? = null
    private var mExtraCollectionViews: ArrayList<TextView>? = null

    private var mView: View? = view

    init {
        itemView.tvSchedulerStart.setTypeface(null, Typeface.BOLD_ITALIC)

        if (THUMBNAIL_WIDTH == 0) THUMBNAIL_WIDTH = itemView.resources?.getDimensionPixelSize(R.dimen.width_thumbnail_video_time_table)?:0
        if (THUMBNAIL_HEIGHT == 0) THUMBNAIL_HEIGHT = itemView.resources?.getDimensionPixelSize(R.dimen.height_thumbnail_video_time_table)?:0
        if (TYPE_BRAND_ICON_WIDTH == 0) TYPE_BRAND_ICON_WIDTH = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_width)?:0
        if (TYPE_BRAND_ICON_HEIGHT == 0) TYPE_BRAND_ICON_HEIGHT = itemView.resources?.getDimensionPixelSize(R.dimen.vh_search_result_ic_type_logo_height)?:0
        if (MARGIN == 0) MARGIN = view.resources?.getDimensionPixelSize(R.dimen.margin)?:0

        resizeWidthHeightItem(itemView)

        setupTitleVideo()
    }

    private fun resizeWidthHeightItem(itemView: View) {
        mView?.also {
            val density = it.resources.displayMetrics.density
            if (density == 1.5f) {
                try {
                    val dm = DisplayMetrics()
                    (it.context as MainActivity).windowManager.defaultDisplay.getMetrics(dm)
                    if (dm.xdpi == 480.0f) {
                        val params = itemView.parentViewSchedulerItem.layoutParams
                        params.height = params.height - 30
                        itemView.parentViewSchedulerItem.layoutParams = params
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun setupTitleVideo() {
        val tf: Typeface = TypefaceUtil.getTypeface(itemView.context, itemView.context.getString(R.string.font_made_evolve_sans))
        itemView.tvVideoTitle?.setTypeface(tf, Typeface.ITALIC)
    }

    fun bind(item: SessionVideo) {
        mData = item

        loadThumbnail(itemView.thumbVideo, item.thumbnail657)

        displayTextViews(item)

        displayIconBrandAndCollections(item)

    }

    private fun loadThumbnail(thumbVideo: ImageView?, thumbnail657: String?) {
        if (thumbVideo == null || thumbnail657.isNullOrEmpty()) return
        val corner = itemView.resources?.getDimensionPixelSize(R.dimen.corner_4dp)?:0
        Glide.with(thumbVideo.context).load(thumbnail657)
                .transform(CenterCrop(), RoundedCorners(corner))
                .override(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT)
                .placeholder(R.drawable.bg_rectangle_ltgray_corner_4dp)
                .error(R.drawable.bg_rectangle_ltgray_corner_4dp)
                .into(thumbVideo)
    }

    private fun displayIconBrandAndCollections(item: SessionVideo) {
        loadBrandTypeLogo(itemView.icTypeBrand, item.logo)
        mExtraCollectionViews = SearchCollectionUtil.displayCollections(
                parentView = itemView.groupIconBrandAndCollections,
                leftView = itemView.icTypeBrand,
                collections = item.collections,
                collectionCountMax = 2,
                extraCollectionTextViews = mExtraCollectionViews
        )
    }

    private fun loadBrandTypeLogo(icCollection: ImageView?, logo: String?) {
        icCollection?.also { imageView ->
            Glide.with(imageView.context).load(logo)
                    .override(TYPE_BRAND_ICON_WIDTH, TYPE_BRAND_ICON_HEIGHT)
                    .placeholder(R.drawable.bg_rectangle_gray_corner_2dp).error(R.drawable.bg_rectangle_gray_corner_2dp)
                    .into(imageView)
        }
    }

    private fun displayTextViews(item: SessionVideo) {
        itemView.tvVideoTitle?.text = item.nameOfVideo
        itemView.tvSchedulerStart?.text = item.getTime()
        itemView.tvVideoDuration?.text = item.getDurationValue()

        displayLevels(item.levels)

        itemView.tvVideoInstructor?.text = item.instructorName
    }

    private fun displayLevels(levels: ArrayList<MMTinyCategory>?) {
        val firstLevelName: String? = if (levels == null || levels.size == 0) "" else levels[0].name

        when (firstLevelName == null || firstLevelName.isEmpty()) {
            true -> {
                itemView.icLevel?.visibility = View.GONE
                itemView.tvVideoLevel?.visibility = View.GONE
            }

            false -> {
                itemView.icLevel?.visibility = View.VISIBLE
                itemView.tvVideoLevel?.visibility = View.VISIBLE
                itemView.tvVideoLevel?.text = firstLevelName
            }
        }
    }

    fun release(){
        mView = null
    }
}