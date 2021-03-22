package player.wellnesssolutions.com.ui.fragment_no_class

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.no_class_search.MMNoClass
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import player.wellnesssolutions.com.ui.fragment_search_brands.module.LoadBrandsHandler

class NoClassPresenter() : BaseResponseObserver<ArrayList<MMBrand>>(), INoClassContract.Presenter {
    private var mView: INoClassContract.View? = null
    private var mLoadBrandsHandler: ILoadBrandHandler? = null
    private var mNoClassData: MMNoClass? = null

    override fun onAttach(view: INoClassContract.View) {
        this.mView = view
        if (mLoadBrandsHandler == null) mLoadBrandsHandler = LoadBrandsHandler(view)

        view.getViewContext()?.also {
            val headerData: HeaderData? = CheckHeaderApiUtil.checkData(SharedPreferencesCustomized.getInstance(it), view.getFragment())

            if (headerData != null && mNoClassData == null) {
                readPref(view)
            }
        }
    }

    private fun readPref(view: INoClassContract.View) {
        view.getViewContext()?.also {
            val json: String = SharedPreferencesCustomized.getInstance(it).getString(SPrefConstant.SS_CONFIG, "")
            if (json == "") {

                return
            }

            val gson: Gson = GsonBuilder().setLenient().create()
            gson.fromJson<MMConfigData>(json, MMConfigData::class.java)?.also { configData ->
                view.showUI(configData)
            }
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        mLoadBrandsHandler?.release()
        mLoadBrandsHandler = null
        mNoClassData = null
    }

    override fun loadBrands(flowTag: String) {
        mLoadBrandsHandler?.loadBrands(flowTag)
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

}