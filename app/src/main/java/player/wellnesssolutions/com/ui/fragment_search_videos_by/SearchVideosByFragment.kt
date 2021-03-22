package player.wellnesssolutions.com.ui.fragment_search_videos_by


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_search_videos_by.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.base.utils.search_util.SearchUIHelper
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.network.models.screen_search.SearchByOption
import player.wellnesssolutions.com.ui.fragment_search_videos_by.recyclerview.SearchVideosByAdapter


class SearchVideosByFragment : BaseFragment(), ISearchVideosByContract.View {
    // vars
    private var mPresenter: ISearchVideosByContract.Presenter? = SearchVideosByPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        readArguments()
    }

    private fun readArguments() {
        val brand: MMBrand? = arguments?.getParcelable(KEY_BRAND)

        if (brand != null) {
            mPresenter?.setChosenBrand(brand)
        }

        arguments?.clear()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_videos_by, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        ViewUtil.setupButton(btnPrevious, this::onBackPressed, btnPrevious)
    }

    private fun detachPresenter() {
        mPresenter?.onDetach()
    }

    override fun onStart() {
        super.onStart()
        attachPresenter()
    }

    private fun attachPresenter() {
        if (mIsJustBeDestroyed) {
            mPresenter?.onReshowUI(this)
            mIsJustBeDestroyed = false
        } else {
            imgBgSearchScreen.postDelayed(Runnable {
                mPresenter?.onAttach(this@SearchVideosByFragment)
            }, 400L)
        }
    }

    override fun onPause() {
        detachPresenter()
        super.onPause()
    }

    override fun onDestroyView() {

        rvSearchVideosBy?.adapter?.also {
            if (it is SearchVideosByAdapter)
                it.release()
        }
        rvSearchVideosBy?.adapter = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        mPresenter?.onDestroy()
        mPresenter = null
        super.onDestroy()
    }

    /**
     * View interface
     */
    override fun showUI(data: ArrayList<SearchByOption>) {
        if (rvSearchVideosBy == null || btnPrevious == null || data.size == 0) return

        val adapter = SearchVideosByAdapter(mPresenter, data)

        rvSearchVideosBy.layoutManager = GridLayoutManager(rvSearchVideosBy.context, data.size, RecyclerView.VERTICAL, false)
        rvSearchVideosBy.setHasFixedSize(true)
        rvSearchVideosBy.adapter = adapter

        btnPrevious.visibility = View.VISIBLE
    }

    override fun onOpenNextScreen(brand: MMBrand, searchByOption: SearchByOption) {
        parentFragment?.also {
            SearchUIHelper.onOpenNextScreen(it, brand, searchByOption.tag, TAG)
        }
    }

    /**
     * -----------------
     */

    companion object {
        val TAG = "SearchVideosByFragment"
        val KEY_BRAND = "BRAND"

        fun getInstance(brand: MMBrand): SearchVideosByFragment {
            val fragment = SearchVideosByFragment()
            val bundle = Bundle().apply {
                putParcelable(KEY_BRAND, brand)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
