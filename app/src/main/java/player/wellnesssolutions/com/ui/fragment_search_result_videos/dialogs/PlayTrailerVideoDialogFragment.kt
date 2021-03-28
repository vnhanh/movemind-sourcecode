package player.wellnesssolutions.com.ui.fragment_search_result_videos.dialogs


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.SeekBar
import androidx.fragment.app.DialogFragment
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import kotlinx.android.synthetic.main.custom_controller_player_dialog_search_result.*
import kotlinx.android.synthetic.main.fragment_dialog_trailer_video.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.common.play_video.IPlayVideoContract
import player.wellnesssolutions.com.base.common.play_video.PlayVideoDisplayHelper
import player.wellnesssolutions.com.base.common.play_video.PlayerManager
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo
import player.wellnesssolutions.com.custom_exoplayer.EnumVolumeLevel
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.MainActivity


class PlayTrailerVideoDialogFragment : DialogFragment(), IPlayVideoContract.Manager.Callback, Player.EventListener {
    private var mPlayerManager: IPlayVideoContract.Manager? = null
    private var mVideoName: String? = null

    private var mIsFullscreen = false

    // flags
    private var mLatestVolumeLevel = EnumVolumeLevel.UP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPlayerManager = PlayerManager(callback = this, context = context).also {
            it.addListener(this)
        }

        readArguments()

        setStyle(STYLE_NO_FRAME, R.style.DialogTheme)
    }

    private fun readArguments() {
        val videoData: MMVideo? = arguments?.getParcelable(EXTRA_VIDEO)

        arguments?.clear()

        if (videoData == null) {
            MessageUtils.showToast(context, R.string.can_not_show_video, R.color.red)
            dismiss()
            return
        }

        mVideoName = videoData.videoName
        mPlayerManager?.addVideo(videoData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog_trailer_video, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        setupLayoutForTitleView()

        ViewUtil.setupButton(view, this::dismiss)

        setupDimensions()
        setupToggleFullScreenButton()
        setupButtonPlayPauseVideo()
        setupVolumeButton()
    }

    private fun setupLayoutForTitleView() {
        val leftMargin = resources.getDimensionPixelSize(R.dimen.margin_left_tv_title_video_dialog_playing_video_search_result)
        val topMargin = resources.getDimensionPixelSize(R.dimen.margin_top_tv_title_video_dialog_playing_video_search_result)

        val params = tvTitleVideo.layoutParams as RelativeLayout.LayoutParams
        params.setMargins(leftMargin, topMargin, 0, 0)
        tvTitleVideo.layoutParams = params
    }

    private fun setupDimensions() {
        setupNormalDimensDialog()
    }

    private fun setupButtonPlayPauseVideo() {
        ViewUtil.setupButton(btnPlayVideoSR, this::onClickedPlayButton)
        ViewUtil.setupButton(btnPauseVideoSR, this::onClickedPauseButton)
    }

    private fun onClickedPlayButton() {
        if (mPlayerManager?.getPlaybackState() == Player.STATE_ENDED) {
            mPlayerManager?.replay()
        } else {
            exo_play.performClick()
        }
    }

    private fun onClickedPauseButton() {
        exo_pause.performClick()
    }

    private fun setupVolumeButton() {
        frameExoVoumeSeebar.visibility = View.GONE

        ViewUtil.setupButton(exo_volume, this::changeDisplayVolumeView)

        exoVolumeSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p3: Boolean) {
                mPlayerManager?.onChangedVolume(progress)

                when (progress) {
                    0 -> {
                        if (mLatestVolumeLevel != EnumVolumeLevel.MUTE)
                            exo_volume.setImageResource(R.drawable.ic_volume_mute_white_24dp)
                        mLatestVolumeLevel = EnumVolumeLevel.MUTE
                    }
                    in 1..70 -> {
                        if (mLatestVolumeLevel != EnumVolumeLevel.DOWN)
                            exo_volume.setImageResource(R.drawable.ic_volume_down_white_24dp)
                        mLatestVolumeLevel = EnumVolumeLevel.DOWN
                    }
                    else -> {
                        if (mLatestVolumeLevel != EnumVolumeLevel.UP)
                            exo_volume.setImageResource(R.drawable.ic_volume_up_white_24dp)
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

    private fun changeDisplayVolumeView() {
        if (frameExoVoumeSeebar.visibility != View.GONE) {
            frameExoVoumeSeebar.visibility = View.GONE
        } else {
            frameExoVoumeSeebar.visibility = View.VISIBLE
        }
    }

    private fun setupToggleFullScreenButton() {
        ViewUtil.setupButton(exo_fullscreen, this::onClickedFullScreenButton)
    }

    private fun onClickedFullScreenButton() {
        if (mIsFullscreen) {
            setupNormalDimensDialog()
            exo_fullscreen.setImageResource(R.drawable.ic_fullscreen_white_24dp)
        } else {
            setupFullscreenDialog()
            exo_fullscreen.setImageResource(R.drawable.ic_fullscreen_exit_white_24dp)
        }
        mIsFullscreen = !mIsFullscreen
    }

    private fun setupFullscreenDialog() {
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    private fun setupNormalDimensDialog() {
        val width = resources.getDimensionPixelSize(R.dimen.width_normal_screen_playing_video_search_result)
        val height = resources.getDimensionPixelSize(R.dimen.height_normal_screen_playing_video_search_result)
        dialog?.window?.setLayout(width, height)
        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

    override fun onStart() {
        super.onStart()
        // playedVideoPosition = -1L: play video from playing position itself
        when (videoPlayer.player != null) {
            true -> {
                // do nothing
            }

            false -> mPlayerManager?.onInitialize(playedVideoPosition = -1L, typeVideo = EnumTypeViewVideo.NORMAL)
        }

    }

    override fun onPause() {
//        mPlayerManager?.onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = false)
        mPlayerManager?.onPause()
        super.onPause()
    }

    override fun onDestroyView() {
        videoPlayer.setControllerVisibilityListener(null)
        mPlayerManager?.onDestroy()
        mPlayerManager = null
        super.onDestroyView()
    }

    /**
     * @interface Player.EventListener
     */
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        if (progressLoading == null || btnPlayVideoSR == null || btnPauseVideoSR == null) return

        when (playbackState) {
            Player.STATE_IDLE, Player.STATE_BUFFERING -> {
                PlayVideoDisplayHelper.displayViewsOnBuffering(progressLoading, btnPlayVideoSR, btnPauseVideoSR)
            }

            Player.STATE_READY -> {
                val isControllerVisible = videoPlayer.isControllerVisible

                PlayVideoDisplayHelper.displayOnReady(isControllerVisible, playWhenReady, progressLoading, btnPlayVideoSR, btnPauseVideoSR)
            }

            Player.STATE_ENDED -> {
                PlayVideoDisplayHelper.displayOnEnded(progressLoading, btnPlayVideoSR, btnPauseVideoSR)
            }
        }
    }

    override fun onStartIntializePlayer() {
        videoPlayer?.hideController()
        showLoadingProgress()
    }

    @SuppressLint("WrongConstant")
    override fun onPlayerInitialized(players: SimpleExoPlayer) {
        if (videoPlayer == null) return


        if (android.os.Build.VERSION.SDK_INT >= 28) {
            val attAudio = AudioAttributes.Builder()
                    .setUsage(C.USAGE_ALARM)
                    .setContentType(C.STREAM_TYPE_NOTIFICATION)
                    .build()
            players.setAudioAttributes(attAudio, false)

        } else {
            val attAudio = AudioAttributes.Builder()
                    .setUsage(C.STREAM_TYPE_NOTIFICATION)
                    .setContentType(C.STREAM_TYPE_NOTIFICATION)
                    .build()
            players.setAudioAttributes(attAudio, false)

        }

        exoVolumeSeekbar.progress = (players.volume * 100).toInt()
        if (players.volume == 0f) exo_volume.setImageResource(R.drawable.ic_volume_mute_white_24dp)

        videoPlayer.player = players


        //player.audioStreamType = C.STREAM_TYPE_ALARM
        // show video name
        mVideoName?.also {
            tvTitleVideo.text = StringBuilder(it).append(Constant.WHITE_SPACE).toString()
        }

        videoPlayer.setControllerVisibilityListener {
            if (it == View.VISIBLE && progressLoading != null && progressLoading.visibility != View.VISIBLE) {
                // not play failed and isPlayWhenReady -> true
                val isPlaying = (false == mPlayerManager?.isPlayerError()) && videoPlayer.player.playWhenReady
                val state = videoPlayer.player.playbackState

                if (state == Player.STATE_ENDED)
                    PlayVideoDisplayHelper.displayOnEnded(progressLoading, btnPlayVideoSR, btnPauseVideoSR)
                else
                    displayButtonPlayPauseVideo(isPlaying)

            } else {
                hideButtonPlayPauseVideo()
                frameExoVoumeSeebar.visibility = View.GONE
            }
        }
    }

    private fun hideButtonPlayPauseVideo() {
        btnPlayVideoSR?.visibility = View.GONE
        btnPauseVideoSR?.visibility = View.GONE
    }

    private fun displayButtonPlayPauseVideo(isPlaying: Boolean) {
        when (isPlaying) {
            true -> {
                btnPlayVideoSR?.visibility = View.GONE
                btnPauseVideoSR?.visibility = View.VISIBLE
            }

            false -> {
                btnPauseVideoSR?.visibility = View.GONE
                btnPlayVideoSR?.visibility = View.VISIBLE
            }
        }
    }

    private fun showLoadingProgress() {
        progressLoading?.visibility = View.VISIBLE
    }

    private fun hideLoadingProgress() {
        progressLoading?.also {
            it.visibility = View.GONE
        }
    }

    override fun onCookieExpired() {
        activity?.also {
            if (it is MainActivity) {
                it.onCookieExpired()
            }
        }
    }


    /**
     * --------------
     */

    companion object {
        val TAG = "PlayTrailerVideoDialogFragment"
        val EXTRA_VIDEO = "KEY DATA"

        fun getInstance(videoData: MMVideo): PlayTrailerVideoDialogFragment =
                PlayTrailerVideoDialogFragment().apply {
                    arguments = Bundle().also {
                        it.putParcelable(EXTRA_VIDEO, videoData)
                    }
                }
    }
}
