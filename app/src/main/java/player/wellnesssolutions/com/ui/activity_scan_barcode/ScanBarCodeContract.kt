package player.wellnesssolutions.com.ui.activity_scan_barcode

import player.wellnesssolutions.com.base.uis.ILifeCycle

interface ScanBarCodeContract {
    interface View : ILifeCycle.View {
        fun getView(): android.view.View
        fun goToHome() {}
        fun resumeScan() {}
        fun pauseScan() {}
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun requestActiveDevice(email: String) {}
        fun checkFormatBarcode(string: String): Boolean {
            return false
        }

        fun login() {}
    }
}