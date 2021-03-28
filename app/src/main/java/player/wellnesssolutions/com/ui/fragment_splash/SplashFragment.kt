package player.wellnesssolutions.com.ui.fragment_splash

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.util.Log
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
    private var isStopProgressBar = false
    private var dialog: AlertDialog? = null
    private val handler = Handler()

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
            isStopProgressBar = false
            it.progressDrawable = ContextCompat.getDrawable(progressLoadBrand.context, R.drawable.progress_splash_default)
            it.progress = 0
            handler.postDelayed(runnableLoading, PERIOD)
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
        handler.postDelayed(runnableLoading, PERIOD)
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
        handler.removeCallbacks(runnableLoading)
        dialog?.dismiss()
        mPresenter?.onDestroy()
    }

    override fun updateProgress(progress: Int) {
        dialog?.dismiss()
        when (progress) {
            in 0..100 -> {
                progressLoadBrand?.also {
                    it.progress = progress * it.max / 100
                }
            }

            else -> {
                Log.d("LOG", this.javaClass.simpleName + " updateProgress() | progress: $progress")
                isStopProgressBar = true
                progressLoadBrand?.also { progressBar ->
                    progressBar.progressDrawable = ContextCompat.getDrawable(progressBar.context, R.drawable.progress_splash_failed)
                    progressBar.progress = progressBar.max
                }
            }
        }
    }

    override fun navigateToHomeScreen() {
        Log.d("LOG", this.javaClass.simpleName + " navigateToHomeScreen()")
        FragmentUtil.replaceFragment(
                fm = activity?.supportFragmentManager,
                newFragment = HomeFragment.getInstanceWithLoadSchedule(),
                newFragmentTag = HomeFragment.TAG,
                frameId = R.id.frameLayoutHome,
                isAddToBackStack = false
        )
    }

    override fun onCallServiceFailed(messageRes: Int) {
        Log.d("LOG", this.javaClass.simpleName + " onCallServiceFailed() | stop progress bar")
        isStopProgressBar = true
        dialog?.dismiss()
        context?.also { _context ->
            dialog = DialogUtil.createDialogOnlyOneButton(context = _context,
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
        dialog?.dismiss()
        this.onExpired("")
    }

    override fun onExpired(message: String) {
        dialog?.dismiss()
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

    private val runnableLoading = object : Runnable {
        override fun run() {
            try {
                progressLoadBrand?.also { progressBar ->
                    Log.d("LOG", "Splash Screen | isStopProgressBar: $isStopProgressBar")
                    when (isStopProgressBar) {
                        false -> {
                            val progress = progressBar.progress + 1

                            if (progress < MAX_PROGRESS_BEFORE_RECEIVE_RESPONSE) {
                                progressBar.progress = progress
                                progressBar.postDelayed(this, PERIOD)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}
