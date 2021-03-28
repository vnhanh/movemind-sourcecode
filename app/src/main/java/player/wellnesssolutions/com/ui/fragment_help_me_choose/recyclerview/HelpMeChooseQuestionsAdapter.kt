package player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract

class HelpMeChooseQuestionsAdapter(answers: ArrayList<MMHelpMeChooseAnswer>, clickedListener: IHelpMeChooseContract.Presenter?) :
        BaseClickableAdapter<HelpMeChooseQuestionVH, IHelpMeChooseContract.Presenter, MMHelpMeChooseAnswer>(clickedListener, answers) {
    private var padding = 0

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): HelpMeChooseQuestionVH {
        if (padding == 0) {
            padding = parent.resources.getDimensionPixelSize(R.dimen.screen_hmc_item_answer_padding)
        }
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_selectable_option_text, parent, false)

        return HelpMeChooseQuestionVH(view, listener)
    }

    override fun onBindViewHolder(holder: HelpMeChooseQuestionVH, position: Int) {
        setPadding(holder, position, padding)
        val isSelected =
                when (position >= 0 && position < list.size && listener != null) {
                    true -> listener?.isItemSelected(list[position]) ?: false
                    false -> false
                }

        holder.bind(list.get(position), isSelected)
    }

    private fun setPadding(holder: HelpMeChooseQuestionVH, position: Int, padding: Int) {
        when (position) {
            0 -> holder.itemView.setPadding(0, 0, padding, 0)
            else -> holder.itemView.setPadding(padding, 0, padding, 0)
        }
    }

    override fun getItemViewType(position: Int): Int =
            when (position) {
                0 -> ITEM_LEFT_EDGE
                list.size - 1 -> ITEM_RIGHT_EDGE
                else -> ITEM_MIDDLE
            }

    val ITEM_LEFT_EDGE = 0
    val ITEM_MIDDLE = 1
    val ITEM_RIGHT_EDGE = 2
}