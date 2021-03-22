package player.wellnesssolutions.com.ui.activity_main

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.services.download.DownloadManagerCustomized
import player.wellnesssolutions.database.manager.IProgressListener
import java.lang.ref.WeakReference

class ActivityDownloadHelper(activity: Activity, view: View) : IProgressListener {
    private val mWeakActivity = WeakReference(activity)
    private val mWeakView = WeakReference(view)


    override fun onDownloadCannotStart(videoId: Int, fileName: String) {
        mWeakActivity.get()?.also { activity ->
            val message = activity.getString(R.string.download_cant_start_because_error, fileName)
            DialogUtil.createDialogOnlyOneButton(activity, message, R.string.btn_ok, null).show()
        }
    }

    override fun onInsufficientSpace(videoId: Int?, fileName: String?, availableSpace: Long, fileLength: Long) {
        mWeakActivity.get()?.also { activity ->
            val message = activity.getString(R.string.download_cant_start_because_insufficient_space, fileName
                    ?: "", availableSpace, fileLength)
            DialogUtil.createDialogOnlyOneButton(activity, message, R.string.btn_ok, null).show()
        }
    }

    override fun onAddTaskFailedBecauseDataNull(videoId: Int) {
        mWeakView.get()?.also {
            MessageUtils.showSnackBar(
                    snackView = it,
                    message = it.context.getString(player.wellnesssolutions.com.network.R.string.error_video_data_null),
                    colorRes = R.color.yellow
            )
        }
    }

    override fun onTaskExist(videoId: Int, fileName: String) {
        mWeakView.get()?.also {
            MessageUtils.showSnackBar(
                    snackView = it,
                    message = it.context.getString(player.wellnesssolutions.com.network.R.string.download_task_already_exists, fileName),
                    colorRes = R.color.yellow
            )
        }
    }

    /**
     * onDownloadCompleted()
     */
    override fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String) {
        when (isSuccess) {
            true -> checkIfShowMessageDownloadSuccess(fileName)
            false -> showMessageDownloadFailed(fileName, message)
        }
    }

    private fun checkIfShowMessageDownloadSuccess(fileName: String?) {
        mWeakView.get()?.also { view ->
            view.post {
                when (SharedPreferencesCustomized.getInstance(view.context).getBoolean(key = SPrefConstant.IS_SHOW_MESSAGE_ALLOWED, defValue = true)) {
                    true -> {
                        showMessageDownloadSuccess(fileName)
                    }
                    false -> {
                        view.postDelayed(object : Runnable {
                            override fun run() {
                                if (SharedPreferencesCustomized.getInstance(view.context).getBoolean(key = SPrefConstant.IS_SHOW_MESSAGE_ALLOWED, defValue = true)) {
                                    showMessageDownloadSuccess(fileName)
                                    view.removeCallbacks(null)
                                } else {
                                    view.postDelayed(this, 200L)
                                }
                            }
                        }, 200L)
                    }
                }
            }
        }
    }

    private fun showMessageDownloadSuccess(fileName: String?) {
        mWeakView.get()?.also { view ->
            val name: String? = getExactFileName(fileName)
            val message: String =
                    when (name.isNullOrEmpty()) {
                        true -> view.resources.getString(player.wellnesssolutions.com.network.R.string.msg_download_video_success_no_file_name)
                        false -> view.resources.getString(player.wellnesssolutions.com.network.R.string.msg_download_video_success, name)
                    }

            MessageUtils.showSnackBar(snackView = view, message = message, colorRes = R.color.white, isLongTime = true, btnRes = R.string.btn_ok)
        }
    }

    private fun showMessageDownloadFailed(fileName: String?, message: String) {
        mWeakView.get()?.also { view ->
            val name: String? = getExactFileName(fileName)
            val msg: String =
                    when (message.isEmpty()) {
                        true -> {
                            when (name.isNullOrEmpty()) {
                                true -> getString(player.wellnesssolutions.com.network.R.string.download_failed_no_file_name)
                                false -> view.context.getString(player.wellnesssolutions.com.network.R.string.msg_download_video_failed, name)
                            }
                        }
                        false -> view.context.getString(player.wellnesssolutions.com.network.R.string.msg_download_video_failed_with_reason, name, message)
                    }

            MessageUtils.showSnackBar(
                    snackView = view,
                    message = msg,
                    colorRes = R.color.red,
                    isLongTime = true,
                    btnRes = R.string.btn_ok,
                    btnColor = ContextCompat.getColor(view.context, R.color.red)
            )
        }
    }

    private fun getExactFileName(fileName: String?): String? {
        val index: Int? = fileName?.lastIndexOf(Constant.DASH)
        return when (fileName.isNullOrEmpty() || index == null) {
            true -> null
            false -> when (index > -1) {
                true -> fileName.substring(0, index)
                false -> fileName
            }
        }
    }

    /**
     * end onDownloadCompleted()
     */

    private fun getString(@StringRes msgRes: Int): String = mWeakActivity.get()?.getString(msgRes)
            ?: Constant.EMPTY

    fun release() {
        mWeakActivity.get()?.also { activity ->
            DownloadManagerCustomized.getInstance(activity).removeListener(this)
        }

        mWeakView.clear()
        mWeakActivity.clear()
    }
}