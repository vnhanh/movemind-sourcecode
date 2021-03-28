package player.wellnesssolutions.com.ui.fragment_search_preview

import android.util.Log
import io.reactivex.Observable
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchDataHelper
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.search_preview.SearchPreviewApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.search_preview.MMSearchPreviewResponse
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SearchPreviewMapper
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion.mVideosToPlay
import retrofit2.Response

class SearchPreviewPresenter : BaseResponseObserver<MMSearchPreviewResponse>(), ISearchPreviewContract.Presenter {
    private var mView: ISearchPreviewContract.View? = null
    private var mSPreviewRespo: SearchPreviewApi = SearchPreviewApi()
    private var mAdapters: ArrayList<BaseClickableAdapter<*, *, *>>? = ArrayList()

    // input data
    private var mChosenOptions: SPSearchedOption? = null

    // loaded data
    private var mData: SPSearchedOption? = null
    private var mDisplayData: SPShowedUIData? = null
    private var mIsProcessing = false
    private var mIsRendered = false

    override fun setPassedData(brand: MMBrand, searchByData: SearchedOption) {
        mChosenOptions = SPSearchedOption().also {
            it.brand = brand
            it.searchByData = searchByData
        }
    }

    override fun onAttach(view: ISearchPreviewContract.View) {
        this.mView = view
        when {
            mDisplayData != null && mChosenOptions != null -> {
                Log.d("LOG", this.javaClass.simpleName + " onAttach() | display right now")
                displayUI()
            }
            else -> loadData(view)
        }

    }

    override fun loadData(view: ISearchPreviewContract.View) {
        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())

            if (mData != null) {
                displayUI()
            } else if (!mIsProcessing && headerData != null) {
                view.showLoadingProgress()

                loadData(headerData.token, headerData.deviceId)
            }
        }
    }

    override fun onReshowUI(view: ISearchPreviewContract.View) {
        this.mView = view
        displayUI()
    }

    private fun displayUI() {
        if (mIsRendered) return
        mDisplayData?.also { data ->
            mView?.showUI(data)
            mIsRendered = true
        }
    }

    private fun loadData(token: String, deviceId: String) {
        mIsProcessing = true
        mIsRendered = false

        val brandId: Int? = mChosenOptions?.brand?.id
        val searchByData: SearchedOption? = mChosenOptions?.searchByData
        val searchById: Int? = searchByData?.id
        val chosenTypeOptionId: Int? = searchByData?.typeOptionId

        when {
            brandId == null || searchById == null || chosenTypeOptionId == null -> mView?.showMessage(R.string.error_request_data_is_empty, R.color.red)
            else -> {
                val observable: Observable<Response<ResponseValue<MMSearchPreviewResponse>>> = when (chosenTypeOptionId) {
                    Constant.SEARCH_COLLECTION -> mSPreviewRespo.getSearchPreviewDataByCollection(token, deviceId, brandId, searchById)
                    Constant.SEARCH_DURATION -> mSPreviewRespo.getSearchPreviewDataByDuration(token, deviceId, brandId, searchById)
                    Constant.SEARCH_PRESENTER -> mSPreviewRespo.getSearchPreviewDataByInstructor(token, deviceId, brandId, searchById)
                    Constant.SEARCH_LEVEL -> mSPreviewRespo.getSearchPreviewDataByLevel(token, deviceId, brandId, searchById)
                    else -> return
                }

                observable.subscribe(this)
            }
        }

    }

    override fun getDataForSearch(): SPSearchedOption? = mChosenOptions

    override fun getDataForShow(): SPShowedUIData? = mDisplayData

    override fun getItemSearchOption(): SearchedOption? = mChosenOptions?.searchByData

    override fun setData(dataShowUI: SPShowedUIData?, dataInputForSearch: SPSearchedOption) {
        this.mDisplayData = dataShowUI
        this.mChosenOptions = dataInputForSearch
    }

    override fun onResponseSuccess(data: ResponseValue<MMSearchPreviewResponse>?) {
        if (data == null) return

        val loadedData: MMSearchPreviewResponse = data.data

        SearchDataHelper.sortInstructors(loadedData.instructors)
        SearchDataHelper.sortCollections(loadedData.collections)

        val showUIData = SPShowedUIData()
        showUIData.brand = mChosenOptions?.brand
        showUIData.searchByData = mChosenOptions?.searchByData
        val parsedData: SPSearchedOption = SearchPreviewMapper.parseVideosSearchResultResponse(loadedData, showUIData)

        parsedData.brand = mChosenOptions?.brand
        parsedData.searchByData = mChosenOptions?.searchByData

        mData = parsedData
        mDisplayData = showUIData

        displayUI()
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        onRequestFailed(message)
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)

        onRequestFailed(message)
    }

    private fun onRequestFailed(message: String?) {
//        val msg = message?:mView?.getViewContext()?.getString(R.string.request_failed)?: Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
    }

    override fun onComplete() {
        super.onComplete()
        mIsProcessing = false
        mView?.hideLoadingProgress()
    }

    override fun onDetach() {
        mView = null
    }

    override fun onStop() {
        mIsRendered = false
//        mAdapters?.also { adapters ->
//            while (adapters.size > 0) {
//                adapters[0].release()
//                adapters.removeAt(0)
//            }
//        }
    }


    override fun onDestroy() {
//        mDisplayData?.clear()
//        mChosenOptions?.clear()
//        mData?.clear()
        mCompoDisposable.clear()
    }

    override fun onChooseOptionItem(id: Int?, name: String?, typeId: Int?) {
        if (id == null || typeId == null || mChosenOptions == null) return
        SearchPreviewMapper.processChosenOption(id, name, typeId, mChosenOptions!!)
    }

    override fun requestResultVideos(isUseOptions: Boolean) {
        val chosenOptions: SPSearchedOption? = mChosenOptions
        if (chosenOptions == null) {
            mView?.showMessage(R.string.error_data, R.color.red)
            return
        }

        val options: SPSearchedOption =
                when (isUseOptions) {
                    true -> chosenOptions
                    false -> getEmptyOptions()
                }

        when (isUseOptions && chosenOptions.isEmptyOption()) {
            true -> {
                mView?.showMessage(R.string.please_select_searched_option, R.color.yellow)
            }

            false -> {
                SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
                HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
                mVideosToPlay.clear()
                mView?.openSearchResultScreen(options)
            }
        }
    }

    private fun getEmptyOptions(): SPSearchedOption =
            SPSearchedOption().also {
                it.brand = mChosenOptions?.brand
                it.searchByData = mChosenOptions?.searchByData
            }

    override fun isHaveCollectionsAndInstructors(): Boolean {
        val collections: java.util.ArrayList<SearchedOption>? = mData?.collections
        val instructors: java.util.ArrayList<SearchedOption>? = mData?.instructors
        val isHaveCollections: Boolean = collections != null && collections.size > 0
        val isHaveInstructors: Boolean = instructors != null && instructors.size > 0

        return isHaveCollections && isHaveInstructors
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

    override fun addAdapter(adapter: BaseClickableAdapter<*, *, *>) {
        mAdapters?.add(adapter)
    }

    override fun isItemSelected(id: Int?, typeId: Int?): Boolean {
        if (id == null || typeId == null || mChosenOptions == null) return false

        return when (typeId) {
            Constant.SEARCH_COLLECTION -> {
                SearchPreviewMapper.isOptionSelected(id, mChosenOptions!!.collections) >= 0
            }
            Constant.SEARCH_PRESENTER -> {
                SearchPreviewMapper.isOptionSelected(id, mChosenOptions!!.instructors) >= 0
            }
            Constant.SEARCH_LEVEL -> {
                SearchPreviewMapper.isOptionSelected(id, mChosenOptions!!.levels) >= 0
            }
            Constant.SEARCH_DURATION -> {
                SearchPreviewMapper.isOptionSelected(id, mChosenOptions!!.durations) >= 0
            }
            else -> false
        }
    }
}