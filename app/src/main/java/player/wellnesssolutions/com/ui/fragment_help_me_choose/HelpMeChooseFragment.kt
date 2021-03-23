package player.wellnesssolutions.com.ui.fragment_help_me_choose


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_help_me_choose.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HelpMeChooseDisplayHelper
import player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionsAdapter
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment


class HelpMeChooseFragment : BaseScheduleFragment(), IHelpMeChooseContract.View {
    private var mPresenter: IHelpMeChooseContract.Presenter? = HelpMeChoosePresenter()
    private var mAdapters: ArrayList<HelpMeChooseQuestionsAdapter>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)
        if (brand != null)
            mPresenter?.setChosenBrand(brand)
        arguments?.clear()
    }

    private fun showError(@StringRes messageResId: Int) {
        MessageUtils.showToast(context, messageResId, R.color.red)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_me_choose, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupBtnPrevious()
        setupIconRefresh()
    }

    private fun setupBtnPrevious() {
        ViewUtil.setupButton(btnPrevious, this::onClickedButtonPrevious)
    }

    private fun onClickedButtonPrevious() {
        activity?.also { act ->
            if (act is MainActivity) {
                act.onBackPreviousScreen()
            }
        }
    }

    private fun setupIconRefresh() {
        icRefresh.setOnClickListener {
            icRefresh.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.loadData(view = this)
            icRefresh.isEnabled = true
        }
    }

    override fun onStart() {
        super.onStart()
        attachPresenter()
    }

    private fun attachPresenter() {
        if (mIsJustBeDestroyed) {
            mPresenter?.onReshowUI(this)
            mIsJustBeDestroyed = false
        } else {
            view?.postDelayed(Runnable {
                mPresenter?.onAttach(this)
            }, 300L)
        }
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        mAdapters?.also { adapters ->
            for (i in 0 until adapters.size) {
                adapters[i].release()
            }
        }
        mAdapters = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null

        super.onDestroy()
    }

    /**
     * @interface IHelpMeChooseContract.View
     */
    override fun showLoadingProgress() {
        progressLoading?.also {
            it.visibility = View.VISIBLE
        }
    }

    override fun hideLoadingProgress() {
        progressLoading?.also {
            it.visibility = View.GONE
        }
    }

    override fun showTextByRemote(configData: MMConfigData) {
        tvTitleHMC?.also {
            var configText = configData.helpmeChooseButtonText.toUpperCase()
            if (configText.isEmpty()) configText = getString(R.string.title_help_me_choose)

            it.text = configText
        }
    }

    override fun showLoadedData(loadedData: ArrayList<MMHelpMeChooseQuestion>, hmcText: String?) {
        questionsContainer?.also {
            btnPrevious.visibility = View.VISIBLE
            if (view == null || !(view is ConstraintLayout)) {
                showError(R.string.error_can_not_display_data)
                return
            }
            mAdapters = HelpMeChooseDisplayHelper.showQuestionsAndAnswersFromLoadedData(presenter = mPresenter, data = loadedData,
                    hmcButtonText = hmcText ?: Constant.EMPTY, parentView = it)
        }
    }

    override fun onRequestFailed(message: String) {
        hideLoadingProgress()
        ViewUtil.showRefreshView(icRefresh, tvRetry)

//        MessageUtils.showToast(context, message, R.color.red)
        context?.also {
            DialogUtil.createDialogOnlyOneButton(
                    context = it,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = ContextCompat.getColor(it, R.color.red)
            ).show()
        }
    }

    override fun openScreenSearchResult(brandId: Int, answers: ArrayList<MMHelpMeChooseAnswer>) {
        parentFragment?.childFragmentManager?.also { fm ->
            FragmentUtil.replaceFragment(
                    fm = fm,
                    newFragment = SearchResultFragment.getInstanceByHelpMeChoose(brandId, answers),
                    newFragmentTag = SearchResultFragment.TAG,
                    frameId = R.id.frameLayoutControl,
                    isAddToBackStack = true
            )
        }
    }

    /**
     * ------------------------
     */

    companion object {
        val TAG = "HelpMeChooseFragment"
        val KEY_BRAND = "KEY BRAND"

        fun getInstance(brand: MMBrand): HelpMeChooseFragment =
                HelpMeChooseFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(KEY_BRAND, brand)
                    }
                }
    }
}
