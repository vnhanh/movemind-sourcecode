package player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview

import android.view.View
import kotlinx.android.synthetic.main.viewholder_selectable_option_text.view.*
import player.wellnesssolutions.com.base.view.BaseVH
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract
import java.lang.ref.WeakReference

class HelpMeChooseQuestionVH(view: View, clickedPresenter: IHelpMeChooseContract.Presenter?) :
        BaseVH<MMHelpMeChooseAnswer>(view), View.OnClickListener {
    private var weakPresenter = WeakReference(clickedPresenter)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        data?.also { data ->
            val isSelected = !(weakPresenter.get()?.isItemSelected(data) ?: false)
            displayView(isSelected)
            weakPresenter.get()?.selectAnswer(data)
        }
    }

    private fun displayView(isSelected: Boolean) {
        if (isSelected) {
            selectView()
        } else {
            unSelectView()
        }
    }

    private fun selectView() {
        itemView.tvOptionTitle.setSelect(true)
    }

    private fun unSelectView() {
        itemView.tvOptionTitle.setSelect(false)
    }

    fun bind(data: MMHelpMeChooseAnswer, isSelected: Boolean) {
        this.data = data

        displayView(isSelected)
        itemView.tvOptionTitle.text = data.answer
    }
}