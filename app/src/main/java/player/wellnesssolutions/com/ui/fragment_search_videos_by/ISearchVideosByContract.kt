package player.wellnesssolutions.com.ui.fragment_search_videos_by

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption

interface ISearchVideosByContract {
    interface View : ILifeCycle.View {
        fun onOpenNextScreen(brand: MMBrand, searchByOption: SearchByOption)
        fun showUI(data: ArrayList<SearchByOption>)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun onChooseItem(data: SearchByOption)
        fun onReshowUI(view: View)
    }
}