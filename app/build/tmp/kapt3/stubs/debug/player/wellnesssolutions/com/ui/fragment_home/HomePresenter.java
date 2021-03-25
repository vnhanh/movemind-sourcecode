package player.wellnesssolutions.com.ui.fragment_home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0014J\u0018\u0010\u001e\u001a\u00020\u00102\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u0016\u0010$\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010&\u001a\u00020\u00102\b\u0010\'\u001a\u0004\u0018\u00010(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_home/HomePresenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$Presenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mHomeApi", "Lplayer/wellnesssolutions/com/network/datasource/home/HomeApi;", "mLoadedConfig", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_home/IHomeContract$View;", "schedule", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "onAttach", "", "view", "onComplete", "onDestroy", "onDetach", "onExpired", "error", "", "onExpiredUnauthenticated", "onRequestError", "message", "onResponseFalse", "code", "", "onResponseSuccess", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onTimePlayAlreadySchedule", "readConfigData", "savePref", "setScheduleCurrent", "videos", "storeBranding", "branding", "Lplayer/wellnesssolutions/com/network/models/login/MMBranding;", "app_debug"})
public final class HomePresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<player.wellnesssolutions.com.network.models.config.MMConfigData> implements player.wellnesssolutions.com.ui.fragment_home.IHomeContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View mView;
    private player.wellnesssolutions.com.network.datasource.home.HomeApi mHomeApi;
    private player.wellnesssolutions.com.network.models.config.MMConfigData mLoadedConfig;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> schedule;
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_home.IHomeContract.View view) {
    }
    
    @java.lang.Override()
    public void setScheduleCurrent(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    @java.lang.Override()
    public void onTimePlayAlreadySchedule() {
    }
    
    private final void readConfigData() {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<player.wellnesssolutions.com.network.models.config.MMConfigData> data) {
    }
    
    private final void storeBranding(player.wellnesssolutions.com.network.models.login.MMBranding branding) {
    }
    
    private final void savePref(player.wellnesssolutions.com.network.models.config.MMConfigData data) {
    }
    
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public HomePresenter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}