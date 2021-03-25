package player.wellnesssolutions.com.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\rJ\u0012\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationService;", "Landroid/app/Service;", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder$BinderListener;", "()V", "mBinder", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder;", "mIsNormalColor", "", "mManager", "Landroid/app/NotificationManager;", "mReceiver", "Landroid/content/BroadcastReceiver;", "changeToNormalMode", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onClosedCaption", "onCreate", "onCreateNotificationRemote", "onDestroy", "onDestroyNotification", "onGetService", "onNextVideo", "onPlayOrPauseVideo", "onShowNextVideos", "showNormalNotification", "isNormalColor", "Companion", "app_debug"})
public final class MMPresentationService extends android.app.Service implements player.wellnesssolutions.com.services.MMPresentationBinder.BinderListener {
    private android.app.NotificationManager mManager;
    private player.wellnesssolutions.com.services.MMPresentationBinder mBinder;
    private boolean mIsNormalColor = true;
    private android.content.BroadcastReceiver mReceiver;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "MMPresentationService";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DESCRIPTION = "Move Mind";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TITLE = "Move Mind";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.MMPresentationService.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreateNotificationRemote() {
    }
    
    private final void showNormalNotification(boolean isNormalColor) {
    }
    
    @java.lang.Override()
    public void onDestroyNotification() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.services.MMPresentationService onGetService() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public final void onPlayOrPauseVideo() {
    }
    
    public final void onNextVideo() {
    }
    
    public final void onShowNextVideos() {
    }
    
    private final void onClosedCaption() {
    }
    
    public final void changeToNormalMode() {
    }
    
    public MMPresentationService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationService$Companion;", "", "()V", "DESCRIPTION", "", "TAG", "TITLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}