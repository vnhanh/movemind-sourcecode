package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tJ\u0018\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016Jt\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\t2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tJ\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingVideoInfoDisplayHelper;", "", "()V", "mTypeLogoHeight", "", "mTypeLogoWidth", "displayPlayingVideo", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "parentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "groupMainControllers", "Landroid/widget/LinearLayout;", "videoData", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "extraCollectionViews", "displayTypeLogoBrand", "", "typeLogo", "", "iconView", "Landroid/widget/ImageView;", "displayVideoInfo", "videoName", "brandTypeLogo", "collections", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "collectionViews", "initTypeLogoDimens", "setupVideo", "Landroid/view/View;", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "app_debug"})
public final class NowPlayingVideoInfoDisplayHelper {
    private static int mTypeLogoWidth = 0;
    private static int mTypeLogoHeight = 0;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVideoInfoDisplayHelper INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<android.widget.TextView> displayPlayingVideo(@org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout parentView, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout groupMainControllers, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.widget.TextView> extraCollectionViews) {
        return null;
    }
    
    public final void setupVideo(@org.jetbrains.annotations.NotNull()
    android.view.View parentView, @org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.SimpleExoPlayer player) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<android.widget.TextView> displayVideoInfo(@org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout parentView, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout groupMainControllers, @org.jetbrains.annotations.NotNull()
    java.lang.String videoName, @org.jetbrains.annotations.Nullable()
    java.lang.String brandTypeLogo, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> collections, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.widget.TextView> collectionViews) {
        return null;
    }
    
    public final void displayTypeLogoBrand(@org.jetbrains.annotations.Nullable()
    java.lang.String typeLogo, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView iconView) {
    }
    
    private final void initTypeLogoDimens(android.widget.ImageView iconView) {
    }
    
    private NowPlayingVideoInfoDisplayHelper() {
        super();
    }
}