package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00015B\'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\u001a\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010\'\u001a\u00020\u001bH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u001bH\u0016J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J,\u00100\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u00010\rj\n\u0012\u0004\u0012\u000202\u0018\u0001`\u000fH\u0002J\u0006\u00103\u001a\u00020\u001bJ\b\u00104\u001a\u00020\u001bH\u0016R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/ISearchResultItemListener;", "view", "Landroid/view/View;", "mItemWidth", "", "mItemHeight", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;", "(Landroid/view/View;IILplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/ISearchResultPageContract$Presenter;)V", "mExtraViews", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "mIsSelected", "", "getMItemHeight", "()I", "getMItemWidth", "mVideo", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideo;", "mView", "mWeakPresenter", "Ljava/lang/ref/WeakReference;", "bind", "", "data", "checkToggleItemSelected", "displayContent", "download", "getVideo", "isDownloaded", "loadBrandTypeLogo", "icTypeLogo", "Landroid/widget/ImageView;", "brandTypeLogo", "", "loadDownloadIcon", "loadPreviewIcon", "onClick", "release", "resizeWidthHeightItem", "itemView", "selectVideo", "setupThumbnailSelectedView", "setupTitleVideo", "showCollections", "collections", "Lplayer/wellnesssolutions/com/network/models/search_result/MMTinyCategory;", "toggleSelectVideo", "unselectVideo", "Companion", "app_debug"})
public final class VideosSearchResultPageVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener, player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.ISearchResultItemListener {
    private java.lang.ref.WeakReference<player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter> mWeakPresenter;
    private player.wellnesssolutions.com.network.models.now_playing.MMVideo mVideo;
    private java.util.ArrayList<android.widget.TextView> mExtraViews;
    private boolean mIsSelected = false;
    private final android.view.View mView = null;
    private final int mItemWidth = 0;
    private final int mItemHeight = 0;
    private static int mTypeLogoWidth = 0;
    private static int mTypeLogoHeight = 0;
    private static int mDownloadButtonSize = 0;
    private static int mThumbnailWidth = 0;
    private static int mThumbnailHeight = 0;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageVH.Companion Companion = null;
    
    private final void setupTitleVideo() {
    }
    
    private final void setupThumbnailSelectedView() {
    }
    
    public final void release() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final void loadDownloadIcon() {
    }
    
    private final void loadPreviewIcon() {
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    private final void checkToggleItemSelected(player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    private final void loadBrandTypeLogo(android.widget.ImageView icTypeLogo, java.lang.String brandTypeLogo) {
    }
    
    private final void displayContent(player.wellnesssolutions.com.network.models.now_playing.MMVideo data) {
    }
    
    private final void resizeWidthHeightItem(android.view.View itemView) {
    }
    
    private final void showCollections(android.widget.ImageView icTypeLogo, java.util.ArrayList<player.wellnesssolutions.com.network.models.search_result.MMTinyCategory> collections) {
    }
    
    public final void toggleSelectVideo() {
    }
    
    @java.lang.Override()
    public void selectVideo() {
    }
    
    @java.lang.Override()
    public void unselectVideo() {
    }
    
    @java.lang.Override()
    public void download() {
    }
    
    @java.lang.Override()
    public boolean isDownloaded() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public player.wellnesssolutions.com.network.models.now_playing.MMVideo getVideo() {
        return null;
    }
    
    public final int getMItemWidth() {
        return 0;
    }
    
    public final int getMItemHeight() {
        return 0;
    }
    
    public VideosSearchResultPageVH(@org.jetbrains.annotations.NotNull()
    android.view.View view, int mItemWidth, int mItemHeight, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.ISearchResultPageContract.Presenter presenter) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_result_videos/page_result/recyclerview/VideosSearchResultPageVH$Companion;", "", "()V", "mDownloadButtonSize", "", "mThumbnailHeight", "mThumbnailWidth", "mTypeLogoHeight", "mTypeLogoWidth", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}