package player.wellnesssolutions.com.ui.fragment_control

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.ui.activity_main.MainActivity
import player.wellnesssolutions.com.ui.fragment_search_brands.module.ILoadBrandHandler
import player.wellnesssolutions.com.ui.fragment_search_brands.module.LoadBrandsHandler

class ControlPresenter : IControlContract.Presenter {
    private var mLoadBrandsHandler: ILoadBrandHandler? = null

    override fun onTapGroupComingUpNext() {
        mView?.hideGroupComingUpNext()
    }

    override fun onClickedComingUpNextVideo(position: Int) {
        mView?.getViewContext()?.also { context ->
            if (context is MainActivity) context.onPlayPresentationVideoAt(position)
        }
    }

    override fun getPlayMode(): PlayMode {
        mView?.getViewContext()?.also { context ->
            if (context is MainActivity) {
                context.getPresentationPlayMode()
                val value = PreferenceHelper.getInstance(context).getInt(ConstantPreference.MODE_PLAY_VIDEO, PlayMode.ON_DEMAND.value)
                return PlayMode.valueOf(value)?:PlayMode.UNKNOWN
            }
        }
        return PlayMode.ON_DEMAND
    }

    private var mView: IControlContract.View? = null
    private var mConfigData: MMConfigData? = null

    override fun onAttach(view: IControlContract.View) {
        Log.d("LOG", "ControlPresenter - onAttach()")
        this.mView = view
        if (mLoadBrandsHandler == null) mLoadBrandsHandler = LoadBrandsHandler(view)
        mLoadBrandsHandler?.onAttach(view)

        if (mConfigData == null)
            readSharePrefData()

        view.getViewContext()?.also { context ->
            if (context is MainActivity && context.isPlayingPresentation()) {
                PreferenceHelper.getInstance(context).getInt(ConstantPreference.MODE_PLAY_VIDEO, PlayMode.ON_DEMAND.value).also { playModeCastingValue ->
                    val playMode = PlayMode.valueOf(playModeCastingValue)

                    val videos: ArrayList<MMVideo> =
                        when(playMode){
                            PlayMode.ON_DEMAND -> VideoDBUtil.getVideosFromDB(Constant.MM_VIDEO_SEARCHED, isDelete = false)
                            PlayMode.SCHEDULE -> VideoDBUtil.getScheduleVideos()
                            else -> arrayListOf()
                        }

                    Log.d("LOG", "ControlPresenter - onAttach() | videos number: ${videos.size} | playModeCasting: $playMode")
                    val number = videos.size
                    if (number == 0) return

                    Observable.fromCallable {
                        val comingUpVideos = ArrayList<MMVideo>()
                        for (i in 1 until number) {
                            comingUpVideos.add(videos[i])
                        }
                        return@fromCallable comingUpVideos
                    }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe { comingUpVideos ->
                            val nowPlayVideo = videos[0]
                            Log.d("LOG", "ControlPresenter - onAttach() | observeOn - coming videos number: ${comingUpVideos.size}")
                            view.showPresentationPlayList(nowPlayVideo, comingUpVideos)
                        }
                }
            }
        }
    }

    override fun onDetach() {
        mView = null
        mLoadBrandsHandler?.onDetach()
    }

    override fun onDestroy() {
        mLoadBrandsHandler?.release()
        mLoadBrandsHandler = null
        mConfigData = null
    }

    private fun readSharePrefData() {
        val view: IControlContract.View? = mView
        val context: Context? = view?.getViewContext()
        if (view == null || context == null) return

        val userConfigJson = PreferenceHelper.getInstance(context).getString(ConstantPreference.SS_CONFIG, "")

        if (userConfigJson.isEmpty()) {
            view.showMessage(R.string.msg_not_got_user_config_data, R.color.red)
            return
        }

        val gSon = Gson()
        val configData: MMConfigData? = gSon.fromJson<MMConfigData>(userConfigJson, MMConfigData::class.java)
        mConfigData = configData

        if (configData != null)
            view.setupViewFloatMenu(configData)
    }

    override fun loadBrands(tag: String) {
        mLoadBrandsHandler?.loadBrands(tag)
    }

}