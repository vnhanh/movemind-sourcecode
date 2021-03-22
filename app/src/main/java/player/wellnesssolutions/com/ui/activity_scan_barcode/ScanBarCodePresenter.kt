package player.wellnesssolutions.com.ui.activity_scan_barcode

import android.annotation.SuppressLint
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.application.MyApplication
import player.wellnesssolutions.com.base.uis.BaseResponseObserver
import player.wellnesssolutions.com.base.utils.CommonUtility
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.login.LoginApi
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.login.MMCookie
import player.wellnesssolutions.com.network.models.login.MMLoginResponseData
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.models.scan_bar_code.MMQRCodeResponse
import java.util.*

class ScanBarCodePresenter(private val mView: ScanBarCodeContract.View) : ScanBarCodeContract.Presenter, BaseResponseObserver<Any>() {

    private var loginService: LoginApi = LoginApi()
    private var mPref: SharedPreferencesCustomized? = SharedPreferencesCustomized.getInstance(mView.getViewContext()!!)

    private fun storeInformation(body: MMQRCodeResponse) {
        mPref?.also { sharedPref ->
            sharedPref.putString(SPrefConstant.EMAIL, body.email ?: "").save()
            sharedPref.putString(SPrefConstant.PASSWORD, body.loginToken ?: "").save()
            sharedPref.putString(SPrefConstant.DEVICE_ID, body.deviceId ?: "").save()
        }
    }

    private fun storeBranding(token: String, branding: MMBranding) {
        mPref?.also { sharedPref ->
            sharedPref.putString(SPrefConstant.TOKEN, token)
//        mPref.putString(SPrefConstant.SS_BOTTOM_BAR_COLOR, "#041e41")
//        mPref.putString(SPrefConstant.PRIMARY_COLOR, "#00c3b3")
//        mPref.putString(SPrefConstant.SECONDARY_COLOR, "#FFFFFF")
            sharedPref.putString(SPrefConstant.SS_BOTTOM_BAR_COLOR, branding.bottomBarColor ?: "")
            sharedPref.putString(SPrefConstant.PRIMARY_COLOR, branding.primaryColor ?: "")
            sharedPref.putString(SPrefConstant.SECONDARY_COLOR, branding.textColor ?: "")
            sharedPref.putString(SPrefConstant.SS_COMPANY_LOGO, branding.companyLogo ?: "")
            sharedPref.putStrings(SPrefConstant.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
        }
    }

    override fun onAttach(view: ScanBarCodeContract.View) {

    }

    override fun onDetach() {

    }

    override fun onDestroy() {
        mPref = null
        mCompoDisposable.dispose()
    }

    override fun checkFormatBarcode(string: String): Boolean {
        return string.toIntOrNull() == null
//        return super.checkFormatBarcode(string)
    }

    @SuppressLint("SimpleDateFormat")
    override fun requestActiveDevice(email: String) {
        val response = CommonUtility.getObjectBy<MMQRCodeResponse>(email)

        if (response.time != null) {
            val cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"))

            val timeStamp = response.time!!

            if (((timeStamp * 1000) + ((48 * 60 * 60) * 1000)) > cal.timeInMillis) {
                storeInformation(response)
                val model = CommonUtility.getModelName()
                val avaSpace = CommonUtility.getAvailableInternalMemorySize()
                val totalSpace = CommonUtility.getTotalInternalMemorySize()
                loginService.activeDevice(response.email ?: "", model, response.deviceId
                        ?: "", avaSpace, totalSpace)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this as BaseResponseObserver<Any>)
            } else {
                Toast.makeText(mView.getViewContext()!!, R.string.qr_expired, Toast.LENGTH_SHORT).show()
                mView.resumeScan()
            }
        } else {
            Toast.makeText(mView.getViewContext()!!, R.string.qr_expired, Toast.LENGTH_SHORT).show()
            mView.resumeScan()
        }

    }

    override fun login() {
        val sharedPref = mPref

        if (sharedPref != null) {
            val email = sharedPref.getString(SPrefConstant.EMAIL, "")
            val password = sharedPref.getString(SPrefConstant.PASSWORD, "")

            val deviceId = sharedPref.getString(SPrefConstant.DEVICE_ID, "")
            loginService.login(email, password, deviceId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this as BaseResponseObserver<MMLoginResponseData>)

        }
    }

    override fun onResponseSuccess(data: ResponseValue<Any>?) {
        super.onResponseSuccess(data)
        when (val response = data?.data) {
            is MMLoginResponseData -> {
                storeBranding(response.token ?: "", response.branding ?: MMBranding())

                (response.cookie)?.also {
                    storeCookie(it)
                }

                mView.goToHome()
            }
            else -> login()
        }
    }

    private fun storeCookie(cookie: MMCookie?) {
        if (cookie == null) return
        val policy = cookie.policy
        val signature = cookie.signature
        val keyPairid = cookie.keyPairId
        mView.getViewContext()?.applicationContext?.also { context ->
            if (context is MyApplication) {
                val builder = StringBuilder()
                builder.append("CloudFront-Policy=").append(policy)
                builder.append(";CloudFront-Signature=").append(signature)
                builder.append(";CloudFront-Key-Pair-Id=").append(keyPairid)

                SharedPreferencesCustomized.getInstance(context).putString(SPrefConstant.SP_COOKIE, builder.toString())
            }
        }
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        MessageUtils.showSnackBar(mView.getView(), message ?: "Error", R.color.red)
        mView.resumeScan()
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        MessageUtils.showSnackBar(mView.getView(), message ?: "Error", R.color.red)
        mView.resumeScan()
    }

    override fun onExpired(error: String) {
        MessageUtils.showSnackBar(mView.getView(), error, R.color.red)
        mView.resumeScan()
    }

    override fun onExpiredUnauthenticated(error: String) {
        MessageUtils.showSnackBar(mView.getView(), error, R.color.red)
        mView.resumeScan()
    }

}
