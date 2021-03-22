package player.wellnesssolutions.database.manager

interface IProgressListener {

    // on download completed and copy tempt file from ssd card to app folder (success)
    fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String)

    // on download task start (after user confirms download permissions)
    fun onDownloadStarted(videoId: Int) {}

    // callbacks called in addTask() function
    fun onAddTaskFailedBecauseDataNull(videoId: Int) {}

    fun onTaskExist(videoId: Int, fileName: String) {}

    fun onInsufficientSpace(videoId: Int?, fileName: String?, availableSpace: Long, fileLength: Long) {}

    fun onDownloadCannotStart(videoId: Int, fileName: String) {}

    fun onDoesNotEnoughMemory() {}

    fun onDownloaded() {}

    fun deleteVideoIdWhenDownloadFailed(videoId: Int, fileName: String?, url: String?) {}

    fun updateVideoIdWhenDownloadFailed(videoId: Int) {}

}