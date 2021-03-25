package player.wellnesssolutions.com.services.download;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000e\u0018\u0000 42\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001:\u000234B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J%\u0010%\u001a\u00020\u00032\u0016\u0010&\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\'\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0010H\u0002J\u0017\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010,J%\u0010-\u001a\u00020\"2\u0016\u0010.\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\'\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0002H\u0002J\u0010\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0002H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00070\u00070\u001a0\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00050\u00050\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lplayer/wellnesssolutions/com/services/download/DownloadTask;", "Landroid/os/AsyncTask;", "Lplayer/wellnesssolutions/com/services/download/DownloadData;", "", "context", "Landroid/content/Context;", "callback", "Lplayer/wellnesssolutions/com/services/download/DownloadTask$Callback;", "(Landroid/content/Context;Lplayer/wellnesssolutions/com/services/download/DownloadTask$Callback;)V", "aesCipherDataSink", "Lcom/google/android/exoplayer2/upstream/crypto/AesCipherDataSink;", "connection", "Ljava/net/HttpURLConnection;", "input", "Ljava/io/InputStream;", "isFirstDownloadTask", "", "mAvailableSpace", "", "mCookieValue", "", "mDownloadData", "mFileLength", "mReason", "mWeakCallbacks", "", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "mWeakContext", "output", "Ljava/io/OutputStream;", "savedFile", "Ljava/io/File;", "addListener", "", "closeAll", "closeInAndConn", "doInBackground", "params", "", "([Lplayer/wellnesssolutions/com/services/download/DownloadData;)Ljava/lang/Integer;", "isNetworkDisconnected", "onPostExecute", "result", "(Ljava/lang/Integer;)V", "onProgressUpdate", "values", "([Ljava/lang/Integer;)V", "saveFileExternal", "downloadData", "saveFileInternal", "Callback", "Companion", "app_debug"})
public final class DownloadTask extends android.os.AsyncTask<player.wellnesssolutions.com.services.download.DownloadData, java.lang.Integer, java.lang.Integer> {
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private java.util.List<java.lang.ref.WeakReference<player.wellnesssolutions.com.services.download.DownloadTask.Callback>> mWeakCallbacks;
    private player.wellnesssolutions.com.services.download.DownloadData mDownloadData;
    private java.lang.String mCookieValue;
    private java.lang.String mReason = "";
    private long mFileLength = 0L;
    private long mAvailableSpace = 0L;
    private java.io.File savedFile;
    private java.net.HttpURLConnection connection;
    private java.io.InputStream input;
    private java.io.OutputStream output;
    private com.google.android.exoplayer2.upstream.crypto.AesCipherDataSink aesCipherDataSink;
    private boolean isFirstDownloadTask = true;
    public static final int CODE_START = -10;
    public static final int CODE_COMPLETED = -100;
    public static final int CODE_FAILED = -200;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_NO_URL = "No downloaded url";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_CANCEL = "Download task is canceled";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_FILE_DOWNLOAD_EXIST = "The downloaded file is exist";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_NETWORK_DISCONNECTED = "Network disconnected";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_INSUFFICIENT_SPACE = "Insufficient space";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_UNKNOWN = "Error unknown";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.download.DownloadTask.Companion Companion = null;
    
    public final void addListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.download.DownloadTask.Callback callback) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.Integer doInBackground(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.download.DownloadData... params) {
        return null;
    }
    
    @java.lang.Override()
    protected void onProgressUpdate(@org.jetbrains.annotations.NotNull()
    java.lang.Integer... values) {
    }
    
    @java.lang.Override()
    protected void onPostExecute(@org.jetbrains.annotations.Nullable()
    java.lang.Integer result) {
    }
    
    private final int saveFileInternal(player.wellnesssolutions.com.services.download.DownloadData downloadData) {
        return 0;
    }
    
    private final int saveFileExternal(player.wellnesssolutions.com.services.download.DownloadData downloadData) {
        return 0;
    }
    
    private final void closeAll() {
    }
    
    private final void closeInAndConn() {
    }
    
    private final boolean isNetworkDisconnected() {
        return false;
    }
    
    public DownloadTask(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.com.services.download.DownloadTask.Callback callback) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\bJ3\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\bJ)\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lplayer/wellnesssolutions/com/services/download/DownloadTask$Callback;", "", "onDownloadCompleted", "", "id", "", "name", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "onDownloadFailed", "reason", "url", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDownloadStarted", "onDownloadUpdate", "progress", "(Ljava/lang/Integer;Ljava/lang/String;I)V", "onInsufficientSpace", "videoId", "availableSpace", "", "fileSize", "(Ljava/lang/Integer;Ljava/lang/String;JJ)V", "app_debug"})
    public static abstract interface Callback {
        
        public abstract void onDownloadStarted(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.String name);
        
        public abstract void onDownloadUpdate(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, int progress);
        
        public abstract void onDownloadFailed(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String reason, @org.jetbrains.annotations.Nullable()
        java.lang.String url);
        
        public abstract void onDownloadCompleted(@org.jetbrains.annotations.Nullable()
        java.lang.Integer id, @org.jetbrains.annotations.Nullable()
        java.lang.String name);
        
        public abstract void onInsufficientSpace(@org.jetbrains.annotations.Nullable()
        java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
        java.lang.String name, long availableSpace, long fileSize);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lplayer/wellnesssolutions/com/services/download/DownloadTask$Companion;", "", "()V", "CODE_COMPLETED", "", "CODE_FAILED", "CODE_START", "ERR_CANCEL", "", "ERR_FILE_DOWNLOAD_EXIST", "ERR_INSUFFICIENT_SPACE", "ERR_NETWORK_DISCONNECTED", "ERR_NO_URL", "ERR_UNKNOWN", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}