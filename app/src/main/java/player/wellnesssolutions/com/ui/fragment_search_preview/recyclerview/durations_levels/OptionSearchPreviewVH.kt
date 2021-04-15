package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels

import android.view.View
import kotlinx.android.synthetic.main.viewholder_selectable_option_text.view.*
import player.wellnesssolutions.com.base.view.BaseVH

class OptionSearchPreviewVH(view: View) : BaseVH<SearchedOption>(view) {

    fun bind(value: SearchedOption, isSelected: Boolean = false) {
        super.bind(value)

        itemView.tvOptionTitle?.text = value.name
        select(isSelected)
    }

    fun select(selected: Boolean) {
        itemView.tvOptionTitle?.setSelect(selected)
    }
}