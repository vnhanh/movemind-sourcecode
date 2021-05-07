package player.wellnesssolutions.com.ui.fragment_home.helper

import android.content.Context
import android.util.Log
import player.wellnesssolutions.com.base.common.load_scheduled_videos.ICallBackNextScheduleVideo
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.datasource.time_network.IRequestTimeNetworkListener
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.HandlerTimeScheduleHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.ICallbackNowScheduleVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.STATE_TIME_PLAY_SCHEDULE

class HandlerScheduleTime(private var context: Context?, private var listener: IListenerHandleScheduleTime?) : IRequestTimeNetworkListener {
    private var mTimeDiffs = -1L
    private var videos: ArrayList<MMVideo> = arrayListOf()

    init {
        if (this.mTimeDiffs == -1L)
            asyncTimeFromNetwork()
    }

    private fun asyncTimeFromNetwork() {
//        RequestTimeServer(this).execute()
    }

    override fun onRecivedTime(timeDiffs: Long) {
        this.mTimeDiffs = timeDiffs
    }

    fun setupScheduleNextVideo(videos: ArrayList<MMVideo>, callback: ICallBackNextScheduleVideo? = null) {
        if (videos.size == 0) return
        handleNextScheduleVideo(videos, 0, callback)
    }

    fun setupScheduleForNowVideo(videos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " setupScheduleForNowVideo() | videos number: ${videos.size}")
        this.videos = videos
        if (videos.size == 0) return

        handleScheduleVideoNow()
    }

    fun release() {
        listener = null
        context = null
    }

    private fun handleScheduleVideoNow() {
        if (listener == null) return
        val firstVideo = videos[0]
        Log.d("LOG", this.javaClass.simpleName + " process() | video name: ${firstVideo.videoName} | videos number: ${videos.size}")
        HandlerTimeScheduleHelper.calculateTimePlayVideo(firstVideo, object : ICallbackNowScheduleVideo {
            override fun onResult(state: STATE_TIME_PLAY_SCHEDULE, timePlay: Long) {
                when (state) {
                    STATE_TIME_PLAY_SCHEDULE.TIME_PLAY -> {
                        Log.d("LOG", this.javaClass.simpleName + " process() | TIME_PLAY | timePlay: $timePlay")

                        ParameterUtils.isClearVideoOnPresentation = true
                        listener?.onHaveNowPlayingVideo(timePlay)
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_WAIT -> {
                        Log.d("LOG", this.javaClass.simpleName + " process() | TIME_WAIT | timePlay: $timePlay | video name: ${firstVideo.videoName} | " +
                                "videos number: ${videos.size}")
                        setupAlarmTask(timePlay)
                        listener?.onHaveVideoAfter(timePlay)
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_EXPIRED -> {
                        Log.d("LOG", this.javaClass.simpleName + " process() | TIME_EXPIRED")
                        when {
                            videos.size == 0 -> listener?.onVideoExpiredTime()
                            else -> {
                                videos.removeAt(0)
                                handleScheduleVideoNow()
                            }
                        }
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_ERROR -> {
                        listener?.onProcessVideoError()
                    }
                }
            }

        })

    }

    private fun setupAlarmTaskForCaseWaitSchedule(index: Int, timePlay: Long, callback: ICallBackNextScheduleVideo?) {
        setupAlarmTask(timePlay)
        callback?.onResult(index, timePlay-1000L)
    }

    private fun handleNextScheduleVideo(videos: ArrayList<MMVideo>, index: Int, callback: ICallBackNextScheduleVideo?) {
        if (index >= videos.size) {
            callback?.onNotFound()
            return
        }

        val videoHandle = videos[index]
        HandlerTimeScheduleHelper.calculateTimePlayVideo(videoHandle, object : ICallbackNowScheduleVideo {
            override fun onResult(state: STATE_TIME_PLAY_SCHEDULE, timePlay: Long) {
                when (state) {
                    STATE_TIME_PLAY_SCHEDULE.TIME_PLAY -> {
                        Log.d("LOG", this.javaClass.simpleName + " handleNextScheduleVideo() | TIME_PLAY | timePlay: $timePlay | " +
                                "video name: ${videoHandle.videoName} | videos number: ${videos.size}")
                        handleNextScheduleVideo(videos, index + 1, callback)
//                        when {
//                            timePlay <= Constant.TIME_CHANGE_SCREEN -> {
//                                Log.d("LOG", this.javaClass.simpleName + " handleNextScheduleVideo() | TIME_WAIT | timePlay: $timePlay | " +
//                                        "video name: ${videoHandle.videoName} | videos number: ${videos.size}")
//                                setupAlarmTaskForCaseWaitSchedule(index, timePlay, callback)
//                            }
//
//                            else -> handleNextScheduleVideo(videos, index + 1, callback)
//                        }

                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_WAIT -> {
                        Log.d("LOG", this.javaClass.simpleName + " handleNextScheduleVideo() | TIME_WAIT | timePlay: $timePlay | " +
                                "video name: ${videoHandle.videoName} | videos number: ${videos.size}")
                        setupAlarmTaskForCaseWaitSchedule(index, timePlay, callback)
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_EXPIRED -> {
                        Log.d("LOG", this.javaClass.simpleName + " handleNextScheduleVideo() | TIME_EXPIRED")
                        handleNextScheduleVideo(videos, index + 1, callback)
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_ERROR -> {
                        callback?.onNotFound()
                    }
                }
            }

        })
    }

    private fun setupAlarmTask(time: Long) {
        context?.also { context ->
            AlarmManagerSchedule.cancelAlarmScheduleTime()
            val timeWait = (time / 1000L).toInt()
            AlarmManagerSchedule.setupTimeWakeSchedule(context, timeWait)
        }
    }
}