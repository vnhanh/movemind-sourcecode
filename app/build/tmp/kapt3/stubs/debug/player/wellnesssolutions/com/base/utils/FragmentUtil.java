package player.wellnesssolutions.com.base.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\nJ>\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013\u00a8\u0006\u001b"}, d2 = {"Lplayer/wellnesssolutions/com/base/utils/FragmentUtil;", "", "()V", "addNewFragment", "", "fm", "Landroidx/fragment/app/FragmentManager;", "newFragment", "Landroidx/fragment/app/Fragment;", "frameId", "", "onBackPressedActivity", "activity", "Landroidx/fragment/app/FragmentActivity;", "printActivityFragmentList", "fragmentManager", "index", "replaceFragment", "newFragmentTag", "", "isAddToBackStack", "", "isRemoveOlds", "showDialogFragment", "dialog", "Landroidx/fragment/app/DialogFragment;", "dialogTag", "app_debug"})
public final class FragmentUtil {
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.utils.FragmentUtil INSTANCE = null;
    
    public final void addNewFragment(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment newFragment, @androidx.annotation.IdRes()
    int frameId) {
    }
    
    public final void replaceFragment(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment newFragment, @org.jetbrains.annotations.NotNull()
    java.lang.String newFragmentTag, @androidx.annotation.IdRes()
    int frameId, boolean isAddToBackStack, boolean isRemoveOlds) {
    }
    
    public final void printActivityFragmentList(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager, int index) {
    }
    
    public final void showDialogFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.DialogFragment dialog, @org.jetbrains.annotations.NotNull()
    java.lang.String dialogTag) {
    }
    
    public final void onBackPressedActivity(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity) {
    }
    
    private FragmentUtil() {
        super();
    }
}