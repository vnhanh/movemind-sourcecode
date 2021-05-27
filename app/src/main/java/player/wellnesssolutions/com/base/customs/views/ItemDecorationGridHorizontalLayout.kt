package player.wellnesssolutions.com.base.customs.views

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorationGridHorizontalLayout(val rowNumber: Int) : RecyclerView.ItemDecoration() {
    var margin: Int = 0
    var maxRows: Int = 0

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val index = parent.indexOfChild(view)
        val rowIndex = index % rowNumber
        val outLeft: Int = if (index < rowNumber) 0 else margin
        val outTop: Int = if (rowIndex == 0) 0 else margin
        val outRight: Int = margin
        val outBottom = margin

        outRect.set(outLeft, outTop, outRight, outBottom)
    }

    /*private constructor(builder: Builder) : this(builder.dividerDrawable, builder.dividerPixelSize, builder.colNumber)

    data class Builder(val context: Context) {
        var dividerDrawable: Drawable? = null
        var dividerPixelSize = 0
        var colNumber = 1

        fun dividerDrawableResID(@DrawableRes id: Int) = apply { dividerDrawable = ContextCompat.getDrawable(context, id) }
        fun dividerSizeResID(@DimenRes size: Int) = apply { dividerPixelSize = context.resources.getDimensionPixelSize(size) }
        fun colNumber(number: Int) = apply { colNumber = number }
        fun build() = ItemDecorationGridHorizontalLayout(this)
    }*/
}