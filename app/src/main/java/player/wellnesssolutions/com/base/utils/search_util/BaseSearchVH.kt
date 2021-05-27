package player.wellnesssolutions.com.base.utils.search_util

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseVH

abstract class BaseSearchVH<M : Any>(
    itemView: View,
    var itemWidth: Int,
    var itemHeight: Int,
    var itemCountInRow: Int
) : BaseVH<M>(itemView) {
    protected var rowSpan = 1
    protected var parentWidth = GridLayoutManager.LayoutParams.MATCH_PARENT

    init {
        setupLayout()
    }

    fun setupLayout() {
        applyDimensions(itemWidth, itemHeight)
    }

    fun setDimensions(itemWidth: Int, itemHeight: Int) {
        applyDimensions(itemWidth, itemHeight)
    }

    protected open fun applyDimensions(itemWidth: Int, itemHeight: Int, force: Boolean = false) {
        if (itemWidth == 0 || itemHeight == 0) return
        if (this.itemWidth == itemWidth && this.itemHeight == itemHeight) return

        this.itemWidth = itemWidth
        this.itemHeight = itemHeight

        setupDimensForItem(itemWidth, itemHeight)
    }

    private fun setupDimensForItem(width: Int, height: Int) {
        val params = GridLayoutManager.LayoutParams(width, height)
        itemView.layoutParams = params
    }

    protected fun setupDimensAndSetBgDrawableForCircleView(view: View, itemCountInRow: Int): PrivateDimens {
        val size: Int
        val padding: Int
        when (itemCountInRow) {
            in 1..3 -> {
                size = itemView.resources.getDimensionPixelSize(R.dimen.size_item_circle_for_1_to_3_items_search_in_row)
                padding = itemView.resources.getDimensionPixelSize(R.dimen.padding_circle_item_for_1_to_3_items_search_in_row)
            }
            4 -> {
                size = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_screen_4_items)
                padding = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_circle_item_4_items_padding)
            }
            5 -> {
                size = itemView.resources.getDimensionPixelSize(R.dimen.size_item_circle_for_5_items_search_in_row)
                padding = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_screen_cicle_item_for_5_items_or_more_padding)
            }
            else -> {
                size = itemView.resources.getDimensionPixelSize(R.dimen.size_item_circle_for_6_items_search_in_row)
                padding = itemView.resources.getDimensionPixelSize(R.dimen.padding_circle_item_for_6_items_search_in_row)
            }
        }

        setupDimensForCircleItem(view, size, size, padding)

        return PrivateDimens(size, padding)
    }

    protected fun setupDimensForCircleItem(view: View, width: Int, height: Int, padding: Int) {
        view.setPadding(padding, padding, padding, padding)
        val params = view.layoutParams as ConstraintLayout.LayoutParams
        params.width = width
        params.height = height
        view.layoutParams = params
    }

    data class PrivateDimens(val size: Int, val padding: Int)
}