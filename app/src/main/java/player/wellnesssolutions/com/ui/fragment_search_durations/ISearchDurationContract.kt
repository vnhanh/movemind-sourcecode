package player.wellnesssolutions.com.ui.fragment_search_durations

import player.wellnesssolutions.com.base.uis.ILifeCycle
import player.wellnesssolutions.com.base.uis.IProgressView
import player.wellnesssolutions.com.base.uis.IShowMessageView
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMDuration

interface ISearchDurationContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun onOpenNextScreen(brand: MMBrand, duration: MMDuration)
        fun showUI(brandName: String, data: ArrayList<MMDuration>)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun onChooseItem(data: MMDuration)
        fun onReShowUI(view: View)
        fun loadData(view: View)
    }
}