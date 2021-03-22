package player.wellnesssolutions.database.model.search_preview

import io.realm.RealmObject

open class BrandRealm : RealmObject() {
    var id:Int?=null
    var name:String?=null
    var description:String?=null
    var hasLevel:Int?=null
    var helperText:String?=null
    var image:String?=null
    var logo:String?=null
}