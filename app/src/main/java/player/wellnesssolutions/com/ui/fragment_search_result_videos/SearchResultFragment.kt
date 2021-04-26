package player.wellnesssolutions.com.ui.fragment_search_result_videos

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search_result.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils.isPlayNewList
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.common.customize_views.MMButton.Companion.isClickToNowPlaying
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.activity_main.IRouterChanged
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.dialogs.PlayTrailerVideoDialogFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultConstant.TYPE_GET_VIDEOS_BY_INSTRUCTOR
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultConstant.TYPE_HELP_ME_CHOOSE
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultConstant.TYPE_SEARCH_BY
import player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultDisplayHelper
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.SearchResultRootAdapter

/**
 * This fragment has the ViewPager that contains child fragments as pages and every child fragment has a recyclerview to show list of video items
 */
class SearchResultFragment : BaseFragment(), ISearchResultContract.View, IRouterChanged {

    companion object {
        const val TAG = "SearchResultFragment"

        const val EXTRA_TYPE = "KEY TYPE"
        const val KEY_BRAND_ID = "KEY BRAND ID"
        const val KEY_INSTRUCTOR = "KEY INSTRUCTOR"
        const val TAG_HMC = ":HMC"
        const val TAG_CHOSEN = ":chosen"

        var typeSearch = 0
        var brandIdSearch = 0

        var instructorSearch: MMInstructor? = null


        const val MSG_CANT_LOAD_VIDEOS_BECAUSE_NO_INSTRUCTOR_ID = "Can't load videos because no instructor id !"

        var mVideosToPlay = ArrayList<MMVideo>() // deleting all item when backing to previous fragment

        /**
         * @param chosenOptions: selected options that user picked in screen SearchPreview
         */

        fun getInstanceBySearchedOptions(searchedOptions: SPSearchedOption): SearchResultFragment =
                SearchResultFragment().apply {
                    arguments = getBundleBySearchedOptions(searchedOptions)
                }

        fun getBundleBySearchedOptions(chosenOptions: SPSearchedOption): Bundle {
            // save the list of searched options (brand, collection, instructor, level, duration)
            // into the database
            val chosenTag: String = getTagOfChosen()
            SPDBUtil.saveToDB(chosenOptions, chosenTag)

            return Bundle().apply {
                putInt(EXTRA_TYPE, TYPE_SEARCH_BY)
            }
        }

        //        fun getTagOfSearchByData() : String = StringBuilder(TAG).append(TAG_SEARCH_BY).toString()
        fun getTagOfChosen(): String = StringBuilder(TAG).append(TAG_CHOSEN).toString()

        fun getInstanceByHelpMeChoose(brandId: Int, answers: ArrayList<MMHelpMeChooseAnswer>): SearchResultFragment =
                SearchResultFragment().apply {
                    arguments = getBundleByHelpMeChoose(brandId, answers)
                }

        fun getBundleByHelpMeChoose(brandId: Int, answers: ArrayList<MMHelpMeChooseAnswer>): Bundle {
            // save the list of HelpMeChoose answers into the database
            val tag = getTagOfHMCForDB()
            HMCDataHelper.saveToDB(answers, tag)

            return Bundle().apply {
                putInt(EXTRA_TYPE, TYPE_HELP_ME_CHOOSE)
                putInt(KEY_BRAND_ID, brandId)
            }
        }

        fun getTagOfHMCForDB(): String = StringBuilder(TAG).append(TAG_HMC).toString()

        fun getInstanceByInstructor(instructor: MMInstructor): SearchResultFragment =
                SearchResultFragment().apply {
                    arguments = getBundleByInstructor(instructor)
                }

        fun getBundleByInstructor(instructor: MMInstructor): Bundle =
                Bundle().apply {
                    putInt(EXTRA_TYPE, TYPE_GET_VIDEOS_BY_INSTRUCTOR)
                    putParcelable(KEY_INSTRUCTOR, instructor)
                }

    }

    private var mPresenter: ISearchResultContract.Presenter? = null

    private var mDialog: AlertDialog? = null
    private var mVPAdapter: SearchResultRootAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = SearchResultPresenter(context!!)

        registerRouterChangedListener()

        readArguments()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments?.isEmpty == false) {
            readArguments()
        } else if (isClickToNowPlaying) {
            when (typeSearch) {
                TYPE_SEARCH_BY -> readSearchByArguments()
                TYPE_HELP_ME_CHOOSE -> readHelpMeChooseArguments()
                TYPE_GET_VIDEOS_BY_INSTRUCTOR -> readGetVideosByInstructorArguments()
            }
        }
        setupUI()
    }

    /**
     * readArguments()
     */
    private fun readArguments() {
        when (arguments?.getInt(EXTRA_TYPE)) {
            TYPE_SEARCH_BY -> readSearchByArguments()
            TYPE_HELP_ME_CHOOSE -> readHelpMeChooseArguments()
            TYPE_GET_VIDEOS_BY_INSTRUCTOR -> readGetVideosByInstructorArguments()
        }
        arguments?.let {
            typeSearch = it.getInt(EXTRA_TYPE)
            instructorSearch = it.getParcelable(KEY_INSTRUCTOR)
            brandIdSearch = it.getInt(KEY_BRAND_ID)
        }
        arguments?.clear()
    }

    private fun readGetVideosByInstructorArguments() {
        var instructor: MMInstructor? = arguments?.getParcelable(KEY_INSTRUCTOR)

        if (isClickToNowPlaying) {
            instructor = instructorSearch
        }

        if (instructor == null) {
            showMessage(getString(R.string.err_not_get_presenter), R.color.red)
            return
        }

        mPresenter?.inputData(instructor)
    }

    private fun readHelpMeChooseArguments() {
        var brandId = arguments?.getInt(KEY_BRAND_ID)

        if (isClickToNowPlaying) {
            brandId = brandIdSearch
        }

        if (brandId != null) {
            mPresenter?.inputData(answers = HMCDataHelper.readDB(getTagOfHMCForDB()), brandId = brandId)
        }
    }

    private fun readSearchByArguments() {
//        val searchByData : SPSearchedOption = SPDBUtil.readFromDB(getTagOfSearchByData())
        val chosenOptions: SPSearchedOption = SPDBUtil.readFromDB(getTagOfChosen())

        mPresenter?.inputData(chosenOptions = chosenOptions)
    }

    /**
     * end readArguments()
     */

    private fun setupUI() {
        setupBtnPrevious()
        setupBtnPlay()
        setupBtnRefresh()
        setupBtnSelectAll()
        setupBtnDownloadAll()
    }

    private fun setupBtnDownloadAll() {
        btnDownloadAllSelectedVideos?.setOnClickListener {
            when (btnDownloadAllSelectedVideos.isActive()) {
                true -> {
                    mPresenter?.downloadAllSelectedVideos()
                }

                false -> {
                    MessageUtils.showSnackBar(btnDownloadAllSelectedVideos, R.string.cant_download_because_not_select_any_video, R.color.yellow)
                }
            }
        }
    }

    private fun setupBtnSelectAll() {
        btnSelectAll?.setOnClickListener {
            when (mPresenter?.isAllVideosSelected()) {
                true -> {
                    mPresenter?.unselectAllVideos()

                    mPresenter?.getVideos()?.also { videos ->
                        if (videos.size > 0) {
                            btnSelectAll.text = getString(R.string.select_all)
                            btnDownloadAllSelectedVideos?.deactivate()
                        }
                    }
                }

                false -> {
                    mPresenter?.selectAllVideos()

                    mPresenter?.getVideos()?.also { videos ->
                        if (videos.size > 0) {
                            btnSelectAll.text = getString(R.string.deselect_all)
//                            btnDownloadAllSelectedVideos.active()
                        }
                    }
                }
            }
        }
    }

    private fun setupBtnPlay() {
        ViewUtil.setupButton(btnPlayInSearchResult, this::clickedBtnPlay)
    }

    private fun clickedBtnPlay() {
        when (mPresenter?.hasSelectedVideos()) {
            true -> {
                activity?.let {
                    PreferenceHelper.getInstance(it).delete(ConstantPreference.LAST_TIME_COUNT_DOWN)
                    PreferenceHelper.getInstance(it).delete(ConstantPreference.LAST_PLAYED_VIDEO_POSITION)
                }
                mPresenter?.onPlaySearchedVideos()
                isClickToNowPlaying = true
            }

            else -> {
                MessageUtils.showSnackBar(btnPlayInSearchResult, R.string.please_select_videos_to_play, R.color.yellow)
            }
        }
    }

    private fun setupBtnPrevious() {
        btnPrevious?.setOnClickListener {
            SPDBUtil.deleteAllFromTag(getTagOfChosen())
            HMCDataHelper.deleteALlFromTag(getTagOfHMCForDB())
            mVideosToPlay.clear()
            onBackPressed(btnPrevious)
        }
    }

    private fun setupBtnRefresh() {
        icRefresh?.setOnClickListener {
            icRefresh.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.loadData(view = this)
            icRefresh.isEnabled = true
        }
    }

    override fun onResume() {
        super.onResume()
        ViewUtil.hideRefreshView(icRefresh, tvRetry)
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
        mIsJustBeDestroyed = true
        mPresenter?.onDetach()
        releaseViewPager()
        super.onPause()
    }

    override fun onDestroyView() {
        mDialog?.dismiss()
        super.onDestroyView()
    }

    private fun releaseViewPager() {
//        resultViewPager?.adapter?.also {
//            if (it is CustomPageAdapter) it.release()
//        }
        resultViewPager?.adapter = null

    }

    override fun onDestroy() {
        unregisterRouterChangedListener()
        mPresenter?.onDestroy()
        mPresenter = null

        super.onDestroy()
    }

    override fun showUIBeforeLoadResultData(chosenOptions: SPSearchedOption?) {
        showUIBeforeLoadResultData()
    }

    override fun showUIBeforeLoadResultData() {

    }

    override fun showUIBeforeLoadResultData(instructor: MMInstructor) {

    }

    override fun displaySearchReuslt(searchList: ArrayList<MMVideo>) {
        // display videos search result on pages
        if (resultViewPager != null) {
            resultViewPager.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            resultViewPager.setHasFixedSize(true)
            resultViewPager.onFlingListener = null
            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(resultViewPager)
            //resultViewPager.setRowCount(1)

            mVPAdapter = SearchResultRootAdapter(SearchResultDisplayHelper.processShowData(searchList)).also {
                //SearchResultDisplayHelper.processShowData(searchList, it, mPresenter)
                it.setParentPrenter(getPresenter())
                resultViewPager.adapter = it
                //(resultViewPager.adapter as CustomPageAdapter).notifyDataSetChanged()
            }

            // display top title
            tvTitleSR?.text = getString(R.string.screen_search_result_tv_title_video_number, searchList.size)

            if (resultViewPager.visibility != View.VISIBLE)
                resultViewPager.visibility = View.VISIBLE
            resultViewPager.adapter?.let {
                if (it.itemCount <= 1) {
                    txtSwipeRightForMoreOptions?.visibility = View.INVISIBLE
                } else {
                    txtSwipeRightForMoreOptions?.visibility = View.VISIBLE
                }
            }

            //resultViewPager?.addOnPageChangeListener(mViewPagerListener)
        }
    }


    override fun openPlayingVideosScreen(data: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " openPlayingVideosScreen() | videos number: ${data.size}")
        activity?.also { activity ->
            val passData = ArrayList<MMVideo>()
            passData.addAll(data)

            if ((activity as MainActivity).isPresentationAvailable()) {
                Log.d("LOG", this.javaClass.simpleName + " openPlayingVideosScreen() | play on TV")
                isPlayNewList = true
                PreferenceHelper.getInstance(activity).putLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION, 0L)

                when (activity.isPlayingSearchedVideos() || activity.isPlayingClass()) {
                    true -> {
                        mDialog?.dismiss()
                        mDialog = DialogUtil.createDialogTwoButtons(
                                context = activity,
                                message = getString(R.string.do_you_want_stop_video_and_play_new_searched_videos),
                                titleLeftButton = R.string.btn_no,
                                leftButtonClickListener = null,
                                titleRightButton = R.string.btn_yes,
                                rightButtonClickListener = object : DialogInterface.OnClickListener {
                                    override fun onClick(dialog: DialogInterface?, which: Int) {
                                        activity.playVideo(PlayMode.ON_DEMAND, passData)
                                        //showMessage(R.string.videos_will_be_showned_in_tv_screen, R.color.white)
                                    }

                                }).also { it.show() }
                    }

                    false -> {
                        activity.playVideo(PlayMode.ON_DEMAND, passData)
                        //showMessage(R.string.videos_will_be_showned_in_tv_screen, R.color.white)
                    }
                }
                // return
            }else{
                NowPlayingVideoSetupHelper.openNowPlayingPlayVideoSearched(fragmentManager = activity.supportFragmentManager, videos = passData)
            }
        }
    }

    override fun onRequestFailed(message: String) {
        hideLoadingProgress()
        tvTitleSR?.text = getString(R.string.screen_search_result_tv_title_video_number, 0)
        ViewUtil.showRefreshView(icRefresh, tvRetry)
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

    override fun showMessage(message: String, color: Int) {
        MessageUtils.showToast(context, message, color)?.show()
    }

    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showToast(context, messageRes, color)?.show()
    }

    override fun showLoadingProgress() {
        if (loadingProgressBar != null)
            loadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoadingProgress() {
        if (loadingProgressBar != null)
            loadingProgressBar.visibility = View.GONE
    }

    // disconnect to TV
    override fun onMediaRouterDisconnected() {

    }

    private fun registerRouterChangedListener() {
        activity?.also {
            if (it is MainActivity) it.addRouterChangedListener(this)
        }
    }

    private fun unregisterRouterChangedListener() {
        activity?.also {
            if (it is MainActivity) it.removeRouterChangedListener(this)
        }
    }

    override fun onAnyVideoSelected(isAnyVideoNotDownloaded: Boolean) {
        btnPlayInSearchResult?.enableButton()
        when (isAnyVideoNotDownloaded) {
            true -> btnDownloadAllSelectedVideos?.active()

            false -> btnDownloadAllSelectedVideos?.deactivate()
        }
    }

    override fun onNoVideoSelected() {
        btnPlayInSearchResult?.disableButton()
        btnDownloadAllSelectedVideos?.deactivate()
    }

    override fun onAllVideosSelected() {
        btnSelectAll?.text = getString(R.string.deselect_all)
    }

    override fun onNoAllVideosSelected() {
        btnSelectAll?.text = getString(R.string.select_all)
    }

    override fun addAllVideosForPlay() {

    }

    override fun onShowPlayingVideoDialog(data: MMVideo) {
        activity?.supportFragmentManager?.also { fm ->
            val dialogTag: String = PlayTrailerVideoDialogFragment.TAG
            val dialog: PlayTrailerVideoDialogFragment = PlayTrailerVideoDialogFragment.getInstance(data)

            FragmentUtil.showDialogFragment(fm, dialog, dialogTag)
        }
    }

    fun getPresenter(): ISearchResultContract.Presenter? = mPresenter
}