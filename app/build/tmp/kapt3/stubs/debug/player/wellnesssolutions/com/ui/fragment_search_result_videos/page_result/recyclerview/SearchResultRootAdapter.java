package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/SearchResultRootAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/SearchResultRootVH;", "list", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/search_result/MMSearchResultRootPage;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "mParentPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/ISearchResultContract$Presenter;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setParentPrenter", "app_debug"})
public final class SearchResultRootAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.SearchResultRootVH> {
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter mParentPresenter;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter mPresenter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage> list = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.SearchResultRootVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.SearchResultRootVH holder, int position) {
    }
    
    public final void setParentPrenter(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract.Presenter mParentPresenter) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage> getList() {
        return null;
    }
    
    public SearchResultRootAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMSearchResultRootPage> list) {
        super();
    }
}