package player.wellnesssolutions.com.base.view

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import player.wellnesssolutions.com.base.utils.CommonUtility
import player.wellnesssolutions.com.common.constant.Constant.DEVICE_IS_INACTIVE
import player.wellnesssolutions.com.common.constant.Constant.DEVICE_NOT_FOUND
import player.wellnesssolutions.com.common.constant.Constant.FAILED_TO_CONNECT
import player.wellnesssolutions.com.common.constant.Constant.HEADER_X_DEVICE_NOT_FOUND
import player.wellnesssolutions.com.common.constant.Constant.UNAUTHENTICATED
import player.wellnesssolutions.com.common.constant.Constant.YOUR_ACCOUNT_IS_INACTIVE
import player.wellnesssolutions.com.network.models.response.ResponseValue
import retrofit2.Response


abstract class BaseResponseObserver<T> : Observer<Response<ResponseValue<T>>> {
    companion object {
        const val MSG_NOT_FOUND_API = "Cannot connect to the server. Please check network and try again."
        const val MSG_REQUEST_FAILED = "Request failed !"
    }

    protected val disposable = CompositeDisposable()
    private var response: Response<ResponseValue<T>>? = null
    private var requestError: Throwable? = null

    override fun onComplete() {
        response = null
        requestError = null
    }

    override fun onSubscribe(d: Disposable) {
        disposable.add(d)
    }

    override fun onNext(response: Response<ResponseValue<T>>) {
//        Log.d("LOG", this.javaClass.simpleName + " onNext() | error body message: ${response.errorBody()?.string()} | " +
//                "body message ${response.body()?.message} | code: ${response.code()}")
        this.response = response
        val strBodyError = response.errorBody()?.string()
        val bodyError = CommonUtility.getErrorBody(strBodyError)
//        Log.d("LOG", this.javaClass.simpleName + " onNext() | code: ${response.code()} | messageError: $strBodyError | messageBody: ${response.body()?.message}")
        val messageError = bodyError?.message

        when {
            response.code() == 200 -> {
                onResponseSuccess(response.body())
            }

            response.code() == 401 -> {
                onUnAuthorized()
            }

            response.body() != null -> {
                handleResponseMessage(code = response.code(), message = response.body()?.message)
            }

            messageError.isNullOrBlank() -> onResponseFailed(code = response.code(), message = MSG_NOT_FOUND_API)

            else -> handleErrorMessage(code = response.code(), message = messageError)
        }

        onComplete()
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
//        Log.d("LOG", this.javaClass.simpleName + " onError() | message: ${e.message} | exception: ${e.printStackTrace()}")
        this.requestError = e
        when (e.message?.toLowerCase()?.contains("failed to connect to")) {
            true -> {
                onRequestError("Failed to connect to server")
            }
            false -> onRequestError("Request failed")
        }

        onComplete()
    }

    // onError()
    protected open fun onRequestError(message: String?) {

    }

    protected open fun onResponseSuccess(data: ResponseValue<T>?) {

    }

    private fun handleResponseMessage(code: Int, message: String?) {
        if (message != null)
            handleErrorMessage(code, message)
        else
            onResponseFailed(code = code, message = null)
    }

    private fun handleErrorMessage(code: Int, message: String) {
//        Log.d("LOG", this.javaClass.simpleName + " handleErrorMessage() | message: $message")
        when (message) {
            HEADER_X_DEVICE_NOT_FOUND, YOUR_ACCOUNT_IS_INACTIVE,
            DEVICE_NOT_FOUND, DEVICE_IS_INACTIVE
            -> onExpired(message)

            UNAUTHENTICATED -> onExpiredUnauthenticated(message)

            else -> {
//                Log.d("LOG", this.javaClass.simpleName + " handleErrorMessage() | case default")
                when (message.toLowerCase().contains(FAILED_TO_CONNECT)) {
                    true -> {
                        onResponseFailed(code, "Failed to connect to server")
                    }
                    false -> onResponseFailed(code, message)
                }
            }
        }
    }

    // the final false/failed function would be called
    protected open fun onResponseFailed(code: Int, message: String?) {}

    protected open fun onUnAuthorized() {}

    abstract fun onExpired(error: String)

    abstract fun onExpiredUnauthenticated(error: String)

    protected fun hasCached(): Boolean = response != null || requestError != null

    protected fun disposeCached() {
        this.response = null
        this.requestError = null
    }
}

enum class CACHE_RESPONSE(private val state: String){
    EMPTY("EMPTY"),
    RESPONSE_SUCCESS("RESPONSE_SUCCESS"),
    REQUEST_ERROR("RESQUEST_ERROR"),
    RESPONSE_FAILED("RESPONSE_FAILED"),
    UNAUTHORIZIED("UNAUTHORIZIED"),
    EXPIRED("ON_EXPIRED"),
    EXPIRED_UNAUTHENTICATION("ON_EXPIRED_UNAUTHENTICATION")
}