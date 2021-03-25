package player.wellnesssolutions.com.base.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0004*\u00020\u0005*\b\b\u0002\u0010\u0003*\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00020\tj\b\u0012\u0004\u0012\u00028\u0002`\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0016J\u001d\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00020 H\u0016\u00a2\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\"H\u0016R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00020\tj\b\u0012\u0004\u0012\u00028\u0002`\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0014\u001a\u0004\u0018\u00018\u00012\b\u0010\u0013\u001a\u0004\u0018\u00018\u00018D@DX\u0084\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u001aX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\'"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/BaseClickableAdapter;", "VH", "Lplayer/wellnesssolutions/com/base/view/BaseVH;", "M", "T", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "listener", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "mHolders", "getMHolders", "setMHolders", "value", "presenter", "getPresenter", "()Ljava/lang/Object;", "setPresenter", "(Ljava/lang/Object;)V", "weakPresenter", "Ljava/lang/ref/WeakReference;", "getWeakPresenter", "()Ljava/lang/ref/WeakReference;", "setWeakPresenter", "(Ljava/lang/ref/WeakReference;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "(Lplayer/wellnesssolutions/com/base/view/BaseVH;I)V", "release", "app_debug"})
public abstract class BaseClickableAdapter<VH extends player.wellnesssolutions.com.base.view.BaseVH<M>, T extends java.lang.Object, M extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.ref.WeakReference<T> weakPresenter;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<VH> mHolders;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<M> list;
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.ref.WeakReference<T> getWeakPresenter() {
        return null;
    }
    
    protected final void setWeakPresenter(@org.jetbrains.annotations.NotNull()
    java.lang.ref.WeakReference<T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.util.ArrayList<VH> getMHolders() {
        return null;
    }
    
    protected final void setMHolders(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<VH> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final T getPresenter() {
        return null;
    }
    
    protected final void setPresenter(@org.jetbrains.annotations.Nullable()
    T value) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    VH holder, int position) {
    }
    
    public void release() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<M> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<M> p0) {
    }
    
    public BaseClickableAdapter(@org.jetbrains.annotations.Nullable()
    T listener, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<M> list) {
        super();
    }
}