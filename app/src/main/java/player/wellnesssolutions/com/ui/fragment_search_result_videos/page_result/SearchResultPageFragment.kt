package player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_page_search_result.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_search_result_videos.ISearchResultContract
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment
import player.wellnesssolutions.com.ui.fragment_search_result_videos.page_result.recyclerview.VideosSearchResultPageAdapter


class SearchResultPageFragment : Fragment(), ISearchResultPageContract.View {
    private var mParentPresenter: ISearchResultContract.Presenter? = null
    private var mPresenter: ISearchResultPageContract.Presenter? = null
    private var mAdapter: VideosSearchResultPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getParentPresenterRef()
        readArguments(savedInstanceState)
    }

    private fun getParentPresenterRef() {
        if (mParentPresenter == null) {
            parentFragment?.also {
                if (it is SearchResultFragment) mParentPresenter = it.getPresenter()
            }
        }
    }

    private fun readArguments(savedInstanceState: Bundle?) {
        val args: Bundle? = arguments

        if (savedInstanceState != null) {
            readBundle(savedInstanceState)
        } else if (args != null) {
            readBundle(args)

        }
    }

    private fun readBundle(bundle: Bundle) {
        bundle.getInt(KEY_INDEX).also { index ->
            if (mPresenter == null) {
                mPresenter = SearchResultPagePresenter(index).also {
                    it.setParentPresenter(this.mParentPresenter)
                }
            }
        }
        bundle.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_search_result, container, false)
    }

    override fun onResume() {
        super.onResume()
//        progressBar.visibility = View.VISIBLE
        attachPresenter()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
//        progressBar.visibility = View.GONE
    }

    private fun attachPresenter() {
        mPresenter?.onAttach(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mPresenter?.getPageIndex()?.also { index ->
            outState.putInt(KEY_INDEX, index)
        }

    }

    override fun onPause() {
        mPresenter?.onDetach()
        super.onPause()
    }

    override fun onDestroyView() {
        rvVideoSearchResult.release()
        super.onDestroyView()
    }

    override fun onDestroy() {
        mAdapter?.release()
        mAdapter = null

        mPresenter?.onDestroy()
        mPresenter = null

        super.onDestroy()
    }

    /**
     * View interface
     */

    override fun getFragment(): Fragment = this

    override fun getViewContext(): Context? = context

    override fun showMessage(message: String, color: Int) {
        MessageUtils.showToast(context, message, color)?.show()
    }

    override fun showMessage(messageRes: Int, color: Int) {
        MessageUtils.showToast(context, messageRes, color)?.show()
    }

    override fun showUI(inputData: ArrayList<MMVideo>) {
        view?.also {
            val adapter = VideosSearchResultPageAdapter(inputData, mPresenter)
            rvVideoSearchResult.layoutManager = GridLayoutManager(context, Constant.COL_COUNT_SCREEN_SEARCH_RESULT,
                    RecyclerView.VERTICAL, false)
            rvVideoSearchResult.setHasFixedSize(true)
            rvVideoSearchResult.setRowCount(Constant.ROW_COUNT_SCREEN_SEARCH_RESULT)
            rvVideoSearchResult.setVideosSearchResultPageAdapter(adapter)

            mAdapter = adapter

            progressLoadBrand?.visibility = View.GONE
        }
    }

    override fun onShowPlayingVideoDialog(data: MMVideo) {
        mParentPresenter?.onShowPlayingVideoDialog(data)
    }

    /**
     * ---------------
     */

    companion object {
        const val TAG = "SearchResultPageFragment"
        const val VIDEO_SEARCH_RESULT_COUNT_IN_ONE_PAGE = 11
        const val KEY_INDEX = "KEY_INDEX"

        fun getInstance(index: Int): SearchResultPageFragment =
                SearchResultPageFragment().apply {
                    arguments = saveIndexPage(index)
                }

        fun saveIndexPage(index: Int): Bundle =
                Bundle().apply {
                    putInt(KEY_INDEX, index)
                }
    }
}