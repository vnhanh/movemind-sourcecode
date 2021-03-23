package player.wellnesssolutions.com.base.common.load_scheduled_videos

import android.content.Context
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.check_header_api_util.CheckHeaderApiUtil
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseScheduleFragment
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.view.IGetNewToken
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.datasource.now_playing.NowPlayingApi
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers.HMCDataHelper
import player.wellnesssolutions.com.ui.fragment_home.helper.IListenerHandleScheduleTime
import player.wellnesssolutions.com.ui.fragment_home.helper.HandlerScheduleTime
import player.wellnesssolutions.com.ui.fragment_search_preview.helpers.SPDBUtil
import player.wellnesssolutions.com.ui.fragment_search_result_videos.SearchResultFragment

class SchedulePresenter(context: Context) : BaseResponseObserver<ArrayList<MMVideo>>(), IScheduleContract.Presenter,
        IListenerHandleScheduleTime {
    companion object {
        const val MSG_REQUEST_FAILED = "Request class videos failed !"
    }

    // vars
    private var mView: IScheduleContract.View? = null
    private var scheduleApi = NowPlayingApi()
    private var handlerScheduleTime: HandlerScheduleTime? = HandlerScheduleTime(context, this)
    private var scheduleVideos: ArrayList<MMVideo>? = null
    private var isClickedFromBtnBottom = false

    // flag
    private var mIsLoading = false

    override fun onAttach(view: IScheduleContract.View) {
        this.mView = view
    }

    override fun onLoadSchedule(view: IScheduleContract.View, isClickedFromBtnBottom: Boolean) {
        if (mIsLoading) {
            showMessageLoading(view)
            return
        }

        loadSchedule(view, isClickedFromBtnBottom)
    }

    private fun showMessageLoading(view: IScheduleContract.View) {
        view.getViewContext()?.also { context ->
            MessageUtils.showToast(context, context.getString(R.string.msg_loading_scheduler), R.color.yellow)?.show()
        }
    }

    private fun loadSchedule(view: IScheduleContract.View, isClickedFromBtnBottom: Boolean) {
        mIsLoading = true
        this.isClickedFromBtnBottom = isClickedFromBtnBottom
        this.mView = view

        view.getViewContext()?.also { context ->
            val headerData = CheckHeaderApiUtil.checkData(PreferenceHelper.getInstance(context), view.getFragment())
                    ?: return

            view.showLoadingProgress()
            scheduleApi.getSchedule(headerData.token, headerData.deviceId).subscribe(this)
        }
    }

    private fun processLoadedVideos(loadedVideos: ArrayList<MMVideo>) {
        if (loadedVideos.size == 0) {
            navigateToNoClass()
            SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
            return
        }
        //save all videos to database
        //VideoDBUtil.saveVideosScheduleToDB(loadedVideos, Constant.SCHEDULE_TAG)
//        val video = loadedVideos[0]
        handlerScheduleTime?.setupScheduleForNowVideo(loadedVideos, this.isClickedFromBtnBottom)
//        mScheduledTimeProcessor?.progressSetTimeToPlaySchedule(loadedVideos)
    }

    override fun onResponseSuccess(data: ResponseValue<ArrayList<MMVideo>>?) {
        super.onResponseSuccess(data)
        val loadedVideos = data?.data

        if (loadedVideos == null || loadedVideos.size == 0) {
            navigateToNoClass()
            SPDBUtil.deleteAllFromTag(SearchResultFragment.getTagOfChosen())
            HMCDataHelper.deleteALlFromTag(SearchResultFragment.getTagOfHMCForDB())
            return
        }

        // filter today scheduler
        LoadSchedulingVideosHelper.filterTodaySchedulingVideos(loadedVideos)
        scheduleVideos = loadedVideos
        mIsLoading = false
//        val video = FakeDataHelper.getNowPlayingVideo()
        processLoadedVideos(loadedVideos)
    }

    override fun onResponseFalse(code: Int, message: String?) {
        super.onResponseFalse(code, message)
        mView?.hideLoadingProgress()
        val msg: String = message
                ?: mView?.getViewContext()?.getString(R.string.request_class_video_failed)
                ?: MSG_REQUEST_FAILED
        mView?.onNoClassVideos(msg, R.color.red, isClickedFromBtnBottom)
    }

    override fun onRequestError(message: String?) {
        super.onRequestError(message)
        mView?.hideLoadingProgress()

        val msg: String =
                when (message.isNullOrEmpty()) {
                    true -> mView?.getViewContext()?.getString(R.string.msg_request_scheduler_failed)
                            ?: MSG_REQUEST_FAILED
                    false -> message
                }

        mView?.onNoClassVideos(msg, R.color.red, isClickedFromBtnBottom)
    }

    override fun onComplete() {
        super.onComplete()
        mIsLoading = false
    }

    /**
     * implementing @interface IListenerHandleScheduleTime
     */
    override fun onHaveNowPlayingVideo(playedPosition: Long) {
        mView?.hideLoadingProgress()
        val loadedVideos: ArrayList<MMVideo>? = scheduleVideos
        if (loadedVideos != null && loadedVideos.size > 0) {
            mView?.onHaveClassVideos(loadedVideos, this.isClickedFromBtnBottom)
        } else {
            navigateToNoClass()
        }
    }

    override fun onVideoExpiredTime() {
        onDontHaveNowPlayingVideo(this.isClickedFromBtnBottom)
    }

    override fun onDontHaveNowPlayingVideo(isClickedButtonHome: Boolean?) {
        val activity: MainActivity? = mView?.getFragment()?.activity as? MainActivity
        if (activity?.isPresentationAvailable() == true) {
            activity.playVideo(PlayMode.SCHEDULE, scheduleVideos!!)
        }

        val message: String = mView?.getViewContext()?.getString(R.string.no_class_now)
                ?: Constant.MSG_NOW_CLASS_NOW

        mView?.hideLoadingProgress()
        mView?.onNoClassVideos(message, isClickedFromBtnBottom = isClickedFromBtnBottom)
    }

    override fun onHaveVideoAfter(playedPosition: Long) {
        super.onHaveVideoAfter(playedPosition)
        mView?.hideLoadingProgress()
        // do nothing more
    }

    override fun onProcessVideoError() {
        mView?.hideLoadingProgress()
        mView?.showMessage(R.string.encountered_error_handling_class_video_data, R.color.red)
    }

    private fun navigateToNoClass() {
        mView?.hideLoadingProgress()
        val message: String = mView?.getViewContext()?.getString(R.string.no_class_now)
                ?: Constant.MSG_NOW_CLASS_NOW
        mView?.onNoClassVideos(message, isClickedFromBtnBottom = isClickedFromBtnBottom)
    }

    override fun onTimePlaySchedule() {
        scheduleVideos?.also { videos->
            VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
            mView?.onTimePlaySchedule()
        }
    }

    override fun onDetach() {
        mView = null
    }

    override fun onDestroy() {
        handlerScheduleTime?.release()
        handlerScheduleTime = null

        mCompoDisposable.dispose()
        mIsLoading = false
    }

    override fun onExpired(error: String) {
        mView?.getFragment()?.also {
            if (it is BaseScheduleFragment) {
                it.onExpired(error)
            }
        }
    }

    override fun onExpiredUnauthenticated(error: String) {
        if (mView != null && mView?.getViewContext() is MainActivity) {
            (mView?.getViewContext() as MainActivity).getTokenAgainWhenTokenExpire(object : IGetNewToken {
                override fun onGetSuccess() {
                    loadSchedule(this@SchedulePresenter.mView!!, this@SchedulePresenter.isClickedFromBtnBottom)
                }
            })
        }
    }

    override fun setScheduleCurrentAndWaitNextVideo(videos: ArrayList<MMVideo>) {
        this.scheduleVideos?.clear()
        this.scheduleVideos?.addAll(videos)
        handlerScheduleTime?.setupScheduleForComingUpVideo(videos)
    }
}