package player.wellnesssolutions.com.ui.fragment_search_preview.helpers

import io.realm.Realm
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption
import player.wellnesssolutions.database.model.search_preview.SPOptionRealm

object SPDBUtil {
    fun saveToDB(data: SPSearchedOption, tag: String) {
        val realm = Realm.getDefaultInstance()

        try {
            val realmData = SPDBMapper.mapToModelRealm(data, tag)
            realm.beginTransaction()
            realm.copyToRealm(realmData)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun readFromDB(tag: String): SPSearchedOption {
        val realm = Realm.getDefaultInstance()
        var result = SPSearchedOption()
        try {
            realm.beginTransaction()
            val realmData = realm.where(SPOptionRealm::class.java).equalTo("tag", tag).findAll()
            result = SPDBMapper.mapToData(realmData)
            //realmData.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
        return result
    }

    fun deleteAllFromTag(tag: String) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val realmData = realm.where(SPOptionRealm::class.java).equalTo("tag", tag).findAll()
            realmData.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }
}