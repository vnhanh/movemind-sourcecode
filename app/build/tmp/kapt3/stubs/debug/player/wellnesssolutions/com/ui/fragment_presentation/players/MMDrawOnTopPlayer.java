package player.wellnesssolutions.com.ui.fragment_presentation.players;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J,\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00192\u0012\u0010+\u001a\u000e\u0012\u0002\b\u00030\u001bj\u0006\u0012\u0002\b\u0003`\u001d2\u0006\u0010,\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J(\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\'2\u0006\u00106\u001a\u00020\'2\u0006\u00107\u001a\u00020\'H\u0016J\u0010\u00108\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0016J\u0010\u00109\u001a\u00020\u00132\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010:\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010;\u001a\u00020\u0013H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_presentation/players/MMDrawOnTopPlayer;", "Lplayer/wellnesssolutions/com/ui/fragment_presentation/players/MMLocalPlayer;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connection", "Landroid/content/ServiceConnection;", "mBound", "", "mPresentation", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder;", "mPresentationCallback", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder$Callback;", "mRoute", "Landroidx/mediarouter/media/MediaRouter$RouteInfo;", "mService", "Lplayer/wellnesssolutions/com/services/MMPresentationService;", "clearAllVideos", "", "connect", "route", "getLastPosition", "", "getMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "getVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "isPlayingNowPlaying", "isPlayingPresentation", "isPlayingSearchVideos", "isScreenSupported", "next", "onAppViewInVisible", "onAppViewVisible", "onPlayPresentationVideoAt", "position", "", "pause", "play", "mode", "item", "lastPosition", "release", "resume", "showNext", "startService", "stopService", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "updatePresentation", "updateSize", "Companion", "app_debug"})
public final class MMDrawOnTopPlayer extends player.wellnesssolutions.com.ui.fragment_presentation.players.MMLocalPlayer implements android.view.SurfaceHolder.Callback {
    private androidx.mediarouter.media.MediaRouter.RouteInfo mRoute;
    private player.wellnesssolutions.com.services.MMPresentationBinder mPresentation;
    private player.wellnesssolutions.com.services.MMPresentationService mService;
    private boolean mBound = false;
    private final android.content.ServiceConnection connection = null;
    private final player.wellnesssolutions.com.services.MMPresentationBinder.Callback mPresentationCallback = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "MMDrawOnTopPlayer";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_presentation.players.MMDrawOnTopPlayer.Companion Companion = null;
    
    @java.lang.Override()
    public boolean isScreenSupported() {
        return false;
    }
    
    @java.lang.Override()
    public void onAppViewVisible() {
    }
    
    @java.lang.Override()
    public void onAppViewInVisible() {
    }
    
    @java.lang.Override()
    public void play(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.datasource.videos.PlayMode mode, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<?> item, long lastPosition) {
    }
    
    @java.lang.Override()
    public boolean isPlayingNowPlaying() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlayingSearchVideos() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlayingPresentation() {
        return false;
    }
    
    @java.lang.Override()
    public void connect(@org.jetbrains.annotations.Nullable()
    androidx.mediarouter.media.MediaRouter.RouteInfo route) {
    }
    
    private final void startService() {
    }
    
    private final void stopService() {
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    @java.lang.Override()
    public void updatePresentation(@org.jetbrains.annotations.NotNull()
    androidx.mediarouter.media.MediaRouter.RouteInfo route) {
    }
    
    @java.lang.Override()
    public void resume() {
    }
    
    @java.lang.Override()
    public void pause() {
    }
    
    @java.lang.Override()
    public void next() {
    }
    
    @java.lang.Override()
    public void showNext() {
    }
    
    @java.lang.Override()
    public void surfaceChanged(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder, int format, int width, int height) {
    }
    
    @java.lang.Override()
    protected void updateSize() {
    }
    
    @java.lang.Override()
    public void surfaceCreated(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder) {
    }
    
    @java.lang.Override()
    public void surfaceDestroyed(@org.jetbrains.annotations.NotNull()
    android.view.SurfaceHolder holder) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public player.wellnesssolutions.com.network.datasource.videos.PlayMode getMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideos() {
        return null;
    }
    
    @java.lang.Override()
    public long getLastPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public void onPlayPresentationVideoAt(int position) {
    }
    
    @java.lang.Override()
    public void clearAllVideos() {
    }
    
    public MMDrawOnTopPlayer(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_presentation/players/MMDrawOnTopPlayer$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}