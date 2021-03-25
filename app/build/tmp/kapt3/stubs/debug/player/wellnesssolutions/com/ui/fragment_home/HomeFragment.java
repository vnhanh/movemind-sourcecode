package player.wellnesssolutions.com.ui.fragment_home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J(\u0010$\u001a\u00020\u000b2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\u000b2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(H\u0016J\"\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00112\b\b\u0001\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0016J\b\u00101\u001a\u00020\u000bH\u0016J\b\u00102\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020\u000bH\u0016J \u00106\u001a\u00020\u000b2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(H\u0016J\b\u00107\u001a\u00020\u000bH\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u000bH\u0016J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u0002002\u0006\u0010<\u001a\u000200H\u0016J\u0018\u0010:\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010<\u001a\u000200H\u0016J\u0012\u0010=\u001a\u00020\u000b2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/HomeFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseScheduleFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$View;", "()V", "handler", "Landroid/os/Handler;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$Presenter;", "runnableAttachPresenterFirstTime", "Ljava/lang/Runnable;", "checkSubIsChange", "", "context", "Landroid/content/Context;", "continueDownload", "it", "convertButtonText", "", "input", "getAllVideosForDownload", "hideLoadingProgress", "loadControlScreen", "loadNowPlayingScreen", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onClickedButtonGetStarted", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onHaveClassVideos", "scheduleVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "isClickedFromBtnBottom", "", "onHaveClassVideosWithTimeWaiting", "videos", "onNoClassVideosForNow", "message", "msgColor", "", "onPause", "onReceiveChangeSub", "onResume", "onStop", "onTimePlaySchedule", "openNowPlayingScreen", "registerScheduleBroadcast", "setupUI", "showLoadingProgress", "showMessage", "messageRes", "color", "showUI", "loadedConfig", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "unregisterScheduleBroadcast", "Companion", "app_debug"})
public final class HomeFragment extends player.wellnesssolutions.com.base.view.BaseScheduleFragment implements player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View {
    private player.wellnesssolutions.com.ui.fragment_home.IHomeContract.Presenter presenter;
    private final android.os.Handler handler = null;
    
    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */
    private final java.lang.Runnable runnableAttachPresenterFirstTime = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "HomeFragment";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_home.HomeFragment.Companion Companion = null;
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void continueDownload(android.content.Context it) {
    }
    
    private final void checkSubIsChange(android.content.Context context) {
    }
    
    private final void getAllVideosForDownload(android.content.Context context) {
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override()
    public void openNowPlayingScreen(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    @java.lang.Override()
    public void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    private final void registerScheduleBroadcast() {
    }
    
    private final void unregisterScheduleBroadcast() {
    }
    
    private final void onClickedButtonGetStarted() {
    }
    
    @java.lang.Override()
    public void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int msgColor, boolean isClickedFromBtnBottom) {
    }
    
    @java.lang.Override()
    public void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
    }
    
    @java.lang.Override()
    public void onTimePlaySchedule() {
    }
    
    private final void loadControlScreen() {
    }
    
    private final void loadNowPlayingScreen() {
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
    public void showUI(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.config.MMConfigData loadedConfig) {
    }
    
    @java.lang.Override()
    public void onReceiveChangeSub() {
    }
    
    private final java.lang.String convertButtonText(java.lang.String input) {
        return null;
    }
    
    public HomeFragment() {
        super();
    }
    
    /**
     * -------------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/HomeFragment$Companion;", "", "()V", "TAG", "", "getInstanceNoLoadSchedule", "Lplayer/wellnesssolutions/com/ui/fragment_home/HomeFragment;", "getInstanceWithLoadSchedule", "updateAlreadyInstanceWithLoadSchedule", "fragment", "updateAlreadyInstanceWithNoSchedule", "Landroidx/fragment/app/Fragment;", "updateAlreadyInstanceWithNotLoadSchedule", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_home.HomeFragment getInstanceWithLoadSchedule() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_home.HomeFragment updateAlreadyInstanceWithLoadSchedule(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_home.HomeFragment fragment) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_home.HomeFragment getInstanceNoLoadSchedule() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.Fragment updateAlreadyInstanceWithNoSchedule(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_home.HomeFragment fragment) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.Fragment updateAlreadyInstanceWithNotLoadSchedule(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_home.HomeFragment fragment) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}