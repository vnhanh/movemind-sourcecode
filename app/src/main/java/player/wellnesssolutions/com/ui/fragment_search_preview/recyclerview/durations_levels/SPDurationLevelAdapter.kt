package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract

class SPDurationLevelAdapter(list: ArrayList<SearchedOption>, presenter: ISearchPreviewContract.Presenter?) :
        BaseClickableAdapter<OptionSearchPreviewVH, ISearchPreviewContract.Presenter, SearchedOption>(presenter, list) {
    private var padding = 0

    init {
        presenter?.addAdapter(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, typeItem: Int): OptionSearchPreviewVH {
        if (padding == 0) {
            padding = parent.resources.getDimensionPixelSize(R.dimen.screen_hmc_item_answer_margin)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_selectable_option_text, parent, false)
        val vh = OptionSearchPreviewVH(view)

        vh.itemView.setOnClickListener {
            vh.data?.also { data ->
                val isSelected = !(weakPresenter.get()?.isItemSelected(data.id, data.typeOptionId)
                        ?: false)

                vh.select(isSelected)

                presenter?.onChooseOptionItem(data.id, data.name, data.typeOptionId)
            }
        }

        return vh
    }

    override fun onBindViewHolder(holder: OptionSearchPreviewVH, position: Int) {
        setPaddingItemView(holder.itemView, position)

        val item = list[position]
        val isSelected = weakPresenter.get()?.isItemSelected(item.id, item.typeOptionId) ?: false

        holder.bind(list[position], isSelected)
    }

    private fun setPaddingItemView(itemView: View, position: Int) {
        when (position) {
            0 -> {
                itemView.setPadding(0, 0, padding, 0)
            }

            else -> {
                itemView.setPadding(padding, 0, padding, 0)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}