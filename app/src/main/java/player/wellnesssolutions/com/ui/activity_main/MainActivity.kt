package player.wellnesssolutions.com.ui.activity_main

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.*
import android.content.pm.PackageManager
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.mediarouter.media.MediaControlIntent
import androidx.mediarouter.media.MediaRouteSelector
import androidx.mediarouter.media.MediaRouter
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.iid.FirebaseInstanceId
import com.google.gson.Gson
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.FragmentUtil
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.base.utils.video.VideoDBUtil
import player.wellnesssolutions.com.base.view.BaseResponseObserver
import player.wellnesssolutions.com.base.view.IGetNewToken
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.media_router.models.PlaylistItem
import player.wellnesssolutions.com.common.media_router.receivers.MediaButtonReceiver
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceManager
import player.wellnesssolutions.com.common.utils.DialogUtil
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.common.utils.PermissionUtils
import player.wellnesssolutions.com.network.datasource.fcm.FirebaseApi
import player.wellnesssolutions.com.network.datasource.home.HomeApi
import player.wellnesssolutions.com.network.datasource.login.LoginApi
import player.wellnesssolutions.com.network.datasource.videos.PlayMode
import player.wellnesssolutions.com.network.models.config.MMConfigData
import player.wellnesssolutions.com.network.models.login.MMBranding
import player.wellnesssolutions.com.network.models.login.MMCookie
import player.wellnesssolutions.com.network.models.login.MMLoginResponseData
import player.wellnesssolutions.com.network.models.now_playing.MMVideo
import player.wellnesssolutions.com.network.models.response.ResponseValue
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import player.wellnesssolutions.com.services.AlarmManagerSchedule.setupAlarmTimeCallEveryDay
import player.wellnesssolutions.com.services.DownloadService
import player.wellnesssolutions.com.ui.activity_scan_barcode.ScanBarCodeActivity
import player.wellnesssolutions.com.ui.fragment_home.HomeFragment
import player.wellnesssolutions.com.ui.fragment_presentation.MMDiscoveryFragment
import player.wellnesssolutions.com.ui.fragment_presentation.MMSessionManager
import player.wellnesssolutions.com.ui.fragment_presentation.players.MMPlayer
import player.wellnesssolutions.com.ui.fragment_splash.SplashFragment
import player.wellnesssolutions.database.manager.DownloadDBManager
import retrofit2.Response
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), NetworkReceiver.IStateListener, CastingBroadcastReceiver.TVListener {
    private var mSelector: MediaRouteSelector? = null
    private val mSessionManager = MMSessionManager("Move Mind")
    private var mPlayer: MMPlayer? = null
    private var mAudioManager: AudioManager? = null
    private var mMediaSession: MediaSessionCompat? = null

    private var mEventReceiver: ComponentName? = null
    private var mMediaPendingIntent: PendingIntent? = null

    private var mIsReturnScanScreen = false

    //private var mDownloadingHelper: ActivityDownloadHelper? = null

    private var mPresentationId = -1

    var appVisible = true
    private var mIsFirst = true
    private var mIsVisble = false

    private var mDisconnectDialog: AlertDialog? = null
    private var mBackToHomeDialog: AlertDialog? = null

    private var isShownDialogNotEnoughSpace = false

    private val mBroadcastReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (context == null || intent == null) return
            when (intent.action) {
                DownloadService.ACTION_DOWNLOAD_UI -> readDownloadIntent(intent)
            }
        }

    }


    /**
     * IRouterChangedListener
     */
    private var mRouterChangedListeners = ArrayList<IRouterChanged>()

    fun addRouterChangedListener(listener: IRouterChanged) {
        if (!mRouterChangedListeners.contains(listener)) mRouterChangedListeners.add(listener)
    }

    fun removeRouterChangedListener(listener: IRouterChanged) {
        val iterator = mRouterChangedListeners.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            if (item == listener) iterator.remove()
        }
    }

    private fun notifyRouterConnected() {
        for (listener: IRouterChanged in mRouterChangedListeners) {
            listener.onMediaRouterConnected()
        }
    }

    private fun notifyRouterDisconnected() {
        for (listener: IRouterChanged in mRouterChangedListeners) {
            listener.onMediaRouterDisconnected()
        }
    }

    /**
     * end IRouterChangedListener
     */
    private var route : MediaRouter.RouteInfo? = null
    private var isMediaProviderChangedInBackground = false
    private val mMediaRouterCB = object : MediaRouter.Callback() {
        @SuppressLint("RestrictedApi")
        override fun onProviderChanged(router: MediaRouter?, provider: MediaRouter.ProviderInfo?) {
            super.onProviderChanged(router, provider)

            router?.selectedRoute?.also { route: MediaRouter.RouteInfo ->
                PreferenceHelper.getInstance()?.getBoolean(ConstantPreference.IS_IN_BACKGROUND, false)?.also { isInBackground ->
                    if(isInBackground){
                        this@MainActivity.route = route
                        isMediaProviderChangedInBackground = true
                    }else{
                        handleOnProviderChanged(route)
                    }
                }
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun handleOnProviderChanged(route: MediaRouter.RouteInfo?) {
        if(route == null) return
        handlerMain.post{
            val id: Int = route.presentationDisplayId
            if (id > -1 && id != mPresentationId) {
                mPresentationId = id

                releaseRoute()
                initRoute(route)
            } else if (id == -1 && id != mPresentationId) {
                mPresentationId = id

                releaseRoute()
                notifyRouterDisconnected()
            }
        }
    }

    private fun initRoute(route: MediaRouter.RouteInfo) {
        // mPlayer : MMDrawOnTopPlayer
        Log.d("LOG", this.javaClass.simpleName + " initRoute()")
        mPlayer = MMPlayer.create(context = this, route = route)
        mPlayer?.let { player ->
            player.updatePresentation(route)
            mSessionManager.setPlayer(player)
            mSessionManager.unSuspend()
        }
        registerRemoteControlClient()

        notifyRouterConnected()
        Log.d("LOG", this.javaClass.simpleName + " notified()")
//        openPresentationIfIsPlaying()
    }

    fun releaseRoute() {
        unregisterRemoteControlClient()
        mPlayer?.release()
    }

    private fun openPresentationIfIsPlaying() {
        handlerMain.post {
            PreferenceHelper.getInstance()?.getBoolean(Constant.IS_PLAYING_VIDEO, false)?.also { isPlayingVideo ->
                if (isPlayingVideo) {
                    if (isPresentationAvailable()) {
                        val playedModeValue = PreferenceHelper.getInstance(this).getInt(ConstantPreference.MODE_PLAY_VIDEO,
                                PlayMode.ON_DEMAND.value)

                        PlayMode.valueOf(playedModeValue)?.also { mode ->
                            Log.d("LOG", "MainActivity - openPresentationIfIsPlaying() | mode: $mode")
                            val tagDB =
                                    when (mode) {
                                        PlayMode.ON_DEMAND -> Constant.MM_VIDEO_SEARCHED
                                        PlayMode.SCHEDULE -> Constant.MM_SCHEDULE
                                        else -> return@post
                                    }
                            playVideo(mode = mode, videos = VideoDBUtil.getVideosFromDB(tagDB))
                        }
                    }
                }
            } // end block

        }
    }

    private fun registerRemoteControlClient() {
        mMediaSession = MediaSessionCompat(this, TAG, null, mMediaPendingIntent)

        MediaButtonReceiver.setActivity(this)
        val stateBuilder = PlaybackStateCompat.Builder()
                .setActions(PlaybackStateCompat.ACTION_PLAY or PlaybackStateCompat.ACTION_PLAY_PAUSE
                        or PlaybackStateCompat.ACTION_PAUSE or PlaybackStateCompat.ACTION_STOP)
        mMediaSession?.setPlaybackState(stateBuilder.build())
    }

    private fun unregisterRemoteControlClient() {
        // Unregister the RCC with AudioManager and MediaRouter
        if (mMediaSession != null) {
            mMediaSession?.setFlags(0)
            MediaButtonReceiver.setActivity(null)
            mMediaSession = null
        }
    }

    private val handlerMain = Handler(Looper.getMainLooper())

    private val mSessionCallback = object : MMSessionManager.Callback {

        override fun onStatusChanged() {
        }

        override fun onItemChanged(item: PlaylistItem) {
        }

        override fun onUpdateVideos(nowPlayVideo: MMVideo, comingUpVideos: ArrayList<MMVideo>) {
            Log.d("LOG", "MainActivity - mSessionCallback - onUpdateVideos() | video: ${nowPlayVideo.videoName} | video next: ${comingUpVideos[0].videoName}")
            for (listener: IRouterChanged in mRouterChangedListeners) {
                listener.onUpdateVideos(nowPlayVideo, comingUpVideos)
            }
        }

        override fun onClearVideos() {
            for (listener: IRouterChanged in mRouterChangedListeners) {
                listener.onClearVideos()
            }
        }
    }

    private fun registerMediaRouter() {
        mAudioManager = (getSystemService(Context.AUDIO_SERVICE) as AudioManager)

        mEventReceiver = ComponentName(packageName, MediaButtonReceiver::class.java.name)
        val mediaButtonIntent = Intent(Intent.ACTION_MEDIA_BUTTON)
        mediaButtonIntent.component = mEventReceiver

        mMediaPendingIntent = PendingIntent.getBroadcast(this, 0, mediaButtonIntent, 0)

        // Create and register the remote control client
        registerRemoteControlClient()

        mSessionManager.setCallback(mSessionCallback)

        mSelector = MediaRouteSelector.Builder().addControlCategories(arrayOf(
                MediaControlIntent.CATEGORY_LIVE_AUDIO,
                MediaControlIntent.CATEGORY_LIVE_VIDEO,
                MediaControlIntent.CATEGORY_REMOTE_PLAYBACK).toMutableList()).build()

        // Add a fragment to take care of media route discovery.
        // This fragment automatically adds or removes a callback whenever the activity
        // is started or stopped.

        var fragment: MMDiscoveryFragment? = supportFragmentManager.findFragmentByTag(MMDiscoveryFragment.TAG) as MMDiscoveryFragment?
        if (fragment == null) {
            fragment = MMDiscoveryFragment()
            fragment.setCallback(mMediaRouterCB)
            fragment.routeSelector = mSelector
            supportFragmentManager.beginTransaction().add(fragment, MMDiscoveryFragment.TAG).commit()
        } else {
            fragment.setCallback(mMediaRouterCB)
            fragment.routeSelector = mSelector
        }
    }

    fun isPresentationAvailable(): Boolean {
        return mSessionManager.isPresentationAvailable()
    }

    fun playVideo(mode: PlayMode, videos: ArrayList<MMVideo>) {
        Log.d("LOG", this.javaClass.simpleName + " playVideo() | mode: $mode | videos number: ${videos.size}")
        mSessionManager.stop()
        PreferenceHelper.getInstance(this).putInt(ConstantPreference.MODE_PLAY_VIDEO, mode.value)
        when {
            mode == PlayMode.ON_DEMAND -> {
                VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_VIDEO_SEARCHED)
            }

            mode == PlayMode.SCHEDULE -> {
                VideoDBUtil.createOrUpdateVideos(videos, Constant.MM_SCHEDULE)
            }
        }
        val currentPosition: Long = PreferenceHelper.getInstance(this).getLong(ConstantPreference.LAST_PLAYED_VIDEO_POSITION,
                0L)
        ParameterUtils.isClearVideoOnPresentation = true
        mSessionManager.add(mode = mode, videos = videos, playedPosition = currentPosition)
    }

    //endregion
    @Suppress("DEPRECATION")
    @SuppressLint("HardwareIds")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        window.decorView.systemUiVisibility = flags

        if (!checkAuthorized()) return
        PreferenceHelper.getInstance(this)
        PreferenceManager.clearSchedulePref()
        // clear database
        VideoDBUtil.deleteAllVideos()

        setContentView(R.layout.activity_main)

        setupUI()

//        mSessionManagerListener.onCreate(this)

        registerMediaRouter()

        checkForUpdates()

        PermissionUtils.checkAndRequestWriteExternalPermission(activity = this)

        // TODO
        //clearFileAndDBForDownload()

        registerReceivers()

        registerService()

        //registerDownloadListener()

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            checkSendTokenDeviceFCM(it.token)
        }
        setupAlarmTimeCallEveryDay(this)
//        if (SharedPreferencesCustomized.getInstance(this).getBoolean(SPrefConstant.IS_SET_TIME_EVERY_DAY, true)) {
//            setupAlarmTimeCallEveryDay(this)
//            SharedPreferencesCustomized.getInstance(this).putBoolean(SPrefConstant.IS_SET_TIME_EVERY_DAY, false)
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Log.e("ffffff", Build.getSerial())
        } else {
            //Log.e("dddddd", Build.SERIAL)
        }

        //AlarmManagerSchedule.setupTimeWakeSchedule(this, 20)

        window.setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private fun checkSendTokenDeviceFCM(token: String) {
        val tokenAu: String = PreferenceHelper.getInstance(this).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(this).getString(ConstantPreference.DEVICE_ID, "")
        val isSendTokenFCM = PreferenceHelper.getInstance(this).getBoolean(ConstantPreference.IS_SEND_DEVICE_TOKEN, true)
        if (isSendTokenFCM && deviceId.isNotEmpty() && tokenAu.isNotEmpty()) {
            FirebaseApi().sendTokenFCMToServer(tokenAu, deviceId, token).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : SingleObserver<Response<Any>> {
                        override fun onSuccess(t: Response<Any>) {
                            if (t.code() == 200) {
                                PreferenceHelper.getInstance(this@MainActivity).putBoolean(ConstantPreference.IS_SEND_DEVICE_TOKEN, false)
                            }
                        }

                        override fun onSubscribe(d: Disposable) {

                        }

                        override fun onError(e: Throwable) {

                        }

                    })
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }

    // only use for the debug or test mode
    // disable this function when building for the client
    private fun clearFileAndDBForDownload() {
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED_VIDEOS)
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED)
        DownloadDBManager.getInstance().clearAll()
    }

    private fun registerService() {
        startService(Intent(this, DownloadService::class.java))
    }

    private fun registerReceivers() {
        // register network broadcast receiver
        val filter = IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        NetworkReceiver.getInstance().addListener(this)
        registerReceiver(NetworkReceiver.getInstance(), filter)

        // register casting TV (presentation) broadcast receiver
        val castingFilter = IntentFilter(CastingBroadcastReceiver.ACTION_TV)
        CastingBroadcastReceiver.getInstance().addListener(this)
        registerReceiver(CastingBroadcastReceiver.getInstance(), castingFilter)

        val castingFilterSchedule = IntentFilter(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
        registerReceiver(ScheduleBroadcastReceiver.getInstance(), castingFilterSchedule)

        val filterDownload = IntentFilter().apply {
            addAction(DownloadService.ACTION_DOWNLOAD_UI)
        }
        registerReceiver(mBroadcastReceiver, filterDownload)

    }

    // if expired then the app will navigate to the Scan Barcode screen
    private fun checkAuthorized(): Boolean {
        val token: String = PreferenceHelper.getInstance(this).getString(ConstantPreference.TOKEN, "")
        val deviceId: String = PreferenceHelper.getInstance(this).getString(ConstantPreference.DEVICE_ID, "")

        if (token.isEmpty() || deviceId.isEmpty()) {
            mIsReturnScanScreen = true
            goToScanBarCode()
            return false
        }
        return true
    }

    private fun readDownloadIntent(intent: Intent) {
        when (intent.getStringExtra(DownloadService.DOWNLOAD_VIDEO_UI)) {
            //Constant.DOWNLOAD_START_UI -> showDialogLoadingDownloaded()
            Constant.DOWNLOAD_END_UI -> showDialogLoadingDownloaded()
            Constant.DOWNLOAD_END_UI_MEMORY -> {
                //hideDialogLoadingDownload()
                onInsufficientSpace()
            }
            //Constant.DOWNLOAD_UPDATE_UI -> setTextForDialogDownloading()
            //Constant.DOWNLOAD_CHANGE_SUB_UI -> destroyDialogWhenChangeSub()
        }
    }

    private fun showDialogLoadingDownloaded() {
        DialogUtil.createDialogOnlyOneButton(this,
                R.style.NormalDialog, "All videos have been downloaded", R.string.btn_ok, null).show()
    }

    private fun onInsufficientSpace() {
        if (isShownDialogNotEnoughSpace) return
        isShownDialogNotEnoughSpace = true
        DialogUtil.createDialogOnlyOneButton(this,
                R.style.NormalDialog_Error,
                getString(R.string.cant_download_because_not_enough_space),
                R.string.btn_ok,
                object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface?, p1: Int) {
                        dialogInterface?.dismiss()
                    }

                }).show()
    }


    private fun goToScanBarCode() {
        val broadCast = Intent().apply {
            action = DownloadService.ACTION_DOWNLOAD
            putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.CANCEL_DOWNLOAD)
        }
        sendBroadcast(broadCast)
        clearAllDataDownload()
        ParameterUtils.isFragmentHomeOpen = true
        val intent = Intent(this, ScanBarCodeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }

    override fun onResume() {
        super.onResume()
        Log.d("LOG", this.javaClass.simpleName + " onResume() | current thread: ${Thread.currentThread()} | name: ${Thread.currentThread().name}")
        PreferenceHelper.getInstance(this).putBoolean(ConstantPreference.IS_IN_BACKGROUND, false)
        mIsVisble = true
        appVisible = true
        checkForCrashes()

        showNetworkDisconnectedDialogIf()
//        mSessionManagerListener.onSetup(this)
        mPlayer?.onAppViewVisible()
        if(isMediaProviderChangedInBackground){
            isMediaProviderChangedInBackground = false
            handleOnProviderChanged(route)
            route = null
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("LOG", this.javaClass.simpleName + " onSaveInstanceState()")
        PreferenceHelper.getInstance(this).putBoolean(ConstantPreference.IS_IN_BACKGROUND, true)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("LOG", this.javaClass.simpleName + " onRestoreInstanceState()")
        PreferenceHelper.getInstance(this).putBoolean(ConstantPreference.IS_IN_BACKGROUND, false)
    }

    private fun showNetworkDisconnectedDialogIf() {
        if (mIsFirst) {
            mIsFirst = false
            return
        }

        mDisconnectDialog?.dismiss()
        if (!NetworkReceiver.getInstance().isNetworkConnected()) {
            val msg = getString(R.string.msg_network_disconnected)
            mDisconnectDialog = DialogUtil.createDialogOnlyOneButton(this,
                    R.style.NormalDialog_Error, msg, R.string.btn_ok, null)
            mDisconnectDialog!!.show()
        }
    }

    fun showDialogBackToHome() {
        mBackToHomeDialog?.also {
            it.dismiss()
            mBackToHomeDialog = null
        }
        mBackToHomeDialog = DialogUtil.createDialogOnlyOneButton(this,
                R.style.NormalDialog_Error, "Your video data in your subscription has been changed", R.string.btn_ok, null)
        mBackToHomeDialog?.show()
    }

    fun hideDialogBackToHome() {
        mBackToHomeDialog?.let {
            it.dismiss()
        }
    }

    fun getTokenAgainWhenTokenExpire(callback: IGetNewToken) {
        val email = PreferenceHelper.getInstance(this).getString(ConstantPreference.EMAIL, "")
        val password = PreferenceHelper.getInstance(this).getString(ConstantPreference.PASSWORD, "")

        val deviceId = PreferenceHelper.getInstance(this).getString(ConstantPreference.DEVICE_ID, "")
        LoginApi().login(email, password, deviceId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : BaseResponseObserver<MMLoginResponseData>() {
                    override fun onResponseSuccess(data: ResponseValue<MMLoginResponseData>?) {
                        super.onResponseSuccess(data)
                        if (data == null) {

                        } else {
                            if (data.data.token != null) {
                                (data.data.cookie)?.also {
                                    storeCookie(it, data.data.token!!)
                                }
                            }
                        }
                        callback.onGetSuccess()
                    }

                    override fun onExpired(error: String) {
                        callback.onGetSuccess()
                    }

                    override fun onExpiredUnauthenticated(error: String) {
                        callback.onGetSuccess()
                    }

                })
    }

    private fun storeCookie(cookie: MMCookie?, token: String) {
        if (cookie == null) return
        val policy = cookie.policy
        val signature = cookie.signature
        val keyPairid = cookie.keyPairId
        val builder = StringBuilder()
        builder.append("CloudFront-Policy=").append(policy)
        builder.append(";CloudFront-Signature=").append(signature)
        builder.append(";CloudFront-Key-Pair-Id=").append(keyPairid)
        PreferenceHelper.getInstance(this).putString(ConstantPreference.SP_COOKIE, builder.toString())
        PreferenceHelper.getInstance(this).putString(ConstantPreference.TOKEN, token)
    }

    fun getApiConfigData() {
        val tokenAu: String = PreferenceHelper.getInstance(this).getString(ConstantPreference.TOKEN, "")
        val deviceId = PreferenceHelper.getInstance(this).getString(ConstantPreference.DEVICE_ID, "")
        HomeApi().getConfigData(tokenAu, deviceId)
                .subscribe(object : BaseResponseObserver<MMConfigData>() {

                    override fun onExpiredUnauthenticated(error: String) {

                    }

                    override fun onResponseSuccess(data: ResponseValue<MMConfigData>?) {
                        super.onResponseSuccess(data)
                        if (data?.data == null) {
                            return
                        }
                        data.data.countDown?.let {
                            if (it > 0L) {
                                ParameterUtils.countTime = it + 1000L
                            } else {
                                ParameterUtils.countTime = 1000L
                            }
                        }
                        savePref(data.data)
                        storeBranding(data.data.branding)
                    }

                    override fun onExpired(error: String) {

                    }

                })
    }

    override fun onPause() {
        mIsVisble = false
        appVisible = false
        mPlayer?.onAppViewInVisible()
        unregisterManagers()
        super.onPause()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Log.d("LOG", this.javaClass.simpleName + " onTrimMemory() | level: $level")
    }

    override fun onDestroy() {
        try {
            handlerMain.removeCallbacks(null)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mPlayer?.release()
        unregisterReceivers()
        VideoDBUtil.deleteAllVideos()
        super.onDestroy()
    }

    private fun unregisterReceivers() {
        try {
            if (CastingBroadcastReceiver.getInstance().isRegistered(this)) {
                unregisterReceiver(CastingBroadcastReceiver.getInstance())
                CastingBroadcastReceiver.getInstance().removeListener(this)
            }
            ScheduleBroadcastReceiver.getInstance().release()
            unregisterReceiver(ScheduleBroadcastReceiver.getInstance())
            unregisterReceiver(mBroadcastReceiver)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //mDownloadingHelper?.release()

        try {
            if (NetworkReceiver.getInstance().isRegistered(this)) {
                unregisterReceiver(NetworkReceiver.getInstance())
                NetworkReceiver.getInstance().removeListener(this)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun checkFileStorageDownloaded() {
        val listDoesNotDownloaded = ArrayList<Int>()
        val indexForRemove = ArrayList<MMVideo>()
        if (FileUtil.isExternalStorageAvailable() && !FileUtil.isExternalStorageReadOnly() && FileUtil.isSDCardAvailable(this)) {
            val externalUrl = getExternalFilesDirs(null)
            if (externalUrl?.get(1) != null) {
                if (File(externalUrl[1], Constant.FOLDER_DOWNLOADED).exists()) {
                    val dir = File(externalUrl[1], Constant.FOLDER_DOWNLOADED)
                    if (dir.isDirectory) {
                        for (f in dir.list()) {
                            val a = File(dir, f).name.split(".")
                            try {
                                listDoesNotDownloaded.add(a[0].toInt())
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
        }
        if (File(filesDir, Constant.FOLDER_DOWNLOADED).exists()) {
            val dir = File(filesDir, Constant.FOLDER_DOWNLOADED)
            if (dir.isDirectory) {
                for (f in dir.list()) {
                    val a = File(dir, f).name.split(".")
                    try {
                        listDoesNotDownloaded.add(a[0].toInt())
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        if (listDoesNotDownloaded.isEmpty()) return
        val videosFromData = VideoDBUtil.readAllDVideosFromDB(Constant.TAG_VIDEO_DOWNLOAD)
        if (videosFromData.isEmpty()) return
        for (j: Int in 0 until videosFromData.size) {
            for (i: Int in 0 until listDoesNotDownloaded.size) {
                if (videosFromData[j].id == listDoesNotDownloaded[i]) {
                    indexForRemove.add(videosFromData[j])
                    break
                }
            }
        }
        for (i in indexForRemove) {
            videosFromData.remove(i)
        }
        if (videosFromData.isEmpty()) return
        for (video in videosFromData) {
            video.id?.let {
                VideoDBUtil.updateTabledVideoDownloadedToFalse(it)
            }
        }
    }

    fun navigateToHomeScreen() {
        FragmentUtil.replaceFragment(
                fm = supportFragmentManager,
                newFragment = HomeFragment.getInstanceWithLoadSchedule(),
                newFragmentTag = HomeFragment.TAG,
                frameId = R.id.frameLayoutHome,
                isAddToBackStack = false
        )
    }

    /**
     * Hockey App
     */
    private fun checkForCrashes() {
//        CrashManager.register(this)
    }

    private fun checkForUpdates() {
        // Remove this for store builds!
//        UpdateManager.register(this)
    }

    private fun unregisterManagers() {
//        UpdateManager.unregister()
    }

    /**
     * ---------
     */

    private fun setupUI() {
        // show (add) the Home screen
        FragmentUtil.addNewFragment(supportFragmentManager, SplashFragment(), R.id.frameLayoutHome)
    }

//    private fun registerDownloadListener() {
//        mDownloadingHelper = ActivityDownloadHelper(activity = this, view = frameLayoutHome)
//    }

    fun getFragment(tag: String): Fragment? {
        return getFragment(supportFragmentManager, tag)
    }

    fun getFragment(fm: FragmentManager, tag: String): Fragment? {
        var fragment: Fragment? = null

        for (frag: Fragment in fm.fragments) {
            if (frag.tag.equals(tag)) {
                fragment = frag
                break
            }
            fragment = getFragment(frag.childFragmentManager, tag)
            if (fragment != null) break
        }

        return fragment
    }

    fun onBackPreviousScreen() {
        try {
            val lastIndex = supportFragmentManager.fragments.size - 1
            if (lastIndex < 0) return

            supportFragmentManager.fragments[lastIndex]?.childFragmentManager?.also { childFragmentManager ->
                Log.d("LOG", this.javaClass.simpleName + " onBackPreviousScreen() | last fragment: ${supportFragmentManager.fragments[lastIndex].javaClass.simpleName}")
                Log.d("LOG", this.javaClass.simpleName + " onBackPreviousScreen() | child fragments number: ${childFragmentManager.backStackEntryCount}")
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    return
                }
            }

            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
                return
            }
        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            try{

            }catch (e:Exception){
                val currentDate: String =
                    SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())
                FirebaseCrashlytics.getInstance().log("crash on backing to previous screen | date: $currentDate")
            }
        }
    }

    // disable the BACK button
    override fun onBackPressed() {}

    fun openScanBarCodeScreen() {
        val broadCast = Intent().apply {
            action = DownloadService.ACTION_DOWNLOAD
            putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.CANCEL_DOWNLOAD)
        }
        sendBroadcast(broadCast)
        clearAllDataDownload()
        ParameterUtils.isFragmentHomeOpen = true
        PreferenceHelper.getInstance(this).clearAllCached()

        val intent = Intent(this, ScanBarCodeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        finish()
    }

    private fun clearAllDataDownload() {
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED_VIDEOS)
        FileUtil.clearFolder(this, Constant.FOLDER_DOWNLOADED)
        DownloadDBManager.getInstance().clearAll()
        PreferenceHelper.getInstance(this).putBoolean(ConstantPreference.IS_DOWNLOAD_VIDEOS, true)
        PreferenceHelper.getInstance(this).putInt(ConstantPreference.DOWNLOAD_VIDEOS_SUBS_ID, -1)
    }

    override fun onChangedState(isConnected: Boolean) {
        if (!mIsVisble) return // only show the disconnected dialog on visible app
        mDisconnectDialog?.dismiss()

        when (isConnected) {
            true -> showMessage(R.string.msg_network_connected, R.color.white)
            false -> {
                val msg = getString(R.string.msg_network_disconnected)
                mDisconnectDialog = DialogUtil.createDialogOnlyOneButton(this,
                        R.style.NormalDialog_Error, msg, R.string.btn_ok, null).also { it.show() }
            }
        }
    }

    fun showMessage(@StringRes messageRes: Int, @ColorRes colorRes: Int) {
        MessageUtils.showSnackBar(frameLayoutHome, messageRes, colorRes)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PermissionUtils.REQUEST_CODE_PERMISSION_DOWNLOAD -> {
                if (permissions.isNotEmpty() && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (PreferenceHelper.getInstance(this).getBoolean(ConstantPreference.SS_DOWNLOADED_BUT_NO_PERMISSION,
                                    defValue = false)) {
                        DialogUtil.createDialogOnlyOneButton(context = this, msgResId = player.wellnesssolutions.com.network.R.string.press_download_button_more_to_download,
                                titleButton = player.wellnesssolutions.com.network.R.string.btn_ok, dialogClickListener = null).show()

                        PreferenceHelper.getInstance(this).delete(ConstantPreference.SS_DOWNLOADED_BUT_NO_PERMISSION)
                    }
                } else {
                    MessageUtils.showToast(this, R.string.no_permissions_needed_for_download, R.color.yellow)?.show()
                }
            }
        }
    }

    fun isPlayingClass(): Boolean = mSessionManager.isPlayingNowPlaying()
    fun isPlayingSearchedVideos(): Boolean = mSessionManager.isPlayingSearchVideos()
    fun isPlayingPresentation(): Boolean = mSessionManager.isPlayingPresentaion()
    fun getPresentationPlayMode(): PlayMode = mSessionManager.getPlayingMode()

    fun getPresentationVideos(): ArrayList<MMVideo> = mSessionManager.getVideos()

    fun onPlayPresentationVideoAt(position: Int) {
        mSessionManager.onPlayPresentationVideoAt(position)
    }

    fun clearPresentationVideos() {
        mSessionManager.clearAllVideos()
    }

    private fun storeBranding(branding: MMBranding?) {
        if (branding == null) return

        PreferenceHelper.getInstance(context = this).putString(ConstantPreference.SS_BOTTOM_BAR_COLOR, branding.bottomBarColor
                ?: "")
        PreferenceHelper.getInstance(context = this).putString(ConstantPreference.PRIMARY_COLOR, branding.primaryColor
                ?: "")
        PreferenceHelper.getInstance(context = this).putString(ConstantPreference.SECONDARY_COLOR, branding.textColor
                ?: "")
        PreferenceHelper.getInstance(context = this).putString(ConstantPreference.SS_COMPANY_LOGO, branding.companyLogo
                ?: "")
        if (branding.backgroundPictures?.size == 0) {
            PreferenceHelper.getInstance(context = this).delete(ConstantPreference.SS_BACKGROUND_PICTURES)
        } else {
            PreferenceHelper.getInstance(context = this).putStrings(ConstantPreference.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
        }

    }

    private fun savePref(data: MMConfigData) {
        val gson = Gson()
        val json = gson.toJson(data)
        PreferenceHelper.getInstance(this).putString(ConstantPreference.SS_CONFIG, json)
    }

    /**
     * @interface CastingBroadcastReceiver.Callback
     */

    override fun onCookieExpired() {
        val msgBuilder = StringBuilder("Unauthenticated.")
        msgBuilder.append("\n\n")
        msgBuilder.append(getString(R.string.confirm_want_to_return_home_screen))

        onReturnHomeScreen(msgBuilder.toString())
    }

    private fun onReturnHomeScreen(message: String) {
        val okButtonListener = DialogInterface.OnClickListener { _, _ -> returnHomeScreen() }
        val dialog = DialogUtil.createDialogOnlyOneButton(this, message, R.string.btn_ok, okButtonListener)
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun returnHomeScreen() {
        getTokenAgainWhenTokenExpire(object : IGetNewToken {
            override fun onGetSuccess() {
                //Todo
            }
        })
        navigateToHomeScreen()


    }


    /**
     * ---------------
     */

    companion object {
        private const val TAG = "MainActivity"
    }
}