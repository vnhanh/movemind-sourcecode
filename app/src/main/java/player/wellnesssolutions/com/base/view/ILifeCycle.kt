package player.wellnesssolutions.com.base.view

import android.content.Context
import androidx.fragment.app.Fragment

interface ILifeCycle {
    interface View {
        fun getFragment(): Fragment
        fun getViewContext(): Context?
    }

    interface Presenter<V : View> {
        fun onAttach(view: V)
        fun onDetach()
        fun onStop() {}
        fun onDestroy()
    }
}