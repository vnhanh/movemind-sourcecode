package player.wellnesssolutions.com.base.utils.search_util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0002J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0004J(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002Jj\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020 \u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020 \u0018\u0001`\u001e2\u0006\u0010!\u001a\u00020\u00042\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001eJ \u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/search_util/SearchCollectionUtil;", "", "()V", "MARGIN", "", "isCollectionChoose", "", "()Z", "setCollectionChoose", "(Z)V", "isSkipAndSearchChoose", "setSkipAndSearchChoose", "mTvCollectionHeight", "addExtraSmallView", "Landroid/widget/TextView;", "parentView", "Landroid/widget/LinearLayout;", "leftView", "Landroid/view/View;", "name", "", "colorStr", "leftMargin", "Landroidx/constraintlayout/widget/ConstraintLayout;", "prevView", "applyConstraintSet", "", "appliedView", "displayCollections", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "collections", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "collectionCountMax", "extraCollectionTextViews", "displayText", "tv", "app_debug"})
public final class SearchCollectionUtil {
    private static int mTvCollectionHeight = 0;
    private static int MARGIN = 0;
    private static boolean isCollectionChoose = false;
    private static boolean isSkipAndSearchChoose = false;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.utils.search_util.SearchCollectionUtil INSTANCE = null;
    
    public final boolean isCollectionChoose() {
        return false;
    }
    
    public final void setCollectionChoose(boolean p0) {
    }
    
    public final boolean isSkipAndSearchChoose() {
        return false;
    }
    
    public final void setSkipAndSearchChoose(boolean p0) {
    }
    
    public final void displayText(@org.jetbrains.annotations.NotNull()
    android.widget.TextView tv, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String colorStr) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView addExtraSmallView(@org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout parentView, @org.jetbrains.annotations.NotNull()
    android.view.View prevView, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String colorStr, int leftMargin) {
        return null;
    }
    
    private final void applyConstraintSet(androidx.constraintlayout.widget.ConstraintLayout parentView, android.view.View prevView, android.widget.TextView appliedView, int leftMargin) {
    }
    
    /**
     * -----------------------
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<android.widget.TextView> displayCollections(@org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout parentView, @org.jetbrains.annotations.NotNull()
    android.view.View leftView, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> collections, int collectionCountMax, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.widget.TextView> extraCollectionTextViews) {
        return null;
    }
    
    private final android.widget.TextView addExtraSmallView(android.widget.LinearLayout parentView, android.view.View leftView, java.lang.String name, java.lang.String colorStr, int leftMargin) {
        return null;
    }
    
    private SearchCollectionUtil() {
        super();
    }
}