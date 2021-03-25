package player.wellnesssolutions.com.ui.fragment_search_brands.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract

class SearchBrandsAdapter(listener: ISearchBrandsContract.Presenter?, items: ArrayList<MMBrand>, val itemCountInRow: Int) :
        BaseSearchVideosAdapter<SearchBrandVH, ISearchBrandsContract.Presenter, MMBrand>(listener, items) {

    override fun onBindViewHolder(holder: SearchBrandVH, position: Int) {
        holder.bind(list.get(position), position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBrandVH {
        val layout =
                when (list.size) {
                    in 0..3 -> R.layout.vh_search_brand_less_4_items
                    else -> R.layout.vh_search_brand_4_items
                }

        val imageSize =
                when (list.size) {
                    in 0..3 -> parent.resources.getDimensionPixelSize(R.dimen.size_item_circle_for_1_to_3_items_search_in_row)
                    else -> parent.resources.getDimensionPixelSize(R.dimen.vh_search_screen_4_items)
                }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        val params = GridLayoutManager.LayoutParams(itemWidth, itemHeight)
        view.layoutParams = params

        val vh = SearchBrandVH(view, imageSize, weakPresenter.get())

        mHolders?.add(vh)

        return vh
    }

}