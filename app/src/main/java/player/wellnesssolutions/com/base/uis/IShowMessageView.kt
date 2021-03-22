package player.wellnesssolutions.com.base.uis

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

interface IShowMessageView {
    fun showMessage(@StringRes messageRes: Int, @ColorRes color: Int) {}

    fun showMessage(message: String, @ColorRes color: Int) {}
}