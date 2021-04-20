package player.wellnesssolutions.com.base.customs.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter

class RecyclerViewCustom : androidx.recyclerview.widget.RecyclerView {
    var isCustomed = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var customAdapter: BaseSearchVideosAdapter<*, *, *>? = null


    fun setCustomAdapter(adapter: BaseSearchVideosAdapter<*, *, *>?) {
        customAdapter = adapter

        if (!isCustomed) {
            if (this.adapter != null) this.adapter = null
            this.adapter = adapter
            return
        }

        if (adapter == null || width == 0 || height == 0) {
            return
        }

        when (val childCount = adapter.itemCount) {
            in 0..adapter.maxItemCountInRow -> {
                adapter.apply {
                    rowSpan = 1
                    colSpan = if (childCount == 0) 1 else childCount
                    itemHeight = height
                    itemWidth = width / colSpan
                }
            }

            else -> {
                adapter.apply {
                    val t: Int = childCount / maxItemCountInRow
                    val d: Int = if (t * maxItemCountInRow < childCount) 1 else 0

                    val r: Int = Math.min(t + d, maxRowCount)
                    rowSpan = if (r == 0) 1 else r
                    colSpan = if (maxItemCountInRow == 0) 1 else maxItemCountInRow
                    itemHeight = height / rowSpan
                    itemWidth = width / colSpan
                }
            }
        }

        if (width > 0 && height > 0)
            this.adapter = adapter

        adapter.updateDimensionsForVHs()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        if (isCustomed) {
            post {
                applyDimensionForCustomAdapter()
            }
        }
    }

    private fun applyDimensionForCustomAdapter() {
        customAdapter?.also { mAdapter ->
            setupForAdapter(mAdapter)
        }
    }

    private fun setupForAdapter(adapter: BaseSearchVideosAdapter<*, *, *>) {
        if (this.adapter != null || !isCustomed) return

        when (val childCount = adapter.itemCount) {
            in 0..adapter.maxItemCountInRow -> {
                adapter.apply {
                    rowSpan = 1
                    colSpan = childCount
                    itemHeight = height
                    itemWidth = width / colSpan
                }
            }

            else -> {
                adapter.apply {
                    val _t = childCount / maxItemCountInRow
                    val _d = if (_t * maxItemCountInRow < childCount) 1 else 0

                    rowSpan = Math.min(_t + _d, maxRowCount)
                    colSpan = maxItemCountInRow
                    itemHeight = height / rowSpan
                    itemWidth = width / colSpan
                }
            }
        }

        adapter.updateDimensionsForVHs()

        this.adapter = adapter
    }

    companion object {

        fun alignCenterHorizontal(rv: RecyclerViewCustom?, itemCount: Int, parentView: ConstraintLayout?, aboveView: View?, itemSize: Int = 0) {
            if (parentView == null || aboveView == null) return
            rv?.also { recyclerViewCustom ->
                val resources = recyclerViewCustom.resources

                val size: Int =
                        when (itemSize) {
                            0 -> resources.getDimensionPixelSize(R.dimen.vh_search_item_size_default)
                            else -> itemSize
                        }

                val width = size * itemCount
                recyclerViewCustom.layoutParams = ConstraintLayout.LayoutParams(width, 0)

                val set = ConstraintSet()
                set.clone(parentView)

                set.connect(recyclerViewCustom.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
                set.connect(recyclerViewCustom.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
                set.connect(recyclerViewCustom.id, ConstraintSet.TOP, aboveView.id, ConstraintSet.BOTTOM)
                set.connect(recyclerViewCustom.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

                set.applyTo(parentView)

                recyclerViewCustom.isCustomed = false
            }
        }
    }

    fun release() {
        customAdapter?.release()
        customAdapter = null
        this.adapter = null
    }
}