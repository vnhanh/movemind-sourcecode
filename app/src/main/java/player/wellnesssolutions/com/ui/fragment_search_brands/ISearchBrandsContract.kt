package player.wellnesssolutions.com.ui.fragment_search_brands

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler

interface ISearchBrandsContract {
    interface View : ILoadBrandHandler.Callback {
        fun showUI(data: ArrayList<MMBrand>)
        fun onOpenNextScreen(data: MMBrand, nextScreenTag: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun inputData(nextScreenTag: String, brands: ArrayList<MMBrand>)
        fun changeSearchedFlow(view: View, searchedFlowTag: String)

        fun onChooseItem(data: MMBrand)

        fun getSearchedFlowTag(): String
    }
}