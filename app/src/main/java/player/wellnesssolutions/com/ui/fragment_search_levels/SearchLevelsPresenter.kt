package player.wellnesssolutions.com.ui.fragment_search_levels

import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.datasource.level.LevelApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMLevel

class SearchLevelsPresenter : BaseResponseObserver<ArrayList<MMLevel>>(), ISearchLevelsContract.Presenter {
    // vars
    private var mView: ISearchLevelsContract.View? = null
    private var mLevelApi: LevelApi = LevelApi()
    private lateinit var mBrand: MMBrand
    private var mIsProcessing = false
    private var mIsRendered = false
    private var mData: ArrayList<MMLevel>? = null

    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onChooseItem(data: MMLevel) {
        mView?.onOpenNextScreen(mBrand, data)
    }

    override fun onAttach(view: ISearchLevelsContract.View) {
        this.mView = view
        loadData(view)
    }

    override fun loadData(view: ISearchLevelsContract.View) {
        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())

            if (headerData != null) {
                if (mData == null) {
                    val brandId: Int? = mBrand.id
                    if (brandId == null) {
                        view.getViewContext()?.also { context ->
                            val message = context.getString(R.string.no_brand_id)
                            DialogUtil.createDialogOnlyOneButton(context = context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null, buttonColor = R.color.red).show()
                        }
                        return
                    } else {
                        loadLevels(headerData.token, headerData.deviceId, brandId)
                    }
                } else {
                    displayUI()
                }
            }
        }
    }

    override fun onReshowUI(view: ISearchLevelsContract.View) {
        this.mView = view
        displayUI()
    }

    private fun loadLevels(token: String, deviceId: String, brandId: Int) {
        mIsRendered = false
        mIsProcessing = true
        mView?.showLoadingProgress()
        this.mLevelApi.getLevels(token, deviceId, brandId).subscribe(this)
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onStop() {
        mIsRendered = false
    }

    override fun onDestroy() {
        mData?.clear()
        mData = null
        mCompoDisposable.dispose()
    }

    /**
     * response Retrofit
     */
    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onShowRequestApiFailed(message)
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        onShowRequestApiFailed(message)
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMLevel>>?) {
        if (data?.data.isNullOrEmpty()) {
            return
        }

        mData = data?.data
        displayUI()
    }

    private fun onShowRequestApiFailed(message: String?) {
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED

        mView?.also { view ->
            view.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                    ?: MSG_REQUEST_FAILED)
            view.hideLoadingProgress()
        }
    }

    private fun displayUI() {
        if (mIsRendered) return
        mData?.also { data ->
            mView?.also { view ->
                view.showLoadedData(data, mBrand.name ?: "")
                view.hideLoadingProgress()
                mIsRendered = true
            }
        }
    }

    override fun onComplete() {
        super.onComplete()
        mIsProcessing = false
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment)
                it.onExpiredUnAuth(error)
        }
    }

    /**
     * -------------------------
     */
}