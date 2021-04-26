package player.wellnesssolutions.com.base.common.load_scheduled_videos

import android.content.Context
import android.os.Handler
import android.util.Log
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.view.IGetNewToken
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.now_playing.NowPlayingApi
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime
import player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime

class SchedulePresenter(private var context: Context?) : BaseResponseObserver<ArrayList<MMVideo>>(), IScheduleContract.Presenter,
        IListenerHandleScheduleTime {
    companion object {
        const val MSG_REQUEST_FAILED = "Request class videos failed !"
    }

    // vars
    private var mView: IScheduleContract.View? = null
    private var scheduleApi = NowPlayingApi()
    private var handlerScheduleTime: HandlerScheduleTime = HandlerScheduleTime(context, this)
    private var scheduleVideos: ArrayList<MMVideo> = arrayListOf()
    private val handler = Handler()
    private var counterTryPostDelay = 0

    // flags
    private var isClickedFromBtnBottom = false
    private var isLoadScheduleOnStart = false
    private var isUpdatingNewSchedule = false
    private var isPerformNextScheduleOnAttachView = false
    private var isPerformingNextScheduleVideo = false
    private var isLoading = false


    private val runnable = object : Runnable {
        override fun run() {
            try {
                isClickedFromBtnBottom = false
                loadSchedule()
            } catch (e: Exception) {
                e.printStackTrace()
                if (counterTryPostDelay++ < Constant.NUM_MAX_TRY_POST_DELAY) {
                    handler.postDelayed(this, Constant.TIME_POST_DELAY_DEFAULT)
                }
            }
        }

    }

    private val runnableHanldeTimeForSchedule = Runnable {
        performForNextSchedule()
    }

    init {
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_LOADING_SCHEDULE, false)
    }

    override fun onAttach(view: IScheduleContract.View) {
        Log.d("LOG", this.javaClass.simpleName + " onAttach()")
        this.mView = view
        view.getViewContext()?.also { viewContext ->
            context = viewContext
            handlerScheduleTime.release()
            handlerScheduleTime = HandlerScheduleTime(viewContext, this)
        }
        if (isLoadScheduleOnStart) {
            isLoadScheduleOnStart = false
            handler.postDelayed(runnable, 1000L)
        } else if (isPerformNextScheduleOnAttachView) {
            handler.postDelayed(runnableHanldeTimeForSchedule, Constant.TIME_CHANGE_SCREEN)
        }
    }

    override fun setStateLoadScheduleOnStart() {
        Log.d("LOG", this.javaClass.simpleName + " setStateLoadScheduleOnStart()")
        isLoadScheduleOnStart = true
        isPerformingNextScheduleVideo = false
        isPerformNextScheduleOnAttachView = false
    }

    override fun onLoadSchedule(view: IScheduleContract.View, isClickedFromBtnBottom: Boolean, mustLoad: Boolean) {
        Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | mustLoad: $mustLoad | mIsLoading: $isLoading")
        when {
            mustLoad -> {
                Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | clear calling | isUpdatingNewSchedule: $isUpdatingNewSchedule")
                isUpdatingNewSchedule = true
//                this.mCompoDisposable.dispose()
                isLoading = false
            }

            else -> {
                if (isLoading) {
                    Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | is loading...")
                    showMessageLoading()
                    return
                }
            }
        }

        // reset flags
        isPerformingNextScheduleVideo = false
        isPerformNextScheduleOnAttachView = false

        this.mView = view
        this.isClickedFromBtnBottom = isClickedFromBtnBottom
        counterTryPostDelay = 0
        loadSchedule()
    }

    private fun showMessageLoading() {
        context?.also { context ->
            MessageUtils.showToast(context, context.getString(R.string.msg_loading_scheduler), R.color.yellow)?.show()
        }
    }

    private fun loadSchedule() {
        Log.d("LOG", this.javaClass.simpleName + " loadSchedule()")
        if (isLoading || mView == null) return
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_LOADING_SCHEDULE, true)
        isLoading = true

        context?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), mView?.getFragment())
                    ?: return

            mView?.showLoadingProgress()
            Log.d("LOG", this.javaClass.simpleName + " loadSchedule()")
            scheduleApi.getSchedule(headerData.token, headerData.deviceId).subscribe(this)
        }
    }

    /**
     * LOAD SCHEDULE
     */

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
        super.onResponseSuccess(data)
        isUpdatingNewSchedule = false
        Log.d("LOG", this.javaClass.simpleName + " onResponseSuccess() | videos number: ${data?.data.orEmpty().size}")
        mView?.hideLoadingProgress()
        val loadedVideos = data?.data

        isLoading = false

        if (loadedVideos.isNullOrEmpty()) {
            scheduleVideos.clear()
            navigateToNoClass()
//            SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
//            HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
            return
        }
        // filter today scheduler
        LoadSchedulingVideosHelper.filterTodaySchedulingVideos(loadedVideos)
        scheduleVideos = loadedVideos

        handlerScheduleTime.setupScheduleForNowVideo(loadedVideos)
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_LOADING_SCHEDULE, false)
    }

    override fun onResponseFailed(code: Int, message: String?) {
        super.onResponseFailed(code, message)
        isUpdatingNewSchedule = false
        isLoading = false
        mView?.hideLoadingProgress()
        Log.d("LOG", this.javaClass.simpleName + " onResponseFalse() | message: $message")
        navigateToNoClass()
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_LOADING_SCHEDULE, false)
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        isUpdatingNewSchedule = false
        Log.d("LOG", this.javaClass.simpleName + " onRequestError() | error: $message")
        mView?.hideLoadingProgress()
        isLoading = false
        val msg: String =
                when (message.isNullOrEmpty()) {
                    true -> mView?.getViewContext()?.getString(R.string.msg_request_scheduler_failed)
                            ?: MSG_REQUEST_FAILED
                    false -> message
                }
        VideoDBUtil.deleteVideosFromDB(Constant.MM_SCHEDULE)
        mView?.onNoClassVideosForNow(arrayListOf(), msg, R.color.red, isClickedFromBtnBottom)
        PreferenceHelper.getInstance()?.putBoolean(Constant.IS_LOADING_SCHEDULE, false)
    }

    override fun onComplete() {
        super.onComplete()
        isUpdatingNewSchedule = false
        isLoading = false
        mView?.hideLoadingProgress()
    }

    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    override fun onHaveNowPlayingVideo(playedPosition: Long) {
        Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | playedPosition: $playedPosition | videos number: ${scheduleVideos.size}")
        if (scheduleVideos.size > 0) {
            val view = mView
            when {
                view == null -> {
                    // TODO: will have to perform the case view is null setup for now schedule
                    if (isPerformingNextScheduleVideo) isPerformNextScheduleOnAttachView = true
                }

                else -> {
                    view.hideLoadingProgress()
                    VideoDBUtil.createOrUpdateVideos(scheduleVideos, Constant.MM_SCHEDULE)
                    view.onHaveClassVideos(scheduleVideos, this.isClickedFromBtnBottom)
                }
            }
        } else {
            navigateToNoClass()
        }
    }

    override fun onVideoExpiredTime() {
        onDontHaveNowPlayingVideo(this.isClickedFromBtnBottom)
    }

    override fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?) {
        Log.d("LOG", this.javaClass.simpleName + " onDontHaveNowPlayingVideo() | isClickedButtonHome: $isClickedButtonHome |0" +
                " videos number: ${scheduleVideos.size}")
//        val activity: MainActivity? = mView?.getFragment()?.activity as? MainActivity
//        if (activity?.isPresentationAvailable() == true) {
//            activity.playVideo(PlayMode.SCHEDULE, scheduleVideos)
//        }

        navigateToNoClass()
    }

    override fun onHaveVideoAfter(playedPosition: Long) {
        super.onHaveVideoAfter(playedPosition)
        Log.d("LOG", this.javaClass.simpleName + " onHaveVideoAfter() | isClickedButtonHome: $isClickedFromBtnBottom | " +
                " videos number: ${scheduleVideos.size}")
        VideoDBUtil.createOrUpdateVideos(scheduleVideos, Constant.MM_SCHEDULE)

        val view = mView
        when {
            view == null -> {
                return
            }

            else -> {
                view.hideLoadingProgress()
                if (isPerformingNextScheduleVideo) return

                view.onNoClassVideosForNow(scheduleVideos, "", R.color.white, isClickedFromBtnBottom)
                // do nothing more
            }
        }
    }

    override fun onProcessVideoError() {
        val view = mView
        when {
            view == null -> {
                return
            }

            else -> {
                mView?.hideLoadingProgress()
                mView?.showMessage(R.string.encountered_error_handling_class_video_data, R.color.red)
            }
        }
    }

    private fun navigateToNoClass(msg: String = "") {
        val view = mView
        when {
            view == null -> {
                return
            }

            else -> {
                view.hideLoadingProgress()
                VideoDBUtil.deleteVideosFromDB(Constant.MM_SCHEDULE)
                val message: String =
                        when {
                            msg.isBlank() -> view.getViewContext()?.getString(R.string.no_class_now)
                                    ?: Constant.MSG_NOW_CLASS_NOW
                            else -> msg
                        }

                view.onNoClassVideosForNow(arrayListOf(), message, isLoadScheduleManually = isClickedFromBtnBottom)
            }
        }
    }

    override fun onTimePlaySchedule() {
        Log.d("LOG", this.javaClass.simpleName + " onTimePlaySchedule() | already videos: ${scheduleVideos.size} | " +
                "isUpdatingNewSchedule: $isUpdatingNewSchedule")
        if (isUpdatingNewSchedule) return
//        scheduleVideos = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
        if (scheduleVideos.size == 0) {
            scheduleVideos = VideoDBUtil.getScheduleVideos()
        }
        isPerformNextScheduleOnAttachView = false
        isPerformingNextScheduleVideo = false
        handlerScheduleTime.setupScheduleForNowVideo(scheduleVideos)
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        context = null
        handler.removeCallbacks(runnable)
        handler.removeCallbacks(runnableHanldeTimeForSchedule)
        handlerScheduleTime.release()
        disposable.clear()
        isLoading = false
        isPerformNextScheduleOnAttachView = false
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        if (mView != null && mView?.getViewContext() is MainActivity) {
            (mView?.getViewContext() as MainActivity).getTokenAgainWhenTokenExpire(object : IGetNewToken {
                override fun onGetSuccess() {
                    counterTryPostDelay = 0
                    isClickedFromBtnBottom = false
                    loadSchedule()
                }
            })
        }
    }

    override fun setScheduleCurrent(videos: ArrayList<MMVideo>) {
        this.scheduleVideos.clear()
        this.scheduleVideos = videos
        this.isPerformNextScheduleOnAttachView = false
        this.isPerformingNextScheduleVideo = false
        this.isLoadScheduleOnStart = false
    }

    override fun setScheduleCurrentAndWaitNextVideo(videos: ArrayList<MMVideo>) {
        this.scheduleVideos.clear()
        this.scheduleVideos = videos
        this.isPerformNextScheduleOnAttachView = false
        this.isPerformingNextScheduleVideo = true // setup schedule for next schedule on screen show
        this.isLoadScheduleOnStart = false
        if (mView == null) {
            this.isPerformNextScheduleOnAttachView = true
            return
        }
        performForNextSchedule()
    }

    private fun performForNextSchedule() {
        if (scheduleVideos.size == 0) {
            isPerformNextScheduleOnAttachView = false
            return
        }

        val scheduleCurrentID = PreferenceHelper.getInstance()?.getInt(Constant.SCHEDULE_CURRENT_ID, -1)
                ?: -1
        val scheduleCurrentTimeStart = PreferenceHelper.getInstance()?.getString(Constant.SCHEDULE_CURRENT_TIME_START, "").orEmpty()
        Log.d("LOG", this.javaClass.simpleName + " setScheduleCurrentAndWaitNextVideo() | just played video: ${scheduleCurrentID} | just played video time start: ${scheduleCurrentTimeStart}")
        when {
            scheduleCurrentID == -1 || scheduleCurrentTimeStart.isBlank() -> {
                handlerScheduleTime.setupScheduleNextVideo(scheduleVideos, object : ICallBackNextScheduleVideo {
                    override fun onResult(index: Int, timeWait: Long) {

                    }

                    override fun onNotFound() {
                        mView?.showMessage(R.string.can_not_calculate_time_play_next_schedule_video, R.color.yellow)
                    }

                })
            }

            else -> {
                var indexSchedulePlayeLast = -1
                for (i in 0 until scheduleVideos.size) {
                    val videoCurrent = scheduleVideos[i]
                    if (videoCurrent.id == scheduleCurrentID && videoCurrent.playTime == scheduleCurrentTimeStart) {
                        Log.d("LOG", this.javaClass.simpleName + " setScheduleCurrentAndWaitNextVideo() | find the just played schedule video item | index: $i")
                        indexSchedulePlayeLast = i
                        break
                    }
                }

                when {
                    indexSchedulePlayeLast > -1 -> {
                        for (i in 0..indexSchedulePlayeLast) {
                            scheduleVideos.removeAt(0)
                            Log.d("LOG", this.javaClass.simpleName + " setScheduleCurrentAndWaitNextVideo() | remove first ele")
                        }
                    }
                }
                Log.d("LOG", this.javaClass.simpleName + " setScheduleCurrentAndWaitNextVideo() | indexScheduleJustPlayed: $indexSchedulePlayeLast | " +
                        "schedule videos number: ${scheduleVideos.size}")
                handlerScheduleTime.setupScheduleForNowVideo(scheduleVideos)
            }
        }

        isPerformingNextScheduleVideo = false
    }

    override fun isUpdatingNewSchedule(): Boolean = isUpdatingNewSchedule
}