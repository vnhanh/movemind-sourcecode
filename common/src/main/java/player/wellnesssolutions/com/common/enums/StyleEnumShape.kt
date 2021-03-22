package player.wellnesssolutions.com.common.enums

enum class StyleEnumShape(var value: Int) {
    RECTANGLE(0),
    CIRCLE(1);

    companion object {
        fun getEnum(value: Int) : StyleEnumShape? = StyleEnumShape.values().find {
            it.value == value
        }
    }
}