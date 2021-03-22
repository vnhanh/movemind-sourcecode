package player.wellnesssolutions.com.ui.fragment_search_brands

import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import player.wellnesssolutions.com.ui.fragment_search_brands.module.LoadBrandsHandler
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment

class SearchBrandsPresenter() : ISearchBrandsContract.Presenter {
    private var mView: ISearchBrandsContract.View? = null
    private var mLoadBrandsHandler: ILoadBrandHandler? = null

    private var mBrands: ArrayList<MMBrand>? = null
    private var mSearchedFlowTag: String = SearchBrandsFragment.TAG
    private var mBrandsHasLevel = ArrayList<MMBrand>()
    private var mIsRendered = false

    override fun getSearchedFlowTag(): String = mSearchedFlowTag

    override fun inputData(nextScreenTag: String, brands: ArrayList<MMBrand>) {
        this.mSearchedFlowTag = nextScreenTag
        this.mBrands = brands

        scanBrandHasNoLevel(brands)
    }

    override fun changeSearchedFlow(view: ISearchBrandsContract.View, searchedFlowTag: String) {
        if (mLoadBrandsHandler == null) mLoadBrandsHandler = LoadBrandsHandler(view)
        this.mSearchedFlowTag = searchedFlowTag
        mLoadBrandsHandler?.loadBrands(searchedFlowTag)
    }

    private fun displayUI() {
        if (mIsRendered) return
        if (mSearchedFlowTag == SearchLevelsFragment.TAG) {
            hideLevelBrandItem()
        } else {
            displayAllBrands()
        }
        mIsRendered = true
    }

    private fun displayAllBrands() {
        mView?.also { view ->
            val loadedData: ArrayList<MMBrand> = mBrands ?: return
            view.showUI(loadedData)
        }
    }

    private fun hideLevelBrandItem() {
        mView?.also { view ->
            if (mBrandsHasLevel.size == 0) return

            view.showUI(mBrandsHasLevel)
        }
    }

    override fun onChooseItem(data: MMBrand) {
        val nextScreenTag: String =
                when (mSearchedFlowTag == SearchBrandsFragment.TAG) {
                    true -> SearchVideosByFragment.TAG
                    false -> mSearchedFlowTag
                }

        mView?.onOpenNextScreen(data, nextScreenTag)
    }

    override fun onAttach(view: ISearchBrandsContract.View) {
        this.mView = view

        displayUI()
    }

    private fun scanBrandHasNoLevel(loadedData: ArrayList<MMBrand>) {
        for (brand: MMBrand in loadedData) {
            if (brand.hasLevel == 1) {
                mBrandsHasLevel.add(brand)
            }
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onStop() {
        mIsRendered = false
    }

    override fun onDestroy() {
        mBrandsHasLevel.clear()
        mBrands?.clear()
        mBrands = null
    }
}