package player.wellnesssolutions.com.common.utils

import android.content.Context
import android.os.Environment
import android.os.StatFs
import java.io.File
import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object FileUtil {
    const val EXTERNAL_FOLDER = "files"
    fun clearFolder(context: Context, folder: String) {
        File(context.filesDir, folder).also { folders ->
            val list = folders.listFiles() ?: return
            for (file in list) {
                file.delete()
            }
        }

        if (isExternalStorageAvailable() && !isExternalStorageReadOnly() && isSDCardAvailable(context)) {
            val externalUrl = context.getExternalFilesDirs(null)
            externalUrl?.get(1)?.let { file ->
                File(file, folder).also {
                    val list = it.listFiles() ?: return
                    for (fileDel in list) {
                        fileDel.delete()
                    }
                }
            }

        }
    }

    fun getAvailableInternalMemorySize(): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val availableBlocks = stat.availableBlocksLong
        val size2GB = 2147483648
        return if((availableBlocks * blockSize) -(size2GB) < 0 ) {
            0
        } else {
            (availableBlocks * blockSize) -(size2GB)
        }
    }

    fun getAvailableExternalMemorySize(context: Context?): Long {
        return if (context != null) {
            if (isExternalStorageAvailable() && !isExternalStorageReadOnly() && isSDCardAvailable(context)) {
                val pathEx = context.getExternalFilesDirs(null)
                val statEx = StatFs(pathEx[1].absolutePath)
                val blockSizeEx = statEx.blockSizeLong
                val availableBlocksEx = statEx.availableBlocksLong
                availableBlocksEx * blockSizeEx
            } else {
                0
            }
        } else {
            0
        }
    }
    fun getTotalExternalMemorySize(context: Context?): Long {
        return  if(context != null) {
            if(isExternalStorageAvailable() && !isExternalStorageReadOnly() && isSDCardAvailable(context)){
                val pathEx = context.getExternalFilesDirs(null)
                val statEx = StatFs(pathEx[1].absolutePath)
                val blockSizeEx = statEx.blockSizeLong
                val totalBlocks = statEx.blockCountLong
                totalBlocks*blockSizeEx
            }else{
                0
            }
        }else{
            0
        }
    }
    fun getTotalInternalMemorySize(): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        return  totalBlocks * blockSize
    }

    fun isExternalStorageReadOnly(): Boolean {
        val extStorageState = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED_READ_ONLY == extStorageState
    }

    fun isExternalStorageAvailable(): Boolean {
        val externalState = Environment.getExternalStorageState()
        return Environment.MEDIA_MOUNTED == externalState
    }

    fun isSDCardAvailable(context: Context?): Boolean {
        if (context == null) return false
        val external = context.getExternalFilesDirs(null)
        return external.size > 1 && external[1] != null
    }

    fun generateKeyAndEncryptFile() : Cipher {
        val sha = MessageDigest.getInstance("SHA-1")
        val sks = SecretKeySpec(Arrays.copyOf(sha.digest("DmNoBatEncrypt".toByteArray(Charsets.UTF_8)),16),"AES")
        val cipher = Cipher.getInstance("AES/CTR/NoPadding","BC")
        cipher.init(Cipher.ENCRYPT_MODE,sks)
        return cipher
    }
}