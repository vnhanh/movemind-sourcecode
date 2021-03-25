package player.wellnesssolutions.com.ui.activity_main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_main/CastOptionsProvider;", "Lcom/google/android/gms/cast/framework/OptionsProvider;", "()V", "CUSTOM_NAMESPACE", "", "getCUSTOM_NAMESPACE", "()Ljava/lang/String;", "getAdditionalSessionProviders", "", "Lcom/google/android/gms/cast/framework/SessionProvider;", "context", "Landroid/content/Context;", "getCastOptions", "Lcom/google/android/gms/cast/framework/CastOptions;", "app_debug"})
public final class CastOptionsProvider implements com.google.android.gms.cast.framework.OptionsProvider {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String CUSTOM_NAMESPACE = "urn:x-cast:custom_namespace";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCUSTOM_NAMESPACE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.google.android.gms.cast.framework.CastOptions getCastOptions(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.List<com.google.android.gms.cast.framework.SessionProvider> getAdditionalSessionProviders(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public CastOptionsProvider() {
        super();
    }
}