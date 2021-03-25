package player.wellnesssolutions.com.base.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/ILifeCycle;", "", "Presenter", "View", "app_debug"})
public abstract interface ILifeCycle {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "", "getFragment", "Landroidx/fragment/app/Fragment;", "getViewContext", "Landroid/content/Context;", "app_debug"})
    public static abstract interface View {
        
        @org.jetbrains.annotations.NotNull()
        public abstract androidx.fragment.app.Fragment getFragment();
        
        @org.jetbrains.annotations.Nullable()
        public abstract android.content.Context getViewContext();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "V", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "", "onAttach", "", "view", "(Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;)V", "onDestroy", "onDetach", "onStop", "app_debug"})
    public static abstract interface Presenter<V extends player.wellnesssolutions.com.base.view.ILifeCycle.View> {
        
        public abstract void onAttach(@org.jetbrains.annotations.NotNull()
        V view);
        
        public abstract void onDetach();
        
        public abstract void onStop();
        
        public abstract void onDestroy();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static <V extends player.wellnesssolutions.com.base.view.ILifeCycle.View>void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<V> $this) {
            }
        }
    }
}