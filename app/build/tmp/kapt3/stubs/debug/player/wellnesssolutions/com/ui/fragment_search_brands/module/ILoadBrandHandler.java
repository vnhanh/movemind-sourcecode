package player.wellnesssolutions.com.ui.fragment_search_brands.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler;", "", "loadBrands", "", "tag", "", "release", "Callback", "app_debug"})
public abstract interface ILoadBrandHandler {
    
    public abstract void loadBrands(@org.jetbrains.annotations.NotNull()
    java.lang.String tag);
    
    public abstract void release();
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "onEndLoadingBrands", "", "onGetBrands", "brands", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "Lkotlin/collections/ArrayList;", "searchBrandFlowTag", "", "onGetOnlyOneBrand", "brand", "nextScreenTag", "onLoadBrandsFailed", "message", "onLoadingBrands", "app_debug"})
    public static abstract interface Callback extends player.wellnesssolutions.com.base.view.ILifeCycle.View {
        
        public abstract void onLoadingBrands();
        
        public abstract void onEndLoadingBrands();
        
        public abstract void onGetBrands(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
        java.lang.String searchBrandFlowTag);
        
        public abstract void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
        java.lang.String nextScreenTag);
        
        public abstract void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void onLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback $this) {
            }
            
            public static void onEndLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback $this) {
            }
            
            public static void onGetBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
            java.lang.String searchBrandFlowTag) {
            }
            
            public static void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
            java.lang.String nextScreenTag) {
            }
            
            public static void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
        }
    }
}