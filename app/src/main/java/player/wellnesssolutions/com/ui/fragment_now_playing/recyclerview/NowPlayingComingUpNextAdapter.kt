package player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener

class NowPlayingComingUpNextAdapter(val list: MutableList<MMVideo>, var presenter: IComingUpNextClickListener?, val isPresentation: Boolean = false) :
        androidx.recyclerview.widget.RecyclerView.Adapter<NowPlayingComingUpNextVH>() {
    private var mHolders: ArrayList<NowPlayingComingUpNextVH>? = ArrayList()
    private var margin = 0

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): NowPlayingComingUpNextVH {
        if (margin == 0) {
            margin = parent.resources.getDimensionPixelSize(R.dimen.margin)
        }

        val vh = NowPlayingComingUpNextVH(
                view = LayoutInflater.from(parent.context).inflate(R.layout.vh_now_playing, parent, false),
                presenter = presenter,
                isPresentation = isPresentation
        )
        mHolders?.add(vh)
        return vh
    }

    override fun onBindViewHolder(holder: NowPlayingComingUpNextVH, position: Int) {
        setDimenLayoutForItemView(holder.itemView, position)

        holder.bind(list[position], position)
    }

    private fun setDimenLayoutForItemView(itemView: View, position: Int) {
        if (position == 0) {
            itemView.setPadding(0, 0, margin, 0)
        } else {
            itemView.setPadding(margin, 0, margin, 0)
        }
    }

    override fun getItemCount(): Int = list.size

    fun release() {
        mHolders?.also { holders ->
            while (holders.size > 0) {
                holders[0].release()
                holders.removeAt(0)
            }
        }
        mHolders = null
        list.clear()
        presenter = null
    }
}