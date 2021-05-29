package player.wellnesssolutions.com.ui.fragment_search_videos_by

import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.helper.SearchVideosByHelper
import java.util.*

class SearchVideosByPresenter : ISearchVideosByContract.Presenter {
    // vars
    private var mView: ISearchVideosByContract.View? = null
    private var mBrand: MMBrand? = null

    // must call before onAttach() function
    override fun setChosenBrand(brand: MMBrand) {
        this.mBrand = brand
    }

    override fun onChooseItem(data: SearchByOption) {
        mBrand?.also { brand ->
            mView?.onOpenNextScreen(brand, data)
        }
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
        mView?.also { view ->
            mBrand?.also { brand ->
                view.getFragment().context?.also { context ->
                    val list: ArrayList<SearchByOption> =
                        SearchVideosByHelper.getSearchByOptions(
                            context, hasLevel = brand.hasLevel ?: 1
                        )
                    view.showUI(list)
                }
            }
        }
    }

    override fun onDetach() {
        this.mView = null
    }

    override fun onDestroy() {

    }
}