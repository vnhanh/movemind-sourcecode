package player.wellnesssolutions.com.services

import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import player.wellnesssolutions.com.base.utils.ParameterUtils
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.network.models.fcm.MessageFirebase
import player.wellnesssolutions.com.ui.activity_main.ScheduleBroadcastReceiver

class FCMService : FirebaseMessagingService() {

    override fun onMessageReceived(mes: RemoteMessage) {
        super.onMessageReceived(mes)
        var dataString = ""
        for (map: MutableMap.MutableEntry<String, String> in mes.data) {
            dataString = map.value
        }
        val reg = Regex("[^A-Za-z0-9_'{}:,\\[\\]]")
        val mapDataString = dataString.replace(reg, "")

        var fcmData: MessageFirebase? = null
        try {
            fcmData = Gson().fromJson(mapDataString, MessageFirebase::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (fcmData != null && applicationContext != null) {
            when (fcmData.event_type) {
                Constant.scheduleChanges -> {
                    ParameterUtils.isClearVideoOnPresentation = false
                    val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                    intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.SCHEDULE_BROAD_CAST_UPDATE)
                    application?.let {
                        it.sendBroadcast(intentSend)
                    }
                }
                /*Constant.eloquentSaved, Constant.eloquentcreated, Constant.eloquentdeleted -> {
                    when (fcmData.modal) {
                        mergeStringWithAppModel(Constant.Brand),
                        mergeStringWithAppModel(Constant.lBundle),
                        mergeStringWithAppModel(Constant.Collection),
                        mergeStringWithAppModel(Constant.Duration),
                        mergeStringWithAppModel(Constant.Instructor),
                        mergeStringWithAppModel(Constant.Video),
                        mergeStringWithAppModel(Constant.Workout),
                        mergeStringWithAppModel(Constant.Series),
                        mergeStringWithAppModel(Constant.BundleVideo)
                        -> {
                            val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                            intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_BACK_TO_HOME)
                            application?.let {
                                it.sendBroadcast(intentSend)
                            }
                        }
                        mergeStringWithAppModel(Constant.UserBranding),
                        mergeStringWithAppModel(Constant.PlayerConfigAnswer),
                        mergeStringWithAppModel(Constant.PlayerConfigButtonsDisplay),
                        mergeStringWithAppModel(Constant.PlayerConfigQuestion) -> {
                            val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                            intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_BACK_TO_HOME_GET_CONFIG)
                            application?.let {
                                it.sendBroadcast(intentSend)
                            }
                        }

                    }
                }*/
                Constant.countdownChanges -> {
                    val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                    intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_GET_CONFIG)
                    application?.let {
                        it.sendBroadcast(intentSend)
                    }
                }

                Constant.subscriptionChanges -> {
                    val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                    intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_SUB)
                    try {
                        if (fcmData.videoIds.isNotEmpty()) {
                            val dataArray = fcmData.videoIds.removeSurrounding("[", "]").split(",")
                                    .map { it.toInt() }.toIntArray()
                            val intent = Intent().apply {
                                action = DownloadService.ACTION_DOWNLOAD
                                putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.API_CHANGE_SUB_SERVICE)
                                putExtra(DownloadService.DATA_VIDEOS, dataArray)
                            }
                            application?.let {
                                it.sendBroadcast(intent)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    application?.let {
                        it.sendBroadcast(intentSend)
                    }
                }

                Constant.removedVideosChanges -> {
                    val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                    intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_SUB)
                    try {
                        if (fcmData.videoIds.isNotEmpty()) {
                            val dataArray = fcmData.videoIds.removeSurrounding("[", "]").split(",")
                                    .map { it.toInt() }.toIntArray()
                            val intent = Intent().apply {
                                action = DownloadService.ACTION_DOWNLOAD
                                putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.API_REMOVE_VIDEO_SERVICE)
                                putExtra(DownloadService.DATA_VIDEOS, dataArray)
                            }
                            application?.let {
                                it.sendBroadcast(intent)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    application?.let {
                        it.sendBroadcast(intentSend)
                    }
                }

                Constant.addedVideosChanges -> {
                    val intentSend = Intent(ScheduleBroadcastReceiver.ACTION_SCHEDULE)
                    intentSend.putExtra(ScheduleBroadcastReceiver.SCHEDULE_PLAY_VIDEO, Constant.API_CHANGE_SUB)
                    try {
                        if (fcmData.videoIds.isNotEmpty()) {
                            val dataArray = fcmData.videoIds.removeSurrounding("[", "]").split(",")
                                    .map { it.toInt() }.toIntArray()
                            val intent = Intent().apply {
                                action = DownloadService.ACTION_DOWNLOAD
                                putExtra(DownloadService.DOWNLOAD_VIDEO, Constant.API_ADD_VIDEO_SERVICE)
                                putExtra(DownloadService.DATA_VIDEOS, dataArray)
                            }
                            application?.let {
                                it.sendBroadcast(intent)
                            }
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                    application?.let {
                        it.sendBroadcast(intentSend)
                    }
                }


            }
        }
    }

}
