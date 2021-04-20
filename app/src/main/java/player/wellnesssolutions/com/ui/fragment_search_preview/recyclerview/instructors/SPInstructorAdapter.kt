package player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.instructors

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_sp_presenter.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseClickableAdapter
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract

class SPInstructorAdapter(list: ArrayList<MMInstructor>, presenter: ISearchPreviewContract.Presenter?) :
        BaseClickableAdapter<SPInstructorVH, ISearchPreviewContract.Presenter, MMInstructor>(presenter, list) {

    private var nameTextSize = 0f
    private var padding = 0

    init {
        presenter?.addAdapter(this)
    }

    fun setTextSize(view: View, presenter: ISearchPreviewContract.Presenter?) {
        if (nameTextSize == 0f) {
            nameTextSize =
                    when (presenter?.isHaveCollectionsAndInstructors() ?: true) {
                        true -> {
                            view.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_rv_item_name_text_size_small)?.toFloat()
                                    ?: 16f
                        }

                        false -> {
                            view.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_rv_item_name_text_size_large)?.toFloat()
                                    ?: 20f
                        }
                    }
        }

        view.tvPresenterName?.setTextSize(TypedValue.COMPLEX_UNIT_PX, nameTextSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, itemType: Int): SPInstructorVH {
        if (padding == 0) {
            padding = parent.resources?.getDimensionPixelSize(R.dimen.vh_sp_collection_padding)
                    ?: 26
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_sp_presenter, parent, false)
        val vh = SPInstructorVH(view)

        setTextSize(view, listener)

        vh.itemView.setOnClickListener {
            vh.data?.also { data ->
                val isSelected = !(listener?.isItemSelected(data.id, Constant.SEARCH_PRESENTER)
                        ?: false)

                vh.select(isSelected)

                listener?.onChooseOptionItem(data.id, data.name, Constant.SEARCH_PRESENTER)
            }
        }

        return vh
    }

    override fun onBindViewHolder(holder: SPInstructorVH, position: Int) {
        setPadding(holder, position, padding)
        val item = list[position]
        val isSelected = (listener?.isItemSelected(item.id, Constant.SEARCH_PRESENTER)
                ?: false)
        holder.bind(list.get(position), isSelected)
    }

    private fun setPadding(vh: SPInstructorVH, position: Int, padding: Int) {
        when (position) {
            0 -> {
                vh.itemView.setPadding(0, 0, padding, 0)
            }

            else -> {
                vh.itemView.setPadding(padding, 0, padding, 0)
            }
        }
    }

    override fun getItemCount(): Int = list.size
}