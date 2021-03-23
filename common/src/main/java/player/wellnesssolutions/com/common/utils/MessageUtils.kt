package player.wellnesssolutions.com.common.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper

object MessageUtils {
    fun showToast(context: Context?, @StringRes messageRes: Int, @ColorRes colorRes: Int, isLongTime: Boolean = true): Toast? {
        if (context == null) return null

        return showToast(context, context.getString(messageRes), colorRes, isLongTime)
    }

    @SuppressLint("ShowToast")
    fun showToast(context: Context?, string: String, @ColorRes colorRes: Int, isLongTime: Boolean = true): Toast? {
        if (context == null) return null
        val toast = Toast.makeText(context, string, if (isLongTime) Toast.LENGTH_LONG else Toast.LENGTH_SHORT)
        val view1: TextView = toast.view.findViewById(android.R.id.message)
        view1.setTextColor(ContextCompat.getColor(context, colorRes))

        return toast
    }

    fun showSnackBar(snackView: View, @StringRes messageRes: Int, @ColorRes colorRes: Int, isOnPresentation: Boolean = false) {
        showSnackBar(snackView, snackView.resources.getString(messageRes), colorRes, isLongTime = false, isOnPresentation = isOnPresentation)
    }

    fun showSnackBar(snackView: View, message: String, @ColorRes colorRes: Int, isLongTime: Boolean = true, isOnPresentation: Boolean = false) {
        createSnack(snackView = snackView, message = message, colorRes = colorRes, isLongTime = isLongTime, isOnPresentation = isOnPresentation).show()
    }

    fun showSnackBar(snackView: View, message: String, @ColorRes colorRes: Int, @StringRes btnRes: Int, isLongTime: Boolean = true) {
        showSnackBar(
                snackView = snackView,
                message = message,
                colorRes = colorRes,
                isLongTime = isLongTime,
                btnRes = btnRes,
                btnColor = Color.parseColor(PreferenceHelper.getInstance(snackView.context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR))
        )
    }

    fun showSnackBar(snackView: View, @StringRes msgRes: Int, @ColorRes colorRes: Int, @StringRes btnRes: Int, isLongTime: Boolean = true) {
        showSnackBar(
                snackView = snackView,
                message = snackView.context.getString(msgRes),
                colorRes = colorRes,
                isLongTime = isLongTime,
                btnRes = btnRes,
                btnColor = Color.parseColor(PreferenceHelper.getInstance(snackView.context).getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR))
        )
    }

    fun showSnackBar(snackView: View, message: String, @ColorRes colorRes: Int, @StringRes btnRes: Int, btnColor: Int, isLongTime: Boolean = true) {
        val snack = createSnack(snackView = snackView, message = message, colorRes = colorRes, isLongTime = isLongTime)
        snack.setActionTextColor(btnColor)

        snack.setAction(btnRes, object : View.OnClickListener {
            override fun onClick(v: View?) {
                snack.dismiss()
            }
        })

        snack.show()
    }

    private fun createSnack(snackView: View, message: String, @ColorRes colorRes: Int, isLongTime: Boolean = true, isOnPresentation: Boolean = false): Snackbar {
        val snack = Snackbar.make(snackView, message, if (isLongTime) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT)

        val tv: TextView = snack.view.findViewById(com.google.android.material.R.id.snackbar_text)
        tv.setTextColor(ContextCompat.getColor(snackView.context, colorRes))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tv.textAlignment = View.TEXT_ALIGNMENT_CENTER
        } else {
            tv.gravity = Gravity.CENTER_HORIZONTAL
        }

        if (!isOnPresentation) {
            val navigationHeight = getNavigationBarSize(snackView.context).y
            val snackLayout = snack.view as Snackbar.SnackbarLayout
            val params = snackLayout.layoutParams as FrameLayout.LayoutParams
            params.setMargins(0, 0, 0, params.bottomMargin - navigationHeight)
            snackLayout.layoutParams = params
        }

        return snack
    }

    fun getNavigationBarSize(context: Context): Point {
        val appUsableSize = getAppUsableScreenSize(context)
        val realScreenSize = getRealScreenSize(context)
        // navigation bar on the right
        if (appUsableSize.x < realScreenSize.x) {
            return Point(realScreenSize.x - appUsableSize.x, appUsableSize.y);
        }

        // navigation bar at the bottom
        if (appUsableSize.y < realScreenSize.y) {
            return Point(appUsableSize.x, realScreenSize.y - appUsableSize.y)
        }

        // navigation bar is not present
        return Point()
    }

    fun getAppUsableScreenSize(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        return point
    }

    fun getRealScreenSize(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        windowManager.defaultDisplay.getRealSize(point)
        return point
    }
}