package player.wellnesssolutions.com.common.transform

import android.content.res.Resources
import android.graphics.*
import androidx.annotation.DrawableRes

object ImageUtil {
    fun cropCircleBitmapSameSize(resources : Resources, @DrawableRes resId : Int) : Bitmap? {
        val bitmap = BitmapFactory.decodeResource(resources, resId)

        return cropCircleBitmapSameSize(bitmap)
    }

    // convert a bitmap to a circle bitmap with same size
    fun cropCircleBitmapSameSize(bitmap : Bitmap) : Bitmap {
        val circleSize = Math.min(bitmap.width, bitmap.height)

        val destBitmap = Bitmap.createBitmap(circleSize, circleSize, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(destBitmap)
        val paint = Paint()
        paint.isAntiAlias = true

        val rect = Rect(0, 0, circleSize, circleSize)
        val rectF = RectF(rect)
        canvas.drawOval(rectF, paint)
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_IN))
        val left = (circleSize - bitmap.width) / 2f
        val top = (circleSize - bitmap.height) / 2f
        canvas.drawBitmap(bitmap, left, top, paint)
        bitmap.recycle()

        return destBitmap
    }
}