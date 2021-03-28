package player.wellnesssolutions.com.common.constant

object Constant {
    /**
     * "Header X-Device not found.", "Your account is inactive.",
    "Device not found.", "Device is inactive."
     */
    // SERVICE
    const val HEADER_X_DEVICE_NOT_FOUND = "Header X-Device not found."
    const val YOUR_ACCOUNT_IS_INACTIVE = "Your account is inactive."
    const val DEVICE_NOT_FOUND = "Device not found."
    const val DEVICE_IS_INACTIVE = "Device is inactive."
    const val UNAUTHENTICATED = "Unauthenticated."
    const val FAILED_TO_CONNECT = "failed to connect to"

    // default branding value
    const val DEF_PRIMARY_COLOR = "#041e41"
    const val DEF_SECONDARY_COLOR = "#00c3b3"
    const val DEF_COLLECTION_TEXT_COLOR = "#979797"
    const val DOUBLE_DOTS = ".."
    const val QUESTION_MASK = "?"
    const val WHITE_SPACE = " "
    const val EMPTY = ""

    const val MOVE_SILVER_BRAND_BG_COLOR = "#edec00"
    const val MIND_WELNESS_BRAND_BG_COLOR = "#4bc0b3"
    const val MOVE_EXCERCISE_BRAND_BG_COLOR = "#ffffff"

    const val SEARCH_UNKNOWN = -1
    const val SEARCH_BRAND = SEARCH_UNKNOWN + 1
    const val SEARCH_CRITERIA = SEARCH_BRAND + 1
    const val SEARCH_COLLECTION = SEARCH_CRITERIA + 1
    const val SEARCH_DURATION = SEARCH_COLLECTION + 1
    const val SEARCH_PRESENTER = SEARCH_DURATION + 1
    const val SEARCH_LEVEL = SEARCH_PRESENTER + 1

    const val DEFAULT_MAX_ITEMS_COUNT_IN_ROW = 4
    const val DEAFULT_MAX_ROWS = 2

    const val MAX_COLLECTION_ITEMS_COUNT_IN_ROW = 5
    const val MAX_COLLECTION_ROWS = 2

    const val MAX_PRESENTER_ITEMS_COUNT_IN_ROW = 6 // INSTRUCTOR
    const val MAX_PRESENTER_ROWS = 3

    const val RATIO_STROKE_BORDER = 0.065f
    const val RATIO_SQUARE_INNER_CIRCLE = 1.42f

    const val COL_COUNT_SCREEN_SEARCH_RESULT = 4
    const val ROW_COUNT_SCREEN_SEARCH_RESULT = 3

    const val DEF_EXO_VOLUME = 0.7f

    const val FOLDER_DOWNLOADED_VIDEOS = "videos"
    const val FOLDER_DOWNLOADED = "downloaded"
    const val M3U8 = "m3u8"

    const val MSG_NOW_CLASS_NOW = "No class now"
    const val DASH = "-"
    const val MSG_NO_SCHEDULE_TODAY = "There is no schedule today !"
    const val SHARP = "#"
    const val SCHEDULE_INTENT = "schedule_intent"
    const val SCHEDULE_ALARM_EVERY = "schedule_alarm_every"
    const val SCHEDULE_ALARM_TIME = "schedule_alarm_time"
    const val SCHEDULE_TAG = "schedule_tag"
    const val SCHEDULE_BROAD_CAST_EVERY = "schedule_broad_cast_every"
    const val SCHEDULE_BROAD_CAST_TIME = "schedule_broad_cast_time"
    const val SCHEDULE_BROAD_CAST_UPDATE = "schedule_broad_cast_update"
    const val API_CHANGE_BACK_TO_HOME = "api_change_back_to_home"
    const val API_CHANGE_BACK_TO_HOME_GET_CONFIG = "api_change_back_to_home_get_config"
    const val API_CHANGE_GET_CONFIG = "api_change_get_config"
    const val API_CHANGE_SUB = "api_change_sub"
    const val API_REMOVE_VIDEO_SERVICE = "api_remove_video_service"
    const val API_ADD_VIDEO_SERVICE = "api_add_video_service"
    const val API_CHANGE_SUB_SERVICE = "api_change_sub_service"

    const val DOWNLOAD_START = "download_start"
    const val DOWNLOAD_END = "download_end"

    const val DOWNLOAD_START_UI = "download_start_ui"
    const val DOWNLOAD_UPDATE_UI = "download_update_ui"
    const val DOWNLOAD_END_UI = "download_end_ui"
    const val DOWNLOAD_CHANGE_SUB_UI = "download_change_sub_ui"
    const val DOWNLOAD_END_UI_MEMORY = "download_end_ui_memory"

    const val scheduleChanges = "scheduleChanges"
    const val countdownChanges = "countdownChanges"
    const val subscriptionChanges = "subscriptionChanges"
    const val removedVideosChanges = "removedVideosChanges"
    const val addedVideosChanges = "addedVideosChanges"
    const val eloquentSaved = "eloquentsaved"
    const val eloquentcreated = "eloquentcreated"
    const val eloquentdeleted = "eloquentdeleted"


    const val AppModel = "AppModel"

    const val Brand = "Brand"
    const val lBundle = "Bundle"
    const val Collection = "Collection"
    const val Duration = "Duration"
    const val Instructor = "Instructor"
    const val PlayerConfigAnswer = "PlayerConfigAnswer"
    const val PlayerConfigButtonsDisplay = "PlayerConfigButtonsDisplay"
    const val PlayerConfigQuestion = "PlayerConfigQuestion"
    const val ScheduleDetail = "ScheduleDetail"
    const val Video = "Video"
    const val Workout = "Workout"
    const val Series = "Series"
    const val UserBranding = "UserBranding"
    const val BundleVideo = "BundleVideo"
    const val TAG_VIDEO_DOWNLOAD = "DownloadTag"

    const val CANCEL_DOWNLOAD = "cancel_download"
    const val DOWNLOAD_FAILIED = "Failed"
    const val DOWNLOAD_COMPLETED = "Completed"
    const val DOWNLOAD_DOWNLOADING = "Downloading"

    /**
     * SCHEDULE
     */
    const val MM_SCHEDULE = "MM_SCHEDULE"
    const val BUNDLE_SCHEDULE = "BUNDLE_SCHEDULE"
    const val BUNDLE_SOURCE_SCHEDULE = "BUNDLE_SOURCE_SCHEDULE"
    const val BUNDLE_SHOW_POPUP = "BUNDLE_SHOW_POPUP"

    /**
     * VIEW
     */
    const val TIME_TRANSITION_SCREEN = 1600L
    const val TIME_POST_DELAY_DEFAULT = 1000L
    const val NUM_MAX_TRY_POST_DELAY = 5
    const val IS_CAST_DISCONNECT = "IS_CAST_DISCONNECT"
    const val BUNDLE_SAVE_STATE = "BUNDLE_SAVE_STATE"

    /**
     * NETWORK
     */
    const val ERROR_CANT_CONNECT_SERVER = "Cannot connect to the server. Please check network and try again."

    const val TIME_MAX_CAN_ROUND = 3000L
    const val TIME_CHANGE_SCREEN = 1000L
}