package player.wellnesssolutions.com.base.view

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.MainActivity

abstract class BaseFragment : Fragment(), ILifeCycle.View {
    protected var mIsJustBeDestroyed = false
    protected val handler = Handler(Looper.getMainLooper())

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

    protected fun playVideoPresentationable(scheduleVideos: ArrayList<MMVideo>): Boolean {
//        Log.d("LOG", this.javaClass.simpleName + " playVideoPresentationable() | scheduled videos number: ${scheduleVideos.size}")
        activity?.also { activity ->
            if (activity is MainActivity && activity.isPresentationAvailable() == true) {
//                Log.d("LOG", this.javaClass.simpleName + " playVideoPresentationable() | casting...")
                activity.playVideo(PlayMode.SCHEDULE, scheduleVideos)
                return true
            }
        }
        return false
    }

    override fun getFragment(): Fragment = this

    override fun getViewContext(): Context? = context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("LOG", this.javaClass.simpleName + " onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Log.d("LOG", this.javaClass.simpleName + " onCreateView()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        Log.d("LOG", this.javaClass.simpleName + " onActivityCreated()")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        Log.d("LOG", this.javaClass.simpleName + " onAttach()")
    }

    override fun onStart() {
        super.onStart()
//        Log.d("LOG", this.javaClass.simpleName + " onStart()")
    }

    override fun onResume() {
        super.onResume()
//        Log.d("LOG", this.javaClass.simpleName + " onResume()")
    }

    override fun onPause() {
        super.onPause()
//        Log.d("LOG", this.javaClass.simpleName + " onPause()")
    }

    override fun onStop() {
        super.onStop()
//        Log.d("LOG", this.javaClass.simpleName + " onStop()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        Log.d("LOG", this.javaClass.simpleName + " onSaveInstanceState()")
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
//        Log.d("LOG", this.javaClass.simpleName + " onDestroyOptionsMenu()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        Log.d("LOG", this.javaClass.simpleName + " onDestroyView()")
        mIsJustBeDestroyed = true
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
//        Log.d("LOG", this.javaClass.simpleName + " onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
//        Log.d("LOG", this.javaClass.simpleName + " onDetach()")
    }

}