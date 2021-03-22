package player.wellnesssolutions.com.ui.fragment_control.helpers

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.ui.fragment_no_class.NoClassFragment
import player.wellnesssolutions.com.ui.fragment_search_brands.SearchBrandsFragment
import player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment

object ChildFragmentManager {
    fun createOrInputNewDataForFragment(fm: FragmentManager, @IdRes frameId: Int, childTag: String, bundle: Bundle?) {
        var childFragment = fm.findFragmentByTag(childTag)
        childFragment =
                when (childFragment != null) {
                    true -> {
                        childFragment.arguments = bundle
                        childFragment
                    }

                    false -> {
                        getNewChildInstance(childTag)
                    }
                }


        FragmentUtil.replaceFragment(fm = fm, newFragment = childFragment, newFragmentTag = childTag, frameId = frameId, isAddToBackStack = true)
    }

    private fun getNewChildInstance(childTag: String): Fragment =
            when (childTag) {
                TimeTableFragment.TAG -> TimeTableFragment.getInstance()
                NoClassFragment.TAG -> NoClassFragment.getInstance()

                else -> SearchBrandsFragment.getInstance(SearchBrandsFragment.TAG)
            }

}