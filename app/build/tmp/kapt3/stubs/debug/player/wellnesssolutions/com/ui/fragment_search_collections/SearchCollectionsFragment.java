package player.wellnesssolutions.com.ui.fragment_search_collections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\tH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010\'\u001a\u00020\tH\u0016J\u0018\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\u0018\u0010(\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\tH\u0002J(\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020 2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u001c00j\b\u0012\u0004\u0012\u00020\u001c`1H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_collections/SearchCollectionsFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$View;", "()V", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/ISearchCollectionContract$Presenter;", "attachPresenter", "", "hideLoadingProgress", "hideSwipeText", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onOpenNextScreen", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "collection", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMCollection;", "onPause", "onRequestFailed", "message", "", "onStart", "readArguments", "setupButtonPrevious", "setupButtonRefresh", "setupTitleText", "setupUI", "showLoadingProgress", "showMessage", "messageRes", "", "color", "showSwipeText", "showUI", "brandName", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Companion", "app_debug"})
public final class SearchCollectionsFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.View {
    private player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract.Presenter mPresenter;
    private androidx.appcompat.app.AlertDialog mDialog;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SearchCollectionsFragment";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BRAND = "BRAND";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void readArguments() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupUI() {
    }
    
    private final void setupButtonRefresh() {
    }
    
    private final void setupTitleText() {
    }
    
    private final void setupButtonPrevious() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void attachPresenter() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void onOpenNextScreen(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.screen_search.MMCollection collection) {
    }
    
    @java.lang.Override()
    public void showUI(@org.jetbrains.annotations.NotNull()
    java.lang.String brandName, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.screen_search.MMCollection> data) {
    }
    
    private final void showSwipeText() {
    }
    
    private final void hideSwipeText() {
    }
    
    @java.lang.Override()
    public void onRequestFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    public SearchCollectionsFragment() {
        super();
    }
    
    /**
     * -------------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_collections/SearchCollectionsFragment$Companion;", "", "()V", "KEY_BRAND", "", "getKEY_BRAND", "()Ljava/lang/String;", "TAG", "getTAG", "getInstance", "Lplayer/wellnesssolutions/com/ui/fragment_search_collections/SearchCollectionsFragment;", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKEY_BRAND() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_collections.SearchCollectionsFragment getInstance(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}