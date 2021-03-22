package player.wellnesssolutions.com.ui.fragment_search_levels.recyclerview

import android.view.View
import kotlinx.android.synthetic.main.viewholder_search_video_level.view.*
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMLevel
import player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract
import java.lang.ref.WeakReference

class SearchLevelVH(view: View, listener: ISearchLevelsContract.Presenter?, itemWidth: Int, itemHeight: Int, itemCountInRow: Int) :
        BaseSearchVH<MMLevel>(view, itemWidth, itemHeight, itemCountInRow), View.OnClickListener {
    private var mWeakPresenter = WeakReference(listener)

    init {
        ViewUtil.setupOnClicked(view.viewWrapper, this)
        ViewUtil.setupOnClicked(view.tvName, this)
    }

    override fun onClick(view: View) {
        data?.also { data ->
            view.isEnabled = false
            itemView.viewWrapper?.changeBgColorOnClick()
            mWeakPresenter.get()?.onChooseItem(data)
            view.isEnabled = true
        }
    }

    override fun bind(data: MMLevel) {
        super.bind(data)

        itemView.tvLevel.text = data.level
        itemView.tvName.text = data.name ?: Constant.SHARP
    }
}