package player.wellnesssolutions.com.ui.fragment_no_class

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler

interface INoClassContract {
    interface View : ILoadBrandHandler.Callback, IProgressView, IShowMessageView {
        fun showUI(data: MMConfigData)

    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun loadBrands(flowTag: String)

    }
}