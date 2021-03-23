package player.wellnesssolutions.com.ui.fragment_time_table


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_time_table.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.customs.views.ItemDecorationGridHorizontalLayout
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.customize_views.MMTabBar
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.network.models.response.SessionVideo
import player.wellnesssolutions.com.ui.fragment_time_table.recyclerview.SchedulerAdapter


class TimeTableFragment : BaseScheduleFragment(), ITimeTableContract.View, MMTabBar.TabBarListener, SchedulerAdapter.OnClickItemListener {
    companion object {
        const val TAG = "TimeTableFragment"
        const val EXTRA_NEW_DATA = "EXTRA_NEW_DATA"

        fun getInstance(): TimeTableFragment = TimeTableFragment()

        fun getBundleForNewData(): Bundle =
                Bundle().apply {
                    putBoolean(EXTRA_NEW_DATA, true)
                }
    }

    private var mPresenter: ITimeTableContract.Presenter? = TimeTablePresenter()
    private var mDialog: AlertDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_time_table, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
        tabBarToday.setTabBarListener(this)
        tabsSession.setTabBarListener(this)
    }

    override fun onResume() {
        super.onResume()
        attachPresenter()
    }

    override fun onPause() {
        detachPresenter()
        super.onPause()
    }

    override fun onDestroyView() {
        mDialog?.dismiss()

        tabBarToday.release()
        tabsSession.release()

        reViewVideos?.adapter?.also {
            if (it is SchedulerAdapter)
                it.release()
        }
        mPresenter?.onStop()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    private fun attachPresenter() {
        view?.postDelayed(Runnable {
            mPresenter?.onAttach(this)
        }, 200L)
    }

    private fun detachPresenter() {
        mPresenter?.onDetach()
    }

    override fun onTabChanged(stringID: String) {
        updateRecyclerView(mPresenter?.onGetSessionVideo(tabBarToday.getState(), tabsSession.getState()))
    }

    override fun onClick(item: SessionVideo) {

    }

    override fun setupUI(data: ArrayList<SessionVideo>?) {
        if (data != null && data.size > 0)
            setupRecyclerView(data)

        updateDisplayingSwipeRightMoreOptionView(data?.size ?: 0)
    }

    override fun showDialog(message: String, buttonColor: Int) {
        clProgressBar.visibility = View.GONE
        context?.let {
            mDialog?.dismiss()
            mDialog = DialogUtil.createDialogOnlyOneButton(context = it,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null,
                    buttonColor = buttonColor).also { dialog ->
                dialog.show()
            }
        }
    }

    override fun showDialog(message: String) {
        clProgressBar.visibility = View.GONE
        context?.let {
            mDialog?.dismiss()
            mDialog = DialogUtil.createDialogOnlyOneButton(context = it,
                    message = message,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = null).also { alert ->
                alert.show()
            }
        }
    }

    private fun setupButtons() {
        initValues()
        setupButtonRefresh()
        setupButtonPrevious()
    }

    private fun setupButtonPrevious() {
        context?.also {
            when (PreferenceHelper.getInstance(it).getBoolean(ConstantPreference.IS_SHOW_BUTTON_PREVIOUS, false)) {
                true -> {
                    btnPrevious.visibility = View.VISIBLE
                    PreferenceHelper.getInstance(it).delete(ConstantPreference.IS_SHOW_BUTTON_PREVIOUS)
                }
                false -> {
                    btnPrevious.text = it.getString(R.string.btn_title_back)
                    btnPrevious.visibility = View.VISIBLE
                }
            }
        }

        btnPrevious.setOnClickListener {
            onBackPressed(it)
        }
    }

    private fun setupButtonRefresh() {
        icRefresh.setOnClickListener {
            icRefresh.isEnabled = false
            ViewUtil.hideRefreshView(icRefresh, tvRetry)
            mPresenter?.onGetTimetable()
            icRefresh.isEnabled = true
        }
    }

    private fun setupRecyclerView(list: ArrayList<SessionVideo>) {
        if (reViewVideos == null || btnSwipeRight == null) return

        val rowNumber = 4
        reViewVideos.layoutManager = GridLayoutManager(context, rowNumber, RecyclerView.HORIZONTAL, false)
        reViewVideos.setHasFixedSize(true)

        val itemDecoration = ItemDecorationGridHorizontalLayout(null, 0, rowNumber)
        itemDecoration.margin = resources.getDimensionPixelSize(R.dimen.margin)
        reViewVideos.addItemDecoration(itemDecoration)

        val adapter = SchedulerAdapter(this)
        adapter.setList(list)

        reViewVideos.adapter = adapter
    }

    private fun updateDisplayingSwipeRightMoreOptionView(itemCount: Int) {
        if (itemCount > 12)
            btnSwipeRight.visibility = View.VISIBLE
        else
            btnSwipeRight?.let {
                it.visibility = View.INVISIBLE
            }
    }

    private fun updateRecyclerView(list: ArrayList<SessionVideo>?) {
        val adapter = reViewVideos.adapter
        if (adapter == null) {
            setupRecyclerView(list ?: arrayListOf())
        } else if (adapter is SchedulerAdapter) {
            adapter.setList(list ?: arrayListOf())
        }

        updateDisplayingSwipeRightMoreOptionView(list?.size ?: 0)
    }

    override fun onRequestFailed() {
        hideLoadingProgress()
        ViewUtil.showRefreshView(icRefresh, tvRetry)
    }

    private var normalTextSize = 14f
    private var expandedTextSize = 16f

    override fun showLoadingProgress() {
        clProgressBar?.also {
            it.visibility = View.VISIBLE
        }
    }

    override fun hideLoadingProgress() {
        clProgressBar?.also {
            it.visibility = View.GONE
        }
    }

    /**
     * call from {@link #setupUI()}
     */
    private fun initValues() {
        normalTextSize = resources.getDimensionPixelSize(R.dimen.text_size_today_tomorrow_time_table_normal).toFloat()
        expandedTextSize = resources.getDimensionPixelSize(R.dimen.text_size_today_tomorrow_time_table_expanded).toFloat()
    }

}
