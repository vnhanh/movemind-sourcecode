package player.wellnesssolutions.com.ui.fragment_search_brands.module

import android.os.Handler
import android.util.Log
import androidx.annotation.StringRes
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.view.CACHE_RESPONSE
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.brand.BrandApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment
import java.util.concurrent.TimeUnit

class LoadBrandsHandler(callback: ILoadBrandHandler.Callback) : BaseResponseObserver<ArrayList<MMBrand>>(), ILoadBrandHandler {
    private var mCallback: ILoadBrandHandler.Callback? = callback
    private var mBrandApi: BrandApi = BrandApi()
    private var mFlowTag = ""
    private var cache = Cache()
    private var isLoading = false

    private class Cache(var data: ArrayList<MMBrand> = arrayListOf(), var message: String = "", var state:CACHE_RESPONSE = CACHE_RESPONSE.EMPTY)

    override fun onAttach(view: ILoadBrandHandler.Callback) {
        this.mCallback = view

        when(cache.state){
            CACHE_RESPONSE.RESPONSE_SUCCESS -> onResponseSuccess(ResponseValue(data = cache.data))
            CACHE_RESPONSE.REQUEST_ERROR -> onRequestError(cache.message)
            CACHE_RESPONSE.RESPONSE_FAILED -> onResponseFailed(code = 444, message = cache.message)
            CACHE_RESPONSE.EXPIRED -> onExpired(cache.message)
            CACHE_RESPONSE.EXPIRED_UNAUTHENTICATION -> onExpiredUnauthenticated(cache.message)
            CACHE_RESPONSE.EMPTY -> {
//                Log.d("LOG", this.javaClass.simpleName + " onAttach() | empty state")
            }
        }
        if(cache.state != CACHE_RESPONSE.EMPTY){
            onComplete()
        }
    }

    override fun onDetach() {
        this.mCallback = null
    }

    override fun loadBrands(tag: String) {
        Log.d("LOG", "LoadBrandsHandler() | loadBrands: $tag")
        if (isLoading) return
        mFlowTag = tag
        mCallback?.getViewContext()?.also { context ->
            val headerData: HeaderData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), mCallback?.getFragment())
                    ?: return

            val (token: String, deviceId: String) = headerData
            Log.d("LOG", "LoadBrandsHandler() | loadBrands - loading...")
            loadApi(token, deviceId)
        }
    }

    private fun loadApi(token: String, deviceId: String) {
        isLoading = true
        mCallback?.onLoadingBrands()
        mBrandApi.getAllBrands(token, deviceId)
                .subscribe(this)
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMBrand>>?) {
//        Log.d("LOG", this.javaClass.simpleName + " onResponseSuccess()")
        isLoading = false
        val callback = mCallback
        if(callback == null){
            cache.data.addAll(data?.data ?: arrayListOf())
            cache.state = CACHE_RESPONSE.RESPONSE_SUCCESS
            return
        }
        val brands: ArrayList<MMBrand> = data?.data ?: return

        if (mFlowTag == SearchLevelsFragment.TAG) {
            var i = 0
            while (i < brands.size) {
                val brand = brands[i]
                if (brand.hasLevel == 0) brands.removeAt(i) else i++
            }
        }

        when (brands.size) {
            0 -> {
                onShowRequestApiFalse(R.string.load_no_brands)
            }

            1 -> {
                val searchBrandFlowTag: String =
                        when (mFlowTag) {
                            SearchBrandsFragment.TAG -> SearchVideosByFragment.TAG
                            else -> mFlowTag
                        }
                callback.onGetOnlyOneBrand(brand = brands[0], nextScreenTag = searchBrandFlowTag)
            }

            else -> {
                callback.onGetBrands(brands = data.data, searchBrandFlowTag = mFlowTag)
            }
        }
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        isLoading = false
        val callback = mCallback
        if(callback == null){
            cache.message = message.orEmpty()
            cache.state = CACHE_RESPONSE.RESPONSE_SUCCESS
            return
        }
        when (message == null) {
            true -> onShowRequestApiFalse(R.string.load_brands_failed)
            false -> callback.onLoadBrandsFailed(message)
        }
    }

    override fun onRequestError(message: String?) {
        isLoading = false
        val callback = mCallback
        if(callback == null){
            cache.message = message.orEmpty()
            cache.state = CACHE_RESPONSE.REQUEST_ERROR
            return
        }
        onShowRequestApiFalse(R.string.load_brands_failed)
    }

    override fun onComplete() {
        mCallback?.onEndLoadingBrands()
        isLoading = false
    }

    private fun onShowRequestApiFalse(@StringRes msgResId: Int) {
        mCallback?.getViewContext()?.also { context ->
            mCallback?.onLoadBrandsFailed(context.getString(msgResId))
        }
    }

    override fun onExpired(error: String) {
        val callback = mCallback
        if(callback == null){
            cache.message = error
            cache.state = CACHE_RESPONSE.EXPIRED
            return
        }
        if (callback is BaseFragment) {
            callback.onExpired(error)
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        val callback = mCallback
        if(callback == null){
            cache.message = error
            cache.state = CACHE_RESPONSE.EXPIRED_UNAUTHENTICATION
            return
        }

        if (callback is BaseFragment) {
            callback.onExpiredUnAuth(error)
        }
    }

    override fun release() {
        mCallback = null
        disposable.clear()
    }
}