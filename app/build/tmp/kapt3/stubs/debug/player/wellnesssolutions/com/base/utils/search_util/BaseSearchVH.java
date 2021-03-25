package player.wellnesssolutions.com.base.utils.search_util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\'B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0014J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0004J(\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0004J\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002J\u0006\u0010&\u001a\u00020\u001aR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006("}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVH;", "M", "", "Lplayer/wellnesssolutions/com/base/view/BaseVH;", "itemView", "Landroid/view/View;", "itemWidth", "", "itemHeight", "itemCountInRow", "(Landroid/view/View;III)V", "getItemCountInRow", "()I", "setItemCountInRow", "(I)V", "getItemHeight", "setItemHeight", "getItemWidth", "setItemWidth", "parentWidth", "getParentWidth", "setParentWidth", "rowSpan", "getRowSpan", "setRowSpan", "applyDimensions", "", "force", "", "setDimensions", "setupDimensAndSetBgDrawableForCircleView", "Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVH$PrivateDimens;", "view", "setupDimensForCircleItem", "width", "height", "padding", "setupDimensForItem", "setupLayout", "PrivateDimens", "app_debug"})
public abstract class BaseSearchVH<M extends java.lang.Object> extends player.wellnesssolutions.com.base.view.BaseVH<M> {
    private int rowSpan = 1;
    private int parentWidth = -1;
    private int itemWidth;
    private int itemHeight;
    private int itemCountInRow;
    
    protected final int getRowSpan() {
        return 0;
    }
    
    protected final void setRowSpan(int p0) {
    }
    
    protected final int getParentWidth() {
        return 0;
    }
    
    protected final void setParentWidth(int p0) {
    }
    
    public final void setupLayout() {
    }
    
    public final void setDimensions(int itemWidth, int itemHeight) {
    }
    
    protected void applyDimensions(int itemWidth, int itemHeight, boolean force) {
    }
    
    private final void setupDimensForItem(int width, int height) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH.PrivateDimens setupDimensAndSetBgDrawableForCircleView(@org.jetbrains.annotations.NotNull()
    android.view.View view, int itemCountInRow) {
        return null;
    }
    
    protected final void setupDimensForCircleItem(@org.jetbrains.annotations.NotNull()
    android.view.View view, int width, int height, int padding) {
    }
    
    public final int getItemWidth() {
        return 0;
    }
    
    public final void setItemWidth(int p0) {
    }
    
    public final int getItemHeight() {
        return 0;
    }
    
    public final void setItemHeight(int p0) {
    }
    
    public final int getItemCountInRow() {
        return 0;
    }
    
    public final void setItemCountInRow(int p0) {
    }
    
    public BaseSearchVH(@org.jetbrains.annotations.NotNull()
    android.view.View itemView, int itemWidth, int itemHeight, int itemCountInRow) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/search_util/BaseSearchVH$PrivateDimens;", "", "size", "", "padding", "(II)V", "getPadding", "()I", "getSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
    public static final class PrivateDimens {
        private final int size = 0;
        private final int padding = 0;
        
        public final int getSize() {
            return 0;
        }
        
        public final int getPadding() {
            return 0;
        }
        
        public PrivateDimens(int size, int padding) {
            super();
        }
        
        public final int component1() {
            return 0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH.PrivateDimens copy(int size, int padding) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}