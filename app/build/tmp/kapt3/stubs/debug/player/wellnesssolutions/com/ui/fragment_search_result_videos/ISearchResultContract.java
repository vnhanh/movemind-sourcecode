package player.wellnesssolutions.com.ui.fragment_search_result_videos;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISearchResultContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH&J \u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\b\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006\u001c"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "addAllVideosForPlay", "", "displaySearchReuslt", "searchList", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "onAllVideosSelected", "onAnyVideoSelected", "isAnyVideoNotDownloaded", "", "onNoAllVideosSelected", "onNoVideoSelected", "onRequestFailed", "message", "", "onShowPlayingVideoDialog", "data", "openPlayingVideosScreen", "showUIBeforeLoadResultData", "instructor", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;", "chosenOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void showUIBeforeLoadResultData(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption chosenOptions);
        
        public abstract void showUIBeforeLoadResultData();
        
        public abstract void showUIBeforeLoadResultData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructor);
        
        public abstract void displaySearchReuslt(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> searchList);
        
        public abstract void openPlayingVideosScreen(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data);
        
        public abstract void onRequestFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        public abstract void addAllVideosForPlay();
        
        public abstract void onAnyVideoSelected(boolean isAnyVideoNotDownloaded);
        
        public abstract void onNoVideoSelected();
        
        public abstract void onAllVideosSelected();
        
        public abstract void onNoAllVideosSelected();
        
        public abstract void onShowPlayingVideoDialog(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo data);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH&J(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J(\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\nj\b\u0012\u0004\u0012\u00020\u0015`\f2\u0006\u0010\u0016\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\u0012H&J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002H&J\b\u0010 \u001a\u00020\u0004H&J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002H&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000bH&J\b\u0010$\u001a\u00020\u0004H&J\u001a\u0010%\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u0012H&J\b\u0010\'\u001a\u00020\u0004H&\u00a8\u0006("}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$View;", "addItemListener", "", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/ISearchResultItemListener;", "checkSelectedVideo", "downloadAllSelectedVideos", "getVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "getVideosFromRange", "begin", "", "range", "hasSelectedVideos", "", "inputData", "answers", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "brandId", "instructor", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;", "chosenOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "isAllVideosSelected", "isVideoSelected", "video", "loadData", "view", "onPlaySearchedVideos", "onReshowUI", "onShowPlayingVideoDialog", "data", "selectAllVideos", "selectVideoToPlay", "isSelected", "unselectAllVideos", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View> {
        
        public abstract void inputData(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption chosenOptions);
        
        public abstract void inputData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> answers, int brandId);
        
        public abstract void inputData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructor);
        
        public abstract void onPlaySearchedVideos();
        
        public abstract void onReshowUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View view);
        
        @org.jetbrains.annotations.NotNull()
        public abstract java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideos();
        
        @org.jetbrains.annotations.NotNull()
        public abstract java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideosFromRange(int begin, int range);
        
        public abstract void loadData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View view);
        
        public abstract void selectVideoToPlay(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo video, boolean isSelected);
        
        public abstract boolean isVideoSelected(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo video);
        
        public abstract boolean hasSelectedVideos();
        
        public abstract void downloadAllSelectedVideos();
        
        public abstract void addItemListener(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener listener);
        
        public abstract boolean isAllVideosSelected();
        
        public abstract void selectAllVideos();
        
        public abstract void unselectAllVideos();
        
        public abstract void checkSelectedVideo();
        
        public abstract void onShowPlayingVideoDialog(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo data);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter $this) {
            }
        }
    }
}