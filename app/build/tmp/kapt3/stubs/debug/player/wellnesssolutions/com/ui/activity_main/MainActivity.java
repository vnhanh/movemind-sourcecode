package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008e\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#J\b\u0010/\u001a\u00020\u0006H\u0002J\u0006\u00100\u001a\u00020-J\b\u00101\u001a\u00020-H\u0002J\b\u00102\u001a\u00020-H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0002J\u0006\u00108\u001a\u00020-J\u0006\u00109\u001a\u00020-J\u0018\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000205J\u0010\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010>\u001a\u000205J\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u0012\u0012\u0004\u0012\u00020B0\"j\b\u0012\u0004\u0012\u00020B`CJ\u000e\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020-H\u0002J\u0006\u0010H\u001a\u00020-J\u0010\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020KH\u0002J\u0006\u0010L\u001a\u00020\u0006J\u0006\u0010M\u001a\u00020\u0006J\u0006\u0010N\u001a\u00020\u0006J\u0006\u0010O\u001a\u00020\u0006J\u0006\u0010P\u001a\u00020-J\b\u0010Q\u001a\u00020-H\u0002J\b\u0010R\u001a\u00020-H\u0002J\b\u0010S\u001a\u00020-H\u0016J\u0006\u0010T\u001a\u00020-J\u0010\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020\u0006H\u0016J\b\u0010W\u001a\u00020-H\u0016J\u0012\u0010X\u001a\u00020-2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0015J\b\u0010[\u001a\u00020-H\u0014J\b\u0010\\\u001a\u00020-H\u0002J\b\u0010]\u001a\u00020-H\u0014J\u000e\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u00020 J-\u0010`\u001a\u00020-2\u0006\u0010a\u001a\u00020 2\u000e\u0010b\u001a\n\u0012\u0006\b\u0001\u0012\u0002050c2\u0006\u0010d\u001a\u00020eH\u0016\u00a2\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020-H\u0014J\u0010\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u000205H\u0002J\u0010\u0010j\u001a\u00020-2\u0006\u0010k\u001a\u00020\u0006H\u0016J\b\u0010l\u001a\u00020-H\u0002J\u0006\u0010m\u001a\u00020-J&\u0010n\u001a\u00020-2\u0006\u0010o\u001a\u00020@2\u0016\u0010p\u001a\u0012\u0012\u0004\u0012\u00020B0\"j\b\u0012\u0004\u0012\u00020B`CJ\u0010\u0010q\u001a\u00020-2\u0006\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020-H\u0002J\b\u0010u\u001a\u00020-H\u0002J\b\u0010v\u001a\u00020-H\u0002J\b\u0010w\u001a\u00020-H\u0002J\u0006\u0010x\u001a\u00020-J\u000e\u0010y\u001a\u00020-2\u0006\u0010.\u001a\u00020#J\b\u0010z\u001a\u00020-H\u0002J\u0010\u0010{\u001a\u00020-2\u0006\u0010|\u001a\u00020}H\u0002J\b\u0010~\u001a\u00020-H\u0002J\u0006\u0010\u007f\u001a\u00020-J\t\u0010\u0080\u0001\u001a\u00020-H\u0002J\u001d\u0010\u0081\u0001\u001a\u00020-2\t\b\u0001\u0010\u0082\u0001\u001a\u00020 2\t\b\u0001\u0010\u0083\u0001\u001a\u00020 J\t\u0010\u0084\u0001\u001a\u00020-H\u0002J\u0015\u0010\u0085\u0001\u001a\u00020-2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J\u001d\u0010\u0088\u0001\u001a\u00020-2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0006\u00104\u001a\u000205H\u0002J\t\u0010\u008b\u0001\u001a\u00020-H\u0002J\t\u0010\u008c\u0001\u001a\u00020-H\u0002J\t\u0010\u008d\u0001\u001a\u00020-H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008f\u0001"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lplayer/wellnesssolutions/com/network/network_connect/NetworkReceiver$IStateListener;", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$TVListener;", "()V", "appVisible", "", "getAppVisible", "()Z", "setAppVisible", "(Z)V", "mAudioManager", "Landroid/media/AudioManager;", "mBackToHomeDialog", "Landroidx/appcompat/app/AlertDialog;", "mBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "mDisconnectDialog", "mEventReceiver", "Landroid/content/ComponentName;", "mIsFirst", "mIsReturnScanScreen", "mIsVisble", "mMediaPendingIntent", "Landroid/app/PendingIntent;", "mMediaRouterCB", "Landroidx/mediarouter/media/MediaRouter$Callback;", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mPlayer", "Lplayer/wellnesssolutions/com/ui/fragment_presentation/players/MMPlayer;", "mPresentationId", "", "mRouterChangedListeners", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/ui/activity_main/IRouterChanged;", "mSelector", "Landroidx/mediarouter/media/MediaRouteSelector;", "mSessionCallback", "Lplayer/wellnesssolutions/com/ui/fragment_presentation/MMSessionManager$Callback;", "mSessionManager", "Lplayer/wellnesssolutions/com/ui/fragment_presentation/MMSessionManager;", "tvNumberDownload", "Landroid/widget/TextView;", "addRouterChangedListener", "", "listener", "checkAuthorized", "checkFileStorageDownloaded", "checkForCrashes", "checkForUpdates", "checkSendTokenDeviceFCM", "token", "", "clearAllDataDownload", "clearFileAndDBForDownload", "clearPresentationVideos", "getApiConfigData", "getFragment", "Landroidx/fragment/app/Fragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "tag", "getPresentationPlayMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "getPresentationVideos", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "getTokenAgainWhenTokenExpire", "callback", "Lplayer/wellnesssolutions/com/base/view/IGetNewToken;", "goToScanBarCode", "hideDialogBackToHome", "initRoute", "route", "Landroidx/mediarouter/media/MediaRouter$RouteInfo;", "isPlayingNowPlaying", "isPlayingPresentation", "isPlayingSearchVideos", "isPresentationAvailable", "navigateToHomeScreen", "notifyRouterConnected", "notifyRouterDisconnected", "onBackPressed", "onBackPreviousScreen", "onChangedState", "isConnected", "onCookieExpired", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInsufficientSpace", "onPause", "onPlayPresentationVideoAt", "position", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onReturnHomeScreen", "message", "onWindowFocusChanged", "hasFocus", "openPresentationIfIsPlaying", "openScanBarCodeScreen", "playVideo", "mode", "videos", "readDownloadIntent", "intent", "Landroid/content/Intent;", "registerMediaRouter", "registerReceivers", "registerRemoteControlClient", "registerService", "releaseRoute", "removeRouterChangedListener", "returnHomeScreen", "savePref", "data", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "setupUI", "showDialogBackToHome", "showDialogLoadingDownloaded", "showMessage", "messageRes", "colorRes", "showNetworkDisconnectedDialogIf", "storeBranding", "branding", "Lplayer/wellnesssolutions/com/network/models/login/MMBranding;", "storeCookie", "cookie", "Lplayer/wellnesssolutions/com/network/models/login/MMCookie;", "unregisterManagers", "unregisterReceivers", "unregisterRemoteControlClient", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements player.wellnesssolutions.com.network.network_connect.NetworkReceiver.IStateListener, player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener {
    private androidx.mediarouter.media.MediaRouteSelector mSelector;
    private final player.wellnesssolutions.com.ui.fragment_presentation.MMSessionManager mSessionManager = null;
    private player.wellnesssolutions.com.ui.fragment_presentation.players.MMPlayer mPlayer;
    private android.media.AudioManager mAudioManager;
    private android.support.v4.media.session.MediaSessionCompat mMediaSession;
    private android.content.ComponentName mEventReceiver;
    private android.app.PendingIntent mMediaPendingIntent;
    private boolean mIsReturnScanScreen = false;
    private int mPresentationId = -1;
    private boolean mIsFirst = true;
    private boolean mIsVisble = false;
    private androidx.appcompat.app.AlertDialog mDisconnectDialog;
    private androidx.appcompat.app.AlertDialog mBackToHomeDialog;
    private android.widget.TextView tvNumberDownload;
    private final android.content.BroadcastReceiver mBroadcastReceiver = null;
    private boolean appVisible = true;
    
    /**
     * IRouterChangedListener
     */
    private java.util.ArrayList<player.wellnesssolutions.com.ui.activity_main.IRouterChanged> mRouterChangedListeners;
    
    /**
     * end IRouterChangedListener
     */
    private final androidx.mediarouter.media.MediaRouter.Callback mMediaRouterCB = null;
    private final player.wellnesssolutions.com.ui.fragment_presentation.MMSessionManager.Callback mSessionCallback = null;
    private static final java.lang.String TAG = "MainActivity";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.activity_main.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean getAppVisible() {
        return false;
    }
    
    public final void setAppVisible(boolean p0) {
    }
    
    public final void addRouterChangedListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.IRouterChanged listener) {
    }
    
    public final void removeRouterChangedListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_main.IRouterChanged listener) {
    }
    
    private final void notifyRouterConnected() {
    }
    
    private final void notifyRouterDisconnected() {
    }
    
    private final void initRoute(androidx.mediarouter.media.MediaRouter.RouteInfo route) {
    }
    
    public final void releaseRoute() {
    }
    
    private final void openPresentationIfIsPlaying() {
    }
    
    private final void registerRemoteControlClient() {
    }
    
    private final void unregisterRemoteControlClient() {
    }
    
    private final void registerMediaRouter() {
    }
    
    public final boolean isPresentationAvailable() {
        return false;
    }
    
    public final void playVideo(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.datasource.videos.PlayMode mode, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @kotlin.Suppress(names = {"DEPRECATION"})
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkSendTokenDeviceFCM(java.lang.String token) {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    private final void clearFileAndDBForDownload() {
    }
    
    private final void registerService() {
    }
    
    private final void registerReceivers() {
    }
    
    private final boolean checkAuthorized() {
        return false;
    }
    
    private final void readDownloadIntent(android.content.Intent intent) {
    }
    
    private final void showDialogLoadingDownloaded() {
    }
    
    private final void onInsufficientSpace() {
    }
    
    private final void goToScanBarCode() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void showNetworkDisconnectedDialogIf() {
    }
    
    public final void showDialogBackToHome() {
    }
    
    public final void hideDialogBackToHome() {
    }
    
    public final void getTokenAgainWhenTokenExpire(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.view.IGetNewToken callback) {
    }
    
    private final void storeCookie(player.wellnesssolutions.com.network.models.login.MMCookie cookie, java.lang.String token) {
    }
    
    public final void getApiConfigData() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void unregisterReceivers() {
    }
    
    public final void checkFileStorageDownloaded() {
    }
    
    public final void navigateToHomeScreen() {
    }
    
    /**
     * Hockey App
     */
    private final void checkForCrashes() {
    }
    
    private final void checkForUpdates() {
    }
    
    private final void unregisterManagers() {
    }
    
    /**
     * ---------
     */
    private final void setupUI() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.fragment.app.Fragment getFragment(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.fragment.app.Fragment getFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    public final void onBackPreviousScreen() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public final void openScanBarCodeScreen() {
    }
    
    private final void clearAllDataDownload() {
    }
    
    @java.lang.Override()
    public void onChangedState(boolean isConnected) {
    }
    
    public final void showMessage(@androidx.annotation.StringRes()
    int messageRes, @androidx.annotation.ColorRes()
    int colorRes) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public final boolean isPlayingNowPlaying() {
        return false;
    }
    
    public final boolean isPlayingSearchVideos() {
        return false;
    }
    
    public final boolean isPlayingPresentation() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.com.network.datasource.videos.PlayMode getPresentationPlayMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getPresentationVideos() {
        return null;
    }
    
    public final void onPlayPresentationVideoAt(int position) {
    }
    
    public final void clearPresentationVideos() {
    }
    
    private final void storeBranding(player.wellnesssolutions.com.network.models.login.MMBranding branding) {
    }
    
    private final void savePref(player.wellnesssolutions.com.network.models.config.MMConfigData data) {
    }
    
    /**
     * @interface CastingBroadcastReceiver.Callback
     */
    @java.lang.Override()
    public void onCookieExpired() {
    }
    
    private final void onReturnHomeScreen(java.lang.String message) {
    }
    
    private final void returnHomeScreen() {
    }
    
    public MainActivity() {
        super();
    }
    
    public void onPlayerReady(boolean isShowPlayPauseButton, boolean isPlaying, long currentPosition, long duration) {
    }
    
    public void onUpdateEndedVideoState() {
    }
    
    public void onUpdateEndedVideoStateSchedule() {
    }
    
    public void onUpdateLoadingVideoState() {
    }
    
    public void onUpdateProgress(boolean isShowPlayPauseButton, boolean isPlaying, long position) {
    }
    
    public void onUpdateTranslatedVideoState() {
    }
    
    /**
     * ---------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/MainActivity$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}