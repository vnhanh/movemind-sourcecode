package player.wellnesssolutions.com.ui.fragment_splash;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ISplashContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "backToScanQRCode", "", "callGetTokenAgain", "navigateToHomeScreen", "onCallServiceFailed", "messageRes", "", "onStartLoadApi", "updateProgress", "progress", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View {
        
        public abstract void updateProgress(int progress);
        
        public abstract void navigateToHomeScreen();
        
        public abstract void onStartLoadApi();
        
        public abstract void onCallServiceFailed(@androidx.annotation.StringRes()
        int messageRes);
        
        public abstract void backToScanQRCode();
        
        public abstract void callGetTokenAgain();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_splash/ISplashContract$View;", "loadApi", "", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.View> {
        
        public abstract void loadApi();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_splash.ISplashContract.Presenter $this) {
            }
        }
    }
}