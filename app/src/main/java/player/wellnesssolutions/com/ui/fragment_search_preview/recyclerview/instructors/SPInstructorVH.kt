package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.instructors

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.vh_sp_presenter.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMCircleImageView
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor

class SPInstructorVH(view: View) : BaseVH<MMInstructor>(view) {
    fun bind(data: MMInstructor, isSelected: Boolean) {
        super.bind(data)

        itemView.tvPresenterName.text = data.name
        loadAvatar(itemView.imgPresenterAvatar, data.image)

        select(isSelected)
    }

    private fun loadAvatar(imageView: MMCircleImageView, image: String?) {
        val size = itemView.resources.getDimensionPixelSize(R.dimen.search_option_item_image_size)

        if (imageView.mPadding == 0) {
            val padding = (size * Constant.RATIO_STROKE_BORDER).toInt()
            imageView.mPadding = padding
        }

        val loadSize = size - imageView.mPadding * 2

        Glide.with(imageView).load(image)
                .override(loadSize).circleCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.bg_sp_no_instructor)
                .fallback(R.drawable.bg_sp_no_instructor)
                .error(R.drawable.bg_sp_no_instructor)
                .into(imageView)
    }

    fun select(isSelected: Boolean) {
        itemView.imgPresenterAvatar.isSelect(isSelected)
    }
}