package player.wellnesssolutions.com.custom_exoplayer

import android.content.Context
import android.media.MediaCodecInfo
import android.media.MediaCodecList
import android.net.Uri
import android.util.Log
import android.webkit.MimeTypeMap
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.SingleSampleMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.FileDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util


class PlayerUsecase {
    private var mTrackSelector: DefaultTrackSelector? = null

    private var mCurrentPosition: Long = 0L
    private var mIsPlayWhenReady = true

    var mPlayer: SimpleExoPlayer? = null

    fun setCurrentPlayPosition(position: Long) {
        mCurrentPosition = position
    }

    fun initPlayer(context: Context, cookieValue: String,
                   url: String, subtitleLink: String, languageCode: String,
                   volume: Float,typeVideo: EnumTypeViewVideo,isPlayOffline: Boolean,fileDataSource : FileDataSource): SimpleExoPlayer {
        val extension: String = MimeTypeMap.getFileExtensionFromUrl(url)

        val player: SimpleExoPlayer =
                when (extension.contains(M3U8)) {
                    true -> ExoPlayerUtil.initStreamPlayer(
                            context = context, appName = APP_NAME,
                            cookieValue = cookieValue, mediaUrl = url,
                            subtitleLink = subtitleLink, languageCode = languageCode,
                            playWhenReady = mIsPlayWhenReady, currentPosition = mCurrentPosition,
                            volume = volume,typeVideo = typeVideo,isPlayOffline = isPlayOffline,fileDataSource = fileDataSource)

                    false -> {
                        ExoPlayerUtil.initProgressiveContainerFormat(
                                context = context,
                                appName = APP_NAME,
                                cookieValue = cookieValue,
                                mediaUrl = url,
                                subtitleLink = subtitleLink,
                                languageCode = languageCode,
                                playWhenReady = mIsPlayWhenReady,
                                currentPosition = mCurrentPosition,
                                volume = volume)
                    }
                }

        this.mPlayer = player

        return player
    }

    fun onRelease(isKeepPosition: Boolean, keepPlayWhenReady: Boolean, listeners: ArrayList<Player.EventListener>) {
        mPlayer?.also {
            it.playWhenReady = false

            for (listener in listeners) {
                val iterator = listeners.iterator()
                while (iterator.hasNext()){
                    iterator.next()
                    iterator.remove()
                }
            }

            mIsPlayWhenReady = keepPlayWhenReady
            it.stop()

            mCurrentPosition = if (isKeepPosition)
                it.currentPosition
            else
                0L

            it.release()
        }
        mPlayer = null
    }

    fun isPlaying(): Boolean {
        return mPlayer?.playWhenReady ?: false
    }

    fun pausePlayer() {
        mPlayer?.also {
            it.playWhenReady = false
            mIsPlayWhenReady = false
            mCurrentPosition = it.currentPosition
        }
    }

    fun resumePlayer() {
        mPlayer?.playWhenReady = true
        mIsPlayWhenReady = true
    }

    fun getCurrentPosition(): Long = mPlayer?.currentPosition ?: mCurrentPosition

    @Suppress("DEPRECATION")
    private fun getDefaultInstanceForMp4(context: Context): SimpleExoPlayer {
        val bandwidthMeter = DefaultBandwidthMeter.Builder(context).build()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
//        val videoTrackSelectionFactory = ExoPlayerFactory()
        mTrackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        // 2. Create the player
        return ExoPlayerFactory.newSimpleInstance(context, mTrackSelector)
    }

    fun initProgressiveContainerFormat(context: Context, appName: String,
                                       cookieValue: String, mediaUrl: String,
                                       subtitleLinks: ArrayList<String>,
                                       playWhenReady: Boolean = true,
                                       currentPosition: Long, volume: Float): SimpleExoPlayer =
            getDefaultInstanceForMp4(context).also { player ->
                val dataSourceFactory = DefaultHttpDataSourceFactory(Util.getUserAgent(context, appName), null).apply {
                    defaultRequestProperties.set("Cookie", cookieValue)
                }

                val extractorFactory = DefaultExtractorsFactory()

                val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory, extractorFactory)
                        .createMediaSource(Uri.parse(mediaUrl))

                val textFormat = Format.createTextSampleFormat(
                        null,
                        MimeTypes.APPLICATION_SUBRIP,
                        null,
                        Format.NO_VALUE,
                        Format.NO_VALUE,
                        null,
                        null,
                        Format.OFFSET_SAMPLE_RELATIVE
                )

                val list = ArrayList<MediaSource>()
                list.add(mediaSource)
                for (srt in subtitleLinks) {
                    list.add(SingleSampleMediaSource.Factory(dataSourceFactory)
                            .createMediaSource(Uri.parse(srt), textFormat, C.TIME_UNSET))
                }

                val arr: Array<MediaSource> = list.toTypedArray()

                val mergedSource = MergingMediaSource(*arr)
                player.prepare(mergedSource)
                player.seekTo(currentPosition)
                player.volume = volume
                player.playWhenReady = playWhenReady
            }

    fun initStreamPlayer(context: Context, appName: String,
                         cookieValue: String, mediaUrl: String, playWhenReady: Boolean = true,
                         currentPosition: Long, volume: Float): SimpleExoPlayer {
        val videoTrackSelectionFactory: TrackSelection.Factory = AdaptiveTrackSelection.Factory()
        mTrackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        val player = ExoPlayerFactory.newSimpleInstance(context, mTrackSelector)

        val dataHttpSourceFactory = DefaultHttpDataSourceFactory(
                Util.getUserAgent(context, appName), null
        )
        dataHttpSourceFactory.defaultRequestProperties.set("Cookie", cookieValue)

        val endIndex = mediaUrl.lastIndexOf(EXT_M3U8) + 5
        val s = mediaUrl.substring(0, endIndex)

        val mediaSource: MediaSource = HlsMediaSource.Factory(dataHttpSourceFactory).createMediaSource(Uri.parse(s))

        player.prepare(mediaSource)
        player.seekTo(currentPosition)
        player.volume = volume
        player.playWhenReady = playWhenReady

        return player
    }

    fun isNotEnded(): Boolean = mPlayer != null && mPlayer!!.playbackState != Player.STATE_ENDED

    companion object {
        const val APP_NAME = "MoveMind"
        const val M3U8 = "m3u8"
        const val EXT_M3U8 = ".m3u8"
    }
}