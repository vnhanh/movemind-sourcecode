package player.wellnesssolutions.com.ui.fragment_control;

import java.lang.System;

/**
 * This fragment is container of screens (child fragments) such as Brands screen, Search Preview screen, Search Video Results screen...
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0099\u0001B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\'2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020#H\u0002J\u0018\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000eH\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0016J\u0006\u00102\u001a\u00020#J\b\u00103\u001a\u00020#H\u0016J\b\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u00020#H\u0002J\u0006\u00106\u001a\u00020#J \u00107\u001a\u00020#2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\'2\u0006\u0010;\u001a\u00020\u000eH\u0002J\b\u0010<\u001a\u00020#H\u0002J\u0012\u0010=\u001a\u00020#2\b\u0010>\u001a\u0004\u0018\u00010)H\u0016J\b\u0010?\u001a\u00020#H\u0016J\b\u0010@\u001a\u00020#H\u0002J\b\u0010A\u001a\u00020#H\u0002J&\u0010B\u001a\u0004\u0018\u00010.2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010>\u001a\u0004\u0018\u00010)H\u0016J\b\u0010G\u001a\u00020#H\u0016J\b\u0010H\u001a\u00020#H\u0016J\b\u0010I\u001a\u00020#H\u0016J(\u0010J\u001a\u00020#2\u0016\u0010K\u001a\u0012\u0012\u0004\u0012\u00020L0\u0014j\b\u0012\u0004\u0012\u00020L`\u00162\u0006\u0010M\u001a\u00020\u000eH\u0016J\u0018\u0010N\u001a\u00020#2\u0006\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020\u000eH\u0016J(\u0010Q\u001a\u00020#2\u0016\u0010R\u001a\u0012\u0012\u0004\u0012\u00020S0\u0014j\b\u0012\u0004\u0012\u00020S`\u00162\u0006\u0010T\u001a\u00020\tH\u0016J\u0010\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020\u000eH\u0016J\b\u0010W\u001a\u00020#H\u0016J\b\u0010X\u001a\u00020#H\u0016J\b\u0010Y\u001a\u00020#H\u0016J\"\u0010Z\u001a\u00020#2\u0006\u0010V\u001a\u00020\u000e2\b\b\u0001\u0010[\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\tH\u0016J\b\u0010\\\u001a\u00020#H\u0016J(\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020!2\u0006\u0010a\u001a\u00020!H\u0016J\b\u0010b\u001a\u00020#H\u0016J\b\u0010c\u001a\u00020#H\u0016J\b\u0010d\u001a\u00020#H\u0016J\b\u0010e\u001a\u00020#H\u0016J\b\u0010f\u001a\u00020#H\u0016J\b\u0010g\u001a\u00020#H\u0016J\b\u0010h\u001a\u00020#H\u0016J\b\u0010i\u001a\u00020#H\u0016J\b\u0010j\u001a\u00020#H\u0016J \u0010k\u001a\u00020#2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010l\u001a\u00020!H\u0016J\b\u0010m\u001a\u00020#H\u0016J(\u0010n\u001a\u00020#2\u0006\u0010o\u001a\u00020S2\u0016\u0010p\u001a\u0012\u0012\u0004\u0012\u00020S0\u0014j\b\u0012\u0004\u0012\u00020S`\u0016H\u0016J\u0010\u0010q\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010r\u001a\u00020#2\u0006\u0010:\u001a\u00020\'2\u0006\u0010s\u001a\u00020\u000eJ\b\u0010t\u001a\u00020#H\u0002J\b\u0010u\u001a\u00020#H\u0002J\b\u0010v\u001a\u00020#H\u0002J\b\u0010w\u001a\u00020#H\u0002J\u0010\u0010x\u001a\u00020#2\u0006\u0010_\u001a\u00020\tH\u0002J\b\u0010y\u001a\u00020#H\u0002J\b\u0010z\u001a\u00020#H\u0002J\u0010\u0010{\u001a\u00020#2\u0006\u0010|\u001a\u00020\u001cH\u0002J\b\u0010}\u001a\u00020#H\u0002J\b\u0010~\u001a\u00020#H\u0002J\b\u0010\u007f\u001a\u00020#H\u0002J\t\u0010\u0080\u0001\u001a\u00020#H\u0002J\t\u0010\u0081\u0001\u001a\u00020#H\u0002J\t\u0010\u0082\u0001\u001a\u00020#H\u0002J\t\u0010\u0083\u0001\u001a\u00020#H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\u000eH\u0002J\t\u0010\u0086\u0001\u001a\u00020#H\u0002J\u0013\u0010\u0087\u0001\u001a\u00020#2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u0007\u0010\u008a\u0001\u001a\u00020#J\t\u0010\u008b\u0001\u001a\u00020#H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020#2\u0007\u0010\u008d\u0001\u001a\u00020\u001c2\u0007\u0010\u008e\u0001\u001a\u00020\u001cH\u0016J\u001a\u0010\u008c\u0001\u001a\u00020#2\u0006\u0010V\u001a\u00020\u000e2\u0007\u0010\u008e\u0001\u001a\u00020\u001cH\u0016J\t\u0010\u008f\u0001\u001a\u00020#H\u0002J\t\u0010\u0090\u0001\u001a\u00020#H\u0002J+\u0010\u0091\u0001\u001a\u00020#2\u0007\u0010\u0092\u0001\u001a\u00020S2\u0017\u0010\u0093\u0001\u001a\u0012\u0012\u0004\u0012\u00020S0\u0014j\b\u0012\u0004\u0012\u00020S`\u0016H\u0016J\t\u0010\u0094\u0001\u001a\u00020#H\u0002J\t\u0010\u0095\u0001\u001a\u00020#H\u0002J\t\u0010\u0096\u0001\u001a\u00020#H\u0002J\t\u0010\u0097\u0001\u001a\u00020#H\u0002J\t\u0010\u0098\u0001\u001a\u00020#H\u0002R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009a\u0001"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/ControlFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseScheduleFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$View;", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "Lplayer/wellnesssolutions/com/ui/activity_main/IRouterChanged;", "Lplayer/wellnesssolutions/com/ui/activity_main/CastingBroadcastReceiver$TVListener;", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$ScheduleListener;", "()V", "isClicked", "", "()Z", "setClicked", "(Z)V", "mCurrentChildScreenTag", "", "getMCurrentChildScreenTag", "()Ljava/lang/String;", "setMCurrentChildScreenTag", "(Ljava/lang/String;)V", "mExtraNPGCUCollectionViews", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "mIsShownMenu", "mIsVideoPlayingTimebarMinute", "mMenuAnimationHelper", "Lplayer/wellnesssolutions/com/ui/fragment_control/helpers/MMMenuAnimationHelper;", "mMenuHeight", "", "mMenuWidth", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$Presenter;", "mVideoPlayingDuration", "", "backToHome", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "getChildFragmentByBrandData", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "getChildFragmentByBrandsListAndFlowTag", "handleClickedFloatMenu", "handleSearchFlow", "view", "Landroid/view/View;", "searchScreenTag", "hideFloatMenu", "hideGroupComingUpNext", "hideLoadingBrand", "hideLoadingProgress", "hidePlayPauseButtonInPlaylist", "hidePresentationPlaylist", "loadNowPlayingScreen", "loadScreen", "fm", "Landroidx/fragment/app/FragmentManager;", "newFragment", "newTag", "loadTimeTable", "onActivityCreated", "savedInstanceState", "onClearVideos", "onClickedButtonLogo", "onClickedButtonMenuFloat", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onEndLoadingBrands", "onGetBrands", "brands", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "searchBrandFlowTag", "onGetOnlyOneBrand", "brand", "nextScreenTag", "onHaveClassVideos", "scheduleVideos", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "isClickedFromBtnBottom", "onLoadBrandsFailed", "message", "onLoadingBrands", "onMediaRouterConnected", "onMediaRouterDisconnected", "onNoClassVideosForNow", "msgColor", "onPause", "onPlayerReady", "isShowPlayPauseButton", "isPlaying", "currentPosition", "duration", "onReceiveChangeApiBackToHome", "onReceiveChangeApiBackToHomeGetConfigApi", "onReceiveChangeApiGetConfigApi", "onReceiveChangeSub", "onResume", "onTimePlaySchedule", "onUpdateEndedVideoState", "onUpdateEndedVideoStateSchedule", "onUpdateLoadingVideoState", "onUpdateProgress", "position", "onUpdateTranslatedVideoState", "onUpdateVideos", "playingVideo", "comingVideos", "openNewScreenByMenuItem", "openNextScreen", "newFragmentTag", "readArguments", "registerCastingTVBroadcast", "registerRouterChangedListener", "registerScheduleBroadcast", "renderButtonPlayPausePlaylist", "setHeighForGroupViewComingUpNextHasTimebar", "setHeightNormalForGroupViewComingUpNext", "setWidthForTimeTV", "width", "setWidthTimeTVByHourUnit", "setWidthTimeTVByMinuteUnit", "setupButtonFloatMenu", "setupButtonPlayPausePlaylist", "setupButtonPlaylist", "setupFloatMenu", "setupGCUTouchEvent", "setupSearchFlowForBrandSearch", "screenTag", "setupUI", "setupViewFloatMenu", "configData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "showLoadingBrand", "showLoadingProgress", "showMessage", "messageRes", "color", "showPauseVideoUIOnPlaylist", "showPlayVideoUIOnPlaylist", "showPresentationPlayList", "nowPlayVideo", "comingUpVideos", "showPresentationPlaylist", "showTranslateToAnotherVideoUIOnPlaylist", "unregisterCastingTVBroadcast", "unregisterRouterChangedListener", "unregisterScheduleBroadcast", "Companion", "app_debug"})
public final class ControlFragment extends player.wellnesssolutions.com.base.view.BaseScheduleFragment implements player.wellnesssolutions.com.ui.fragment_control.IControlContract.View, player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View, player.wellnesssolutions.com.ui.activity_main.IRouterChanged, player.wellnesssolutions.com.ui.activity_main.CastingBroadcastReceiver.TVListener, player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener {
    private player.wellnesssolutions.com.ui.fragment_control.IControlContract.Presenter mPresenter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mCurrentChildScreenTag = "";
    private boolean isClicked = false;
    private java.util.ArrayList<android.widget.TextView> mExtraNPGCUCollectionViews;
    private player.wellnesssolutions.com.ui.fragment_control.helpers.MMMenuAnimationHelper mMenuAnimationHelper;
    private int mMenuWidth = 0;
    private int mMenuHeight = 0;
    private boolean mIsShownMenu = false;
    
    /**
     * @interface CastingBroadcastReceiver.Callback
     */
    private long mVideoPlayingDuration = 1L;
    private boolean mIsVideoPlayingTimebarMinute = true;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ControlFragment";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_CHILD_SCREEN_TAG = "EXTRA_CHILD_SCREEN_TAG";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_BRAND = "EXTRA_BRAND";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_control.ControlFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMCurrentChildScreenTag() {
        return null;
    }
    
    public final void setMCurrentChildScreenTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isClicked() {
        return false;
    }
    
    public final void setClicked(boolean p0) {
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
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    /**
     * implementing @interface Presenter
     */
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
    
    public final void loadNowPlayingScreen() {
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
    
    private final void backToHome(androidx.fragment.app.FragmentActivity activity) {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.config.MMConfigData configData) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupGCUTouchEvent() {
    }
    
    private final void readArguments() {
    }
    
    private final androidx.fragment.app.Fragment getChildFragmentByBrandsListAndFlowTag(android.os.Bundle bundle) {
        return null;
    }
    
    private final androidx.fragment.app.Fragment getChildFragmentByBrandData(android.os.Bundle bundle) {
        return null;
    }
    
    private final void onClickedButtonLogo() {
    }
    
    private final void setupButtonFloatMenu() {
    }
    
    private final void onClickedButtonMenuFloat() {
    }
    
    private final void setupFloatMenu() {
    }
    
    private final void handleClickedFloatMenu() {
    }
    
    private final void handleSearchFlow(android.view.View view, java.lang.String searchScreenTag) {
    }
    
    private final boolean setupSearchFlowForBrandSearch(java.lang.String screenTag) {
        return false;
    }
    
    private final void openNewScreenByMenuItem(android.view.View view) {
    }
    
    private final void hideFloatMenu() {
    }
    
    private final void loadTimeTable() {
    }
    
    private final void loadScreen(androidx.fragment.app.FragmentManager fm, androidx.fragment.app.Fragment newFragment, java.lang.String newTag) {
    }
    
    /**
     * @IRouterChangedListener
     */
    @java.lang.Override()
    public void onMediaRouterConnected() {
    }
    
    @java.lang.Override()
    public void onMediaRouterDisconnected() {
    }
    
    @java.lang.Override()
    public void onUpdateVideos(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo playingVideo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingVideos) {
    }
    
    @java.lang.Override()
    public void onClearVideos() {
    }
    
    private final void showPresentationPlaylist() {
    }
    
    private final void hidePresentationPlaylist() {
    }
    
    private final void registerRouterChangedListener() {
    }
    
    private final void registerCastingTVBroadcast() {
    }
    
    private final void registerScheduleBroadcast() {
    }
    
    private final void unregisterCastingTVBroadcast() {
    }
    
    private final void unregisterScheduleBroadcast() {
    }
    
    private final void unregisterRouterChangedListener() {
    }
    
    private final void setupButtonPlaylist() {
    }
    
    @java.lang.Override()
    public void showPresentationPlayList(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo nowPlayVideo, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos) {
    }
    
    @java.lang.Override()
    public void hideGroupComingUpNext() {
    }
    
    @java.lang.Override()
    public void onPlayerReady(boolean isShowPlayPauseButton, boolean isPlaying, long currentPosition, long duration) {
    }
    
    private final void setWidthTimeTVByMinuteUnit() {
    }
    
    private final void setWidthTimeTVByHourUnit() {
    }
    
    private final void setWidthForTimeTV(int width) {
    }
    
    @java.lang.Override()
    public void onUpdateProgress(boolean isShowPlayPauseButton, boolean isPlaying, long position) {
    }
    
    @java.lang.Override()
    public void onUpdateLoadingVideoState() {
    }
    
    @java.lang.Override()
    public void onUpdateEndedVideoState() {
    }
    
    @java.lang.Override()
    public void onUpdateEndedVideoStateSchedule() {
    }
    
    @java.lang.Override()
    public void onUpdateTranslatedVideoState() {
    }
    
    private final void renderButtonPlayPausePlaylist(boolean isPlaying) {
    }
    
    private final void hidePlayPauseButtonInPlaylist() {
    }
    
    private final void showPlayVideoUIOnPlaylist() {
    }
    
    private final void showPauseVideoUIOnPlaylist() {
    }
    
    private final void showTranslateToAnotherVideoUIOnPlaylist() {
    }
    
    private final void setHeightNormalForGroupViewComingUpNext() {
    }
    
    private final void setHeighForGroupViewComingUpNextHasTimebar() {
    }
    
    private final void setupButtonPlayPausePlaylist() {
    }
    
    /**
     * SHOW LOADING BRAND VIEWS
     */
    public final void showLoadingBrand() {
    }
    
    public final void hideLoadingBrand() {
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
    
    public final void openNextScreen(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment newFragment, @org.jetbrains.annotations.NotNull()
    java.lang.String newFragmentTag) {
    }
    
    @java.lang.Override()
    public void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public ControlFragment() {
        super();
    }
    
    public void onCookieExpired() {
    }
    
    /**
     * ---------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J&\u0010\u000b\u001a\u00020\f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0015"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/ControlFragment$Companion;", "", "()V", "EXTRA_BRAND", "", "getEXTRA_BRAND", "()Ljava/lang/String;", "EXTRA_CHILD_SCREEN_TAG", "getEXTRA_CHILD_SCREEN_TAG", "TAG", "getTAG", "getInstance", "Lplayer/wellnesssolutions/com/ui/fragment_control/ControlFragment;", "screenTag", "brands", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "Lkotlin/collections/ArrayList;", "searchBrandFlowTag", "brand", "childScreenTag", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEXTRA_CHILD_SCREEN_TAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEXTRA_BRAND() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_control.ControlFragment getInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String screenTag) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_control.ControlFragment getInstance(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
        java.lang.String searchBrandFlowTag) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_control.ControlFragment getInstance(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
        java.lang.String childScreenTag) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}