package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

/**
 * GCU: Group Coming Up next
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J^\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\b2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010&2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002JD\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010&2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u00100\u001a\u000201J2\u00102\u001a\u00020\u000b2\f\u00103\u001a\b\u0012\u0004\u0012\u00020.042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u00100\u001a\u000201R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/GCUDisplayHelper;", "", "()V", "mThumbnailCorner", "", "mThumbnailHeight", "mThumbnailWidth", "convertDateStrToAMPMFormat", "", "time", "displayDuration", "", "duration", "tvVideoDuration", "Landroid/widget/TextView;", "displayTimeStart", "playTime", "tv", "Lplayer/wellnesssolutions/com/common/customize_views/MMTextView;", "displayVideoTitle", "videoName", "tvTitleVideo", "hideGCUAfterTapped", "groupViewsComingUpNext", "Landroid/view/View;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "initThumbnailValues", "resources", "Landroid/content/res/Resources;", "loadThumbnail", "thunmailUrl", "thumbnailVideo", "Landroid/widget/ImageView;", "releaseAdapters", "recyclerview", "Landroidx/recyclerview/widget/RecyclerView;", "showPlayingVideoInfo", "Ljava/util/ArrayList;", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "thumbnalUrl", "collections", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "extraCollectionViews", "videoData", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "extraCollectionView", "isPresentation", "", "showVideosComingUpNext", "videos", "", "app_debug"})
public final class GCUDisplayHelper {
    private static int mThumbnailCorner = 0;
    private static int mThumbnailWidth = 0;
    private static int mThumbnailHeight = 0;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.helper.GCUDisplayHelper INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<android.widget.TextView> showPlayingVideoInfo(@org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout rootView, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo videoData, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.widget.TextView> extraCollectionView, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter, boolean isPresentation) {
        return null;
    }
    
    private final void displayTimeStart(java.lang.String playTime, player.wellnesssolutions.com.common.customize_views.MMTextView tv) {
    }
    
    private final java.util.ArrayList<android.widget.TextView> showPlayingVideoInfo(androidx.constraintlayout.widget.ConstraintLayout rootView, java.lang.String videoName, java.lang.String thumbnalUrl, java.lang.String duration, java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> collections, java.util.ArrayList<android.widget.TextView> extraCollectionViews, player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter) {
        return null;
    }
    
    private final void hideGCUAfterTapped(android.view.View groupViewsComingUpNext, player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter) {
    }
    
    private final void displayVideoTitle(java.lang.String videoName, android.widget.TextView tvTitleVideo) {
    }
    
    private final void displayDuration(java.lang.String duration, android.widget.TextView tvVideoDuration) {
    }
    
    private final void loadThumbnail(java.lang.String thunmailUrl, android.widget.ImageView thumbnailVideo) {
    }
    
    private final void initThumbnailValues(android.content.res.Resources resources) {
    }
    
    public final void showVideosComingUpNext(@org.jetbrains.annotations.NotNull()
    java.util.List<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos, @org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView recyclerview, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter, boolean isPresentation) {
    }
    
    private final void releaseAdapters(androidx.recyclerview.widget.RecyclerView recyclerview) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertDateStrToAMPMFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String time) {
        return null;
    }
    
    private GCUDisplayHelper() {
        super();
    }
}