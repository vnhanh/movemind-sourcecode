package player.wellnesssolutions.com.common.enums

enum class StyleEnum(var value: Int) {
    NORMAL(0),
    BORDER(1),
    BACKGROUND(2),
    BTN_COLOR(3),
    BORDER_HALF(4),
    BORDER_ACTIVED(5);

    companion object {
        fun getEnum(value: Int) : StyleEnum? = StyleEnum.values().find {
            it.value == value
        }
    }
}