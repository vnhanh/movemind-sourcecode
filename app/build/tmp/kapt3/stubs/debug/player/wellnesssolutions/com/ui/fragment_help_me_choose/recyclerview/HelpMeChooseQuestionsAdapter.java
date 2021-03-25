package player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\'\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/recyclerview/HelpMeChooseQuestionsAdapter;", "Lplayer/wellnesssolutions/com/base/view/BaseClickableAdapter;", "Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/recyclerview/HelpMeChooseQuestionVH;", "Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract$Presenter;", "Lplayer/wellnesssolutions/com/network/models/help_me_choose/MMHelpMeChooseAnswer;", "answers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clickedListener", "(Ljava/util/ArrayList;Lplayer/wellnesssolutions/com/ui/fragment_help_me_choose/IHelpMeChooseContract$Presenter;)V", "ITEM_LEFT_EDGE", "", "getITEM_LEFT_EDGE", "()I", "ITEM_MIDDLE", "getITEM_MIDDLE", "ITEM_RIGHT_EDGE", "getITEM_RIGHT_EDGE", "padding", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "itemType", "setPadding", "app_debug"})
public final class HelpMeChooseQuestionsAdapter extends player.wellnesssolutions.com.base.view.BaseClickableAdapter<player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionVH, player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.Presenter, player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> {
    private int padding = 0;
    private final int ITEM_LEFT_EDGE = 0;
    private final int ITEM_MIDDLE = 1;
    private final int ITEM_RIGHT_EDGE = 2;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int itemType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionVH holder, int position) {
    }
    
    private final void setPadding(player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionVH holder, int position, int padding) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final int getITEM_LEFT_EDGE() {
        return 0;
    }
    
    public final int getITEM_MIDDLE() {
        return 0;
    }
    
    public final int getITEM_RIGHT_EDGE() {
        return 0;
    }
    
    public HelpMeChooseQuestionsAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer> answers, @org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract.Presenter clickedListener) {
        super(null, null);
    }
}