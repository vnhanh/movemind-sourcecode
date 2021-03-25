package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J*\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J1\u0010\u001a\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010 \u001a\u00020\fJ\u001a\u0010!\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0012\u0010\"\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ActivityDownloadHelper;", "Lplayer/wellnesssolutions/database/manager/IProgressListener;", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;)V", "mWeakActivity", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "mWeakView", "checkIfShowMessageDownloadSuccess", "", "fileName", "", "getExactFileName", "getString", "msgRes", "", "onAddTaskFailedBecauseDataNull", "videoId", "onDownloadCannotStart", "onDownloadCompleted", "isSuccess", "", "message", "onInsufficientSpace", "availableSpace", "", "fileLength", "(Ljava/lang/Integer;Ljava/lang/String;JJ)V", "onTaskExist", "release", "showMessageDownloadFailed", "showMessageDownloadSuccess", "app_debug"})
public final class ActivityDownloadHelper implements player.wellnesssolutions.database.manager.IProgressListener {
    private final java.lang.ref.WeakReference<android.app.Activity> mWeakActivity = null;
    private final java.lang.ref.WeakReference<android.view.View> mWeakView = null;
    
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
    public void onAddTaskFailedBecauseDataNull(int videoId) {
    }
    
    @java.lang.Override()
    public void onTaskExist(int videoId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
    }
    
    /**
     * onDownloadCompleted()
     */
    @java.lang.Override()
    public void onDownloadCompleted(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, boolean isSuccess, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void checkIfShowMessageDownloadSuccess(java.lang.String fileName) {
    }
    
    private final void showMessageDownloadSuccess(java.lang.String fileName) {
    }
    
    private final void showMessageDownloadFailed(java.lang.String fileName, java.lang.String message) {
    }
    
    private final java.lang.String getExactFileName(java.lang.String fileName) {
        return null;
    }
    
    /**
     * end onDownloadCompleted()
     */
    private final java.lang.String getString(@androidx.annotation.StringRes()
    int msgRes) {
        return null;
    }
    
    public final void release() {
    }
    
    public ActivityDownloadHelper(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super();
    }
    
    public void deleteVideoIdWhenDownloadFailed(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    public void onDoesNotEnoughMemory() {
    }
    
    public void onDownloadStarted(int videoId) {
    }
    
    public void onDownloaded() {
    }
    
    public void updateVideoIdWhenDownloadFailed(int videoId) {
    }
}