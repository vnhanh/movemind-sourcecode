package player.wellnesssolutions.com.common.utils

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity

object PermissionUtils {
    const val REQUEST_CODE_PERMISSION_DOWNLOAD = 0

    fun checkAndRequestWriteExternalPermission(activity: AppCompatActivity) : PermissionModel{
        val externalStorage = ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

        val internet = ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED

        val hasPermission = externalStorage && internet

        if(Build.VERSION.SDK_INT >= 23){
            val isCheckedNeverAskAgain = if(hasPermission) false else !activity.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)

            if(!isCheckedNeverAskAgain && !hasPermission){
                ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.INTERNET),
                        REQUEST_CODE_PERMISSION_DOWNLOAD)
            }
            return PermissionModel(hasPermission, isCheckedNeverAskAgain)
        }

        return PermissionModel(hasPermission = hasPermission, isCheckedNeverAskAgain = false)
    }
}