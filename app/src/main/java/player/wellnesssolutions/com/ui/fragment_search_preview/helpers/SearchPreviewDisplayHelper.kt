package player.wellnesssolutions.com.ui.fragment_search_preview.helpers

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search_preview.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.models.screen_search.MMCollection
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_preview.ISearchPreviewContract
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.SPShowedUIData
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.collections.SPCollectionAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SPDurationLevelAdapter
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.durations_levels.SearchedOption
import player.wellnesssolutions.com.ui.fragment_search_preview.recyclerview.instructors.SPInstructorAdapter

object SearchPreviewDisplayHelper {
    fun showUI(presenter: ISearchPreviewContract.Presenter, data: SPShowedUIData, rootView: ConstraintLayout) {
        val hasResult = checkHasResultAndDisplayTitle(rootView, data)
        if (!hasResult) return

        displayUI(presenter, data, rootView)

        // display 2 main buttons finally
        rootView.btnShowResultByMyOptions?.also {
            it.visibility = View.VISIBLE
        }

        rootView.btnShowAllVideosResult?.also {
            it.visibility = View.VISIBLE
        }
    }

    private fun displayUI(presenter: ISearchPreviewContract.Presenter, data: SPShowedUIData, rootView: ConstraintLayout) {
        val rvs = ArrayList<RecyclerView>().apply {
            add(rootView.rv1)
            add(rootView.rv2)
            add(rootView.rv3)
        }

        val tvs = ArrayList<TextView>().apply {
            add(rootView.tvLabel1)
            add(rootView.tvLabel2)
            add(rootView.tvLabel3)
        }

        setupLayoutMargin(data, rootView)

        var j = 0
        for (i in 0..3) {
            if (j >= tvs.size) break
            val tv = tvs[j]
            val rv = rvs[j]

            val extra: Int =
                    when (i) {
                        0 -> displayCollections(tv, rv, data.collections, presenter)
                        1 -> displayInstructors(tv, rv, data.instructors, presenter)
                        2 -> displayDurations(tv, rv, data.durations, presenter)
                        else -> displayLevels(tv, rv, data.levels, presenter)
                    }
            j += extra
        }

        checkScrollableRecycler(rvs, rootView)
    }

    private fun checkScrollableRecycler(rvs: ArrayList<RecyclerView>, rootView: ConstraintLayout) {
        var isScroll = 0
        for (i in 0..2) {
            if (isRecyclerScrollable(rvs[i])) {
                isScroll = 1
            }
        }
        if (isScroll == 1) {
            rootView.txtSwipeRightForMoreOptions?.visibility = View.VISIBLE
        } else {
            rootView.txtSwipeRightForMoreOptions?.visibility = View.INVISIBLE
        }
    }


    private fun setupLayoutMargin(data: SPShowedUIData, rootView: ConstraintLayout) {
        val collections = data.collections
        val instructors = data.instructors

        val hasCollections = !collections.isNullOrEmpty()
        val hasInstructors = !instructors.isNullOrEmpty()
        val has2ImageList = hasCollections && hasInstructors

        val marginTop: Int =
                when (has2ImageList) {
                    true -> rootView.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_rv_margin_top_small)?:0
                    false -> rootView.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_rv_margin_top_large)?:0
                }

        setupMargin(rootView, rootView.rv2, rootView.rv1, rootView.rv3, rootView.tvLabel2, marginTop)
        setupMargin(rootView, rootView.rv3, rootView.rv2, rootView.btnShowAllVideosResult, rootView.tvLabel3, marginTop)

        val btnMainMarginTop: Int =
                when (has2ImageList) {
                    true -> rootView.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_btn_main_margin_top_small)?:0
                    false -> rootView.resources?.getDimensionPixelSize(R.dimen.screen_search_preview_btn_main_margin_top_large)?:0
                }

        setupMarginForMainButons(rootView, btnMainMarginTop)
    }

    private fun setupMargin(rootView: ConstraintLayout, rv: View, aboveView: RecyclerView, belowView: View, leftView: View, marginTop: Int) {
        val set = ConstraintSet()
        set.clone(rootView)
        set.connect(rv.id, ConstraintSet.TOP, aboveView.id, ConstraintSet.BOTTOM, marginTop)
        set.connect(rv.id, ConstraintSet.START, leftView.id, ConstraintSet.END)
        set.connect(rv.id, ConstraintSet.END, aboveView.id, ConstraintSet.END)

        if (belowView.id == rootView.id)
            set.connect(rv.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        else
            set.connect(rv.id, ConstraintSet.BOTTOM, belowView.id, ConstraintSet.TOP)

        set.applyTo(rootView)
    }

    private fun setupMarginForMainButons(rootView: ConstraintLayout, marginTop: Int) {
        val btnOptions = rootView.btnShowResultByMyOptions
        val btnAllVideos = rootView.btnShowAllVideosResult
        val tvTitle = rootView.tvTitle
        val rv3 = rootView.rv3

        val set = ConstraintSet()
        set.clone(rootView)

        set.connect(btnAllVideos.id, ConstraintSet.TOP, rv3.id, ConstraintSet.BOTTOM, marginTop)
        set.connect(btnAllVideos.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
        set.connect(btnAllVideos.id, ConstraintSet.START, btnOptions.id, ConstraintSet.END)
        set.connect(btnAllVideos.id, ConstraintSet.END, rv3.id, ConstraintSet.END)
        set.setVerticalChainStyle(btnAllVideos.id, ConstraintSet.CHAIN_PACKED)

        set.connect(btnOptions.id, ConstraintSet.START, tvTitle.id, ConstraintSet.START)
        set.connect(btnOptions.id, ConstraintSet.END, btnAllVideos.id, ConstraintSet.START)
        set.connect(btnOptions.id, ConstraintSet.TOP, btnAllVideos.id, ConstraintSet.TOP)
        set.connect(btnOptions.id, ConstraintSet.BOTTOM, btnAllVideos.id, ConstraintSet.BOTTOM)

        set.setHorizontalChainStyle(btnAllVideos.id, ConstraintSet.CHAIN_PACKED)
        set.setHorizontalChainStyle(btnOptions.id, ConstraintSet.CHAIN_PACKED)

        set.applyTo(rootView)
    }

    private fun displayCollections(tvLabel: TextView, rvCollections: RecyclerView, list: ArrayList<MMCollection>?,
                                   presenter: ISearchPreviewContract.Presenter): Int {
        if (list == null || list.isEmpty()) return 0

        tvLabel.text = tvLabel.context.getString(R.string.screen_search_preview_tv_label_collection)
        val adapter = SPCollectionAdapter(list, presenter)
        setupRecyclerview(rvCollections, adapter)
        return 1
    }

    private fun displayInstructors(tvLabel: TextView, rvInstructors: RecyclerView, list: ArrayList<MMInstructor>?,
                                   presenter: ISearchPreviewContract.Presenter): Int {
        if (list == null || list.isEmpty()) return 0

        tvLabel.text = tvLabel.context.getString(R.string.screen_search_preview_tv_label_presenter)
        val adapter = SPInstructorAdapter(list, presenter)
        setupRecyclerview(rvInstructors, adapter)
        return 1
    }

    private fun displayDurations(tvLabel: TextView, rvDurations: RecyclerView, list: ArrayList<SearchedOption>?,
                                 presenter: ISearchPreviewContract.Presenter): Int {
        if (list == null || list.isEmpty()) return 0

        tvLabel.text = tvLabel.context.getString(R.string.screen_search_preview_tv_label_time)
        val adapter = SPDurationLevelAdapter(list, presenter)
        setupRecyclerview(rvDurations, adapter)
        return 1
    }

    private fun displayLevels(tvLabel: TextView, rvLevels: RecyclerView, list: ArrayList<SearchedOption>?,
                              presenter: ISearchPreviewContract.Presenter): Int {
        if (list == null || list.isEmpty()) return 0

        tvLabel.text = tvLabel.context.getString(R.string.screen_search_preview_tv_label_level)
        val adapter = SPDurationLevelAdapter(list, presenter)
        setupRecyclerview(rvLevels, adapter)
        return 1
    }

    private fun setupRecyclerview(rv: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        rv.layoutManager = LinearLayoutManager(rv.context, LinearLayoutManager.HORIZONTAL, false)
        rv.setHasFixedSize(true)
        rv.adapter = adapter
    }

    fun checkHasResultAndDisplayTitle(rootView: ConstraintLayout, data: SPShowedUIData): Boolean {
        var hasResult = false

        data.collections?.also {
            if (it.size > 0) {
                hasResult = true
            }
        }

        data.instructors?.also {
            if (it.size > 0) {
                hasResult = true
            }
        }

        data.durations?.also<ArrayList<SearchedOption>> {
            if (it.size > 0) {
                hasResult = true
            }
        }

        data.levels?.also<ArrayList<SearchedOption>> {
            if (it.size > 0) {
                hasResult = true
            }
        }

        if (!hasResult)
            displayDialogEmpty(rootView, data)

        return hasResult
    }

    private fun displayDialogEmpty(rootView: ConstraintLayout, data: SPShowedUIData) {
        val brandName: String? = data.brand?.name
        val searchBy: SearchedOption? = data.searchByData

        val message = StringBuilder()

        if (brandName == null || searchBy == null || searchBy.name == null) {
            message.append(rootView.context.getString(R.string.search_preview_has_no_videos))
        } else {
            val typeName =
                    when (searchBy.typeOptionId) {
                        Constant.SEARCH_COLLECTION -> rootView.context.getString(R.string.collection)
                        Constant.SEARCH_PRESENTER -> rootView.context.getString(R.string.instructor)
                        Constant.SEARCH_LEVEL -> rootView.context.getString(R.string.level)
                        Constant.SEARCH_DURATION -> rootView.context.getString(R.string.time)
                        else -> "Item"
                    }

            message.append(rootView.context.getString(R.string.this_item_has_not_video_of_this_brand, searchBy.name, typeName, brandName))
        }

        DialogUtil.createDialogOnlyOneButton(context = rootView.context, message = message.toString(), titleButton = R.string.btn_ok, dialogClickListener = null).show()
    }

    private fun isRecyclerScrollable(rv: RecyclerView): Boolean {
        when (val adapter = rv.adapter ?: return false) {
            is SPCollectionAdapter -> {
                return adapter.itemCount > 5
            }
            is SPDurationLevelAdapter -> {
                return adapter.itemCount > 4
            }
            is SPInstructorAdapter -> {
                return adapter.itemCount > 5
            }
            else -> return false
        }
    }
}