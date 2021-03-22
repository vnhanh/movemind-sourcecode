package player.wellnesssolutions.com.common.enums

enum class StyleEnumSelect(var value: Int) {
    UNSELECTED(0),
    SELECTED(1);

    companion object {
        fun getEnum(value: Int) : StyleEnumSelect? = StyleEnumSelect.values().find {
            it.value == value
        }
    }
}