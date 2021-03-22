package player.wellnesssolutions.com.custom_exoplayer

class DecodeInfo {
//    /**
//     * The name of the decoder.
//     * <p>
//     * May be passed to {@link android.media.MediaCodec#createByCodecName(String)} to create an
//     * instance of the decoder.
//     */
//    public lateinit var name :String
//
//    /**
//     * {@link MediaCodecInfo.CodecCapabilities} for this decoder.
//     */
//    public lateinit var capabilities : MediaCodecInfo.CodecCapabilities
//
//    /**
//     * Whether the decoder supports seamless resolution switches.
//     *
//     * @see android.media.MediaCodecInfo.CodecCapabilities#isFeatureSupported(String)
//     * @see android.media.MediaCodecInfo.CodecCapabilities#FEATURE_AdaptivePlayback
//     */
//    public lateinit var adaptive : Boolean
//
//    /**
//     * @param name The name of the decoder.
//     * @param capabilities {@link MediaCodecInfo.CodecCapabilities} of the decoder.
//     */
//    /* package */ constructor(name:String, capabilities : MediaCodecInfo.CodecCapabilities) {
//        this.name = name;
//        this.capabilities = capabilities;
//        this.adaptive = isAdaptive(capabilities);
//    }
//
//    private fun isAdaptive(capabilities: MediaCodecInfo.CodecCapabilities) : Boolean{
//        return capabilities != null && isAdaptiveV19(capabilities);
//    }
//
//    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities capabilities) {
//        return capabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_AdaptivePlayback);
//    }
}