package player.wellnesssolutions.database.model.video

import io.realm.RealmObject

open class TinyCollectionRealm : RealmObject(){
    var _id: Int?= 0
    var name: String?=""
    var colorStr: String?=""
}