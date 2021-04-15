package player.wellnesssolutions.com.base.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView

object ViewUtil {
    fun setupButton(button: View?, func: () -> Unit) {
        if (button == null) return

        button.setOnClickListener {
            it.isEnabled = false

            func()

            it.isEnabled = true
        }
    }

    fun <T> setupButton(button: View?, func: (T) -> Unit, param: T?) {
        if (button == null || param == null) return

        button.setOnClickListener {
            it.isEnabled = false

            func(param)

            it.isEnabled = true
        }
    }

    fun <T, V> setupButton(button: View?, func: (T, V) -> Unit, p1: T, p2: V) {
        if (button == null) return

        button.setOnClickListener {
            it.isEnabled = false
            func(p1, p2)
            it.isEnabled = true
        }
    }

    fun setupOnClicked(view: View?, listener: View.OnClickListener) {
        if (view == null) return

        view.setOnClickListener {
            it.isEnabled = false
            listener.onClick(it)
            it.isEnabled = true
        }
    }

    fun showRefreshView(icRefresh: ImageView?, tvRetry: TextView?) {
        if (icRefresh?.visibility != View.VISIBLE) icRefresh?.visibility = View.VISIBLE

        if (tvRetry?.visibility != View.VISIBLE) tvRetry?.visibility = View.VISIBLE
    }

    fun hideRefreshView(icRefresh: ImageView?, tvRetry: TextView?) {
        if (icRefresh?.visibility != View.GONE) icRefresh?.visibility = View.GONE

        if (tvRetry?.visibility != View.GONE) tvRetry?.visibility = View.GONE
    }
}