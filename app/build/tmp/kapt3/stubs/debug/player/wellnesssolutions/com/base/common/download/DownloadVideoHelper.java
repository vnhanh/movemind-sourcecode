package player.wellnesssolutions.com.base.common.download;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/download/DownloadVideoHelper;", "", "()V", "links", "Ljava/util/ArrayList;", "", "download", "", "context", "Landroid/content/Context;", "data", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "hasPermission", "", "senStorageStatusToServer", "availableSpace", "", "totalSpace", "sdAvailableSpace", "sdTotalSpace", "sendDownloadStatusToServer", "status", "app_debug"})
public final class DownloadVideoHelper {
    private static final java.util.ArrayList<java.lang.String> links = null;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.common.download.DownloadVideoHelper INSTANCE = null;
    
    public final void download(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data, boolean hasPermission) {
    }
    
    public final void sendDownloadStatusToServer(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String status) {
    }
    
    public final void senStorageStatusToServer(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long availableSpace, long totalSpace, long sdAvailableSpace, long sdTotalSpace) {
    }
    
    private DownloadVideoHelper() {
        super();
    }
}