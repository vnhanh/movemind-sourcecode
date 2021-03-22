package player.wellnesssolutions.com.base.utils.search_util

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom
import player.wellnesssolutions.com.base.uis.BaseClickableAdapter
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_control.ControlFragment
import player.wellnesssolutions.com.ui.fragment_help_me_choose.HelpMeChooseFragment
import player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment

object SearchUIHelper {

    fun showItemsOnRecyclerView(recyclerView: RecyclerViewCustom?, adapter: BaseSearchVideosAdapter<*, *, *>) {
        if (recyclerView == null) return
        recyclerView.adapter?.also {
            if (it is BaseClickableAdapter<*, *, *>) {
                it.release()
            }
        }
        recyclerView.setHasFixedSize(true)
        setGridLayoutDefault(recyclerView, adapter.list.size, adapter.maxItemCountInRow, adapter.maxRowCount)
        recyclerView.setCustomAdapter(adapter)
    }

    private fun setGridLayoutDefault(recyclerView: RecyclerView, childCount: Int, maxColSpan: Int, maxRowSpan: Int) {
        if (childCount < 1) return

        if (childCount <= maxColSpan) {
            recyclerView.layoutManager = GridLayoutManager(recyclerView.context, childCount, RecyclerView.VERTICAL, false)
        } else if (childCount <= maxColSpan * maxRowSpan) {
            recyclerView.layoutManager = GridLayoutManager(recyclerView.context, maxColSpan, RecyclerView.VERTICAL, false)
        } else {
            recyclerView.layoutManager = GridLayoutManager(recyclerView.context, maxRowSpan, GridLayoutManager.HORIZONTAL, false)
        }
    }

    fun onOpenNextScreen(parentFragment: Fragment, data: MMBrand, nextScreenTag: String, currentFragmentTag: String) {
        val fragment: Fragment
        val newTag: String

        when (nextScreenTag) {
            SearchVideosByFragment.TAG -> {
                fragment = SearchVideosByFragment.getInstance(data)
                newTag = SearchVideosByFragment.TAG
            }

            SearchInstructorsFragment.TAG -> {
                fragment = SearchInstructorsFragment.getInstance(data)
                newTag = SearchInstructorsFragment.TAG
            }

            SearchCollectionsFragment.TAG -> {
                fragment = SearchCollectionsFragment.getInstance(data)
                newTag = SearchCollectionsFragment.TAG
            }

            SearchLevelsFragment.TAG -> {
                fragment = SearchLevelsFragment.getInstance(data)
                newTag = SearchLevelsFragment.TAG
            }

            SearchDurationsFragment.TAG -> {
                fragment = SearchDurationsFragment.getInstance(data)
                newTag = SearchDurationsFragment.TAG
            }

            HelpMeChooseFragment.TAG -> {
                fragment = HelpMeChooseFragment.getInstance(data)
                newTag = HelpMeChooseFragment.TAG
            }

            else -> return
        }

        if (parentFragment is ControlFragment)
            parentFragment.mCurrentChildScreenTag = newTag

        FragmentUtil.replaceFragment(parentFragment.childFragmentManager, fragment, newTag, R.id.frameLayoutControl, isAddToBackStack = true)

        if (parentFragment is ControlFragment)
            parentFragment.mCurrentChildScreenTag = newTag
    }
}