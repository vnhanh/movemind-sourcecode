package player.wellnesssolutions.com.ui.fragment_home

import android.content.Context
import com.google.gson.Gson
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import java.util.*

class HomePresenter(context: Context) : BaseResponseObserver<MMConfigData>(), IHomeContract.Presenter {
    // vars
    private var mView: IHomeContract.View? = null
    private var mHomeApi = HomeApi()
    private var mLoadedConfig: MMConfigData? = null
    private var schedule = arrayListOf<MMVideo>()

    init {
        SharedPreferencesCustomized.getInstance(context).delete(SPrefConstant.TIME_DIFFS)
    }

    override fun onAttach(view: IHomeContract.View) {
        this.mView = view

        view.getViewContext()?.also {
            val headerData = CheckHeaderApiUtil.checkData(
                    SharedPreferencesCustomized.getInstance(it), view.getFragment())

//            if (headerData != null && mLoadedConfig == null) {
//                mHomeApi.getConfigData(headerData.token, headerData.deviceId).subscribe(this)
//            }
            if (headerData != null) {
                readConfigData()
            }
        }
    }

    override fun setScheduleRemain(videos: ArrayList<MMVideo>) {
        schedule.clear()
        schedule.addAll(videos)
    }

    override fun onTimePlayAlreadySchedule() {
        mView?.openNowPlayingScreen(schedule)
    }

    private fun readConfigData() {
        mView?.getViewContext()?.also { context ->
            val gson = Gson()
            val str = SharedPreferencesCustomized.getInstance(context).getString(SPrefConstant.SS_CONFIG, "")
            val data: MMConfigData? = gson.fromJson<MMConfigData>(str, MMConfigData::class.java)
            mView?.showUI(data)
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        mLoadedConfig = null
        mCompoDisposable.dispose()
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
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SS_BOTTOM_BAR_COLOR, branding.bottomBarColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.PRIMARY_COLOR, branding.primaryColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SECONDARY_COLOR, branding.textColor
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putString(SPrefConstant.SS_COMPANY_LOGO, branding.companyLogo
                    ?: "")
            SharedPreferencesCustomized.getInstance(context = context).putStrings(SPrefConstant.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
        }
    }

    private fun savePref(data: MMConfigData) {
        mView?.getViewContext()?.also {
            val gson = Gson()
            val json = gson.toJson(data)
            SharedPreferencesCustomized.getInstance(it).putString(SPrefConstant.SS_CONFIG, json)
        }
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
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