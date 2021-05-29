package player.wellnesssolutions.com.ui.fragment_search_levels


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_search_levels.*
import kotlinx.android.synthetic.main.merge_layout_group_top_search_screen.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMOptionTextView.Companion.isChangeBG
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMLevel
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.recyclerview.SearchLevelsAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment

class SearchLevelsFragment : BaseFragment(), ISearchLevelsContract.View {
    private var mPrensenter: ISearchLevelsContract.Presenter? = SearchLevelsPresenter()
    private var mDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)
        if (brand == null) {
            showError(context?.getString(R.string.error_not_get_chosen_brand).orEmpty())
            return
        }
        mPrensenter?.setChosenBrand(brand)
    }


    private fun showError(string: String) {
        if (string.isNotBlank())
            MessageUtils.showToast(tvTitle?.context, string, R.color.red)?.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_levels, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupTextTitle()
        setupButtonPrevious()
        setupButtonRefresh()
    }

    private fun setupButtonPrevious() {
        btnPrevious?.setOnClickListener {
            it.isEnabled = false
            FragmentUtil.onBackPressedActivity(activity)
        }
    }

    private fun setupButtonRefresh() {
        icRefresh?.setOnClickListener {
            it.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPrensenter?.loadData(view = this)
            it.isEnabled = true
        }
    }

    private fun setupTextTitle() {
        tvTitle?.text = context?.getString(R.string.screen_level_tv_title).orEmpty()
        tvTitle2?.text = context?.getString(R.string.screen_level_choose_a_level).orEmpty()
    }

    override fun onStart() {
        super.onStart()
        ViewUtil.hideRefreshView(icRefresh, tvRetry)
        attachPresenter()
    }

    private fun attachPresenter() {
        if (mIsJustBeDestroyed) {
            mPrensenter?.onReshowUI(this)
            mIsJustBeDestroyed = false
        } else {
            handler.postDelayed(Runnable {
                mPrensenter?.onAttach(this@SearchLevelsFragment)
            }, 400L)
        }
    }

    override fun onPause() {
        mPrensenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        mDialog?.dismiss()
        rvLevels?.release()
        mPrensenter?.onStop()
        isChangeBG = false
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPrensenter?.onDestroy()
        mPrensenter = null
        super.onDestroy()
    }

    /**
     * View interface
     */
    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showToast(context, messageRes, color)?.show()
    }

    override fun showMessage(message: String, color: Int) {
        if (message.isNotBlank())
            MessageUtils.showToast(context, message, color)?.show()
    }

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

    override fun onOpenNextScreen(brand: MMBrand, level: MMLevel) {
        if (brand.id == null || level.id == null) {
            context?.also { context ->
                mDialog = DialogUtil.createDialogOnlyOneButton(
                        context = context,
                        message = context.getString(R.string.cant_open_search_preview_because_no_brand_or_level_id),
                        titleButton = R.string.btn_ok,
                        dialogClickListener = null
                ).also { it.show() }
            }
            return
        }
        parentFragment?.also { parent ->
            parentFragment?.childFragmentManager?.also { fm ->
                val nextFragment = SearchPreviewFragment.getInstance(brand, Constant.SEARCH_LEVEL, level.id, level.name, "", "")
                val newTag = SearchPreviewFragment.TAG
                FragmentUtil.replaceFragment(
                        fm = fm,
                        newFragment = nextFragment,
                        newFragmentTag = newTag,
                        frameId = R.id.frameLayoutControl,
                        isAddToBackStack = true
                )

                if (parent is ControlFragment)
                    parent.mCurrentChildScreenTag = newTag
            }
        }
    }

    override fun showLoadedData(data: ArrayList<MMLevel>, brandName: String) {
        if (tvTitle2 == null) return

        if (data.size == 0) {
            mDialog?.dismiss()

            tvTitle2.text = context?.getString(R.string.screen_level_tv_title2_no_item).orEmpty()

            val message = context?.getString(R.string.this_brand_has_no_levels, brandName).orEmpty()
            mDialog = DialogUtil.createDialogOnlyOneButton(
                    context = tvTitle2.context,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null
            ).also { it.show() }

            return
        }

        rvLevels?.also {
            val itemCountInRow = Math.min(Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW, data.size)
            val adapter = SearchLevelsAdapter(mPrensenter, data, itemCountInRow).apply {
                maxItemCountInRow = Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW
                maxRowCount = Constant.DEAFULT_MAX_ROWS

            }

            if (data.size < Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW) {
                RecyclerViewCustom.alignCenterHorizontal(rvLevels, data.size, rootSearchLevel, btnPrevious)
            }
            isChangeBG = true


            SearchUIHelper.showItemsOnRecyclerView(it, adapter)

            if (data.size > 8) {
                showSwipeText()
            } else {
                hideSwipeText()
            }

        }

    }

    private fun showSwipeText() {
        rootSearchLevel?.also { layoutSearchLevel ->
            txtSwipeRightForMoreOptions?.also { textViewSwipeRight ->
                rvLevels?.also { recyclerviewLevels ->
                    val set = ConstraintSet()
                    set.clone(layoutSearchLevel)

                    set.connect(recyclerviewLevels.id, ConstraintSet.BOTTOM, textViewSwipeRight.id, ConstraintSet.TOP)
                    set.applyTo(layoutSearchLevel)
                    textViewSwipeRight.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun hideSwipeText() {
        rootSearchLevel?.also { layoutSearchLevel ->
            rvLevels?.also { recyclerviewLevels ->
                val set = ConstraintSet()
                set.clone(layoutSearchLevel)

                set.connect(recyclerviewLevels.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
                set.applyTo(layoutSearchLevel)
            }
        }

        txtSwipeRightForMoreOptions?.visibility = View.GONE
    }

    override fun onRequestFailed(message: String) {
        hideLoadingProgress()
        ViewUtil.showRefreshView(icRefresh, tvRetry)
        context?.also { context ->
            mDialog?.dismiss()
            mDialog = DialogUtil.createDialogOnlyOneButton(
                    context = context,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = ContextCompat.getColor(context, R.color.red)
            ).also { it.show() }
        }
    }

    /**
     * -------------------------
     */

    companion object {
        val TAG = "SearchLevelsFragment"
        val KEY_BRAND = "BRAND"

        fun getInstance(brand: MMBrand): SearchLevelsFragment {
            val fragment = SearchLevelsFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
