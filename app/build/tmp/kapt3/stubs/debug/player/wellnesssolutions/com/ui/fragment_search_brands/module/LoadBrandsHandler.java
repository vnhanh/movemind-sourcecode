package player.wellnesssolutions.com.ui.fragment_search_brands.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u00012\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0014J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0014J(\u0010\u001d\u001a\u00020\u000f2\u001e\u0010\u001e\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u000f2\b\b\u0001\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/LoadBrandsHandler;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "Lkotlin/collections/ArrayList;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler;", "callback", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "(Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;)V", "mBrandApi", "Lplayer/wellnesssolutions/com/network/datasource/brand/BrandApi;", "mCallback", "mFlowTag", "", "loadApi", "", "token", "deviceId", "loadBrands", "tag", "onComplete", "onExpired", "error", "onExpiredUnauthenticated", "onRequestError", "message", "onResponseFalse", "code", "", "onResponseSuccess", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onShowRequestApiFalse", "msgResId", "release", "app_debug"})
public final class LoadBrandsHandler extends player.wellnesssolutions.com.base.view.BaseResponseObserver<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand>> implements player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler {
    private final player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback mCallback = null;
    private player.wellnesssolutions.com.network.datasource.brand.BrandApi mBrandApi;
    private java.lang.String mFlowTag = "";
    
    @java.lang.Override()
    public void loadBrands(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    private final void loadApi(java.lang.String token, java.lang.String deviceId) {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand>> data) {
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
    
    private final void onShowRequestApiFalse(@androidx.annotation.StringRes()
    int msgResId) {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    public LoadBrandsHandler(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback callback) {
        super();
    }
}