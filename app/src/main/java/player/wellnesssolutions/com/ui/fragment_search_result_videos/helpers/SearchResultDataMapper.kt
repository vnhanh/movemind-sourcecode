package player.wellnesssolutions.com.ui.fragment_search_result_videos.helpers

import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer

object SearchResultDataMapper {

    fun mapHelpMeChooseAnswersToArrayInt(answers: ArrayList<MMHelpMeChooseAnswer>): ArrayList<Int> {
        val res = ArrayList<Int>()
        for (answer in answers) {
            answer.id?.also {
                res.add(it)
            }
        }
        return res
    }
}