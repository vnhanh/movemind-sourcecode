package player.wellnesssolutions.com.ui.fragment_no_class;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_no_class/INoClassContract;", "", "Presenter", "View", "app_debug"})
public abstract interface INoClassContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_no_class/INoClassContract$View;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "showUI", "", "data", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback, player.wellnesssolutions.com.base.view.IProgressView, player.wellnesssolutions.com.base.view.IShowMessageView {
        
        public abstract void showUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.config.MMConfigData data);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onEndLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onGetBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
            java.lang.String searchBrandFlowTag) {
            }
            
            @java.lang.Override()
            public static void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
            java.lang.String nextScreenTag) {
            }
            
            @java.lang.Override()
            public static void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_no_class/INoClassContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_no_class/INoClassContract$View;", "loadBrands", "", "flowTag", "", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.View> {
        
        public abstract void loadBrands(@org.jetbrains.annotations.NotNull()
        java.lang.String flowTag);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_no_class.INoClassContract.Presenter $this) {
            }
        }
    }
}