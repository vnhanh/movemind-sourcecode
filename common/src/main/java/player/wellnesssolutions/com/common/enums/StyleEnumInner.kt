package player.wellnesssolutions.com.common.enums

enum class StyleEnumInner(var value: Int) {
    CIRCLE_FIT_INNER(0),
    SQUARE_INNER_CIRCLE(1);

    companion object {
        fun getEnum(value: Int) : StyleEnumInner? = StyleEnumInner.values().find {
            it.value == value
        }
    }
}