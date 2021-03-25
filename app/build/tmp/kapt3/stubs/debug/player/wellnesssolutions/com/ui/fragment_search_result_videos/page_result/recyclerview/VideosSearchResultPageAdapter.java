package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\'\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0006\u0010\u001c\u001a\u00020\u0016J\u0006\u0010\u001d\u001a\u00020\u0016J\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageVH;", "list", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "Lkotlin/collections/ArrayList;", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "(Ljava/util/ArrayList;Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;)V", "getList", "()Ljava/util/ArrayList;", "mHolders", "mItemHeight", "", "mItemWidth", "weakPresenter", "Ljava/lang/ref/WeakReference;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "vh", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "release", "selectAllVideos", "setItemDimens", "width", "height", "setupLayoutForVHItem", "view", "Landroid/view/View;", "unselectAllVideos", "Companion", "app_debug"})
public final class VideosSearchResultPageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageVH> {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter> weakPresenter;
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageVH> mHolders;
    private int mItemWidth = 0;
    private int mItemHeight = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> list = null;
    private static final int ROW_COUNT = 3;
    private static final int COL_COUNT = 4;
    private static final int TYPE_ITEM_LEFT_EDGE = 0;
    private static final int TYPE_ITEM_MIDDLE = 1;
    private static final int TYPE_ITEM_RIGHT_EDGE = 2;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageAdapter.Companion Companion = null;
    
    public final void setItemDimens(int width, int height) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int itemType) {
        return null;
    }
    
    private final void setupLayoutForVHItem(android.view.View view) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageVH vh, int position) {
    }
    
    public final void release() {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void selectAllVideos() {
    }
    
    public final void unselectAllVideos() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getList() {
        return null;
    }
    
    public VideosSearchResultPageAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> list, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageAdapter$Companion;", "", "()V", "COL_COUNT", "", "getCOL_COUNT", "()I", "ROW_COUNT", "getROW_COUNT", "TYPE_ITEM_LEFT_EDGE", "getTYPE_ITEM_LEFT_EDGE", "TYPE_ITEM_MIDDLE", "getTYPE_ITEM_MIDDLE", "TYPE_ITEM_RIGHT_EDGE", "getTYPE_ITEM_RIGHT_EDGE", "app_debug"})
    public static final class Companion {
        
        public final int getROW_COUNT() {
            return 0;
        }
        
        public final int getCOL_COUNT() {
            return 0;
        }
        
        public final int getTYPE_ITEM_LEFT_EDGE() {
            return 0;
        }
        
        public final int getTYPE_ITEM_MIDDLE() {
            return 0;
        }
        
        public final int getTYPE_ITEM_RIGHT_EDGE() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}