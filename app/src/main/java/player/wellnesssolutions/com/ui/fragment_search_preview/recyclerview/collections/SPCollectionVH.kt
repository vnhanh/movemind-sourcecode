package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.vh_sp_collection.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMCircleImageView
import player.wellnesssolutions.com.network.models.screen_search.MMCollection

class SPCollectionVH(view: View) : BaseVH<MMCollection>(view) {
    companion object {
        private var mImageLoadSize = 0
    }

    fun bind(collection: MMCollection, isSelected: Boolean) {
        super.bind(collection)

        itemView.tvCollectionName?.text = collection.name
        displayLogoCollection(itemView.imgCollectionLogo, collection.image, collection.getColorStr())

        select(isSelected)
    }

    private fun displayLogoCollection(imageView: MMCircleImageView?, url: String?, color: String) {
        try {
            imageView?.also { imgView ->
                if (color.isNotEmpty() && color.length > 1)
                    imgView.setStrokeColor(Color.parseColor(color))

                if (mImageLoadSize == 0) {
                    val size: Int = imgView.resources?.getDimensionPixelSize(R.dimen.search_option_item_image_size)
                            ?: 130
                    mImageLoadSize = (size * (1 - Constant.RATIO_STROKE_BORDER) / Constant.RATIO_SQUARE_INNER_CIRCLE).toInt()
                }

                Glide.with(imgView).load(url)
                        .apply(RequestOptions().fitCenter().override(mImageLoadSize, mImageLoadSize)
                                .placeholder(R.drawable.bg_sp_deault_collection)
                                .fallback(R.drawable.bg_sp_deault_collection)
                                .error(R.drawable.bg_sp_deault_collection))
                        .into(imgView)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun select(isSelected: Boolean) {
        itemView.imgCollectionLogo?.isSelect(isSelected)
    }
}