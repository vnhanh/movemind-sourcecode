package player.wellnesssolutions.com.common.enums

import android.graphics.Typeface

enum class TextStyle(var value:Int) {
    BOLD(Typeface.BOLD),
    BOLD_ITALIC(Typeface.BOLD_ITALIC);

    companion object{
        fun getEnum(value: Int) : TextStyle = TextStyle.values().find {
            it.value == value
        }?:BOLD
    }
}