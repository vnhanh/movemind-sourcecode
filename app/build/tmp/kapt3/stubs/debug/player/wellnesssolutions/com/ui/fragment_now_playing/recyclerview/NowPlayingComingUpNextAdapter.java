package player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\u0006\u0010 \u001a\u00020\u0019J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/recyclerview/NowPlayingComingUpNextAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/recyclerview/NowPlayingComingUpNextVH;", "list", "", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "isPresentation", "", "(Ljava/util/List;Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;Z)V", "()Z", "getList", "()Ljava/util/List;", "mHolders", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "margin", "", "getPresenter", "()Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "setPresenter", "(Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "release", "setDimenLayoutForItemView", "itemView", "Landroid/view/View;", "app_debug"})
public final class NowPlayingComingUpNextAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextVH> {
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextVH> mHolders;
    private int margin = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<player.wellnesssolutions.com.network.models.now_playing.MMVideo> list = null;
    @org.jetbrains.annotations.Nullable()
    private player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter;
    private final boolean isPresentation = false;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int itemType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.NowPlayingComingUpNextVH holder, int position) {
    }
    
    private final void setDimenLayoutForItemView(android.view.View itemView, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void release() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<player.wellnesssolutions.com.network.models.now_playing.MMVideo> getList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener getPresenter() {
        return null;
    }
    
    public final void setPresenter(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener p0) {
    }
    
    public final boolean isPresentation() {
        return false;
    }
    
    public NowPlayingComingUpNextAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<player.wellnesssolutions.com.network.models.now_playing.MMVideo> list, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter, boolean isPresentation) {
        super();
    }
}