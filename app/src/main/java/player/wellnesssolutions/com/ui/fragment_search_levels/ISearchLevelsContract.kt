package player.wellnesssolutions.com.ui.fragment_search_levels

import player.wellnesssolutions.com.base.uis.ILifeCycle
import player.wellnesssolutions.com.base.uis.IProgressView
import player.wellnesssolutions.com.base.uis.IShowMessageView
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMLevel

interface ISearchLevelsContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun onOpenNextScreen(brand: MMBrand, level: MMLevel)
        fun showLoadedData(data: ArrayList<MMLevel>, brandName: String)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun onChooseItem(data: MMLevel)
        fun onReshowUI(view: View)
        fun loadData(view: View)
    }
}