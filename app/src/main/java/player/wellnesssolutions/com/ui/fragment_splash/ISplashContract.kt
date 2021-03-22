package player.wellnesssolutions.com.ui.fragment_splash

import player.wellnesssolutions.com.base.uis.ILifeCycle

interface ISplashContract {
    interface View : ILifeCycle.View {
        fun updateProgress(progress: Int)
        fun navigateToHomeScreen()
        fun onStartLoadApi()
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun loadApi()
    }
}