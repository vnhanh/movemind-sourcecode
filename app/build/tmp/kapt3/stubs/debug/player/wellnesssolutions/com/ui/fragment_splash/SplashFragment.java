package player.wellnesssolutions.com.ui.fragment_splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0012\u0010 \u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J\u0010\u0010\'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\u0014H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_splash/SplashFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$View;", "Landroid/view/View$OnClickListener;", "()V", "MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE", "", "PERIOD", "", "dialog", "Landroidx/appcompat/app/AlertDialog;", "handler", "Landroid/os/Handler;", "mIsStopProgressbar", "", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$Presenter;", "runnableLoading", "Ljava/lang/Runnable;", "backToScanQRCode", "", "callGetTokenAgain", "navigateToHomeScreen", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCallServiceFailed", "messageRes", "onClick", "view", "Landroid/view/View;", "onClickedRefreshView", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onExpired", "message", "", "onPause", "onResume", "onStartLoadApi", "setupUI", "updateProgress", "progress", "app_debug"})
public final class SplashFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.View, android.view.View.OnClickListener {
    private player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.Presenter mPresenter;
    private final long PERIOD = 100L;
    private int MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE = 60;
    private boolean mIsStopProgressbar = false;
    private androidx.appcompat.app.AlertDialog dialog;
    private final android.os.Handler handler = null;
    private final java.lang.Runnable runnableLoading = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void setupUI() {
    }
    
    @java.lang.Override()
    public void onStartLoadApi() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    private final void onClickedRefreshView(android.view.View view) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void updateProgress(int progress) {
    }
    
    @java.lang.Override()
    public void navigateToHomeScreen() {
    }
    
    @java.lang.Override()
    public void onCallServiceFailed(int messageRes) {
    }
    
    @java.lang.Override()
    public void backToScanQRCode() {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void callGetTokenAgain() {
    }
    
    public SplashFragment() {
        super();
    }
}