package player.wellnesssolutions.com.base.utils.video

import android.util.Log
import io.realm.Realm
import io.realm.RealmList
import player.wellnesssolutions.com.base.utils.video.mapper.*
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

    fun saveVideosToDB(data: ArrayList<MMVideo>, tag: String) {
        val realm = Realm.getDefaultInstance()

        try {
            val savedData = VideosToRealmObjectsMapper.mapList(data, tag)
            realm.beginTransaction()
            realm.copyToRealm(savedData)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }


    fun createOrUpdateVideos(data: ArrayList<MMVideo>, tag: String) {
        Log.d("LOG", this.javaClass.simpleName + " createOrUpdateVideos() | videos number: ${data.size}")
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

    fun saveVideosScheduleToDB(data: ArrayList<MMVideo>, tag: String) {
        val realm = Realm.getDefaultInstance()

        try {
            val savedData = VideosScheduleToRealmObjectsMapper.mapList(data, tag)
            realm.beginTransaction()
            realm.copyToRealm(savedData)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun saveDVideosToDB(data: ArrayList<MMVideo>, tag: String) {
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
        val realm = Realm.getDefaultInstance()
        var list = ArrayList<MMVideo>()
        try {
            realm.beginTransaction()
            val result = realm.where(RealmDVideo::class.java)
                    .equalTo("tag", tag)
                    .equalTo("isDownloaded", true)
                    .equalTo("isFailureDownload", true).findAll()
            list = RealmObjectsToDVideosMapper.mapList(result)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return list
    }

    fun readAllDVideosFromDB(tag: String): ArrayList<MMVideo> {
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
        return Pair(size, sizeDownloaded)
    }

    fun deleteDVideosFromDB(tag: String, idVideo: Int): Boolean {
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


}