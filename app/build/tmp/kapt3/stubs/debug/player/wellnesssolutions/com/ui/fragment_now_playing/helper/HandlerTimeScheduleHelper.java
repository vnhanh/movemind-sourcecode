package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/HandlerTimeScheduleHelper;", "", "()V", "TIME_PLAY_MAX_ROUND", "", "calculateTimePlayVideo", "", "video", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "callback", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/ICallbackNowScheduleVideo;", "convertCurrentTimeToDateStr", "", "time", "convertTime", "dateTimeStr", "readSharePrefData", "", "ss", "Lplayer/wellnesssolutions/com/common/sharedpreferences/PreferenceHelper;", "view", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "app_debug"})
public final class HandlerTimeScheduleHelper {
    private static final long TIME_PLAY_MAX_ROUND = 2000L;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.helper.HandlerTimeScheduleHelper INSTANCE = null;
    
    public final void calculateTimePlayVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo video, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.ICallbackNowScheduleVideo callback) {
    }
    
    private final java.lang.String convertCurrentTimeToDateStr(long time) {
        return null;
    }
    
    public final long convertTime(@org.jetbrains.annotations.NotNull()
    java.lang.String dateTimeStr) {
        return 0L;
    }
    
    public final boolean readSharePrefData(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper ss, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View view) {
        return false;
    }
    
    private HandlerTimeScheduleHelper() {
        super();
    }
}