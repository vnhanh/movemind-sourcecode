package player.wellnesssolutions.com.ui.fragment_search_instructors.recyclerview

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.viewholder_search_video_presenter.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_instructors.ISearchInstructorContract
import java.lang.ref.WeakReference


class SearchInstructorVH(view: View, listener: ISearchInstructorContract.Presenter?, itemWidth: Int, itemHeight: Int, countItemInRow: Int, val mGlideHeaders: LazyHeaders?) :
        BaseSearchVH<MMInstructor>(view, itemWidth, itemHeight, countItemInRow), View.OnClickListener {
    private var weakPresenter = WeakReference(listener)
    private var mLoadSize = 0

    init {
        ViewUtil.setupOnClicked(itemView.tvName, this)
        ViewUtil.setupOnClicked(itemView.imgAvatar, this)
//        ViewUtil.setupOnClicked(itemView.imageCover, this)
        ViewUtil.setupOnClicked(itemView.btnShowInfoItemSearchInstructor, this)

        val size = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_presenter_avatar_size)
        val padding = itemView.resources.getDimensionPixelSize(R.dimen.padding_circle_item_for_6_items_search_in_row)
        mLoadSize = size - padding * 2
        setPaddingImage(padding)
        setMarginForPivotView(padding)
        drawStroke(padding)
    }

    private fun setPaddingImage(padding: Int) {
        itemView.imgAvatar.setPadding(padding, padding, padding, padding)
    }

    private fun drawStroke(padding: Int) {
        val strokeBg = GradientDrawable().also {
            it.shape = GradientDrawable.OVAL
            it.color = ColorStateList.valueOf(Color.WHITE)
            it.setStroke(padding, ContextCompat.getColor(itemView.context, R.color.instructorStroke))
        }
        itemView.imgAvatar.background = strokeBg
    }

    override fun onClick(view: View) {
        data?.also { data ->
            changeAvatarBgColorOnClick()
            view.isEnabled = false

            when (view.id) {
                itemView.tvName.id, itemView.imgAvatar.id -> {
                    weakPresenter.get()?.onClickInstructorItem(data)
                }
                itemView.btnShowInfoItemSearchInstructor.id -> {
                    weakPresenter.get()?.onClickShowInfoInstructor(data)
                }
            }

            view.isEnabled = true
        }
    }

    private var mAvatarDrawable: Drawable? = null

    private fun changeAvatarBgColorOnClick() {
        mAvatarDrawable = itemView.imgAvatar.background

        val coverDrawable: GradientDrawable = GradientDrawable().also {
            it.shape = GradientDrawable.OVAL
            it.color = ColorStateList.valueOf(Color.LTGRAY)
            it.alpha = 200
        }

        itemView.imgAvatar.background = null
        itemView.imgAvatar.background = LayerDrawable(arrayOf(mAvatarDrawable, coverDrawable))

        itemView.postDelayed({
            itemView.imgAvatar.background = mAvatarDrawable
        }, 200L)
    }

    override fun bind(data: MMInstructor) {
        super.bind(data)

        itemView.tvName.text = String.format(" %s ", data.name ?: Constant.SHARP)

        loadAvatar(data)
    }

    private fun setMarginForPivotView(imagePadding: Int) {
        val params = itemView.viewPivotTopRight.layoutParams as ConstraintLayout.LayoutParams
        params.rightMargin = imagePadding
        params.topMargin = (imagePadding * 2.8f).toInt()
    }

    private fun loadAvatar(data: MMInstructor) {
        if (!data.image.isNullOrEmpty()) {

            Glide.with(itemView).load(data.image).override(mLoadSize, mLoadSize).circleCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.ic_no_instructor).error(R.drawable.ic_no_instructor)
                    .into(itemView.imgAvatar)
        }
    }
}