package player.wellnesssolutions.com.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/services/AlarmManagerSchedule;", "", "()V", "alarm", "Landroid/app/AlarmManager;", "codeScheduleRequest", "", "codeScheduleRequestEvery", "intentPending", "Landroid/app/PendingIntent;", "cancelAlarmScheduleTime", "", "setupAlarmTimeCallEveryDay", "context", "Landroid/content/Context;", "setupTimeWakeSchedule", "secondStart", "app_debug"})
public final class AlarmManagerSchedule {
    private static final int codeScheduleRequest = 14;
    private static final int codeScheduleRequestEvery = 16;
    private static android.app.AlarmManager alarm;
    private static android.app.PendingIntent intentPending;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.AlarmManagerSchedule INSTANCE = null;
    
    public final void setupTimeWakeSchedule(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int secondStart) {
    }
    
    public final void setupAlarmTimeCallEveryDay(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void cancelAlarmScheduleTime() {
    }
    
    private AlarmManagerSchedule() {
        super();
    }
}