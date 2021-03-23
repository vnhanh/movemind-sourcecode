package player.wellnesssolutions.com.ui.fragment_splash

import androidx.annotation.StringRes
import player.wellnesssolutions.com.base.view.ILifeCycle

interface ISplashContract {
    interface View : ILifeCycle.View {
        fun updateProgress(progress: Int)
        fun navigateToHomeScreen()
        fun onStartLoadApi()
        fun onCallServiceFailed(@StringRes messageRes: Int)
        fun backToScanQRCode()
        fun callGetTokenAgain()
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun loadApi()
    }
}