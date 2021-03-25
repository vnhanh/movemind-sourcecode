package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\'\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/collections/SPCollectionAdapter;", "Lplayer/wellnesssolutions/com/base/view/BaseClickableAdapter;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/collections/SPCollectionVH;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$Presenter;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMCollection;", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "presenter", "(Ljava/util/ArrayList;Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$Presenter;)V", "nameTextSize", "", "padding", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onClickedItem", "vh", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "setPadding", "setTextSize", "view", "Landroid/view/View;", "app_debug"})
public final class SPCollectionAdapter extends player.wellnesssolutions.com.base.view.BaseClickableAdapter<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionVH, player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.Presenter, player.wellnesssolutions.com.network.models.screen_search.MMCollection> {
    private float nameTextSize = 0.0F;
    private int padding = 0;
    
    public final void setTextSize(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.Presenter presenter) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int itemType) {
        return null;
    }
    
    private final void onClickedItem(player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionVH vh) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionVH holder, int position) {
    }
    
    private final void setPadding(player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionVH vh, int position, int padding) {
    }
    
    public SPCollectionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> list, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.Presenter presenter) {
        super(null, null);
    }
}