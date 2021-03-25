package player.wellnesssolutions.com.ui.fragment_search_brands;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISearchBrandsContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH&\u00a8\u0006\u000b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract$View;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "onOpenNextScreen", "", "data", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "nextScreenTag", "", "showUI", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback {
        
        public abstract void showUI(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> data);
        
        public abstract void onOpenNextScreen(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand data, @org.jetbrains.annotations.NotNull()
        java.lang.String nextScreenTag);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onEndLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onGetBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
            java.lang.String searchBrandFlowTag) {
            }
            
            @java.lang.Override()
            public static void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
            java.lang.String nextScreenTag) {
            }
            
            @java.lang.Override()
            public static void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J(\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/ISearchBrandsContract$View;", "changeSearchedFlow", "", "view", "searchedFlowTag", "", "getSearchedFlowTag", "inputData", "nextScreenTag", "brands", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "Lkotlin/collections/ArrayList;", "onChooseItem", "data", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View> {
        
        public abstract void inputData(@org.jetbrains.annotations.NotNull()
        java.lang.String nextScreenTag, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands);
        
        public abstract void changeSearchedFlow(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.View view, @org.jetbrains.annotations.NotNull()
        java.lang.String searchedFlowTag);
        
        public abstract void onChooseItem(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand data);
        
        @org.jetbrains.annotations.NotNull()
        public abstract java.lang.String getSearchedFlowTag();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract.Presenter $this) {
            }
        }
    }
}