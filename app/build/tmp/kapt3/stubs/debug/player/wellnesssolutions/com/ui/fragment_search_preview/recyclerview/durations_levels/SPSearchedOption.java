package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\'J\u0018\u0010(\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020%H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006+"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "brand", "Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "getBrand", "()Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;", "setBrand", "(Lplayer/wellnesssolutions/com/network/models/screen_search/MMBrand;)V", "collections", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SearchedOption;", "Lkotlin/collections/ArrayList;", "getCollections", "()Ljava/util/ArrayList;", "setCollections", "(Ljava/util/ArrayList;)V", "durations", "getDurations", "setDurations", "instructors", "getInstructors", "setInstructors", "levels", "getLevels", "setLevels", "searchByData", "getSearchByData", "()Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SearchedOption;", "setSearchByData", "(Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SearchedOption;)V", "clear", "", "describeContents", "", "isEmptyOption", "", "writeToParcel", "flags", "CREATOR", "app_debug"})
public final class SPSearchedOption implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private player.wellnesssolutions.com.network.models.screen_search.MMBrand brand;
    @org.jetbrains.annotations.Nullable()
    private player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption searchByData;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> collections;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> instructors;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> durations;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> levels;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.Nullable()
    public final player.wellnesssolutions.com.network.models.screen_search.MMBrand getBrand() {
        return null;
    }
    
    public final void setBrand(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.screen_search.MMBrand p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption getSearchByData() {
        return null;
    }
    
    public final void setSearchByData(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> getCollections() {
        return null;
    }
    
    public final void setCollections(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> getInstructors() {
        return null;
    }
    
    public final void setInstructors(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> getDurations() {
        return null;
    }
    
    public final void setDurations(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> getLevels() {
        return null;
    }
    
    public final void setLevels(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption> p0) {
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public final boolean isEmptyOption() {
        return false;
    }
    
    public final void clear() {
    }
    
    public SPSearchedOption() {
        super();
    }
    
    public SPSearchedOption(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lplayer/wellnesssolutions/com/ui/fragment_search_preview/recyclerview/durations_levels/SPSearchedOption;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPSearchedOption[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}