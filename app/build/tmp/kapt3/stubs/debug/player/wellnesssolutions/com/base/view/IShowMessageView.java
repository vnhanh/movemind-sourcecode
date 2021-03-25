package player.wellnesssolutions.com.base.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/IShowMessageView;", "", "showMessage", "", "messageRes", "", "color", "message", "", "app_debug"})
public abstract interface IShowMessageView {
    
    public abstract void showMessage(@androidx.annotation.StringRes()
    int messageRes, @androidx.annotation.ColorRes()
    int color);
    
    public abstract void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int color);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static void showMessage(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.view.IShowMessageView $this, @androidx.annotation.StringRes()
        int messageRes, @androidx.annotation.ColorRes()
        int color) {
        }
        
        public static void showMessage(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.base.view.IShowMessageView $this, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @androidx.annotation.ColorRes()
        int color) {
        }
    }
}