package player.wellnesssolutions.com.ui.activity_main

import player.wellnesssolutions.com.network.models.now_playing.MMVideo

interface IRouterChanged {
    fun onMediaRouterConnected() {}

    fun onMediaRouterDisconnected() {}

    fun onUpdateVideos(playingVideo: MMVideo, comingVideos: ArrayList<MMVideo>) {}

    fun onClearVideos() {}
}