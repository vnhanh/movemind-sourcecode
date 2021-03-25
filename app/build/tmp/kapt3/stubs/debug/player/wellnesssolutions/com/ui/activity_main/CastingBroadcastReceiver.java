package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

/**
 * This BroadcastReceiver helps to transfer the data and actions between the Casting TV Service and the UI
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000  2\u00020\u0001:\u0003 !\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001c\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "mTVListeners", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$TVListener;", "Lkotlin/collections/ArrayList;", "mUIListeners", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$UIListener;", "addListener", "", "listener", "isRegistered", "", "onCookieExpired", "onPauseVideoOnTV", "onPlayVideoOnTV", "onPlayerInitialized", "intent", "Landroid/content/Intent;", "onReceive", "context", "Landroid/content/Context;", "onUpdateEndedVideoState", "onUpdateEndedVideoStateSchedule", "onUpdateLoadingVideoState", "onUpdateTranslatedVideoState", "onUpdateVideoProgress", "readTVIntent", "readUIIntent", "release", "removeListener", "Companion", "TVListener", "UIListener", "app_debug"})
public final class CastingBroadcastReceiver extends android.content.BroadcastReceiver {
    private final java.util.ArrayList<player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.UIListener> mUIListeners = null;
    private final java.util.ArrayList<player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener> mTVListeners = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_TV = "com.tma.movemind.TV_STATUS_CHANGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_UI = "com.tma.movemind.UI_COMMAND";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_COOKIE_EXPIRED = "EXTRA_COOKIE_EXPIRED";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_LOADING_VIDEO_STATE_ON_TV = "EXTRA_LOADING_VIDEO_STATE_ON_TV";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_READY_VIDEO_STATE_ON_TV = "EXTRA_READY_VIDEO_STATE_ON_TV";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ENDED_VIDEO_STATE_ON_TV = "EXTRA_ENDED_VIDEO_STATE_ON_TV";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE = "EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DURATION_VIDEO_ON_TV = "EXTRA_DURATION_VIDEO_ON_TV";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_UPDATE_PROGRESS = "EXTRA_UPDATE_PROGRESS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV = "EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON = "EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_PLAY_VIDEO = "EXTRA_PLAY_VIDEO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_PAUSE_VIDEO = "EXTRA_PAUSE_VIDEO";
    private static player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver mInstance;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.Companion Companion = null;
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener listener) {
    }
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.UIListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.UIListener listener) {
    }
    
    public final void release() {
    }
    
    public final boolean isRegistered(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener listener) {
        return false;
    }
    
    public final boolean isRegistered(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.UIListener listener) {
        return false;
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void readTVIntent(android.content.Intent intent) {
    }
    
    private final void onUpdateEndedVideoState() {
    }
    
    private final void onUpdateEndedVideoStateSchedule() {
    }
    
    private final void onUpdateLoadingVideoState() {
    }
    
    private final void onUpdateTranslatedVideoState() {
    }
    
    private final void readUIIntent(android.content.Intent intent) {
    }
    
    private final void onPlayVideoOnTV() {
    }
    
    private final void onPauseVideoOnTV() {
    }
    
    private final void onPlayerInitialized(android.content.Intent intent) {
    }
    
    private final void onUpdateVideoProgress(android.content.Intent intent) {
    }
    
    private final void onCookieExpired() {
    }
    
    public CastingBroadcastReceiver() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J.\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J$\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$TVListener;", "", "onCookieExpired", "", "onPlayerReady", "isShowPlayPauseButton", "", "isPlaying", "currentPosition", "", "duration", "onUpdateEndedVideoState", "onUpdateEndedVideoStateSchedule", "onUpdateLoadingVideoState", "onUpdateProgress", "position", "onUpdateTranslatedVideoState", "app_debug"})
    public static abstract interface TVListener {
        
        public abstract void onPlayerReady(boolean isShowPlayPauseButton, boolean isPlaying, long currentPosition, long duration);
        
        public abstract void onUpdateProgress(boolean isShowPlayPauseButton, boolean isPlaying, long position);
        
        public abstract void onCookieExpired();
        
        public abstract void onUpdateEndedVideoState();
        
        public abstract void onUpdateEndedVideoStateSchedule();
        
        public abstract void onUpdateLoadingVideoState();
        
        public abstract void onUpdateTranslatedVideoState();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void onPlayerReady(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this, boolean isShowPlayPauseButton, boolean isPlaying, long currentPosition, long duration) {
            }
            
            public static void onUpdateProgress(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this, boolean isShowPlayPauseButton, boolean isPlaying, long position) {
            }
            
            public static void onCookieExpired(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this) {
            }
            
            public static void onUpdateEndedVideoState(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this) {
            }
            
            public static void onUpdateEndedVideoStateSchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this) {
            }
            
            public static void onUpdateLoadingVideoState(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this) {
            }
            
            public static void onUpdateTranslatedVideoState(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener $this) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$UIListener;", "", "onReceivePauseVideoFromUI", "", "onReceivePlayVideoFromUI", "app_debug"})
    public static abstract interface UIListener {
        
        public abstract void onReceivePlayVideoFromUI();
        
        public abstract void onReceivePauseVideoFromUI();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$Companion;", "", "()V", "ACTION_TV", "", "ACTION_UI", "EXTRA_COOKIE_EXPIRED", "EXTRA_DURATION_VIDEO_ON_TV", "EXTRA_ENDED_VIDEO_STATE_ON_TV", "EXTRA_ENDED_VIDEO_STATE_ON_TV_SCHEDULE", "EXTRA_IS_SHOW_PLAY_PAUSE_BUTTON", "EXTRA_LOADING_VIDEO_STATE_ON_TV", "EXTRA_PAUSE_VIDEO", "EXTRA_PLAY_VIDEO", "EXTRA_READY_VIDEO_STATE_ON_TV", "EXTRA_TRANSLATE_TO_ANOTHER_VIDEO_ON_TV", "EXTRA_UPDATE_PROGRESS", "mInstance", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}