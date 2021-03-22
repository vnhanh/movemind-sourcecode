package player.wellnesssolutions.com.ui.fragment_home.helper

import android.content.Context
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.constant.Constant.TIME_CHANGE_SCREEN
import player.wellnesssolutions.com.common.sharedpreferences.SPrefConstant
import player.wellnesssolutions.com.common.sharedpreferences.SharedPreferencesCustomized
import player.wellnesssolutions.com.network.datasource.time_network.IRequestTimeNetworkListener
import player.wellnesssolutions.com.network.datasource.time_network.RequestTimeServer
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.services.AlarmManagerSchedule
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.NowPlayingPresenterHelper

class ScheduledTimeProcessor(context: Context, var mListener: IProcessTimeNowPlayingVideoListener?) : IRequestTimeNetworkListener {
    private var mContext: Context?
    private var mTimeDiffs = -1L
    private var mVideos: ArrayList<MMVideo>? = null

    init {
        mContext = context
        this.mTimeDiffs = SharedPreferencesCustomized.getInstance(context).getLong(SPrefConstant.TIME_DIFFS, -1L)

        if (this.mTimeDiffs == -1L)
            asyncTimeFromNetwork()
    }

    private fun asyncTimeFromNetwork() {
        RequestTimeServer(this).execute()
    }

    override fun onRecivedTime(timeDiffs: Long) {
        this.mTimeDiffs = timeDiffs
        mContext?.also {
            SharedPreferencesCustomized.getInstance(it).putLong(SPrefConstant.TIME_DIFFS, timeDiffs)
        }
    }

    private fun process(isClickedButtonHome: Boolean?, isSetAlarmTask: Boolean) {
        val firstVideo = mVideos?.get(0)
        if (firstVideo == null || mListener == null) return

        val result: Array<Long> = NowPlayingPresenterHelper.calculateTimePlayVideo(firstVideo, mTimeDiffs)
        when (result.size > 1) {
            true -> {
                var playedPosition = result[1]

                when (result[0]) {
                    NowPlayingPresenterHelper.TIME_PLAY -> {
                        when (playedPosition >= -1 * TIME_CHANGE_SCREEN) {
                            true -> {
                                ParameterUtils.isClearVideoOnPresentation = true
                                if (playedPosition <= Constant.TIME_MAX_CAN_ROUND) playedPosition = 0L

                                mListener?.onHaveNowPlayingVideo(playedPosition)

                            }
                            false -> {
                                mContext?.also { context ->
                                    val timeWait = -1 * (playedPosition / 1000L).toInt()
                                    AlarmManagerSchedule.cancelAlarmScheduleTime()
                                    AlarmManagerSchedule.setupTimeWakeSchedule(context, timeWait)
                                }
                                mListener?.onHaveVideoAfter(-1 * playedPosition)
                            }
                        }
                    }
                    NowPlayingPresenterHelper.EXPIRED_TIME_PLAY -> {
                        when {
                            mVideos?.size ?: 0 == 0 -> mListener?.onVideoExpiredTime()
                            else -> {
                                mVideos?.removeAt(0)
                                process(isClickedButtonHome, isSetAlarmTask)
                            }
                        }
                    }
                    NowPlayingPresenterHelper.ERROR -> {
                        mListener!!.onDontHaveNowPlayingVideo(isClickedButtonHome)
                    }
                }
            }

            false -> {
                mListener!!.onDontHaveNowPlayingVideo(isClickedButtonHome)
            }
        }
    }

    fun processScheduledVideo(videos: ArrayList<MMVideo>, isClickedButtonHome: Boolean?, isSetAlarmTask: Boolean = false) {
        this.mVideos = videos
        if (videos.size == 0) return

        process(isClickedButtonHome, isSetAlarmTask)
    }

    fun progressSetTimeToPlaySchedule(videos: ArrayList<MMVideo>) {
//        this.mVideos = videos
        this.processTimeSchedule()
    }

    private fun processTimeSchedule() {
        if (mVideos == null || mListener == null) return
        if (mVideos!!.isEmpty()) return

        val result: Array<Long> = NowPlayingPresenterHelper.calculateTimePlayVideo(mVideos!![0], mTimeDiffs)

        when (result.size > 1) {
            true -> {
                val playedPosition = result[1]

                when (result[0]) {
                    NowPlayingPresenterHelper.TIME_PLAY -> {
                        when (playedPosition >= 0L) {
                            true -> {
                                if (mVideos!!.size > 1) {
                                    val resultNextVideo: Array<Long> = NowPlayingPresenterHelper.calculateTimePlayVideo(mVideos!![1], mTimeDiffs)
                                    when (result.size > 1) {
                                        true -> {
                                            val playedPositionNextVideo = resultNextVideo[1]
                                            when (resultNextVideo[0]) {
                                                NowPlayingPresenterHelper.TIME_PLAY -> {
                                                    val timePlayNextVideo = -1 * ((playedPositionNextVideo / 1000)).toInt()
                                                    AlarmManagerSchedule.cancelAlarmScheduleTime()
                                                    AlarmManagerSchedule.setupTimeWakeSchedule(mContext!!, timePlayNextVideo + 1)

                                                }
                                            }
                                        }
                                    }
                                    //val timePlay = NowPlayingPresenterHelper.convertTime(mVideos!![1].getStartTime())
                                    //AlarmManagerSchedule.setupTimeWakeSchedule(mContext!!, (playedPosition / 60).toInt())
                                }
                            }
                            false -> {
                                val timePlay = -1 * ((playedPosition / 1000)).toInt()
                                AlarmManagerSchedule.cancelAlarmScheduleTime()
                                AlarmManagerSchedule.setupTimeWakeSchedule(mContext!!, timePlay)
                            }
                        }
                    }
                    NowPlayingPresenterHelper.EXPIRED_TIME_PLAY -> {

                    }
                    NowPlayingPresenterHelper.ERROR -> {

                    }
                }
            }
        }
    }


    fun release() {
        mListener = null
        mContext = null
    }
}