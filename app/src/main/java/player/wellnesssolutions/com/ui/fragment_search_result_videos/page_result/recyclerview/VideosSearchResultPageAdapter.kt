package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract

class VideosSearchResultPageAdapter(val list: ArrayList<MMVideo>, private var listener: ISearchResultPageContract.Presenter?) :
        RecyclerView.Adapter<VideosSearchResultPageVH>() {
    private var mHolders: ArrayList<VideosSearchResultPageVH>? = ArrayList()
    private var mItemWidth = 0
    private var mItemHeight = 0

    fun setItemDimens(width: Int, height: Int) {
        this.mItemWidth = width
        this.mItemHeight = height
    }

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): VideosSearchResultPageVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_result, parent, false)
        setupLayoutForVHItem(view)
        val viewholder = VideosSearchResultPageVH(view, mItemWidth, mItemHeight, listener)
        mHolders?.add(viewholder)
        return viewholder
    }

    private fun setupLayoutForVHItem(view: View) {
        val params = view.layoutParams as GridLayoutManager.LayoutParams
        params.width = mItemWidth
        params.height = mItemHeight
        view.layoutParams = params
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(vh: VideosSearchResultPageVH, position: Int) {
        val brand = list[position]
        vh.bind(brand)
    }

    fun release() {
        listener = null
        mHolders?.also { holders ->
            while (holders.size > 0) {
                holders[0].release()
                holders.removeAt(0)
            }
        }
        mHolders = null
    }

    override fun getItemViewType(position: Int): Int {
        if (position % COL_COUNT == 0) {
            return TYPE_ITEM_LEFT_EDGE
        } else if ((position + 1) % COL_COUNT == 0) {
            return TYPE_ITEM_RIGHT_EDGE
        }
        return TYPE_ITEM_MIDDLE
    }

    fun selectAllVideos() {
        mHolders?.also { holders ->
            for (holder: VideosSearchResultPageVH in holders) {
                holder.toggleSelectVideo()
            }
        }
    }

    fun unselectAllVideos() {
        mHolders?.also { holders ->
            for (holder: VideosSearchResultPageVH in holders) {
                holder.toggleSelectVideo()
            }
        }
    }

    companion object {
        val ROW_COUNT = 3
        val COL_COUNT = 4

        val TYPE_ITEM_LEFT_EDGE = 0
        val TYPE_ITEM_MIDDLE = 1
        val TYPE_ITEM_RIGHT_EDGE = 2
    }
}