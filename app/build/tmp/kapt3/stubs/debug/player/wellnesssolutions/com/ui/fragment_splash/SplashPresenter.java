package player.wellnesssolutions.com.ui.fragment_splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0016H\u0016J\u0012\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0014J\u001a\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010&\u001a\u00020\u00132\u000e\u0010\'\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0013H\u0014J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\'\u001a\u00020\u0002H\u0002J\u0012\u0010+\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010-H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_splash/SplashPresenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$Presenter;", "Lplayer/wellnesssolutions/com/network/network_connect/NetworkReceiver$IStateListener;", "()V", "REQUEST_FAILED", "", "RESPONSE_FALSE", "RESPONSE_SUCCESS", "isLoading", "", "mConfigApi", "Lplayer/wellnesssolutions/com/network/datasource/home/HomeApi;", "mLoadedData", "mRequestCode", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$View;", "handleOnCallServiceFailed", "", "loadApi", "token", "", "deviceId", "onAttach", "view", "onChangedState", "isConnected", "onComplete", "onDestroy", "onDetach", "onExpired", "error", "onExpiredUnauthenticated", "onRequestError", "message", "onResponseFalse", "code", "onResponseSuccess", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onUnAuthorized", "savePref", "storeBranding", "branding", "Lplayer/wellnesssolutions/com/network/models/login/MMBranding;", "app_debug"})
public final class SplashPresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<player.wellnesssolutions.com.network.models.config.MMConfigData> implements player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.Presenter, player.wellnesssolutions.com.network.network_connect.NetworkReceiver.IStateListener {
    private player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.View mView;
    private player.wellnesssolutions.com.network.models.config.MMConfigData mLoadedData;
    private player.wellnesssolutions.com.network.datasource.home.HomeApi mConfigApi;
    private final int REQUEST_FAILED = -1;
    private final int RESPONSE_SUCCESS = 1;
    private final int RESPONSE_FALSE = -10;
    private int mRequestCode;
    private boolean isLoading = false;
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.View view) {
    }
    
    @java.lang.Override()
    public void loadApi() {
    }
    
    private final void loadApi(java.lang.String token, java.lang.String deviceId) {
    }
    
    /**
     * Response successfully
     */
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<player.wellnesssolutions.com.network.models.config.MMConfigData> data) {
    }
    
    private final void storeBranding(player.wellnesssolutions.com.network.models.login.MMBranding branding) {
    }
    
    private final void savePref(player.wellnesssolutions.com.network.models.config.MMConfigData data) {
    }
    
    /**
     * -----------
     */
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onUnAuthorized() {
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    private final void handleOnCallServiceFailed() {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onChangedState(boolean isConnected) {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public SplashPresenter() {
        super();
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}