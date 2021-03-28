package player.wellnesssolutions.com.ui.fragment_search_preview


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_search_preview.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.common.constant.Constant
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
    private var mPresenter: ISearchPreviewContract.Presenter? = null
    private var mDialog: AlertDialog? = null
    private var nameCollectionChoose: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LOG", this.javaClass.simpleName + " onCreate() | savedInstanceState: ${savedInstanceState}")
        mPresenter = SearchPreviewPresenter()
        savedInstanceState?.also { bundle ->
            try {
                when {
                    bundle.containsKey(KEY_DATA_FOR_SEARCH) -> {
                        val gson = Gson()
                        val strDataInput = bundle.getString(KEY_DATA_FOR_SEARCH)
                        val dataInputForSearch: SPSearchedOption = gson.fromJson(strDataInput, SPSearchedOption::class.java)

                        val dataShowUI: SPShowedUIData? = when {
                            bundle.containsKey(Constant.BUNDLE_SAVE_STATE) -> {
                                val strShowUIData = bundle.getString(Constant.BUNDLE_SAVE_STATE)
                                gson.fromJson(strShowUIData, SPShowedUIData::class.java)
                            }

                            else -> null
                        }
                        mPresenter?.setData(dataShowUI, dataInputForSearch)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("LOG", this.javaClass.simpleName + " onCreate() | savedInstanceState | error: ${e.message}")
            }
        }
        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)
        val searchByData: SearchedOption? = arguments?.getParcelable(KEY_SEARCH_BY_DATA)

        if (brand != null && searchByData != null) {
            mPresenter?.setPassedData(brand, searchByData)
            nameCollectionChoose = searchByData.name
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        arguments?.also { bundle ->
            try {
                Log.d("LOG", this.javaClass.simpleName + " onCreateView() | savedInstanceState | is contains data for search: ${bundle.containsKey(KEY_DATA_FOR_SEARCH)} | " +
                        "is contains BUNDLE_SAVE_STATE: ${bundle.containsKey(Constant.BUNDLE_SAVE_STATE)}")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("LOG", this.javaClass.simpleName + " onCreateView() | savedInstanceState | error: ${e.message}")
            }
        }
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
                if (!mPresenter?.getItemSearchOption()?.imgStrokeColor!!.isEmpty()) {
                    it.setStrokeColor(Color.parseColor(mPresenter?.getItemSearchOption()?.imgStrokeColor))
                }
                Glide.with(it.context).load(mPresenter?.getItemSearchOption()?.imgCollection)
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
        super.onDestroy()
        mPresenter?.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LOG", this.javaClass.simpleName + " onSaveInstanceState() | data: ${mPresenter?.getDataForSearch()}")
        val gson = Gson()
        try {
            mPresenter?.getDataForSearch()?.also { data: SPSearchedOption ->
                val strInputData = gson.toJson(data, SPSearchedOption::class.java)
                outState.putString(KEY_DATA_FOR_SEARCH, strInputData)
            }
            mPresenter?.getDataForShow()?.also { data: SPShowedUIData ->
                val strData = gson.toJson(data, SPShowedUIData::class.java)
                outState.putString(Constant.BUNDLE_SAVE_STATE, strData)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("LOG", this.javaClass.simpleName + " can not save state before this fragment destroyed | " +
                    "error: ${e.message}")

        }
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
                                nextFragment.apply {
                                    arguments = SearchResultFragment.getBundleBySearchedOptions(selectedOptions)
                                }
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
        val KEY_DATA_FOR_SEARCH = "KEY_DATA_FOR_SEARCH"

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