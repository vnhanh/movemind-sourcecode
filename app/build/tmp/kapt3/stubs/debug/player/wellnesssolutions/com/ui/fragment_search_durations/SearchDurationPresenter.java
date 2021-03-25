package player.wellnesssolutions.com.ui.fragment_search_durations;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010$\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u0010&\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0002J\u001a\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0014J\u001e\u0010)\u001a\u00020\u00112\u0014\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u0011H\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_durations/SearchDurationPresenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMDuration;", "Lplayer/wellnesssolutions/com/ui/fragment_search_durations/ISearchDurationContract$Presenter;", "()V", "mBrand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "mData", "mDurationApi", "Lplayer/wellnesssolutions/com/network/datasource/duration/DurationApi;", "mIsProcessing", "", "mIsRendered", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_search_durations/ISearchDurationContract$View;", "displayUI", "", "loadData", "view", "loadDurations", "token", "", "deviceId", "brandId", "", "onAttach", "onChooseItem", "data", "onComplete", "onDestroy", "onDetach", "onExpired", "error", "onExpiredUnauthenticated", "onReShowUI", "onRequestError", "message", "onRequestFailed", "onResponseFalse", "code", "onResponseSuccess", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onStop", "setChosenBrand", "brand", "app_debug"})
public final class SearchDurationPresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMDuration>> implements player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract.View mView;
    private player.wellnesssolutions.com.network.datasource.duration.DurationApi mDurationApi;
    private player.wellnesssolutions.com.network.models.screen_search.MMBrand mBrand;
    private boolean mIsProcessing = false;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMDuration> mData;
    private boolean mIsRendered = false;
    
    @java.lang.Override()
    public void setChosenBrand(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand brand) {
    }
    
    @java.lang.Override()
    public void onChooseItem(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMDuration data) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract.View view) {
    }
    
    @java.lang.Override()
    public void loadData(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract.View view) {
    }
    
    @java.lang.Override()
    public void onReShowUI(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract.View view) {
    }
    
    private final void displayUI() {
    }
    
    private final void loadDurations(java.lang.String token, java.lang.String deviceId, int brandId) {
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
    
    /**
     * Response for Retrofit
     */
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMDuration>> data) {
    }
    
    @java.lang.Override()
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private final void onRequestFailed(java.lang.String message) {
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
    
    public SearchDurationPresenter() {
        super();
    }
}