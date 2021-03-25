package player.wellnesssolutions.com.ui.fragment_presentation.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_presentation/presentation/MMPreInterface;", "", "View", "app_debug"})
public abstract interface MMPreInterface {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_presentation/presentation/MMPreInterface$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "initUI", "", "isPlaying", "", "isPlayingSchedule", "isPlayingSearchVideos", "setUpPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View {
        
        public abstract void initUI();
        
        public abstract void setUpPlayer(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.SimpleExoPlayer player);
        
        public abstract boolean isPlayingSchedule();
        
        public abstract boolean isPlayingSearchVideos();
        
        public abstract boolean isPlaying();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void initUI(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_presentation.presentation.MMPreInterface.View $this) {
            }
            
            public static void setUpPlayer(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_presentation.presentation.MMPreInterface.View $this, @org.jetbrains.annotations.NotNull()
            com.google.android.exoplayer2.SimpleExoPlayer player) {
            }
        }
    }
}