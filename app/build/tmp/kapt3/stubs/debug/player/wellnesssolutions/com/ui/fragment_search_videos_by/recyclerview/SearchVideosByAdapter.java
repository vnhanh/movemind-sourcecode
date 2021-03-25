package player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0006\u0010\u001d\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/recyclerview/SearchVideosByAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/recyclerview/SearchVideosByVH;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract$Presenter;", "list", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/screen_search/SearchByOption;", "Lkotlin/collections/ArrayList;", "(Lplayer/wellnesssolutions/com/ui/fragment_search_videos_by/ISearchVideosByContract$Presenter;Ljava/util/ArrayList;)V", "TYPE_IMAGE", "", "TYPE_TEXT", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "weakPresenter", "Ljava/lang/ref/WeakReference;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "release", "app_debug"})
public final class SearchVideosByAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview.SearchVideosByVH> {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract.Presenter> weakPresenter;
    private final int TYPE_IMAGE = 10;
    private final int TYPE_TEXT = 11;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.SearchByOption> list;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview.SearchVideosByVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview.SearchVideosByVH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void release() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.SearchByOption> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.SearchByOption> p0) {
    }
    
    public SearchVideosByAdapter(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_videos_by.ISearchVideosByContract.Presenter presenter, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.SearchByOption> list) {
        super();
    }
}