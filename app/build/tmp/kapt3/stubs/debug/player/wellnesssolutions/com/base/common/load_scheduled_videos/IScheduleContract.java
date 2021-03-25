package player.wellnesssolutions.com.base.common.load_scheduled_videos;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract;", "", "Presenter", "View", "app_debug"})
public abstract interface IScheduleContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J(\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00052\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016J$\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "onHaveClassVideos", "", "scheduleVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "isClickedFromBtnBottom", "", "onHaveClassVideosWithTimeWaiting", "videos", "onNoClassVideosForNow", "message", "", "msgColor", "", "onTimePlaySchedule", "showDialogAskWantToBackToHome", "isLoadSchedule", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IProgressView, player.wellnesssolutions.com.base.view.IShowMessageView {
        
        public abstract void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @androidx.annotation.ColorRes()
        int msgColor, boolean isClickedFromBtnBottom);
        
        public abstract void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom);
        
        public abstract void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        public abstract void onTimePlaySchedule();
        
        public abstract void showDialogAskWantToBackToHome(boolean isLoadSchedule);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int msgColor, boolean isClickedFromBtnBottom) {
            }
            
            public static void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
            }
            
            public static void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
            }
            
            public static void onTimePlaySchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this) {
            }
            
            public static void showDialogAskWantToBackToHome(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, boolean isLoadSchedule) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J \u0010\r\u001a\u00020\u00032\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&\u00a8\u0006\u0013"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$Presenter;", "", "onAttach", "", "view", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "onDestroy", "onDetach", "onLoadSchedule", "isClickedFromBtnBottom", "", "mustLoad", "onTimePlaySchedule", "setScheduleCurrentAndWaitNextVideo", "videos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "setStateLoadScheduleOnStart", "app_debug"})
    public static abstract interface Presenter {
        
        public abstract void onLoadSchedule(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View view, boolean isClickedFromBtnBottom, boolean mustLoad);
        
        public abstract void onDetach();
        
        public abstract void onDestroy();
        
        public abstract void onAttach(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View view);
        
        public abstract void setScheduleCurrentAndWaitNextVideo(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        public abstract void onTimePlaySchedule();
        
        public abstract void setStateLoadScheduleOnStart();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
        }
    }
}