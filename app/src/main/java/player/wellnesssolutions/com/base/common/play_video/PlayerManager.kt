package player.wellnesssolutions.com.base.common.play_video

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.FileDataSource
import com.google.android.exoplayer2.upstream.HttpDataSource
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.check_header_api_util.HeaderData
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.custom_exoplayer.EnumTypeViewVideo
import player.wellnesssolutions.com.custom_exoplayer.PlayerUsecase
import player.wellnesssolutions.com.network.datasource.videos.SearchResultApi
import player.wellnesssolutions.com.network.datasource.videos.VideoViewResponse
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage
import player.wellnesssolutions.com.network.models.response.ResponseValue
import java.io.File
import java.lang.ref.WeakReference
import java.net.ConnectException


class PlayerManager(callback: IPlayVideoContract.Manager.Callback, context: Context) :
        BaseResponseObserver<VideoViewResponse>(), IPlayVideoContract.Manager, Player.EventListener {
    companion object {
        const val CODE_NO_ERROR = -1

        const val ERR_CODE = 100
        const val ERR_DISCONNECT = 404
        const val ERR_FORBIDDEN = 403

        const val MAX_UPDATE_VIDEO_VIEW_NUMBER = 3
    }

    private var mWeakContext: WeakReference<Context> = WeakReference(context)
    private var mPlayerUseCase: PlayerUsecase = PlayerUsecase()
    private var mErrorCode = -1

    private var mPlayerCallback: IPlayVideoContract.Manager.Callback? = callback
    private var mListeners: ArrayList<Player.EventListener> = ArrayList()

    // video data
    private var mVideos: ArrayList<MMVideo>? = null

    private var mCookieValue: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.SP_COOKIE, "")

    // handle CloseCaption related to UI
    private var mClosedCaptionController: ClosedCaptionController? = null

    // for trying load and play video number
    private var mTryCount = 0
    private val MaxTryCount = 2

    // status flags
    private var mCurrentVideoSize = -1

    private var mUpdateViewNumberAvailable = true

    // determines that update view number for the playing video successfully
    private var mHasUpdatedViewNumber = false
    private var mUpdateViewNumber = 0

    private var mPlayBackState = Player.STATE_IDLE
    private var mHasSubtitle = false

    // update view number
    private var mUpdateViewNumberService: SearchResultApi = SearchResultApi()
    private var mTypeVideo = EnumTypeViewVideo.NORMAL

    init {
        mListeners.add(this)
    }

    override fun addListener(listener: Player.EventListener) {
        if (!mListeners.contains(listener)) mListeners.add(listener)
    }

    override fun removeListener(listener: Player.EventListener) {
        mListeners.remove(listener)
    }

    override fun resumeOrIntialize(playedVideoPosition: Long, typeVideo: EnumTypeViewVideo, isUpdateViewNumber: Boolean, isSupportCC: Boolean) {
        when (mPlayerUseCase.mPlayer != null) {
            true -> onResume()
            false -> onInitialize(playedVideoPosition = playedVideoPosition, typeVideo = EnumTypeViewVideo.NORMAL, isUpdateViewNumber = isUpdateViewNumber, isSupportCC = true)
        }
    }

    // playedVideoPosition: default value is 0L
    override fun onInitialize(playedVideoPosition: Long, typeVideo: EnumTypeViewVideo, isUpdateViewNumber: Boolean, isSupportCC: Boolean) {
        val videos: ArrayList<MMVideo>? = mVideos
        if (videos == null || videos.size == 0) return
        val context: Context = mWeakContext.get() ?: return

        mPlayerCallback?.onStartIntializePlayer()

        val languageKey: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.LAST_LANGUAGE_KEY, "")
        val languageCode: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.LAST_LANGUAGE_CODE, "")

        resetData()
        this.mTypeVideo = typeVideo
        this.mUpdateViewNumberAvailable = isUpdateViewNumber

        val video: MMVideo = videos[0]
        val url: String =
                if (isUpdateViewNumber) {
                    video.videoUrl ?: Constant.EMPTY

                } else {
                    video.trailerUrl ?: Constant.EMPTY
                }

        if (playedVideoPosition >= 0) {
            mPlayerUseCase.setCurrentPlayPosition(playedVideoPosition)
        }

        val volume: Float = PreferenceHelper.getInstance(context).getFloat(ConstantPreference.SS_LAST_VOLUME_PERCENT, Constant.DEF_EXO_VOLUME)

        val subtitleLink: String =
                when (isSupportCC) {
                    true -> mVideos!![0].subtitles?.get(languageKey) ?: ""
                    false -> ""
                }

        this.mHasSubtitle = isSupportCC && subtitleLink != ""

        // update or create new CloseCaption UI base on "languages" data of video
        mClosedCaptionController?.createOrUpdateSubtitleBoardView(video.id, video.languages)

        val externalFolder: File
        val internalFolder: File
        var dataSpec: DataSpec
        if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(mWeakContext.get())) {
            val externalUrl = mWeakContext.get()?.getExternalFilesDirs(null)
            if (externalUrl?.get(1) != null) {
                externalFolder = File(externalUrl[1],
                        String.format("%s/%s", Constant.FOLDER_DOWNLOADED, video.id.toString() + ".mp4"))
                if (externalFolder.exists()) {
                    dataSpec = DataSpec(Uri.fromFile(externalFolder))
                } else {
                    internalFolder = File(context.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED, video.id.toString() + ".mp4"))
                    dataSpec = DataSpec(Uri.fromFile(internalFolder))
                }
            } else {
                internalFolder = File(context.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED, video.id.toString() + ".mp4"))
                dataSpec = DataSpec(Uri.fromFile(internalFolder))
            }

        } else {
            internalFolder = File(context.filesDir, String.format("%s/%s", Constant.FOLDER_DOWNLOADED, video.id.toString() + ".mp4"))
            dataSpec = DataSpec(Uri.fromFile(internalFolder))
        }

        val fileDataSource = FileDataSource()
        try {
            fileDataSource.open(dataSpec)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mPlayerUseCase.initPlayer(context = context, cookieValue = mCookieValue,
                url = url, subtitleLink = subtitleLink,
                languageCode = languageCode, volume = volume, typeVideo = typeVideo,
                isPlayOffline = when (isUpdateViewNumber) {
                    true -> {
                        if (VideoDBUtil.checkVideoDownloaded(data = video, tag = Constant.DownloadTag)) {
                            checkIfFileExist(video.id.toString() + ".mp4")
                        } else {
                            false
                        }
                    }
                    false -> false
                },
                fileDataSource = fileDataSource).also {

            for (listener: Player.EventListener in mListeners) {
                it.addListener(listener)
            }

            mPlayerCallback?.onPlayerInitialized(player = it)
        }
    }

    private fun checkIfFileExist(fileName: String): Boolean {
        mWeakContext.get()?.also { context ->
            if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(mWeakContext.get())) {
                val externalUrl = mWeakContext.get()?.getExternalFilesDirs(null)
                if (externalUrl?.get(1) != null) {
                    if (File(externalUrl[1],
                                    String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)).exists()) {
                        return checkSize(File(externalUrl[1],
                                String.format("%s/%s", Constant.FOLDER_DOWNLOADED, fileName)))
                    } else if ((File(context.filesDir, String.format("%s/%s",
                                    Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                        return checkSize(File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)))
                    }
                } else if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                    return checkSize(File(context.filesDir, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileName)))
                }

            } else {
                if ((File(context.filesDir, String.format("%s/%s",
                                Constant.FOLDER_DOWNLOADED, fileName)).exists())) {
                    return checkSize(File(context.filesDir, String.format("%s/%s",
                            Constant.FOLDER_DOWNLOADED, fileName)))
                }
            }

        }
        return false
    }


    private fun checkSize(fileName: File): Boolean {
        return getSizeFile(fileName) > 5
    }

    private fun getSizeFile(path: File): Int {
        return try {
            Integer.parseInt(((path.length() / 1024) / 1024).toString())
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    override fun replay() {
        mPlayerUseCase.mPlayer?.also {
            it.playWhenReady = true
            it.seekTo(0L)
        }
    }

    override fun addVideos(videos: ArrayList<MMVideo>) {
        mVideos?.clear()
        mVideos = videos
    }

    override fun addVideo(video: MMVideo) {
        if (mVideos == null) mVideos = ArrayList()
        mVideos?.add(video)
    }

    override fun playVideoAt(index: Int) {
        if (index <= 0 || mVideos == null || mVideos!!.size <= 1) return
        // removeAllVideosBeforeAt() must run before onReleasePlayer() to avoid bug
        removeAllVideosBeforeAt(index)
        onReleasePlayer(isKeepPosition = false, keepPlayWhenReady = true)
        mPlayerCallback?.onPlayNext()
    }

    private fun removeAllVideosBeforeAt(index: Int) {
        var i = 0
        while (i < index) {
            mVideos?.removeAt(0)
            i++
        }
    }

    override fun getCurrentPosition(): Long = mPlayerUseCase.getCurrentPosition()

    // reset all flags
    private fun resetData() {
        mErrorCode = CODE_NO_ERROR

        if (mVideos != null && mCurrentVideoSize != mVideos!!.size) {
            // changed the list
            mCurrentVideoSize = mVideos!!.size
            mHasUpdatedViewNumber = false
            mUpdateViewNumber = 0
        }
    }

    override fun onChangedVolume(progress: Int) {
        val value: Float = progress * 1.0f / 100

        mPlayerUseCase.mPlayer?.volume = value

        mWeakContext.get()?.also {
            PreferenceHelper.getInstance(it).putFloat(ConstantPreference.SS_LAST_VOLUME_PERCENT, value)
        }
    }

    override fun isPlaying(): Boolean {
        return mPlayerUseCase.isPlaying()
    }

    override fun onResume() {
        mPlayerUseCase.resumePlayer()
    }

    override fun onPause() {
        mPlayerUseCase.pausePlayer()
    }

    override fun onReleasePlayer(isKeepPosition: Boolean, keepPlayWhenReady: Boolean) {
        mPlayerUseCase.onRelease(isKeepPosition, keepPlayWhenReady, mListeners)
    }

    override fun onDestroy() {
        mListeners.clear()
        mClosedCaptionController?.release()
        onReleasePlayer(isKeepPosition = false, keepPlayWhenReady = false)
        mPlayerCallback = null
    }

    override fun setSubtitleController(closedCaptionController: ClosedCaptionController) {
        this.mClosedCaptionController = closedCaptionController
        closedCaptionController.setPlayerManager(this)
    }

    override fun hasPlayer(): Boolean = mPlayerUseCase.mPlayer != null

    override fun isPlayerError(): Boolean = mErrorCode > -1

    override fun getPlaybackState(): Int = mPlayBackState

    /**
     * implementing @interface Player.EventListener
     */
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        mPlayBackState = playbackState

        when (playbackState) {
            Player.STATE_ENDED -> {
                if (!mHasSubtitle) {
                    handleOnEnded()
                }
            }

            Player.STATE_READY -> {
                updatePlayingVideoViewNumber()
            }// END STATE_READY
        }
    }

    private fun updatePlayingVideoViewNumber() {
        mVideos?.also { videos ->
            // mUpdateViewNumberAvailable == true: need to update video view number
            // mHasUpdatedViewNumber == true: has updated video view number
            // videos.size > 0 && videos[0].id != null: has video in the list
            if (mUpdateViewNumberAvailable && !mHasUpdatedViewNumber && videos.size > 0 && videos[0].id != null) {
                loadApiUpdateViewNumber(videos[0].id!!)
            }

        }
    }

    override fun handleOnEnded() {
        mClosedCaptionController?.resetData()
        if (mVideos?.size ?: 0 <= 1) return
        playVideoAt(index = 1)
    }

    override fun onPlayerError(error: ExoPlaybackException?) {
        if (error == null) return
        mTryCount++

        if (mTryCount < MaxTryCount) {
            mPlayerUseCase.onRelease(isKeepPosition = true, keepPlayWhenReady = true, listeners = mListeners)
            onInitialize(playedVideoPosition = -1L, typeVideo = this.mTypeVideo) // playedVideoPosition = -1L: play video at last position before the time counted error
        } else {
            mErrorCode = ERR_CODE
            mPlayerUseCase.onRelease(isKeepPosition = true, keepPlayWhenReady = true, listeners = mListeners)

            if (error.cause is HttpDataSource.InvalidResponseCodeException) {
                val code: Int = (error.cause as HttpDataSource.InvalidResponseCodeException).responseCode
                if (code == ERR_FORBIDDEN) {
                    mErrorCode = ERR_FORBIDDEN
                    onHandleForbiddenError()
                }
            } else if (error.cause is HttpDataSource.HttpDataSourceException) {
                mErrorCode = ERR_DISCONNECT
                val isConnectException: Boolean = (error.cause as HttpDataSource.HttpDataSourceException).cause is ConnectException
                if (isConnectException) {
                    onHandleDisconnectedError()
                }
            } else {
                onHandlePlayedError()
            }
        }
    }

    private fun onHandleForbiddenError() {
        mPlayerCallback?.onCookieExpired()
    }

    private fun onHandleDisconnectedError() {
        mWeakContext.get()?.also { context ->
            val message = context.getString(R.string.error_disconnected_video)
            DialogUtil.createDialogOnlyOneButton(context = context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null).show()
        }
    }

    private fun onHandlePlayedError() {
//        mWeakContext.get()?.also { context ->
//            val message = context.getString(R.string.error_cannot_play_video)
//            DialogUtil.createDialogOnlyOneButton(context = context, message = message, titleButton = R.string.btn_ok, dialogClickListener = null).show()
//        }
    }

    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters?) {
    }

    override fun onSeekProcessed() {}

    override fun onTracksChanged(trackGroups: TrackGroupArray?, trackSelections: TrackSelectionArray?) {}

    override fun onLoadingChanged(isLoading: Boolean) {
    }

    override fun onPositionDiscontinuity(reason: Int) {}

    override fun onRepeatModeChanged(repeatMode: Int) {
    }

    override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {}

    override fun onTimelineChanged(timeline: Timeline?, manifest: Any?, reason: Int) {}

    /**
     * implemented abstract class BaseResponseObserver<T>
     */

    private fun loadApiUpdateViewNumber(videoId: Int) {
        mWeakContext.get()?.also {
            val headerData: HeaderData? = CheckHeaderApiUtil.getExpiredData(it)
            if (headerData == null || headerData.deviceId.isEmpty() || headerData.token.isEmpty()) {
                onExpired(it.getString(R.string.device_not_store_authenticated_data))
                return
            }
            mUpdateViewNumberService.updateViewNumber(token = headerData.token, deviceId = headerData.deviceId, videoId = videoId, type = this.mTypeVideo.value).subscribe(this)
        }
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)

        mUpdateViewNumber++
        if (mUpdateViewNumber < MAX_UPDATE_VIDEO_VIEW_NUMBER) {
            // update video view number again
            updatePlayingVideoViewNumber()
        }
    }

    override fun onResponseSuccess(data: ResponseValue<VideoViewResponse>?) {
        super.onResponseSuccess(data)
        mHasUpdatedViewNumber = true
    }

    override fun onClickedLanguageSubtitle(value: MMVideoLanguage) {
        if (mPlayerUseCase.isNotEnded()) {
            // release playing video with options
            onReleasePlayer(isKeepPosition = true, keepPlayWhenReady = true)
//        onInitialize(playedVideoPosition = -1, typeViewVideo = this.mTypeVideo, isPlayCC = true)
            mPlayerCallback?.onReload()
        }
    }

    override fun selectLanguageCCOption() {
        getClosedCaptionController()?.selectCurrentLanguageCCOption()
    }

    override fun slideNextLanguageCCOption() {
        getClosedCaptionController()?.slideNextLanguageCCOption()
    }

    override fun onExpired(error: String) {
        mPlayerCallback?.onCookieExpired()
    }

    override fun onExpiredUnauthenticated(error: String) {
        mPlayerCallback?.onCookieExpired()
    }

    override fun getClosedCaptionController(): ClosedCaptionController? = mClosedCaptionController

    override fun isPlayingCC(): Boolean = mHasSubtitle

    override fun getPlayer(): SimpleExoPlayer? = mPlayerUseCase.mPlayer

    /**
     * end abstract class BaseResponseObserver<T>
     */
}