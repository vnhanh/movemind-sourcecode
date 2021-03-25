package player.wellnesssolutions.com.ui.activity_scan_barcode;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014J\u001a\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014J\u0018\u0010\u001d\u001a\u00020\u00102\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u000eH\u0017J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020\u00102\b\u0010\'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodePresenter;", "Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "", "mView", "Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$View;", "(Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$View;)V", "loginService", "Lplayer/wellnesssolutions/com/network/datasource/login/LoginApi;", "mPref", "Lplayer/wellnesssolutions/com/common/sharedpreferences/PreferenceHelper;", "checkFormatBarcode", "", "string", "", "login", "", "onAttach", "view", "onDestroy", "onDetach", "onExpired", "error", "onExpiredUnauthenticated", "onRequestError", "message", "onResponseFalse", "code", "", "onResponseSuccess", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "requestActiveDevice", "email", "storeBranding", "token", "branding", "Lplayer/wellnesssolutions/com/network/models/login/MMBranding;", "storeCookie", "cookie", "Lplayer/wellnesssolutions/com/network/models/login/MMCookie;", "storeInformation", "body", "Lplayer/wellnesssolutions/com/network/models/scan_bar_code/MMQRCodeResponse;", "app_debug"})
public final class ScanBarCodePresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<java.lang.Object> implements player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter {
    private player.wellnesssolutions.com.network.datasource.login.LoginApi loginService;
    private player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper mPref;
    private final player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View mView = null;
    
    private final void storeInformation(player.wellnesssolutions.com.network.models.scan_bar_code.MMQRCodeResponse body) {
    }
    
    private final void storeBranding(java.lang.String token, player.wellnesssolutions.com.network.models.login.MMBranding branding) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View view) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public boolean checkFormatBarcode(@org.jetbrains.annotations.NotNull()
    java.lang.String string) {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @java.lang.Override()
    public void requestActiveDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    @java.lang.Override()
    public void login() {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<java.lang.Object> data) {
    }
    
    private final void storeCookie(player.wellnesssolutions.com.network.models.login.MMCookie cookie) {
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
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public ScanBarCodePresenter(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View mView) {
        super();
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}