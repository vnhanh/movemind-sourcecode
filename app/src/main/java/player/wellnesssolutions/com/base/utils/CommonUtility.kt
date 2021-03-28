package player.wellnesssolutions.com.base.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import okhttp3.ResponseBody
import player.wellnesssolutions.com.common.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.models.response.ErrorBody


object CommonUtility {

    inline fun <reified T> getObjectBy(string: String): T {
        return Gson().fromJson(string, T::class.java)
    }

    fun getDrawableByPrimary(context: Context): Drawable? {
        val mPref = PreferenceHelper.getInstance(context)

        val strPrimaryColor = mPref.getString(ConstantPreference.PRIMARY_COLOR, "")

        if (strPrimaryColor.isEmpty()) return null
        val shape = GradientDrawable()
        GradientDrawable.RECTANGLE
        shape.cornerRadius = context.resources.getDimension(R.dimen.sr_radius_button)
        shape.setStroke(context.resources.getDimension(R.dimen.sr_width_stroke_button).toInt(), Color.parseColor(strPrimaryColor))

        return shape
    }

    fun getDrawableByPrimary(context: Context, @ColorRes solidColor: Int): Drawable? {
        val mPref = PreferenceHelper.getInstance(context)

        val strPrimaryColor = mPref.getString(ConstantPreference.PRIMARY_COLOR, "")

        if (strPrimaryColor.isEmpty()) return null
        val shape = GradientDrawable()
        GradientDrawable.RECTANGLE
        shape.cornerRadius = context.resources.getDimension(R.dimen.sr_radius_button)
        shape.setStroke(context.resources.getDimension(R.dimen.sr_width_stroke_button).toInt(), Color.parseColor(strPrimaryColor))
        shape.color = ColorStateList.valueOf(ContextCompat.getColor(context, solidColor))

        return shape
    }

    fun getErrorBody(strBodyError: String?): ErrorBody? {
        when {
            strBodyError.isNullOrBlank() -> return null
            else -> return try {
                Gson().fromJson(strBodyError, ErrorBody::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("LOG", this.javaClass.simpleName + " getErrorBody() | error: ${e.message}")
                ErrorBody(success = false, message = strBodyError)
            }
        }
    }

    fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun getAvailableInternalMemorySize(): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val availableBlocks = stat.availableBlocksLong
//        return formatSize(availableBlocks * blockSize)
        return (availableBlocks * blockSize)
    }

    fun getTotalInternalMemorySize(): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
//        return formatSize(totalBlocks * blockSize)
        return (totalBlocks * blockSize)
    }

    fun getDeviceId(): String {
        return Build.ID
    }

    fun getModelName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        if (model.startsWith(manufacturer)) {
            return capitalize(model)
        }

        return capitalize(manufacturer) + Constant.WHITE_SPACE + model
    }

    private fun capitalize(str: String): String {
        if (TextUtils.isEmpty(str)) {
            return str
        }
        val arr = str.toCharArray()
        var capitalizeNext = true

        val phrase = StringBuilder()
        for (c in arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c))
                capitalizeNext = false
                continue
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true
            }
            phrase.append(c)
        }

        return phrase.toString()
    }
}