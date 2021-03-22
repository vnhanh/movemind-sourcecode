package player.wellnesssolutions.com.ui.fragment_search_videos_by.helper

import android.content.Context
import androidx.annotation.StringRes
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.customize_views.MMOptionTextView.Companion.colorBand
import player.wellnesssolutions.com.common.enums.StyleEnumInner
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment
import player.wellnesssolutions.com.ui.fragment_search_durations.SearchDurationsFragment
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.com.ui.fragment_search_levels.SearchLevelsFragment
import player.wellnesssolutions.com.ui.fragment_search_videos_by.model.SearchByOptionImage

object SearchVideosByHelper {


    fun getSearchByOptions(context: Context, hasLevel: Int = 1): ArrayList<SearchByOption> {
        val list = ArrayList<SearchByOption>()
        var color = "#d7d7d7"
        when (colorBand) {
            1 -> color = "#00C3B3"
            2 -> color = "#FFEB3B"
            else -> color
        }


        list.add(SearchByOptionImage(
                tag = SearchInstructorsFragment.TAG,
                title = getString(context, R.string.screen_svb_item_presenter),
                imageResId = R.drawable.icon_instructor, width = 168, height = 158,
                innerStyle = StyleEnumInner.SQUARE_INNER_CIRCLE,
                bgColorStr = color)
        )
        list.add(SearchByOptionImage(
                tag = SearchCollectionsFragment.TAG, title = getString(context, R.string.screen_svb_item_collection),
                imageResId = R.drawable.icon_collection, width = 168, height = 158,
                innerStyle = StyleEnumInner.SQUARE_INNER_CIRCLE,
                bgColorStr = color)
        )

        if (hasLevel == 1) {
            list.add(SearchByOptionImage(
                    tag = SearchLevelsFragment.TAG,
                    title = getString(context, R.string.screen_svb_item_level),
                    imageResId = R.drawable.icon_level, width = 168, height = 158,
                    innerStyle = StyleEnumInner.SQUARE_INNER_CIRCLE,
                    bgColorStr = color)
            )
        }
        //list.add(SearchByOptionText(tag = SearchLevelsFragment.TAG, title = getString(context, R.string.screen_svb_item_level), content = "III"))
        //list.add(SearchByOptionText(tag = SearchDurationsFragment.TAG, title = getString(context, R.string.screen_svb_item_time), content = "9"))
        list.add(SearchByOptionImage(
                tag = SearchDurationsFragment.TAG,
                title = getString(context, R.string.screen_svb_item_time),
                imageResId = R.drawable.icon_time, width = 168, height = 158,
                innerStyle = StyleEnumInner.SQUARE_INNER_CIRCLE,
                bgColorStr = color)
        )
        return list
    }

    private fun getString(context: Context, @StringRes labelResId: Int): String = context.getString(labelResId)
}