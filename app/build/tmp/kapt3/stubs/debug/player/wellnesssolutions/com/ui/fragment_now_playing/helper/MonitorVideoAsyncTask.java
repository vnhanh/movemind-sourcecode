package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask;", "Ljava/lang/Runnable;", "view", "Landroid/view/View;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask$Listener;", "(Landroid/view/View;Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask$Listener;)V", "mIsStop", "", "mPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "mVideoId", "", "Ljava/lang/Integer;", "mVideoLength", "", "mWeakListener", "Ljava/lang/ref/WeakReference;", "mWeakPresenter", "mWeakView", "isStop", "run", "", "startTask", "stopTask", "Listener", "app_debug"})
public final class MonitorVideoAsyncTask implements java.lang.Runnable {
    private final java.lang.ref.WeakReference<android.view.View> mWeakView = null;
    private final java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter> mWeakPresenter = null;
    private final java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask.Listener> mWeakListener = null;
    private com.google.android.exoplayer2.SimpleExoPlayer mPlayer;
    private java.lang.Integer mVideoId;
    private long mVideoLength = 0L;
    private boolean mIsStop = false;
    
    public final void stopTask() {
    }
    
    @java.lang.Override()
    public void run() {
    }
    
    public final void startTask() {
    }
    
    public final boolean isStop() {
        return false;
    }
    
    public MonitorVideoAsyncTask(@org.jetbrains.annotations.Nullable()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask.Listener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask$Listener;", "", "onUpdateVideoProgress", "", "isPlaying", "", "position", "", "app_debug"})
    public static abstract interface Listener {
        
        public abstract void onUpdateVideoProgress(boolean isPlaying, long position);
    }
}