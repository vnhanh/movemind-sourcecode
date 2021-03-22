package player.wellnesssolutions.com.ui.fragment_no_class


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_no_class_search.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.uis.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.StringUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil
import player.wellnesssolutions.com.common.customize_views.MMOptionTextView.Companion.colorBand
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_help_me_choose.HelpMeChooseFragment
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_search_brands.module.OpenSearchScreenByBrand


class NoClassFragment : BaseFragment(), INoClassContract.View {
    private var mPresenter: INoClassContract.Presenter? = null

    companion object {
        val TAG = "NoClassFragment"

        fun getInstance(): NoClassFragment = NoClassFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.gc()
        mPresenter = NoClassPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_class_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        btnHelpMeChoose.setOnClickListener { clickedHelpMeChooseButton() }
        btnSkipSearch.setOnClickListener { clickedSkipAndSearchButton() }
    }

    private fun clickedSkipAndSearchButton() {
        mPresenter?.loadBrands(flowTag = SearchBrandsFragment.TAG)
        SearchCollectionUtil.isSkipAndSearchChoose = true
    }

    private fun clickedHelpMeChooseButton() {
        btnHelpMeChoose?.changeBgColor()
        mPresenter?.loadBrands(flowTag = HelpMeChooseFragment.TAG)
        SearchCollectionUtil.isSkipAndSearchChoose = false
    }

    override fun onResume() {
        super.onResume()
        attachPresenter()
    }

    override fun onPause() {
        detachPresenter()
        super.onPause()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    private fun attachPresenter() {
        // add 400 miliseconds delay
        // if not add, then app will be lagged during fragment translating
        view?.postDelayed(Runnable {
            mPresenter?.onAttach(this)
        }, 400L)
    }

    private fun detachPresenter() {
        mPresenter?.onDetach()
    }

    /**
     * implemented @interface INoClassContract.View
     */
    override fun showUI(data: MMConfigData) {
        displayUI(data)
    }

    private fun setCenterButtonHelpMeChoose() {
        view?.also {
            val set = ConstraintSet()
            set.clone(rootCollection)
            set.connect(btnHelpMeChoose.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            set.applyTo(rootCollection)
            val newLayoutParams: ConstraintLayout.LayoutParams = btnHelpMeChoose.layoutParams as ConstraintLayout.LayoutParams
            newLayoutParams.topMargin = 0
            btnHelpMeChoose.layoutParams = newLayoutParams
        }
    }

    private fun displayUI(data: MMConfigData) {
        view?.also {
            displayHelpMeChooseViews(data, true)

            if (data.hasHelpMeChoose == 1) { // there is "HELP ME CHOOSE" button
                displaySkipAndSearchViews(data)
            } else {
                hideSkipAndSearchViews()
            }
        }
    }

    private fun displayHelpMeChooseViews(data: MMConfigData, isShowed: Boolean) {
        view?.also {
            when (isShowed) {
                true -> {
                    btnHelpMeChoose?.also {
                        if (it.visibility != View.VISIBLE)
                            it.visibility = View.VISIBLE

                        if (data.hasHelpMeChoose == 1) {
                            it.text = data.helpmeChooseButtonText
                        } else {
                            it.setOnClickListener { null }
                            it.setOnClickListener { clickedSkipAndSearchButton() }
                            it.text = getString(R.string.text_button_search)
                            setCenterButtonHelpMeChoose()
                        }
                    }

                    tvHelperHelpMeChoose?.also {
                        if (it.visibility != View.VISIBLE)
                            it.visibility = View.VISIBLE

                        StringUtil.setupFontMadeESNormal(it)
                        if (data.hasHelpMeChoose == 1) {
                            it.text = data.helpMeChooseHelperText
                        } else {
                            it.text = data.skipAndSearchHelperText
                        }
                    }
                }

                false -> {
                    if (btnHelpMeChoose.visibility != View.GONE)
                        btnHelpMeChoose.visibility = View.GONE

                    if (tvHelperHelpMeChoose.visibility != View.GONE)
                        tvHelperHelpMeChoose.visibility = View.GONE
                }
            }
        }
    }

    private fun displaySkipAndSearchViews(data: MMConfigData) {
        if (btnSkipSearch == null || tvHelperSkipSearch == null) return

        if (btnSkipSearch.visibility != View.VISIBLE)
            btnSkipSearch.visibility = View.VISIBLE

        if (tvHelperSkipSearch.visibility != View.VISIBLE)
            tvHelperSkipSearch.visibility = View.VISIBLE

        val buttonText: String = data.skipAndSearchButtonText
        if (!buttonText.isEmpty())
            btnSkipSearch.text = buttonText

        StringUtil.setupFontMadeESNormal(tvHelperSkipSearch)
        tvHelperSkipSearch.text = data.skipAndSearchHelperText
    }

    private fun hideSkipAndSearchViews() {
        if (btnSkipSearch == null || tvHelperSkipSearch == null) return

        if (btnSkipSearch.visibility == View.VISIBLE)
            btnSkipSearch.visibility = View.GONE

        if (tvHelperSkipSearch.visibility == View.VISIBLE)
            tvHelperSkipSearch.visibility = View.GONE
    }

    override fun showLoadingProgress() {
        progressBar?.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        progressBar?.visibility = View.GONE
    }

    override fun showMessage(messageRes: Int, @ColorRes color: Int) {
        imageBgScreenNoClass?.also {
            MessageUtils.showSnackBar(snackView = it, msgRes = messageRes, colorRes = color, btnRes = R.string.btn_ok)
        }
    }

    override fun showMessage(message: String, color: Int) {
        imageBgScreenNoClass?.also {
            MessageUtils.showSnackBar(snackView = it, message = message, colorRes = color, btnRes = R.string.btn_ok)
        }
    }

    /**
     * LOAD BRANDS FROM BACKEND
     */
    override fun onLoadingBrands() {
        btnHelpMeChoose?.isEnabled = false
        btnSkipSearch?.isEnabled = false

        showLoadingBrand()
    }

    override fun onEndLoadingBrands() {
        btnHelpMeChoose?.isEnabled = true
        btnSkipSearch?.isEnabled = true

        hideLoadingBrand()
    }

    private fun showLoadingBrand() {
        parentFragment?.also { parent ->
            if (parent is ControlFragment) parent.showLoadingBrand()
        }
    }

    private fun hideLoadingBrand() {
        parentFragment?.also { parent ->
            if (parent is ControlFragment) parent.hideLoadingBrand()
        }
    }

    override fun onGetBrands(brands: ArrayList<MMBrand>, searchBrandFlowTag: String) {
        val newFragment: SearchBrandsFragment = SearchBrandsFragment.getInstance(searchBrandFlowTag, brands)
        openNextScreen(newFragment, SearchBrandsFragment.TAG)
    }

    override fun onGetOnlyOneBrand(brand: MMBrand, nextScreenTag: String) {
        OpenSearchScreenByBrand.getFragmentBySearchBrandFlowTag(brand, nextScreenTag)?.also { newFragment ->
            openNextScreen(newFragment, nextScreenTag)
        }
        brand.id?.let {
            colorBand = it
        }
    }

    private fun openNextScreen(newFragment: Fragment, newFragmentTag: String) {
        parentFragment?.also { parent ->
            val manager: FragmentManager = parent.childFragmentManager
            FragmentUtil.replaceFragment(manager, newFragment, newFragmentTag, R.id.frameLayoutControl, isAddToBackStack = true)

            if (parent is ControlFragment)
                parent.mCurrentChildScreenTag = newFragmentTag
        }
    }

    override fun onLoadBrandsFailed(message: String) {
        MessageUtils.showToast(context, message, R.color.red, isLongTime = true)?.show()
    }
}
