package player.wellnesssolutions.com.ui.fragment_control

import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.graphics.ColorUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_control.*
import kotlinx.android.synthetic.main.layout_float_menu.*
import kotlinx.android.synthetic.main.layout_float_menu.view.*
import kotlinx.android.synthetic.main.merge_load_brand.*
import kotlinx.android.synthetic.main.merge_loading_screen.*
import kotlinx.android.synthetic.main.merge_now_playing_coming_up_next.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.download.DownloadVideoHelper
import player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMTextView
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.common.utils.StrUtil
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver
import player.wellnesssolutions.com.ui.activity_main.IRouterChanged
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver
import player.wellnesssolutions.com.ui.fragment_control.helpers.MMMenuAnimationHelper
import player.wellnesssolutions.com.ui.fragment_help_me_choose.HelpMeChooseFragment
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment
import player.wellnesssolutions.com.ui.fragment_no_class.NoClassFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.GCUDisplayHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_search_brands.module.OpenSearchScreenByBrand
import player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion.mVideosToPlay
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment
import player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment


/**
 * This fragment is container of screens (child fragments) such as Brands screen, Search Preview screen, Search Video Results screen...
 */
class ControlFragment : BaseScheduleFragment(), IControlContract.View, IScheduleContract.View, IRouterChanged,
        CastingBroadcastReceiver.TVListener,
        ScheduleBroadcastReceiver.ScheduleListener {
    private var mPresenter: IControlContract.Presenter? = ControlPresenter()
    var mCurrentChildScreenTag = ""
    var isClicked = false

    // handler that perform downloading videos task
    // use for PLAYLIST function in case casting videos on TV
    //private var mNowPlayingDownloadButtonManager: DownloadButtonManager? = null
    private var mExtraNPGCUCollectionViews: ArrayList<TextView>? = ArrayList()

    //MENU
    private var mMenuAnimationHelper: MMMenuAnimationHelper = MMMenuAnimationHelper()

    private var mMenuWidth = 0
    private var mMenuHeight = 0
    private var mIsShownMenu = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerRouterChangedListener()
        registerCastingTVBroadcast()
        registerScheduleBroadcast()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.onAttach(this)
    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroy() {
        unregisterCastingTVBroadcast()
        unregisterScheduleBroadcast()
        unregisterRouterChangedListener()

        mPresenter?.onDestroy()
        mMenuAnimationHelper.release()

        super.onDestroy()
    }

    /**
     * implementing @interface Presenter
     */
    // process in case no class videos (no schedule) after loading schedule
    override fun onNoClassVideos(message: String, @ColorRes msgColor: Int, isClickedFromBtnBottom: Boolean) {
        btnLogoBottom?.isEnabled = true
//        if (message.isNotEmpty()) {
//            MessageUtils.showSnackBar(btnLogoBottom, message, R.color.yellow)
//        }
//        else {
//            val msg = getString(R.string.no_class_now)
//            MessageUtils.showSnackBar(btnLogoBottom, msg, R.color.yellow)
//        }

        activity?.also { act ->
            if (act is MainActivity && act.isPresentationAvailable() && ParameterUtils.isClearVideoOnPresentation) {
                act.clearPresentationVideos()
            } else {
                ParameterUtils.isClearVideoOnPresentation = true
            }
        }

        // old flow
//        childFragmentManager.also { fm ->
//            ChildFragmentManager.createOrInputNewDataForFragment(fm, R.id.frameLayoutControl, NoClassFragment.TAG, null)
//            mCurrentChildScreenTag = NoClassFragment.TAG
//        }

        // new flow
        if (isClickedFromBtnBottom) {
            activity?.let {
                if (it is MainActivity) {
                    it.getApiConfigData()
                }
            }
            activity?.supportFragmentManager?.also { fm ->
                val tag: String = HomeFragment.TAG
                var fragment: Fragment? = fm.findFragmentByTag(tag) // find the earlier fragment if existed
                fragment =
                        when (fragment != null && fragment is HomeFragment) {
                            true -> HomeFragment.updateAlreadyInstanceWithNoSchedule(fragment)                    // use old instance
                            false -> HomeFragment.getInstanceNoLoadSchedule() // create new instance if it has been not created yet
                        }
                FragmentUtil.replaceFragment(fm = fm,
                        newFragment = fragment, newFragmentTag = tag,
                        frameId = R.id.frameLayoutHome, isAddToBackStack = false, isRemoveOlds = true)
            }
        }

        btnLogoBottom?.isEnabled = true
    }

    override fun onHaveClassVideos(scheduledVideos: ArrayList<MMVideo>, isClickedFromBtnBottom: Boolean) {
        activity?.also { activity ->
            if (activity is MainActivity && activity.isPresentationAvailable()) {
                MessageUtils.showSnackBar(snackView = btnLogoBottom, message = getString(R.string.now_playing_class),
                        colorRes = R.color.white)
                activity.playVideo(PlayMode.SCHEDULE, scheduledVideos)

            } else {
                loadNowPlayingScreen()
            }
        }
    }

    override fun onTimePlaySchedule() {
        loadNowPlayingScreen()
    }

    fun loadNowPlayingScreen() {
        activity?.supportFragmentManager?.also { _fm ->
            val tag = NowPlayingFragment.TAG
            var fragment = _fm.findFragmentByTag(tag)
            fragment =
                    when (fragment != null && fragment is NowPlayingFragment) {
                        true -> fragment
                        false -> NowPlayingFragment.getInstancePlaySchedule()
                    }
            FragmentUtil.replaceFragment(fm = _fm, newFragment = fragment, newFragmentTag = tag, frameId = R.id.frameLayoutHome, isAddToBackStack = true, isRemoveOlds = true)
        }

    }

    override fun onReceiveChangeApiBackToHome() {
        activity?.let {
            if (it is MainActivity) {
                //it.showDialogBackToHome()
                Handler().postDelayed({
                    //it.hideDialogBackToHome()
                    backToHome(it)
                }, 3000)
            }
        }
    }

    override fun onReceiveChangeSub() {
        activity?.let {
            if (it is MainActivity) {
                it.showDialogBackToHome()
                Handler().postDelayed({
                    //it.hideDialogBackToHome()
                    backToHome(it)
                }, 3000)
            }
            DownloadVideoHelper.senStorageStatusToServer(it,
                    FileUtil.getAvailableInternalMemorySize(),
                    FileUtil.getTotalInternalMemorySize(),
                    FileUtil.getAvailableExternalMemorySize(it),
                    FileUtil.getTotalExternalMemorySize(it))
        }
    }

    override fun onReceiveChangeApiBackToHomeGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                //it.showDialogBackToHome()
                it.getApiConfigData()
                Handler().postDelayed({
                    //it.hideDialogBackToHome()
                    backToHome(it)
                }, 3000)
            }
        }
    }

    override fun onReceiveChangeApiGetConfigApi() {
        activity?.let {
            if (it is MainActivity) {
                it.getApiConfigData()
            }
        }
    }

    private fun backToHome(activity: FragmentActivity) {
        if (activity is MainActivity) {
            if (activity.appVisible) {
                activity.supportFragmentManager.also { fm ->
                    val tag: String = HomeFragment.TAG
                    var fragment: Fragment? = fm.findFragmentByTag(tag) // find the earlier fragment if existed
                    fragment =
                            when (fragment != null && fragment is HomeFragment) {
                                true -> fragment                    // use old instance
                                false -> HomeFragment.getInstanceWithLoadSchedule() // create new instance if it has been not created yet
                            }
                    FragmentUtil.replaceFragment(fm = fm,
                            newFragment = fragment, newFragmentTag = tag,
                            frameId = R.id.frameLayoutHome, isAddToBackStack = false, isRemoveOlds = true)
                }
            }
        }
    }

    override fun showLoadingProgress() {
        screenFrameOverlay?.also {
            it.visibility = View.VISIBLE
        }
    }

    override fun hideLoadingProgress() {
        screenFrameOverlay?.also {
            it.visibility = View.GONE
        }
    }

    override fun showMessage(messageRes: Int, color: Int) {
        btnLogoBottom?.also {
            MessageUtils.showSnackBar(it, messageRes, color)
        }
    }

    override fun showMessage(message: String, color: Int) {
        btnLogoBottom?.also {
            MessageUtils.showSnackBar(it, message, color)
        }
    }

    override fun setupViewFloatMenu(configData: MMConfigData) {
        when (configData.hasHelpMeChoose) {
            0 -> {
                menuItemHelpMeChoose.visibility = View.GONE
            }

            1 -> {
                menuItemHelpMeChoose.visibility = View.VISIBLE

                configData.helpmeChooseButtonText.also {
                    if (it.isNotEmpty())
                        menuItemHelpMeChoose.text = it
                }
            }
        }
    }

    // how to check if this screen was invisible or was recalled
    private fun setupUI() {
        readArguments()

        setupButtonFloatMenu()

        ViewUtil.setupButton(btnLogoBottom, this::onClickedButtonLogo)

        setupFloatMenu()

        setupButtonPlaylist()

        setupGCUTouchEvent()

        setupButtonPlayPausePlaylist()

        //setupButtonEnded()

    }

    private fun setupGCUTouchEvent() {
        view?.also {
            NowPlayingVideoSetupHelper.setupComingUpNext(it, null, mPresenter)
        }
    }


    private fun readArguments() {
        arguments?.also { bundle ->
            val tag: String? = bundle.getString(EXTRA_CHILD_SCREEN_TAG)

            val childFragment: Fragment? =
                    when (tag) {
                        TimeTableFragment.TAG -> TimeTableFragment.getInstance()
                        NoClassFragment.TAG -> NoClassFragment.getInstance()

                        SearchBrandsFragment.TAG -> getChildFragmentByBrandsListAndFlowTag(bundle)

                        SearchVideosByFragment.TAG,
                        SearchInstructorsFragment.TAG,
                        SearchCollectionsFragment.TAG,
                        SearchLevelsFragment.TAG,
                        SearchDurationsFragment.TAG,
                        HelpMeChooseFragment.TAG -> getChildFragmentByBrandData(bundle)

                        else -> null
                    }

            if (tag != null && childFragment != null)
                loadScreen(childFragmentManager, childFragment, tag)

            mCurrentChildScreenTag = tag ?: ""
            bundle.clear()
        }
    }

    private fun getChildFragmentByBrandsListAndFlowTag(bundle: Bundle): Fragment? {
        val tag: String = SearchBrandsFragment.TAG
        val brands: ArrayList<MMBrand>? = bundle.getParcelableArrayList(SearchBrandsFragment.KEY_BRANDS)
        val searchBrandFlowTag: String = bundle.getString(SearchBrandsFragment.KEY_SEARCH_FLOW, "")

        return when (brands?.size ?: 0) {
            0 -> {
                SearchBrandsFragment.getInstance(tag)
            }

            1 -> {
                if (searchBrandFlowTag.isNotEmpty())
                    OpenSearchScreenByBrand.getFragmentBySearchBrandFlowTag(brands!![0], searchBrandFlowTag)
                else
                    SearchBrandsFragment.getInstance(tag)
            }

            else -> {
                SearchBrandsFragment.getInstance(searchBrandFlowTag, brands!!)
            }
        }
    }

    private fun getChildFragmentByBrandData(bundle: Bundle): Fragment? {
        val brand: MMBrand? = bundle.getParcelable(EXTRA_BRAND)
        val childScreenTag: String = bundle.getString(EXTRA_CHILD_SCREEN_TAG, SearchVideosByFragment.TAG)
        return if (brand == null) null else OpenSearchScreenByBrand.getFragmentBySearchBrandFlowTag(brand, childScreenTag)
    }

    private fun onClickedButtonLogo() {
        btnLogoBottom.isEnabled = false

        activity?.also { act ->
            if ((act as MainActivity).isPresentationAvailable()) {
                val isPlayingSearchVideos: Boolean = act.isPlayingSearchVideos()
                if (isPlayingSearchVideos) {
                    val message: String = getString(player.wellnesssolutions.com.R.string.confirm_stop_video_and_navigate_to_screen_get_started)

                    val yesBtnListener = DialogInterface.OnClickListener { _, _ ->
                        loadSchedule(true)
                        btnLogoBottom.isEnabled = true
                        mVideosToPlay.clear()
                    }
                    DialogUtil.createDialogTwoButtons(context = act, message = message, titleLeftButton = player.wellnesssolutions.com.R.string.btn_no,
                            leftButtonClickListener = null, titleRightButton = player.wellnesssolutions.com.R.string.btn_yes, rightButtonClickListener = yesBtnListener).show()
                    return
                }
            } else {
                mVideosToPlay.clear()
            }
        }
        loadSchedule(true)

    }

    private fun setupButtonFloatMenu() {
        mMenuWidth = resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.width_btn_menu_float)
        mMenuHeight = resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.height_btn_menu_float)

        wrapperMenuFloat.setOnClickListener {
            onClickedButtonMenuFloat()
        }

        btnMenuFloat.setOnClickListener {
            onClickedButtonMenuFloat()
        }

        btnCloseMenuFloat.setOnClickListener {
            onClickedButtonMenuFloat()
        }
    }

    private fun onClickedButtonMenuFloat() {
        val startAnim: Boolean =
                when (mIsShownMenu) {
                    true -> mMenuAnimationHelper.startAnim(btnMenuFloat, btnCloseMenuFloat, menuFloat, frameOverlay, isHideFloatMenu = true)
                    else -> mMenuAnimationHelper.startAnim(btnCloseMenuFloat, btnMenuFloat, menuFloat, frameOverlay, isHideFloatMenu = false)
                }
        if (startAnim)
            mIsShownMenu = !mIsShownMenu
    }

    private fun setupFloatMenu() {
        handleClickedFloatMenu()
    }

    private fun handleClickedFloatMenu() {
        frameOverlay.setOnClickListener {
            openNewScreenByMenuItem(it)
        }

        menuFloat.setOnTouchListener { _, _ ->
            hideFloatMenu()
            false
        }

        viewBgGroupControllers.setOnClickListener {
            if (mIsShownMenu)
                openNewScreenByMenuItem(it)
        }

        menuFloat.setOnClickListener {
            openNewScreenByMenuItem(it)
        }

        menuFloat.menuItemHelpMeChoose.setOnClickListener {
            handleSearchFlow(it, HelpMeChooseFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemFindClass.setOnClickListener {
            handleSearchFlow(it, SearchBrandsFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemSearchByInstructor.setOnClickListener {
            handleSearchFlow(it, SearchInstructorsFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemSearchByCollection.setOnClickListener {
            handleSearchFlow(it, SearchCollectionsFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemSearchByLevel.setOnClickListener {
            handleSearchFlow(it, SearchLevelsFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemSearchByDuration.setOnClickListener {
            handleSearchFlow(it, SearchDurationsFragment.TAG)
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
        }

        menuFloat.menuItemTimeTable.setOnClickListener {
            menuFloat.menuItemTimeTable.changeColorOnClick()
            //mVideosToPlay.clear()
            //SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            //HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
            openNewScreenByMenuItem(it)
        }
    }

    private fun handleSearchFlow(view: View, searchScreenTag: String) {
        if (view is MMTextView) {
            view.changeColorOnClick()
        }

        val isSetupNewSearchFlow: Boolean = setupSearchFlowForBrandSearch(searchScreenTag)

        if (!isSetupNewSearchFlow) {
            openNewScreenByMenuItem(view)
        }

        hideFloatMenu()
    }

    private fun setupSearchFlowForBrandSearch(screenTag: String): Boolean {
        val fragments: MutableList<Fragment> = childFragmentManager.fragments
        if (fragments.size == 0) return false

        val lastIndex: Int = fragments.size - 1
        if (lastIndex < 0) return true
        val lastFragment: Fragment = fragments[lastIndex]

        if (lastFragment is SearchBrandsFragment) {
            lastFragment.setSearchFlowTag(screenTag)
            return true
        }

        return false
    }

    private fun openNewScreenByMenuItem(view: View) {
        val searchBrandFlowTag: String =
                when (view.id) {
                    R.id.menuItemHelpMeChoose -> HelpMeChooseFragment.TAG

                    R.id.menuItemFindClass -> SearchBrandsFragment.TAG

                    R.id.menuItemSearchByInstructor -> SearchInstructorsFragment.TAG

                    R.id.menuItemSearchByCollection -> SearchCollectionsFragment.TAG

                    R.id.menuItemSearchByLevel -> SearchLevelsFragment.TAG

                    R.id.menuItemSearchByDuration -> SearchDurationsFragment.TAG

                    R.id.menuItemTimeTable -> {
                        loadTimeTable()
                        TimeTableFragment.TAG // return empty string
                    }

                    else -> "" // return empty string
                }

        if (searchBrandFlowTag.isNotEmpty() && searchBrandFlowTag != TimeTableFragment.TAG)
            mPresenter?.loadBrands(searchBrandFlowTag)

        hideFloatMenu()
    }

    private fun hideFloatMenu() {
        if (mIsShownMenu)
            onClickedButtonMenuFloat()
    }

    private fun loadTimeTable() {
        //if (TimeTableFragment.TAG == mCurrentChildScreenTag) return

        val newFragment: TimeTableFragment = TimeTableFragment.getInstance()
        loadScreen(childFragmentManager, newFragment, TimeTableFragment.TAG)
    }

    private fun loadScreen(fm: FragmentManager, newFragment: Fragment, newTag: String) {
        if (fm.fragments.size == 0) {
            FragmentUtil.addNewFragment(fm, newFragment, R.id.frameLayoutControl)
        } else {
            FragmentUtil.replaceFragment(fm, newFragment, newTag, R.id.frameLayoutControl,
                    isAddToBackStack = true, isRemoveOlds = false)
        }
        mCurrentChildScreenTag = newTag
    }

    /**
     * @IRouterChangedListener
     */
    // connect to TV
    override fun onMediaRouterConnected() {
        super.onMediaRouterConnected()

    }

    // disconnect TV
    override fun onMediaRouterDisconnected() {
        btnPlaylistPresentation?.visibility = View.INVISIBLE
        constraintArrowUp?.visibility = View.INVISIBLE
        constraintArrowDown?.visibility = View.INVISIBLE
        prgTimebarPlaying?.visibility = View.GONE
    }

    // start playing videos on TV or play new videos on TV
    override fun onUpdateVideos(playingVideo: MMVideo, comingVideos: ArrayList<MMVideo>) {
        showPresentationPlayList(playingVideo, comingVideos)
    }

    // clear all videos on TV
    // at now, using the callbacks to run the operation
    // TODO: should use BroadcastReceiver (@CastingBroadcastReceiver class)
    override fun onClearVideos() {
        hidePresentationPlaylist()
        btnPlaylistPresentation?.visibility = View.INVISIBLE
        constraintArrowUp?.visibility = View.INVISIBLE
        constraintArrowDown?.visibility = View.INVISIBLE

    }

    private fun showPresentationPlaylist() {
        constraintArrowUp?.let {
            it.visibility = View.INVISIBLE
        }
        constraintArrowDown?.let {
            it.visibility = View.VISIBLE
        }
        groupViewsComingUpNext?.visibility = View.VISIBLE
        viewPlayList?.visibility = View.VISIBLE
        tvSharingOnTV?.visibility = View.VISIBLE
        tvSharingOnTV?.isEnabled = false
    }

    private fun hidePresentationPlaylist() {
        constraintArrowUp?.let {
            it.visibility = View.VISIBLE
        }
        constraintArrowDown?.let {
            it.visibility = View.INVISIBLE
        }
        groupViewsComingUpNext?.visibility = View.INVISIBLE
        viewPlayList?.visibility = View.INVISIBLE
        tvSharingOnTV?.visibility = View.INVISIBLE
    }

    private fun registerRouterChangedListener() {
        activity?.also {
            if (it is MainActivity) it.addRouterChangedListener(this)
        }
    }

    private fun registerCastingTVBroadcast() {
        // register casting TV (presentation) broadcast receiver
        activity?.also { act ->
            val castingFilter = IntentFilter(CastingBroadcastReceiver.ACTION_TV)
            CastingBroadcastReceiver.getInstance().addListener(this)
            act.registerReceiver(CastingBroadcastReceiver.getInstance(), castingFilter)
        }
    }

    private fun registerScheduleBroadcast() {
        // register casting TV (presentation) broadcast receiver
        activity?.also { _ ->
            ScheduleBroadcastReceiver.getInstance().addListener(this)
        }
    }

    private fun unregisterCastingTVBroadcast() {
        activity?.also { act ->
            if (CastingBroadcastReceiver.getInstance().isRegistered(this)) {
                try {
                    act.unregisterReceiver(CastingBroadcastReceiver.getInstance())
                    CastingBroadcastReceiver.getInstance().removeListener(this)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun unregisterScheduleBroadcast() {

        activity?.also { _ ->
            if (ScheduleBroadcastReceiver.getInstance().isRegistered(this)) {
                try {
                    ScheduleBroadcastReceiver.getInstance().removeListener(this)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun unregisterRouterChangedListener() {
        activity?.also {
            if (it is MainActivity) it.removeRouterChangedListener(this)
        }
    }

    private fun setupButtonPlaylist() {
        //mNowPlayingDownloadButtonManager = DownloadButtonManager(groupViewsComingUpNext.btnDownloadPlaying)
        // var isClicked = false
        groupViewsComingUpNext.tag = false
        btnPlaylistPresentation?.setOnClickListener {
            groupViewsComingUpNext.tag?.also { isVisible ->
                if (isVisible is Boolean) {
                    when (isVisible) {
                        true -> {
                            hidePresentationPlaylist()
                        }
                        else -> {
                            showPresentationPlaylist()
                        }
                    }
                    groupViewsComingUpNext?.tag = !isVisible
                }
            }
            if (isClicked) {
                constraintArrowUp.visibility = View.VISIBLE
                constraintArrowDown.visibility = View.INVISIBLE
            } else {
                constraintArrowUp.visibility = View.INVISIBLE
                constraintArrowDown.visibility = View.VISIBLE
            }
            isClicked = !isClicked
        }

    }

    override fun showPresentationPlayList(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
        //mNowPlayingDownloadButtonManager?.setVideoData(nowPlayVideo)
        view?.also { _ ->
            // show video nowplaying data in group views coming up next
            mExtraNPGCUCollectionViews = GCUDisplayHelper.showPlayingVideoInfo(groupViewsComingUpNext,
                    nowPlayVideo,
                    mExtraNPGCUCollectionViews,
                    mPresenter)
            GCUDisplayHelper.showVideosComingUpNext(comingUpVideos, rvComingUpNext, mPresenter)
        }
        btnPlaylistPresentation?.visibility = View.VISIBLE
        constraintArrowUp?.visibility = View.VISIBLE
        constraintArrowDown?.visibility = View.INVISIBLE
    }

    override fun hideGroupComingUpNext() {
        hidePresentationPlaylist()
    }

    /**
     * @interface CastingBroadcastReceiver.Callback
     */
    private var mVideoPlayingDuration = 1L
    private var mIsVideoPlayingTimebarMinute = true

    override fun onPlayerReady(isShowPlayPauseButton: Boolean, isPlaying: Boolean, currentPosition: Long, duration: Long) {
        // show the pause button in PLAYLIST
        if (isShowPlayPauseButton)
            renderButtonPlayPausePlaylist(isPlaying)
        else
            hidePlayPauseButtonInPlaylist()

        setHeighForGroupViewComingUpNextHasTimebar()

        this.mVideoPlayingDuration = if (duration > 0) duration else 1L
        prgTimebarPlaying?.also { progressBar ->
            progressBar.progress = (currentPosition * 100 / mVideoPlayingDuration).toInt()
            progressBar.visibility = View.VISIBLE
        }

        val strDuration: String = StrUtil.convertTimeValueToString(value = duration / 1000L)
        when (strDuration.length) {
            in 0..4 -> {
                if (!mIsVideoPlayingTimebarMinute) {
                    mIsVideoPlayingTimebarMinute = true
                    setWidthTimeTVByMinuteUnit()
                }
            }

            else -> {
                if (mIsVideoPlayingTimebarMinute) {
                    mIsVideoPlayingTimebarMinute = false
                    setWidthTimeTVByHourUnit()
                }
            }
        }

        tvVideoPlayingPlaylistPosition?.visibility = View.VISIBLE
        tvVideoPlayingPlaylistPosition?.text = StrUtil.convertTimeValueToString(value = currentPosition / 1000L)

        tvVideoPlayingPlaylistDuration?.visibility = View.VISIBLE
        tvVideoPlayingPlaylistDuration?.text = StrUtil.convertTimeValueToString(value = duration / 1000L)


    }

    private fun setWidthTimeTVByMinuteUnit() {
        val width: Int = resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.playlist_video_time_minute_length)

        setWidthForTimeTV(width)
    }

    private fun setWidthTimeTVByHourUnit() {
        val width: Int = resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.playlist_video_time_hour_length)

        setWidthForTimeTV(width)
    }

    private fun setWidthForTimeTV(width: Int) {
        tvVideoPlayingPlaylistPosition?.layoutParams?.also { params ->
            params.width = width
            tvVideoPlayingPlaylistPosition.layoutParams = params
            tvVideoPlayingPlaylistPosition.requestLayout()
        }

        tvVideoPlayingPlaylistDuration?.layoutParams?.also { params ->
            params.width = width
            tvVideoPlayingPlaylistDuration.layoutParams = params
            tvVideoPlayingPlaylistDuration.requestLayout()
        }
    }

    override fun onUpdateProgress(isShowPlayPauseButton: Boolean, isPlaying: Boolean, position: Long) {
        if (isShowPlayPauseButton)
            renderButtonPlayPausePlaylist(isPlaying)
        else
            hidePlayPauseButtonInPlaylist()

        if (mVideoPlayingDuration <= 0L) mVideoPlayingDuration = 1L
        prgTimebarPlaying?.progress = (position * 100 / mVideoPlayingDuration).toInt()
        tvVideoPlayingPlaylistPosition?.text = StrUtil.convertTimeValueToString(value = position / 1000L)
    }

    override fun onUpdateLoadingVideoState() {
        showPauseVideoUIOnPlaylist()
    }

    override fun onUpdateEndedVideoState() {
        showPlayVideoUIOnPlaylist()
        hidePresentationPlaylist()
        btnPlaylistPresentation?.let {
            it.visibility = View.INVISIBLE
        }
        constraintArrowDown?.let {
            it.visibility = View.INVISIBLE
        }
        constraintArrowUp?.let {
            it.visibility = View.INVISIBLE
        }
    }

    override fun onUpdateEndedVideoStateSchedule() {
        showPlayVideoUIOnPlaylist()
        hidePresentationPlaylist()
        btnPlaylistPresentation?.let {
            it.visibility = View.INVISIBLE
        }
        constraintArrowDown?.let {
            it.visibility = View.INVISIBLE
        }
        constraintArrowUp?.let {
            it.visibility = View.INVISIBLE
        }
    }

    override fun onUpdateTranslatedVideoState() {
        showTranslateToAnotherVideoUIOnPlaylist()
    }

    private fun renderButtonPlayPausePlaylist(isPlaying: Boolean) {
        when (isPlaying) {
            true -> showPauseVideoUIOnPlaylist()
            false -> showPlayVideoUIOnPlaylist()
        }

    }

    private fun hidePlayPauseButtonInPlaylist() {
        btnPlayVideoPlaying?.visibility = View.GONE
        btnPauseVideoPlaying?.visibility = View.GONE
    }

    private fun showPlayVideoUIOnPlaylist() {
        btnPlayVideoPlaying?.visibility = View.VISIBLE
        btnPauseVideoPlaying?.visibility = View.GONE
    }

    private fun showPauseVideoUIOnPlaylist() {
        btnPlayVideoPlaying?.visibility = View.GONE
        btnPauseVideoPlaying?.visibility = View.VISIBLE


    }

    private fun showTranslateToAnotherVideoUIOnPlaylist() {
        tvVideoPlayingPlaylistPosition?.visibility = View.GONE
        tvVideoPlayingPlaylistDuration?.visibility = View.GONE
        prgTimebarPlaying?.visibility = View.GONE
        btnPlayVideoPlaying?.visibility = View.GONE
        btnPauseVideoPlaying?.visibility = View.GONE
        setHeightNormalForGroupViewComingUpNext()
    }

    private fun setHeightNormalForGroupViewComingUpNext() {
        groupViewsComingUpNext?.layoutParams?.also { params ->
            params.height = groupViewsComingUpNext.resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.group_coming_up_next_height)
            groupViewsComingUpNext.layoutParams = params
            groupViewsComingUpNext.requestLayout()
        }
    }

    private fun setHeighForGroupViewComingUpNextHasTimebar() {
        groupViewsComingUpNext?.layoutParams?.also { params ->
            params.height = groupViewsComingUpNext.resources.getDimensionPixelSize(player.wellnesssolutions.com.R.dimen.group_coming_up_next_has_playlist_height)
            groupViewsComingUpNext.layoutParams = params
            groupViewsComingUpNext.requestLayout()
        }
    }

    private fun setupButtonPlayPausePlaylist() {
        context?.also {
            val strPrimaryColor = PreferenceHelper.getInstance(it).getString(ConstantPreference.PRIMARY_COLOR, Constant.DEF_PRIMARY_COLOR)
            val primaryColor = Color.parseColor(strPrimaryColor)
            val textColor = ColorUtils.blendARGB(primaryColor, Color.WHITE, 0.2f)
            tvVideoPlayingPlaylistPosition?.setTextColor(textColor)
            tvVideoPlayingPlaylistDuration?.setTextColor(textColor)
        }

        btnPlayVideoPlaying?.setOnClickListener {
            val intent = Intent(CastingBroadcastReceiver.ACTION_UI)
            intent.putExtra(CastingBroadcastReceiver.EXTRA_PLAY_VIDEO, true)
            activity?.sendBroadcast(intent)
        }

        btnPauseVideoPlaying?.setOnClickListener {
            val intent = Intent(CastingBroadcastReceiver.ACTION_UI)
            intent.putExtra(CastingBroadcastReceiver.EXTRA_PAUSE_VIDEO, true)
            activity?.sendBroadcast(intent)
        }
    }

    /**
     * SHOW LOADING BRAND VIEWS
     */

    fun showLoadingBrand() {
        dimBgScreen?.visibility = View.VISIBLE
        boxLoading?.visibility = View.VISIBLE
        progressLoadBrand?.visibility = View.VISIBLE
        tvLoading?.visibility = View.VISIBLE
    }

    fun hideLoadingBrand() {
        dimBgScreen?.visibility = View.GONE
        boxLoading?.visibility = View.GONE
        progressLoadBrand?.visibility = View.GONE
        tvLoading?.visibility = View.GONE
    }

    /**
     * LOAD BRANDS FROM BACKEND
     */
    override fun onLoadingBrands() {
        showLoadingBrand()
    }

    override fun onEndLoadingBrands() {
        hideLoadingBrand()
    }

    override fun onGetBrands(brands: ArrayList<MMBrand>, searchBrandFlowTag: String) {
        val newFragment = SearchBrandsFragment.getInstance(searchBrandFlowTag, brands)
        openNextScreen(newFragment, SearchBrandsFragment.TAG)
    }

    override fun onGetOnlyOneBrand(brand: MMBrand, nextScreenTag: String) {
        OpenSearchScreenByBrand.getFragmentBySearchBrandFlowTag(brand, nextScreenTag)?.also { newFragment ->
            openNextScreen(newFragment, nextScreenTag)
        }
    }

    fun openNextScreen(newFragment: Fragment, newFragmentTag: String) {
        FragmentUtil.replaceFragment(childFragmentManager, newFragment, newFragmentTag,
                R.id.frameLayoutControl, isAddToBackStack = true)

        this.mCurrentChildScreenTag = newFragmentTag
    }

    override fun onLoadBrandsFailed(message: String) {
        MessageUtils.showToast(context, message, R.color.red, isLongTime = true)?.show()
    }


    /**
     * ---------------
     */
    companion object {
        val TAG = "ControlFragment"

        val EXTRA_CHILD_SCREEN_TAG = "EXTRA_CHILD_SCREEN_TAG"
        val EXTRA_BRAND = "EXTRA_BRAND"

        fun getInstance(screenTag: String): ControlFragment {
            val instance = ControlFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA_CHILD_SCREEN_TAG, screenTag)
            instance.arguments = bundle

            return instance
        }

        fun getInstance(brands: ArrayList<MMBrand>, searchBrandFlowTag: String): ControlFragment {
            val instance = ControlFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA_CHILD_SCREEN_TAG, SearchBrandsFragment.TAG)
            bundle.putParcelableArrayList(SearchBrandsFragment.KEY_BRANDS, brands)
            bundle.putString(SearchBrandsFragment.KEY_SEARCH_FLOW, searchBrandFlowTag)
            instance.arguments = bundle

            return instance
        }

        fun getInstance(brand: MMBrand, childScreenTag: String): ControlFragment {
            val instance = ControlFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA_CHILD_SCREEN_TAG, childScreenTag)
            bundle.putParcelable(EXTRA_BRAND, brand)
            instance.arguments = bundle

            return instance
        }
    }
}
