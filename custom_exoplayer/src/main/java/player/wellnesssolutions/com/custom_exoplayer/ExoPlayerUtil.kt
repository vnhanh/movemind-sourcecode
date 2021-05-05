package player.wellnesssolutions.com.custom_exoplayer

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Format
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.SingleSampleMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.upstream.FileDataSource
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util


/**
 * Setups sorts of ExoPlayer
 */

object ExoPlayerUtil {
    private var mTrackSelector: DefaultTrackSelector? = null
    private const val EXT_M3U8 = ".m3u8"
    private var BITRATE_1080 = 4870000
    private var BITRATE_720 = 2356000

    @Suppress("DEPRECATION")
    private fun getDefaultInstanceForMp4(context: Context): SimpleExoPlayer {
        val bandwidthMeter: DefaultBandwidthMeter = DefaultBandwidthMeter.Builder(context).build()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
//        val videoTrackSelectionFactory = ExoPlayerFactory.newInstance()
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
        mTrackSelector = trackSelector
        // 2. Create the player
        return ExoPlayerFactory.newSimpleInstance(context, trackSelector)
    }

    fun initProgressiveContainerFormat(context: Context, appName: String, cookieValue: String,
                                       mediaUrl: String, subtitleLink: String, languageCode: String,
                                       playWhenReady: Boolean = true, currentPosition: Long, volume: Float): SimpleExoPlayer {
        Log.d("LOG", this.javaClass.simpleName + " initProgressiveContainerFormat()")
        val player: SimpleExoPlayer = getDefaultInstanceForMp4(context)

        val dataSourceFactory: DefaultHttpDataSourceFactory = DefaultHttpDataSourceFactory(Util.getUserAgent(context, appName), null).apply {
            defaultRequestProperties.set("Cookie", cookieValue)
        }

        val extractorFactory = DefaultExtractorsFactory()

        val mediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(dataSourceFactory, extractorFactory)
                .createMediaSource(Uri.parse(mediaUrl))
//        val mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(mediaUrl))?:"video/mp4"
//        val mediaCodec = MediaCodec.createByCodecName(mimeType)
        return mergeMediaSource(player, dataSourceFactory, mediaSource, subtitleLink, languageCode, currentPosition, volume, playWhenReady)
    }

    fun initStreamPlayer(context: Context, appName: String,
                         cookieValue: String, mediaUrl: String,
                         subtitleLink: String, languageCode: String,
                         playWhenReady: Boolean = true, currentPosition: Long,
                         volume: Float, typeVideo: EnumTypeViewVideo, isPlayOffline: Boolean, fileDataSource: FileDataSource): SimpleExoPlayer {
        Log.d("LOG", this.javaClass.simpleName + " initStreamPlayer()")
        val videoTrackSelectionFactory: TrackSelection.Factory = AdaptiveTrackSelection.Factory()
        val trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
//        val defaultParameter = trackSelector.buildUponParameters()
//                .setMaxVideoBitrate(BITRATE_1080)
//                .setForceHighestSupportedBitrate(true)
//                .build()
//
//        trackSelector.parameters = defaultParameter


        val player = ExoPlayerFactory.newSimpleInstance(context, trackSelector)

        val dataSourceFactory = DefaultHttpDataSourceFactory(
                Util.getUserAgent(context, appName), null
        )
        dataSourceFactory.defaultRequestProperties.set("Cookie", cookieValue)

        val endIndex = mediaUrl.lastIndexOf(EXT_M3U8) + 5
        val s = mediaUrl.substring(0, endIndex)
        Log.d("LOG", this.javaClass.simpleName + " s: $s")

        val mediaSource: MediaSource?

        mediaSource = if (isPlayOffline) {
            val extractorsFactory = DefaultExtractorsFactory()
                    .setMp4ExtractorFlags(Mp4Extractor.FLAG_WORKAROUND_IGNORE_EDIT_LISTS)
            val defaultFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, appName))
            val factory = EncryptedDefaultDataSourceFactory("vovanhoan1234567", context, defaultFactory)
//            Toast.makeText(context, "Play offline mode", Toast.LENGTH_SHORT).show()
            ProgressiveMediaSource.Factory(factory, extractorsFactory).createMediaSource(fileDataSource.uri)
        } else {
            HlsMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(s))
        }

        return mergeMediaSource(player, dataSourceFactory, mediaSource!!, subtitleLink, languageCode, currentPosition, volume, playWhenReady)
    }


    private fun mergeMediaSource(player: SimpleExoPlayer, dataSourceFactory: DefaultHttpDataSourceFactory,
                                 mediaSource: MediaSource, subtitleLink: String,
                                 languageCode: String, currentPosition: Long, volume: Float,
                                 playWhenReady: Boolean): SimpleExoPlayer {
        when (subtitleLink == "") {
            true -> {
                player.prepare(mediaSource)
            }
            false -> {
                val textFormat = Format.createTextSampleFormat(
                        null,
                        MimeTypes.APPLICATION_SUBRIP,
                        null,
                        Format.NO_VALUE,
                        Format.NO_VALUE,
                        languageCode,
                        null,
                        Format.OFFSET_SAMPLE_RELATIVE
                )

                val subtitleMediaSource = SingleSampleMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(Uri.parse(subtitleLink), textFormat, C.TIME_UNSET)
                val mergedSource = MergingMediaSource(mediaSource, subtitleMediaSource)
                player.prepare(mergedSource)
            }
        }

        player.seekTo(currentPosition)
        player.volume = volume
        player.playWhenReady = playWhenReady

        return player
    }
}
