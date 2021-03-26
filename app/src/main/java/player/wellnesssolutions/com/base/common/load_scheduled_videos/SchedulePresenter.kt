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
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime
import player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime
import java.lang.ref.WeakReference

class SchedulePresenter(context: Context) : BaseResponseObserver<ArrayList<MMVideo>>(), IScheduleContract.Presenter,
        IListenerHandleScheduleTime {
    companion object {
        const val MSG_REQUEST_FAILED = "Request class videos failed !"
    }

    // vars
    private var mView: IScheduleContract.View? = null
    private var weakContext = WeakReference(context)
    private var scheduleApi = NowPlayingApi()
    private var handlerScheduleTime: HandlerScheduleTime = HandlerScheduleTime(context, this)
    private var scheduleVideos: ArrayList<MMVideo> = arrayListOf()
    private var isClickedFromBtnBottom = false
    private var isLoadScheduleOnStart = false
    private val handler = Handler()
    private var counterTryPostDelay = 0
    private var isUpdatingNewSchedule = false

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

    // flag
    private var mIsLoading = false

    override fun onAttach(view: IScheduleContract.View) {
        Log.d("LOG", this.javaClass.simpleName + " onAttach() | view: ${view.javaClass.simpleName}")
        this.mView = view
        if (isLoadScheduleOnStart) {
            isLoadScheduleOnStart = false
            handler.postDelayed(runnable, 1000L)
        }
        view.getViewContext()?.also { viewContext ->
            handlerScheduleTime = HandlerScheduleTime(viewContext, this)
        }
    }

    override fun setStateLoadScheduleOnStart() {
        Log.d("LOG", this.javaClass.simpleName + " setStateLoadScheduleOnStart()")
        isLoadScheduleOnStart = true
    }

    override fun onLoadSchedule(view: IScheduleContract.View, isClickedFromBtnBottom: Boolean, mustLoad:Boolean) {
        Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | mustLoad: $mustLoad | mIsLoading: $mIsLoading")
        when{
            mustLoad -> {
                Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | clear calling | isUpdatingNewSchedule: $isUpdatingNewSchedule")
                isUpdatingNewSchedule = true
//                this.mCompoDisposable.dispose()
                mIsLoading= false
            }

            else -> {
                if (mIsLoading) {
                    Log.d("LOG", this.javaClass.simpleName + " onLoadSchedule() | is loading...")
                    showMessageLoading(view)
                    return
                }
            }
        }

        this.mView = view
        this.isClickedFromBtnBottom = isClickedFromBtnBottom
        counterTryPostDelay = 0
        loadSchedule()
    }

    private fun showMessageLoading(view: IScheduleContract.View) {
        weakContext.get()?.also { context ->
            MessageUtils.showToast(context, context.getString(R.string.msg_loading_scheduler), R.color.yellow)?.show()
        }
    }

    private fun loadSchedule() {
        Log.d("LOG", this.javaClass.simpleName + " loadSchedule() | mView: $mView")
        if (mIsLoading || mView == null) return
        mIsLoading = true

        weakContext.get()?.also { context ->
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
        val loadedVideos = data?.data

        if (loadedVideos.isNullOrEmpty()) {
            navigateToNoClass()
//            SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
//            HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
            return
        }

        // filter today scheduler
        LoadSchedulingVideosHelper.filterTodaySchedulingVideos(loadedVideos)
        scheduleVideos = loadedVideos
        mIsLoading = false
        handlerScheduleTime.setupScheduleForNowVideo(loadedVideos)
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        isUpdatingNewSchedule = false
        Log.d("LOG", this.javaClass.simpleName + " onResponseFalse() | message: $message")
        navigateToNoClass()
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        isUpdatingNewSchedule = false
        Log.d("LOG", this.javaClass.simpleName + " onRequestError() | error: $message")
        mView?.hideLoadingProgress()

        val msg: String =
                when (message.isNullOrEmpty()) {
                    true -> mView?.getViewContext()?.getString(R.string.msg_request_scheduler_failed)
                            ?: MSG_REQUEST_FAILED
                    false -> message
                }

        mView?.onNoClassVideosForNow(msg, R.color.red, isClickedFromBtnBottom)
    }

    override fun onComplete() {
        super.onComplete()
        mView?.hideLoadingProgress()
        mIsLoading = false
    }

    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    override fun onHaveNowPlayingVideo(playedPosition: Long) {
        Log.d("LOG", this.javaClass.simpleName + " onHaveNowPlayingVideo() | playedPosition: $playedPosition | videos number: ${scheduleVideos.size}")
        if (scheduleVideos.size > 0) {
            mView?.hideLoadingProgress()
            VideoDBUtil.createOrUpdateVideos(scheduleVideos, Constant.MM_SCHEDULE)
            mView?.onHaveClassVideos(scheduleVideos, this.isClickedFromBtnBottom)
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
        mView?.hideLoadingProgress()
        scheduleVideos.also { videos ->
            VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
        }
        mView?.onNoClassVideosForNow("", R.color.white, isClickedFromBtnBottom)
        // do nothing more
    }

    override fun onProcessVideoError() {
        mView?.hideLoadingProgress()
        mView?.showMessage(R.string.encountered_error_handling_class_video_data, R.color.red)
    }

    private fun navigateToNoClass(msg: String = "") {
        mView?.hideLoadingProgress()
        VideoDBUtil.deleteVideosFromDB(Constant.MM_SCHEDULE)
        val message: String =
                when {
                    msg.isBlank() -> mView?.getViewContext()?.getString(R.string.no_class_now)
                            ?: Constant.MSG_NOW_CLASS_NOW
                    else -> msg
                }
        mView?.onNoClassVideosForNow(message, isClickedFromBtnBottom = isClickedFromBtnBottom)
    }

    override fun onTimePlaySchedule() {
        Log.d("LOG", this.javaClass.simpleName + " onTimePlaySchedule() | already videos: ${scheduleVideos.size} | " +
                "isUpdatingNewSchedule: $isUpdatingNewSchedule")
        if(isUpdatingNewSchedule) return
        scheduleVideos = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
        if (scheduleVideos.size == 0) {
            scheduleVideos = VideoDBUtil.getVideosFromDB(Constant.MM_SCHEDULE, false)
        }
        handlerScheduleTime.setupScheduleForNowVideo(scheduleVideos, this, weakContext.get())
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        handler.removeCallbacks(runnable)
        handlerScheduleTime.release()

        mCompoDisposable.dispose()
        mIsLoading = false
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

    override fun setScheduleCurrentAndWaitNextVideo(videos: ArrayList<MMVideo>) {
        AlarmManagerSchedule.cancelAlarmScheduleTime()
        this.scheduleVideos.clear()
        this.scheduleVideos = videos
        Log.d("LOG", this.javaClass.simpleName + " setScheduleCurrentAndWaitNextVideo() | videos number: ${scheduleVideos.size} | " +
                "videos number 2: ${videos.size}")
        handlerScheduleTime.setupScheduleNextVideo(videos, object : ICallBackNextScheduleVideo {
            override fun onResult(index: Int, timeWait: Long) {

            }

            override fun onNotFound() {
                mView?.showMessage(R.string.can_not_calculate_time_play_next_schedule_video, R.color.yellow)
            }

        })
    }

    override fun isUpdatingNewSchedule(): Boolean = isUpdatingNewSchedule
}