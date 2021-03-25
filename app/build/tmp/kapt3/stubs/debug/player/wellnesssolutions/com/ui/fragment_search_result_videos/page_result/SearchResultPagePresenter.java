package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u001a\u0010 \u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016J \u0010$\u001a\u00020\u00112\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/SearchResultPagePresenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "pageIndex", "", "(I)V", "mIsShown", "", "mPageIndex", "mParentPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "mVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$View;", "addItemListener", "", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/ISearchResultItemListener;", "displayUI", "view", "getPageIndex", "getVideos", "isVideoSelected", "video", "(Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;)Ljava/lang/Boolean;", "onAttach", "onClickedResultItem", "data", "onDestroy", "onDetach", "selectVideoToPlay", "isSelected", "setParentPresenter", "parentPresenter", "setPassedData", "app_debug"})
public final class SearchResultPagePresenter implements player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.View mView;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter mParentPresenter;
    private int mPageIndex;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mVideos;
    private boolean mIsShown = false;
    
    @java.lang.Override()
    public void setPassedData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.View view) {
    }
    
    private final void displayUI(player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.View view) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onClickedResultItem(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    @java.lang.Override()
    public void selectVideoToPlay(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo video, boolean isSelected) {
    }
    
    @java.lang.Override()
    public void setParentPresenter(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter parentPresenter) {
    }
    
    @java.lang.Override()
    public void addItemListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener listener) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Boolean isVideoSelected(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo video) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideos() {
        return null;
    }
    
    @java.lang.Override()
    public int getPageIndex() {
        return 0;
    }
    
    public SearchResultPagePresenter(int pageIndex) {
        super();
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}