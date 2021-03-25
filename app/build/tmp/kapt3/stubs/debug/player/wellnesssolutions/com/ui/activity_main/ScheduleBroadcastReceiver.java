package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \'2\u00020\u0001:\u0003\'()B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u001c\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "MAX_NUM_TRY", "", "TIME_DELAY", "", "counterTry", "handler", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$MyHandle;", "mScheduleListeners", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$ScheduleListener;", "Lkotlin/collections/ArrayList;", "runnablePlaySchedule", "Ljava/lang/Runnable;", "scheduleBroadcastReceiver", "Ljava/lang/ref/WeakReference;", "addListener", "", "listener", "checkListenerHomeAndControl", "", "isRegistered", "onBackToHome", "onBackToHomeGetConfigApi", "onChangeSubs", "onGetConfigApi", "onPLaySchedule", "onPLayScheduleEvery", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onUpdateSchedule", "readScheduleIntent", "release", "removeListener", "Companion", "MyHandle", "ScheduleListener", "app_debug"})
public final class ScheduleBroadcastReceiver extends android.content.BroadcastReceiver {
    private final java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver> scheduleBroadcastReceiver = null;
    private final player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.MyHandle handler = null;
    private final java.util.ArrayList<player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener> mScheduleListeners = null;
    private int counterTry = 0;
    private final int MAX_NUM_TRY = 5;
    private final java.lang.Runnable runnablePlaySchedule = null;
    private final long TIME_DELAY = 1000L;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_SCHEDULE = "player.wellnesssolution.com.au.schedule";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SCHEDULE_PLAY_VIDEO = "schedule_play_video";
    private static player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver mInstance;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.Companion Companion = null;
    
    public final void release() {
    }
    
    public final boolean isRegistered(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener listener) {
        return false;
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void readScheduleIntent(android.content.Intent intent) {
    }
    
    private final void onChangeSubs() {
    }
    
    private final void onPLaySchedule() {
    }
    
    private final void onBackToHome() {
    }
    
    private final void onBackToHomeGetConfigApi() {
    }
    
    private final void onGetConfigApi() {
    }
    
    private final void onPLayScheduleEvery() {
    }
    
    private final void onUpdateSchedule() {
    }
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener listener) {
    }
    
    private final boolean checkListenerHomeAndControl() {
        return false;
    }
    
    public ScheduleBroadcastReceiver() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$MyHandle;", "Landroid/os/Handler;", "scheduleBroadcastReceiver", "Ljava/lang/ref/WeakReference;", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver;", "(Ljava/lang/ref/WeakReference;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "app_debug"})
    public static final class MyHandle extends android.os.Handler {
        private final java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver> scheduleBroadcastReceiver = null;
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.Nullable()
        android.os.Message msg) {
        }
        
        public MyHandle(@org.jetbrains.annotations.NotNull()
        java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver> scheduleBroadcastReceiver) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$ScheduleListener;", "", "onReceiveChangeApiBackToHome", "", "onReceiveChangeApiBackToHomeGetConfigApi", "onReceiveChangeApiGetConfigApi", "onReceiveChangeSub", "onReceivePlayVideoScheduleFromUI", "onReceiveResetScheduleFromUI", "onReceiveUpdateScheduleFromUI", "app_debug"})
    public static abstract interface ScheduleListener {
        
        public abstract void onReceivePlayVideoScheduleFromUI();
        
        public abstract void onReceiveResetScheduleFromUI();
        
        public abstract void onReceiveUpdateScheduleFromUI();
        
        public abstract void onReceiveChangeApiBackToHome();
        
        public abstract void onReceiveChangeApiBackToHomeGetConfigApi();
        
        public abstract void onReceiveChangeApiGetConfigApi();
        
        public abstract void onReceiveChangeSub();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void onReceiveChangeSub(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener $this) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$Companion;", "", "()V", "ACTION_SCHEDULE", "", "SCHEDULE_PLAY_VIDEO", "mInstance", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver getInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}