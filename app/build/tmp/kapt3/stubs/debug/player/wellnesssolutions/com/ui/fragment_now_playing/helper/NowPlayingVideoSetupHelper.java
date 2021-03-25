package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J:\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J.\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u0010\u0010\'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010+\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010)J\u001c\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0002J0\u00100\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J:\u00101\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J&\u00102\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u000105H\u0002J&\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00152\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u00104\u001a\u0004\u0018\u00010:J\u001a\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u001bH\u0002J$\u0010?\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u00104\u001a\u0004\u0018\u000105H\u0002J:\u0010@\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0002J0\u0010A\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00152\b\u00104\u001a\u0004\u0018\u000105H\u0002J\"\u0010B\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00152\b\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010C\u001a\u00020\bJ0\u0010D\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010E\u001a\u0004\u0018\u00010\u00152\b\u0010F\u001a\u0004\u0018\u00010G2\b\u00104\u001a\u0004\u0018\u000105H\u0002J \u0010H\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010I\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingVideoSetupHelper;", "", "()V", "SUBTITLES_TEXTSIZE", "", "getSUBTITLES_TEXTSIZE", "()I", "isClicked", "", "isVideoPlayerFullScreen", "mBottomBarHeight", "mIsPresentation", "mLatestVolumeLevel", "Lplayer/wellnesssolutions/com/custom_exoplayer/EnumVolumeLevel;", "mRvTouchedX", "", "mRvTouchedY", "mScreenHeight", "clickedBtnComingUpNext", "", "groupViewsComingUpNext", "Landroid/view/View;", "clickedButtonExoFullScreen", "parenView", "videoPlayer", "Lcom/google/android/exoplayer2/ui/PlayerView;", "btnExoFullScreen", "Landroid/widget/ImageView;", "viewBottomVideoPlayer", "barBottom", "getHeight", "context", "Landroid/content/Context;", "text", "", "textSize", "typeface", "Landroid/graphics/Typeface;", "padding", "openHomeFragmentWithLoadSchedule", "fm", "Landroidx/fragment/app/FragmentManager;", "openHomeFragmentWithNotLoadSchedule", "openNowPlayingWithSchedule", "setBackgroundForVideoNowPlaying", "wrapperVideoNowPlaying", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/recyclerview/MMVideoNowPlayingView;", "bgNowPlayingItemViedeo", "setFullScreenPlayerVideo", "setNormalViewPlayerVideo", "setupButtonOfVideo", "parentView", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "setupComingUpNext", "view", "menuSetupHelper", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingFloatMenuHelper;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "setupDownloadButton", "resources", "Landroid/content/res/Resources;", "btnDownload", "setupPlayerViews", "setupToggleFullScreenButton", "setupVideoPlayer", "setupViewsForPlayer", "isPresentation", "setupVolumeButton", "frameExoVolumeSeekbar", "seekbarExoVolume", "Landroid/widget/SeekBar;", "showDialogNavigateToNoClassScreen", "isClickedFromBtnBottom", "app_debug"})
public final class NowPlayingVideoSetupHelper {
    private static int mBottomBarHeight = 0;
    private static int mScreenHeight = 0;
    private static final int SUBTITLES_TEXTSIZE = 30;
    private static boolean mIsPresentation = false;
    private static boolean isClicked = false;
    
    /**
     * call from {@link #setupVideoPlayer()}
     */
    private static boolean isVideoPlayerFullScreen = false;
    
    /**
     * call from {@link #setupVideoPlayer()}
     */
    private static player.wellnesssolutions.com.custom_exoplayer.EnumVolumeLevel mLatestVolumeLevel = player.wellnesssolutions.com.custom_exoplayer.EnumVolumeLevel.UP;
    private static float mRvTouchedX = 0.0F;
    private static float mRvTouchedY = 0.0F;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoSetupHelper INSTANCE = null;
    
    public final int getSUBTITLES_TEXTSIZE() {
        return 0;
    }
    
    public final void setupViewsForPlayer(@org.jetbrains.annotations.NotNull()
    android.view.View parentView, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter, boolean isPresentation) {
    }
    
    private final void setupPlayerViews(android.view.View parentView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    private final void setupButtonOfVideo(android.view.View parentView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    private final void setupDownloadButton(android.content.res.Resources resources, android.widget.ImageView btnDownload) {
    }
    
    /**
     * call from {@link #setupUI()}
     */
    private final void setupVideoPlayer(android.view.View parentView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.view.View barBottom, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    public final int getHeight(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String text, float textSize, @org.jetbrains.annotations.NotNull()
    android.graphics.Typeface typeface, int padding) {
        return 0;
    }
    
    private final void setupToggleFullScreenButton(android.view.View parenView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.widget.ImageView btnExoFullScreen, android.view.View viewBottomVideoPlayer, android.view.View barBottom) {
    }
    
    private final void clickedButtonExoFullScreen(android.view.View parenView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.widget.ImageView btnExoFullScreen, android.view.View viewBottomVideoPlayer, android.view.View barBottom) {
    }
    
    private final void setupVolumeButton(com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.view.View frameExoVolumeSeekbar, android.widget.SeekBar seekbarExoVolume, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    /**
     * call from {@link #setupToggleFullScreenButton()}
     */
    private final void setFullScreenPlayerVideo(android.view.View parenView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.widget.ImageView btnExoFullScreen, android.view.View barBottom) {
    }
    
    /**
     * call from {@link #setupToggleFullScreenButton()}
     */
    private final void setNormalViewPlayerVideo(android.view.View parenView, com.google.android.exoplayer2.ui.PlayerView videoPlayer, android.widget.ImageView btnExoFullScreen, android.view.View viewBottomVideoPlayer, android.view.View barBottom) {
    }
    
    public final void setupComingUpNext(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingFloatMenuHelper menuSetupHelper, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter) {
    }
    
    private final void setBackgroundForVideoNowPlaying(player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.MMVideoNowPlayingView wrapperVideoNowPlaying, android.view.View bgNowPlayingItemViedeo) {
    }
    
    private final void clickedBtnComingUpNext(android.view.View groupViewsComingUpNext) {
    }
    
    public final void showDialogNavigateToNoClassScreen(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm, boolean isClickedFromBtnBottom) {
    }
    
    public final void openHomeFragmentWithLoadSchedule(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm) {
    }
    
    public final void openHomeFragmentWithNotLoadSchedule(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm) {
    }
    
    public final void openNowPlayingWithSchedule(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm) {
    }
    
    private NowPlayingVideoSetupHelper() {
        super();
    }
}