package player.wellnesssolutions.com.base.utils

import android.os.Build
import android.os.Environment
import android.os.StatFs
import android.text.TextUtils
import com.google.gson.Gson
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.response.ErrorBody


object CommonUtility {

    inline fun <reified T> getObjectBy(string: String): T {
        return Gson().fromJson(string, T::class.java)
    }

    fun getErrorBody(strBodyError: String?): ErrorBody? {
        when {
            strBodyError.isNullOrBlank() -> return null
            else -> return try {
                Gson().fromJson(strBodyError, ErrorBody::class.java)
            } catch (e: Exception) {
                e.printStackTrace()
//                Log.d("LOG", this.javaClass.simpleName + " getErrorBody() | error: ${e.message}")
                ErrorBody(success = false, message = strBodyError)
            }
        }
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