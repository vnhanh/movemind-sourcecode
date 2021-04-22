package player.wellnesssolutions.com.ui.fragment_now_playing.helper

import android.content.Context
import android.content.DialogInterface
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.graphics.ColorUtils
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.custom_controller_player_screen_now_playing.view.*
import kotlinx.android.synthetic.main.fragment_now_playing.view.*
import kotlinx.android.synthetic.main.merge_layout_bottom_bar_screen_now_playing.view.*
import kotlinx.android.synthetic.main.merge_now_playing_coming_up_next.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.custom_exoplayer.EnumVolumeLevel
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.INowPlayingConstruct
import player.wellnesssolutions.com.ui.fragment_now_playing.NowPlayingFragment
import player.wellnesssolutions.com.ui.fragment_now_playing.recyclerview.MMVideoNowPlayingView
import java.util.concurrent.TimeUnit


object NowPlayingVideoSetupHelper {
    private var mBottomBarHeight = 0
    private var mScreenHeight = 0
    val SUBTITLES_TEXTSIZE = 30
    private var mIsPresentation = false
    private var isClicked = false

    fun setupViewsForPlayer(parentView: View, presenter: INowPlayingConstruct.Presenter?, isPresentation: Boolean = false) {
        if (presenter == null) return
        mIsPresentation = isPresentation
        setupPlayerViews(parentView, videoPlayer = parentView.videoPlayer, presenter = presenter)
    }

    private fun setupPlayerViews(parentView: View, videoPlayer: PlayerView?, presenter: INowPlayingConstruct.Presenter?) {
        parentView.resources?.also {
            setupDownloadButton(it, parentView.btnDownload)
        }

        setupButtonOfVideo(parentView, videoPlayer, presenter)

        setupVideoPlayer(parentView, videoPlayer, parentView.barBottom, presenter)
    }

    private fun setupButtonOfVideo(parentView: View?, videoPlayer: PlayerView?, presenter: INowPlayingConstruct.Presenter?) {
        if (parentView == null) return

        parentView.btnPlayVideo?.setOnClickListener {
            parentView.groupViewsComingUpNext?.visibility = View.GONE
            if (videoPlayer?.player?.playbackState == Player.STATE_ENDED && presenter?.getPlayMode() == PlayMode.ON_DEMAND)
                presenter.replayVideo()
            else
                videoPlayer?.exo_play?.performClick()
        }

        parentView.btnPauseVideo?.setOnClickListener {
            parentView.groupViewsComingUpNext?.visibility = View.GONE
            videoPlayer?.exo_pause?.performClick()
        }
    }

    private fun setupDownloadButton(resources: Resources, btnDownload: ImageView?) {
        val downloadButtonSize = resources.getDimensionPixelSize(R.dimen.size_btn_download_in_now_playing)
        val downloadButtonPadding = resources.getDimensionPixelSize(R.dimen.marginx2)
        val iconDownloadSize = downloadButtonSize - downloadButtonPadding

        btnDownload?.let {
            Glide.with(it)
                    .load(R.drawable.ic_download)
                    .override(iconDownloadSize)
                    .into(it)
        }
    }

    /**
     * call from {@link #setupUI()}
     */
    private fun setupVideoPlayer(parentView: View?, videoPlayer: PlayerView?, barBottom: View?, presenter: INowPlayingConstruct.Presenter?) {
        parentView?.also { view ->
            if (mBottomBarHeight == 0) mBottomBarHeight = view.resources.getDimensionPixelSize(R.dimen.height_bottom_logo) + view.resources.getDimensionPixelSize(R.dimen.marginx2)

            if (mScreenHeight == 0) {
                val metrics = DisplayMetrics()
                val windowManager = view.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                windowManager.defaultDisplay.getMetrics(metrics)
                mScreenHeight = metrics.heightPixels
            }
        }

        val frameExoVolumeSeekBar = parentView?.frameExoVoume
        val btnExoVolume = parentView?.seekbarVolume
        setupVolumeButton(videoPlayer, frameExoVolumeSeekBar, btnExoVolume, presenter)

        val btnExoFullScreen = videoPlayer?.exo_fullscreen
        val viewBottomVideoPlayer = barBottom?.viewBgGroupControllers
        setupToggleFullScreenButton(parentView, videoPlayer, btnExoFullScreen, viewBottomVideoPlayer, barBottom)
    }

    fun getHeight(context: Context, text: String, textSize: Float, typeface: Typeface, padding: Int): Int {
        val textView = TextView(context)
        textView.setPadding(padding, padding, padding, padding)
        textView.typeface = typeface
        textView.setText(text, TextView.BufferType.SPANNABLE)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize)

        val metrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(metrics)

        val widthMeasureSpec: Int = View.MeasureSpec.makeMeasureSpec(metrics.widthPixels, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec: Int = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        textView.measure(widthMeasureSpec, heightMeasureSpec)
        return textView.measuredHeight
    }

    /**
     * call from {@link #setupVideoPlayer()}
     */
    private var isVideoPlayerFullScreen = false

    private fun setupToggleFullScreenButton(parenView: View?, videoPlayer: PlayerView?, btnExoFullScreen: ImageView?, viewBottomVideoPlayer: View?, barBottom: View?) {
        btnExoFullScreen?.also { view ->
            view.setOnClickListener {
                it.isEnabled = false
                clickedButtonExoFullScreen(parenView, videoPlayer, btnExoFullScreen, viewBottomVideoPlayer, barBottom)
                it.isEnabled = true
            }
        }
    }

    private fun clickedButtonExoFullScreen(parenView: View?, videoPlayer: PlayerView?, btnExoFullScreen: ImageView?, viewBottomVideoPlayer: View?, barBottom: View?) {
        if (isVideoPlayerFullScreen) {
            setNormalViewPlayerVideo(parenView, videoPlayer, btnExoFullScreen, viewBottomVideoPlayer, barBottom)
        } else {
            setFullScreenPlayerVideo(parenView, videoPlayer, btnExoFullScreen, barBottom)
        }

        isVideoPlayerFullScreen = !isVideoPlayerFullScreen
    }

    /**
     * call from {@link #setupVideoPlayer()}
     */

    // flags
    private var mLatestVolumeLevel = EnumVolumeLevel.UP

    private fun setupVolumeButton(videoPlayer: PlayerView?, frameExoVolumeSeekbar: View?, seekbarExoVolume: SeekBar?, presenter: INowPlayingConstruct.Presenter?) {
        videoPlayer?.exo_volume?.also { view ->
            view.setOnClickListener {
                if (frameExoVolumeSeekbar?.visibility == View.VISIBLE) {
                    frameExoVolumeSeekbar.visibility = View.GONE
                } else {
                    frameExoVolumeSeekbar?.visibility = View.VISIBLE
                }
            }
        }

        seekbarExoVolume?.also { view ->
            view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar, progress: Int, p3: Boolean) {
                    presenter?.onChangeVolume(seekbar.context, progress)

                    when (progress) {
                        0 -> {
                            if (mLatestVolumeLevel != EnumVolumeLevel.MUTE)
                                videoPlayer?.exo_volume?.setImageResource(R.drawable.ic_volume_mute_white_28dp)
                            mLatestVolumeLevel = EnumVolumeLevel.MUTE
                        }
                        in 1..70 -> {
                            if (mLatestVolumeLevel != EnumVolumeLevel.DOWN)
                                videoPlayer?.exo_volume?.setImageResource(R.drawable.ic_volume_down_white_28dp)
                            mLatestVolumeLevel = EnumVolumeLevel.DOWN
                        }
                        else -> {
                            if (mLatestVolumeLevel != EnumVolumeLevel.UP)
                                videoPlayer?.exo_volume?.setImageResource(R.drawable.ic_volume_up_white_28dp)
                            mLatestVolumeLevel = EnumVolumeLevel.UP
                        }
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }
            })
        }
    }

    /**
     * call from {@link #setupToggleFullScreenButton()}
     */
    private fun setFullScreenPlayerVideo(parenView: View?, videoPlayer: PlayerView?, btnExoFullScreen: ImageView?, barBottom: View?) {
        parenView?.also { layout ->
            videoPlayer?.also { vidPlayer ->
                if (layout is ConstraintLayout) {
                    val set = ConstraintSet()
                    set.clone(layout)
                    set.connect(vidPlayer.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
                    set.applyTo(layout)

                    barBottom?.visibility = View.GONE

                }
            }
            btnExoFullScreen?.setImageResource(R.drawable.ic_fullscreen_exit_white_28dp)
        }
    }

    /**
     * call from {@link #setupToggleFullScreenButton()}
     */
    private fun setNormalViewPlayerVideo(parenView: View?, videoPlayer: PlayerView?, btnExoFullScreen: ImageView?, viewBottomVideoPlayer: View?, barBottom: View?) {
        parenView?.also { layout ->
            videoPlayer?.also { vidPlayer ->
                if (layout is ConstraintLayout) {
                    barBottom?.visibility = View.VISIBLE

                    val set = ConstraintSet()
                    set.clone(layout)
                    set.connect(vidPlayer.id, ConstraintSet.BOTTOM, viewBottomVideoPlayer?.id
                            ?: 0, ConstraintSet.TOP)
                    set.applyTo(layout)

                    btnExoFullScreen?.setImageResource(R.drawable.ic_fullscreen_white_28dp)
                }
            }
        }
    }

    private var mRvTouchedX = 0f
    private var mRvTouchedY = 0f

    fun setupComingUpNext(view: View, menuSetupHelper: NowPlayingFloatMenuHelper? = null, presenter: IComingUpNextClickListener? = null) {
        view.groupViewsComingUpNext?.rvComingUpNext?.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mRvTouchedX = event.x
                    mRvTouchedY = event.y
                }

                MotionEvent.ACTION_UP -> {
                    val translatedX = event.x - mRvTouchedX
                    val translatedY = event.y - mRvTouchedY
                    if (translatedX < 10f && translatedY < 10f) {
                        presenter?.onTapGroupComingUpNext()
                    }
                }
            }

            return@setOnTouchListener false
        }

        val wrapperVideoNowPlaying: MMVideoNowPlayingView? = view.groupViewsComingUpNext?.containerNowPlayingGCU
        val bgNowPlayingItemVideo: View? = view.groupViewsComingUpNext?.barTopWrapperVideoNowPlayingGroupComingUpNext

        setBackgroundForVideoNowPlaying(wrapperVideoNowPlaying = wrapperVideoNowPlaying, bgNowPlayingItemViedeo = bgNowPlayingItemVideo)

        // init
        val constraintLayoutUp = view.constraintArrowUp
        val constraintLayoutDown = view.constraintArrowDown

        view.btnComingUpNext?.setOnClickListener {
            it.isEnabled = false
            if (isClicked) {
                constraintLayoutUp?.visibility = View.VISIBLE
                constraintLayoutDown?.visibility = View.INVISIBLE
            } else {
                constraintLayoutUp?.visibility = View.INVISIBLE
                constraintLayoutDown?.visibility = View.VISIBLE
            }
            // reverse
            isClicked = !isClicked
            // close float menu if it has been opening
            menuSetupHelper?.closeFloatMenu()
            clickedBtnComingUpNext(view.groupViewsComingUpNext)
            it.isEnabled = true
        }

    }

    private fun setBackgroundForVideoNowPlaying(wrapperVideoNowPlaying: MMVideoNowPlayingView?, bgNowPlayingItemViedeo: View?) {
        if (wrapperVideoNowPlaying == null || bgNowPlayingItemViedeo == null) return

        var strSecondaryColor = PreferenceHelper.getInstance(wrapperVideoNowPlaying.context)
                .getString(ConstantPreference.SECONDARY_COLOR, Constant.DEF_SECONDARY_COLOR)

        if (strSecondaryColor.isEmpty()) {
            strSecondaryColor = Constant.DEF_SECONDARY_COLOR
        }

        val primaryColor = Color.parseColor(strSecondaryColor)

        wrapperVideoNowPlaying.setBackgroundColor(primaryColor)

        val darkColor = ColorUtils.blendARGB(primaryColor, Color.BLACK, 0.3f)
        val gd = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(darkColor, primaryColor))
        bgNowPlayingItemViedeo.background = gd
    }

    private fun clickedBtnComingUpNext(groupViewsComingUpNext: View?) {
        if (groupViewsComingUpNext == null) return
        val wasDisplaying = groupViewsComingUpNext.visibility == View.VISIBLE
        if (wasDisplaying) {
            groupViewsComingUpNext.visibility = View.GONE
        } else {
            val anim = AnimationUtils.loadAnimation(groupViewsComingUpNext.context, R.anim.alpha_02_10_duration_400)
            groupViewsComingUpNext.visibility = View.VISIBLE
            groupViewsComingUpNext.startAnimation(anim)
        }
    }

    fun showDialogNavigateToNoClassScreen(context: Context, fm: FragmentManager?, isClickedFromBtnBottom: Boolean) {
        val message = context.getString(R.string.confirm_stop_video_and_navigate_to_screen_get_started)
        val okButtonListener = DialogInterface.OnClickListener { _, _ ->
            openHomeFragmentWithNotLoadSchedule(fm)
        }

        DialogUtil.createDialogOnlyOneButton(
                context = context,
                message = message,
                titleButton = R.string.btn_yes,
                dialogClickListener = okButtonListener
        ).show()
    }

    fun openHomeFragmentWithLoadSchedule(fm: FragmentManager?) {
        Log.d("LOG", this.javaClass.simpleName + " openHomeFragmentWithLoadSchedule()")
        fm?.also { _fm ->
            val tag = HomeFragment.TAG
            var fragment = _fm.findFragmentByTag(tag)
            fragment =
                    when (fragment != null && fragment is HomeFragment) {
                        true -> {
                            HomeFragment.updateAlreadyInstanceWithLoadSchedule(fragment)
//                            _fm.beginTransaction().remove(fragment).commitAllowingStateLoss()
//                            HomeFragment.getInstanceWithLoadSchedule()
                        }
                        false -> HomeFragment.getInstanceWithLoadSchedule()
                    }
            FragmentUtil.replaceFragment(fm = _fm, newFragment = fragment, newFragmentTag = tag, frameId = R.id.frameLayoutHome, isAddToBackStack = false, isRemoveOlds = true)
        }
    }

    fun openHomeFragmentWithNotLoadSchedule(fm: FragmentManager?) {
        fm?.also { _fm ->
            Log.d("LOG", this.javaClass.simpleName + " openHomeFragmentWithNotLoadSchedule()")
            val tag = HomeFragment.TAG
            var fragment = _fm.findFragmentByTag(tag)
            fragment =
                    when (fragment != null && fragment is HomeFragment) {
                        true -> {
                            HomeFragment.updateAlreadyInstanceWithNotLoadSchedule(fragment)
                        }
                        false -> HomeFragment.getInstanceNotLoadSchedule()
                    }
            FragmentUtil.replaceFragment(fm = _fm, newFragment = fragment, newFragmentTag = tag, frameId = R.id.frameLayoutHome, isAddToBackStack = false, isRemoveOlds = true)
        }
    }

    fun openHomeFragmentWithNotLoadScheduleAndShowPopup(fm: FragmentManager?, message: String) {
        try {
            openHomeScreenNotLoadScheduleAndShowPopUp(fm, message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun openHomeScreenNotLoadScheduleAndShowPopUp(fm: FragmentManager?, message: String) {
        fm?.also { _fm ->
            Log.d("LOG", this.javaClass.simpleName + " openHomeFragmentWithNotLoadSchedule()")
            val tag = HomeFragment.TAG
            var fragment = _fm.findFragmentByTag(tag)
            fragment =
                    when (fragment != null && fragment is HomeFragment) {
                        true -> {
                            HomeFragment.updateAlreadyInstanceWithNotLoadScheduleAndShowPopUp(fragment, message)
                        }
                        false -> HomeFragment.getInstanceNotLoadScheduleAndShowPopUp(message)
                    }
            FragmentUtil.replaceFragment(fm = _fm, newFragment = fragment, newFragmentTag = tag, frameId = R.id.frameLayoutHome, isAddToBackStack = false, isRemoveOlds = true)
        }
    }

    fun openNowPlayingWithSchedule(fm: FragmentManager?) {
        Log.d("LOG", this.javaClass.simpleName + " openNowPlayingWithSchedule()")
        openNowPlayingPlaySchedule(fm)
    }

    fun openNowPlayingPlaySchedule(fm: FragmentManager?) {
        fm?.also { _fm ->
            val tag = NowPlayingFragment.TAG
            var fragment = _fm.findFragmentByTag(tag)
            fragment =
                    when (fragment != null && fragment is NowPlayingFragment) {
                        true -> {
//                            _fm.beginTransaction().remove(fragment).commitAllowingStateLoss()
                            NowPlayingFragment.updateAlreadyInstanceWithSchedule(fragment)
                        }
                        false -> NowPlayingFragment.getInstancePlaySchedule()
                    }
            FragmentUtil.replaceFragment(fm = _fm, newFragment = fragment, newFragmentTag = tag, frameId = R.id.frameLayoutHome, isAddToBackStack = true, isRemoveOlds = true)
        }
    }

}