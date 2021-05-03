package player.wellnesssolutions.com.ui.fragment_home

import android.util.Log
import com.google.gson.Gson
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import java.util.*

class HomePresenter : BaseResponseObserver<MMConfigData>(), IHomeContract.Presenter {
    // vars
    private var mView: IHomeContract.View? = null
    private var mLoadedConfig: MMConfigData? = null
    private var schedule = arrayListOf<MMVideo>()
    private var messagePopUpOnStart = ""
    private var messageSnackbarOnResume = ""

    override fun onAttach(view: IHomeContract.View) {
        this.mView = view

        view.getViewContext()?.also {
            val headerData = CheckHeaderApiUtil.checkData(
                    PreferenceHelper.getInstance(it), view.getFragment())

//            if (headerData != null && mLoadedConfig == null) {
//                mHomeApi.getConfigData(headerData.token, headerData.deviceId).subscribe(this)
//            }
            if (headerData != null) {
                readConfigData()
            }
        }

        if (messagePopUpOnStart.isNotBlank()) {
            val message = messagePopUpOnStart
            view.showPopUp(message)
            messagePopUpOnStart = ""
        }

        Log.d("LOG", this.javaClass.simpleName + " onAttach() | messageSnackbarOnResume: $messageSnackbarOnResume")
        if (messageSnackbarOnResume.isNotBlank()) {
            val message = messageSnackbarOnResume
            view.showSnackbar(message)
            messageSnackbarOnResume = ""
        }
    }

    override fun setupShowPopUpOnStartScreen(message: String) {
        messagePopUpOnStart = message
    }

    override fun setupShowSnackbarOnStartScreen(message: String) {
        val view = mView
        if (view == null) {
            messageSnackbarOnResume = message
            Log.d("LOG", this.javaClass.simpleName + " setupShowSnackbarOnStartScreen() | view is null | set snackbar message: $messageSnackbarOnResume")
        } else {
            Log.d("LOG", this.javaClass.simpleName + " setupShowSnackbarOnStartScreen() | view is not null | show snackbar message: $messageSnackbarOnResume")
            view.showSnackbar(message)
            messageSnackbarOnResume = ""
        }
    }

    override fun setScheduleCurrent(videos: ArrayList<MMVideo>) {
        schedule.clear()
        schedule.addAll(videos)
    }

    override fun onTimePlayAlreadySchedule() {
        mView?.openNowPlayingScreen(schedule)
    }

    private fun readConfigData() {
        mView?.getViewContext()?.also { context ->
            val gson = Gson()
            val str = PreferenceHelper.getInstance(context).getString(ConstantPreference.SS_CONFIG, "")
            val data: MMConfigData? = gson.fromJson<MMConfigData>(str, MMConfigData::class.java)
            mView?.showUI(data)
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        mLoadedConfig = null
        disposable.dispose()
    }

    override fun onResponseSuccess(data: ResponseValue<MMConfigData>?) {
        super.onResponseSuccess(data)

        if (data?.data != null) {
            storeBranding(data.data.branding)
            mLoadedConfig = data.data
            savePref(data.data)
            mView?.showUI(data.data)
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
            PreferenceHelper.getInstance(context = context).putStrings(ConstantPreference.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
        }
    }

    private fun savePref(data: MMConfigData) {
        mView?.getViewContext()?.also {
            val gson = Gson()
            val json = gson.toJson(data)
            PreferenceHelper.getInstance(it).putString(ConstantPreference.SS_CONFIG, json)
        }
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        mView?.showUI(null)
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        mView?.showUI(null)
    }

    override fun onComplete() {
        super.onComplete()
        mView?.hideLoadingProgress()
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {

    }
}