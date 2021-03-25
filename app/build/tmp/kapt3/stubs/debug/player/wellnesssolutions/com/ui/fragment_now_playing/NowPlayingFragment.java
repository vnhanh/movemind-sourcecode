package player.wellnesssolutions.com.ui.fragment_now_playing;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0095\u0001B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010\'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u0011H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0011H\u0016J\b\u00102\u001a\u00020\u001fH\u0016J\u0012\u00103\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00109\u001a\u00020\u001fH\u0016J\b\u0010:\u001a\u00020\u001fH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J(\u0010<\u001a\u00020\u001f2\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>0\nj\b\u0012\u0004\u0012\u00020>`\f2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020@H\u0016J(\u0010D\u001a\u00020\u001f2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010F\u001a\u00020\u0011H\u0016J\b\u0010G\u001a\u00020\u001fH\u0016J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020@H\u0016J\b\u0010J\u001a\u00020\u001fH\u0016J\b\u0010K\u001a\u00020\u001fH\u0016J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u0016H\u0016J\b\u0010N\u001a\u00020\u001fH\u0016J\"\u0010O\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020@2\b\b\u0001\u0010P\u001a\u00020Q2\u0006\u0010F\u001a\u00020\u0011H\u0016J\b\u0010R\u001a\u00020\u001fH\u0016J\u0018\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0011H\u0016J\u0018\u0010W\u001a\u00020\u001f2\u0006\u0010X\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020QH\u0016J\b\u0010Z\u001a\u00020\u001fH\u0016J\b\u0010[\u001a\u00020\u001fH\u0016J\b\u0010\\\u001a\u00020\u001fH\u0016J\b\u0010]\u001a\u00020\u001fH\u0016J\b\u0010^\u001a\u00020\u001fH\u0016J\b\u0010_\u001a\u00020\u001fH\u0016J\b\u0010`\u001a\u00020\u001fH\u0016J\b\u0010a\u001a\u00020\u001fH\u0016J\b\u0010b\u001a\u00020\u001fH\u0016J\b\u0010c\u001a\u00020\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010e\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020gH\u0002J\u0017\u0010h\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020\u001fH\u0016J\b\u0010k\u001a\u00020\u001fH\u0002J\b\u0010l\u001a\u00020\u001fH\u0002J\b\u0010m\u001a\u00020\u001fH\u0002J\b\u0010n\u001a\u00020\u001fH\u0002J\b\u0010o\u001a\u00020\u001fH\u0002J\b\u0010p\u001a\u00020\u001fH\u0002J\b\u0010q\u001a\u00020\u001fH\u0002J\b\u0010r\u001a\u00020\u001fH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\b\u0010t\u001a\u00020\u001fH\u0002J\b\u0010u\u001a\u00020\u001fH\u0002J\b\u0010v\u001a\u00020\u001fH\u0002J\b\u0010w\u001a\u00020\u001fH\u0002J\b\u0010x\u001a\u00020\u001fH\u0002J\b\u0010y\u001a\u00020\u001fH\u0002J\b\u0010z\u001a\u00020\u001fH\u0002J\u0010\u0010{\u001a\u00020\u001f2\u0006\u0010|\u001a\u00020}H\u0016J\b\u0010~\u001a\u00020\u001fH\u0002J\u0011\u0010\u007f\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\u0016H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020\u001f2\u0007\u0010\u0082\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u0083\u0001\u001a\u00020\u001fH\u0016J\t\u0010\u0084\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0085\u0001\u001a\u00020\u001fH\u0016J\u001b\u0010\u0086\u0001\u001a\u00020\u001f2\u0007\u0010\u0087\u0001\u001a\u00020Q2\u0007\u0010\u0088\u0001\u001a\u00020QH\u0016J\u001a\u0010\u0086\u0001\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020@2\u0007\u0010\u0088\u0001\u001a\u00020QH\u0016J+\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020\u000b2\u0017\u0010\u008b\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J+\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020\u000b2\u0017\u0010\u008e\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\t\u0010\u008f\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0090\u0001\u001a\u00020\u001fH\u0002J!\u0010\u0091\u0001\u001a\u00020\u001f2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\t\u0010\u0092\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0093\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0094\u0001\u001a\u00020\u001fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0096\u0001"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/NowPlayingFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseScheduleFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$View;", "Lplayer/wellnesssolutions/com/ui/activity_main/IRouterChanged;", "Lplayer/wellnesssolutions/com/network/network_connect/NetworkReceiver$IStateListener;", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$ScheduleListener;", "()V", "mCheckVideoPositionRunnable", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/MonitorVideoAsyncTask;", "mComingUpVideos", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "mExtraItemCollectionViews", "Landroid/widget/TextView;", "mExtraMainCollectionViews", "mIsTranslateCompleted", "", "mMenuSetupHelper", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingFloatMenuHelper;", "mNowVideo", "mNowVideoLength", "", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "mSchedulePresenter", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$Presenter;", "mVideoPlayerTouchedX", "", "mVideoPlayerTouchedY", "attachPresenter", "", "backToHomeScreenWithNotLoadSchedule", "destroyPresenters", "detachPresenters", "hideCountDown", "hideGroupViewComingUpNext", "hideGroupViewsComingUpNext", "hideLoadingBrand", "hideLoadingProgress", "hideVideoTitleAndCollections", "isCastableOnTV", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "view", "Landroid/view/View;", "onChangedState", "isConnected", "onCookieExpired", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onEndLoadingBrands", "onGetBrands", "brands", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "searchBrandFlowTag", "", "onGetOnlyOneBrand", "brand", "nextScreenTag", "onHaveClassVideos", "scheduleVideos", "isClickedFromBtnBottom", "onIntermediateStage", "onLoadBrandsFailed", "message", "onLoadScheduleWhilePlaySearchedVideos", "onLoadingBrands", "onLoadingVideoDelay", "playedPosition", "onMediaRouterConnected", "onNoClassVideosForNow", "msgColor", "", "onPause", "onPlayerInitialized", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "isReload", "onPlayerStateChanged", "playWhenReady", "playbackState", "onReceiveChangeApiBackToHome", "onReceiveChangeApiBackToHomeGetConfigApi", "onReceiveChangeApiGetConfigApi", "onReceiveChangeSub", "onReceivePlayVideoScheduleFromUI", "onReceiveResetScheduleFromUI", "onReceiveUpdateScheduleFromUI", "onResume", "onStartInitializePlayer", "onTimePlaySchedule", "onVideoEnded", "openControlScreen", "newFragment", "Landroidx/fragment/app/Fragment;", "openNoClassSearchScreen", "(Ljava/lang/Boolean;)V", "openTimeTableScreen", "postDelayCheckVideoPosition", "readArguments", "registerMediaRouterConnected", "registerNetworkConnecting", "registerScheduleBroadcast", "releaseAdapters", "releaseExtraViews", "reloadScheduledVideo", "returnPrevScreen", "setupBtnPrevious", "setupButtonLogo", "setupMenuFloat", "setupTextViewCountdownTime", "setupUI", "setupVideoPlayerController", "setupVideoPlayerOnMode", "setupViewFloatMenu", "configData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "showCountDown", "showCountDownPlayTime", "millisUntilFinished", "showDialogAskWantToBackToHome", "isLoadSchedule", "showDialogAskWantToLoadSchedule", "showLoadingBrand", "showLoadingProgress", "showMessage", "messageRes", "color", "showUI", "video", "comingUpNextVideos", "showUIForPlayingVideo", "videoData", "comingUpVideos", "showVideoTitleAndCollections", "stopPresenter", "switchToCurrentClass", "unRegisterMediaRouterConnected", "unregisterNetworkConnecting", "unregisterScheduleBroadcast", "Companion", "app_debug"})
public final class NowPlayingFragment extends player.wellnesssolutions.com.base.view.BaseScheduleFragment implements player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.View, player.wellnesssolutions.com.ui.activity_main.IRouterChanged, player.wellnesssolutions.com.network.network_connect.NetworkReceiver.IStateListener, player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener {
    private player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter mPresenter;
    private player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.Presenter mSchedulePresenter;
    private player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingFloatMenuHelper mMenuSetupHelper;
    private java.util.ArrayList<android.widget.TextView> mExtraMainCollectionViews;
    private java.util.ArrayList<android.widget.TextView> mExtraItemCollectionViews;
    private boolean mIsTranslateCompleted = false;
    private player.wellnesssolutions.com.network.models.now_playing.MMVideo mNowVideo;
    private long mNowVideoLength = 0L;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mComingUpVideos;
    private player.wellnesssolutions.com.ui.fragment_now_playing.helper.MonitorVideoAsyncTask mCheckVideoPositionRunnable;
    private float mVideoPlayerTouchedX = 0.0F;
    private float mVideoPlayerTouchedY = 0.0F;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "NowPlayingFragment";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DATA_PLAYING_VIDEO = "KEY DATA PLAYING VIDEO";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_DATA_NOW_PLAYING = "KEY DATA NOW PLAYING";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void readArguments() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void attachPresenter() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void stopPresenter() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onBackPressed(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void releaseExtraViews() {
    }
    
    private final void releaseAdapters() {
    }
    
    private final void detachPresenters() {
    }
    
    private final void destroyPresenters() {
    }
    
    private final void setupUI() {
    }
    
    private final void setupBtnPrevious() {
    }
    
    private final void setupTextViewCountdownTime() {
    }
    
    private final void setupVideoPlayerOnMode() {
    }
    
    private final void setupButtonLogo() {
    }
    
    @java.lang.Override()
    public void showDialogAskWantToLoadSchedule() {
    }
    
    @java.lang.Override()
    public void onLoadScheduleWhilePlaySearchedVideos() {
    }
    
    private final void hideGroupViewComingUpNext() {
    }
    
    private final void setupVideoPlayerController() {
    }
    
    private final void setupMenuFloat() {
    }
    
    /**
     */
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void returnPrevScreen() {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    @java.lang.Override()
    public void onStartInitializePlayer() {
    }
    
    @java.lang.Override()
    public void reloadScheduledVideo() {
    }
    
    @java.lang.Override()
    public void onPlayerInitialized(@org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.SimpleExoPlayer player, boolean isReload) {
    }
    
    @java.lang.Override()
    public void onIntermediateStage() {
    }
    
    @java.lang.Override()
    public void onReceiveUpdateScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceivePlayVideoScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceiveResetScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiBackToHome() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeSub() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiBackToHomeGetConfigApi() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiGetConfigApi() {
    }
    
    private final void registerScheduleBroadcast() {
    }
    
    private final void unregisterScheduleBroadcast() {
    }
    
    private final void showVideoTitleAndCollections() {
    }
    
    private final void hideVideoTitleAndCollections() {
    }
    
    private final void showCountDown() {
    }
    
    private final void hideCountDown() {
    }
    
    @java.lang.Override()
    public void showUIForPlayingVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos) {
    }
    
    private final void showUI(player.wellnesssolutions.com.network.models.now_playing.MMVideo video, java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpNextVideos) {
    }
    
    private final void postDelayCheckVideoPosition() {
    }
    
    @java.lang.Override()
    public boolean isCastableOnTV() {
        return false;
    }
    
    @java.lang.Override()
    public void backToHomeScreenWithNotLoadSchedule() {
    }
    
    @java.lang.Override()
    public void openNoClassSearchScreen(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean isClickedFromBtnBottom) {
    }
    
    @java.lang.Override()
    public void hideGroupViewsComingUpNext() {
    }
    
    @java.lang.Override()
    public void onLoadingVideoDelay(long playedPosition) {
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
    public void onTimePlaySchedule() {
    }
    
    @java.lang.Override()
    public void showDialogAskWantToBackToHome(boolean isLoadSchedule) {
    }
    
    private final void switchToCurrentClass(java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos) {
    }
    
    @java.lang.Override()
    public void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.config.MMConfigData configData) {
    }
    
    @java.lang.Override()
    public void onVideoEnded() {
    }
    
    /**
     * @IRouterChangedListener
     */
    @java.lang.Override()
    public void onMediaRouterConnected() {
    }
    
    private final void registerMediaRouterConnected() {
    }
    
    private final void unRegisterMediaRouterConnected() {
    }
    
    @java.lang.Override()
    public void onCookieExpired() {
    }
    
    @java.lang.Override()
    public void showCountDownPlayTime(long millisUntilFinished) {
    }
    
    /**
     * implemented @Player.EventListener
     */
    @java.lang.Override()
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
    }
    
    /**
     * implemented @NetworkReceiver.IStateListener
     */
    @java.lang.Override()
    public void onChangedState(boolean isConnected) {
    }
    
    private final void registerNetworkConnecting() {
    }
    
    private final void unregisterNetworkConnecting() {
    }
    
    /**
     * LOAD BRANDS FROM BACKEND
     */
    @java.lang.Override()
    public void onLoadingBrands() {
    }
    
    @java.lang.Override()
    public void onEndLoadingBrands() {
    }
    
    private final void showLoadingBrand() {
    }
    
    private final void hideLoadingBrand() {
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
    
    private final void openControlScreen(androidx.fragment.app.Fragment newFragment) {
    }
    
    @java.lang.Override()
    public void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void openTimeTableScreen() {
    }
    
    public NowPlayingFragment() {
        super();
    }
    
    public void hideControlWhenNextVideoSchedule() {
    }
    
    public void hideCountDownTimer() {
    }
    
    public void onClearVideos() {
    }
    
    public void onMediaRouterDisconnected() {
    }
    
    public void onUpdateVideos(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo playingVideo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingVideos) {
    }
    
    /**
     * -------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/NowPlayingFragment$Companion;", "", "()V", "KEY_DATA_NOW_PLAYING", "", "KEY_DATA_PLAYING_VIDEO", "TAG", "getBundleBySearchedVideos", "Landroid/os/Bundle;", "data", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "getInstanceForSearchedVideos", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/NowPlayingFragment;", "getInstancePlaySchedule", "updateAlreadyInstanceWithSchedule", "Landroidx/fragment/app/Fragment;", "fragment", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment getInstanceForSearchedVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getBundleBySearchedVideos(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment getInstancePlaySchedule() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.fragment.app.Fragment updateAlreadyInstanceWithSchedule(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment fragment) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}