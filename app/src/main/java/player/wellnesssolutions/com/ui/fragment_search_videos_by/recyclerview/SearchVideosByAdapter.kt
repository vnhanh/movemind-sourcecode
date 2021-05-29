package player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.vh_search_videos_by_image.view.*
import kotlinx.android.synthetic.main.vh_search_videos_by_text.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract

class SearchVideosByAdapter(
    private var presenter: ISearchVideosByContract.Presenter?,
    var list: ArrayList<SearchByOption>
) : RecyclerView.Adapter<SearchVideosByVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchVideosByVH {
        val viewholder: SearchVideosByVH

        viewholder = when (viewType) {
            TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_videos_by_image, parent, false)
                SearchVideosByImageVH(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_videos_by_text, parent, false)
                SearchVideosByTextVH(view)
            }
        }

        viewholder.itemView.setOnClickListener {
            viewholder.data?.also { data ->
                it.isEnabled = false
                when (viewType) {
                    TYPE_IMAGE -> {
                        viewholder.itemView.imgSVBItem?.changeBgColorOnClick()
                        SearchCollectionUtil.isCollectionChoose = data.title == "Collection"
                    }

                    else -> {
                        viewholder.itemView.tvWrapperCircleItem?.changeBgColorOnClick()
                    }
                }
                presenter?.onChooseItem(data)

                it.isEnabled = true
            }
        }

        return viewholder
    }

    override fun onBindViewHolder(holder: SearchVideosByVH, position: Int) {
        if (holder is SearchVideosByTextVH)
            holder.bind(list.get(position))
        else if (holder is SearchVideosByImageVH)
            holder.bind(list[position])
    }

    private val TYPE_IMAGE = 10
    private val TYPE_TEXT = 11

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int =
            when (position) {
                in 0..3 -> TYPE_IMAGE
                else -> TYPE_TEXT
            }

    fun release() {
        presenter = null
    }
}