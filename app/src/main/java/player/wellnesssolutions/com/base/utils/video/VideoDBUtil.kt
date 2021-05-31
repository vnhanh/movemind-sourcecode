package player.wellnesssolutions.com.base.utils.video

import io.realm.Realm
import io.realm.RealmList
import player.wellnesssolutions.com.base.utils.video.mapper.DVideosToRealmObjectsMapper
import player.wellnesssolutions.com.base.utils.video.mapper.RealmObjectsToDVideosMapper
import player.wellnesssolutions.com.base.utils.video.mapper.RealmObjectsToVideosMapper
import player.wellnesssolutions.com.base.utils.video.mapper.VideosToRealmObjectsMapper
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.database.model.video.RealmDVideo
import player.wellnesssolutions.database.model.video.VideoEntity

object VideoDBUtil {
    fun getVideosFromDB(tag: String, isDelete: Boolean = true): ArrayList<MMVideo> {
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            val result = realm.where(VideoEntity::class.java).equalTo("tag", tag).findAll()
            list = RealmObjectsToVideosMapper.mapList(result)

            if (isDelete) result.deleteAllFromRealm()

            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return list
    }

    fun getVideosFromDBAndSort(tag: String, isDelete: Boolean = true, fieldNameSort: String): ArrayList<MMVideo> {
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            var result = realm.where(VideoEntity::class.java).equalTo("tag", tag).findAll()
            when {
                fieldNameSort.isNotBlank() -> result = result.sort(fieldNameSort)
            }
            list = RealmObjectsToVideosMapper.mapList(result)

            if (isDelete) result.deleteAllFromRealm()

            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return list
    }

    fun getScheduleVideos(): ArrayList<MMVideo> = getVideosFromDBAndSort(tag = Constant.MM_SCHEDULE, isDelete = false, fieldNameSort = "playTime")

    fun createOrUpdateVideos(data: ArrayList<MMVideo>, tag: String) {
//        Log.d("LOG", this.javaClass.simpleName + " createOrUpdateVideos() | videos number: ${data.size} | tag: $tag")
        val realm = Realm.getDefaultInstance()

        try {
            val videoEntities: RealmList<VideoEntity> = VideosToRealmObjectsMapper.mapList(data, tag)
            realm.beginTransaction()
            realm.where(VideoEntity::class.java).equalTo("tag", tag).findAll().deleteAllFromRealm()
            realm.copyToRealm(videoEntities)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun deleteVideosFromDB(tag: String): Boolean {
        var isSuccess = true
        var realm: Realm? = null
        try {
            realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            val result = realm.where(VideoEntity::class.java).equalTo("tag", tag).findAll()
            result.deleteAllFromRealm()

            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
            isSuccess = false
        } finally {
            realm?.close()
        }
        return isSuccess
    }

    fun saveDVideosToDB(data: ArrayList<MMVideo>, tag: String) {
//        Log.d("LOG", this.javaClass.simpleName + " saveDVideosToDB() | tag: $tag")
        val realm = Realm.getDefaultInstance()

        try {
            val savedData: RealmList<RealmDVideo> = DVideosToRealmObjectsMapper.mapList(data, tag)
            realm.beginTransaction()
            realm.copyToRealm(savedData)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun checkVideoAvailable(data: MMVideo, tag: String): Boolean {
//        Log.d("LOG", this.javaClass.simpleName + " checkVideoAvailable() | tag: $tag")
        val realm = Realm.getDefaultInstance()
        return try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("id", data.id)
                    .findFirst()
            realm.commitTransaction()
            result == null

        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            realm.close()
        }
    }

    fun checkVideoDownloaded(data: MMVideo, tag: String): Boolean {
//        Log.d("LOG", this.javaClass.simpleName + " checkVideoDownloaded() | tag: $tag")
        val realm = Realm.getDefaultInstance()
        return try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("id", data.id)
                    .equalTo("isDownloaded", true)
                    .findFirst()
            realm.commitTransaction()
            result != null

        } catch (e: Exception) {
            e.printStackTrace()
            false
        } finally {
            realm.close()
        }
    }

    fun readDVideosFromDB(tag: String): ArrayList<MMVideo> {
//        Log.d("LOG", this.javaClass.simpleName + " readDVideosFromDB() | tag: $tag")
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("isDownloaded", false).findAll()
            list = RealmObjectsToDVideosMapper.mapList(result)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return list
    }

    fun readDVideosFailureFromDB(tag: String): ArrayList<MMVideo> {
//        Log.d("LOG", this.javaClass.simpleName + " readDVideosFailureFromDB() | tag: $tag")
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("isDownloaded", false)
                    .equalTo("isFailureDownload", true).findAll()
            list = RealmObjectsToDVideosMapper.mapList(result)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
//        Log.d("LOG", this.javaClass.simpleName + " readDVideosFailureFromDB() | number: ${list.size}")
        return list
    }

    fun readAllDVideosFromDB(tag: String): ArrayList<MMVideo> {
//        Log.d("LOG", this.javaClass.simpleName + " readAllDVideosFromDB() | tag: ${tag}")
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag).findAll()
            list = RealmObjectsToDVideosMapper.mapList(result)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return list
    }

    fun countRecordInTable(tag: String): Pair<Int, Int> {
//        Log.d("LOG", this.javaClass.simpleName + " countRecordInTable() | tag: $tag")
        val realm = Realm.getDefaultInstance()
        var sizeDownloaded = 0
        var size = 0
        try {
            realm.beginTransaction()
            sizeDownloaded = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("isDownloaded", true).findAll().size
            size = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("isDownloaded", false).findAll().size
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
//        Log.d("LOG", this.javaClass.simpleName + " countRecordInTable() | not downloaded: $size | sizeDownloaded: $sizeDownloaded")
        return Pair(size, sizeDownloaded)
    }

    fun deleteDVideosFromDB(tag: String, idVideo: Int): Boolean {
//        Log.d("LOG", this.javaClass.simpleName + " deleteDVideosFromDB() | tag: $tag | idVideo: $idVideo")
        val realm = Realm.getDefaultInstance()
        var isSuccess = true
        try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java).equalTo("tag", tag)
                    .equalTo("id", idVideo).findFirst()
            result?.let {
                it.deleteFromRealm()
            }
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
            isSuccess = false
        } finally {
            realm.close()
        }
        return isSuccess
    }

    fun updateTabledVideoDownloadedToFalse(videoId: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " updateTabledVideoDownloadedToFalse() | videoId: $videoId")
        val realm = Realm.getDefaultInstance()
        try {
            val data = realm.where(RealmDVideo::class.java).equalTo("id", videoId).findFirst()
            realm.beginTransaction()
            if (data != null) {
                data.isDownloaded = false
                data.isFailureDownload = false
            }
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun updateTabledVideoDownloadedState(videoId: Int) {
//        Log.d("LOG", this.javaClass.simpleName + " updateTabledVideoDownloadedState() | videoId: $videoId")
        val realm = Realm.getDefaultInstance()
        try {
            val data = realm.where(RealmDVideo::class.java).equalTo("id", videoId).findFirst()
            realm.beginTransaction()
            if (data != null) {
                data.isDownloaded = true
                data.isFailureDownload = false
            }
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun deleteAllVideos() {
        var realm: Realm? = null
        try {
            realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            val result = realm.where(VideoEntity::class.java).findAll()
            result.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm?.close()
        }
    }

}