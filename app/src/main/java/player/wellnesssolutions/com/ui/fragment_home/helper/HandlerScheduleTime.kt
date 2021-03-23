package player.wellnesssolutions.com.ui.fragment_home.helper

import android.content.Context
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.time_network.IRequestTimeNetworkListener
import player.wellnesssolutions.com.network.datasource.time_network.RequestTimeServer
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.HandlerTimeScheduleHelper
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.ICallbackTimePlaySchedule
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.STATE_TIME_PLAY_SCHEDULE

class HandlerScheduleTime(context: Context, var mListener: IListenerHandleScheduleTime?) : IRequestTimeNetworkListener {
    private var mContext: Context?
    private var mTimeDiffs = -1L
    private var mVideos: ArrayList<MMVideo>? = null
    private var isHandleForNowVideo = false

    init {
        mContext = context
        this.mTimeDiffs = PreferenceHelper.getInstance(context).getLong(ConstantPreference.TIME_DIFFS, -1L)

        if (this.mTimeDiffs == -1L)
            asyncTimeFromNetwork()
    }

    private fun asyncTimeFromNetwork() {
        RequestTimeServer(this).execute()
    }

    override fun onRecivedTime(timeDiffs: Long) {
        this.mTimeDiffs = timeDiffs
        mContext?.also {
            PreferenceHelper.getInstance(it).putLong(ConstantPreference.TIME_DIFFS, timeDiffs)
        }
    }

    fun setupScheduleForComingUpVideo(videos: ArrayList<MMVideo>){
        isHandleForNowVideo = false
        this.mVideos = videos
        if (videos.size == 0) return
        process(false)
    }

    fun setupScheduleForNowVideo(videos: ArrayList<MMVideo>, isClickedButtonHome: Boolean?) {
        isHandleForNowVideo = true
        this.mVideos = videos
        if (videos.size == 0) return

        process(isClickedButtonHome)
    }

    private fun process(isClickedButtonHome: Boolean?) {
        val firstVideo = mVideos?.get(0)
        if (firstVideo == null || mListener == null) return

        HandlerTimeScheduleHelper.calculateTimePlayVideo(firstVideo, object : ICallbackTimePlaySchedule {
            override fun onResult(state: STATE_TIME_PLAY_SCHEDULE, timePlay: Long) {
                when (state) {
                    STATE_TIME_PLAY_SCHEDULE.TIME_PLAY -> {
                        when {
                            isHandleForNowVideo -> {
                                ParameterUtils.isClearVideoOnPresentation = true
                                mListener?.onHaveNowPlayingVideo(timePlay)
                            }
                            else -> {
                                mVideos?.removeAt(0)
                                process(isClickedButtonHome)
                            }
                        }
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_WAIT -> {
                        mContext?.also { context ->
                            val timeWait = (timePlay / 1000L).toInt()
                            AlarmManagerSchedule.cancelAlarmScheduleTime()
                            AlarmManagerSchedule.setupTimeWakeSchedule(context, timeWait)
                        }
                        mListener?.onHaveVideoAfter(timePlay)
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_EXPIRED -> {
                        when {
                            mVideos?.size ?: 0 == 0 -> mListener?.onVideoExpiredTime()
                            else -> {
                                mVideos?.removeAt(0)
                                process(isClickedButtonHome)
                            }
                        }
                    }

                    STATE_TIME_PLAY_SCHEDULE.TIME_ERROR -> {
                        mListener?.onProcessVideoError()
                    }
                }
            }

        })

    }

    fun release() {
        mListener = null
        mContext = null
    }
}