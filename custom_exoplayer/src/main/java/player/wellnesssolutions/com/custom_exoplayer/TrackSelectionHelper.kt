package player.wellnesssolutions.com.custom_exoplayer

import android.content.DialogInterface
import android.view.View
import com.google.android.exoplayer2.trackselection.MappingTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection

/**
 * @param selector The track selector.
 * @param adaptiveTrackSelectionFactory A factory for adaptive [TrackSelection]s, or null
 * if the selection helper should not support adaptive tracks.
 */
class TrackSelectionHelper(private val selector : MappingTrackSelector, private val adaptiveTrackSelectionFactory : TrackSelection.Factory?) :
        View.OnClickListener, DialogInterface.OnClickListener {

    override fun onClick(v : View?) {

    }

    //    private var trackInfo : MappedTrackInfo? = null
//    private var rendererIndex : Int = 0
//    private var trackGroups : TrackGroupArray? = null
//    private var trackGroupsAdaptive : BooleanArray? = null
//    private var isDisabled : Boolean = false
//    private var override : SelectionOverride? = null
//
//    private var disableView : CheckedTextView? = null
//    private var defaultView : CheckedTextView? = null
//    private var enableRandomAdaptationView : CheckedTextView? = null
//    private var trackViews : Array<Array<CheckedTextView>>? = null
//
//    /**
//     * Shows the selection dialog for a given renderer.
//     *
//     * @param activity The parent activity.
//     * @param title The dialog's title.
//     * @param trackInfo The current track information.
//     * @param rendererIndex The index of the renderer.
//     */
//    fun showSelectionDialog(activity : Activity, title : CharSequence, trackInfo : MappedTrackInfo,
//                            rendererIndex : Int) {
//        this.trackInfo = trackInfo
//        this.rendererIndex = rendererIndex
//
//        trackGroups = trackInfo.getTrackGroups(rendererIndex)
//        trackGroupsAdaptive = BooleanArray(trackGroups!!.length)
//        for (i in 0 until trackGroups!!.length) {
//            trackGroupsAdaptive[i] = (adaptiveTrackSelectionFactory != null
//                    && trackInfo.getAdaptiveSupport(rendererIndex, i, false) != RendererCapabilities.ADAPTIVE_NOT_SUPPORTED
//                    && trackGroups!!.get(i).length > 1)
//        }
//        isDisabled = selector.getRendererDisabled(rendererIndex)
//        override = selector.getSelectionOverride(rendererIndex, trackGroups)
//
//        val builder = AlertDialog.Builder(activity)
//        builder.setTitle(title)
//                .setView(buildView(builder.getContext()))
//                .setPositiveButton(android.R.string.ok, this)
//                .setNegativeButton(android.R.string.cancel, null)
//                .create()
//                .show()
//    }
//
//    // DialogInterface.OnClickListener
//
    override fun onClick(dialog : DialogInterface, which : Int) {
//        selector.setRendererDisabled(rendererIndex, isDisabled)
//        if (override != null) {
//            selector.setSelectionOverride(rendererIndex, trackGroups, override)
//        } else {
//            selector.clearSelectionOverrides(rendererIndex)
//        }
    }
//
//    private fun setOverride(group : Int, tracks : IntArray, enableRandomAdaptation : Boolean) {
//        val factory = if (tracks.size == 1)
//            FIXED_FACTORY
//        else
//            if (enableRandomAdaptation) RANDOM_FACTORY else adaptiveTrackSelectionFactory
//        override = SelectionOverride(factory, group, tracks)
//    }
//
//    companion object {
//
//        private val FIXED_FACTORY = FixedTrackSelection.Factory()
//        private val RANDOM_FACTORY = RandomTrackSelection.Factory()
//
//        // Track array manipulation.
//
//        private fun getTracksAdding(override : SelectionOverride, addedTrack : Int) : IntArray {
//            var tracks = override.tracks
//            tracks = Arrays.copyOf(tracks, tracks.size + 1)
//            tracks[tracks.size - 1] = addedTrack
//            return tracks
//        }
//
//        private fun getTracksRemoving(override : SelectionOverride, removedTrack : Int) : IntArray {
//            val tracks = IntArray(override.length - 1)
//            var trackCount = 0
//            for (i in 0 until tracks.size + 1) {
//                val track = override.tracks[i]
//                if (track != removedTrack) {
//                    tracks[trackCount++] = track
//                }
//            }
//            return tracks
//        }
//    }

}