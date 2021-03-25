package player.wellnesssolutions.com.ui.fragment_search_collections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u00012\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u001a\u0010\'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014J(\u0010*\u001a\u00020\u00122\u001e\u0010\u001d\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0018\u00010+H\u0014J\u0012\u0010,\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010-\u001a\u00020\u0012H\u0016J0\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\bH\u0016J2\u00102\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\u00172\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_collections/SearchCollectionsPresenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMCollection;", "Lkotlin/collections/ArrayList;", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$Presenter;", "()V", "mBrand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "mCollectionApi", "Lplayer/wellnesssolutions/com/network/datasource/collection/CollectionApi;", "mData", "mIsLoading", "", "mIsRendered", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$View;", "displayUI", "", "getDisplayItems", "items", "loadApi", "token", "", "deviceId", "loadData", "view", "onAttach", "onChooseItem", "data", "onComplete", "onDestroy", "onDetach", "onExpired", "error", "onExpiredUnauthenticated", "onRequestError", "message", "onReshowUI", "onResponseFalse", "code", "", "onResponseSuccess", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "onShowRequestApiFailed", "onStop", "removeChildCollections", "collections", "setChosenBrand", "brand", "showDisplayItems", "brandName", "displayItems", "app_debug"})
public final class SearchCollectionsPresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection>> implements player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View mView;
    private player.wellnesssolutions.com.network.datasource.collection.CollectionApi mCollectionApi;
    private player.wellnesssolutions.com.network.models.screen_search.MMBrand mBrand;
    private boolean mIsLoading = false;
    private boolean mIsRendered = false;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> mData;
    
    @java.lang.Override()
    public void setChosenBrand(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand brand) {
    }
    
    @java.lang.Override()
    public void onChooseItem(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMCollection data) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View view) {
    }
    
    @java.lang.Override()
    public void loadData(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View view) {
    }
    
    private final void loadApi(java.lang.String token, java.lang.String deviceId) {
    }
    
    @java.lang.Override()
    public void onReshowUI(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View view) {
    }
    
    private final void displayUI() {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection>> data) {
    }
    
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private final void onShowRequestApiFailed(java.lang.String message) {
    }
    
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> removeChildCollections(java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> collections) {
        return null;
    }
    
    private final void showDisplayItems(player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View view, java.lang.String brandName, java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> displayItems) {
    }
    
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> getDisplayItems(java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> items) {
        return null;
    }
    
    @java.lang.Override()
    public void onComplete() {
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
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public SearchCollectionsPresenter() {
        super();
    }
}