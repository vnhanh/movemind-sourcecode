package player.wellnesssolutions.com.ui.fragment_search_instructors

import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchDataHelper
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.datasource.instructor.InstructorApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor

class SearchInstructorsPresenter() : BaseResponseObserver<ArrayList<MMInstructor>>(), ISearchInstructorContract.Presenter {
    private var mView: ISearchInstructorContract.View? = null
    private var instructorRepository = InstructorApi()
    private var mBrand: MMBrand? = null
    private var mData: ArrayList<MMInstructor>? = null
    private var mIsRendered = false
    private var mIsProcessing = false

    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onAttach(view: ISearchInstructorContract.View) {
        this.mView = view

        loadData(view)
    }

    override fun loadData(view: ISearchInstructorContract.View) {
        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(SharedPreferencesCustomized.getInstance(context), view.getFragment())

            if (mData != null) {
                displayUI()
            } else if (!mIsRendered && headerData != null) {
                view.showLoadingProgress()
                loadInstructors(headerData.token, headerData.deviceId)
            }
        }
    }

    override fun onReshowUI(view: ISearchInstructorContract.View) {
        this.mView = view
        displayUI()
    }

    private fun displayUI() {
        if (mIsRendered) return
        mData?.also { data ->
            val brandName = (mBrand?.name ?: "").toUpperCase()
            mView?.showUI(brandName, data)
            mIsRendered = true
        }
    }

    private fun loadInstructors(token: String, deviceId: String) {
        mIsRendered = false
        mIsProcessing = true
        mView?.showLoadingProgress()
        mBrand?.id?.also { brandId ->
            this.instructorRepository.getInstructors(token, deviceId, brandId).subscribe(this)
        }
    }

    override fun onClickInstructorItem(item: MMInstructor) {
        mBrand?.also { brand ->
            mView?.onOpenNextScreen(brand, item)
        }
    }

    override fun onClickShowInfoInstructor(item: MMInstructor) {
        mView?.showInstructorInfo(item)
    }

    /**
     * Response for Retrofit
     */

    override fun onRequestError(message: String?) {
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
    }

    override fun onResponseSuccess(data: ResponseValue<java.util.ArrayList<MMInstructor>>?) {
        val loadedData = data?.data
        if (loadedData == null || loadedData.size == 0) {
            return
        }

        SearchDataHelper.convertToUpperCase(loadedData)
        SearchDataHelper.sortInstructors(loadedData)

        mData = loadedData
        displayUI()
    }

    /**
     * end response of Retrofit
     */

    override fun onClickedShowVideosByInstructor(instructor: MMInstructor) {
        mView?.onOpenSearchResultScreen(instructor)
    }

    override fun onComplete() {
        super.onComplete()
        mView?.hideLoadingProgress()
        mIsProcessing = false
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
}