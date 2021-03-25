package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001c\u0010\u001f\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\"\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00040\u00040\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ChromecastSessionManagerListener;", "Lcom/google/android/gms/cast/framework/SessionManagerListener;", "Lcom/google/android/gms/cast/framework/CastSession;", "listener", "Lplayer/wellnesssolutions/com/ui/activity_main/ChromecastSessionManagerListener$IListener;", "(Lplayer/wellnesssolutions/com/ui/activity_main/ChromecastSessionManagerListener$IListener;)V", "mCastContext", "Lcom/google/android/gms/cast/framework/CastContext;", "mCastSession", "mCastStateListener", "Lcom/google/android/gms/cast/framework/CastStateListener;", "mSessionManager", "Lcom/google/android/gms/cast/framework/SessionManager;", "mWeakListener", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onCreate", "", "context", "Landroid/content/Context;", "onSessionEnded", "session", "p1", "", "onSessionEnding", "onSessionResumeFailed", "onSessionResumed", "", "onSessionResuming", "", "onSessionStartFailed", "onSessionStarted", "sessionId", "onSessionStarting", "onSessionSuspended", "onSetup", "onUnInstall", "IListener", "app_debug"})
public final class ChromecastSessionManagerListener implements com.google.android.gms.cast.framework.SessionManagerListener<com.google.android.gms.cast.framework.CastSession> {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.activity_main.ChromecastSessionManagerListener.IListener> mWeakListener;
    private com.google.android.gms.cast.framework.CastContext mCastContext;
    private com.google.android.gms.cast.framework.SessionManager mSessionManager;
    private com.google.android.gms.cast.framework.CastStateListener mCastStateListener;
    private com.google.android.gms.cast.framework.CastSession mCastSession;
    
    public final void onCreate(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void onSetup(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void onUnInstall() {
    }
    
    @java.lang.Override()
    public void onSessionStarted(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, @org.jetbrains.annotations.Nullable()
    java.lang.String sessionId) {
    }
    
    @java.lang.Override()
    public void onSessionResumed(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, boolean p1) {
    }
    
    @java.lang.Override()
    public void onSessionEnded(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, int p1) {
    }
    
    @java.lang.Override()
    public void onSessionResumeFailed(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, int p1) {
    }
    
    @java.lang.Override()
    public void onSessionSuspended(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, int p1) {
    }
    
    @java.lang.Override()
    public void onSessionStarting(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session) {
    }
    
    @java.lang.Override()
    public void onSessionResuming(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, @org.jetbrains.annotations.Nullable()
    java.lang.String p1) {
    }
    
    @java.lang.Override()
    public void onSessionEnding(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session) {
    }
    
    @java.lang.Override()
    public void onSessionStartFailed(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.cast.framework.CastSession session, int p1) {
    }
    
    public ChromecastSessionManagerListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.ChromecastSessionManagerListener.IListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ChromecastSessionManagerListener$IListener;", "", "onSessionEnd", "", "onSessionStarted", "app_debug"})
    public static abstract interface IListener {
        
        public abstract void onSessionStarted();
        
        public abstract void onSessionEnd();
    }
}