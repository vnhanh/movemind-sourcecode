package player.wellnesssolutions.com.ui.fragment_search_videos_by

import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.helper.SearchVideosByHelper
import java.util.*

class SearchVideosByPresenter : ISearchVideosByContract.Presenter {
    // vars
    private var mView: ISearchVideosByContract.View? = null
    private lateinit var mBrand: MMBrand

    // must call before onAttach() function
    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onChooseItem(data: SearchByOption) {
        mView?.onOpenNextScreen(mBrand, data)
    }

    override fun onAttach(view: ISearchVideosByContract.View) {
        this.mView = view

        displayUI()
    }

    override fun onReshowUI(view: ISearchVideosByContract.View) {
        this.mView = view
        displayUI()
    }

    private fun displayUI() {
        mView?.getFragment()?.context?.also { context ->
            val list: ArrayList<SearchByOption> = SearchVideosByHelper.getSearchByOptions(context, mBrand.hasLevel
                    ?: 1)
            mView?.showUI(list)
        }
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onDestroy() {

    }
}