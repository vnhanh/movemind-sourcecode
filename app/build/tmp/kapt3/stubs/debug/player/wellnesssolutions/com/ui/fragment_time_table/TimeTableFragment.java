package player.wellnesssolutions.com.ui.fragment_time_table;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J \u0010*\u001a\u00020\u000e2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00140,j\b\u0012\u0004\u0012\u00020\u0014`-H\u0002J$\u0010.\u001a\u00020\u000e2\u001a\u0010/\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`-H\u0016J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020$H\u0016J\u0018\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000eH\u0016J\u0010\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u000203H\u0002J$\u00107\u001a\u00020\u000e2\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`-H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/TimeTableFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$View;", "Lplayer/wellnesssolutions/com/common/customize_views/MMTabBar$TabBarListener;", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/recyclerview/SchedulerAdapter$OnClickItemListener;", "()V", "expandedTextSize", "", "mDialog", "Landroidx/appcompat/app/AlertDialog;", "mPresenter", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$Presenter;", "normalTextSize", "attachPresenter", "", "detachPresenter", "hideLoadingProgress", "initValues", "onClick", "item", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onPause", "onRequestFailed", "onResume", "onTabChanged", "stringID", "", "onViewCreated", "view", "setupButtonPrevious", "setupButtonRefresh", "setupButtons", "setupRecyclerView", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setupUI", "data", "showDialog", "message", "buttonColor", "", "showLoadingProgress", "updateDisplayingSwipeRightMoreOptionView", "itemCount", "updateRecyclerView", "Companion", "app_debug"})
public final class TimeTableFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.View, player.wellnesssolutions.com.common.customize_views.MMTabBar.TabBarListener, player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerAdapter.OnClickItemListener {
    private player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.Presenter mPresenter;
    private androidx.appcompat.app.AlertDialog mDialog;
    private float normalTextSize = 14.0F;
    private float expandedTextSize = 16.0F;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "TimeTableFragment";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_NEW_DATA = "EXTRA_NEW_DATA";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
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
    
    private final void attachPresenter() {
    }
    
    private final void detachPresenter() {
    }
    
    @java.lang.Override()
    public void onTabChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String stringID) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.response.SessionVideo item) {
    }
    
    @java.lang.Override()
    public void setupUI(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> data) {
    }
    
    @java.lang.Override()
    public void showDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String message, int buttonColor) {
    }
    
    @java.lang.Override()
    public void showDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    private final void setupButtons() {
    }
    
    private final void setupButtonPrevious() {
    }
    
    private final void setupButtonRefresh() {
    }
    
    private final void setupRecyclerView(java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> list) {
    }
    
    private final void updateDisplayingSwipeRightMoreOptionView(int itemCount) {
    }
    
    private final void updateRecyclerView(java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> list) {
    }
    
    @java.lang.Override()
    public void onRequestFailed() {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    /**
     * call from {@link #setupUI()}
     */
    private final void initValues() {
    }
    
    public TimeTableFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/TimeTableFragment$Companion;", "", "()V", "EXTRA_NEW_DATA", "", "TAG", "getBundleForNewData", "Landroid/os/Bundle;", "getInstance", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/TimeTableFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.ui.fragment_time_table.TimeTableFragment getInstance() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getBundleForNewData() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}