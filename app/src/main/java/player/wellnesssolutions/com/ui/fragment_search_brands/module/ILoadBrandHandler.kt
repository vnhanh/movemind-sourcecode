package player.wellnesssolutions.com.ui.fragment_search_brands.module

import player.wellnesssolutions.com.base.uis.ILifeCycle
import player.wellnesssolutions.com.network.models.screen_search.MMBrand

interface ILoadBrandHandler {
    interface Callback : ILifeCycle.View {
        fun onLoadingBrands() {}
        fun onEndLoadingBrands() {}
        fun onGetBrands(brands: ArrayList<MMBrand>, searchBrandFlowTag: String) {}
        fun onGetOnlyOneBrand(brand: MMBrand, nextScreenTag: String) {}
        fun onLoadBrandsFailed(message: String) {}
    }

    fun loadBrands(tag: String)
    fun release()
}