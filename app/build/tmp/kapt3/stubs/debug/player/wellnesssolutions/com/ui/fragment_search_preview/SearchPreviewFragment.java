package player.wellnesssolutions.com.ui.fragment_search_preview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\tH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010\'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u000bH\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/SearchPreviewFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$View;", "()V", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/ISearchPreviewContract$Presenter;", "nameCollectionChoose", "", "attachPresenter", "", "clickedButtonShowAllVideos", "clickedButtonShowVideosByOptions", "clickedShowResult", "isUseOptions", "", "hideLoadingProgress", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onClickedIconRefresh", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onRequestFailed", "message", "onStart", "openSearchResultScreen", "selectedOptions", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "readArguments", "setupButtons", "setupTextTitle", "setupUI", "showLoadingProgress", "showMessage", "messageRes", "", "color", "showUI", "showUIData", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/SPShowedUIData;", "Companion", "app_debug"})
public final class SearchPreviewFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.View {
    private player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract.Presenter mPresenter;
    private androidx.appcompat.app.AlertDialog mDialog;
    private java.lang.String nameCollectionChoose;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "SearchPreviewFragment";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_BRAND = "BRAND";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SEARCH_BY_DATA = "KEY NORMAL BY DATA";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment.Companion Companion = null;
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
    
    private final void setupTextTitle() {
    }
    
    private final void setupButtons() {
    }
    
    private final void clickedButtonShowAllVideos() {
    }
    
    private final void clickedShowResult(boolean isUseOptions) {
    }
    
    private final void clickedButtonShowVideosByOptions() {
    }
    
    private final void onClickedIconRefresh() {
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
    
    /**
     * View interface
     */
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int color) {
    }
    
    @java.lang.Override()
    public void showMessage(int messageRes, int color) {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    @java.lang.Override()
    public void showUI(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData showUIData) {
    }
    
    @java.lang.Override()
    public void onRequestFailed(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void openSearchResultScreen(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption selectedOptions) {
    }
    
    public SearchPreviewFragment() {
        super();
    }
    
    /**
     * ---------------------
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JC\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/SearchPreviewFragment$Companion;", "", "()V", "KEY_BRAND", "", "getKEY_BRAND", "()Ljava/lang/String;", "KEY_SEARCH_BY_DATA", "getKEY_SEARCH_BY_DATA", "TAG", "getTAG", "getInstance", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/SearchPreviewFragment;", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "chosenTypeOptionId", "", "chosenOptionId", "chosenOptionTitle", "imgCollection", "imgStrokeColor", "(Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lplayer/wellnesssolutions/com/ui/fragment_search_preview/SearchPreviewFragment;", "app_debug"})
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
        public final java.lang.String getKEY_SEARCH_BY_DATA() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_search_preview.SearchPreviewFragment getInstance(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand, int chosenTypeOptionId, @org.jetbrains.annotations.Nullable()
        java.lang.Integer chosenOptionId, @org.jetbrains.annotations.Nullable()
        java.lang.String chosenOptionTitle, @org.jetbrains.annotations.Nullable()
        java.lang.String imgCollection, @org.jetbrains.annotations.Nullable()
        java.lang.String imgStrokeColor) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}