package player.wellnesssolutions.com.services.notification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J!\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u001aJ3\u0010\u001b\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u001aJ)\u0010 \u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0016\u00a2\u0006\u0002\u0010!J1\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016\u00a2\u0006\u0002\u0010\'J\u0006\u0010(\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00030\u00030\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lplayer/wellnesssolutions/com/services/notification/DownloadNotification;", "Lplayer/wellnesssolutions/com/services/download/DownloadTask$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CHANNEL_ID", "", "NOTI_ID", "", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "mLayout", "Landroid/widget/RemoteViews;", "mNotiManager", "Landroidx/core/app/NotificationManagerCompat;", "mWeakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "cancelNoti", "", "create", "progress", "name", "createNotificationChannel", "onDownloadCompleted", "id", "(Ljava/lang/Integer;Ljava/lang/String;)V", "onDownloadFailed", "reason", "url", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDownloadStarted", "onDownloadUpdate", "(Ljava/lang/Integer;Ljava/lang/String;I)V", "onInsufficientSpace", "videoId", "availableSpace", "", "fileSize", "(Ljava/lang/Integer;Ljava/lang/String;JJ)V", "stop", "app_debug"})
public final class DownloadNotification implements player.wellnesssolutions.com.services.download.DownloadTask.Callback {
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private androidx.core.app.NotificationManagerCompat mNotiManager;
    private final java.lang.String CHANNEL_ID = "DOWNLOAD CHANNEL";
    private android.widget.RemoteViews mLayout;
    private final int NOTI_ID = 10;
    private androidx.core.app.NotificationCompat.Builder mBuilder;
    
    @java.lang.Override()
    public void onDownloadStarted(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    @java.lang.Override()
    public void onInsufficientSpace(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, long availableSpace, long fileSize) {
    }
    
    @java.lang.Override()
    public void onDownloadUpdate(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, int progress) {
    }
    
    @java.lang.Override()
    public void onDownloadFailed(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void onDownloadCompleted(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    private final void cancelNoti() {
    }
    
    private final void createNotificationChannel(android.content.Context context) {
    }
    
    public final void create(int progress, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    public final void stop() {
    }
    
    public DownloadNotification(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}