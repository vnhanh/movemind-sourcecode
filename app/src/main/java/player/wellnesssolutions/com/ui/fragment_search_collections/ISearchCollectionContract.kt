package player.wellnesssolutions.com.ui.fragment_search_collections

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMCollection

interface ISearchCollectionContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun onOpenNextScreen(brand: MMBrand, collection: MMCollection)
        fun showUI(brandName: String, data: ArrayList<MMCollection>)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun onChooseItem(data: MMCollection)
        fun onReshowUI(view: View)
        fun loadData(view: View)
    }
}