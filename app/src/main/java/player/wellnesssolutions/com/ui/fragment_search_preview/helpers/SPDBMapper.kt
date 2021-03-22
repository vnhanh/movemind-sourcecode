package player.wellnesssolutions.com.ui.fragment_search_preview.helpers

import io.realm.RealmList
import io.realm.RealmResults
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.database.model.search_preview.BrandRealm
import player.wellnesssolutions.database.model.search_preview.SPOptionRealm
import player.wellnesssolutions.database.model.search_preview.SPTinyOptionRealm

object SPDBMapper {
    fun mapToData(data: RealmResults<SPOptionRealm>): SPSearchedOption =
            SPSearchedOption().also {
                it.brand = mapToBrand(data[0]?.brand)
                it.searchByData = mapToTinySPOptionModel(data[0]?.searchByData)
                it.collections = mapToTinySPOptionList(data[0]?.collections)
                it.instructors = mapToTinySPOptionList(data[0]?.presenters)
                it.levels = mapToTinySPOptionList(data[0]?.levels)
                it.durations = mapToTinySPOptionList(data[0]?.durations)
            }

    fun mapToBrand(data: BrandRealm?): MMBrand =
            MMBrand(data?.id, data?.name, data?.description, data?.hasLevel, data?.helperText, data?.image, data?.logo)

    fun mapToTinySPOptionModel(data: SPTinyOptionRealm?): SearchedOption =
            SearchedOption(data?.id, data?.name, data?.typeOptionId)

    fun mapToTinySPOptionList(list: RealmList<SPTinyOptionRealm>?): ArrayList<SearchedOption> {
        val result = ArrayList<SearchedOption>()
        list?.also { data ->
            for (ele in data) {
                result.add(mapToTinySPOptionModel(ele))
            }
        }
        return result
    }

    fun mapToModelRealm(data: SPSearchedOption, tag: String): SPOptionRealm =
            SPOptionRealm().also {
                it.tag = tag
                it.brand = mapToBrandRealm(data.brand)
                it.searchByData = mapToTinyOptionRealm(data.searchByData)
                it.collections = mapToTinyOptionRealmList(data.collections)
                it.presenters = mapToTinyOptionRealmList(data.instructors)
                it.levels = mapToTinyOptionRealmList(data.levels)
                it.durations = mapToTinyOptionRealmList(data.durations)
            }

    fun mapToBrandRealm(data: MMBrand?): BrandRealm =
            BrandRealm().also {
                it.id = data?.id
                it.name = data?.name
                it.description = data?.description
                it.hasLevel = data?.hasLevel
                it.helperText = data?.helperText
                it.image = data?.image
                it.logo = data?.logo
            }

    fun mapToTinyOptionRealm(data: SearchedOption?): SPTinyOptionRealm =
            SPTinyOptionRealm().also {
                it.id = data?.id
                it.name = data?.name
                it.typeOptionId = data?.typeOptionId
            }

    fun mapToTinyOptionRealmList(list: ArrayList<SearchedOption>): RealmList<SPTinyOptionRealm> {
        val result = RealmList<SPTinyOptionRealm>()
        for (ele in list) {
            result.add(mapToTinyOptionRealm(ele))
        }
        return result
    }
}