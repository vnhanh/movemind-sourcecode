package player.wellnesssolutions.com.ui.fragment_search_instructors

import player.wellnesssolutions.com.base.view.ILifeCycle
import player.wellnesssolutions.com.base.view.IProgressView
import player.wellnesssolutions.com.base.view.IShowMessageView
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor

interface ISearchInstructorContract {
    interface View : ILifeCycle.View, IShowMessageView, IProgressView {
        fun onOpenNextScreen(brand: MMBrand, instructor: MMInstructor)
        fun showUI(brandName: String, data: ArrayList<MMInstructor>)
        fun showInstructorInfo(item: MMInstructor)
        fun onOpenSearchResultScreen(instructor: MMInstructor)
        fun onRequestFailed(message: String)
    }

    interface Presenter : ILifeCycle.Presenter<View> {
        fun setChosenBrand(brand: MMBrand)
        fun onClickShowInfoInstructor(item: MMInstructor)
        fun onClickInstructorItem(item: MMInstructor)
        fun onClickedShowVideosByInstructor(instructor: MMInstructor)
        fun onReshowUI(view: View)
        fun loadData(view: View)
    }
}