package player.wellnesssolutions.com.base.common.play_video;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020.H\u0002J\u001e\u0010/\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u0015H\u0002J\u001a\u00101\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0016H\u0002J \u00103\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020.H\u0002J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0003H\u0002J&\u00108\u001a\u00020)2\u0006\u00107\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u0015H\u0002J1\u00109\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010\f2\u001a\u00100\u001a\u0016\u0012\u0004\u0012\u00020.\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020.\u0018\u0001`\u0017\u00a2\u0006\u0002\u0010;J \u0010<\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020.H\u0002J\u0018\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0013H\u0002J\u0006\u0010A\u001a\u00020)J\b\u0010B\u001a\u00020)H\u0002J\u0006\u0010C\u001a\u00020\u0013J\u0006\u0010D\u001a\u00020)J\u0006\u0010E\u001a\u00020)J\u0006\u0010F\u001a\u00020)J\u000e\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u001eJ\u0006\u0010I\u001a\u00020)J\b\u0010J\u001a\u00020)H\u0002J\u0006\u0010K\u001a\u00020)J\b\u0010L\u001a\u00020)H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010\r\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f`\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000f0\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u000f`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f0\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000f`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\"R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00030\u00030\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\'\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00050\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006M"}, d2 = {"Lplayer/wellnesssolutions/com/base/common/play_video/ClosedCaptionController;", "", "playerControllerView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "subtilteView", "Lcom/google/android/exoplayer2/ui/SubtitleView;", "showMode", "Lplayer/wellnesssolutions/com/base/common/play_video/ShowMode;", "(Landroidx/constraintlayout/widget/ConstraintLayout;Lcom/google/android/exoplayer2/ui/SubtitleView;Lplayer/wellnesssolutions/com/base/common/play_video/ShowMode;)V", "NoneLanguageKey", "", "mCheckViewSize", "", "mCheckViews", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "Lkotlin/collections/HashMap;", "mIsShownCheckViewOnInit", "", "mLanguageBgViews", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "mLanguageTextViews", "Landroid/widget/TextView;", "mLastLanguageKey", "mMargin", "mOptionIndex", "mPlayerManager", "Lplayer/wellnesssolutions/com/base/common/play_video/IPlayVideoContract$Manager;", "mShowMode", "mSubtitleBoardPadding", "mVideoId", "Ljava/lang/Integer;", "mWeakCCView", "kotlin.jvm.PlatformType", "mWeakControllerSubtitleBoard", "mWeakPlayerControllerView", "mWeakSubtitleView", "addBackgroundView", "", "subtitleBoard", "iconCheck", "isSelected", "language", "Lplayer/wellnesssolutions/com/network/models/now_playing/MMVideoLanguage;", "addChildViews", "languages", "addIconCheck", "aboveView", "addTextLanguage", "leftView", "videoLanguage", "clearLatestViews", "parentView", "createControllerBoard", "createOrUpdateSubtitleBoardView", "videoId", "(Ljava/lang/Integer;Ljava/util/ArrayList;)V", "createTextLanguageView", "displayCheckView", "context", "Landroid/content/Context;", "isDisplay", "hideClosedCaptionView", "hideSubtitleView", "isShowClosedCaptionView", "release", "resetData", "selectCurrentLanguageCCOption", "setPlayerManager", "playerManager", "showClosedCaptionView", "showSubtitleView", "slideNextLanguageCCOption", "updateSubtitleBoardView", "app_debug"})
public final class ClosedCaptionController {
    private final java.lang.ref.WeakReference<androidx.constraintlayout.widget.ConstraintLayout> mWeakPlayerControllerView = null;
    private final java.lang.ref.WeakReference<com.google.android.exoplayer2.ui.SubtitleView> mWeakSubtitleView = null;
    private final java.lang.ref.WeakReference<android.widget.ImageView> mWeakCCView = null;
    private final player.wellnesssolutions.com.base.common.play_video.ShowMode mShowMode = null;
    private player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager mPlayerManager;
    private java.lang.ref.WeakReference<androidx.constraintlayout.widget.ConstraintLayout> mWeakControllerSubtitleBoard;
    private java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<android.widget.ImageView>> mCheckViews;
    private java.util.ArrayList<java.lang.ref.WeakReference<android.widget.TextView>> mLanguageTextViews;
    private java.util.ArrayList<java.lang.ref.WeakReference<android.view.View>> mLanguageBgViews;
    private int mMargin = 0;
    private int mSubtitleBoardPadding = 0;
    private java.lang.Integer mVideoId;
    private boolean mIsShownCheckViewOnInit = false;
    private int mCheckViewSize = 0;
    private final java.lang.String NoneLanguageKey = "-1";
    private java.lang.String mLastLanguageKey;
    private int mOptionIndex = 0;
    
    public final void createOrUpdateSubtitleBoardView(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage> languages) {
    }
    
    private final void updateSubtitleBoardView() {
    }
    
    private final void createControllerBoard(androidx.constraintlayout.widget.ConstraintLayout parentView, androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage> languages) {
    }
    
    private final void addChildViews(androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage> languages) {
    }
    
    private final android.widget.ImageView addIconCheck(androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, android.view.View aboveView) {
        return null;
    }
    
    private final android.widget.TextView addTextLanguage(androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, android.widget.ImageView leftView, player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage videoLanguage) {
        return null;
    }
    
    private final android.widget.TextView createTextLanguageView(androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, android.widget.ImageView leftView, player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage videoLanguage) {
        return null;
    }
    
    private final void addBackgroundView(androidx.constraintlayout.widget.ConstraintLayout subtitleBoard, android.widget.ImageView iconCheck, boolean isSelected, player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage language) {
    }
    
    private final void showSubtitleView() {
    }
    
    private final void hideSubtitleView() {
    }
    
    private final void displayCheckView(android.content.Context context, boolean isDisplay) {
    }
    
    private final void clearLatestViews(androidx.constraintlayout.widget.ConstraintLayout parentView) {
    }
    
    public final void setPlayerManager(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract.Manager playerManager) {
    }
    
    public final void release() {
    }
    
    public final void showClosedCaptionView() {
    }
    
    public final void hideClosedCaptionView() {
    }
    
    public final boolean isShowClosedCaptionView() {
        return false;
    }
    
    public final void slideNextLanguageCCOption() {
    }
    
    public final void selectCurrentLanguageCCOption() {
    }
    
    public final void resetData() {
    }
    
    public ClosedCaptionController(@org.jetbrains.annotations.NotNull()
    androidx.constraintlayout.widget.ConstraintLayout playerControllerView, @org.jetbrains.annotations.NotNull()
    com.google.android.exoplayer2.ui.SubtitleView subtilteView, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.base.common.play_video.ShowMode showMode) {
        super();
    }
}