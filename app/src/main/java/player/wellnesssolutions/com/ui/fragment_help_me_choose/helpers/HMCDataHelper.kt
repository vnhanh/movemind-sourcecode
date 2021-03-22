package player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers

import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.database.model.help_me_choose.AnswerRealm

object HMCDataHelper {
    fun mapToRealmList(list: ArrayList<MMHelpMeChooseAnswer>, tag: String): RealmList<AnswerRealm> {
        val result = RealmList<AnswerRealm>()
        for (ele in list) {
            result.add(mapToAnswerRealm(ele, tag))
        }
        return result
    }

    fun mapToAnswerRealm(answer: MMHelpMeChooseAnswer, tag: String): AnswerRealm =
            AnswerRealm().also {
                it.id = answer.id
                it.tag = tag
                it.questionId = answer.questionId
                it.answer = answer.answer
            }

    fun mapToListModel(realmResult: RealmResults<AnswerRealm>): ArrayList<MMHelpMeChooseAnswer> {
        val result = ArrayList<MMHelpMeChooseAnswer>()
        for (item in realmResult) {
            result.add(mapToAnswerModel(item))
        }
        return result
    }

    fun mapToAnswerModel(data: AnswerRealm): MMHelpMeChooseAnswer =
            MMHelpMeChooseAnswer(data.id, data.questionId, data.answer)

    fun saveToDB(list: ArrayList<MMHelpMeChooseAnswer>, tag: String) {
        val realm = Realm.getDefaultInstance()

        try {
            val realmList = mapToRealmList(list, tag)
            realm.beginTransaction()
            realm.copyToRealm(realmList)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }

    fun readDB(tag: String): ArrayList<MMHelpMeChooseAnswer> {
        var list: ArrayList<MMHelpMeChooseAnswer>
        val realm = Realm.getDefaultInstance()

        try {
            realm.beginTransaction()
            val realmResult = realm.where(AnswerRealm::class.java).equalTo("tag", tag).findAll()
            list = mapToListModel(realmResult)
            //realmResult.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
            list = ArrayList()
        } finally {
            realm.close()
        }
        return list
    }

    fun deleteALlFromTag(tag: String) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            val realmResult = realm.where(AnswerRealm::class.java).equalTo("tag", tag).findAll()
            realmResult.deleteAllFromRealm()
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }
}