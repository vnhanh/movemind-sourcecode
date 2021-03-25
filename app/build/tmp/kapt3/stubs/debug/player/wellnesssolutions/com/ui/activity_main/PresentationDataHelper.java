package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJO\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/PresentationDataHelper;", "", "()V", "VIDEO_TAG", "", "clearCacheLastVideos", "", "context", "Landroid/content/Context;", "readVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "save", "mode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "videos", "currentPosition", "", "timeCountDown", "(Landroid/content/Context;Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;Ljava/util/ArrayList;Ljava/lang/Long;Ljava/lang/Long;)V", "app_debug"})
public final class PresentationDataHelper {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VIDEO_TAG = "TV Presentation";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.activity_main.PresentationDataHelper INSTANCE = null;
    
    public final void save(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.datasource.videos.PlayMode mode, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, @org.jetbrains.annotations.Nullable()
    java.lang.Long currentPosition, @org.jetbrains.annotations.Nullable()
    java.lang.Long timeCountDown) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> readVideos() {
        return null;
    }
    
    public final void clearCacheLastVideos(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private PresentationDataHelper() {
        super();
    }
}