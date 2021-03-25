package player.wellnesssolutions.com.services;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\u0018\u0000 \u00a0\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0006\u009e\u0001\u009f\u0001\u00a0\u0001B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u001eJ\u0006\u0010I\u001a\u00020GJ\u0006\u0010J\u001a\u000203J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u0004\u0018\u00010NJ\u0006\u0010O\u001a\u00020;J\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"J\n\u0010Q\u001a\u0004\u0018\u00010$H\u0016J\b\u0010R\u001a\u00020GH\u0016J\b\u0010S\u001a\u00020GH\u0002J\b\u0010T\u001a\u00020GH\u0016J\b\u0010U\u001a\u00020GH\u0016J\b\u0010V\u001a\u00020GH\u0016J\b\u0010W\u001a\u00020GH\u0002J\b\u0010X\u001a\u00020\u0019H\u0016J\b\u0010Y\u001a\u00020\u0019H\u0016J\b\u0010Z\u001a\u00020\u0019H\u0016J\b\u0010[\u001a\u00020\u0019H\u0016J\b\u0010\\\u001a\u00020\u0019H\u0002J\u0006\u0010]\u001a\u00020GJ\u0006\u0010^\u001a\u00020GJ\u0006\u0010_\u001a\u00020GJ\b\u0010`\u001a\u00020GH\u0002J\b\u0010a\u001a\u00020GH\u0002J\b\u0010b\u001a\u00020GH\u0016J\u0006\u0010c\u001a\u00020GJ\u0006\u0010d\u001a\u00020GJ\b\u0010e\u001a\u00020GH\u0016J\u0010\u0010f\u001a\u00020G2\u0006\u0010g\u001a\u000203H\u0016J\b\u0010h\u001a\u00020GH\u0002J\u000e\u0010i\u001a\u00020G2\u0006\u0010j\u001a\u00020kJ\u0018\u0010l\u001a\u00020G2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u0019H\u0016J\u0018\u0010p\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00192\u0006\u0010r\u001a\u00020kH\u0016J\b\u0010s\u001a\u00020GH\u0016J\b\u0010t\u001a\u00020GH\u0016J\b\u0010u\u001a\u00020GH\u0016J\u0018\u0010v\u001a\u00020G2\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010j\u001a\u000203H\u0016J\b\u0010w\u001a\u00020GH\u0016J\u0017\u0010x\u001a\u00020G2\b\u0010y\u001a\u0004\u0018\u00010\u0019H\u0016\u00a2\u0006\u0002\u0010zJ\u0006\u0010{\u001a\u00020GJ\u0006\u0010|\u001a\u00020GJ\b\u0010}\u001a\u00020GH\u0002J$\u0010~\u001a\u00020G2\u001a\u0010\u007f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"H\u0002J\t\u0010\u0080\u0001\u001a\u00020GH\u0002J\t\u0010\u0081\u0001\u001a\u00020GH\u0002J\t\u0010\u0082\u0001\u001a\u00020GH\u0016J\u0007\u0010\u0083\u0001\u001a\u00020GJ\t\u0010\u0084\u0001\u001a\u00020GH\u0002J\t\u0010\u0085\u0001\u001a\u00020GH\u0002J\u0011\u0010\u0086\u0001\u001a\u00020G2\u0006\u0010Y\u001a\u00020\u0019H\u0002J\t\u0010\u0087\u0001\u001a\u00020GH\u0002J\u0010\u0010\u0088\u0001\u001a\u00020G2\u0007\u0010\u0089\u0001\u001a\u00020\u0011J\u0010\u0010\u008a\u0001\u001a\u00020G2\u0007\u0010\u008b\u0001\u001a\u000207J\t\u0010\u008c\u0001\u001a\u00020GH\u0002J1\u0010\u008d\u0001\u001a\u00020G2\u0007\u0010\u008e\u0001\u001a\u00020N2\u0016\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"2\u0007\u0010\u008f\u0001\u001a\u000203J\t\u0010\u0090\u0001\u001a\u00020GH\u0002J\t\u0010\u0091\u0001\u001a\u00020GH\u0002J\t\u0010\u0092\u0001\u001a\u00020GH\u0002J\u0007\u0010\u0093\u0001\u001a\u00020GJ\t\u0010\u0094\u0001\u001a\u00020GH\u0002J\u0012\u0010\u0095\u0001\u001a\u00020G2\u0007\u0010\u0096\u0001\u001a\u000203H\u0016J\t\u0010\u0097\u0001\u001a\u00020GH\u0016J\u0007\u0010\u0098\u0001\u001a\u00020GJ\t\u0010\u0099\u0001\u001a\u00020GH\u0002J+\u0010\u009a\u0001\u001a\u00020G2\u0007\u0010\u009b\u0001\u001a\u00020!2\u0017\u0010\u009c\u0001\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0016J\t\u0010\u009d\u0001\u001a\u00020GH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010 j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010 j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a1\u0001"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationBinder;", "Landroid/os/Binder;", "Lplayer/wellnesssolutions/com/ui/fragment_presentation/presentation/MMPreInterface$View;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask$Listener;", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$UIListener;", "listener", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder$BinderListener;", "(Lplayer/wellnesssolutions/com/services/MMPresentationBinder$BinderListener;)V", "btnComingUpNext", "Landroid/widget/TextView;", "btnMenuFloat", "Landroid/view/View;", "btnPauseVideo", "Landroid/widget/ImageView;", "btnPlayVideo", "frameExoVolume", "Landroid/view/ViewGroup;", "groupCollections", "Landroid/widget/LinearLayout;", "groupViewsComingUpNext", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageBgHomeScreen", "Lplayer/wellnesssolutions/com/common/customize_views/MMBackGroundView;", "isShowing", "", "getListener", "()Lplayer/wellnesssolutions/com/services/MMPresentationBinder$BinderListener;", "setListener", "mCallback", "Lplayer/wellnesssolutions/com/services/MMPresentationBinder$Callback;", "mComingUpVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "mContext", "Landroid/content/Context;", "mDisplay", "Landroid/view/Display;", "getMDisplay", "()Landroid/view/Display;", "setMDisplay", "(Landroid/view/Display;)V", "mExtraComingCollectionViews", "mExtraPlayingCollectionViews", "mIsLoadingNewVideo", "mIsRunnableStop", "mMonitorVideoAsyncTask", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask;", "mNowVideo", "mNowVideoLength", "", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "mRouter", "Landroidx/mediarouter/media/MediaRouter$RouteInfo;", "mRunnable", "Ljava/lang/Runnable;", "mService", "Lplayer/wellnesssolutions/com/services/MMPresentationService;", "mView", "progressLoadingVideo", "Lplayer/wellnesssolutions/com/common/customize_views/MMProgressBar;", "rvComingUpNext", "Landroidx/recyclerview/widget/RecyclerView;", "tvCountdownTimerUntilPlay", "Lplayer/wellnesssolutions/com/common/customize_views/MMTextView;", "videoPlayer", "Lcom/google/android/exoplayer2/ui/PlayerView;", "videoTitle", "addCallback", "", "callback", "clearAllVideos", "getCurrentVideoPosition", "getFragment", "Landroidx/fragment/app/Fragment;", "getPlayMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "getService", "getVideos", "getViewContext", "hideControlWhenNextVideoSchedule", "hideCountDown", "hideCountDownTimer", "hideGroupViewsComingUpNext", "hideLoadingProgress", "hideTitleAndCollections", "isCastableOnTV", "isPlaying", "isPlayingSchedule", "isPlayingSearchVideos", "isShowClosedCaptionView", "nextVideo", "onAppViewInVisible", "onAppViewVisible", "onClickedButtonPauseVideo", "onClickedButtonPlayVideo", "onCookieExpired", "onCreate", "onDestroy", "onIntermediateStage", "onLoadingVideoDelay", "playedPosition", "onNoVideoPlay", "onPlayPresentationVideoAt", "position", "", "onPlayerInitialized", "players", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isReload", "onPlayerStateChanged", "playWhenReady", "playbackState", "onReceivePauseVideoFromUI", "onReceivePlayVideoFromUI", "onStartInitializePlayer", "onUpdateVideoProgress", "onVideoEnded", "openNoClassSearchScreen", "isClickedButtonHome", "(Ljava/lang/Boolean;)V", "pause", "pauseOrPlay", "postDelayCheckVideoPosition", "readPlayingVideoData", "videos", "registerUICastingBroadcast", "releasePresenters", "reloadScheduledVideo", "resume", "sendEndedVideoStateToUI", "sendLoadingVideoStateToUI", "sendReadyVideoStateToUI", "sendTranslatedVideoStateToUI", "setContentView", "view", "setRouter", "router", "setupButtonPlayPauseVideo", "setupPlayVideo", "mode", "lastPosition", "setupUI", "setupVideoPlayerController", "setupVideoPlayerOnMode", "showClosedCaption", "showCountDown", "showCountDownPlayTime", "millisUntilFinished", "showLoadingProgress", "showNextVideo", "showTitleAndCollections", "showUIForPlayingVideo", "videoData", "comingUpVideos", "unregisterUICastingBroadcast", "BinderListener", "Callback", "Companion", "app_debug"})
public final class MMPresentationBinder extends android.os.Binder implements player.wellnesssolutions.com.ui.fragment_presentation.presentation.MMPreInterface.View, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View, player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask.Listener, player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.UIListener {
    @org.jetbrains.annotations.Nullable()
    private android.view.Display mDisplay;
    private boolean isShowing = false;
    private player.wellnesssolutions.com.services.MMPresentationService mService;
    private android.view.ViewGroup mView;
    private android.content.Context mContext;
    private androidx.mediarouter.media.MediaRouter.RouteInfo mRouter;
    private player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter mPresenter;
    private java.util.ArrayList<android.widget.TextView> mExtraPlayingCollectionViews;
    private java.util.ArrayList<android.widget.TextView> mExtraComingCollectionViews;
    private player.wellnesssolutions.com.common.customize_views.MMBackGroundView imageBgHomeScreen;
    private android.view.ViewGroup frameExoVolume;
    private android.widget.TextView videoTitle;
    private android.widget.LinearLayout groupCollections;
    private android.widget.ImageView btnPauseVideo;
    private android.widget.ImageView btnPlayVideo;
    private androidx.constraintlayout.widget.ConstraintLayout groupViewsComingUpNext;
    private android.widget.TextView btnComingUpNext;
    private androidx.recyclerview.widget.RecyclerView rvComingUpNext;
    private android.view.View btnMenuFloat;
    private com.google.android.exoplayer2.ui.PlayerView videoPlayer;
    private player.wellnesssolutions.com.common.customize_views.MMProgressBar progressLoadingVideo;
    private player.wellnesssolutions.com.common.customize_views.MMTextView tvCountdownTimerUntilPlay;
    private player.wellnesssolutions.com.network.models.now_playing.MMVideo mNowVideo;
    private long mNowVideoLength = 0L;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mComingUpVideos;
    private player.wellnesssolutions.com.services.MMPresentationBinder.Callback mCallback;
    private player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask mMonitorVideoAsyncTask;
    private boolean mIsLoadingNewVideo = false;
    private boolean mIsRunnableStop = false;
    private java.lang.Runnable mRunnable;
    @org.jetbrains.annotations.NotNull()
    private player.wellnesssolutions.com.services.MMPresentationBinder.BinderListener listener;
    private static final java.lang.String TAG = "PresentationBinder";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.MMPresentationBinder.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.Display getMDisplay() {
        return null;
    }
    
    public final void setMDisplay(@org.jetbrains.annotations.Nullable()
    android.view.Display p0) {
    }
    
    /**
     * This function is highest priority.
     * Must be called before onCreate.
     */
    public final void setRouter(@org.jetbrains.annotations.NotNull()
    androidx.mediarouter.media.MediaRouter.RouteInfo router) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.com.services.MMPresentationService getService() {
        return null;
    }
    
    /**
     * This function is highest priority.
     * Must be called before onCreate.
     */
    public final void setContentView(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup view) {
    }
    
    public final void onCreate() {
    }
    
    private final void registerUICastingBroadcast() {
    }
    
    public final void onDestroy() {
    }
    
    private final void unregisterUICastingBroadcast() {
    }
    
    public final void pauseOrPlay() {
    }
    
    public final void pause() {
    }
    
    public final void resume() {
    }
    
    public final void nextVideo() {
    }
    
    public final void showNextVideo() {
    }
    
    public final void showClosedCaption() {
    }
    
    public final void setupPlayVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.datasource.videos.PlayMode mode, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, long lastPosition) {
    }
    
    private final void releasePresenters() {
    }
    
    private final void readPlayingVideoData(java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupVideoPlayerOnMode() {
    }
    
    private final void setupVideoPlayerController() {
    }
    
    private final void setupButtonPlayPauseVideo() {
    }
    
    private final void onClickedButtonPlayVideo() {
    }
    
    private final void onClickedButtonPauseVideo() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment getFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.content.Context getViewContext() {
        return null;
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    @java.lang.Override()
    public void onLoadingVideoDelay(long playedPosition) {
    }
    
    @java.lang.Override()
    public void onIntermediateStage() {
    }
    
    private final void showCountDown() {
    }
    
    private final void hideCountDown() {
    }
    
    @java.lang.Override()
    public void reloadScheduledVideo() {
    }
    
    @java.lang.Override()
    public void onStartInitializePlayer() {
    }
    
    @java.lang.Override()
    public void hideCountDownTimer() {
    }
    
    private final void showTitleAndCollections() {
    }
    
    private final void hideTitleAndCollections() {
    }
    
    @java.lang.Override()
    public void onPlayerInitialized(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.SimpleExoPlayer players, boolean isReload) {
    }
    
    @java.lang.Override()
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
    }
    
    private final void sendLoadingVideoStateToUI() {
    }
    
    private final void sendReadyVideoStateToUI(boolean isPlaying) {
    }
    
    @java.lang.Override()
    public void hideControlWhenNextVideoSchedule() {
    }
    
    @java.lang.Override()
    public boolean isCastableOnTV() {
        return false;
    }
    
    private final void sendEndedVideoStateToUI() {
    }
    
    private final void sendTranslatedVideoStateToUI() {
    }
    
    @java.lang.Override()
    public void showUIForPlayingVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos) {
    }
    
    private final void onNoVideoPlay() {
    }
    
    @java.lang.Override()
    public void onCookieExpired() {
    }
    
    @java.lang.Override()
    public boolean isPlayingSchedule() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlayingSearchVideos() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlaying() {
        return false;
    }
    
    @java.lang.Override()
    public void hideGroupViewsComingUpNext() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final player.wellnesssolutions.com.network.datasource.videos.PlayMode getPlayMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getVideos() {
        return null;
    }
    
    public final long getCurrentVideoPosition() {
        return 0L;
    }
    
    private final boolean isShowClosedCaptionView() {
        return false;
    }
    
    private final void postDelayCheckVideoPosition() {
    }
    
    @java.lang.Override()
    public void onVideoEnded() {
    }
    
    @java.lang.Override()
    public void showCountDownPlayTime(long millisUntilFinished) {
    }
    
    public final void onAppViewVisible() {
    }
    
    public final void onAppViewInVisible() {
    }
    
    public final void addCallback(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.MMPresentationBinder.Callback callback) {
    }
    
    public final void onPlayPresentationVideoAt(int position) {
    }
    
    public final void clearAllVideos() {
    }
    
    @java.lang.Override()
    public void openNoClassSearchScreen(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean isClickedButtonHome) {
    }
    
    /**
     * interface @MonitorVideoAsyncTask.TVListener
     */
    @java.lang.Override()
    public void onUpdateVideoProgress(boolean isPlaying, long position) {
    }
    
    /**
     * interface @CastingBroadcastReceiver.UIListener
     */
    @java.lang.Override()
    public void onReceivePlayVideoFromUI() {
    }
    
    @java.lang.Override()
    public void onReceivePauseVideoFromUI() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.com.services.MMPresentationBinder.BinderListener getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.MMPresentationBinder.BinderListener p0) {
    }
    
    public MMPresentationBinder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.MMPresentationBinder.BinderListener listener) {
        super();
    }
    
    public void initUI() {
    }
    
    public void setUpPlayer(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.SimpleExoPlayer player) {
    }
    
    public void returnPrevScreen() {
    }
    
    public void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.config.MMConfigData configData) {
    }
    
    public void openTimeTableScreen() {
    }
    
    public void showDialogAskWantToLoadSchedule() {
    }
    
    public void onLoadScheduleWhilePlaySearchedVideos() {
    }
    
    public void backToHomeScreenWithNotLoadSchedule() {
    }
    
    @java.lang.Override()
    public void onEndLoadingBrands() {
    }
    
    @java.lang.Override()
    public void onGetBrands(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
    java.lang.String searchBrandFlowTag) {
    }
    
    @java.lang.Override()
    public void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
    java.lang.String nextScreenTag) {
    }
    
    @java.lang.Override()
    public void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onLoadingBrands() {
    }
    
    @java.lang.Override()
    public void showMessage(@androidx.annotation.StringRes()
    int messageRes, @androidx.annotation.ColorRes()
    int color) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int color) {
    }
    
    @java.lang.Override()
    public void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int msgColor, boolean isClickedFromBtnBottom) {
    }
    
    @java.lang.Override()
    public void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
    }
    
    @java.lang.Override()
    public void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    @java.lang.Override()
    public void onTimePlaySchedule() {
    }
    
    @java.lang.Override()
    public void showDialogAskWantToBackToHome(boolean isLoadSchedule) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationBinder$BinderListener;", "", "onCreateNotificationRemote", "", "onDestroyNotification", "onGetService", "Lplayer/wellnesssolutions/com/services/MMPresentationService;", "app_debug"})
    public static abstract interface BinderListener {
        
        public abstract void onCreateNotificationRemote();
        
        public abstract void onDestroyNotification();
        
        @org.jetbrains.annotations.NotNull()
        public abstract player.wellnesssolutions.com.services.MMPresentationService onGetService();
    }
    
    /**
     * ---------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\tH&\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationBinder$Callback;", "", "onClearVideos", "", "onUpdateVideos", "nowPlayVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "comingUpVideos", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onUpdateVideos(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo nowPlayVideo, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos);
        
        public abstract void onClearVideos();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/services/MMPresentationBinder$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}