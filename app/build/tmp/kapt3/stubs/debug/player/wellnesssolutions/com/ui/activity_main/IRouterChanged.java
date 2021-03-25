package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/IRouterChanged;", "", "onClearVideos", "", "onMediaRouterConnected", "onMediaRouterDisconnected", "onUpdateVideos", "playingVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "comingVideos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
public abstract interface IRouterChanged {
    
    public abstract void onMediaRouterConnected();
    
    public abstract void onMediaRouterDisconnected();
    
    public abstract void onUpdateVideos(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo playingVideo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingVideos);
    
    public abstract void onClearVideos();
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void onMediaRouterConnected(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.activity_main.IRouterChanged $this) {
        }
        
        public static void onMediaRouterDisconnected(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.activity_main.IRouterChanged $this) {
        }
        
        public static void onUpdateVideos(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.activity_main.IRouterChanged $this, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo playingVideo, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingVideos) {
        }
        
        public static void onClearVideos(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.activity_main.IRouterChanged $this) {
        }
    }
}