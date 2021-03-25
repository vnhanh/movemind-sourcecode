package player.wellnesssolutions.com.services.download;

import java.lang.System;

/**
 * This manager class contain a queue download data and manage download work
 * It download one by one until the queue is empty
 * When download task completed, its download data would be removed from the queue
 * If network interrupted while download task running, this manager would restart downloading once network reconnect
 * If download data invalid, they would be deleted and the manager start the next download task (if exist)
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b-\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000eJ4\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020\u001bJ \u0010&\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0016H\u0002J\u0006\u0010*\u001a\u00020\u001bJ:\u0010+\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J:\u0010.\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00132\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u00102\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J\u0015\u00104\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u00105J\u001a\u00106\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010\'\u001a\u00020\u0007H\u0002J\"\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u000b2\b\b\u0002\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u000bH\u0016J!\u0010>\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0002\u0010?J3\u0010@\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010A\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0002\u0010BJ!\u0010C\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0002\u0010?J)\u0010D\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010E\u001a\u00020\u0016H\u0016\u00a2\u0006\u0002\u0010FJ1\u0010G\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0016\u00a2\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010M\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000eJ\b\u0010N\u001a\u00020\u001bH\u0002J\b\u0010O\u001a\u00020\u001bH\u0002J\b\u0010P\u001a\u00020\u001bH\u0002J\b\u0010Q\u001a\u00020\u001bH\u0002J\u0006\u0010R\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b`\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006T"}, d2 = {"Lplayer/wellnesssolutions/com/services/download/DownloadManagerCustomized;", "Lplayer/wellnesssolutions/com/services/download/DownloadTask$Callback;", "Lplayer/wellnesssolutions/com/network/network_connect/NetworkReceiver$IStateListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCookieValue", "", "mDownloadTask", "Lplayer/wellnesssolutions/com/services/download/DownloadTask;", "mIsDownloading", "", "mListeners", "Ljava/util/ArrayList;", "Lplayer/wellnesssolutions/database/manager/IProgressListener;", "Lkotlin/collections/ArrayList;", "mNotiManager", "Lplayer/wellnesssolutions/com/services/notification/DownloadNotification;", "mQueue", "Lplayer/wellnesssolutions/com/services/download/DownloadData;", "mQueueMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mWeakContext", "Ljava/lang/ref/WeakReference;", "addDownloadTask", "", "downloadData", "addListener", "listener", "addTask", "videoId", "url", "name", "folder", "hasPermission", "cancelDownloadService", "checkIfFileExist", "fileName", "path", "checkIfTaskExist", "clearQueue", "createDownloadTask", "fileNameDownload", "nameShowFile", "createDownloadTaskInternal", "deleteFileIfExist", "getDownloadDataByVideoId", "id", "getSavedFileName", "extension", "isDownloading", "(Ljava/lang/Integer;)Z", "nextDownload", "notifyDownloadCannotStart", "notifyDownloadCompleted", "data", "isSuccess", "message", "onChangedState", "isConnected", "onDownloadCompleted", "(Ljava/lang/Integer;Ljava/lang/String;)V", "onDownloadFailed", "reason", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDownloadStarted", "onDownloadUpdate", "progress", "(Ljava/lang/Integer;Ljava/lang/String;I)V", "onInsufficientSpace", "availableSpace", "", "fileSize", "(Ljava/lang/Integer;Ljava/lang/String;JJ)V", "release", "removeListener", "resetData", "resetDataNotDelete", "startDownload", "startDownloadIfIdle", "stopNotify", "Companion", "app_debug"})
public final class DownloadManagerCustomized implements player.wellnesssolutions.com.services.download.DownloadTask.Callback, player.wellnesssolutions.com.network.network_connect.NetworkReceiver.IStateListener {
    private java.lang.String mCookieValue;
    private java.lang.ref.WeakReference<android.content.Context> mWeakContext;
    private player.wellnesssolutions.com.services.download.DownloadTask mDownloadTask;
    private final java.util.ArrayList<player.wellnesssolutions.com.services.download.DownloadData> mQueue = null;
    private final java.util.HashMap<java.lang.Integer, java.lang.Boolean> mQueueMap = null;
    private final java.util.ArrayList<player.wellnesssolutions.database.manager.IProgressListener> mListeners = null;
    private boolean mIsDownloading = false;
    private final player.wellnesssolutions.com.services.notification.DownloadNotification mNotiManager = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ERR_USER_CANCEL = "The downloaded file has been canceled !";
    private static player.wellnesssolutions.com.services.download.DownloadManagerCustomized INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.services.download.DownloadManagerCustomized.Companion Companion = null;
    
    public final void cancelDownloadService() {
    }
    
    @java.lang.Override()
    public void onChangedState(boolean isConnected) {
    }
    
    @java.lang.Override()
    public void onDownloadStarted(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    @java.lang.Override()
    public void onDownloadUpdate(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, int progress) {
    }
    
    @java.lang.Override()
    public void onInsufficientSpace(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, long availableSpace, long fileSize) {
    }
    
    @java.lang.Override()
    public void onDownloadFailed(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void onDownloadCompleted(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    /**
     * add, remove listeners and release
     */
    public final void addListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.database.manager.IProgressListener listener) {
    }
    
    public final void removeListener(@org.jetbrains.annotations.NotNull()
    player.wellnesssolutions.database.manager.IProgressListener listener) {
    }
    
    public final boolean isDownloading(@org.jetbrains.annotations.Nullable()
    java.lang.Integer videoId) {
        return false;
    }
    
    public final void release() {
    }
    
    public final void stopNotify() {
    }
    
    public final void addTask(int videoId, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String folder, boolean hasPermission) {
    }
    
    private final void notifyDownloadCannotStart(int videoId, java.lang.String fileName) {
    }
    
    private final void createDownloadTask(int videoId, java.lang.String url, java.lang.String folder, boolean hasPermission, java.lang.String fileNameDownload, java.lang.String nameShowFile) {
    }
    
    private final void createDownloadTaskInternal(int videoId, java.lang.String url, java.lang.String folder, boolean hasPermission, java.lang.String fileNameDownload, java.lang.String nameShowFile) {
    }
    
    private final void checkIfFileExist(int videoId, java.lang.String fileName, java.lang.String path) {
    }
    
    private final boolean checkIfTaskExist(int videoId) {
        return false;
    }
    
    private final void startDownloadIfIdle() {
    }
    
    private final void startDownload() {
    }
    
    private final void addDownloadTask(player.wellnesssolutions.com.services.download.DownloadData downloadData) {
    }
    
    private final void notifyDownloadCompleted(player.wellnesssolutions.com.services.download.DownloadData data, boolean isSuccess, java.lang.String message) {
    }
    
    private final player.wellnesssolutions.com.services.download.DownloadData getDownloadDataByVideoId(int id) {
        return null;
    }
    
    private final void resetData() {
    }
    
    private final void resetDataNotDelete() {
    }
    
    private final void deleteFileIfExist() {
    }
    
    private final void nextDownload(int videoId, java.lang.String name) {
    }
    
    public final void clearQueue() {
    }
    
    private final java.lang.String getSavedFileName(java.lang.String name, java.lang.String extension) {
        return null;
    }
    
    public DownloadManagerCustomized(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lplayer/wellnesssolutions/com/services/download/DownloadManagerCustomized$Companion;", "", "()V", "ERR_USER_CANCEL", "", "INSTANCE", "Lplayer/wellnesssolutions/com/services/download/DownloadManagerCustomized;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final player.wellnesssolutions.com.services.download.DownloadManagerCustomized getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}