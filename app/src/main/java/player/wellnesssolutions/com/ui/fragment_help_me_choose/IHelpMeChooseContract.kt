package player.wellnesssolutions.com.ui.fragment_help_me_choose

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion
import player.wellnesssolutions.com.network.models.screen_search.MMBrand

interface IHelpMeChooseContract {
    interface View : ILifeCycle.View, IProgressView {
        fun showTextByRemote(configData: MMConfigData)
        fun showLoadedData(loadedData: ArrayList<MMHelpMeChooseQuestion>, hmcText: String?)
        fun openScreenSearchResult(brandId: Int, answers: ArrayList<MMHelpMeChooseAnswer>)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun selectAnswer(data: MMHelpMeChooseAnswer)
        fun clickedButtonHelpMeChoose()
        fun onReshowUI(view: View)
        fun isItemSelected(item: MMHelpMeChooseAnswer): Boolean
        fun loadData(view: View)
    }
}