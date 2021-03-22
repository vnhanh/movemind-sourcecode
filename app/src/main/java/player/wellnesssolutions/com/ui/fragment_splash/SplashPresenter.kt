package player.wellnesssolutions.com.ui.fragment_splash

import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.uis.BaseResponseObserver
import player.wellnesssolutions.com.base.uis.IGetNewToken
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import player.wellnesssolutions.com.ui.activity_main.MainActivity

class SplashPresenter : BaseResponseObserver<MMConfigData>(), ISplashContract.Presenter, NetworkReceiver.IStateListener {
    private var mView: ISplashContract.View? = null
    private var mLoadedData: MMConfigData? = null
    private var mConfigApi = HomeApi()
    private var mDialog: AlertDialog? = null
    private val REQUEST_FAILED = -1
    private val RESPONSE_SUCCESS = 1
    private val RESPONSE_FALSE = -10
    private var mRequestCode = RESPONSE_SUCCESS

    init {
        NetworkReceiver.getInstance().addListener(this)
    }

    override fun onAttach(view: ISplashContract.View) {
        this.mView = view

        loadApi()
    }

    override fun loadApi() {
        mView?.getViewContext()?.also {
            val headerData: HeaderData = CheckHeaderApiUtil.checkData(sharedPref = SharedPreferencesCustomized.getInstance(it), fragment = mView!!.getFragment())
                    ?: return

            when (mLoadedData == null) {
                true -> {
                    mView!!.onStartLoadApi()
                    loadApi(headerData.token, headerData.deviceId)
                }
                false -> mView!!.navigateToHomeScreen()
            }
        }
    }

    private fun loadApi(token: String, deviceId: String) {
        mConfigApi.getConfigData(token, deviceId).subscribe(this)
    }

    /**
     * Response successfully
     */
    override fun onResponseSuccess(data: ResponseValue<MMConfigData>?) {
        super.onResponseSuccess(data)
        mRequestCode = RESPONSE_SUCCESS
        mDialog?.dismiss()

        mView?.updateProgress(70)
        mLoadedData = data?.data

        if (data?.data == null) {
            onResponseFalse(-1, mView?.getViewContext()?.getString(R.string.no_data_response))
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
        mView?.updateProgress(85)

        storeBranding(data.data.branding)

        mView?.updateProgress(100)

        mView?.navigateToHomeScreen()
    }

    private fun storeBranding(branding: MMBranding?) {
        if (branding == null) return
        mView?.getViewContext()?.also { context ->
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SS_BOTTOM_BAR_COLOR, branding.bottomBarColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.PRIMARY_COLOR, branding.primaryColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SECONDARY_COLOR, branding.textColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SS_COMPANY_LOGO, branding.companyLogo
                    ?: "")
            if (branding.backgroundPictures?.size == 0) {
                SharedPreferencesCustomized.getInstance(context = context).delete(SPrefConstant.SS_BACKGROUND_PICTURES)
            } else {
                SharedPreferencesCustomized.getInstance(context = context).putStrings(SPrefConstant.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
            }
        }
    }

    private fun savePref(data: MMConfigData) {
        mView?.getViewContext()?.also {
            val gson = Gson()
            val json = gson.toJson(data)
            SharedPreferencesCustomized.getInstance(it).putString(SPrefConstant.SS_CONFIG, json)
        }
    }

    /**
     * -----------
     */

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        mRequestCode = RESPONSE_FALSE
        handleOnRequestApiFailed()
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
//        onExpired("Unauthentication !")
        mRequestCode = REQUEST_FAILED
        handleOnRequestApiFailed()
    }

    private fun handleOnRequestApiFailed() {
        val msgResId: Int =
                when (mRequestCode) {
                    REQUEST_FAILED -> R.string.request_failed
                    RESPONSE_FALSE -> R.string.response_false
                    else -> return
                }
        mDialog?.dismiss()
        mView?.updateProgress(-1)
        mView?.getViewContext()?.also { context ->
            mDialog = DialogUtil.createDialogOnlyOneButton(context = context, msgResId = msgResId, titleButton = R.string.btn_ok, dialogClickListener = null).also {
                it.show()
            }
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        mDialog?.dismiss()
        NetworkReceiver.getInstance().removeListener(this)
        mLoadedData = null
        mView = null
    }

    override fun onChangedState(isConnected: Boolean) {
        if (isConnected && mLoadedData == null && mView != null) {
            loadApi()
        }
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        if (mView?.getViewContext() is MainActivity) {
            (mView?.getViewContext() as MainActivity).getTokenAgainWhenTokenExpire(object : IGetNewToken {
                override fun onGetSuccess() {
                    loadApi()
                }
            })
        }
    }
}