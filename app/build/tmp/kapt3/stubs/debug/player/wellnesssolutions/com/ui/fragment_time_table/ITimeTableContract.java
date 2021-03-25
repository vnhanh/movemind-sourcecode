package player.wellnesssolutions.com.ui.fragment_time_table;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ITimeTableContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J$\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "onRequestFailed", "", "setupUI", "data", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "Lkotlin/collections/ArrayList;", "showDialog", "message", "", "buttonColor", "", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void setupUI(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> data);
        
        public abstract void showDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String message, int buttonColor);
        
        public abstract void showDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        public abstract void onRequestFailed();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J,\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_time_table/ITimeTableContract$View;", "onGetSessionVideo", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/response/SessionVideo;", "Lkotlin/collections/ArrayList;", "typeDay", "", "typeSession", "onGetTimetable", "", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.View> {
        
        @org.jetbrains.annotations.Nullable()
        public abstract java.util.ArrayList<player.wellnesssolutions.com.network.models.response.SessionVideo> onGetSessionVideo(@org.jetbrains.annotations.NotNull()
        java.lang.String typeDay, @org.jetbrains.annotations.NotNull()
        java.lang.String typeSession);
        
        public abstract void onGetTimetable();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_time_table.ITimeTableContract.Presenter $this) {
            }
        }
    }
}