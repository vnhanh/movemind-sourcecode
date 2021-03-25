package player.wellnesssolutions.com.base.utils.video.mapper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0002J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\u00a8\u0006\u0015"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/video/mapper/VideosToRealmObjectsMapper;", "", "()V", "convertTinyCollection", "Lplayer/wellnesssolutions/database/model/video/TinyCollectionRealm;", "collection", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "convertTinyOption", "Lplayer/wellnesssolutions/database/model/video/TinyOptionRealm;", "Lplayer/wellnesssolutions/com/network/models/search_result/MMSimpleOption;", "mapList", "Lio/realm/RealmList;", "Lplayer/wellnesssolutions/database/model/video/VideoEntity;", "source", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "tag", "", "mapObject", "groupTag", "app_debug"})
public final class VideosToRealmObjectsMapper {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.utils.video.mapper.VideosToRealmObjectsMapper INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<player.wellnesssolutions.database.model.video.VideoEntity> mapList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> source, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    private final player.wellnesssolutions.database.model.video.VideoEntity mapObject(player.wellnesssolutions.com.network.models.now_playing.MMVideo source, java.lang.String groupTag) {
        return null;
    }
    
    private final player.wellnesssolutions.database.model.video.TinyOptionRealm convertTinyOption(player.wellnesssolutions.com.network.models.search_result.MMSimpleOption collection) {
        return null;
    }
    
    private final player.wellnesssolutions.database.model.video.TinyCollectionRealm convertTinyCollection(player.wellnesssolutions.com.network.models.search_result.MMTinyCategory collection) {
        return null;
    }
    
    private VideosToRealmObjectsMapper() {
        super();
    }
}