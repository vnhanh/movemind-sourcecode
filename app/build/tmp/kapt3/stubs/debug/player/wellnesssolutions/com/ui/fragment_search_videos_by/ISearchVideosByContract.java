package player.wellnesssolutions.com.ui.fragment_search_videos_by;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISearchVideosByContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bH&\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "onOpenNextScreen", "", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "searchByOption", "Lplayer/wellnesssolutions/com/network/models/screen_search/SearchByOption;", "showUI", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View {
        
        public abstract void onOpenNextScreen(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.SearchByOption searchByOption);
        
        public abstract void showUI(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.SearchByOption> data);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract$View;", "onChooseItem", "", "data", "Lplayer/wellnesssolutions/com/network/models/screen_search/SearchByOption;", "onReshowUI", "view", "setChosenBrand", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract.View> {
        
        public abstract void setChosenBrand(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand);
        
        public abstract void onChooseItem(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.SearchByOption data);
        
        public abstract void onReshowUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract.View view);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract.Presenter $this) {
            }
        }
    }
}