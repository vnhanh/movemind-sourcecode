package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.layout_float_menu.view.*
import player.wellnesssolutions.com.common.customize_views.MMTextView
import player.wellnesssolutions.com.ui.fragment_control.helpers.MMMenuAnimationHelper
import player.wellnesssolutions.com.ui.fragment_help_me_choose.HelpMeChooseFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment
import java.lang.ref.WeakReference

class NowPlayingFloatMenuHelper() {
    // the handler for process all animations related to show and close menu
    private lateinit var mAnimHelper: MMMenuAnimationHelper

    // weak reference of "Close Menu" button
    private lateinit var mWeakCloseButton: WeakReference<ImageView>

    // flag check if menu is showing or not
    private var mIsShowFloatMenu = false

    fun onInit() {
        mAnimHelper = MMMenuAnimationHelper()
        mAnimHelper.restart()
        mIsShowFloatMenu = false
    }

    private fun onClickedButtonMenuFloat(showButton: ImageView, closeButton: ImageView, floatMenu: View, menuFrame: View) {
        val startAnim: Boolean =
                when (mIsShowFloatMenu) {
                    true -> mAnimHelper.startAnim(showButton, closeButton, floatMenu, menuFrame, isHideFloatMenu = true)
                    else -> mAnimHelper.startAnim(closeButton, showButton, floatMenu, menuFrame, isHideFloatMenu = false)
                }
        if (startAnim)
            mIsShowFloatMenu = !mIsShowFloatMenu
    }

    fun setupFloatMenu(showButton: ImageView, closeButton: ImageView, wrapperButonMenu: View, floatMenu: View, menuFrame: View, viewBgGroupControls: View,
                       presenter: INowPlayingConstruct.Presenter?) {
        showButton.setOnClickListener {
            onClickedButtonMenuFloat(showButton, closeButton, floatMenu, menuFrame)
        }

        mWeakCloseButton = WeakReference(closeButton)

        closeButton.setOnClickListener {
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)
        }

        wrapperButonMenu.setOnClickListener {
            onClickedButtonMenuFloat(showButton, closeButton, floatMenu, menuFrame)
        }

        menuFrame.setOnClickListener {
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)
        }

        floatMenu.setOnTouchListener { _, _ ->
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)
            false
        }

        viewBgGroupControls.setOnClickListener {
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)
        }

        floatMenu.setOnClickListener {
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)
        }

        setupMenuItemClickedListener(floatMenu.menuItemTimeTable, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemHelpMeChoose, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemFindClass, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemSearchByInstructor, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemSearchByCollection, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemSearchByLevel, showButton, closeButton, floatMenu, menuFrame, presenter)
        setupMenuItemClickedListener(floatMenu.menuItemSearchByDuration, showButton, closeButton, floatMenu, menuFrame, presenter)
    }

    private fun setupMenuItemClickedListener(view: View, showButton: ImageView, closeButton: ImageView, floatMenu: View, menuFrame: View, presenter: INowPlayingConstruct.Presenter?) {
        view.setOnClickListener {
            if (view is MMTextView) {
                view.changeColorOnClick()
            }

            it.isEnabled = false

            val screenTag: String =
                    when (view.id) {
                        floatMenu.menuItemTimeTable.id -> TimeTableFragment.TAG
                        floatMenu.menuItemHelpMeChoose.id -> HelpMeChooseFragment.TAG
                        floatMenu.menuItemFindClass.id -> SearchBrandsFragment.TAG
                        floatMenu.menuItemSearchByInstructor.id -> SearchInstructorsFragment.TAG
                        floatMenu.menuItemSearchByCollection.id -> SearchCollectionsFragment.TAG
                        floatMenu.menuItemSearchByLevel.id -> SearchLevelsFragment.TAG
                        floatMenu.menuItemSearchByDuration.id -> SearchDurationsFragment.TAG
                        else -> ""
                    }

            it.isEnabled = true
            hideFloatMenu(showButton, closeButton, floatMenu, menuFrame)

            if (screenTag == TimeTableFragment.TAG) {
                presenter?.openTimeTableScreen()
            } else if (screenTag.isNotEmpty()) {
                presenter?.loadBrands(tag = screenTag)
            }

//            SearchResultFragment.mVideosToPlay.clear()
//            SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
//            HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())

        }
    }

    private fun hideFloatMenu(showButton: ImageView, closeButton: ImageView, floatMenu: View, menuFrame: View) {
        if (mIsShowFloatMenu) {
            onClickedButtonMenuFloat(showButton, closeButton, floatMenu, menuFrame)
        }
    }

    fun isFloatMenuIsOpening(): Boolean = mIsShowFloatMenu && mWeakCloseButton.get()?.visibility == View.VISIBLE

    fun closeFloatMenu() {
        if (isFloatMenuIsOpening())
            mWeakCloseButton.get()?.performClick()
    }

    fun onRelease() {
        mAnimHelper.release()
    }
}