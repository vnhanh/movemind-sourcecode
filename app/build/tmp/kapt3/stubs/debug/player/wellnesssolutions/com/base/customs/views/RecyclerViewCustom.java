package player.wellnesssolutions.com.base.customs.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0014J\u0006\u0010\u0019\u001a\u00020\u0013J\u001c\u0010\u001a\u001a\u00020\u00132\u0014\u0010\u001b\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fJ\u001c\u0010\u001c\u001a\u00020\u00132\u0012\u0010\u001b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fH\u0002R\u001c\u0010\u000b\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lplayer/wellnesssolutions/com/base/customs/views/RecyclerViewCustom;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customAdapter", "Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVideosAdapter;", "isCustomed", "", "()Z", "setCustomed", "(Z)V", "applyDimensionForCustomAdapter", "", "onSizeChanged", "w", "h", "oldw", "oldh", "release", "setCustomAdapter", "adapter", "setupForAdapter", "Companion", "app_debug"})
public final class RecyclerViewCustom extends androidx.recyclerview.widget.RecyclerView {
    private boolean isCustomed = true;
    private player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter<?, ?, ?> customAdapter;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public final boolean isCustomed() {
        return false;
    }
    
    public final void setCustomed(boolean p0) {
    }
    
    public final void setCustomAdapter(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter<?, ?, ?> adapter) {
    }
    
    @java.lang.Override()
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    private final void applyDimensionForCustomAdapter() {
    }
    
    private final void setupForAdapter(player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter<?, ?, ?> adapter) {
    }
    
    public final void release() {
    }
    
    public RecyclerViewCustom(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public RecyclerViewCustom(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public RecyclerViewCustom(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/base/customs/views/RecyclerViewCustom$Companion;", "", "()V", "alignCenterHorizontal", "", "rv", "Lplayer/wellnesssolutions/com/base/customs/views/RecyclerViewCustom;", "itemCount", "", "parentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "aboveView", "Landroid/view/View;", "itemSize", "app_debug"})
    public static final class Companion {
        
        public final void alignCenterHorizontal(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.customs.views.RecyclerViewCustom rv, int itemCount, @org.jetbrains.annotations.NotNull()
        androidx.constraintlayout.widget.ConstraintLayout parentView, @org.jetbrains.annotations.NotNull()
        android.view.View aboveView, int itemSize) {
        }
        
        private Companion() {
            super();
        }
    }
}