package player.wellnesssolutions.com.ui.fragment_search_brands.module

import androidx.fragment.app.Fragment
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_help_me_choose.HelpMeChooseFragment
import player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.SearchVideosByFragment

object OpenSearchScreenByBrand {
    fun getFragmentBySearchBrandFlowTag(brand: MMBrand, flowSearchTag: String): Fragment? =
            when (flowSearchTag) {
                SearchVideosByFragment.TAG -> SearchVideosByFragment.getInstance(brand)
                HelpMeChooseFragment.TAG -> HelpMeChooseFragment.getInstance(brand)
                SearchInstructorsFragment.TAG -> SearchInstructorsFragment.getInstance(brand)
                SearchCollectionsFragment.TAG -> SearchCollectionsFragment.getInstance(brand)
                SearchLevelsFragment.TAG -> SearchLevelsFragment.getInstance(brand)
                SearchDurationsFragment.TAG -> SearchDurationsFragment.getInstance(brand)
                else -> null
            }
}