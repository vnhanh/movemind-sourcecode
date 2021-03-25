package player.wellnesssolutions.com.ui.fragment_home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract;", "", "Presenter", "View", "app_debug"})
public abstract interface IHomeContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\r"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "openNowPlayingScreen", "", "videos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "showUI", "loadedConfig", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.view.IProgressView, player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View {
        
        public abstract void showUI(@org.jetbrains.annotations.Nullable()
        player.wellnesssolutions.com.network.models.config.MMConfigData loadedConfig);
        
        public abstract void openNowPlayingScreen(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int msgColor, boolean isClickedFromBtnBottom) {
            }
            
            @java.lang.Override()
            public static void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
            }
            
            @java.lang.Override()
            public static void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
            }
            
            @java.lang.Override()
            public static void onTimePlaySchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this) {
            }
            
            @java.lang.Override()
            public static void showDialogAskWantToBackToHome(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View $this, boolean isLoadSchedule) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$View;", "onTimePlayAlreadySchedule", "", "setScheduleCurrent", "videos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View> {
        
        public abstract void setScheduleCurrent(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        public abstract void onTimePlayAlreadySchedule();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_home.IHomeContract.Presenter $this) {
            }
        }
    }
}