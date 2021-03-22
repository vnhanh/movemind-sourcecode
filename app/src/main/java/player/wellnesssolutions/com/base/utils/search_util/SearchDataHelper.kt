package player.wellnesssolutions.com.base.utils.search_util

import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import java.util.*

object SearchDataHelper {
    fun sortInstructors(instructors: ArrayList<MMInstructor>?) {
        if (instructors == null) return

        instructors.sortWith(Comparator { person1, person2 ->
            (person1.name ?: Constant.EMPTY).compareTo((person2.name ?: Constant.EMPTY))
        })
    }

    fun sortCollections(collections: ArrayList<MMCollection>?) {
        if (collections == null) return

        collections.sortWith(Comparator { item1, item2 ->
            (item1.name ?: Constant.EMPTY).compareTo((item2.name ?: Constant.EMPTY))
        })
    }

    fun sortDurations(durations: ArrayList<MMDuration>?) {
        if (durations == null) return

        durations.sortWith(Comparator { item1, item2 ->
            (item1.min ?: 0).compareTo((item2.min ?: 0))
        })
    }

    fun convertToUpperCase(instructors: ArrayList<MMInstructor>) {
        for (instructor: MMInstructor in instructors) {
            instructor.name = instructor.name?.toUpperCase()
        }
    }
}