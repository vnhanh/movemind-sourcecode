package player.wellnesssolutions.com.ui.fragment_search_brands.module

import androidx.annotation.StringRes
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.brand.BrandApi
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment

class LoadBrandsHandler(callback: ILoadBrandHandler.Callback) : BaseResponseObserver<ArrayList<MMBrand>>(), ILoadBrandHandler {
    private val mCallback: ILoadBrandHandler.Callback = callback
    private var mBrandApi: BrandApi = BrandApi()
    private var mFlowTag = ""

    override fun loadBrands(tag: String) {
        mFlowTag = tag

        mCallback.getViewContext()?.also { context ->
            val headerData: HeaderData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), mCallback.getFragment())
                    ?: return

            val (token: String, deviceId: String) = headerData

            loadApi(token, deviceId)
        }
    }

    private fun loadApi(token: String, deviceId: String) {
        mCallback.onLoadingBrands()
        mBrandApi.getAllBrands(token, deviceId)
                .subscribe(this)
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMBrand>>?) {
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
                mCallback.onGetOnlyOneBrand(brand = brands[0], nextScreenTag = searchBrandFlowTag)
            }

            else -> {
                mCallback.onGetBrands(brands = data.data, searchBrandFlowTag = mFlowTag)
            }
        }

    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)

        when (message == null) {
            true -> onShowRequestApiFalse(R.string.load_brands_failed)
            false -> mCallback.onLoadBrandsFailed(message)
        }
    }

    override fun onRequestError(message: String?) {
        onShowRequestApiFalse(R.string.load_brands_failed)
    }

    override fun onComplete() {
        mCallback.onEndLoadingBrands()
    }

    private fun onShowRequestApiFalse(@StringRes msgResId: Int) {
        mCallback.getViewContext()?.also { context ->
            mCallback.onLoadBrandsFailed(context.getString(msgResId))
        }
    }

    override fun onExpired(error: String) {
        if (mCallback is BaseFragment) {
            mCallback.onExpired(error)
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        if (mCallback is BaseFragment) {
            mCallback.onExpiredUnAuth(error)
        }
    }

    override fun release() {
        mCompoDisposable.dispose()
    }
}