package player.wellnesssolutions.com.base.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rH\u0004J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0004J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\u0016H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\b\u0010)\u001a\u00020\u0016H\u0016J\b\u0010*\u001a\u00020\u0016H\u0016J\b\u0010+\u001a\u00020\u0016H\u0016J\b\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0004J\b\u0010.\u001a\u00020\u0016H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/BaseScheduleFragment;", "Lplayer/wellnesssolutions/com/base/view/BaseFragment;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$View;", "Lplayer/wellnesssolutions/com/ui/activity_main/ScheduleBroadcastReceiver$ScheduleListener;", "()V", "dialog", "Landroid/app/Dialog;", "getDialog", "()Landroid/app/Dialog;", "setDialog", "(Landroid/app/Dialog;)V", "isNewScreen", "", "()Z", "setNewScreen", "(Z)V", "isStartedOpenNewScreen", "setStartedOpenNewScreen", "schedulePresenter", "Lplayer/wellnesssolutions/com/base/common/load_scheduled_videos/IScheduleContract$Presenter;", "hideLoadingProgress", "", "loadSchedule", "isClickedFromBtnBottom", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onHandleSchedule", "onPause", "onReceiveChangeApiBackToHome", "onReceiveChangeApiBackToHomeGetConfigApi", "onReceiveChangeApiGetConfigApi", "onReceivePlayVideoScheduleFromUI", "onReceiveResetScheduleFromUI", "onReceiveUpdateScheduleFromUI", "onResume", "onStop", "setOldScreen", "showLoadingProgress", "app_debug"})
public class BaseScheduleFragment extends player.wellnesssolutions.com.base.view.BaseFragment implements player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.View, player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver.ScheduleListener {
    private player.wellnesssolutions.com.base.common.load_scheduled_videos.IScheduleContract.Presenter schedulePresenter;
    private boolean isNewScreen = true;
    @org.jetbrains.annotations.Nullable()
    private android.app.Dialog dialog;
    private boolean isStartedOpenNewScreen = false;
    private java.util.HashMap _$_findViewCache;
    
    protected final boolean isNewScreen() {
        return false;
    }
    
    protected final void setNewScreen(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.app.Dialog getDialog() {
        return null;
    }
    
    protected final void setDialog(@org.jetbrains.annotations.Nullable()
    android.app.Dialog p0) {
    }
    
    protected final boolean isStartedOpenNewScreen() {
        return false;
    }
    
    protected final void setStartedOpenNewScreen(boolean p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    protected final void loadSchedule(boolean isClickedFromBtnBottom) {
    }
    
    protected final void setOldScreen() {
    }
    
    protected final void onHandleSchedule() {
    }
    
    /**
     * ------------------------------------------------------------------------------------------------------------------------
     */
    @java.lang.Override()
    public void onReceivePlayVideoScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceiveResetScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceiveUpdateScheduleFromUI() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiBackToHome() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiBackToHomeGetConfigApi() {
    }
    
    @java.lang.Override()
    public void onReceiveChangeApiGetConfigApi() {
    }
    
    @java.lang.Override()
    public void showLoadingProgress() {
    }
    
    @java.lang.Override()
    public void hideLoadingProgress() {
    }
    
    public BaseScheduleFragment() {
        super();
    }
    
    public void onHaveClassVideos(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> scheduleVideos, boolean isClickedFromBtnBottom) {
    }
    
    public void onHaveClassVideosWithTimeWaiting(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.now_playing.MMVideo> videos) {
    }
    
    public void onNoClassVideosForNow(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int msgColor, boolean isClickedFromBtnBottom) {
    }
    
    public void onTimePlaySchedule() {
    }
    
    public void showDialogAskWantToBackToHome(boolean isLoadSchedule) {
    }
    
    @java.lang.Override()
    public void showMessage(@androidx.annotation.StringRes()
    int messageRes, @androidx.annotation.ColorRes()
    int color) {
    }
    
    @java.lang.Override()
    public void showMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @androidx.annotation.ColorRes()
    int color) {
    }
    
    public void onReceiveChangeSub() {
    }
}