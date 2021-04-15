package player.wellnesssolutions.com.ui.fragment_search_durations.recyclerview

import android.view.View
import kotlinx.android.synthetic.main.viewholder_search_video_duration.view.*
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMDuration
import player.wellnesssolutions.com.ui.fragment_search_durations.ISearchDurationContract

class SearchDurationVH(view: View, private var listener: ISearchDurationContract.Presenter?, itemWidth: Int, itemHeight: Int, itemCountInRow: Int) :
        BaseSearchVH<MMDuration>(view, itemWidth, itemHeight, itemCountInRow), View.OnClickListener {

    init {
        ViewUtil.setupOnClicked(view.viewWrapper, this)
        ViewUtil.setupOnClicked(view.tvTimeUnit, this)
    }

    override fun release() {
        super.release()
        listener = null
    }

    override fun onClick(view: View) {
        data?.also { data ->
            view.isEnabled = false
            itemView.viewWrapper?.changeBgColorOnClick()
            listener?.onChooseItem(data)
            view.isEnabled = true
        }
    }

    override fun bind(data: MMDuration) {
        super.bind(data)

        itemView.tvTimeNumber?.text = data.title ?: Constant.SHARP
    }
}