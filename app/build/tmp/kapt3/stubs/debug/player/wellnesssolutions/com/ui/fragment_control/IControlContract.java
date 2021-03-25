package player.wellnesssolutions.com.ui.fragment_control;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract;", "", "Presenter", "View", "app_debug"})
public abstract interface IControlContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH&\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$View;", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler$Callback;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "hideGroupComingUpNext", "", "setupViewFloatMenu", "configData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "showPresentationPlayList", "nowPlayVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "comingUpVideos", "Ljava/util/ArrayList;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler.Callback, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void setupViewFloatMenu(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.config.MMConfigData configData);
        
        public abstract void hideGroupComingUpNext();
        
        public abstract void showPresentationPlayList(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.now_playing.MMVideo nowPlayVideo, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> comingUpVideos);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onEndLoadingBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this) {
            }
            
            @java.lang.Override()
            public static void onGetBrands(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this, @org.jetbrains.annotations.NotNull()
            java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMBrand> brands, @org.jetbrains.annotations.NotNull()
            java.lang.String searchBrandFlowTag) {
            }
            
            @java.lang.Override()
            public static void onGetOnlyOneBrand(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this, @org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
            java.lang.String nextScreenTag) {
            }
            
            @java.lang.Override()
            public static void onLoadBrandsFailed(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$View;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "loadBrands", "", "tag", "", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_control.IControlContract.View>, player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener {
        
        public abstract void loadBrands(@org.jetbrains.annotations.NotNull()
        java.lang.String tag);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_control.IControlContract.Presenter $this) {
            }
        }
    }
}