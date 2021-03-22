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

    //    fun displayCollections(parentView: ConstraintLayout, leftView:View, collections:ArrayList<MMTinyCategory>?, collectionCountMax:Int,
//                           extraViews:ArrayList<TextView>?) : ArrayList<TextView>?{
//
//        while (extraViews?.size?:0 > 0){
//            parentView.removeView(extraViews?.get(0))
//            extraViews?.removeAt(0)
//        }
//
//        if(collections == null || collections.size == 0) {
//            return extraViews
//        }
//
//        if(MARGIN == 0) MARGIN = parentView.resources.getDimensionPixelSize(R.dimen.margin)
//
//        var prevTv = leftView
//
//        val lastIndex = Math.min(collections.size - 1, collectionCountMax)
//
//        for (i : Int in 0..lastIndex){
//            val content = if(i < collectionCountMax) collections.get(i).name?:"" else "..."
//            val colorStr = collections.get(i).getColor()
//
//            prevTv = addExtraSmallView(parentView, prevTv, content, colorStr, MARGIN)
//            extraViews?.add(prevTv)
//        }
//
//        return extraViews
//    }
//
    fun addExtraSmallView(parentView: ConstraintLayout, prevView: View, name: String, colorStr: String?, leftMargin: Int): TextView {
        val tv = TextView(parentView.context)

        if (mTvCollectionHeight == 0) mTvCollectionHeight = parentView.resources.getDimensionPixelSize(R.dimen.vh_now_playing_title_collection_height)

        tv.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                mTvCollectionHeight
        )

        tv.id = ViewCompat.generateViewId()
        tv.setTypeface(null, Typeface.BOLD_ITALIC)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, parentView.resources.getDimensionPixelSize(R.dimen.tv_collection_video_text_size_small).toFloat())

        displayText(tv, name, colorStr)

        parentView.addView(tv)

        applyConstraintSet(parentView, prevView, tv, leftMargin)

        return tv
    }

    private fun applyConstraintSet(parentView: ConstraintLayout, prevView: View, appliedView: TextView, leftMargin: Int) {
        val set = ConstraintSet()
        set.clone(parentView)

        set.connect(appliedView.id, ConstraintSet.BOTTOM, prevView.id, ConstraintSet.BOTTOM)

        set.connect(appliedView.id, ConstraintSet.START, prevView.id, ConstraintSet.END, leftMargin)

        set.applyTo(parentView)
    }

    /**
     * -----------------------
     */

    fun displayCollections(parentView: LinearLayout, leftView: View, collections: ArrayList<MMTinyCategory>?, collectionCountMax: Int,
                           extraCollectionTextViews: ArrayList<TextView>?): ArrayList<TextView>? {

        extraCollectionTextViews?.also { list ->
            while (list.size > 0) {
                parentView.removeView(list.get(0))
                list.removeAt(0)
            }
        }

        if (collections == null || collections.size == 0) {
            return extraCollectionTextViews
        }

        var newListViews = extraCollectionTextViews
        if (newListViews == null) newListViews = ArrayList()

        if (MARGIN == 0) MARGIN = parentView.resources.getDimensionPixelSize(R.dimen.margin)

        var prevTv = leftView

        val lastIndex = Math.min(collections.size - 1, collectionCountMax)

        for (i: Int in 0..lastIndex) {
            val content = if (i < collectionCountMax) collections.get(i).name
                    ?: "" else Constant.DOUBLE_DOTS
            val colorStr = collections.get(i).getColor()

            prevTv = addExtraSmallView(parentView, leftView, content, colorStr, MARGIN)
            newListViews.add(prevTv)
        }

        return newListViews
    }

    private fun addExtraSmallView(parentView: LinearLayout, leftView: View, name: String, colorStr: String?, leftMargin: Int): TextView {
        val tv = TextView(parentView.context)
        if (mTvCollectionHeight == 0) mTvCollectionHeight = parentView.resources.getDimensionPixelSize(R.dimen.vh_now_playing_title_collection_height)

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