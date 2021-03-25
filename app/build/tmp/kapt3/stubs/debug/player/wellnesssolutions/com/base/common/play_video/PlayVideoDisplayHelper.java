package player.wellnesssolutions.com.base.common.play_video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0006J$\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u0012J4\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0015\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0006J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u001d"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/PlayVideoDisplayHelper;", "", "()V", "displayControllerPlayViews", "", "playWhenReady", "", "btnPlayVideo", "Landroid/view/View;", "btnPauseVideo", "controllerVisible", "displayLoading", "progress", "Landroid/widget/ProgressBar;", "isDisplayed", "displayOnEnded", "progressLoading", "Lplayer/wellnesssolutions/com/common/customize_views/MMProgressBar;", "Landroid/widget/ImageView;", "displayOnReady", "isControllerVisible", "displayPauseButton", "displayPlayButton", "displayView", "view", "displayViewsOnBuffering", "btnPlay", "btnPause", "hideAllButtons", "app_debug"})
public final class PlayVideoDisplayHelper {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.common.play_video.PlayVideoDisplayHelper INSTANCE = null;
    
    public final void displayViewsOnBuffering(@org.jetbrains.annotations.NotNull()
    android.widget.ProgressBar progress, @org.jetbrains.annotations.Nullable()
    android.view.View btnPlay, @org.jetbrains.annotations.Nullable()
    android.view.View btnPause) {
    }
    
    public final void displayOnReady(boolean isControllerVisible, boolean playWhenReady, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.common.customize_views.MMProgressBar progressLoading, @org.jetbrains.annotations.Nullable()
    android.view.View btnPlayVideo, @org.jetbrains.annotations.Nullable()
    android.view.View btnPauseVideo) {
    }
    
    public final void displayOnEnded(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.common.customize_views.MMProgressBar progressLoading, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView btnPlayVideo, @org.jetbrains.annotations.Nullable()
    android.widget.ImageView btnPauseVideo) {
    }
    
    public final void displayControllerPlayViews(boolean controllerVisible, boolean playWhenReady, @org.jetbrains.annotations.Nullable()
    android.view.View btnPlayVideo, @org.jetbrains.annotations.Nullable()
    android.view.View btnPauseVideo) {
    }
    
    public final void hideAllButtons(@org.jetbrains.annotations.Nullable()
    android.view.View btnPlayVideo, @org.jetbrains.annotations.Nullable()
    android.view.View btnPauseVideo) {
    }
    
    public final void displayControllerPlayViews(boolean playWhenReady, @org.jetbrains.annotations.Nullable()
    android.view.View btnPlayVideo, @org.jetbrains.annotations.Nullable()
    android.view.View btnPauseVideo) {
    }
    
    public final void displayLoading(@org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar progress, boolean isDisplayed) {
    }
    
    public final void displayPlayButton(@org.jetbrains.annotations.Nullable()
    android.view.View btnPlayVideo, boolean isDisplayed) {
    }
    
    public final void displayPauseButton(@org.jetbrains.annotations.Nullable()
    android.view.View btnPauseVideo, boolean isDisplayed) {
    }
    
    public final void displayView(@org.jetbrains.annotations.Nullable()
    android.view.View view, boolean isDisplayed) {
    }
    
    private PlayVideoDisplayHelper() {
        super();
    }
}