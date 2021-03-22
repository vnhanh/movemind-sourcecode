package player.wellnesssolutions.com.base.uis

import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import player.wellnesssolutions.com.base.utils.CommonUtility
import player.wellnesssolutions.com.network.models.response.ErrorBody
import player.wellnesssolutions.com.network.models.response.ResponseValue
import retrofit2.Response


abstract class BaseResponseObserver<T> : Observer<Response<ResponseValue<T>>> {
    companion object {
        const val MSG_NOT_FOUND_API = "Cannot connect to the server. Please check network and try again."
        const val MSG_REQUEST_FAILED = "Request failed !"
    }

    protected val mCompoDisposable = CompositeDisposable()
    private var response: Response<ResponseValue<T>>? = null
    private var requestError: Throwable? = null

    override fun onComplete() {
        response = null
        requestError = null
    }

    override fun onSubscribe(d: Disposable) {
        mCompoDisposable.add(d)
    }

    override fun onNext(response: Response<ResponseValue<T>>) {
        this.response = response

        if (response.code() == 200) {
            onResponseSuccess(response.body())
        } else {
            when (response.body() != null) {
                true -> {
                    receivedResponseFalse(code = response.code(), message = response.body()?.message)
                }
                else -> {
                    val errorBody = CommonUtility.getErrorBody(response.errorBody())

                    if (errorBody?.message != null)
                        receivedResponseFalse(code = response.code(), body = errorBody)
                    else
                        onResponseFalse(code = response.code(), message = MSG_NOT_FOUND_API)
                }
            }
        }
    }

    override fun onError(e: Throwable) {
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

    private fun receivedResponseFalse(code: Int, message: String?) {
        if (message != null)
            processErrorMessage(code, message)
        else
            onResponseFalse(code = code, message = null)
    }

    private fun receivedResponseFalse(code: Int, body: ErrorBody) {
        processErrorMessage(code, body.message!!)
    }

    private fun processErrorMessage(code: Int, message: String) {
        when (message) {
            "Header X-Device not found.", "Your account is inactive.",
            "Device not found.", "Device is inactive."
            -> onExpired(message)

            "Unauthenticated." -> onExpiredUnauthenticated(message)

            else -> {
                when (message.toLowerCase().contains("failed to connect to")) {
                    true -> {
                        onResponseFalse(code, "Failed to connect to server")
                    }
                    false -> onResponseFalse(code, message)
                }
            }
        }
        onComplete()
    }

    // the final false/failed function would be called
    protected open fun onResponseFalse(code: Int, message: String?) {}

    abstract fun onExpired(error: String)

    abstract fun onExpiredUnauthenticated(error: String)

    protected fun hasCached(): Boolean = response != null || requestError != null

    protected fun disposeCached() {
        this.response = null
        this.requestError = null
    }
}