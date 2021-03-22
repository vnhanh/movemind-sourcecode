package player.wellnesssolutions.com.ui.fragment_splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_splash.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment


class SplashFragment : BaseFragment(), ISplashContract.View, View.OnClickListener {
    private lateinit var mPresenter: ISplashContract.Presenter
    private val PERIOD = 100L
    private var MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE = 60
    private var mIsStopProgressbar = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = SplashPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        icRefresh.setOnClickListener(this)
        tvRetry.setOnClickListener(this)

        MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE = 60 * progressLoadBrand.max / 100 // max 60 % loading
    }

    override fun onStartLoadApi() {
        progressLoadBrand?.also {
            mIsStopProgressbar = false
            it.progressDrawable = ContextCompat.getDrawable(progressLoadBrand.context, R.drawable.progress_splash_default)
            it.progress = 0
            it.postDelayed(mProgressRunnable, PERIOD)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            icRefresh?.id, tvRetry?.id -> onClickedRefreshView(view)
        }
    }

    private fun onClickedRefreshView(view: View?) {
        if (view == null) return

        icRefresh?.visibility = View.GONE
        tvRetry?.visibility = View.GONE

        view.isEnabled = false
        progressLoadBrand.progress = 0
        progressLoadBrand?.postDelayed(mProgressRunnable, PERIOD)
        progressLoadBrand?.visibility = View.VISIBLE
        mPresenter.loadApi()
        view.isEnabled = true
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onAttach(this)

    }

    override fun onPause() {
        super.onPause()
        mPresenter.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun updateProgress(progress: Int) {
        when (progress) {
            in 0..100 -> {
                progressLoadBrand?.also {
                    it.progress = progress * it.max / 100
                }
            }

            else -> {
                mIsStopProgressbar = true
            }
        }
    }

    override fun navigateToHomeScreen() {
        view?.postDelayed(Runnable {
            FragmentUtil.replaceFragment(
                    fm = activity?.supportFragmentManager,
                    newFragment = HomeFragment.getInstance(),
                    newFragmentTag = HomeFragment.TAG,
                    frameId = R.id.frameLayoutHome,
                    isAddToBackStack = false
            )
        }, 500L)
    }

    override fun onExpired(message: String) {
        super.onExpired(message)
        mIsStopProgressbar = true
    }

    private val mProgressRunnable = object : Runnable {
        override fun run() {
            progressLoadBrand?.also { progressBar ->
                when (mIsStopProgressbar) {
                    true -> {
                        progressBar.progressDrawable = ContextCompat.getDrawable(progressBar.context, R.drawable.progress_splash_failed)
                    }

                    false -> {
                        val progress = progressBar.progress + 1

                        if (progress < MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE) {
                            progressBar.progress = progress
                            progressBar.postDelayed(this, PERIOD)
                        }
                    }
                }
            }
        }

    }
}
