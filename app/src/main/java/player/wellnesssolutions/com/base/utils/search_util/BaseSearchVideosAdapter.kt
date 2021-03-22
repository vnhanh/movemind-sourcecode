package player.wellnesssolutions.com.base.utils.search_util

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.base.view.BaseVH

abstract class BaseSearchVideosAdapter<VH : BaseVH<M>, T : Any, M : Any>(listener: T?, list: ArrayList<M>) : BaseClickableAdapter<VH, T, M>(listener, list) {
    var itemHeight = 0
    var itemWidth = 0
    var rowSpan = 1
    var colSpan = 1
    var maxItemCountInRow = 1
    var maxRowCount = 1

    fun setDimensions(itemWidth: Int, itemHeight: Int) {
        this.itemWidth = itemWidth
        this.itemHeight = itemHeight
    }

    fun updateDimensionsForVHs() {
        setDimensions(itemWidth, itemHeight)
    }

    fun setupDimensForViewHolder(view: View) {
        val params = GridLayoutManager.LayoutParams(itemWidth, itemHeight)
        view.layoutParams = params
    }

    fun setupLayoutForItemView(itemView: View, circleView: View) {
        val isNeedChangeLayout = list.size < maxItemCountInRow

        if (!isNeedChangeLayout) {
            setupDimensForViewHolder(itemView)
            val params = circleView.layoutParams as ConstraintLayout.LayoutParams
            params.setMargins(0, 0, 0, 0)
        } else {
            itemView.layoutParams = GridLayoutManager.LayoutParams(GridLayoutManager.LayoutParams.WRAP_CONTENT, GridLayoutManager.LayoutParams.MATCH_PARENT)
        }
    }
}