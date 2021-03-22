package player.wellnesssolutions.com.ui.activity_scan_barcode

//import android.support.annotation.RequiresApi
//import android.support.v4.app.ActivityCompat
//import android.support.v4.app.Fragment
//import android.support.v4.content.ContextCompat
//import android.support.v7.app.AppCompatActivity

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import kotlinx.android.synthetic.main.activity_scan_bar_code.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.ui.activity_main.MainActivity


class ScanBarCodeActivity : AppCompatActivity(), ScanBarCodeContract.View, BarcodeCallback {
    private lateinit var presenter: ScanBarCodeContract.Presenter

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermissionDrawOnTop(): Boolean {
        if (!Settings.canDrawOverlays(this)) {
            val dialog = DialogUtil.createDialogOnlyOneButton(this, R.string.draw_over_other, R.string.btn_ok,
                    DialogInterface.OnClickListener { _, _ ->
                        val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                Uri.parse("package:$packageName"))
                        startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE)
                    })
            dialog.setCancelable(false)
            dialog.show()
            return false
        }
        return true
    }

    private fun checkPermission(): Boolean {
        return when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED -> {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), PERMISSION_REQUEST)
                false
            }
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED -> {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), PERMISSION_REQUEST)
                false
            }
            ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED -> {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_PHONE_STATE), PERMISSION_REQUEST)
                false
            }
            else -> true
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scan_bar_code)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermissionDrawOnTop()) {
                if (checkPermission()) {
                    zxingBarcodeScanner.decodeContinuous(this)
                }
            }
        } else {
            if (checkPermission()) {
                zxingBarcodeScanner.decodeContinuous(this)
            }
        }


        presenter = ScanBarCodePresenter(this)

        btnExit.setOnClickListener {
            onBackPressed()
        }
    }


    override fun getFragment(): Fragment = Fragment()

    override fun getViewContext(): Context? = this

    override fun getView(): View {
        return content
    }

    override fun onResume() {
        super.onResume()
        //clearAllDataDownload()
        zxingBarcodeScanner.resume()
    }

    override fun onPause() {
        super.onPause()
        zxingBarcodeScanner.pause()
    }

    override fun goToHome() {
        super.goToHome()
        ParameterUtils.isGoToMainActivity = false
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    override fun resumeScan() {
        super.resumeScan()
        zxingBarcodeScanner.resume()
    }

    override fun pauseScan() {
        super.pauseScan()
        zxingBarcodeScanner.pause()

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return zxingBarcodeScanner.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event)
    }

    override fun barcodeResult(result: BarcodeResult?) {
        if (result?.text == null || !presenter.checkFormatBarcode(result.text)) {
            MessageUtils.showSnackBar(getView(), getString(R.string.msg_scan_fail), R.color.red)
            return
        }

        zxingBarcodeScanner.setStatusText(result.text)
        zxingBarcodeScanner.pause()

        presenter.requestActiveDevice(result.text)
    }

    override fun possibleResultPoints(resultPoints: MutableList<ResultPoint>?) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkPermissionDrawOnTop()) {
                        checkPermission()
                    }
                }
            }
            else -> {
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST -> {
                if ((grantResults.isNotEmpty() && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    zxingBarcodeScanner.decodeContinuous(this)
                }
                checkPermission()
            }
            else -> {
            }
        }
    }

    companion object {
        //    private lateinit var beepManager: BeepManager
        private const val PERMISSION_REQUEST = 101
        private const val ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 102
    }
}
