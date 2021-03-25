package player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eJ,\u0010\u0017\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u001eH\u0002J\u001a\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\u0006\u0010*\u001a\u00020\u0014R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/recyclerview/NowPlayingComingUpNextVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;", "isPresentation", "", "(Landroid/view/View;Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/IComingUpNextClickListener;Z)V", "mExtraCollectionViews", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "mPosition", "", "mVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "mWeakPresenter", "Ljava/lang/ref/WeakReference;", "bind", "", "video", "position", "displayCollections", "collections", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "icTypeLogo", "Landroid/widget/ImageView;", "displayDurationVideo", "durationValue", "", "tvTimeDuration", "displayTimeStart", "playTime", "displayTitleVideo", "videoName", "tvTitleVideo", "displayTypeLogo", "typeLogo", "iconView", "loadThumbnail", "onClickedItemView", "release", "app_debug"})
public final class NowPlayingComingUpNextVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener> mWeakPresenter;
    private java.util.ArrayList<android.widget.TextView> mExtraCollectionViews;
    private int mPosition = 0;
    private player.wellnesssolutions.com.network.models.now_playing.MMVideo mVideo;
    
    private final void onClickedItemView() {
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo video, int position) {
    }
    
    private final void loadThumbnail(player.wellnesssolutions.com.network.models.now_playing.MMVideo video) {
    }
    
    private final void displayTimeStart(java.lang.String playTime) {
    }
    
    private final void displayDurationVideo(java.lang.String durationValue, android.widget.TextView tvTimeDuration) {
    }
    
    private final void displayTitleVideo(java.lang.String videoName, android.widget.TextView tvTitleVideo) {
    }
    
    private final void displayTypeLogo(java.lang.String typeLogo, android.widget.ImageView iconView) {
    }
    
    private final void displayCollections(java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> collections, android.widget.ImageView icTypeLogo) {
    }
    
    public final void release() {
    }
    
    public NowPlayingComingUpNextVH(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener presenter, boolean isPresentation) {
        super(null);
    }
}