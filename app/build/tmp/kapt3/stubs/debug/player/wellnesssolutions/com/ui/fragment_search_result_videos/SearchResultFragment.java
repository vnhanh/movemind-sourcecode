package player.wellnesssolutions.com.ui.fragment_search_result_videos;

import java.lang.System;

/**
 * This fragment has the ViewPager that contains child fragments as pages and every child fragment has a recyclerview to show list of video items
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u00020\f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\bJ\b\u0010\u0015\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\b\u0010\'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\fH\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\fH\u0016J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0012H\u0016J \u00100\u001a\u00020\f2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0016J\b\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u00020\fH\u0002J\b\u00104\u001a\u00020\fH\u0002J\b\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\fH\u0002J\b\u0010:\u001a\u00020\fH\u0002J\b\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\fH\u0002J\b\u0010=\u001a\u00020\fH\u0016J\u0018\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010>\u001a\u00020\f2\u0006\u0010+\u001a\u00020,2\u0006\u0010A\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020DH\u0016J\u0012\u0010B\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/SearchResultFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$View;", "Lplayer/wellnesssolutions/com/ui/activity_main/IRouterChanged;", "()V", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "mVPAdapter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/SearchResultRootAdapter;", "addAllVideosForPlay", "", "attachPresenter", "clickedBtnPlay", "displaySearchReuslt", "searchList", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "getPresenter", "hideLoadingProgress", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAllVideosSelected", "onAnyVideoSelected", "isAnyVideoNotDownloaded", "", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onMediaRouterDisconnected", "onNoAllVideosSelected", "onNoVideoSelected", "onPause", "onRequestFailed", "message", "", "onResume", "onShowPlayingVideoDialog", "data", "openPlayingVideosScreen", "readArguments", "readGetVideosByInstructorArguments", "readHelpMeChooseArguments", "readSearchByArguments", "registerRouterChangedListener", "releaseViewPager", "setupBtnDownloadAll", "setupBtnPlay", "setupBtnPrevious", "setupBtnRefresh", "setupBtnSelectAll", "setupUI", "showLoadingProgress", "showMessage", "messageRes", "", "color", "showUIBeforeLoadResultData", "instructor", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;", "chosenOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "unregisterRouterChangedListener", "Companion", "app_debug"})
public final class SearchResultFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.View, player.wellnesssolutions.com.ui.activity_main.IRouterChanged {
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter mPresenter;
    private androidx.appcompat.app.AlertDialog mDialog;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.SearchResultRootAdapter mVPAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "SearchResultFragment";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TYPE = "KEY TYPE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_BRAND_ID = "KEY BRAND ID";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_INSTRUCTOR = "KEY INSTRUCTOR";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG_HMC = ":HMC";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG_CHOSEN = ":chosen";
    private static int typeSearch = 0;
    private static int brandIdSearch = 0;
    @org.jetbrains.annotations.Nullable()
    private static player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructorSearch;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG_CANT_LOAD_VIDEOS_BECAUSE_NO_INSTRUCTOR_ID = "Can\'t load videos because no instructor id !";
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mVideosToPlay;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * readArguments()
     */
    private final void readArguments() {
    }
    
    private final void readGetVideosByInstructorArguments() {
    }
    
    private final void readHelpMeChooseArguments() {
    }
    
    private final void readSearchByArguments() {
    }
    
    /**
     * end readArguments()
     */
    private final void setupUI() {
    }
    
    private final void setupBtnDownloadAll() {
    }
    
    private final void setupBtnSelectAll() {
    }
    
    private final void setupBtnPlay() {
    }
    
    private final void clickedBtnPlay() {
    }
    
    private final void setupBtnPrevious() {
    }
    
    private final void setupBtnRefresh() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void attachPresenter() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void releaseViewPager() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void showUIBeforeLoadResultData(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption chosenOptions) {
    }
    
    @java.lang.Override()
    public void showUIBeforeLoadResultData() {
    }
    
    @java.lang.Override()
    public void showUIBeforeLoadResultData(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructor) {
    }
    
    @java.lang.Override()
    public void displaySearchReuslt(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> searchList) {
    }
    
    @java.lang.Override()
    public void openPlayingVideosScreen(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data) {
    }
    
    @java.lang.Override()
    public void onRequestFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    @java.lang.Override()
    public void onMediaRouterDisconnected() {
    }
    
    private final void registerRouterChangedListener() {
    }
    
    private final void unregisterRouterChangedListener() {
    }
    
    @java.lang.Override()
    public void onAnyVideoSelected(boolean isAnyVideoNotDownloaded) {
    }
    
    @java.lang.Override()
    public void onNoVideoSelected() {
    }
    
    @java.lang.Override()
    public void onAllVideosSelected() {
    }
    
    @java.lang.Override()
    public void onNoAllVideosSelected() {
    }
    
    @java.lang.Override()
    public void addAllVideosForPlay() {
    }
    
    @java.lang.Override()
    public void onShowPlayingVideoDialog(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter getPresenter() {
        return null;
    }
    
    public SearchResultFragment() {
        super();
    }
    
    public void onClearVideos() {
    }
    
    public void onMediaRouterConnected() {
    }
    
    public void onUpdateVideos(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo playingVideo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingVideos) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\u0018j\b\u0012\u0004\u0012\u00020%`&J\u000e\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0012J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+J&\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020\f2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\u0018j\b\u0012\u0004\u0012\u00020%`&J\u000e\u0010.\u001a\u00020-2\u0006\u0010(\u001a\u00020\u0012J\u000e\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010\u00a8\u00063"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/SearchResultFragment$Companion;", "", "()V", "EXTRA_TYPE", "", "KEY_BRAND_ID", "KEY_INSTRUCTOR", "MSG_CANT_LOAD_VIDEOS_BECAUSE_NO_INSTRUCTOR_ID", "TAG", "TAG_CHOSEN", "TAG_HMC", "brandIdSearch", "", "getBrandIdSearch", "()I", "setBrandIdSearch", "(I)V", "instructorSearch", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;", "getInstructorSearch", "()Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;", "setInstructorSearch", "(Lplayer/wellnesssolutions/com/network/models/screen_search/MMInstructor;)V", "mVideosToPlay", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "getMVideosToPlay", "()Ljava/util/ArrayList;", "setMVideosToPlay", "(Ljava/util/ArrayList;)V", "typeSearch", "getTypeSearch", "setTypeSearch", "getBundleByHelpMeChoose", "Landroid/os/Bundle;", "brandId", "answers", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "Lkotlin/collections/ArrayList;", "getBundleByInstructor", "instructor", "getBundleBySearchedOptions", "chosenOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "getInstanceByHelpMeChoose", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/SearchResultFragment;", "getInstanceByInstructor", "getInstanceBySearchedOptions", "searchedOptions", "getTagOfChosen", "getTagOfHMCForDB", "app_debug"})
    public static final class Companion {
        
        public final int getTypeSearch() {
            return 0;
        }
        
        public final void setTypeSearch(int p0) {
        }
        
        public final int getBrandIdSearch() {
            return 0;
        }
        
        public final void setBrandIdSearch(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final player.wellnesssolutions.com.network.models.screen_search.MMInstructor getInstructorSearch() {
            return null;
        }
        
        public final void setInstructorSearch(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.network.models.screen_search.MMInstructor p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getMVideosToPlay() {
            return null;
        }
        
        public final void setMVideosToPlay(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> p0) {
        }
        
        /**
         * @param chosenOptions: selected options that user picked in screen SearchPreview
         */
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment getInstanceBySearchedOptions(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption searchedOptions) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getBundleBySearchedOptions(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption chosenOptions) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTagOfChosen() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment getInstanceByHelpMeChoose(int brandId, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> answers) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getBundleByHelpMeChoose(int brandId, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> answers) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTagOfHMCForDB() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment getInstanceByInstructor(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructor) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getBundleByInstructor(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMInstructor instructor) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}