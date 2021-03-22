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
import java.lang.ref.WeakReference

class SearchVideosByAdapter(presenter: ISearchVideosByContract.Presenter?, var list: ArrayList<SearchByOption>) : RecyclerView.Adapter<SearchVideosByVH>() {
    private var weakPresenter: WeakReference<ISearchVideosByContract.Presenter?> = WeakReference(presenter)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchVideosByVH {
        val vh: SearchVideosByVH

        vh = when (viewType) {
            TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_videos_by_image, parent, false)
                SearchVideosByImageVH(view)
            }

            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_search_videos_by_text, parent, false)
                SearchVideosByTextVH(view)
            }
        }

        vh.itemView.setOnClickListener {
            vh.data?.also { data ->
                it.isEnabled = false
                when (viewType) {
                    TYPE_IMAGE -> {
                        vh.itemView.imgSVBItem.changeBgColorOnClick()
                        SearchCollectionUtil.isCollectionChoose = data.title == "Collection"
                    }

                    else -> {
                        vh.itemView.tvWrapperCircleItem.changeBgColorOnClick()
                    }
                }
                weakPresenter.get()?.onChooseItem(data)

                it.isEnabled = true
            }
        }

        return vh
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
        weakPresenter.clear()
    }
}