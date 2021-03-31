package player.wellnesssolutions.com.ui.fragment_search_levels.recyclerview

import android.view.View
import kotlinx.android.synthetic.main.viewholder_search_video_level.view.*
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMLevel
import player.wellnesssolutions.com.ui.fragment_search_levels.ISearchLevelsContract

class SearchLevelVH(view: View, private var listener: ISearchLevelsContract.Presenter?, itemWidth: Int, itemHeight: Int, itemCountInRow: Int) :
        BaseSearchVH<MMLevel>(view, itemWidth, itemHeight, itemCountInRow), View.OnClickListener {

    init {
        ViewUtil.setupOnClicked(view.viewWrapper, this)
        ViewUtil.setupOnClicked(view.tvName, this)
    }

    override fun onClick(view: View) {
        data?.also { data ->
            view.isEnabled = false
            itemView.viewWrapper?.changeBgColorOnClick()
            listener?.onChooseItem(data)
            view.isEnabled = true
        }
    }

    override fun bind(data: MMLevel) {
        super.bind(data)

        itemView.tvLevel.text = data.level
        itemView.tvName.text = data.name ?: Constant.SHARP
    }

    override fun release() {
        super.release()
        listener = null
    }
}