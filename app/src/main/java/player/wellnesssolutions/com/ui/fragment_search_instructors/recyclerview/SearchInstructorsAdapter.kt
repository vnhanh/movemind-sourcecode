package player.wellnesssolutions.com.ui.fragment_search_instructors.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.load.model.LazyHeaders
import kotlinx.android.synthetic.main.viewholder_search_video_presenter.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.search_util.BaseSearchVideosAdapter
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_instructors.ISearchInstructorContract

class SearchInstructorsAdapter(presenter: ISearchInstructorContract.Presenter?, list: ArrayList<MMInstructor>, val countItemInRow: Int)
    : BaseSearchVideosAdapter<SearchInstructorVH, ISearchInstructorContract.Presenter, MMInstructor>(presenter, list) {
    private var mGlideHeaders: LazyHeaders? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchInstructorVH {
        if (mGlideHeaders == null) {
            mGlideHeaders = LazyHeaders.Builder().addHeader("MMCookie", SharedPreferencesCustomized.getInstance(parent.context).getString(SPrefConstant.SP_COOKIE, "")).build()
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_search_video_presenter, parent, false)

        setupLayoutForItemView(view, view.imgAvatar)

        return SearchInstructorVH(view = view, listener = presenter, itemWidth = itemWidth, itemHeight = itemHeight, countItemInRow = countItemInRow,
                mGlideHeaders = mGlideHeaders)
    }
}