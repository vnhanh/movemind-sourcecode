package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_sp_collection.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract

class SPCollectionAdapter(list: ArrayList<MMCollection>, presenter: ISearchPreviewContract.Presenter?) :
        BaseClickableAdapter<SPCollectionVH, ISearchPreviewContract.Presenter, MMCollection>(presenter, list) {
    private var nameTextSize = 0f
    private var padding = 0

    init {
        presenter?.addAdapter(this)
    }

    fun setTextSize(view: View, presenter: ISearchPreviewContract.Presenter?) {
        if (nameTextSize == 0f) {
            nameTextSize =
                    when (presenter?.isHaveCollectionsAndInstructors() ?: true) {
                        true -> {
                            view.resources.getDimensionPixelSize(R.dimen.screen_search_preview_rv_item_name_text_size_small).toFloat()
                        }

                        false -> {
                            view.resources.getDimensionPixelSize(R.dimen.screen_search_preview_rv_item_name_text_size_large).toFloat()
                        }
                    }
        }

        view.tvCollectionName.setTextSize(TypedValue.COMPLEX_UNIT_PX, nameTextSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): SPCollectionVH {
        if (padding == 0) {
            padding = parent.resources.getDimensionPixelSize(R.dimen.vh_sp_collection_padding)
        }

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.vh_sp_collection, parent, false)
        val vh = SPCollectionVH(view)

        setTextSize(view, listener)

        ViewUtil.setupOnClicked(vh.itemView, object : View.OnClickListener {
            override fun onClick(p0: View?) {
                onClickedItem(vh)
            }
        })

        return vh
    }

    private fun onClickedItem(vh: SPCollectionVH) {
        vh.data?.also { data ->
            val isSelected = !(listener?.isItemSelected(data.id, Constant.SEARCH_COLLECTION)
                    ?: false)

            vh.select(isSelected)

            listener?.onChooseOptionItem(data.id, data.name, Constant.SEARCH_COLLECTION)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SPCollectionVH, position: Int) {
        setPadding(holder, position, padding)
        val item: MMCollection = list[position]
        val isSelected: Boolean = listener?.isItemSelected(item.id, Constant.SEARCH_COLLECTION)
                ?: false
        holder.bind(list[position], isSelected)
    }

    private fun setPadding(vh: SPCollectionVH, position: Int, padding: Int) {
        when (position) {
            0 -> {
                vh.itemView.setPadding(0, 0, padding, 0)
            }

            else -> {
                vh.itemView.setPadding(padding, 0, padding, 0)
            }
        }
    }
}