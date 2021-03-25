package player.wellnesssolutions.com.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0002J*\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\b\u0010#\u001a\u00020\nH\u0016J\b\u0010$\u001a\u00020\u0000H\u0016J\u0012\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\'\u001a\u00020\nH\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010+\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lplayer/wellnesssolutions/com/services/DownloadService;", "Landroid/app/Service;", "Lplayer/wellnesssolutions/database/manager/IProgressListener;", "Lplayer/wellnesssolutions/com/services/DownloadBinder$BinderDownloadListener;", "()V", "mBinder", "Lplayer/wellnesssolutions/com/services/DownloadBinder;", "mBroadcast", "Landroid/content/BroadcastReceiver;", "addVideosApi", "", "intent", "Landroid/content/Intent;", "cancelDownloadByBarCode", "changeSubAPi", "clearAllDataDownload", "deleteVideoIdWhenDownloadFailed", "videoId", "", "fileName", "", "url", "onBind", "Landroid/os/IBinder;", "onChangeSub", "onCreate", "onDestroy", "onDoesNotEnoughMemory", "onDownLoadMemory", "onDownloadCompleted", "isSuccess", "", "message", "onDownloadEnd", "onDownloadStart", "onDownloaded", "onGetService", "onTaskRemoved", "rootIntent", "onUpDateDownload", "readScheduleIntent", "registerReceive", "removeVideoApi", "startDownload", "Companion", "app_debug"})
public final class DownloadService extends android.app.Service implements player.wellnesssolutions.database.manager.IProgressListener, player.wellnesssolutions.com.services.DownloadBinder.BinderDownloadListener {
    private final player.wellnesssolutions.com.services.DownloadBinder mBinder = null;
    private final android.content.BroadcastReceiver mBroadcast = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_DOWNLOAD = "player.wellnesssolution.com.au.download";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_DOWNLOAD_UI = "player.wellnesssolution.com.au.download.ui";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DOWNLOAD_VIDEO = "download_video";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANGE_SUB_SERVICE = "change_sub_service";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DOWNLOAD_VIDEO_UI = "download_video_ui";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATA_VIDEOS = "data_videos";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.DownloadService.Companion Companion = null;
    
    private final void readScheduleIntent(android.content.Intent intent) {
    }
    
    @kotlin.Suppress(names = {"NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"})
    private final void addVideosApi(android.content.Intent intent) {
    }
    
    @kotlin.Suppress(names = {"NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"})
    private final void removeVideoApi(android.content.Intent intent) {
    }
    
    private final void changeSubAPi() {
    }
    
    private final void clearAllDataDownload() {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onTaskRemoved(@org.jetbrains.annotations.Nullable()
    android.content.Intent rootIntent) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.services.DownloadService onGetService() {
        return null;
    }
    
    private final void registerReceive() {
    }
    
    private final void startDownload() {
    }
    
    @java.lang.Override()
    public void onDownloadCompleted(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, boolean isSuccess, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onDoesNotEnoughMemory() {
    }
    
    @java.lang.Override()
    public void onDownloaded() {
    }
    
    @java.lang.Override()
    public void deleteVideoIdWhenDownloadFailed(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public final void onDownloadStart() {
    }
    
    private final void onUpDateDownload() {
    }
    
    public final void onDownloadEnd() {
    }
    
    private final void onChangeSub() {
    }
    
    private final void onDownLoadMemory() {
    }
    
    private final void cancelDownloadByBarCode() {
    }
    
    public DownloadService() {
        super();
    }
    
    public void onAddTaskFailedBecauseDataNull(int videoId) {
    }
    
    public void onDownloadCannotStart(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    public void onDownloadStarted(int videoId) {
    }
    
    public void onInsufficientSpace(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, long availableSpace, long fileLength) {
    }
    
    public void onTaskExist(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    public void updateVideoIdWhenDownloadFailed(int videoId) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/services/DownloadService$Companion;", "", "()V", "ACTION_DOWNLOAD", "", "ACTION_DOWNLOAD_UI", "CHANGE_SUB_SERVICE", "DATA_VIDEOS", "DOWNLOAD_VIDEO", "DOWNLOAD_VIDEO_UI", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}