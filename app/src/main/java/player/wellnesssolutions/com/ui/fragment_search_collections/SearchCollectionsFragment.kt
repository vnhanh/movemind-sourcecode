package player.wellnesssolutions.com.ui.fragment_search_collections


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_search_collections.*
import kotlinx.android.synthetic.main.merge_layout_group_top_search_screen.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.Constant.MAX_COLLECTION_ITEMS_COUNT_IN_ROW
import player.wellnesssolutions.com.common.constant.Constant.MAX_COLLECTION_ROWS
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_collections.recyclerview.SearchCollectionsAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment


class SearchCollectionsFragment : BaseFragment(), ISearchCollectionContract.View {
    private var mPresenter: ISearchCollectionContract.Presenter? = SearchCollectionsPresenter()
    private var mDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }


    private fun readArguments() {
        val brand: MMBrand = arguments?.getParcelable(KEY_BRAND) ?: return
        mPresenter?.setChosenBrand(brand)

        arguments?.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_collections, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupTitleText()
        setupButtonPrevious()
        setupButtonRefresh()
    }

    private fun setupButtonRefresh() {
        icRefresh.setOnClickListener {
            it.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.loadData(this)
            it.isEnabled = true
        }
    }

    private fun setupTitleText() {
        tvTitle.text = getString(R.string.screen_collection_tv_title)
        tvTitle2.text = getString(R.string.screen_collection_tv_title_choose_a_collection)
    }

    private fun setupButtonPrevious() {
        ViewUtil.setupButton(btnPrevious, this::onBackPressed, btnPrevious)
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
                mPresenter?.onAttach(this@SearchCollectionsFragment)
            }, 400L)
        }
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        mDialog?.dismiss()
        rvSearchCollections?.release()
        mPresenter?.onStop()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showToast(tvTitle.context, messageRes, color)?.show()
    }

    override fun showMessage(message: String, color: Int) {
        MessageUtils.showToast(tvTitle.context, message, color)?.show()
    }

    override fun onOpenNextScreen(brand: MMBrand, collection: MMCollection) {
        if (collection.id == null) {
            context?.also {
                mDialog?.dismiss()
                mDialog = DialogUtil.createDialogOnlyOneButton(
                        context = it,
                        message = it.getString(R.string.cant_open_search_preview_because_no_collection_id),
                        titleButton = R.string.btn_ok,
                        dialogClickListener = null
                ).also {
                    it.show()
                }
            }
            return
        }
        parentFragment?.also { parent ->
            parent.childFragmentManager.also { fm ->
                val nextFragment = SearchPreviewFragment.getInstance(brand, Constant.SEARCH_COLLECTION, collection.id, collection.name, collection.image, collection.getColorStr())
                val newTag = SearchPreviewFragment.TAG
                FragmentUtil.replaceFragment(fm, nextFragment, newTag, R.id.frameLayoutControl, true)

                if (parent is ControlFragment)
                    parent.mCurrentChildScreenTag = newTag
            }
        }
    }

    override fun showUI(brandName: String, data: ArrayList<MMCollection>) {
        rootCollection?.also {
            if (data.size == 0) {
                mDialog?.dismiss()
                tvTitle2.text = getString(R.string.no_collection)

                val message = getString(R.string.this_brand_has_no_collection, brandName)
                mDialog = DialogUtil.createDialogOnlyOneButton(context = tvTitle2.context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null).also {
                    it.show()
                }

                return
            }

            if (data.size < MAX_COLLECTION_ITEMS_COUNT_IN_ROW) {
                RecyclerViewCustom.alignCenterHorizontal(rvSearchCollections, data.size, it, btnPrevious)
            }

            val itemCountInRow = Math.min(data.size, MAX_COLLECTION_ITEMS_COUNT_IN_ROW)

            val adapter = SearchCollectionsAdapter(mPresenter, data, itemCountInRow).apply {
                maxItemCountInRow = MAX_COLLECTION_ITEMS_COUNT_IN_ROW
                maxRowCount = MAX_COLLECTION_ROWS
            }

            SearchUIHelper.showItemsOnRecyclerView(rvSearchCollections, adapter)
            if (data.size > 10) {
                showSwipeText()
            } else {
                hideSwipeText()
            }
        }
    }

    private fun showSwipeText() {

        val set = ConstraintSet()
        set.clone(rootCollection)

        set.connect(rvSearchCollections.id, ConstraintSet.BOTTOM, txtSwipeRightForMoreOptions.id, ConstraintSet.TOP)
        set.applyTo(rootCollection)
        txtSwipeRightForMoreOptions.visibility = View.VISIBLE
    }

    private fun hideSwipeText() {

        val set = ConstraintSet()
        set.clone(rootCollection)

        set.connect(rvSearchCollections.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        set.applyTo(rootCollection)
        txtSwipeRightForMoreOptions.visibility = View.GONE
    }

    override fun onRequestFailed(message: String) {
        hideLoadingProgress()
        ViewUtil.showRefreshView(icRefresh, tvRetry)
//        MessageUtils.showToast(context, message, R.color.red)
        context?.also {
            mDialog?.dismiss()
            mDialog = DialogUtil.createDialogOnlyOneButton(
                    context = it,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = ContextCompat.getColor(it, R.color.red)
            ).also { it.show() }
        }
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

    /**
     * -------------------
     */

    companion object {
        val TAG = "SearchCollectionsFragment"
        val KEY_BRAND = "BRAND"

        fun getInstance(brand: MMBrand): SearchCollectionsFragment {
            val fragment = SearchCollectionsFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
