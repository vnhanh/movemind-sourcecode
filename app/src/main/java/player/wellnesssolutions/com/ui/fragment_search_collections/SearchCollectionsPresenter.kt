package player.wellnesssolutions.com.ui.fragment_search_collections

import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchDataHelper
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.collection.CollectionApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMCollection

class SearchCollectionsPresenter : BaseResponseObserver<ArrayList<MMCollection>>(), ISearchCollectionContract.Presenter {
    // vars
    private var mView: ISearchCollectionContract.View? = null
    private var mCollectionApi: CollectionApi = CollectionApi()
    private var mBrand: MMBrand? = null
    private var mIsLoading = false
    private var mIsRendered = false
    private var mData: ArrayList<MMCollection>? = null

    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onChooseItem(data: MMCollection) {
        if (mBrand != null) {
            mView?.onOpenNextScreen(mBrand!!, data)
        }
    }

    override fun onAttach(view: ISearchCollectionContract.View) {
        this.mView = view

        loadData(view)
    }

    override fun loadData(view: ISearchCollectionContract.View) {
        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())

            if (headerData == null || mIsLoading) return

            if (mData != null) displayUI() else loadApi(headerData.token, headerData.deviceId)
        }
    }

    private fun loadApi(token: String, deviceId: String) {
        mIsRendered = false
        mIsLoading = true
        mView?.showLoadingProgress()
        this.mCollectionApi.getCollections(token, deviceId).subscribe(this)
    }

    override fun onReshowUI(view: ISearchCollectionContract.View) {
        this.mView = view
        displayUI()
    }

    private fun displayUI() {
        if (mIsRendered) return
        mData?.also { data ->
            val brandName = (mBrand?.name ?: "").toUpperCase()
            showDisplayItems(mView, brandName, data)
            mIsRendered = true
        }
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMCollection>>?) {
        var loadedData: java.util.ArrayList<MMCollection>? = data?.data ?: return

        loadedData = loadedData?.let { removeChildCollections(it) }

        SearchDataHelper.sortCollections(loadedData)

        mData = loadedData?.let { getDisplayItems(it) }

        displayUI()
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        onShowRequestApiFailed(message)
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onShowRequestApiFailed(message)
    }

    private fun onShowRequestApiFailed(message: String?) {
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
        mIsLoading = false
    }

    private fun removeChildCollections(collections: ArrayList<MMCollection>): ArrayList<MMCollection> {
        var index = 0

        while (index < collections.size) {
            val collection: MMCollection = collections.get(index)
            if (collection.parentId != null) {
                collections.removeAt(index)
                index--
            }
            index++
        }

        return collections
    }

    private fun showDisplayItems(view: ISearchCollectionContract.View?, brandName: String, displayItems: ArrayList<MMCollection>) {
        view?.showUI(brandName, displayItems)
    }

    private fun getDisplayItems(items: java.util.ArrayList<MMCollection>): ArrayList<MMCollection> {
        val list = ArrayList<MMCollection>()
        val brandId: Int? = mBrand?.id
        for (item: MMCollection in items) {
            if (brandId == item.brandId && item.parentId == null) {
                list.add(item)
            }
        }
        return list
    }

    override fun onComplete() {
        super.onComplete()
        mIsLoading = false
        mView?.hideLoadingProgress()
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onStop() {
        mIsRendered = false
    }

    override fun onDestroy() {
        mCompoDisposable.dispose()
        mData?.clear()
        mData = null
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpired(error)
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpiredUnAuth(error)
        }
    }

    /**
     * ------------------------
     */
}