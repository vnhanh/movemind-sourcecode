package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/ISearchResultItemListener;", "", "download", "", "getVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "isDownloaded", "", "selectVideo", "unselectVideo", "app_debug"})
public abstract interface ISearchResultItemListener {
    
    public abstract void selectVideo();
    
    public abstract void unselectVideo();
    
    public abstract void download();
    
    @org.jetbrains.annotations.Nullable()
    public abstract player.wellnesssolutions.com.network.models.now_playing.MMVideo getVideo();
    
    public abstract boolean isDownloaded();
}