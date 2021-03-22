package player.wellnesssolutions.com.common.utils

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized

object DialogUtil {
    fun createDialogOnlyOneButton(context: Context, @StringRes msgResId: Int,
                                  @StringRes titleButton: Int, dialogClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val msg = context.getString(msgResId)

        return createDialogOnlyOneButton(context, msg, titleButton, dialogClickListener)
    }

    fun createDialogOnlyOneButton(context: Context, @StyleRes style: Int,
                                  message: String, @StringRes titleButton: Int,
                                  dialogClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val primaryColor = SharedPreferencesCustomized
                .getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        var color : Int?
        color = try {
            Color.parseColor(primaryColor)
        } catch (e : Exception) {
            e.printStackTrace()
            Color.RED
        }


        val dialog =
                AlertDialog.Builder(context, style)
                        .setMessage(message)
                        .setCancelable(true)
                        .setPositiveButton(titleButton, dialogClickListener).create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }

    fun createDialogOnlyOneButton(context: Context, @StyleRes style: Int,
                                  @StringRes titleRes: Int, @StringRes messageRes: Int,
                                  @StringRes titleButton: Int, dialogClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val title = context.getString(titleRes)
        val message = context.getString(messageRes)

        return createDialogOnlyOneButton(context, style, title, message, titleButton, dialogClickListener)
    }

    fun createDialogOnlyOneButton(context: Context, @StyleRes style: Int?,
                                  title: String?, message: String, @StringRes titleButton: Int,
                                  dialogClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val primaryColor = SharedPreferencesCustomized
                .getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        val color = Color.parseColor(primaryColor)

        val builder: AlertDialog.Builder =
                when (style != null) {
                    true -> AlertDialog.Builder(context, style)
                    false -> AlertDialog.Builder(context)
                }
        if (!title.isNullOrEmpty()) builder.setTitle(title)

        val dialog = builder.setMessage(message)
                .setCancelable(true)
                .setPositiveButton(titleButton, dialogClickListener).create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }

    fun createDialogOnlyOneButton(context: Context, message: String, @StringRes titleButton: Int,
                                  dialogClickListener: DialogInterface.OnClickListener?): AlertDialog {
        val primaryColor = SharedPreferencesCustomized
                .getInstance(context).getString(SPrefConstant.PRIMARY_COLOR, "#00c3b3")
        val color: Int?
        color = try {
            Color.parseColor(primaryColor)
        } catch (e: Exception) {
            Color.parseColor("#00c3b3")
        }

        val dialog =
                AlertDialog.Builder(context)
                        .setMessage(message)
                        .setCancelable(true)
                        .setPositiveButton(titleButton, dialogClickListener).create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }

    fun createDialogOnlyOneButton(context: Context, message: String,
                                  @StringRes titleButton: Int, dialogClickListener: DialogInterface.OnClickListener?,
                                  buttonColor: Int): AlertDialog {
        val dialog =
                AlertDialog.Builder(context)
                        .setMessage(message)
                        .setCancelable(true)
                        .setPositiveButton(titleButton, dialogClickListener).create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(buttonColor)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }

    fun createDialogOnlyOneButton(context: Context, @StyleRes style: Int, message: String, isCancelable: Boolean): AlertDialog {
        val primaryColor = SharedPreferencesCustomized
                .getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        val color = Color.parseColor(primaryColor)

        val dialog =
                AlertDialog.Builder(context, style)
                        .setMessage(message)
                        .setCancelable(isCancelable)
                        .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }

    fun createDialogTwoButtons(context: Context, message: String, @StringRes titleLeftButton: Int,
                               leftButtonClickListener: DialogInterface.OnClickListener?,
                               @StringRes titleRightButton: Int, rightButtonClickListener: DialogInterface.OnClickListener?,
                               isCancelable: Boolean = true): AlertDialog {
        val primaryColor = SharedPreferencesCustomized
                .getInstance(context).getString(SPrefConstant.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)
        val color = Color.parseColor(primaryColor)

        val dialog =
                AlertDialog.Builder(context)
                        .setMessage(message)
                        .setCancelable(isCancelable)
                        .setNegativeButton(titleLeftButton, leftButtonClickListener)
                        .setPositiveButton(titleRightButton, rightButtonClickListener).create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color)
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(color)
        }
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_dialog)

        return dialog
    }
}