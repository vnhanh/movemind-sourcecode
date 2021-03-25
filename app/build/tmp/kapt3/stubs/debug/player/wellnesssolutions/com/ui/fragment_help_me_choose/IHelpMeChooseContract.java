package player.wellnesssolutions.com.ui.fragment_help_me_choose;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract;", "", "Presenter", "View", "app_debug"})
public abstract interface IHelpMeChooseContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH&J*\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000bj\b\u0012\u0004\u0012\u00020\u0010`\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "Lplayer/wellnesssolutions/com/base/view/IProgressView;", "onRequestFailed", "", "message", "", "openScreenSearchResult", "brandId", "", "answers", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "Lkotlin/collections/ArrayList;", "showLoadedData", "loadedData", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseQuestion;", "hmcText", "showTextByRemote", "configData", "Lplayer/wellnesssolutions/com/network/models/config/MMConfigData;", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View, player.wellnesssolutions.com.base.view.IProgressView {
        
        public abstract void showTextByRemote(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.config.MMConfigData configData);
        
        public abstract void showLoadedData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion> loadedData, @org.jetbrains.annotations.Nullable()
        java.lang.String hmcText);
        
        public abstract void openScreenSearchResult(int brandId, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> answers);
        
        public abstract void onRequestFailed(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0011"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract$View;", "clickedButtonHelpMeChoose", "", "isItemSelected", "", "item", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "loadData", "view", "onReshowUI", "selectAnswer", "data", "setChosenBrand", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.View> {
        
        public abstract void setChosenBrand(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.screen_search.MMBrand brand);
        
        public abstract void selectAnswer(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer data);
        
        public abstract void clickedButtonHelpMeChoose();
        
        public abstract void onReshowUI(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.View view);
        
        public abstract boolean isItemSelected(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer item);
        
        public abstract void loadData(@org.jetbrains.annotations.NotNull()
        player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.View view);
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.Presenter $this) {
            }
        }
    }
}