package player.wellnesssolutions.com.ui.fragment_splash

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_splash.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.IGetNewToken
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment


class SplashFragment : BaseFragment(), ISplashContract.View, View.OnClickListener {
    private var mPresenter: ISplashContract.Presenter? = null
    private val PERIOD = 100L
    private var MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE = 60
    private var mIsStopProgressbar = false
    private var mDialog: AlertDialog? = null

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
        mPresenter?.loadApi()
        view.isEnabled = true
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.onAttach(this)
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
        mDialog?.dismiss()
        mPresenter?.onDestroy()
    }

    override fun updateProgress(progress: Int) {
        mDialog?.dismiss()
        when (progress) {
            in 0..100 -> {
                progressLoadBrand?.also {
                    it.progress = progress * it.max / 100
                }
            }

            else -> {
                mIsStopProgressbar = true
                progressLoadBrand?.also { progressBar ->
                    progressBar.progressDrawable = ContextCompat.getDrawable(progressBar.context, R.drawable.progress_splash_failed)
                }
            }
        }
    }

    override fun navigateToHomeScreen() {
        view?.postDelayed(Runnable {
            FragmentUtil.replaceFragment(
                    fm = activity?.supportFragmentManager,
                    newFragment = HomeFragment.getInstanceWithLoadSchedule(),
                    newFragmentTag = HomeFragment.TAG,
                    frameId = R.id.frameLayoutHome,
                    isAddToBackStack = false
            )
        }, 500L)
    }

    override fun onCallServiceFailed(messageRes: Int) {
        mDialog?.dismiss()
        context?.also { _context ->
            mDialog = DialogUtil.createDialogOnlyOneButton(context = _context,
                    msgResId = messageRes,
                    titleButton = R.string.btn_ok,
                    dialogClickListener = object : DialogInterface.OnClickListener {
                        override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                            dialogInterface?.dismiss()
                        }

                    }).also {
                it.show()
            }
        }

    }

    override fun backToScanQRCode() {
        mDialog?.dismiss()
        this.onExpired("")
    }

    override fun onExpired(message: String) {
        mDialog?.dismiss()
        super.onExpired(message)
    }

    override fun callGetTokenAgain() {
        activity?.also { activity ->
            (activity as MainActivity).getTokenAgainWhenTokenExpire(object : IGetNewToken {
                override fun onGetSuccess() {
                    mPresenter?.loadApi()
                }
            })
        }
    }

    private val mProgressRunnable = object : Runnable {
        override fun run() {
            progressLoadBrand?.also { progressBar ->
                when (mIsStopProgressbar) {
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
