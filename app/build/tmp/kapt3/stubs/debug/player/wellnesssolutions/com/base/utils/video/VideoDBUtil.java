package player.wellnesssolutions.com.base.utils.video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\r\u001a\u00020\u000e2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u0019\u001a\u00020\u000e2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u001a\u001a\u00020\u000e2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\u001b\u001a\u00020\u000e2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00102\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\f\u00a8\u0006\u001e"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/video/VideoDBUtil;", "", "()V", "checkVideoAvailable", "", "data", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "tag", "", "checkVideoDownloaded", "countRecordInTable", "Lkotlin/Pair;", "", "createOrUpdateVideos", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "deleteDVideosFromDB", "idVideo", "deleteVideosFromDB", "getVideosFromDB", "isDelete", "readAllDVideosFromDB", "readDVideosFailureFromDB", "readDVideosFromDB", "saveDVideosToDB", "saveVideosScheduleToDB", "saveVideosToDB", "updateTabledVideoDownloadedToFalse", "videoId", "app_debug"})
public final class VideoDBUtil {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.utils.video.VideoDBUtil INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideosFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, boolean isDelete) {
        return null;
    }
    
    public final void saveVideosToDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void createOrUpdateVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final boolean deleteVideosFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return false;
    }
    
    public final void saveVideosScheduleToDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final void saveDVideosToDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public final boolean checkVideoAvailable(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return false;
    }
    
    public final boolean checkVideoDownloaded(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> readDVideosFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> readDVideosFailureFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> readAllDVideosFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> countRecordInTable(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    public final boolean deleteDVideosFromDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, int idVideo) {
        return false;
    }
    
    public final void updateTabledVideoDownloadedToFalse(int videoId) {
    }
    
    private VideoDBUtil() {
        super();
    }
}