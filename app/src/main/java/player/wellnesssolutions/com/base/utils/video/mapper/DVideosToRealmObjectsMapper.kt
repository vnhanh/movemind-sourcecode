package player.wellnesssolutions.com.base.utils.video.mapper

import io.realm.RealmList
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage
import player.wellnesssolutions.com.network.models.search_result.MMSimpleOption
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.database.model.video.*

object DVideosToRealmObjectsMapper {
    fun mapList(source: ArrayList<MMVideo>, tag: String): RealmList<RealmDVideo> {
        val res = RealmList<RealmDVideo>()
        for (ele: MMVideo in source) {
            res.add(mapObject(ele, tag))
        }
        return res
    }

    private fun mapObject(source: MMVideo, groupTag: String): RealmDVideo {
        val res = RealmDVideo().apply {
            id = source.id
            tag = groupTag
            brandId = source.brandId
            brandTypeLogo = source.brandTypeLogo
            durationId = source.durationId
            durationName = source.durationName
            languageId = source.languageId
            videoName = source.videoName
            presenterId = source.instructorId
            presenterName = source.instructorName
            videoUrl = source.videoUrl
            trailerUrl = source.trailerUrl
            downloadUrl = source.downloadUrl
            thumbnailLargeUrl = source.thumbnailLargeUrl
            thumbnailMediumUrl = source.thumbnailMediumUrl
            thumbnailSmallUrl = source.thumbnailSmallUrl
            videoLength = source.videoLength
            videoSize = source.videoSize
            playTime = source.playTime
        }

        source.languages?.also {
            val languages = RealmList<RealmLanguage>()
            for (ele: MMVideoLanguage in it) {
                languages.add(RealmLanguage().also { realmLanguage ->
                    realmLanguage.id = ele.id
                    realmLanguage.name = ele.name
                })
            }
            res.languages = languages
        }

        source.subtitles?.also {
            val subtitles = RealmList<RealmSubtitle>()
            for (ele: MutableMap.MutableEntry<String, String> in it) {
                subtitles.add(RealmSubtitle(ele.key, ele.value))
            }
            res.subtitles = subtitles
        }

        // convert collections
        source.collections?.also {
            val collections = RealmList<TinyCollectionRealm>()
            for (ele: MMTinyCategory in it) {
                collections.add(convertTinyCollection(ele))
            }
            res.collections = collections
        }

        source.levels?.also {
            val levels = RealmList<TinyOptionRealm>()
            for (ele in it) {
                levels.add(convertTinyOption(ele))
            }
            res.levels = levels
        }

        return res
    }

    private fun convertTinyOption(collection: MMSimpleOption): TinyOptionRealm =
            TinyOptionRealm().apply {
                _id = collection._id
                name = collection.name
            }

    private fun convertTinyCollection(collection: MMTinyCategory): TinyCollectionRealm =
            TinyCollectionRealm().apply {
                _id = collection._id
                name = collection.name
                colorStr = collection.colorStr
            }
}