package player.wellnesssolutions.com.ui.fragment_search_preview


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_search_preview.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SearchPreviewDisplayHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment


class SearchPreviewFragment : BaseFragment(), ISearchPreviewContract.View {
    private var mPresenter: ISearchPreviewContract.Presenter? = SearchPreviewPresenter()
    private var mDialog: AlertDialog? = null
    private var nameCollectionChoose: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)
        val searchByData: SearchedOption? = arguments?.getParcelable(KEY_SEARCH_BY_DATA)

        if (brand != null && searchByData != null) {
            mPresenter?.setPassedData(brand, searchByData)
            nameCollectionChoose = searchByData.name
        }


        arguments?.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_preview, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupButtons()
        setupTextTitle()
    }

    private fun setupTextTitle() {
        if (SearchCollectionUtil.isSkipAndSearchChoose && SearchCollectionUtil.isCollectionChoose && !nameCollectionChoose.isNullOrEmpty()) {
            tvTitle.text = nameCollectionChoose
            tvTitle3.text = context?.getString(R.string.title_search_preview)
            tvTitle3.visibility = View.VISIBLE
            tvTitle2.visibility = View.VISIBLE
            imgCollectionLogoOnTop.let {
                it.visibility = View.VISIBLE
                if (!mPresenter?.getData()?.imgStrokeColor!!.isEmpty()) {
                    it.setStrokeColor(Color.parseColor(mPresenter?.getData()?.imgStrokeColor))
                }
                Glide.with(it.context).load(mPresenter?.getData()?.imgCollection)
                        .override(60, 60)
                        .placeholder(R.drawable.bg_sp_deault_collection)
                        .fallback(R.drawable.bg_sp_deault_collection)
                        .error(R.drawable.bg_sp_deault_collection)
                        .into(it)
            }
            val set = ConstraintSet()
            set.clone(ctlTvTitle)

            set.connect(tvTitle.id, ConstraintSet.START, imgCollectionLogoOnTop.id, ConstraintSet.END)
            set.applyTo(ctlTvTitle)
        }
    }

    private fun setupButtons() {
        // button PREVIOUS
        ViewUtil.setupButton(btnPrevious, this::onBackPressed, btnPrevious)
        ViewUtil.setupButton(btnShowAllVideosResult, this::clickedButtonShowAllVideos)
        ViewUtil.setupButton(btnShowResultByMyOptions, this::clickedButtonShowVideosByOptions)
        ViewUtil.setupButton(icRefresh, this::onClickedIconRefresh)
    }

    private fun clickedButtonShowAllVideos() {
        clickedShowResult(false)
    }

    private fun clickedShowResult(isUseOptions: Boolean = false) {
        mPresenter?.requestResultVideos(isUseOptions)
    }

    private fun clickedButtonShowVideosByOptions() {
        clickedShowResult(true)
    }

    private fun onClickedIconRefresh() {
        icRefresh.isEnabled = false
        ViewUtil.hideRefreshView(icRefresh, tvRetry)
        mPresenter?.loadData(view = this)
        icRefresh.isEnabled = true
    }

    override fun onStart() {
        super.onStart()
        ViewUtil.hideRefreshView(icRefresh, tvRetry)
        attachPresenter()
    }

    private fun attachPresenter() {
        if (mIsJustBeDestroyed) {
            mPresenter?.onReshowUI(this)
            mIsJustBeDestroyed = false
        } else {
            view?.postDelayed(Runnable {
                mPresenter?.onAttach(this@SearchPreviewFragment)
            }, 300L)
        }
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        mDialog?.dismiss()
        mPresenter?.onStop()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    /**
     * View interface
     */

    override fun showMessage(message: String, color: Int) {
        MessageUtils.showSnackBar(btnPrevious, message, color)
    }

    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showSnackBar(btnPrevious, messageRes, color)
    }

    override fun showLoadingProgress() {
        progressLoadingSearchPreview?.also {
            it.visibility = View.VISIBLE
        }
    }

    override fun hideLoadingProgress() {
        progressLoadingSearchPreview?.also {
            it.visibility = View.GONE
        }

    }


    override fun showUI(showUIData: SPShowedUIData) {
        rootSP?.also {
            mPresenter?.also { presenter ->
                SearchPreviewDisplayHelper.showUI(presenter, showUIData, it)
            }

        }
    }

    override fun onRequestFailed(message: String) {
        hideLoadingProgress()
        ViewUtil.showRefreshView(icRefresh, tvRetry)

        context?.also {
            mDialog?.dismiss()
            mDialog = DialogUtil.createDialogOnlyOneButton(
                    context = it,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = ContextCompat.getColor(it, R.color.red)
            ).also {
                it.show()
            }

        }
    }

    override fun openSearchResultScreen(selectedOptions: SPSearchedOption) {
        parentFragment?.also { parent ->
            parent.childFragmentManager.also { fm ->
                //                var nextFragment : SearchResultFragment = SearchResultFragment.getInstanceBySearchedOptions(selectedOptions)
                val tag = SearchResultFragment.TAG
                var nextFragment = fm.findFragmentByTag(tag)

                nextFragment =
                        when (nextFragment != null && nextFragment is SearchResultFragment) {
                            true -> {
                                nextFragment.arguments = SearchResultFragment.getBundleBySearchedOptions(selectedOptions)
                                nextFragment
                            }
                            false -> {
                                SearchResultFragment.getInstanceBySearchedOptions(selectedOptions)
                            }
                        }

                FragmentUtil.replaceFragment(
                        fm = fm,
                        newFragment = nextFragment,
                        newFragmentTag = tag,
                        frameId = R.id.frameLayoutControl,
                        isAddToBackStack = true
                )

                if (parent is ControlFragment) parent.mCurrentChildScreenTag = tag
            }
        }
    }

    /**
     *  ---------------------
     */

    companion object {
        val TAG = "SearchPreviewFragment"
        val KEY_BRAND = "BRAND"
        val KEY_SEARCH_BY_DATA = "KEY NORMAL BY DATA"

        fun getInstance(brand: MMBrand, chosenTypeOptionId: Int, chosenOptionId: Int?, chosenOptionTitle: String?, imgCollection: String?, imgStrokeColor: String?): SearchPreviewFragment {
            val fragment = SearchPreviewFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
                putParcelable(KEY_SEARCH_BY_DATA, SearchedOption(chosenOptionId, chosenOptionTitle, chosenTypeOptionId, imgCollection, imgStrokeColor))
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}