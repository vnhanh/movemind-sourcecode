package player.wellnesssolutions.database.model.help_me_choose

import io.realm.RealmObject

open class AnswerRealm : RealmObject() {
    var id:Int?=null
    var tag:String?=null
    var questionId:Int?=null
    var answer:String?=null
}