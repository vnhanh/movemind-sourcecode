package player.wellnesssolutions.com.common.utils

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import player.wellnesssolutions.com.common.R

object DrawableUtils{
    fun getBackgroundPrimary(color: String, context: Context): GradientDrawable{
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE
        drawable.color = ColorStateList.valueOf(Color.parseColor(color))
        drawable.cornerRadius = context.resources.getDimension(R.dimen.radius_button)
        return drawable
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}