package player.wellnesssolutions.com.ui.fragment_search_durations


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_search_durations.*
import kotlinx.android.synthetic.main.merge_layout_group_top_search_screen.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.Constant.DEAFULT_MAX_ROWS
import player.wellnesssolutions.com.common.constant.Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW
import player.wellnesssolutions.com.common.customize_views.MMOptionTextView
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.recyclerview.SearchDurationsAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment


class SearchDurationsFragment : BaseFragment(), ISearchDurationContract.View {
    private var mPresenter: ISearchDurationContract.Presenter? = SearchDurationPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)
        if (brand != null) {
            mPresenter?.setChosenBrand(brand)
        }
        arguments?.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_durations, container, false)
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

    private fun setupTextTitle() {
        tvTitle.text = getString(R.string.screen_time_tv_title)
        tvTitle2.text = getString(R.string.tv_choose_a_time)
    }

    private fun setupButtonPrevious() {
        ViewUtil.setupButton(btnPrevious, this::onBackPressed, btnPrevious)
    }

    private fun setupButtonRefresh() {
        icRefresh.setOnClickListener {
            icRefresh.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.loadData(view = this)
            icRefresh.isEnabled = true
        }
    }

    override fun onStart() {
        super.onStart()
        ViewUtil.hideRefreshView(icRefresh, tvRetry)
        attachPresenter()
    }

    private fun attachPresenter() {
        if (mIsJustBeDestroyed) {
            mPresenter?.onReShowUI(this)
            mIsJustBeDestroyed = false
        } else {
            tvTitle.postDelayed(Runnable {
                mPresenter?.onAttach(this@SearchDurationsFragment)
            }, 400L)
        }
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {

        rvDuration?.release()
        mPresenter?.onStop()
        MMOptionTextView.isChangeBG = false
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

    override fun onOpenNextScreen(brand: MMBrand, duration: MMDuration) {
        if (duration.id == null) {
            context?.also {
                DialogUtil.createDialogOnlyOneButton(
                        context = it,
                        message = it.getString(R.string.cant_open_search_preview_because_no_time_id),
                        titleButton = R.string.btn_ok,
                        dialogClickListener = null
                ).show()
            }
            return
        }

        parentFragment?.also { parent ->
            parent.childFragmentManager.also { fm ->
                val nextFragment = SearchPreviewFragment.getInstance(brand = brand, chosenTypeOptionId = Constant.SEARCH_DURATION,
                        chosenOptionId = duration.id, chosenOptionTitle = String.format("%s %s", duration.title, " MINS"), imgCollection = "", imgStrokeColor = "")

                val newTag = SearchPreviewFragment.TAG
                FragmentUtil.replaceFragment(fm = fm, newFragment = nextFragment, newFragmentTag = SearchPreviewFragment.TAG,
                        frameId = R.id.frameLayoutControl, isAddToBackStack = true)

                if (parent is ControlFragment)
                    parent.mCurrentChildScreenTag = newTag
            }
        }
    }

    override fun showUI(brandName: String, data: ArrayList<MMDuration>) {
        if (tvTitle2 == null) return

        if (data.size == 0) {
            tvTitle2.text = getString(R.string.no_time)

            val message = getString(R.string.this_brand_has_no_time, brandName)
            DialogUtil.createDialogOnlyOneButton(context = tvTitle2.context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null).show()

            return
        }

        if (data.size < DEFAULT_MAX_ITEMS_COUNT_IN_ROW) {
            RecyclerViewCustom.alignCenterHorizontal(rvDuration, data.size, rootSearchDuration, btnPrevious)
        }

        val itemCountInRow = Math.min(data.size, DEFAULT_MAX_ITEMS_COUNT_IN_ROW)

        val adapter = SearchDurationsAdapter(mPresenter, data, itemCountInRow).apply {
            maxItemCountInRow = DEFAULT_MAX_ITEMS_COUNT_IN_ROW
            maxRowCount = DEAFULT_MAX_ROWS
        }
        MMOptionTextView.isChangeBG = true
        SearchUIHelper.showItemsOnRecyclerView(rvDuration, adapter)

        if (data.size > 8) {
            showSwipeText()
        } else {
            hideSwipeText()
        }
    }

    private fun showSwipeText() {

        val set = ConstraintSet()
        set.clone(rootSearchDuration)

        set.connect(rvDuration.id, ConstraintSet.BOTTOM, txtSwipeRightForMoreOptions.id, ConstraintSet.TOP)
        set.applyTo(rootSearchDuration)
        txtSwipeRightForMoreOptions.visibility = View.VISIBLE
    }

    private fun hideSwipeText() {

        val set = ConstraintSet()
        set.clone(rootSearchDuration)

        set.connect(rvDuration.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        set.applyTo(rootSearchDuration)
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

    /**
     * -------------------
     */

    companion object {
        val TAG = "SearchDurationsFragment"
        val KEY_BRAND = "BRAND"

        fun getInstance(brand: MMBrand): SearchDurationsFragment {
            val fragment = SearchDurationsFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
