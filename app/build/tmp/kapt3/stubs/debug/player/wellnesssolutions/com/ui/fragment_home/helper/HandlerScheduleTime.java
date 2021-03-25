package player.wellnesssolutions.com.ui.fragment_home.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J0\u0010\u0013\u001a\u00020\u00122\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\bH\u0002J&\u0010 \u001a\u00020\u00122\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0019\u001a\u00020\u001aJ8\u0010 \u001a\u00020\u00122\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J&\u0010!\u001a\u00020\u00122\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00030\u00030\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00050\u00050\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/helper/HandlerScheduleTime;", "Lplayer/wellnesssolutions/com/network/datasource/time_network/IRequestTimeNetworkListener;", "context", "Landroid/content/Context;", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_home/helper/IListenerHandleScheduleTime;", "(Landroid/content/Context;Lplayer/wellnesssolutions/com/ui/fragment_home/helper/IListenerHandleScheduleTime;)V", "mTimeDiffs", "", "videos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "weakContext", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "weakListener", "asyncTimeFromNetwork", "", "handleNextScheduleVideo", "index", "", "callback", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/ICallBackNextScheduleVideo;", "handleScheduleVideoNow", "isClickedButtonHome", "", "onRecivedTime", "timeDiffs", "release", "setupAlarmTask", "time", "setupScheduleForNowVideo", "setupScheduleNextVideo", "app_debug"})
public final class HandlerScheduleTime implements player.wellnesssolutions.com.network.datasource.time_network.IRequestTimeNetworkListener {
    private java.lang.ref.WeakReference<android.content.Context> weakContext;
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime> weakListener;
    private long mTimeDiffs = -1L;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos;
    
    private final void asyncTimeFromNetwork() {
    }
    
    @java.lang.Override()
    public void onRecivedTime(long timeDiffs) {
    }
    
    public final void setupScheduleNextVideo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.load_scheduled_videos.ICallBackNextScheduleVideo callback) {
    }
    
    public final void setupScheduleForNowVideo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, boolean isClickedButtonHome) {
    }
    
    public final void setupScheduleForNowVideo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, boolean isClickedButtonHome, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime listener, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    public final void release() {
    }
    
    private final void handleScheduleVideoNow(boolean isClickedButtonHome) {
    }
    
    private final void handleNextScheduleVideo(java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, int index, player.wellnesssolutions.com.base.common.load_scheduled_videos.ICallBackNextScheduleVideo callback) {
    }
    
    private final void setupAlarmTask(long time) {
    }
    
    public HandlerScheduleTime(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime listener) {
        super();
    }
}