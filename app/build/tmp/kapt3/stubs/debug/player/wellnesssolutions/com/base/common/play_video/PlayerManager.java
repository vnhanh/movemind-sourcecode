package player.wellnesssolutions.com.base.common.play_video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0084\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0002\u0084\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020$H\u0016J \u0010,\u001a\u00020(2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020$0\u0016j\b\u0012\u0004\u0012\u00020$`\u0017H\u0016J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u000fH\u0002J\u0010\u00100\u001a\u00020\u00132\u0006\u0010/\u001a\u000201H\u0002J\n\u00102\u001a\u0004\u0018\u00010\rH\u0016J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u000bH\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J\b\u0010=\u001a\u00020\u0013H\u0016J\b\u0010>\u001a\u00020\u0013H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u000bH\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020(H\u0016J\u0010\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010I\u001a\u00020(2\u0006\u0010H\u001a\u00020\u000fH\u0016J\b\u0010J\u001a\u00020(H\u0002J\b\u0010K\u001a\u00020(H\u0002J\b\u0010L\u001a\u00020(H\u0002J(\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u0002042\u0006\u0010O\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0016J\u0010\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\u0013H\u0016J\b\u0010T\u001a\u00020(H\u0016J\u0012\u0010U\u001a\u00020(2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010X\u001a\u00020(2\b\u0010H\u001a\u0004\u0018\u00010YH\u0016J\u0018\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u000bH\u0016J\u0010\u0010]\u001a\u00020(2\u0006\u0010^\u001a\u00020\u000bH\u0016J\u0018\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020\u00132\u0006\u0010a\u001a\u00020\u0013H\u0016J\u0010\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u000bH\u0016J\u001a\u0010d\u001a\u00020(2\u0006\u0010e\u001a\u00020\u000b2\b\u0010f\u001a\u0004\u0018\u00010\u000fH\u0014J\u0018\u0010g\u001a\u00020(2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010iH\u0014J\b\u0010j\u001a\u00020(H\u0016J\b\u0010k\u001a\u00020(H\u0016J\u0010\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020\u0013H\u0016J$\u0010n\u001a\u00020(2\b\u0010o\u001a\u0004\u0018\u00010p2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010^\u001a\u00020\u000bH\u0016J\u001c\u0010s\u001a\u00020(2\b\u0010t\u001a\u0004\u0018\u00010u2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010y\u001a\u00020\u000bH\u0016J\u0010\u0010z\u001a\u00020(2\u0006\u0010y\u001a\u00020\u000bH\u0002J\u0010\u0010{\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0016J\b\u0010|\u001a\u00020(H\u0016J\b\u0010}\u001a\u00020(H\u0002J(\u0010~\u001a\u00020(2\u0006\u0010N\u001a\u0002042\u0006\u0010O\u001a\u00020\u001e2\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u0013H\u0016J\b\u0010\u007f\u001a\u00020(H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020(2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0016J\t\u0010\u0082\u0001\u001a\u00020(H\u0016J\t\u0010\u0083\u0001\u001a\u00020(H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010#\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020$\u0018\u0001`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0&X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0085\u0001"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/PlayerManager;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Lplayer/wellnesssolutions/com/network/datasource/videos/VideoViewResponse;", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager;", "Lcom/google/android/exoplayer2/Player$EventListener;", "callback", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager$Callback;", "context", "Landroid/content/Context;", "(Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager$Callback;Landroid/content/Context;)V", "MaxTryCount", "", "mClosedCaptionController", "Lplayer/wellnesssolutions/com/base/common/play_video/ClosedCaptionController;", "mCookieValue", "", "mCurrentVideoSize", "mErrorCode", "mHasSubtitle", "", "mHasUpdatedViewNumber", "mListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mPlayBackState", "mPlayerCallback", "mPlayerUseCase", "Lplayer/wellnesssolutions/com/custom_exoplayer/PlayerUsecase;", "mTryCount", "mTypeVideo", "Lplayer/wellnesssolutions/com/custom_exoplayer/EnumTypeViewVideo;", "mUpdateViewNumber", "mUpdateViewNumberAvailable", "mUpdateViewNumberService", "Lplayer/wellnesssolutions/com/network/datasource/videos/SearchResultApi;", "mVideos", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "mWeakContext", "Ljava/lang/ref/WeakReference;", "addListener", "", "listener", "addVideo", "video", "addVideos", "videos", "checkIfFileExist", "fileName", "checkSize", "Ljava/io/File;", "getClosedCaptionController", "getCurrentPosition", "", "getPlaybackState", "getPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getSizeFile", "path", "handleOnEnded", "hasPlayer", "isPlayerError", "isPlaying", "isPlayingCC", "loadApiUpdateViewNumber", "videoId", "onChangedVolume", "progress", "onClickedLanguageSubtitle", "value", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideoLanguage;", "onDestroy", "onExpired", "error", "onExpiredUnauthenticated", "onHandleDisconnectedError", "onHandleForbiddenError", "onHandlePlayedError", "onInitialize", "playedVideoPosition", "typeVideo", "isUpdateViewNumber", "isSupportCC", "onLoadingChanged", "isLoading", "onPause", "onPlaybackParametersChanged", "playbackParameters", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "onPositionDiscontinuity", "reason", "onReleasePlayer", "isKeepPosition", "keepPlayWhenReady", "onRepeatModeChanged", "repeatMode", "onResponseFalse", "code", "message", "onResponseSuccess", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onResume", "onSeekProcessed", "onShuffleModeEnabledChanged", "shuffleModeEnabled", "onTimelineChanged", "timeline", "Lcom/google/android/exoplayer2/Timeline;", "manifest", "", "onTracksChanged", "trackGroups", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "trackSelections", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "playVideoAt", "index", "removeAllVideosBeforeAt", "removeListener", "replay", "resetData", "resumeOrIntialize", "selectLanguageCCOption", "setSubtitleController", "closedCaptionController", "slideNextLanguageCCOption", "updatePlayingVideoViewNumber", "Companion", "app_debug"})
public final class PlayerManager extends player.wellnesssolutions.com.base.view.BaseResponseObserver<player.wellnesssolutions.com.network.datasource.videos.VideoViewResponse> implements player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager, com.google.android.exoplayer2.Player.EventListener {
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private player.wellnesssolutions.com.custom_exoplayer.PlayerUsecase mPlayerUseCase;
    private int mErrorCode = -1;
    private player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager.Callback mPlayerCallback;
    private java.util.ArrayList<com.google.android.exoplayer2.Player.EventListener> mListeners;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mVideos;
    private java.lang.String mCookieValue;
    private player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController mClosedCaptionController;
    private int mTryCount = 0;
    private final int MaxTryCount = 2;
    private int mCurrentVideoSize = -1;
    private boolean mUpdateViewNumberAvailable = true;
    private boolean mHasUpdatedViewNumber = false;
    private int mUpdateViewNumber = 0;
    private int mPlayBackState = com.google.android.exoplayer2.Player.STATE_IDLE;
    private boolean mHasSubtitle = false;
    private player.wellnesssolutions.com.network.datasource.videos.SearchResultApi mUpdateViewNumberService;
    private player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo mTypeVideo = player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo.NORMAL;
    public static final int CODE_NO_ERROR = -1;
    public static final int ERR_CODE = 100;
    public static final int ERR_DISCONNECT = 404;
    public static final int ERR_FORBIDDEN = 403;
    public static final int MAX_UPDATE_VIDEO_VIEW_NUMBER = 3;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.common.play_video.PlayerManager.Companion Companion = null;
    
    @java.lang.Override()
    public void addListener(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.Player.EventListener listener) {
    }
    
    @java.lang.Override()
    public void removeListener(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.Player.EventListener listener) {
    }
    
    @java.lang.Override()
    public void resumeOrIntialize(long playedVideoPosition, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo typeVideo, boolean isUpdateViewNumber, boolean isSupportCC) {
    }
    
    @java.lang.Override()
    public void onInitialize(long playedVideoPosition, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo typeVideo, boolean isUpdateViewNumber, boolean isSupportCC) {
    }
    
    private final boolean checkIfFileExist(java.lang.String fileName) {
        return false;
    }
    
    private final boolean checkSize(java.io.File fileName) {
        return false;
    }
    
    private final int getSizeFile(java.io.File path) {
        return 0;
    }
    
    @java.lang.Override()
    public void replay() {
    }
    
    @java.lang.Override()
    public void addVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    @java.lang.Override()
    public void addVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo video) {
    }
    
    @java.lang.Override()
    public void playVideoAt(int index) {
    }
    
    private final void removeAllVideosBeforeAt(int index) {
    }
    
    @java.lang.Override()
    public long getCurrentPosition() {
        return 0L;
    }
    
    private final void resetData() {
    }
    
    @java.lang.Override()
    public void onChangedVolume(int progress) {
    }
    
    @java.lang.Override()
    public boolean isPlaying() {
        return false;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onReleasePlayer(boolean isKeepPosition, boolean keepPlayWhenReady) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void setSubtitleController(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController closedCaptionController) {
    }
    
    @java.lang.Override()
    public boolean hasPlayer() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isPlayerError() {
        return false;
    }
    
    @java.lang.Override()
    public int getPlaybackState() {
        return 0;
    }
    
    /**
     * implementing @interface Player.EventListener
     */
    @java.lang.Override()
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
    }
    
    private final void updatePlayingVideoViewNumber() {
    }
    
    @java.lang.Override()
    public void handleOnEnded() {
    }
    
    @java.lang.Override()
    public void onPlayerError(@org.jetbrains.annotations.Nullable()
    com.google.android.exoplayer2.ExoPlaybackException error) {
    }
    
    private final void onHandleForbiddenError() {
    }
    
    private final void onHandleDisconnectedError() {
    }
    
    private final void onHandlePlayedError() {
    }
    
    @java.lang.Override()
    public void onPlaybackParametersChanged(@org.jetbrains.annotations.Nullable()
    com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
    }
    
    @java.lang.Override()
    public void onSeekProcessed() {
    }
    
    @java.lang.Override()
    public void onTracksChanged(@org.jetbrains.annotations.Nullable()
    com.google.android.exoplayer2.source.TrackGroupArray trackGroups, @org.jetbrains.annotations.Nullable()
    com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelections) {
    }
    
    @java.lang.Override()
    public void onLoadingChanged(boolean isLoading) {
    }
    
    @java.lang.Override()
    public void onPositionDiscontinuity(int reason) {
    }
    
    @java.lang.Override()
    public void onRepeatModeChanged(int repeatMode) {
    }
    
    @java.lang.Override()
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
    }
    
    @java.lang.Override()
    public void onTimelineChanged(@org.jetbrains.annotations.Nullable()
    com.google.android.exoplayer2.Timeline timeline, @org.jetbrains.annotations.Nullable()
    java.lang.Object manifest, int reason) {
    }
    
    /**
     * implemented abstract class BaseResponseObserver<T>
     */
    private final void loadApiUpdateViewNumber(int videoId) {
    }
    
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<player.wellnesssolutions.com.network.datasource.videos.VideoViewResponse> data) {
    }
    
    @java.lang.Override()
    public void onClickedLanguageSubtitle(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage value) {
    }
    
    @java.lang.Override()
    public void selectLanguageCCOption() {
    }
    
    @java.lang.Override()
    public void slideNextLanguageCCOption() {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public player.wellnesssolutions.com.base.common.play_video.ClosedCaptionController getClosedCaptionController() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isPlayingCC() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.google.android.exoplayer2.SimpleExoPlayer getPlayer() {
        return null;
    }
    
    public PlayerManager(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager.Callback callback, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/PlayerManager$Companion;", "", "()V", "CODE_NO_ERROR", "", "ERR_CODE", "ERR_DISCONNECT", "ERR_FORBIDDEN", "MAX_UPDATE_VIDEO_VIEW_NUMBER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}