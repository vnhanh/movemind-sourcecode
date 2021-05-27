package player.wellnesssolutions.com.ui.fragment_splash

import com.google.gson.Gson
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver

class SplashPresenter : BaseResponseObserver<MMConfigData>(), ISplashContract.Presenter, NetworkReceiver.IStateListener {
    private var mView: ISplashContract.View? = null
    private var mLoadedData: MMConfigData? = null
    private var mConfigApi = HomeApi()
    private val REQUEST_FAILED = -1
    private val RESPONSE_SUCCESS = 1
    private val RESPONSE_FALSE = -10
    private var mRequestCode = RESPONSE_SUCCESS
    private var isLoading = false

    init {
        NetworkReceiver.getInstance().addListener(this)
    }

    override fun onAttach(view: ISplashContract.View) {
        this.mView = view

        loadApi()
    }

    override fun loadApi() {
        if (isLoading) return

        mView?.getViewContext()?.also {
            val headerData: HeaderData? = CheckHeaderApiUtil.checkData(
                sharedPref = PreferenceHelper.getInstance(it),
                fragment = mView!!.getFragment()
            ) ?: null

            when {
                headerData == null -> {
                    mView?.backToScanQRCode()
                }

                else -> {
                    when (mLoadedData == null) {
                        true -> {
                            mView?.onStartLoadApi()
                            loadApi(headerData.token, headerData.deviceId)
                        }
                        false -> {
                            mView?.navigateToHomeScreen()
                        }
                    }

                }
            }
        }
    }

    private fun loadApi(token: String, deviceId: String) {
        isLoading = true
        mConfigApi.getConfigData(token, deviceId).subscribe(this)
    }

    /**
     * Response successfully
     */
    override fun onResponseSuccess(data: ResponseValue<MMConfigData>?) {
        super.onResponseSuccess(data)
        isLoading = false

        mRequestCode = RESPONSE_SUCCESS

        mView?.updateProgress(70)
        mLoadedData = data?.data

        if (data?.data == null) {
            onResponseFailed(-1, mView?.getViewContext()?.getString(R.string.no_data_response))
            return
        }

        data.data.countDown?.let {
            if (it > 0L) {
                ParameterUtils.countTime = it + 1000L
            } else {
                ParameterUtils.countTime = 31000L
            }
        }

        savePref(data.data)
        mView?.also { view ->
            view.updateProgress(85)

            storeBranding(data.data.branding)

            view.updateProgress(100)

            view.navigateToHomeScreen()
        }
    }

    private fun storeBranding(branding: MMBranding?) {
        if (branding == null) return
        mView?.getViewContext()?.also { context ->
            PreferenceHelper.getInstance(context = context).putString(ConstantPreference.SS_BOTTOM_BAR_COLOR, branding.bottomBarColor
                    ?: "")
            PreferenceHelper.getInstance(context = context).putString(ConstantPreference.PRIMARY_COLOR, branding.primaryColor
                    ?: "")
            PreferenceHelper.getInstance(context = context).putString(ConstantPreference.SECONDARY_COLOR, branding.textColor
                    ?: "")
            PreferenceHelper.getInstance(context = context).putString(ConstantPreference.SS_COMPANY_LOGO, branding.companyLogo
                    ?: "")
            if (branding.backgroundPictures?.size == 0) {
                PreferenceHelper.getInstance(context = context).delete(ConstantPreference.SS_BACKGROUND_PICTURES)
            } else {
                PreferenceHelper.getInstance(context = context).putStrings(ConstantPreference.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
            }
        }
    }

    private fun savePref(data: MMConfigData) {
        mView?.getViewContext()?.also {
            val gson = Gson()
            val json = gson.toJson(data)
            PreferenceHelper.getInstance(it).putString(ConstantPreference.SS_CONFIG, json)
        }
    }

    /**
     * -----------
     */

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        isLoading = false
        mRequestCode = RESPONSE_FALSE
        handleOnCallServiceFailed()
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        isLoading = false
//        onExpired("Unauthentication !")
        mRequestCode = REQUEST_FAILED
        handleOnCallServiceFailed()
    }

    override fun onUnAuthorized() {
        super.onUnAuthorized()
        isLoading = false
        mView?.updateProgress(-1)
        mView?.backToScanQRCode()
    }

    override fun onComplete() {
        super.onComplete()
        isLoading = false
    }

    private fun handleOnCallServiceFailed() {
        mView?.updateProgress(-1)
        val msgResId: Int =
                when (mRequestCode) {
                    REQUEST_FAILED -> R.string.request_failed
                    RESPONSE_FALSE -> R.string.response_false
                    else -> return
                }

        mView?.onCallServiceFailed(msgResId)
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        disposable.clear()
        NetworkReceiver.getInstance().removeListener(this)
    }

    override fun onChangedState(isConnected: Boolean) {
        if (isConnected && mLoadedData == null && mView != null) {
            loadApi()
        }
    }

    override fun onExpired(error: String) {
        isLoading = false
        mView?.updateProgress(-1)
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        isLoading = false
        mView?.updateProgress(-1)
        mView?.callGetTokenAgain()
    }
}