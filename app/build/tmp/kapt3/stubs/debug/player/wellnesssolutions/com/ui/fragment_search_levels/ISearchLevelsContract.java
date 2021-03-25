package player.wellnesssolutions.com.ui.fragment_search_levels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_levels/ISearchLevelsContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISearchLevelsContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00052\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u00102\u0006\u0010\u0011\u001a\u00020\fH&\u00a8\u0006\u0012"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_levels/ISearchLevelsContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "onOpenNextScreen", "", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "level", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMLevel;", "onRequestFailed", "message", "", "showLoadedData", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "brandName", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void onOpenNextScreen(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMLevel level);
        
        public abstract void showLoadedData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMLevel> data, @org.jetbrains.annotations.NotNull()
        java.lang.String brandName);
        
        public abstract void onRequestFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_levels/ISearchLevelsContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_levels/ISearchLevelsContract$View;", "loadData", "", "view", "onChooseItem", "data", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMLevel;", "onReshowUI", "setChosenBrand", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.View> {
        
        public abstract void setChosenBrand(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand);
        
        public abstract void onChooseItem(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMLevel data);
        
        public abstract void onReshowUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.View view);
        
        public abstract void loadData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.View view);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract.Presenter $this) {
            }
        }
    }
}