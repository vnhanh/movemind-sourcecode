package player.wellnesssolutions.com.base.utils.video.mapper

import io.realm.RealmList
import io.realm.RealmResults
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage
import player.wellnesssolutions.com.network.models.search_result.MMSimpleOption
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory
import player.wellnesssolutions.database.model.video.RealmLanguage
import player.wellnesssolutions.database.model.video.TinyCollectionRealm
import player.wellnesssolutions.database.model.video.TinyOptionRealm
import player.wellnesssolutions.database.model.video.VideoEntity

object RealmObjectsToVideosMapper {
    fun mapList(source: RealmResults<VideoEntity>): ArrayList<MMVideo> {
        val res = ArrayList<MMVideo>()

        for (ele: VideoEntity in source) {
            res.add(mapObject(ele))
        }
        return res
    }

    private fun mapObject(source: VideoEntity): MMVideo {
        val res = MMVideo().apply {
            id = source.id
            brandId = source.brandId
            brandTypeLogo = source.brandTypeLogo
            durationId = source.durationId
            durationName = source.durationName
            languageId = source.languageId
            videoName = source.videoName
            instructorId = source.presenterId
            instructorName = source.presenterName
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
            val languages = ArrayList<MMVideoLanguage>()
            for (ele: RealmLanguage in it) {
                languages.add(MMVideoLanguage(id = ele.id, name = ele.name))
            }
            res.languages = languages
        }

        source.subtitles?.also {
            val subtitles = HashMap<String, String>()
            for (ele in it) {
                if (ele.id != null && ele.link != null) subtitles.put(ele.id!!, ele.link!!)
            }
            res.subtitles = subtitles
        }

        // convert collections
        source.collections?.also {
            res.collections = convertListSimpleCollections(it)
        }

        source.levels?.also {
            res.levels = convertListSimpleOptions(it)
        }

        return res
    }

    private fun convertListSimpleCollections(list: RealmList<TinyCollectionRealm>): ArrayList<MMTinyCategory> {
        val result = ArrayList<MMTinyCategory>()

        for (ele: TinyCollectionRealm in list) {
            result.add(convertSimpleCollection(ele))
        }

        return result
    }

    private fun convertListSimpleOptions(list: RealmList<TinyOptionRealm>): ArrayList<MMSimpleOption> {
        val result = ArrayList<MMSimpleOption>()

        for (ele: TinyOptionRealm in list) {
            result.add(convertSimpleOption(ele))
        }

        return result
    }

    private fun convertSimpleOption(source: TinyOptionRealm): MMSimpleOption = MMSimpleOption().apply {
        _id = source._id
        name = source.name
    }

    private fun convertSimpleCollection(source: TinyCollectionRealm): MMTinyCategory = MMTinyCategory().apply {
        _id = source._id
        name = source.name
        colorStr = source.colorStr
    }
}