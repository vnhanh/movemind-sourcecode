package player.wellnesssolutions.com.ui.fragment_search_durations

import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchDataHelper
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.datasource.duration.DurationApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import java.util.*

class SearchDurationPresenter : BaseResponseObserver<ArrayList<MMDuration>>(), ISearchDurationContract.Presenter {
    // vars
    private var mView: ISearchDurationContract.View? = null
    private var mDurationApi: DurationApi = DurationApi()
    private lateinit var mBrand: MMBrand
    private var mIsProcessing = false
    private var mData: ArrayList<MMDuration>? = null
    private var mIsRendered = false

    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onChooseItem(data: MMDuration) {
        mView?.onOpenNextScreen(mBrand, data)
    }

    override fun onAttach(view: ISearchDurationContract.View) {
        this.mView = view

        loadData(view)
    }

    override fun loadData(view: ISearchDurationContract.View) {
        view.getViewContext()?.also {
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(it), view.getFragment())

            if (mIsProcessing || headerData == null) return

            if (mData != null)
                displayUI()
            else {
                val brandId: Int? = mBrand.id
                if (brandId == null) {
                    view.getViewContext()?.also { context ->
                        val message = context.getString(R.string.no_brand_id)
                        DialogUtil.createDialogOnlyOneButton(context = context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null, buttonColor = R.color.red).show()
                    }
                    return
                }
                loadDurations(headerData.token, headerData.deviceId, brandId)
            }
        }
    }

    override fun onReShowUI(view: ISearchDurationContract.View) {
        this.mView = view
        displayUI()
    }

    private fun displayUI() {
        if (mIsRendered) return

        mData?.also { data ->
            val brandName = mBrand.name ?: "".toUpperCase()
            mView?.showUI(brandName, data)
            mIsRendered = true
        }
    }

    private fun loadDurations(token: String, deviceId: String, brandId: Int) {
        mIsRendered = false
        mIsProcessing = true
        mView?.showLoadingProgress()
        this.mDurationApi.getDurationsByBrandId(token, deviceId, brandId).subscribe(this)
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
     * Response for Retrofit
     */

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMDuration>>?) {
        if (data?.data == null) {
            return
        }
        SearchDataHelper.sortDurations(data.data)
        mData = data.data
        displayUI()
    }


    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onRequestFailed(message)
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        onRequestFailed(message)
    }

    private fun onRequestFailed(message: String?) {
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?:Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
        mIsProcessing = false
    }

    override fun onComplete() {
        super.onComplete()
        mIsProcessing = false
        mView?.hideLoadingProgress()
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