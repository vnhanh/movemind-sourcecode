package player.wellnesssolutions.com.base.common.play_video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract;", "", "Manager", "ViewCallback", "app_debug"})
public abstract interface IPlayVideoContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$ViewCallback;", "", "onCookieExpired", "", "onPlayerInitialized", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isReload", "", "app_debug"})
    public static abstract interface ViewCallback {
        
        public abstract void onPlayerInitialized(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.SimpleExoPlayer player, boolean isReload);
        
        public abstract void onCookieExpired();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u00002\u00020\u0001:\u00015J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u0019\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0012H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0003H&J.\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00172\b\b\u0002\u0010&\u001a\u00020\u0017H&J\b\u0010\'\u001a\u00020\u0003H&J\u001a\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H&J\b\u0010+\u001a\u00020\u0003H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0012H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010/\u001a\u00020\u0003H&J*\u00100\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017H&J\b\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u000eH&J\b\u00104\u001a\u00020\u0003H&\u00a8\u00066"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager;", "", "addListener", "", "listener", "Lcom/google/android/exoplayer2/Player$EventListener;", "addVideo", "video", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "addVideos", "videos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getClosedCaptionController", "Lplayer/wellnesssolutions/com/base/common/play_video/ClosedCaptionController;", "getCurrentPosition", "", "getPlaybackState", "", "getPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "handleOnEnded", "hasPlayer", "", "isPlayerError", "isPlaying", "isPlayingCC", "onChangedVolume", "progress", "onClickedLanguageSubtitle", "value", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideoLanguage;", "onDestroy", "onInitialize", "playedVideoPosition", "typeVideo", "Lplayer/wellnesssolutions/com/custom_exoplayer/EnumTypeViewVideo;", "isUpdateViewNumber", "isSupportCC", "onPause", "onReleasePlayer", "isKeepPosition", "keepPlayWhenReady", "onResume", "playVideoAt", "index", "removeListener", "replay", "resumeOrIntialize", "selectLanguageCCOption", "setSubtitleController", "closedCaptionController", "slideNextLanguageCCOption", "Callback", "app_debug"})
    public static abstract interface Manager {
        
        public abstract void addListener(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player.EventListener listener);
        
        public abstract void removeListener(@org.jetbrains.annotations.NotNull()
        com.google.android.exoplayer2.Player.EventListener listener);
        
        public abstract void resumeOrIntialize(long playedVideoPosition, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo typeVideo, boolean isUpdateViewNumber, boolean isSupportCC);
        
        public abstract void onInitialize(long playedVideoPosition, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo typeVideo, boolean isUpdateViewNumber, boolean isSupportCC);
        
        public abstract void addVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos);
        
        public abstract void addVideo(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo video);
        
        public abstract void playVideoAt(int index);
        
        public abstract void onChangedVolume(int progress);
        
        public abstract void setSubtitleController(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController closedCaptionController);
        
        public abstract void onClickedLanguageSubtitle(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage value);
        
        public abstract void replay();
        
        public abstract void handleOnEnded();
        
        @org.jetbrains.annotations.Nullable()
        public abstract player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController getClosedCaptionController();
        
        public abstract void slideNextLanguageCCOption();
        
        public abstract void selectLanguageCCOption();
        
        public abstract void onPause();
        
        public abstract void onResume();
        
        public abstract void onReleasePlayer(boolean isKeepPosition, boolean keepPlayWhenReady);
        
        public abstract void onDestroy();
        
        public abstract long getCurrentPosition();
        
        public abstract boolean isPlaying();
        
        public abstract boolean hasPlayer();
        
        public abstract boolean isPlayerError();
        
        public abstract int getPlaybackState();
        
        public abstract boolean isPlayingCC();
        
        @org.jetbrains.annotations.Nullable()
        public abstract com.google.android.exoplayer2.SimpleExoPlayer getPlayer();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager$Callback;", "", "onCookieExpired", "", "onPlayNext", "onPlayerInitialized", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "onReload", "onStartIntializePlayer", "app_debug"})
        public static abstract interface Callback {
            
            public abstract void onStartIntializePlayer();
            
            public abstract void onPlayerInitialized(@org.jetbrains.annotations.NotNull()
            com.google.android.exoplayer2.SimpleExoPlayer player);
            
            public abstract void onPlayNext();
            
            public abstract void onReload();
            
            public abstract void onCookieExpired();
            
            @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
            public static final class DefaultImpls {
                
                public static void onPlayNext(@org.jetbrains.annotations.NotNull()
                player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager.Callback $this) {
                }
                
                public static void onReload(@org.jetbrains.annotations.NotNull()
                player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager.Callback $this) {
                }
            }
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static boolean hasPlayer(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager $this) {
                return false;
            }
        }
    }
}