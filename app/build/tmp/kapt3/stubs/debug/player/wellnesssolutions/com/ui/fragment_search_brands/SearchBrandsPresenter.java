package player.wellnesssolutions.com.ui.fragment_search_brands;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J(\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\r2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J \u0010!\u001a\u00020\u00112\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/SearchBrandsPresenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract$Presenter;", "()V", "mBrands", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "Lkotlin/collections/ArrayList;", "mBrandsHasLevel", "mIsRendered", "", "mLoadBrandsHandler", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler;", "mSearchedFlowTag", "", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract$View;", "changeSearchedFlow", "", "view", "searchedFlowTag", "displayAllBrands", "displayUI", "getSearchedFlowTag", "hideLevelBrandItem", "inputData", "nextScreenTag", "brands", "onAttach", "onChooseItem", "data", "onDestroy", "onDetach", "onStop", "scanBrandHasNoLevel", "loadedData", "app_debug"})
public final class SearchBrandsPresenter implements player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View mView;
    private player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler mLoadBrandsHandler;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> mBrands;
    private java.lang.String mSearchedFlowTag;
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> mBrandsHasLevel;
    private boolean mIsRendered = false;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getSearchedFlowTag() {
        return null;
    }
    
    @java.lang.Override()
    public void inputData(@org.jetbrains.annotations.NotNull()
    java.lang.String nextScreenTag, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands) {
    }
    
    @java.lang.Override()
    public void changeSearchedFlow(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View view, @org.jetbrains.annotations.NotNull()
    java.lang.String searchedFlowTag) {
    }
    
    private final void displayUI() {
    }
    
    private final void displayAllBrands() {
    }
    
    private final void hideLevelBrandItem() {
    }
    
    @java.lang.Override()
    public void onChooseItem(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand data) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View view) {
    }
    
    private final void scanBrandHasNoLevel(java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> loadedData) {
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
    
    public SearchBrandsPresenter() {
        super();
    }
}