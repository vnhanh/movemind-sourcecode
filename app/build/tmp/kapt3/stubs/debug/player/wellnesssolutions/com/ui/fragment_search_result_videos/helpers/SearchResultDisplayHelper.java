package player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J.\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fJ0\u0010\f\u001a\u00020\u00122\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\nJ>\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00110\rj\b\u0012\u0004\u0012\u00020\u0011`\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/helpers/SearchResultDisplayHelper;", "", "()V", "VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE", "", "getVIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE", "()I", "getChosenText", "", "data", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "typeId", "processShowData", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/search_result/MMSearchResultRootPage;", "Lkotlin/collections/ArrayList;", "showData", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "", "pageAdapter", "Lplayer/wellnesssolutions/com/base/customs/CustomPageAdapter;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "showChosenOptionText", "tv", "Landroid/widget/TextView;", "chosenOptions", "splitItemsByPage", "startIndex", "itemCountInOnePage", "app_debug"})
public final class SearchResultDisplayHelper {
    private static final int VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE = 11;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers.SearchResultDisplayHelper INSTANCE = null;
    
    public final int getVIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE() {
        return 0;
    }
    
    public final void showChosenOptionText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView tv, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption chosenOptions) {
    }
    
    private final java.lang.String getChosenText(player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption data, int typeId) {
        return null;
    }
    
    public final void processShowData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> showData, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.customs.CustomPageAdapter pageAdapter, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter presenter) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage> processShowData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> showData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> splitItemsByPage(int startIndex, int itemCountInOnePage, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data) {
        return null;
    }
    
    private SearchResultDisplayHelper() {
        super();
    }
}