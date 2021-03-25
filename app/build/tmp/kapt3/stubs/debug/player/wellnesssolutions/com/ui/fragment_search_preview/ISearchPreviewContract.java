package player.wellnesssolutions.com.ui.fragment_search_preview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISearchPreviewContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "onRequestFailed", "", "message", "", "openSearchResultScreen", "selectedOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "showUI", "showUIData", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/SPShowedUIData;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IShowMessageView, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void showUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData showUIData);
        
        public abstract void openSearchResultScreen(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption selectedOptions);
        
        public abstract void onRequestFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View $this, @androidx.annotation.StringRes()
            int messageRes, @androidx.annotation.ColorRes()
            int color) {
            }
            
            @java.lang.Override()
            public static void showMessage(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View $this, @org.jetbrains.annotations.NotNull()
            java.lang.String message, @androidx.annotation.ColorRes()
            int color) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J!\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&J+\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nH&J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH&\u00a8\u0006\u001d"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$View;", "addAdapter", "", "adapter", "Lplayer/wellnesssolutions/com/base/view/BaseClickableAdapter;", "getData", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SearchedOption;", "isHaveCollectionsAndInstructors", "", "isItemSelected", "id", "", "typeId", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "loadData", "view", "onChooseOptionItem", "name", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "onReshowUI", "requestResultVideos", "isUseOptions", "setPassedData", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "searchByData", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View> {
        
        public abstract void setPassedData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption searchByData);
        
        public abstract void onChooseOptionItem(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, @org.jetbrains.annotations.Nullable()
        java.lang.Integer typeId);
        
        public abstract void requestResultVideos(boolean isUseOptions);
        
        public abstract boolean isHaveCollectionsAndInstructors();
        
        public abstract void onReshowUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View view);
        
        public abstract void addAdapter(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.view.BaseClickableAdapter<?, ?, ?> adapter);
        
        public abstract boolean isItemSelected(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.Integer typeId);
        
        public abstract void loadData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View view);
        
        @org.jetbrains.annotations.NotNull()
        public abstract player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption getData();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.Presenter $this) {
            }
        }
    }
}