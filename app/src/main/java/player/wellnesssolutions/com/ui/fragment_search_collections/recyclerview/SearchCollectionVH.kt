package player.wellnesssolutions.com.ui.fragment_search_collections.recyclerview

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.vh_search_collection.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.ui.fragment_search_collections.ISearchCollectionContract
import java.lang.ref.WeakReference


class SearchCollectionVH(view: View, listener: ISearchCollectionContract.Presenter?, itemWidth: Int, itemHeight: Int, itemCountInRow: Int) :
        BaseSearchVH<MMCollection>(view, itemWidth, itemHeight, itemCountInRow), View.OnClickListener {
    private var weakPresenter = WeakReference(listener)

    private var mLoadSize = 0

    init {
        ViewUtil.setupOnClicked(view.imgCollectionLogo, this)
        ViewUtil.setupOnClicked(view.tvCollectionName, this)

        val size: Int = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_item_circle_item_size_large)
        val padding: Int = itemView.resources.getDimensionPixelSize(R.dimen.vh_search_screen_cicle_item_for_5_items_or_more_padding)
        mLoadSize = size - padding * 2
    }

    override fun onClick(view: View) {
        data?.also { data ->
            itemView.imgCollectionLogo.changeBgColorOnClick()
            view.isEnabled = false

            weakPresenter.get()?.onChooseItem(data)

            view.isEnabled = true
        }
    }

    override fun bind(data: MMCollection) {
        super.bind(data)

        itemView.tvCollectionName.text = data.name

        loadImage(data)
    }

    private fun loadImage(data: MMCollection) {
        val strokeColor: String = data.getColorStr()

        if (!strokeColor.isEmpty() && strokeColor.length > 1) {
            itemView.imgCollectionLogo.setStrokeColor(Color.parseColor(strokeColor))
        }


        Glide.with(itemView).load(data.image)
                .override(mLoadSize, mLoadSize)
                .placeholder(R.drawable.bg_sp_deault_collection)
                .fallback(R.drawable.bg_sp_deault_collection)
                .error(R.drawable.bg_sp_deault_collection)
                .into(itemView.imgCollectionLogo)
    }

    override fun release() {
        super.release()
        weakPresenter.clear()
    }
}