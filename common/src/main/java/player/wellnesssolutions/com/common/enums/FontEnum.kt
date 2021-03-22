package player.wellnesssolutions.com.common.enums


enum class FontEnum(var value:String) {
    MADE_EVOLVE_SANS("fonts/made_evolve_sans.ttf"),
    MADE_EVOLVE_SANS_BOLD("fonts/made_evolve_sans_bold.ttf"),
    LIBERATOR_HEVAY("fonts/Liberator-Heavy.ttf");

    companion object{
        fun getEnum(value: String) : FontEnum? = FontEnum.values().find {
            it.value == value
        }
    }
}