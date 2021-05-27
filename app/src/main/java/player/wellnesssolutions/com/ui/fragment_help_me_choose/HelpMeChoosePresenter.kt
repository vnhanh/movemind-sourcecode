package player.wellnesssolutions.com.ui.fragment_help_me_choose

import android.content.Context
import com.google.gson.GsonBuilder
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.datasource.help_me_choose.HelpMeChooseApi
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion.mVideosToPlay


class HelpMeChoosePresenter : BaseResponseObserver<ArrayList<MMHelpMeChooseQuestion>>(), IHelpMeChooseContract.Presenter {
    private var mView: IHelpMeChooseContract.View? = null
    private val helpMeChooseRepository = HelpMeChooseApi()
    private var mBrand: MMBrand? = null
    private var mLoadedData: ArrayList<MMHelpMeChooseQuestion>? = null
    private var mConfigData: MMConfigData? = null

    private val mAnswers: ArrayList<MMHelpMeChooseAnswer> = ArrayList()

    private var wasDisplayed = false

    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onAttach(view: IHelpMeChooseContract.View) {
        this.mView = view
        loadData(view = view)
    }

    override fun loadData(view: IHelpMeChooseContract.View) {
        view.getViewContext()?.also {
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(it), view.getFragment())
                    ?: return

            if (!wasDisplayed && mLoadedData != null) {
                // display title and button HMC text by server
                showViewsByRemote(it)
                displayUI()
            } else if (mLoadedData == null) {
                // display title and button HMC text by server
                showViewsByRemote(it)
                loadData(headerData.token, headerData.deviceId)
            }
        }
    }

    override fun onReshowUI(view: IHelpMeChooseContract.View) {
        this.mView = view
        view.showLoadingProgress()
        wasDisplayed = false
        displayUI()
        view.hideLoadingProgress()
    }

    private fun displayUI() {
        mLoadedData?.also { data ->
            mView?.showLoadedData(data, mConfigData?.helpmeChooseButtonText)
            wasDisplayed = true
        }
    }

    private fun showViewsByRemote(context: Context) {
        PreferenceHelper.getInstance(context).getString(ConstantPreference.SS_CONFIG, Constant.EMPTY).also {
            if (it.isEmpty()) return
            val gson = GsonBuilder().setLenient().create()

            gson.fromJson<MMConfigData>(it, MMConfigData::class.java)?.also { configData ->
                mConfigData = configData

                mView?.showTextByRemote(configData)
            }
        }
    }

    private fun loadData(token: String, deviceId: String) {
        loadQuestions(token, deviceId)
    }

    private fun loadQuestions(token: String, deviceId: String) {
        wasDisplayed = false
        mView?.showLoadingProgress()
        helpMeChooseRepository.loadQuestions(token, deviceId).subscribe(this)
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMHelpMeChooseQuestion>>?) {
        super.onResponseSuccess(data)

        if (data?.data.isNullOrEmpty()) return

        mLoadedData = data?.data
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
//        val msg:String = message?:mView?.getViewContext()?.getString(R.string.request_failed)?:Constant.MSG_REQUEST_FAILED
        mView?.onRequestFailed(mView?.getViewContext()?.getString(R.string.request_failed)
                ?: MSG_REQUEST_FAILED)
    }

    override fun onComplete() {
        super.onComplete()
        mView?.hideLoadingProgress()
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onDestroy() {
        mAnswers.clear()
        mLoadedData?.clear()
        mLoadedData = null
        disposable.dispose()
    }

    override fun selectAnswer(data: MMHelpMeChooseAnswer) {
        if (mAnswers.contains(data)) {
            mAnswers.remove(data)
        } else {
            mAnswers.add(data)
        }
    }

    override fun isItemSelected(item: MMHelpMeChooseAnswer): Boolean = mAnswers.contains(item)

    override fun clickedButtonHelpMeChoose() {
        val brandId = mBrand?.id
        if (brandId == null) {
            mView?.getViewContext()?.also { context ->
                val message = context.getString(R.string.no_brand_id)
                DialogUtil.createDialogOnlyOneButton(
                    context = context,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = R.color.red
                ).show()
            }
            return
        }
        mVideosToPlay.clear()
        SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
        HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        mView?.openScreenSearchResult(brandId, mAnswers)
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
            if (it is BaseFragment) {
                it.onExpiredUnAuth(error)
            }
        }
    }
}