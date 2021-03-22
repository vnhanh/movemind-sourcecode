package player.wellnesssolutions.com.ui.fragment_control

import player.wellnesssolutions.com.base.uis.ILifeCycle
import player.wellnesssolutions.com.base.uis.IShowMessageView
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.fragment_now_playing.helper.IComingUpNextClickListener
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import java.util.*

interface IControlContract {
    interface View : ILoadBrandHandler.Callback, IShowMessageView {
        fun setupViewFloatMenu(configData: MMConfigData)
        fun hideGroupComingUpNext()
        fun showPresentationPlayList(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>)
    }

    interface Presenter : ILifeCycle.Presenter<View>, IComingUpNextClickListener {
        fun loadBrands(tag: String)
    }
}