package player.wellnesssolutions.com.ui.fragment_control.helpers;

import java.lang.System;

/**
 * This class help to show the menu animation
 * Use in NOW PLAYING screen and CONTROL FRAGMENT
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J0\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J.\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/helpers/MMMenuAnimationHelper;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "()V", "mAnimator", "Landroid/animation/ValueAnimator;", "mFloatMenu", "Landroid/view/View;", "mIsAnimating", "", "mIsHideFloatMenu", "mIsStateTransfered", "mMenuFrame", "mWillHideButton", "Landroid/widget/ImageView;", "mWillShowButton", "init", "", "onAnimationUpdate", "animator", "process", "willShowButton", "willHideButton", "floatMenu", "menuFrame", "value", "", "release", "restart", "roateWillShowButton", "showButton", "rotateWillHideButton", "startAnim", "isHideFloatMenu", "Companion", "app_debug"})
public final class MMMenuAnimationHelper implements android.animation.ValueAnimator.AnimatorUpdateListener {
    private android.animation.ValueAnimator mAnimator;
    private android.widget.ImageView mWillShowButton;
    private android.widget.ImageView mWillHideButton;
    private android.view.View mFloatMenu;
    private android.view.View mMenuFrame;
    private boolean mIsHideFloatMenu = false;
    private boolean mIsAnimating = false;
    private boolean mIsStateTransfered = false;
    public static final long DURATION = 400L;
    private static final int WHOLE_CRICLE = 360;
    private static final int HALF_CIRCLE = 180;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_control.helpers.MMMenuAnimationHelper.Companion Companion = null;
    
    public final void init() {
    }
    
    public final void restart() {
    }
    
    @java.lang.Override()
    public void onAnimationUpdate(@org.jetbrains.annotations.NotNull()
    android.animation.ValueAnimator animator) {
    }
    
    private final void process(android.widget.ImageView willShowButton, android.widget.ImageView willHideButton, android.view.View floatMenu, android.view.View menuFrame, int value) {
    }
    
    private final void roateWillShowButton(android.widget.ImageView showButton, android.view.View floatMenu, android.view.View menuFrame, int value) {
    }
    
    private final void rotateWillHideButton(android.widget.ImageView willHideButton, int value) {
    }
    
    public final void release() {
    }
    
    /**
     * if open menu:
     *     1. willShowButton: the CLOSE MENU button
     *     2. willHideButton: the MENU button
     *
     * else if close menu:
     *     1. willShowButton: the MENU button
     *     2. willHideButton: the CLOSE MENU button
     */
    public final boolean startAnim(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView willShowButton, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView willHideButton, @org.jetbrains.annotations.NotNull()
    android.view.View floatMenu, @org.jetbrains.annotations.NotNull()
    android.view.View menuFrame, boolean isHideFloatMenu) {
        return false;
    }
    
    public MMMenuAnimationHelper() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/helpers/MMMenuAnimationHelper$Companion;", "", "()V", "DURATION", "", "HALF_CIRCLE", "", "WHOLE_CRICLE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}