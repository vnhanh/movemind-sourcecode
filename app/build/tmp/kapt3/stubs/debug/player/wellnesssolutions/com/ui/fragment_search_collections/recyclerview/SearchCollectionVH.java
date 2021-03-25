package player.wellnesssolutions.com.ui.fragment_search_collections.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_collections/recyclerview/SearchCollectionVH;", "Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVH;", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMCollection;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$Presenter;", "itemWidth", "", "itemHeight", "itemCountInRow", "(Landroid/view/View;Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$Presenter;III)V", "mLoadSize", "weakPresenter", "Ljava/lang/ref/WeakReference;", "bind", "", "data", "loadImage", "onClick", "release", "app_debug"})
public final class SearchCollectionVH extends player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH<player.wellnesssolutions.com.network.models.screen_search.MMCollection> implements android.view.View.OnClickListener {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.Presenter> weakPresenter;
    private int mLoadSize = 0;
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void bind(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMCollection data) {
    }
    
    private final void loadImage(player.wellnesssolutions.com.network.models.screen_search.MMCollection data) {
    }
    
    @java.lang.Override()
    public void release() {
    }
    
    public SearchCollectionVH(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.Presenter listener, int itemWidth, int itemHeight, int itemCountInRow) {
        super(null, 0, 0, 0);
    }
}