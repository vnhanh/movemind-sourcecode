package player.wellnesssolutions.com.ui.fragment_search_preview.helpers

import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.datasource.videos.SearchVideosRequestOptions
import player.wellnesssolutions.com.network.models.screen_search.*
import player.wellnesssolutions.com.network.models.search_preview.MMSearchPreviewResponse
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption

object SearchPreviewMapper {
    const val MINS = " mins"

    fun mapCollections(list: ArrayList<MMCollection>): ArrayList<SearchedOption> {
        val res = ArrayList<SearchedOption>()
        for (item: MMCollection in list) {
            res.add(SearchedOption(item.id, item.name, Constant.SEARCH_COLLECTION))
        }
        return res
    }

    fun mapInstructors(list: ArrayList<MMInstructor>): ArrayList<SearchedOption> {
        val res = ArrayList<SearchedOption>()
        for (item: MMInstructor in list) {
            res.add(SearchedOption(item.id, item.name, Constant.SEARCH_PRESENTER))
        }
        return res
    }

    fun mapDurations(list: ArrayList<MMDuration>): ArrayList<SearchedOption> {
        val res = ArrayList<SearchedOption>()
        for (item: MMDuration in list) {
            res.add(SearchedOption(item.id, String.format("%s %s", item.title, MINS), Constant.SEARCH_DURATION))
        }
        return res
    }

    fun mapLevels(list: ArrayList<MMLevel>): ArrayList<SearchedOption> {
        val res = ArrayList<SearchedOption>()
        for (item: MMLevel in list) {
            res.add(SearchedOption(item.id, item.name, Constant.SEARCH_LEVEL))
        }
        return res
    }

    fun processChosenOption(id: Int, name: String?, typeId: Int, chosenOptions: SPSearchedOption) {
        when (typeId) {
            Constant.SEARCH_COLLECTION -> {
                addOrRemoveChosenOption(id, name, typeId, chosenOptions.collections)
            }
            Constant.SEARCH_PRESENTER -> {
                addOrRemoveChosenOption(id, name, typeId, chosenOptions.instructors)
            }
            Constant.SEARCH_LEVEL -> {
                addOrRemoveChosenOption(id, name, typeId, chosenOptions.levels)
            }
            Constant.SEARCH_DURATION -> {
                addOrRemoveChosenOption(id, name, typeId, chosenOptions.durations)
            }
        }
    }

    private fun addOrRemoveChosenOption(id: Int, name: String?, typeId: Int, list: ArrayList<SearchedOption>) {
        val index = isOptionSelected(id, list)
        if (index >= 0) {
            list.removeAt(index)
            return
        }
        list.add(SearchedOption().also {
            it.id = id
            it.name = name
            it.typeOptionId = typeId
        })
    }

    fun isOptionSelected(id: Int, list: ArrayList<SearchedOption>): Int {
        val size = list.size
        for (i in 0 until size) {
            if (list[i].id == id)
                return i
        }
        return -1
    }

    // TODO: replace addAll() by "="
    fun scanChosenOptions(scannedData: SPSearchedOption, sourceData: SPSearchedOption): SPSearchedOption {
        val res = SPSearchedOption()
        scannedData.brand?.also { sourceBrand ->
            res.brand = MMBrand(sourceBrand.id, sourceBrand.name, sourceBrand.description, sourceBrand.hasLevel, sourceBrand.helperText, sourceBrand.image, sourceBrand.logo)
        }

        scannedData.searchByData?.also { sourceSearchByData ->
            res.searchByData = SearchedOption(sourceSearchByData.id, sourceSearchByData.name, sourceSearchByData.typeOptionId)
        }

        res.collections.addAll(scannedData.collections)
        res.instructors.addAll(scannedData.instructors)
        res.levels.addAll(scannedData.levels)
        res.durations.addAll(scannedData.durations)

        if (res.collections.size == 0) {
            res.collections.addAll(sourceData.collections)
        } else if (res.levels.size == 0) {
            res.levels.addAll(sourceData.levels)
        } else if (res.durations.size == 0) {
            res.durations.addAll(sourceData.durations)
        } else if (res.instructors.size == 0) {
            res.instructors.addAll(sourceData.instructors)
        }

        return res
    }

    fun parseVideosSearchResultResponse(searchPreviewResponse: MMSearchPreviewResponse, showUIData: SPShowedUIData): SPSearchedOption {
        val parsedData = SPSearchedOption()

        searchPreviewResponse.collections?.also {
            parsedData.collections = mapCollections(it)
            showUIData.collections = searchPreviewResponse.collections
        }

        searchPreviewResponse.instructors?.also {
            parsedData.instructors = mapInstructors(it)
            showUIData.instructors = searchPreviewResponse.instructors
        }

        searchPreviewResponse.durations?.also {
            parsedData.durations = mapDurations(it)
            showUIData.durations = parsedData.durations
        }

        searchPreviewResponse.levels?.also {
            parsedData.levels = mapLevels(it)
            showUIData.levels = parsedData.levels
        }

        return parsedData
    }

    /**
     * For Presenter
     */
    fun getOptionsMapForRequestApi(input: SPSearchedOption): SearchVideosRequestOptions {
        val map = SearchVideosRequestOptions()

        map.collections = addOptionToMap(input.collections)
        map.instructors = addOptionToMap(input.instructors)
        map.durations = addOptionToMap(input.durations)
        map.levels = addOptionToMap(input.levels)

        return map
    }

    fun addOptionToMap(items: ArrayList<SearchedOption>): ArrayList<Int> {
        val res = ArrayList<Int>()
        for (item in items) {
            res.add(item.id ?: 0)
        }
        return res
    }

}