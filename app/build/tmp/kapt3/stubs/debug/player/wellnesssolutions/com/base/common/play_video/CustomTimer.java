package player.wellnesssolutions.com.base.common.play_video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/CustomTimer;", "Ljava/util/Timer;", "()V", "mIsCancel", "", "cancel", "", "isCancel", "schedule", "task", "Ljava/util/TimerTask;", "delay", "", "period", "app_debug"})
public final class CustomTimer extends java.util.Timer {
    private boolean mIsCancel = true;
    
    @java.lang.Override()
    public void schedule(@org.jetbrains.annotations.Nullable()
    java.util.TimerTask task, long delay) {
    }
    
    @java.lang.Override()
    public void schedule(@org.jetbrains.annotations.Nullable()
    java.util.TimerTask task, long delay, long period) {
    }
    
    @java.lang.Override()
    public void cancel() {
    }
    
    public final boolean isCancel() {
        return false;
    }
    
    public CustomTimer() {
        super();
    }
}