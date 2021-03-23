package player.wellnesssolutions.com.base.view

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.fragment.app.Fragment
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.ui.activity_main.MainActivity

abstract class BaseFragment : Fragment(), ILifeCycle.View{
    protected var mIsJustBeDestroyed = false

    protected open fun onBackPressed(view: View) {
        view.isEnabled = false
        FragmentUtil.onBackPressedActivity(activity)
    }

    open fun onExpired(message: String) {
        context?.also { context ->
            val msgBuilder = StringBuilder(message)
            msgBuilder.append("\n\n")
            msgBuilder.append(context.getString(R.string.confirm_want_to_return_screen_scan_bar_code))

            onReturnScanBarCodeScreen(msgBuilder.toString())
        }
    }

    private fun onReturnScanBarCodeScreen(message: String) {
        context?.also { context ->
            val okButtonListener = DialogInterface.OnClickListener { _, _ -> returnScreenScanBarCode() }
            val dialog = DialogUtil.createDialogOnlyOneButton(context, message, R.string.btn_ok, okButtonListener)
            dialog.setCancelable(false)
            dialog.show()
        }
    }

    private fun returnScreenScanBarCode() {
        activity?.also { act ->
            if (act is MainActivity) {
                act.openScanBarCodeScreen()
            }
        }
    }

    open fun onExpiredUnAuth(message: String) {
        context?.also { context ->
            val msgBuilder = StringBuilder(message)
            msgBuilder.append("\n\n")
            msgBuilder.append(context.getString(R.string.confirm_want_to_return_home_screen))

            onReturnHomeScreen(msgBuilder.toString())
        }
    }

    private fun onReturnHomeScreen(message: String) {
        context?.also { context ->
            val okButtonListener = DialogInterface.OnClickListener { _, _ -> returnHomeScreen() }
            val dialog = DialogUtil.createDialogOnlyOneButton(context, message, R.string.btn_ok, okButtonListener)
            dialog.setCancelable(false)
            dialog.show()
        }
    }

    private fun returnHomeScreen() {
        activity?.also { act ->
            if (act is MainActivity) {
                act.getTokenAgainWhenTokenExpire(object : IGetNewToken {
                    override fun onGetSuccess() {
                        //Todo
                    }
                })
                act.navigateToHomeScreen()
            }
        }
    }

    override fun getFragment(): Fragment = this

    override fun getViewContext(): Context? = context

    override fun onDestroyView() {
        super.onDestroyView()
        mIsJustBeDestroyed = true
    }

}