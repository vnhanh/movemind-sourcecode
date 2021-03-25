package player.wellnesssolutions.com.ui.fragment_time_table.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0006\u0010\u0015\u001a\u00020\u000eJ\u001e\u0010\u0016\u001a\u00020\u000e2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\u0018R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerItemVH;", "listener", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerAdapter$OnClickItemListener;", "(Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerAdapter$OnClickItemListener;)V", "list", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "weakListener", "Ljava/lang/ref/WeakReference;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "release", "setList", "_list", "Lkotlin/collections/ArrayList;", "OnClickItemListener", "app_debug"})
public final class SchedulerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerItemVH> {
    private java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> list;
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerAdapter.OnClickItemListener> weakListener;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerItemVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerItemVH holder, int position) {
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> _list) {
    }
    
    public final void release() {
    }
    
    public SchedulerAdapter(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerAdapter.OnClickItemListener listener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerAdapter$OnClickItemListener;", "", "onClick", "", "item", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "app_debug"})
    public static abstract interface OnClickItemListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.response.SessionVideo item);
    }
}