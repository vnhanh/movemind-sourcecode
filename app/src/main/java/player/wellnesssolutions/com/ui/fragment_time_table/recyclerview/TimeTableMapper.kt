package player.wellnesssolutions.com.ui.fragment_time_table.recyclerview

import player.wellnesssolutions.com.network.models.response.SubVideo
import player.wellnesssolutions.com.network.models.search_result.MMTinyCategory

object TimeTableMapper {
    fun convertToMMSimpleCollection(item: SubVideo): MMTinyCategory =
            MMTinyCategory(
                    _id = item.idSub,
                    name = item.nameOfSub,
                    colorStr = item.colorOfSub
            )

//    fun convertToListOfMMSimpleCollection(inputList:ArrayList<SubVideo>) : ArrayList<MMTinyCategory> =
}