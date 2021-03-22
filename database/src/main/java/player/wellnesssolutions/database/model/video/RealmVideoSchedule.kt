package player.wellnesssolutions.database.model.video

import io.realm.RealmList
import io.realm.RealmObject

open class RealmVideoSchedule : RealmObject(){
    var id : Int? = null
    var tag : String? = ""
    var brandId : Int? = null
    var brandTypeLogo : String? = null
    var durationId : Int? = null
    var durationName : String? = null
    var languageId : Int? = null
    var videoName : String? = null
    var presenterId : Int? = null
    var presenterName : String? = null
    var videoUrl : String? = null
    var trailerUrl : String? = null
    var thumbnailLargeUrl : String? = null
    var thumbnailMediumUrl : String? = null
    var thumbnailSmallUrl : String? = null
    var videoLength : Float? = null
    var videoSize : Long? = null
    var playTime : String? = null
    var downloadUrl : String? = null
    var languages : RealmList<RealmLanguage>? = null
    var subtitles : RealmList<RealmSubtitle>? = null
    var collections : RealmList<TinyCollectionRealm>? = null
    var levels : RealmList<TinyOptionRealm>? = null
}