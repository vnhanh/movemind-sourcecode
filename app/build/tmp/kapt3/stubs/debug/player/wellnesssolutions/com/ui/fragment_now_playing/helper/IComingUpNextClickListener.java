package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "", "getPlayMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "onClickedComingUpNextVideo", "", "position", "", "onTapGroupComingUpNext", "app_debug"})
public abstract interface IComingUpNextClickListener {
    
    public abstract void onClickedComingUpNextVideo(int position);
    
    public abstract void onTapGroupComingUpNext();
    
    @org.jetbrains.annotations.NotNull()
    public abstract player.wellnesssolutions.com.network.datasource.videos.PlayMode getPlayMode();
}