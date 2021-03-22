package player.wellnesssolutions.database.manager

import io.realm.Realm
import player.wellnesssolutions.database.model.download.DownloadedFile
import player.wellnesssolutions.database.model.video.RealmDVideo

class DownloadDBManager : IProgressListener {
    override fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String) {
        if (isSuccess) {
            writeFileDownloaded(videoId)
            updateTabledVideoDownloaded(videoId)
        }
    }

    override fun updateVideoIdWhenDownloadFailed(videoId: Int) {
        super.updateVideoIdWhenDownloadFailed(videoId)
        updateTabledVideoDownloadedFailure(videoId)
    }

    private fun updateTabledVideoDownloaded(videoId: Int) {
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

    private fun updateTabledVideoDownloadedFailure(videoId: Int) {
        val realm = Realm.getDefaultInstance()
        try {
            val data = realm.where(RealmDVideo::class.java).equalTo("id", videoId).findFirst()
            realm.beginTransaction()
            if (data != null) {
                data.isDownloaded = true
                data.isFailureDownload = true
            }
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun clearAll() {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val result = realm.where(DownloadedFile::class.java).findAll()
            val resultD = realm.where(RealmDVideo::class.java).findAll()
            result.deleteAllFromRealm()
            resultD.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    private fun writeFileDownloaded(videoId: Int) {
        val realm = Realm.getDefaultInstance()
        try {
            val data = DownloadedFile().also {
                it.videoId = videoId
            }
            realm.beginTransaction()
            realm.copyToRealm(data)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun findData(videoId: Int?): Boolean {
        if (videoId == null) return false
        var isExisted = false
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val result = realm.where(DownloadedFile::class.java).equalTo("videoId", videoId).findFirst()
            isExisted = result != null
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
        return isExisted
    }

    companion object {
        private val INSTANCE: DownloadDBManager = DownloadDBManager()
        fun getInstance(): DownloadDBManager = INSTANCE
    }
}