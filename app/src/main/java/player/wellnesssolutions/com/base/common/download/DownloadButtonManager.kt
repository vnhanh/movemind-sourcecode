package player.wellnesssolutions.com.base.common.download

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.webkit.MimeTypeMap
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMImageView
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.common.utils.PermissionModel
import player.wellnesssolutions.com.common.utils.PermissionUtils
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.download.DownloadManagerCustomized
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.database.manager.DownloadDBManager
import player.wellnesssolutions.database.manager.IProgressListener
import java.lang.ref.WeakReference

class DownloadButtonManager : View.OnClickListener, IProgressListener {
    companion object {
        fun checkDownloaded(videoId: Int?): Boolean = DownloadDBManager.getInstance().findData(videoId)
    }

    private var mWeakButtons: ArrayList<WeakReference<MMImageView>> = ArrayList()
    private lateinit var mWeakContext: WeakReference<Context>

    private var mVideo: MMVideo? = null
    private var mIsDownloaded = false

    private var mIsEnable = true
    private val PACKAGE = "player.wellnesssolutions.com.au"

    constructor(btnDownload: MMImageView) {
        mWeakButtons.add(WeakReference(btnDownload))
        mWeakContext = WeakReference(btnDownload.context)
        btnDownload.setOnClickListener(this)
        registerProgressListener(btnDownload.context)
    }

    constructor(vararg btn: MMImageView) {
        if (btn.isNotEmpty()) {
            mWeakContext = WeakReference(btn[0].context)
            registerProgressListener(btn[0].context)
        }

        for (button: MMImageView in btn) {
            mWeakButtons.add(WeakReference(button))
            button.setOnClickListener(this)
        }
    }

    fun setVideoData(data: MMVideo) {
        this.mVideo = data

        mIsDownloaded = checkDownloaded(data.id)
        displayUI()
    }

    /**
     * onClick()
     */
    override fun onClick(view: View) {
        if (!mIsEnable) return

        if (!checkNetworkAvailable()) {
            MessageUtils.showToast(mWeakContext.get(), R.string.network_disconnect_for_downloading, R.color.red)?.show()
            return
        }

        if (mVideo == null || mVideo?.downloadUrl.isNullOrEmpty()) {
            showMessageOnVideoDataNull(view.context)
        } else if (!mIsDownloaded) {
            if (checkDownloading(view.context, mVideo?.id)) {
                showMessageDownloading(view.context)
            } else {
                mIsEnable = false

                // check if download permission and add download task
                view.context?.also { context ->
                    onHandleDownloadOnClicked(context)
                }

                mIsEnable = true
            }
        } else {
            showMessageDownloaded(view.context)
        }
    }

    private fun onHandleDownloadOnClicked(context: Context) {
        if (context is MainActivity) {
            val permissionResult: PermissionModel = PermissionUtils.checkAndRequestWriteExternalPermission(context)

            // change UI for downloading
            if (!permissionResult.hasPermission && permissionResult.isCheckedNeverAskAgain) {
                DialogUtil.createDialogOnlyOneButton(context = context, style = R.style.NormalDialog,
                        titleRes = R.string.title_dialog_download, messageRes = R.string.msg_rationale_no_download_permission,
                        titleButton = R.string.btn_ok, dialogClickListener = DialogInterface.OnClickListener { _, _ -> openAppInformationScreen() }).show()
            } else if (permissionResult.hasPermission) { // has downloaded permission
                when (MimeTypeMap.getFileExtensionFromUrl(mVideo?.downloadUrl).contains(Constant.M3U8)) {
                    true -> {
                        DialogUtil.createDialogOnlyOneButton(context = context, style = R.style.NormalDialog,
                                titleRes = R.string.title_dialog_download, messageRes = R.string.not_download_video_m3u8,
                                titleButton = R.string.btn_ok, dialogClickListener = null).show()
                    }

                    false -> {
                        DownloadVideoHelper.download(context = context, data = mVideo, hasPermission = permissionResult.hasPermission)
                    }
                }
            } else { // denied download permission but not checked "Never ask again"
                PreferenceHelper.getInstance(context).putBoolean(key = ConstantPreference.SS_DOWNLOADED_BUT_NO_PERMISSION, value = true)
            }
        }
    }

    private fun openAppInformationScreen() {
        // open app information screen
        mWeakContext.get()?.also {
            if (it is Activity) {
                try {
                    //Open the specific App Info page:
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    intent.data = Uri.parse("package:$PACKAGE")
                    it.startActivity(intent)

                } catch (e: ActivityNotFoundException) {
                    //e.printStackTrace();
                    //Open the generic Apps page:
                    val intent = Intent(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS)
                    it.startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                    MessageUtils.showToast(it, R.string.cant_open_app_information_screen, R.color.yellow)?.show()
                }
            }
        }
    }

    private fun showMessageOnVideoDataNull(context: Context) {
        if (mWeakButtons.size == 0) return
        mWeakButtons[0].get()?.also { button ->
            MessageUtils.showSnackBar(
                    snackView = button,
                    message = context.getString(R.string.no_download_video_url),
                    colorRes = R.color.red
            )
        }
    }

    @Suppress("DEPRECATION", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    private fun checkNetworkAvailable(): Boolean {
        mWeakContext.get()?.also { context ->
            val cm: ConnectivityManager? = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            return cm?.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
        }
        return false
    }

    /**
     * end onClick()
     */

    private fun showUIAllButtonsDownloading() {
        for (weakButton: WeakReference<MMImageView> in mWeakButtons) {
            weakButton.get()?.also { button ->
                showUIDownloading(button = button)
            }
        }
    }

    private fun showUIDownloading(button: MMImageView) {
        val strTextColor = PreferenceHelper.getInstance(button.context).getString(ConstantPreference.PRIMARY_COLOR,
                Constant.DEF_PRIMARY_COLOR)
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.OVAL
        shape.color =
                when (strTextColor.isNotEmpty()) {
                    true -> ColorStateList.valueOf(Color.parseColor(strTextColor))
                    false -> ColorStateList.valueOf(Color.YELLOW)
                }

        button.background = shape
    }

    private fun showMessageDownloading(context: Context) {
        if (mWeakButtons.size == 0) return

        mWeakButtons[0].get()?.also { button ->
            MessageUtils.showSnackBar(
                    snackView = button,
                    message = context.getString(R.string.msg_downloading_video),
                    colorRes = R.color.yellow,
                    isLongTime = false
            )
        }
    }

    private fun showMessageDownloaded(context: Context) {
        if (mWeakButtons.size == 0) return

        mWeakButtons[0].get()?.also { button ->
            MessageUtils.showSnackBar(
                    snackView = button,
                    message = context.getString(R.string.msg_this_video_downloaded),
                    colorRes = R.color.yellow
            )
        }
    }

    override fun onTaskExist(videoId: Int, fileName: String) {
        if (videoId == mVideo?.id)
            displayUI()
    }


    override fun onDownloadStarted(videoId: Int) {
        if (videoId == mVideo?.id) {
            showUIAllButtonsDownloading()
        }
    }

    override fun onDownloadCannotStart(videoId: Int, fileName: String) {
        if (videoId == mVideo?.id) {
            mIsDownloaded = false
            displayUI()
        }
    }

    override fun onInsufficientSpace(videoId: Int?, fileName: String?, availableSpace: Long, fileLength: Long) {
        super.onInsufficientSpace(videoId, fileName, availableSpace, fileLength)
        if (videoId == mVideo?.id) {
            mIsDownloaded = false
            displayUI()
        }
    }

    override fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String) {
        handleDownloadCompleted(videoId = videoId, isSuccess = isSuccess)
    }

    private fun handleDownloadCompleted(videoId: Int, isSuccess: Boolean) {
        if (videoId == mVideo?.id) {
            mIsDownloaded = isSuccess
            displayDownloadedUI()
        }
    }

    private fun displayDownloadedUI() {
        for (weakButton: WeakReference<MMImageView> in mWeakButtons) {
            weakButton.get()?.also { button ->
                button.setActive(!mIsDownloaded)
            }
        }// end loop mWeakButtons
    }

    fun displayUI() {
        mWeakContext.get()?.also { context ->
            mVideo?.also { data ->
                data.id?.also { videoId ->
                    val isDownloading: Boolean = checkDownloading(context = context, videoId = videoId)

                    for (weakButton: WeakReference<MMImageView> in mWeakButtons) {
                        weakButton.get()?.also { button ->
                            if (isDownloading) {
                                showUIDownloading(button)
                            } else {
                                button.setActive(!mIsDownloaded)
                            }
                        }
                    }// end loop mWeakButtons
                }// end videoId
            }// end mVideo
        }// end mWeakContexts
    }

    private fun checkDownloading(context: Context, videoId: Int?): Boolean =
            DownloadManagerCustomized.getInstance(context).isDownloading(videoId)

    fun release() {
        mVideo = null

        mWeakContext.get()?.also {
            unregisterProgressListener(it)
        }

        for (weakButton: WeakReference<MMImageView> in mWeakButtons) {
            weakButton.clear()
        }
        mWeakButtons.clear()

        mWeakContext.clear()
    }

    private fun registerProgressListener(context: Context) {
        DownloadManagerCustomized.getInstance(context).addListener(this)
    }

    private fun unregisterProgressListener(context: Context) {
        DownloadManagerCustomized.getInstance(context).removeListener(this)
    }

    fun isDownloaded(): Boolean = mIsDownloaded
}