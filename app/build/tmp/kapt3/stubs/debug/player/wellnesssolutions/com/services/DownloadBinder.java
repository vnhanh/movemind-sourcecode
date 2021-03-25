package player.wellnesssolutions.com.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u000fJ*\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001fJ\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010\'\u001a\u00020\u0018H\u0002J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lplayer/wellnesssolutions/com/services/DownloadBinder;", "Landroid/os/Binder;", "listener", "Lplayer/wellnesssolutions/com/services/DownloadBinder$BinderDownloadListener;", "(Lplayer/wellnesssolutions/com/services/DownloadBinder$BinderDownloadListener;)V", "getListener", "()Lplayer/wellnesssolutions/com/services/DownloadBinder$BinderDownloadListener;", "setListener", "mListDownload", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "mListDownloadFailure", "mService", "Lplayer/wellnesssolutions/com/services/DownloadService;", "cancelDownloadByScanBarcode", "", "context", "Landroid/content/Context;", "cancelNotifyWhenServiceKilled", "compareAndUpdateDataDVideos", "deleteFileWithId", "videoId", "", "nameShowFile", "", "url", "downloadWhenChangeSubs", "getAllVideosForDownload", "getAllVideosForDownloadChangeSubs", "getAllVideosForDownloadWithId", "dataInt", "", "getFullListVideoAndRemoveVideoWithId", "data", "getListDoesNotDownloaded", "isCalledComeFromUI", "", "getSavedFileName", "name", "extension", "removeVideoWithId", "updateDataDVideos", "BinderDownloadListener", "app_debug"})
public final class DownloadBinder extends android.os.Binder {
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mListDownload;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mListDownloadFailure;
    private player.wellnesssolutions.com.services.DownloadService mService;
    @org.jetbrains.annotations.NotNull()
    private player.wellnesssolutions.com.services.DownloadBinder.BinderDownloadListener listener;
    
    public final void getListDoesNotDownloaded(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isCalledComeFromUI) {
    }
    
    public final void removeVideoWithId(@org.jetbrains.annotations.NotNull()
    int[] data) {
    }
    
    public final void getFullListVideoAndRemoveVideoWithId(@org.jetbrains.annotations.NotNull()
    int[] data) {
    }
    
    public final void deleteFileWithId(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String nameShowFile, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    private final java.lang.String getSavedFileName(java.lang.String name, java.lang.String extension) {
        return null;
    }
    
    public final void compareAndUpdateDataDVideos() {
    }
    
    private final void getAllVideosForDownload(android.content.Context context) {
    }
    
    public final void updateDataDVideos(@org.jetbrains.annotations.NotNull()
    int[] data) {
    }
    
    private final void getAllVideosForDownloadWithId(android.content.Context context, int[] dataInt) {
    }
    
    public final void downloadWhenChangeSubs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void cancelNotifyWhenServiceKilled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void getAllVideosForDownloadChangeSubs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void cancelDownloadByScanBarcode(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.com.services.DownloadBinder.BinderDownloadListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.DownloadBinder.BinderDownloadListener p0) {
    }
    
    public DownloadBinder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.DownloadBinder.BinderDownloadListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/services/DownloadBinder$BinderDownloadListener;", "", "onGetService", "Lplayer/wellnesssolutions/com/services/DownloadService;", "app_debug"})
    public static abstract interface BinderDownloadListener {
        
        @org.jetbrains.annotations.NotNull()
        public abstract player.wellnesssolutions.com.services.DownloadService onGetService();
    }
}