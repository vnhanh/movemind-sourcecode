package player.wellnesssolutions.com.ui.fragment_now_playing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct;", "", "Presenter", "View", "app_debug"})
public abstract interface INowPlayingConstruct {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\bH&J\u0017\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0012H&J\b\u0010 \u001a\u00020\bH\u0016J(\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020#0%j\b\u0012\u0004\u0012\u00020#`&H\u0016\u00a8\u0006\'"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$ViewCallback;", "Lcom/google/android/exoplayer2/Player$EventListener;", "backToHomeScreenWithNotLoadSchedule", "", "hideControlWhenNextVideoSchedule", "hideCountDownTimer", "hideGroupViewsComingUpNext", "isCastableOnTV", "", "onIntermediateStage", "onLoadScheduleWhilePlaySearchedVideos", "onLoadingVideoDelay", "playedPosition", "", "onStartInitializePlayer", "onVideoEnded", "openNoClassSearchScreen", "isClickedButtonHome", "(Ljava/lang/Boolean;)V", "openTimeTableScreen", "reloadScheduledVideo", "returnPrevScreen", "setupViewFloatMenu", "configData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "showCountDownPlayTime", "millisUntilFinished", "showDialogAskWantToLoadSchedule", "showUIForPlayingVideo", "videoData", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "comingUpVideos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.IProgressView, player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View, player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.ViewCallback, com.google.android.exoplayer2.Player.EventListener {
        
        public abstract void showUIForPlayingVideo(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos);
        
        public abstract void returnPrevScreen();
        
        public abstract void openNoClassSearchScreen(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean isClickedButtonHome);
        
        public abstract void hideGroupViewsComingUpNext();
        
        public abstract void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.config.MMConfigData configData);
        
        public abstract void onLoadingVideoDelay(long playedPosition);
        
        public abstract void showCountDownPlayTime(long millisUntilFinished);
        
        public abstract void onVideoEnded();
        
        public abstract void onStartInitializePlayer();
        
        public abstract void onIntermediateStage();
        
        public abstract void reloadScheduledVideo();
        
        public abstract void openTimeTableScreen();
        
        public abstract void hideCountDownTimer();
        
        public abstract void hideControlWhenNextVideoSchedule();
        
        public abstract void showDialogAskWantToLoadSchedule();
        
        public abstract void onLoadScheduleWhilePlaySearchedVideos();
        
        public abstract void backToHomeScreenWithNotLoadSchedule();
        
        public abstract boolean isCastableOnTV();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void showUIForPlayingVideo(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos) {
            }
            
            public static void returnPrevScreen(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void openNoClassSearchScreen(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.Nullable()
            java.lang.Boolean isClickedButtonHome) {
            }
            
            public static void hideGroupViewsComingUpNext(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.config.MMConfigData configData) {
            }
            
            public static void onLoadingVideoDelay(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, long playedPosition) {
            }
            
            public static void openTimeTableScreen(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void hideCountDownTimer(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void hideControlWhenNextVideoSchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void showDialogAskWantToLoadSchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void onLoadScheduleWhilePlaySearchedVideos(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            public static void backToHomeScreenWithNotLoadSchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            @java.lang.Override()
            public static void onEndLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            @java.lang.Override()
            public static void onGetBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
            java.lang.String searchBrandFlowTag) {
            }
            
            @java.lang.Override()
            public static void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
            java.lang.String nextScreenTag) {
            }
            
            @java.lang.Override()
            public static void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @java.lang.Override()
            public static void onLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int msgColor, boolean isClickedFromBtnBottom) {
            }
            
            @java.lang.Override()
            public static void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
            }
            
            @java.lang.Override()
            public static void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
            }
            
            @java.lang.Override()
            public static void onTimePlaySchedule(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this) {
            }
            
            @java.lang.Override()
            public static void showDialogAskWantToBackToHome(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View $this, boolean isLoadSchedule) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u000eH&J\b\u0010\u0016\u001a\u00020\u000eH&J\b\u0010\u0017\u001a\u00020\u000eH&J\b\u0010\u0018\u001a\u00020\u000eH&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010!\u001a\u00020\u0006H&J\u0017\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010 H&\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0006H&J\b\u0010&\u001a\u00020\u0006H&J\b\u0010\'\u001a\u00020\u0006H&J\b\u0010(\u001a\u00020\u0006H&J\b\u0010)\u001a\u00020\u000eH&J\b\u0010*\u001a\u00020\u0006H&J\b\u0010+\u001a\u00020\u0006H&J\b\u0010,\u001a\u00020\u0006H&J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\fH&J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u000201H&J \u00102\u001a\u00020\u00062\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&J\b\u00104\u001a\u00020\u0006H&J\b\u00105\u001a\u00020\u0006H&J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H&J \u00108\u001a\u00020\u00062\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH&\u00a8\u0006:"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "Lplayer/wellnesssolutions/com/ui/fragment_home/helper/IListenerHandleScheduleTime;", "clickToCallServiceLoadSchedule", "", "getAllVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "getCurrentPlayedPosition", "", "getIsCountDown", "", "getNowPlayVideo", "getPlayerManager", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager;", "getPlayerState", "Lplayer/wellnesssolutions/com/custom_exoplayer/PlayerState;", "hideClosedCaptionView", "isPlayerError", "isPlayingCC", "isPlayingVideo", "isShowClosedCaptionView", "loadBrands", "tag", "", "onChangeVolume", "context", "Landroid/content/Context;", "progress", "", "onClickedComingUpNextItem", "onPlayerEnded", "videoId", "(Ljava/lang/Integer;)V", "onReconnectNetwork", "openTimeTableScreen", "pausePlayer", "pauseVideo", "playNextVideo", "replayVideo", "resumeOrReplay", "selectLanguageCCOption", "setPlayedPosition", "position", "setSubtitleController", "closedCaptionController", "Lplayer/wellnesssolutions/com/base/common/play_video/ClosedCaptionController;", "setVideos", "videos", "showClosedCaptionView", "slideNextLanguageCCOption", "startToPlayScheduleVideo", "stopCountdown", "switchToPlayScheduleVideos", "scheduleVideos", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View>, player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener, player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime {
        
        public abstract void onChangeVolume(@org.jetbrains.annotations.NotNull()
        android.content.Context context, int progress);
        
        public abstract void pausePlayer();
        
        @org.jetbrains.annotations.NotNull()
        public abstract player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager getPlayerManager();
        
        @org.jetbrains.annotations.Nullable()
        public abstract java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getAllVideos();
        
        public abstract void onReconnectNetwork();
        
        public abstract void replayVideo();
        
        public abstract boolean playNextVideo();
        
        public abstract void pauseVideo();
        
        public abstract void resumeOrReplay();
        
        public abstract void setVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        public abstract void setPlayedPosition(long position);
        
        public abstract void setSubtitleController(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController closedCaptionController);
        
        public abstract void switchToPlayScheduleVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos);
        
        public abstract void onClickedComingUpNextItem();
        
        public abstract void showClosedCaptionView();
        
        public abstract void hideClosedCaptionView();
        
        public abstract void slideNextLanguageCCOption();
        
        public abstract void selectLanguageCCOption();
        
        public abstract boolean isPlayingVideo();
        
        public abstract boolean isPlayerError();
        
        public abstract long getCurrentPlayedPosition();
        
        public abstract void onPlayerEnded(@org.jetbrains.annotations.Nullable()
        java.lang.Integer videoId);
        
        public abstract boolean isPlayingCC();
        
        public abstract boolean isShowClosedCaptionView();
        
        @org.jetbrains.annotations.Nullable()
        public abstract player.wellnesssolutions.com.network.models.now_playing.MMVideo getNowPlayVideo();
        
        @org.jetbrains.annotations.NotNull()
        public abstract player.wellnesssolutions.com.custom_exoplayer.PlayerState getPlayerState();
        
        public abstract void loadBrands(@org.jetbrains.annotations.NotNull()
        java.lang.String tag);
        
        public abstract void openTimeTableScreen();
        
        public abstract void stopCountdown();
        
        public abstract boolean getIsCountDown();
        
        public abstract void startToPlayScheduleVideo();
        
        public abstract void clickToCallServiceLoadSchedule();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void startToPlayScheduleVideo(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter $this) {
            }
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter $this) {
            }
            
            @java.lang.Override()
            public static void onHaveVideoAfter(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter $this, long playedPosition, boolean isRequestFromUser) {
            }
            
            @java.lang.Override()
            public static void onVideoExpiredTime(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter $this) {
            }
        }
    }
}