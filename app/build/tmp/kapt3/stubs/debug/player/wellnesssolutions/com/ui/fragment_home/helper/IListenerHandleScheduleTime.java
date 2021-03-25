package player.wellnesssolutions.com.ui.fragment_home.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H\u0016\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/helper/IListenerHandleScheduleTime;", "", "onDontHaveNowPlayingVideo", "", "isClickedButtonHome", "", "(Ljava/lang/Boolean;)V", "onHaveNowPlayingVideo", "playedPosition", "", "onHaveVideoAfter", "isRequestFromUser", "onProcessVideoError", "onVideoExpiredTime", "app_debug"})
public abstract interface IListenerHandleScheduleTime {
    
    public abstract void onHaveNowPlayingVideo(long playedPosition);
    
    public abstract void onHaveVideoAfter(long playedPosition, boolean isRequestFromUser);
    
    public abstract void onDontHaveNowPlayingVideo(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean isClickedButtonHome);
    
    public abstract void onVideoExpiredTime();
    
    public abstract void onProcessVideoError();
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void onHaveVideoAfter(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime $this, long playedPosition, boolean isRequestFromUser) {
        }
        
        public static void onVideoExpiredTime(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime $this) {
        }
    }
}