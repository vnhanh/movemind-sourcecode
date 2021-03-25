package player.wellnesssolutions.com.ui.fragment_time_table;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J,\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010!j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\u0012\u0010\'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010)\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0014J\u0018\u0010,\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u0014J\b\u0010-\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/TimeTablePresenter;", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "Lplayer/wellnesssolutions/com/network/models/response/TimeTableResponse;", "()V", "NOT_PUBLISH", "", "NO_SCHEDULE", "mIsLoading", "", "mIsRendered", "mResponse", "mTimeTableApi", "Lplayer/wellnesssolutions/com/network/datasource/time_table/TimeTableApi;", "mView", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$View;", "checkIfNoSchedulerForToday", "", "data", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "displayUI", "getString", "id", "", "onAttach", "view", "onComplete", "onDestroy", "onDetach", "onExpired", "error", "onExpiredUnauthenticated", "onGetSessionVideo", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "Lkotlin/collections/ArrayList;", "typeDay", "typeSession", "onGetTimetable", "onRequestError", "message", "onRequestFailed", "onResponseFalse", "code", "onResponseSuccess", "onStop", "app_debug"})
public final class TimeTablePresenter extends player.wellnesssolutions.com.base.view.BaseResponseObserver<player.wellnesssolutions.com.network.models.response.TimeTableResponse> implements player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.Presenter {
    private player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.View mView;
    private player.wellnesssolutions.com.network.datasource.time_table.TimeTableApi mTimeTableApi;
    private player.wellnesssolutions.com.network.models.response.TimeTableResponse mResponse;
    private boolean mIsLoading = false;
    private boolean mIsRendered = false;
    private final java.lang.String NO_SCHEDULE = "There is no schedule for this device";
    private final java.lang.String NOT_PUBLISH = "The schedule has not been published";
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.View view) {
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> onGetSessionVideo(@org.jetbrains.annotations.NotNull()
    java.lang.String typeDay, @org.jetbrains.annotations.NotNull()
    java.lang.String typeSession) {
        return null;
    }
    
    private final java.lang.String getString(int id) {
        return null;
    }
    
    @java.lang.Override()
    public void onGetTimetable() {
    }
    
    @java.lang.Override()
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<player.wellnesssolutions.com.network.models.response.TimeTableResponse> data) {
    }
    
    private final void displayUI() {
    }
    
    @java.lang.Override()
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    private final void onRequestFailed(java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    private final void checkIfNoSchedulerForToday(player.wellnesssolutions.com.network.models.response.ResponseValue<player.wellnesssolutions.com.network.models.response.TimeTableResponse> data) {
    }
    
    @java.lang.Override()
    public void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @java.lang.Override()
    public void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public TimeTablePresenter() {
        super();
    }
}