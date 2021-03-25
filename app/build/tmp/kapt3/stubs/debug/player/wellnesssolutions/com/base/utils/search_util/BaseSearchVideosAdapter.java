package player.wellnesssolutions.com.base.utils.search_util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u0002*\b\b\u0001\u0010\u0004*\u00020\u0005*\b\b\u0002\u0010\u0003*\u00020\u00052\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u0006B\'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00028\u00020\tj\b\u0012\u0004\u0012\u00028\u0002`\n\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020\"2\u0006\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\"R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011\u00a8\u0006*"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVideosAdapter;", "VH", "Lplayer/wellnesssolutions/com/base/view/BaseVH;", "M", "T", "", "Lplayer/wellnesssolutions/com/base/view/BaseClickableAdapter;", "listener", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "colSpan", "", "getColSpan", "()I", "setColSpan", "(I)V", "itemHeight", "getItemHeight", "setItemHeight", "itemWidth", "getItemWidth", "setItemWidth", "maxItemCountInRow", "getMaxItemCountInRow", "setMaxItemCountInRow", "maxRowCount", "getMaxRowCount", "setMaxRowCount", "rowSpan", "getRowSpan", "setRowSpan", "setDimensions", "", "setupDimensForViewHolder", "view", "Landroid/view/View;", "setupLayoutForItemView", "itemView", "circleView", "updateDimensionsForVHs", "app_debug"})
public abstract class BaseSearchVideosAdapter<VH extends player.wellnesssolutions.com.base.view.BaseVH<M>, T extends java.lang.Object, M extends java.lang.Object> extends player.wellnesssolutions.com.base.view.BaseClickableAdapter<VH, T, M> {
    private int itemHeight = 0;
    private int itemWidth = 0;
    private int rowSpan = 1;
    private int colSpan = 1;
    private int maxItemCountInRow = 1;
    private int maxRowCount = 1;
    
    public final int getItemHeight() {
        return 0;
    }
    
    public final void setItemHeight(int p0) {
    }
    
    public final int getItemWidth() {
        return 0;
    }
    
    public final void setItemWidth(int p0) {
    }
    
    public final int getRowSpan() {
        return 0;
    }
    
    public final void setRowSpan(int p0) {
    }
    
    public final int getColSpan() {
        return 0;
    }
    
    public final void setColSpan(int p0) {
    }
    
    public final int getMaxItemCountInRow() {
        return 0;
    }
    
    public final void setMaxItemCountInRow(int p0) {
    }
    
    public final int getMaxRowCount() {
        return 0;
    }
    
    public final void setMaxRowCount(int p0) {
    }
    
    public final void setDimensions(int itemWidth, int itemHeight) {
    }
    
    public final void updateDimensionsForVHs() {
    }
    
    public final void setupDimensForViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void setupLayoutForItemView(@org.jetbrains.annotations.NotNull()
    android.view.View itemView, @org.jetbrains.annotations.NotNull()
    android.view.View circleView) {
    }
    
    public BaseSearchVideosAdapter(@org.jetbrains.annotations.Nullable()
    T listener, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<M> list) {
        super(null, null);
    }
}