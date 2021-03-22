package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView


class SearchResultPageRecyclerView : RecyclerView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var mCustomAdapter: VideosSearchResultPageAdapter? = null
    private var rowCount = 1

    fun setVideosSearchResultPageAdapter(adapter: VideosSearchResultPageAdapter) {
        this.mCustomAdapter = adapter

        if (width == 0 || height == 0) return
        setupLayoutForCustomAdapter(adapter, width, height)
    }

    fun setRowCount(rowCount: Int) {
        this.rowCount = rowCount
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        post {
            applyDimensionForCustomAdapter()
        }
    }

    private fun applyDimensionForCustomAdapter() {
        val mAdapter = mCustomAdapter ?: return

        setupLayoutForCustomAdapter(mAdapter, width, height)
    }

    private fun setupLayoutForCustomAdapter(adapter: VideosSearchResultPageAdapter, width: Int, height: Int) {
        adapter.setItemDimens(width = width / 4, height = height / rowCount) // 4 video in a row

        setAdapter(adapter)
    }

    fun release() {
        mCustomAdapter?.release()
        mCustomAdapter = null
        this.adapter = null
    }
}