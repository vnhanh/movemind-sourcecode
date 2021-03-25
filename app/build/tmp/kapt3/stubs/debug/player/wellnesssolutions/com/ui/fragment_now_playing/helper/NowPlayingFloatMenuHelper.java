package player.wellnesssolutions.com.ui.fragment_now_playing.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ@\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ:\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_now_playing/helper/NowPlayingFloatMenuHelper;", "", "()V", "mAnimHelper", "Lplayer/wellnesssolutions/com/ui/fragment_control/helpers/MMMenuAnimationHelper;", "mIsShowFloatMenu", "", "mWeakCloseButton", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "closeFloatMenu", "", "hideFloatMenu", "showButton", "closeButton", "floatMenu", "Landroid/view/View;", "menuFrame", "isFloatMenuIsOpening", "onClickedButtonMenuFloat", "onInit", "onRelease", "setupFloatMenu", "wrapperButonMenu", "viewBgGroupControls", "presenter", "Lplayer/wellnesssolutions/com/ui/fragment_now_playing/INowPlayingConstruct$Presenter;", "setupMenuItemClickedListener", "view", "app_debug"})
public final class NowPlayingFloatMenuHelper {
    private player.wellnesssolutions.com.ui.fragment_control.helpers.MMMenuAnimationHelper mAnimHelper;
    private java.lang.ref.WeakReference<android.widget.ImageView> mWeakCloseButton;
    private boolean mIsShowFloatMenu = false;
    
    public final void onInit() {
    }
    
    private final void onClickedButtonMenuFloat(android.widget.ImageView showButton, android.widget.ImageView closeButton, android.view.View floatMenu, android.view.View menuFrame) {
    }
    
    public final void setupFloatMenu(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView showButton, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView closeButton, @org.jetbrains.annotations.NotNull()
    android.view.View wrapperButonMenu, @org.jetbrains.annotations.NotNull()
    android.view.View floatMenu, @org.jetbrains.annotations.NotNull()
    android.view.View menuFrame, @org.jetbrains.annotations.NotNull()
    android.view.View viewBgGroupControls, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    private final void setupMenuItemClickedListener(android.view.View view, android.widget.ImageView showButton, android.widget.ImageView closeButton, android.view.View floatMenu, android.view.View menuFrame, player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct.Presenter presenter) {
    }
    
    private final void hideFloatMenu(android.widget.ImageView showButton, android.widget.ImageView closeButton, android.view.View floatMenu, android.view.View menuFrame) {
    }
    
    public final boolean isFloatMenuIsOpening() {
        return false;
    }
    
    public final void closeFloatMenu() {
    }
    
    public final void onRelease() {
    }
    
    public NowPlayingFloatMenuHelper() {
        super();
    }
}