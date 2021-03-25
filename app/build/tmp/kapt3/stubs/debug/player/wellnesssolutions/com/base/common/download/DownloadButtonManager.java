package player.wellnesssolutions.com.base.common.download;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007\"\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\fH\u0002J\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\nH\u0016J*\u0010\'\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010 \u001a\u00020\f2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J1\u0010+\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0006\u00103\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u000fJ\u0010\u00106\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0004H\u0002J\u0010\u0010<\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0012`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/download/DownloadButtonManager;", "Landroid/view/View$OnClickListener;", "Lplayer/wellnesssolutions/database/manager/IProgressListener;", "btnDownload", "Lplayer/wellnesssolutions/com/common/customize_views/MMImageView;", "(Lplayer/wellnesssolutions/com/common/customize_views/MMImageView;)V", "btn", "", "([Lplayer/wellnesssolutions/com/common/customize_views/MMImageView;)V", "PACKAGE", "", "mIsDownloaded", "", "mIsEnable", "mVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "mWeakButtons", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "mWeakContext", "Landroid/content/Context;", "checkDownloading", "context", "videoId", "", "(Landroid/content/Context;Ljava/lang/Integer;)Z", "checkNetworkAvailable", "displayDownloadedUI", "", "displayUI", "handleDownloadCompleted", "isSuccess", "isDownloaded", "onClick", "view", "Landroid/view/View;", "onDownloadCannotStart", "fileName", "onDownloadCompleted", "message", "onDownloadStarted", "onHandleDownloadOnClicked", "onInsufficientSpace", "availableSpace", "", "fileLength", "(Ljava/lang/Integer;Ljava/lang/String;JJ)V", "onTaskExist", "openAppInformationScreen", "registerProgressListener", "release", "setVideoData", "data", "showMessageDownloaded", "showMessageDownloading", "showMessageOnVideoDataNull", "showUIAllButtonsDownloading", "showUIDownloading", "button", "unregisterProgressListener", "Companion", "app_debug"})
public final class DownloadButtonManager implements android.view.View.OnClickListener, player.wellnesssolutions.database.manager.IProgressListener {
    private java.util.ArrayList<java.lang.ref.WeakReference<player.wellnesssolutions.com.common.customize_views.MMImageView>> mWeakButtons;
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private player.wellnesssolutions.com.network.models.now_playing.MMVideo mVideo;
    private boolean mIsDownloaded = false;
    private boolean mIsEnable = true;
    private final java.lang.String PACKAGE = "player.wellnesssolutions.com.au";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.common.download.DownloadButtonManager.Companion Companion = null;
    
    public final void setVideoData(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    /**
     * onClick()
     */
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void onHandleDownloadOnClicked(android.content.Context context) {
    }
    
    private final void openAppInformationScreen() {
    }
    
    private final void showMessageOnVideoDataNull(android.content.Context context) {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"})
    private final boolean checkNetworkAvailable() {
        return false;
    }
    
    /**
     * end onClick()
     */
    private final void showUIAllButtonsDownloading() {
    }
    
    private final void showUIDownloading(player.wellnesssolutions.com.common.customize_views.MMImageView button) {
    }
    
    private final void showMessageDownloading(android.content.Context context) {
    }
    
    private final void showMessageDownloaded(android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onTaskExist(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    @java.lang.Override()
    public void onDownloadStarted(int videoId) {
    }
    
    @java.lang.Override()
    public void onDownloadCannotStart(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    @java.lang.Override()
    public void onInsufficientSpace(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, long availableSpace, long fileLength) {
    }
    
    @java.lang.Override()
    public void onDownloadCompleted(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, boolean isSuccess, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void handleDownloadCompleted(int videoId, boolean isSuccess) {
    }
    
    private final void displayDownloadedUI() {
    }
    
    public final void displayUI() {
    }
    
    private final boolean checkDownloading(android.content.Context context, java.lang.Integer videoId) {
        return false;
    }
    
    public final void release() {
    }
    
    private final void registerProgressListener(android.content.Context context) {
    }
    
    private final void unregisterProgressListener(android.content.Context context) {
    }
    
    public final boolean isDownloaded() {
        return false;
    }
    
    public DownloadButtonManager(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.common.customize_views.MMImageView btnDownload) {
        super();
    }
    
    public DownloadButtonManager(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.common.customize_views.MMImageView... btn) {
        super();
    }
    
    public void deleteVideoIdWhenDownloadFailed(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public void onAddTaskFailedBecauseDataNull(int videoId) {
    }
    
    public void onDoesNotEnoughMemory() {
    }
    
    public void onDownloaded() {
    }
    
    public void updateVideoIdWhenDownloadFailed(int videoId) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/download/DownloadButtonManager$Companion;", "", "()V", "checkDownloaded", "", "videoId", "", "(Ljava/lang/Integer;)Z", "app_debug"})
    public static final class Companion {
        
        public final boolean checkDownloaded(@org.jetbrains.annotations.Nullable()
        java.lang.Integer videoId) {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}