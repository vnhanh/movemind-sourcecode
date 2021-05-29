package player.wellnesssolutions.com.ui.fragment_search_videos_by.model

import androidx.annotation.DrawableRes
import player.wellnesssolutions.com.common.enums.StyleEnumInner
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption

class SearchByOptionImage(
        tag: String,
        title: String,
        @DrawableRes val imageResId: Int = -1,
        val width: Int,
        val height: Int,
        val innerStyle: StyleEnumInner,
        val bgColorStr: String = "#ffffff"
) : SearchByOption(tag, title)