package player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers

import android.widget.TextView
import player.wellnesssolutions.com.base.customs.CustomPageAdapter
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.SearchResultPageFragment

object SearchResultDisplayHelper {
    val VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE = 11

    fun showChosenOptionText(tv: TextView, chosenOptions: SPSearchedOption?) {
        if (chosenOptions == null) return

        val builder = StringBuilder()
        builder.append(chosenOptions.brand?.name ?: "".toUpperCase())
        builder.append(getChosenText(chosenOptions, Constant.SEARCH_PRESENTER))
        builder.append(getChosenText(chosenOptions, Constant.SEARCH_COLLECTION))
        builder.append(getChosenText(chosenOptions, Constant.SEARCH_LEVEL))
        builder.append(getChosenText(chosenOptions, Constant.SEARCH_DURATION))

        tv.text = builder.toString()
    }

    private fun getChosenText(data: SPSearchedOption, typeId: Int): String {
        val builder = StringBuilder()
        if (data.searchByData?.typeOptionId == typeId)
            builder.append(String.format(" - %s", data.searchByData?.name ?: "".toUpperCase()))

        val items: ArrayList<SearchedOption> =
                when (typeId) {
                    Constant.SEARCH_PRESENTER -> data.instructors
                    Constant.SEARCH_COLLECTION -> data.collections
                    Constant.SEARCH_LEVEL -> data.levels
                    Constant.SEARCH_DURATION -> data.durations
                    else -> ArrayList()
                }

        if (items.size > 0) {
            for (item: SearchedOption in items) {
                val str: String = String.format(" - %s", item.name ?: "".toUpperCase())
                builder.append(str)
            }
        }

        return builder.toString()
    }

    fun processShowData(showData: ArrayList<MMVideo>, pageAdapter: CustomPageAdapter, presenter: ISearchResultContract.Presenter?) {
        var index = 0
        val lastIndex = showData.size - 1

        // create PageFragment show search result
        while (index * VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE <= lastIndex) {

            val pageFragment: SearchResultPageFragment = SearchResultPageFragment.getInstance(index)
            pageAdapter.addPage(pageFragment)

            index++
        }
    }

    fun processShowData(showData: ArrayList<MMVideo>): ArrayList<MMSearchResultRootPage> {
        var index = 0
        val lastIndex = showData.size - 1

        val list = ArrayList<MMSearchResultRootPage>()


        // create PageFragment show search result
        while (index * VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE <= lastIndex) {
            val listVideo = ArrayList<MMVideo>()
            val begin = index * VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE
            val endIndex = Math.min(showData.size - 1, begin + VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE - 1)

            for (i in begin..endIndex) {
                listVideo.add(showData[i])
            }

            val listRoot = MMSearchResultRootPage(listVideo)

            list.add(listRoot)


            index++
        }

        return list
    }

    fun splitItemsByPage(startIndex: Int, itemCountInOnePage: Int, data: ArrayList<MMVideo>): ArrayList<MMVideo> {
        val output = ArrayList<MMVideo>()
        val lastIndex = data.size - 1
        val endIndex = Math.min(lastIndex, startIndex + itemCountInOnePage - 1)
        for (i: Int in startIndex..endIndex) {
            output.add(data[i])
        }

        return output
    }
}