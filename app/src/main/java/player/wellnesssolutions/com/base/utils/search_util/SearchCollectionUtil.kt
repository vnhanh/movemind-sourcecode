package player.wellnesssolutions.com.base.utils.search_util

import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory

object SearchCollectionUtil {
    private var mTvCollectionHeight = 0
    private var MARGIN = 0
    var isCollectionChoose = false
    var isSkipAndSearchChoose = false

    fun displayText(tv: TextView, name: String, colorStr: String?) {
        val color =
                when (colorStr.isNullOrEmpty() || colorStr.length < 2) {
                    true -> Color.parseColor(Constant.DEF_COLLECTION_TEXT_COLOR)
                    false -> Color.parseColor(colorStr)
                }

        tv.text = StringBuilder(name.toUpperCase()).append(Constant.WHITE_SPACE).toString()
        tv.setTextColor(color)
    }

    /**
     * -----------------------
     */

    fun displayCollections(parentView: LinearLayout?,
                           leftView: View?,
                           collections: ArrayList<MMTinyCategory>?,
                           collectionCountMax: Int,
                           extraCollectionTextViews: ArrayList<TextView>?): ArrayList<TextView>? {
        parentView?.also { rootView ->
            extraCollectionTextViews?.also { list ->
                while (list.size > 0) {
                    rootView.removeView(list.get(0))
                    list.removeAt(0)
                }
            }

            if (collections == null || collections.size == 0) {
                return extraCollectionTextViews
            }

            var newListViews = extraCollectionTextViews
            if (newListViews == null) newListViews = ArrayList()

            if (MARGIN == 0) MARGIN = rootView.resources?.getDimensionPixelSize(R.dimen.margin) ?: 0

            var prevTv = leftView

            val lastIndex = Math.min(collections.size - 1, collectionCountMax)

            for (i: Int in 0..lastIndex) {
                val content = if (i < collectionCountMax) collections.get(i).name
                        ?: "" else Constant.DOUBLE_DOTS
                val colorStr = collections.get(i).getColor()

                prevTv = addExtraSmallView(rootView, content, colorStr, MARGIN)
                newListViews.add(prevTv)
            }
            return newListViews
        }

        return null
    }

    private fun addExtraSmallView(parentView: LinearLayout, name: String, colorStr: String?, leftMargin: Int): TextView {
        val tv = TextView(parentView.context)
        if (mTvCollectionHeight == 0) mTvCollectionHeight = parentView.resources?.getDimensionPixelSize(R.dimen.vh_now_playing_title_collection_height)
                ?: 15

        tv.id = ViewCompat.generateViewId()
        tv.setTypeface(null, Typeface.BOLD_ITALIC)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, parentView.resources.getDimensionPixelSize(R.dimen.tv_collection_video_text_size_small).toFloat())

        displayText(tv, name, colorStr)

        val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.marginStart = leftMargin
        params.gravity = Gravity.BOTTOM
        tv.layoutParams = params

        parentView.addView(tv)

        return tv
    }
}