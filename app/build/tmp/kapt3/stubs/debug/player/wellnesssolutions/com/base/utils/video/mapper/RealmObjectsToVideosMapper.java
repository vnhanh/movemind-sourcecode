package player.wellnesssolutions.com.base.utils.video.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0004j\b\u0012\u0004\u0012\u00020\u000b`\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\fH\u0002J$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013H\u0002\u00a8\u0006\u0015"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/video/mapper/RealmObjectsToVideosMapper;", "", "()V", "convertListSimpleCollections", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "Lkotlin/collections/ArrayList;", "list", "Lio/realm/RealmList;", "Lplayer/wellnesssolutions/database/model/video/TinyCollectionRealm;", "convertListSimpleOptions", "Lplayer/wellnesssolutions/com/network/models/search_result/MMSimpleOption;", "Lplayer/wellnesssolutions/database/model/video/TinyOptionRealm;", "convertSimpleCollection", "source", "convertSimpleOption", "mapList", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lio/realm/RealmResults;", "Lplayer/wellnesssolutions/database/model/video/VideoEntity;", "mapObject", "app_debug"})
public final class RealmObjectsToVideosMapper {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.utils.video.mapper.RealmObjectsToVideosMapper INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mapList(@org.jetbrains.annotations.NotNull()
    io.realm.RealmResults<player.wellnesssolutions.database.model.video.VideoEntity> source) {
        return null;
    }
    
    private final player.wellnesssolutions.com.network.models.now_playing.MMVideo mapObject(player.wellnesssolutions.database.model.video.VideoEntity source) {
        return null;
    }
    
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> convertListSimpleCollections(io.realm.RealmList<player.wellnesssolutions.database.model.video.TinyCollectionRealm> list) {
        return null;
    }
    
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMSimpleOption> convertListSimpleOptions(io.realm.RealmList<player.wellnesssolutions.database.model.video.TinyOptionRealm> list) {
        return null;
    }
    
    private final player.wellnesssolutions.com.network.models.search_result.MMSimpleOption convertSimpleOption(player.wellnesssolutions.database.model.video.TinyOptionRealm source) {
        return null;
    }
    
    private final player.wellnesssolutions.com.network.models.search_result.MMTinyCategory convertSimpleCollection(player.wellnesssolutions.database.model.video.TinyCollectionRealm source) {
        return null;
    }
    
    private RealmObjectsToVideosMapper() {
        super();
    }
}