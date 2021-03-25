package player.wellnesssolutions.com.ui.activity_scan_barcode;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract;", "", "Presenter", "View", "app_debug"})
public abstract interface ScanBarCodeContract {
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$View;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$View;", "getView", "Landroid/view/View;", "goToHome", "", "pauseScan", "resumeScan", "app_debug"})
    public static abstract interface View extends player.wellnesssolutions.com.base.view.ILifeCycle.View {
        
        @org.jetbrains.annotations.NotNull()
        public abstract android.view.View getView();
        
        public abstract void goToHome();
        
        public abstract void resumeScan();
        
        public abstract void pauseScan();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void goToHome(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View $this) {
            }
            
            public static void resumeScan(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View $this) {
            }
            
            public static void pauseScan(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View $this) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$Presenter;", "Lplayer/wellnesssolutions/com/base/view/ILifeCycle$Presenter;", "Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$View;", "checkFormatBarcode", "", "string", "", "login", "", "requestActiveDevice", "email", "app_debug"})
    public static abstract interface Presenter extends player.wellnesssolutions.com.base.view.ILifeCycle.Presenter<player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View> {
        
        public abstract void requestActiveDevice(@org.jetbrains.annotations.NotNull()
        java.lang.String email);
        
        public abstract boolean checkFormatBarcode(@org.jetbrains.annotations.NotNull()
        java.lang.String string);
        
        public abstract void login();
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 3)
        public static final class DefaultImpls {
            
            public static void requestActiveDevice(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter $this, @org.jetbrains.annotations.NotNull()
            java.lang.String email) {
            }
            
            public static boolean checkFormatBarcode(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter $this, @org.jetbrains.annotations.NotNull()
            java.lang.String string) {
                return false;
            }
            
            public static void login(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter $this) {
            }
            
            @java.lang.Override()
            public static void onStop(@org.jetbrains.annotations.NotNull()
            player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter $this) {
            }
        }
    }
}