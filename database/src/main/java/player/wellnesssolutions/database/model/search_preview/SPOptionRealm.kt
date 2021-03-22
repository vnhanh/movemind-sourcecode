package player.wellnesssolutions.database.model.search_preview

import io.realm.RealmList
import io.realm.RealmObject

open class SPOptionRealm : RealmObject() {
    var tag:String?=null
    var brand: BrandRealm?=null
    var searchByData: SPTinyOptionRealm?=null

    var collections:RealmList<SPTinyOptionRealm>?=null
    var durations:RealmList<SPTinyOptionRealm>?=null
    var levels:RealmList<SPTinyOptionRealm>?=null
    var presenters:RealmList<SPTinyOptionRealm>?= null
}