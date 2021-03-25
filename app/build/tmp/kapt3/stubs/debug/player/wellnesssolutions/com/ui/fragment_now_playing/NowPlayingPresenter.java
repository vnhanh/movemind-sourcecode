package player.wellnesssolutions.com.ui.fragment_now_playing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016J0\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0002J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\fH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0016J\b\u00107\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020 H\u0016J\u0018\u0010>\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020&H\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020@H\u0016J\b\u0010D\u001a\u00020&H\u0016J\b\u0010E\u001a\u00020&H\u0016J\b\u0010F\u001a\u00020&H\u0016J\u0017\u0010G\u001a\u00020&2\b\u0010H\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\u0011H\u0016J\u0018\u0010L\u001a\u00020&2\u0006\u0010K\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010M\u001a\u00020&H\u0016J\u0017\u0010N\u001a\u00020&2\b\u0010O\u001a\u0004\u0018\u00010@H\u0016\u00a2\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020SH\u0016J\u0018\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020@H\u0016J\b\u0010W\u001a\u00020&H\u0016J\b\u0010X\u001a\u00020&H\u0016J\b\u0010Y\u001a\u00020&H\u0016J\b\u0010Z\u001a\u00020&H\u0016J\b\u0010[\u001a\u00020&H\u0016J\b\u0010\\\u001a\u00020&H\u0016J\b\u0010]\u001a\u00020&H\u0016J\u0010\u0010^\u001a\u00020&2\u0006\u0010_\u001a\u00020\u0011H\u0002J\b\u0010`\u001a\u00020&H\u0016J\b\u0010a\u001a\u00020&H\u0016J\b\u0010b\u001a\u00020&H\u0016J\b\u0010c\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020&H\u0002J\b\u0010e\u001a\u00020&H\u0002J \u0010f\u001a\u00020&2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0002J\b\u0010g\u001a\u00020&H\u0016J\b\u0010h\u001a\u00020&H\u0016J\b\u0010i\u001a\u00020&H\u0002J\b\u0010j\u001a\u00020&H\u0002J\b\u0010k\u001a\u00020&H\u0016J\u0010\u0010l\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0011H\u0016J\u0010\u0010m\u001a\u00020&2\u0006\u0010n\u001a\u00020oH\u0016J \u0010p\u001a\u00020&2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016J\b\u0010q\u001a\u00020&H\u0016J\b\u0010r\u001a\u00020&H\u0016J\b\u0010s\u001a\u00020&H\u0016J\b\u0010t\u001a\u00020&H\u0016J \u0010u\u001a\u00020&2\u0016\u0010v\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00050\u00050\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006w"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/NowPlayingPresenter;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager$Callback;", "Lcom/google/android/exoplayer2/Player$EventListener;", "context", "Landroid/content/Context;", "playMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "(Landroid/content/Context;Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;)V", "handlerScheduleTimePlay", "Lplayer/wellnesssolutions/com/ui/fragment_home/helper/HandlerScheduleTime;", "isOnCountDown", "", "isRequestFromUser", "mCountDownTimerPlayVideo", "Landroid/os/CountDownTimer;", "mInitPlayedPosition", "", "mIsReload", "mIsRenderedData", "mLoadBrandsHandler", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler;", "mPlayedMode", "mPlayerManager", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager;", "mPlayerState", "Lplayer/wellnesssolutions/com/custom_exoplayer/PlayerState;", "mVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "mWeakContext", "Ljava/lang/ref/WeakReference;", "weakContext", "kotlin.jvm.PlatformType", "checkPlayMode", "", "clickToCallServiceLoadSchedule", "getAllVideos", "getComingUpNextVideos", "videos", "getCurrentPlayedPosition", "getIsCountDown", "getNowPlayVideo", "getPlayMode", "getPlayerManager", "getPlayerState", "hideClosedCaptionView", "initCountDownTimer", "initializeSearchPlayer", "isPlayerError", "isPlayerInitialized", "isPlayingCC", "isPlayingVideo", "isShowClosedCaptionView", "loadBrands", "tag", "", "onAttach", "view", "onChangeVolume", "progress", "", "onClickedComingUpNextItem", "onClickedComingUpNextVideo", "position", "onCookieExpired", "onDestroy", "onDetach", "onDontHaveNowPlayingVideo", "isClickedButtonHome", "(Ljava/lang/Boolean;)V", "onHaveNowPlayingVideo", "playedPosition", "onHaveVideoAfter", "onPlayNext", "onPlayerEnded", "videoId", "(Ljava/lang/Integer;)V", "onPlayerInitialized", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onProcessVideoError", "onReconnectNetwork", "onReload", "onStartIntializePlayer", "onStop", "onTapGroupComingUpNext", "onVideoExpiredTime", "openNowPlayingVideo", "playedVideoPosition", "openTimeTableScreen", "pausePlayer", "pauseVideo", "playNextVideo", "processPlayerBaseOnState", "renderVideosData", "renderVideosInfo", "replayVideo", "resumeOrReplay", "runCountDownTimer", "scanScheduleVideos", "selectLanguageCCOption", "setPlayedPosition", "setSubtitleController", "closedCaptionController", "Lplayer/wellnesssolutions/com/base/common/play_video/ClosedCaptionController;", "setVideos", "showClosedCaptionView", "slideNextLanguageCCOption", "startToPlayScheduleVideo", "stopCountdown", "switchToPlayScheduleVideos", "scheduleVideos", "app_debug"})
public final class NowPlayingPresenter implements player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter, player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager.Callback, com.google.android.exoplayer2.Player.EventListener {
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View mView;
    private player.wellnesssolutions.com.network.datasource.videos.PlayMode mPlayedMode = player.wellnesssolutions.com.network.datasource.videos.PlayMode.ON_DEMAND;
    private player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager mPlayerManager;
    private player.wellnesssolutions.com.custom_exoplayer.PlayerState mPlayerState = player.wellnesssolutions.com.custom_exoplayer.PlayerState.NOTHING;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mVideos;
    private long mInitPlayedPosition = 0L;
    private boolean mIsReload = false;
    private player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime handlerScheduleTimePlay;
    private android.os.CountDownTimer mCountDownTimerPlayVideo;
    private player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler mLoadBrandsHandler;
    private boolean mIsRenderedData = false;
    private final java.lang.ref.WeakReference<android.content.Context> weakContext = null;
    private boolean isOnCountDown = false;
    private boolean isRequestFromUser = false;
    
    private final void initCountDownTimer() {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View view) {
    }
    
    private final void checkPlayMode() {
    }
    
    @java.lang.Override()
    public void startToPlayScheduleVideo() {
    }
    
    @java.lang.Override()
    public boolean playNextVideo() {
        return false;
    }
    
    @java.lang.Override()
    public void pauseVideo() {
    }
    
    @java.lang.Override()
    public void resumeOrReplay() {
    }
    
    @java.lang.Override()
    public void pausePlayer() {
    }
    
    @java.lang.Override()
    public void onChangeVolume(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int progress) {
    }
    
    @java.lang.Override()
    public void setVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getComingUpNextVideos(java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
        return null;
    }
    
    @java.lang.Override()
    public void onClickedComingUpNextVideo(int position) {
    }
    
    private final boolean isPlayerInitialized() {
        return false;
    }
    
    private final void processPlayerBaseOnState() {
    }
    
    private final void runCountDownTimer() {
    }
    
    private final void renderVideosData() {
    }
    
    private final void renderVideosInfo(java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    private final void initializeSearchPlayer() {
    }
    
    @java.lang.Override()
    public void onStartIntializePlayer() {
    }
    
    @java.lang.Override()
    public void onPlayerInitialized(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.SimpleExoPlayer player) {
    }
    
    @java.lang.Override()
    public void onPlayNext() {
    }
    
    @java.lang.Override()
    public void onReload() {
    }
    
    @java.lang.Override()
    public void onCookieExpired() {
    }
    
    @java.lang.Override()
    public void onReconnectNetwork() {
    }
    
    @java.lang.Override()
    public void onPlayerEnded(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId) {
    }
    
    @java.lang.Override()
    public void clickToCallServiceLoadSchedule() {
    }
    
    /**
     * implementing the module playing scheduled videos
     */
    private final void scanScheduleVideos() {
    }
    
    @java.lang.Override()
    public void onClickedComingUpNextItem() {
    }
    
    @java.lang.Override()
    public void setSubtitleController(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController closedCaptionController) {
    }
    
    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    @java.lang.Override()
    public void onHaveNowPlayingVideo(long playedPosition) {
    }
    
    @java.lang.Override()
    public void onHaveVideoAfter(long playedPosition, boolean isRequestFromUser) {
    }
    
    @java.lang.Override()
    public void onVideoExpiredTime() {
    }
    
    @java.lang.Override()
    public void onProcessVideoError() {
    }
    
    @java.lang.Override()
    public void onDontHaveNowPlayingVideo(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean isClickedButtonHome) {
    }
    
    private final void openNowPlayingVideo(long playedVideoPosition) {
    }
    
    @java.lang.Override()
    public void setPlayedPosition(long position) {
    }
    
    @java.lang.Override()
    public void switchToPlayScheduleVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void showClosedCaptionView() {
    }
    
    @java.lang.Override()
    public void hideClosedCaptionView() {
    }
    
    @java.lang.Override()
    public void slideNextLanguageCCOption() {
    }
    
    @java.lang.Override()
    public void selectLanguageCCOption() {
    }
    
    @java.lang.Override()
    public void onTapGroupComingUpNext() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public player.wellnesssolutions.com.network.models.now_playing.MMVideo getNowPlayVideo() {
        return null;
    }
    
    /**
     * @interface Player.EventListener
     */
    @java.lang.Override()
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
    }
    
    @java.lang.Override()
    public boolean getIsCountDown() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.custom_exoplayer.PlayerState getPlayerState() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isShowClosedCaptionView() {
        return false;
    }
    
    @java.lang.Override()
    public void replayVideo() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager getPlayerManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getAllVideos() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isPlayingVideo() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.network.datasource.videos.PlayMode getPlayMode() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isPlayerError() {
        return false;
    }
    
    @java.lang.Override()
    public long getCurrentPlayedPosition() {
        return 0L;
    }
    
    @java.lang.Override()
    public boolean isPlayingCC() {
        return false;
    }
    
    /**
     * LOAD BRANDS
     */
    @java.lang.Override()
    public void loadBrands(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    @java.lang.Override()
    public void openTimeTableScreen() {
    }
    
    @java.lang.Override()
    public void stopCountdown() {
    }
    
    public NowPlayingPresenter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.datasource.videos.PlayMode playMode) {
        super();
    }
}