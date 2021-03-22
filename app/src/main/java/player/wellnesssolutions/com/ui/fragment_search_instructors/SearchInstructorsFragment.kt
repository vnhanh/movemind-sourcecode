package player.wellnesssolutions.com.ui.fragment_search_instructors


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_search_instructors.*
import kotlinx.android.synthetic.main.merge_layout_group_top_search_screen.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.dialog.InstructorDialogFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.recyclerview.SearchInstructorsAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment
import kotlin.math.min

class SearchInstructorsFragment : BaseFragment(), ISearchInstructorContract.View {
    private var mPresenter: ISearchInstructorContract.Presenter? = SearchInstructorsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(SearchDurationsFragment.KEY_BRAND)

        when (brand == null) {
            true -> showMessage(getString(R.string.error_not_get_chosen_brand), R.color.red)
            false -> mPresenter?.setChosenBrand(brand)
        }

        arguments?.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_instructors, container, false)
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
        btnPrevious.setOnClickListener { view ->
            activity?.also { activity ->
                view.isEnabled = false
                if (activity is MainActivity) {
                    activity.onBackPreviousScreen()
                }
            }
        }
    }

    private fun setupButtonRefresh() {
        icRefresh.setOnClickListener {
            it.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.loadData(this)
            it.isEnabled = true
        }
    }

    private fun setupTextTitle() {
        tvTitle.text = getString(R.string.screen_presenter_tv_title)
        tvTitle2.text = getString(R.string.screen_presenter_choose_a_presenter)
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
            tvTitle.postDelayed(Runnable {
                mPresenter?.onAttach(this@SearchInstructorsFragment)
            }, 300L)
        }
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {

        rvPresenters?.release()
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


    override fun showInstructorInfo(item: MMInstructor) {
        val dialog: InstructorDialogFragment = InstructorDialogFragment.getInstance(item)
        FragmentUtil.showDialogFragment(childFragmentManager, dialog, "dialog")
    }

    override fun onOpenNextScreen(brand: MMBrand, instructor: MMInstructor) {
        if (instructor.id == null) {
            context?.also {
                DialogUtil.createDialogOnlyOneButton(
                        context = it,
                        message = it.getString(R.string.cant_open_search_preview_because_no_presenter_id),
                        titleButton = R.string.btn_ok,
                        dialogClickListener = null
                ).show()
            }
            return
        }
        parentFragment?.childFragmentManager?.also { fm ->
            val nextFragment = SearchPreviewFragment.getInstance(brand, Constant.SEARCH_PRESENTER, instructor.id, instructor.name, "", "")
            val newTag = SearchPreviewFragment.TAG
            FragmentUtil.replaceFragment(fm, nextFragment, newTag, R.id.frameLayoutControl, true)
        }
    }

    override fun showUI(brandName: String, data: ArrayList<MMInstructor>) {
        if (tvTitle2 == null) return

        if (data.size == 0) {
            val title2 = getString(R.string.no_presenter)
            tvTitle2.text = title2

            val message = getString(R.string.this_brand_has_no_presenter, brandName)
            DialogUtil.createDialogOnlyOneButton(context = tvTitle2.context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null).show()

            return
        }

        if (data.size < Constant.MAX_PRESENTER_ITEMS_COUNT_IN_ROW) {
            val itemSize = resources.getDimensionPixelSize(R.dimen.vh_search_item_size_presenter)
            RecyclerViewCustom.alignCenterHorizontal(rvPresenters, data.size, rootSearchPresenter, btnPrevious, itemSize)
        }

        val itemCountInRow = min(data.size, Constant.MAX_PRESENTER_ITEMS_COUNT_IN_ROW)

        val adapter: SearchInstructorsAdapter = SearchInstructorsAdapter(mPresenter, data, itemCountInRow).apply {
            maxItemCountInRow = Constant.MAX_PRESENTER_ITEMS_COUNT_IN_ROW
            maxRowCount = Constant.MAX_PRESENTER_ROWS
        }

        SearchUIHelper.showItemsOnRecyclerView(rvPresenters, adapter)

        if (data.size > 18) {
            showSwipeText()
        } else {
            hideSwipeText()
        }
    }

    private fun showSwipeText() {

        val set = ConstraintSet()
        set.clone(rootSearchPresenter)

        set.connect(rvPresenters.id, ConstraintSet.BOTTOM, txtSwipeRightForMoreOptions.id, ConstraintSet.TOP)
        set.applyTo(rootSearchPresenter)
        txtSwipeRightForMoreOptions.visibility = View.VISIBLE
    }

    private fun hideSwipeText() {

        val set = ConstraintSet()
        set.clone(rootSearchPresenter)

        set.connect(rvPresenters.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        set.applyTo(rootSearchPresenter)
        txtSwipeRightForMoreOptions.visibility = View.GONE
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

    override fun showMessage(message: String, color: Int) {
        MessageUtils.showToast(context, message, color)?.show()
    }

    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showToast(context, messageRes, color)?.show()
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

    override fun onOpenSearchResultScreen(instructor: MMInstructor) {
        parentFragment?.also { parent ->
            parent.childFragmentManager.also { fm ->
                val newFragment = SearchResultFragment.getInstanceByInstructor(instructor)
                val newTag = SearchResultFragment.TAG
                FragmentUtil.replaceFragment(fm, newFragment, newTag, R.id.frameLayoutControl, true)

                if (parent is ControlFragment)
                    parent.mCurrentChildScreenTag = newTag
            }
        }
    }

    // call from button INFO in item MMInstructor
    fun onClickedShowVideosByInstructor(data: MMInstructor) {
        mPresenter?.onClickedShowVideosByInstructor(data)
    }

    /**
     * -----------------
     */

    companion object {
        val TAG = "SearchInstructorsFragment"
        val KEY_BRAND = "BRAND"

        fun getInstance(brand: MMBrand): SearchInstructorsFragment {
            val fragment = SearchInstructorsFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}