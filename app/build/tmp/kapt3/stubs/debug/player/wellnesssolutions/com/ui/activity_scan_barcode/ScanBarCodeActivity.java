package player.wellnesssolutions.com.ui.activity_scan_barcode;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\"\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001a\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\bH\u0014J-\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020&0%2\u0006\u0010\'\u001a\u00020(H\u0016\u00a2\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\bH\u0014J\b\u0010+\u001a\u00020\bH\u0016J\u0018\u0010,\u001a\u00020\b2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J\b\u00100\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$View;", "Lcom/journeyapps/barcodescanner/BarcodeCallback;", "()V", "presenter", "Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeContract$Presenter;", "barcodeResult", "", "result", "Lcom/journeyapps/barcodescanner/BarcodeResult;", "checkPermission", "", "checkPermissionDrawOnTop", "getFragment", "Landroidx/fragment/app/Fragment;", "getView", "Landroid/view/View;", "getViewContext", "Landroid/content/Context;", "goToHome", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "pauseScan", "possibleResultPoints", "resultPoints", "", "Lcom/google/zxing/ResultPoint;", "resumeScan", "Companion", "app_debug"})
public final class ScanBarCodeActivity extends androidx.appcompat.app.AppCompatActivity implements player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.View, com.journeyapps.barcodescanner.BarcodeCallback {
    private player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeContract.Presenter presenter;
    private static final int PERMISSION_REQUEST = 101;
    private static final int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 102;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final boolean checkPermissionDrawOnTop() {
        return false;
    }
    
    private final boolean checkPermission() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment getFragment() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.content.Context getViewContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView() {
        return null;
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void goToHome() {
    }
    
    @java.lang.Override()
    public void resumeScan() {
    }
    
    @java.lang.Override()
    public void pauseScan() {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    public void barcodeResult(@org.jetbrains.annotations.Nullable()
    com.journeyapps.barcodescanner.BarcodeResult result) {
    }
    
    @java.lang.Override()
    public void possibleResultPoints(@org.jetbrains.annotations.Nullable()
    java.util.List<com.google.zxing.ResultPoint> resultPoints) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public ScanBarCodeActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lplayer/wellnesssolutions/com/ui/activity_scan_barcode/ScanBarCodeActivity$Companion;", "", "()V", "ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE", "", "PERMISSION_REQUEST", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}