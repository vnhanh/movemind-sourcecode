package player.wellnesssolutions.fontsizelibrary

import android.content.Context
import android.graphics.Typeface

class TypefaceUtil {

    companion object {
        fun overrideFont(context: Context, defaultFont: String, customFont: String) {
            val customTypeFace = Typeface.createFromAsset(context.assets, customFont)

            try {
                val defaultField = Typeface::class.java.getDeclaredField(defaultFont)
                defaultField.isAccessible = true
                defaultField.set(null, customTypeFace)
            } catch (error: Exception) {
                error.printStackTrace()
            }
        }

        fun getTypeface(context: Context?, fontName: String = ""): Typeface {
            return if (context == null || fontName.isBlank()) {
                Typeface.DEFAULT
            } else {
                Typeface.createFromAsset(context.assets, fontName)
            }
        }
    }

}