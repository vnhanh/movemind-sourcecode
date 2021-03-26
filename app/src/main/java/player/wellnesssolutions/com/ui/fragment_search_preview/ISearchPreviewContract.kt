package player.wellnesssolutions.com.ui.fragment_search_preview

import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption

interface ISearchPreviewContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun showUI(showUIData: SPShowedUIData)
        fun openSearchResultScreen(selectedOptions: SPSearchedOption)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setPassedData(brand: MMBrand, searchByData: SearchedOption)
        fun onChooseOptionItem(id: Int?, name: String?, typeId: Int?)
        fun requestResultVideos(isUseOptions: Boolean)
        fun isHaveCollectionsAndInstructors(): Boolean
        fun onReshowUI(view: View)
        fun addAdapter(adapter: BaseClickableAdapter<*, *, *>)
        fun isItemSelected(id: Int?, typeId: Int?): Boolean
        fun loadData(view: View)
        fun getDataForSearch(): SPSearchedOption?
        fun getItemSearchOption() : SearchedOption?
        fun getDataForShow() : SPShowedUIData?
        fun setData(dataShowUI: SPShowedUIData?, dataInputForSearch: SPSearchedOption)
    }
}