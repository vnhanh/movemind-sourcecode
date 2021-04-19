package player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.vh_search_videos_by_image.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMCircleImageView
import player.wellnesssolutions.com.common.enums.StyleEnumInner
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.model.SearchByOptionImage

class SearchVideosByImageVH(view: View) : SearchVideosByVH(view) {
    private val mLoadSize: Int

    init {
        val size = itemView.resources.getDimensionPixelSize(R.dimen.vh_svb_circle_item_size)
        mLoadSize = (size * (1f - Constant.RATIO_STROKE_BORDER)).toInt()
    }

    override fun bind(data: SearchByOption) {
        super.bind(data)

        val title: String = data.title
        itemView.tvNameSVBItem?.text = title

        if (data is SearchByOptionImage)
            loadImage(itemView.imgSVBItem, data)
    }

    private fun loadImage(imageView: MMCircleImageView?, data: SearchByOptionImage) {
        val imgResId: Int = data.imageResId
        val innerStyle: StyleEnumInner = data.innerStyle
        val bgColorStr: String = data.bgColorStr

        if (imgResId == -1 || bgColorStr.isEmpty() || bgColorStr.length < 2) return

        // set padding inner
        imageView?.also { imgView ->
            imgView.setInnerStyle(innerStyle)
            imgView.bgColor = Color.parseColor(bgColorStr)
            imgView.setupBackground()

            when (innerStyle) {
                StyleEnumInner.CIRCLE_FIT_INNER -> {
                    Glide.with(imgView).load(data.imageResId)
                            .override(mLoadSize).circleCrop()
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .placeholder(R.drawable.bg_circle_white).error(R.drawable.bg_circle_white)
                            .into(imgView)
                }

                StyleEnumInner.SQUARE_INNER_CIRCLE -> {
                    Glide.with(imgView).load(imgResId)
                            .override(mLoadSize)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(imgView)
                }
            }
        }

    }
}