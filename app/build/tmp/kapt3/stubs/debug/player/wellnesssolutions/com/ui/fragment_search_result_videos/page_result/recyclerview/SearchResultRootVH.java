package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/SearchResultRootVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mAdapter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageAdapter;", "mListVideo", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "bind", "", "data", "displayView", "app_debug"})
public final class SearchResultRootVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> mListVideo;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter mPresenter;
    private player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageAdapter mAdapter;
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> data, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter mPresenter) {
    }
    
    private final void displayView() {
    }
    
    public SearchResultRootVH(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super(null);
    }
}