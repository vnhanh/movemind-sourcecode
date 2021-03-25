package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0001H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'H\u0016J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\'H\u0016J \u0010+\u001a\u00020\u000b2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020!0-j\b\u0012\u0004\u0012\u00020!`.H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/SearchResultPageFragment;", "Landroidx/fragment/app/Fragment;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$View;", "()V", "mAdapter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageAdapter;", "mParentPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "attachPresenter", "", "getFragment", "getParentPresenterRef", "getViewContext", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onResume", "onSaveInstanceState", "outState", "onShowPlayingVideoDialog", "data", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "readArguments", "readBundle", "bundle", "showMessage", "messageRes", "", "color", "message", "", "showUI", "inputData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "app_debug"})
public final class SearchResultPageFragment extends androidx.fragment.app.Fragment implements player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.View {
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter mParentPresenter;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter mPresenter;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageAdapter mAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "SearchResultPageFragment";
    public static final int VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE = 11;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_INDEX = "KEY_INDEX";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.SearchResultPageFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getParentPresenterRef() {
    }
    
    private final void readArguments(android.os.Bundle savedInstanceState) {
    }
    
    private final void readBundle(android.os.Bundle bundle) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void attachPresenter() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    /**
     * View interface
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment getFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.content.Context getViewContext() {
        return null;
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showUI(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> inputData) {
    }
    
    @java.lang.Override()
    public void onShowPlayingVideoDialog(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    public SearchResultPageFragment() {
        super();
    }
    
    /**
     * ---------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/SearchResultPageFragment$Companion;", "", "()V", "KEY_INDEX", "", "TAG", "VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE", "", "getInstance", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/SearchResultPageFragment;", "index", "saveIndexPage", "Landroid/os/Bundle;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.SearchResultPageFragment getInstance(int index) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle saveIndexPage(int index) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}