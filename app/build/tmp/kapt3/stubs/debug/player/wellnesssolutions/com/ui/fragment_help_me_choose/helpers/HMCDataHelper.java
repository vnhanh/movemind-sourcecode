package player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0017"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/helpers/HMCDataHelper;", "", "()V", "deleteALlFromTag", "", "tag", "", "mapToAnswerModel", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "data", "Lplayer/wellnesssolutions/database/model/help_me_choose/AnswerRealm;", "mapToAnswerRealm", "answer", "mapToListModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "realmResult", "Lio/realm/RealmResults;", "mapToRealmList", "Lio/realm/RealmList;", "list", "readDB", "saveToDB", "app_debug"})
public final class HMCDataHelper {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.RealmList<player.wellnesssolutions.database.model.help_me_choose.AnswerRealm> mapToRealmList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> list, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.database.model.help_me_choose.AnswerRealm mapToAnswerRealm(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer answer, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> mapToListModel(@org.jetbrains.annotations.NotNull()
    io.realm.RealmResults<player.wellnesssolutions.database.model.help_me_choose.AnswerRealm> realmResult) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer mapToAnswerModel(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.database.model.help_me_choose.AnswerRealm data) {
        return null;
    }
    
    public final void saveToDB(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> list, @org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> readDB(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
        return null;
    }
    
    public final void deleteALlFromTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tag) {
    }
    
    private HMCDataHelper() {
        super();
    }
}