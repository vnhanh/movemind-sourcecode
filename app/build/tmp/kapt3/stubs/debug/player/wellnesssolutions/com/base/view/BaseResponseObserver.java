package player.wellnesssolutions.com.base.view;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00030\u0002:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0004J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001c\u0010\u0018\u001a\u00020\u000e2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0014J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\u001e\u001a\u00020\u000e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0014J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000eH\u0014J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver;", "T", "Lio/reactivex/Observer;", "Lretrofit2/Response;", "Lplayer/wellnesssolutions/com/network/models/response/ResponseValue;", "()V", "mCompoDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompoDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "requestError", "", "response", "disposeCached", "", "hasCached", "", "onComplete", "onError", "e", "onExpired", "error", "", "onExpiredUnauthenticated", "onNext", "onRequestError", "message", "onResponseFalse", "code", "", "onResponseSuccess", "data", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "onUnAuthorized", "processErrorMessage", "receivedResponseFalse", "body", "Lplayer/wellnesssolutions/com/network/models/response/ErrorBody;", "Companion", "app_debug"})
public abstract class BaseResponseObserver<T extends java.lang.Object> implements io.reactivex.Observer<retrofit2.Response<player.wellnesssolutions.com.network.models.response.ResponseValue<T>>> {
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.disposables.CompositeDisposable mCompoDisposable = null;
    private retrofit2.Response<player.wellnesssolutions.com.network.models.response.ResponseValue<T>> response;
    private java.lang.Throwable requestError;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG_NOT_FOUND_API = "Cannot connect to the server. Please check network and try again.";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MSG_REQUEST_FAILED = "Request failed !";
    @org.jetbrains.annotations.NotNull()
    public static final player.wellnesssolutions.com.base.view.BaseResponseObserver.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    protected final io.reactivex.disposables.CompositeDisposable getMCompoDisposable() {
        return null;
    }
    
    @java.lang.Override()
    public void onComplete() {
    }
    
    @java.lang.Override()
    public void onSubscribe(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable d) {
    }
    
    @java.lang.Override()
    public void onNext(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<player.wellnesssolutions.com.network.models.response.ResponseValue<T>> response) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable e) {
    }
    
    protected void onRequestError(@org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    protected void onResponseSuccess(@org.jetbrains.annotations.Nullable()
    player.wellnesssolutions.com.network.models.response.ResponseValue<T> data) {
    }
    
    private final void receivedResponseFalse(int code, java.lang.String message) {
    }
    
    private final void receivedResponseFalse(int code, player.wellnesssolutions.com.network.models.response.ErrorBody body) {
    }
    
    private final void processErrorMessage(int code, java.lang.String message) {
    }
    
    protected void onResponseFalse(int code, @org.jetbrains.annotations.Nullable()
    java.lang.String message) {
    }
    
    protected void onUnAuthorized() {
    }
    
    public abstract void onExpired(@org.jetbrains.annotations.NotNull()
    java.lang.String error);
    
    public abstract void onExpiredUnauthenticated(@org.jetbrains.annotations.NotNull()
    java.lang.String error);
    
    protected final boolean hasCached() {
        return false;
    }
    
    protected final void disposeCached() {
    }
    
    public BaseResponseObserver() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lplayer/wellnesssolutions/com/base/view/BaseResponseObserver$Companion;", "", "()V", "MSG_NOT_FOUND_API", "", "MSG_REQUEST_FAILED", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}