package player.wellnesssolutions.com.ui.fragment_control;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_control/ControlPresenter;", "Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$Presenter;", "()V", "mConfigData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "mLoadBrandsHandler", "Lplayer/wellnesssolutions/com/ui/fragment_search_brands/module/ILoadBrandHandler;", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_control/IControlContract$View;", "getPlayMode", "Lplayer/wellnesssolutions/com/network/datasource/videos/PlayMode;", "loadBrands", "", "tag", "", "onAttach", "view", "onClickedComingUpNextVideo", "position", "", "onDestroy", "onDetach", "onTapGroupComingUpNext", "readSharePrefData", "app_debug"})
public final class ControlPresenter implements player.wellnesssolutions.com.ui.fragment_control.IControlContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler mLoadBrandsHandler;
    private player.wellnesssolutions.com.ui.fragment_control.IControlContract.View mView;
    private player.wellnesssolutions.com.network.models.config.MMConfigData mConfigData;
    
    @java.lang.Override()
    public void onTapGroupComingUpNext() {
    }
    
    @java.lang.Override()
    public void onClickedComingUpNextVideo(int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.network.datasource.videos.PlayMode getPlayMode() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_control.IControlContract.View view) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void readSharePrefData() {
    }
    
    @java.lang.Override()
    public void loadBrands(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    public ControlPresenter() {
        super();
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}