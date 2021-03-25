package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingVHDisplayHelper;", "", "()V", "mThumbnailCorner", "", "mThumbnailHeight", "mThumbnailWidth", "displayThumbnail", "", "thumbnailVideo", "Landroid/widget/ImageView;", "url", "", "displayTimeStart", "tvTimeStart", "Lplayer/wellnesssolutions/com/common/customize_views/MMTextView;", "playTime", "initThumbnailDimens", "resources", "Landroid/content/res/Resources;", "app_debug"})
public final class NowPlayingVHDisplayHelper {
    private static int mThumbnailCorner = 0;
    private static int mThumbnailWidth = 0;
    private static int mThumbnailHeight = 0;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingVHDisplayHelper INSTANCE = null;
    
    public final void displayTimeStart(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.common.customize_views.MMTextView tvTimeStart, @org.jetbrains.annotations.NotNull()
    java.lang.String playTime) {
    }
    
    public final void displayThumbnail(@org.jetbrains.annotations.Nullable()
    android.widget.ImageView thumbnailVideo, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    private final void initThumbnailDimens(android.content.res.Resources resources) {
    }
    
    private NowPlayingVHDisplayHelper() {
        super();
    }
}