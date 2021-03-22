package player.wellnesssolutions.com.ui.fragment_search_brands


import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_search_brands.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_search_brands.module.OpenSearchScreenByBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.recyclerview.SearchBrandsAdapter


class SearchBrandsFragment : BaseFragment(), ISearchBrandsContract.View {
    private var mPresenter: ISearchBrandsContract.Presenter? = SearchBrandsPresenter()

    // dialog will show in this fragment
    // it guarantees only one dialog at a time
    private var mDialog: AlertDialog? = null

    private var mLeftToRightAnimation: AnimatorSet? = null
    private var mRightToLeftAnimation: AnimatorSet? = null

    // position of the recyclerview when it perform the LeftToRight slide animation
    private var mSlideToRightAnimationPosition: Float = 1200f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.gc()
        context?.also { Glide.get(it).clearMemory() }

        readArguments()

        mSlideToRightAnimationPosition = resources.displayMetrics.widthPixels.toFloat()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_search_brands, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        btnPrevious.setOnClickListener {
            onBackPressed(it)
        }
    }

    override fun onStart() {
        super.onStart()
        attachPresenter()
    }

    private fun attachPresenter() {
        // add 400 miliseconds delay
        // if not add, then app will be lagged during fragment translating
        view?.postDelayed(Runnable {
            mPresenter?.onAttach(this@SearchBrandsFragment)
        }, 400L)
    }

    override fun onPause() {
        super.onPause()
        detachPresenter()
    }

    private fun detachPresenter() {
        mPresenter?.onDetach()
    }

    // this method will be called after navigating to another screen
    override fun onDestroyView() {

        // stop animations
        mLeftToRightAnimation?.cancel()
        mRightToLeftAnimation?.cancel()

        // close dialog
        mDialog?.dismiss()

        rvBrands.release()
        mPresenter?.onStop()

        super.onDestroyView()
    }

    // this method may not be called after navigating to another screen in ControlFragment (if using addToBackStack() method)
    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    // read and clear data in arguments
    private fun readArguments() {
        arguments?.also { args ->
            val nextScreenTag = arguments?.getString(KEY_SEARCH_FLOW) ?: TAG

            args.getParcelableArrayList<MMBrand>(KEY_BRANDS)?.also { brands ->
                mPresenter?.inputData(nextScreenTag, brands)
            }

            args.clear()
        }
    }

    // change searched flow by setting tag
    fun setSearchFlowTag(screenTag: String) {

        // if no new screen tag
        if (screenTag.equals(mPresenter?.getSearchedFlowTag())) {
            view?.also {
                MessageUtils.showSnackBar(it, R.string.no_change_screen, R.color.white)
            }
            return
        }

        mPresenter?.changeSearchedFlow(view = this, searchedFlowTag = screenTag)
    }

    override fun onOpenNextScreen(data: MMBrand, nextScreenTag: String) {
        parentFragment?.also {
            SearchUIHelper.onOpenNextScreen(it, data, nextScreenTag, TAG)
        }
    }

    // Prevent crash app when double touch on loading this fragment
    override fun showUI(data: ArrayList<MMBrand>) {
        rvBrands?.also {
            it.release()
            SearchUIHelper.showItemsOnRecyclerView(rvBrands, getAdapter(data))
        }
    }

    private fun getAdapter(data: ArrayList<MMBrand>): SearchBrandsAdapter {
        val itemCountInRow: Int = Math.min(data.size, Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW)

        return SearchBrandsAdapter(mPresenter, data, itemCountInRow).apply {
            maxItemCountInRow = Constant.DEFAULT_MAX_ITEMS_COUNT_IN_ROW
            maxRowCount = 1
        }
    }

    /**
     * LOAD BRANDS FROM BACKEND
     */
    override fun onLoadingBrands() {
        slideScreenLeftToRight()
    }

    private fun slideScreenLeftToRight() {
        // animation slide recyclerview left to right and then right to left
        val slideOutRight: ObjectAnimator = ObjectAnimator.ofFloat(rvBrands, "translationX", 0f, mSlideToRightAnimationPosition).apply {
            duration = 400
        }

        mLeftToRightAnimation = AnimatorSet().apply {
            play(slideOutRight)

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {

                }

                override fun onAnimationCancel(animation: Animator?) {
                    hideLoading()
                }

                override fun onAnimationStart(animation: Animator?) {
                    mRightToLeftAnimation?.cancel()
                    showLoading()
                }

            })

            start()
        }
    }

    private fun showLoading() {
        progressLoading?.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressLoading?.visibility = View.GONE
    }

    private fun slideScreenRightToLeft() {
        // animation slide recyclerview left to right and then right to left
        val slideInRight: ObjectAnimator = ObjectAnimator.ofFloat(rvBrands, "translationX", mSlideToRightAnimationPosition, 0f).apply {
            duration = 400
        }

        mRightToLeftAnimation = AnimatorSet().apply {
            play(slideInRight)
            start()
        }
    }

    override fun onEndLoadingBrands() {
        mLeftToRightAnimation?.cancel()
        hideLoading()
        slideScreenRightToLeft()
    }

    override fun onGetBrands(brands: ArrayList<MMBrand>, searchBrandFlowTag: String) {
        showUI(brands)
    }

    override fun onGetOnlyOneBrand(brand: MMBrand, nextScreenTag: String) {
        parentFragment?.also { parent ->
            if (parent is ControlFragment) {
                OpenSearchScreenByBrand.getFragmentBySearchBrandFlowTag(brand, nextScreenTag)?.also { newFragment ->
                    parent.openNextScreen(newFragment, nextScreenTag)
                }
            }
        }
    }

    /**
     * --------------------------------------
     */

    companion object {
        val TAG = "SearchBrandsFragment"
        val KEY_SEARCH_FLOW = "NORMAL SCREEN ID"
        val KEY_BRANDS = "KEY_BRANDS"

        fun getInstance(screenTag: String): SearchBrandsFragment {
            val fragment = SearchBrandsFragment()
            fragment.arguments = Bundle().apply {
                putString(KEY_SEARCH_FLOW, screenTag)
            }

            return fragment
        }

        fun getInstance(searchBrandFlowTag: String, brands: ArrayList<MMBrand>): SearchBrandsFragment {
            val fragment = SearchBrandsFragment()
            fragment.arguments = getBundle(searchBrandFlowTag, brands)

            return fragment
        }

        fun getBundle(searchBrandFlowTag: String, brands: ArrayList<MMBrand>): Bundle =
                Bundle().apply {
                    putString(KEY_SEARCH_FLOW, searchBrandFlowTag)
                    putParcelableArrayList(KEY_BRANDS, brands)
                }
    }
}