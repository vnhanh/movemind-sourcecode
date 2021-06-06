package player.wellnesssolutions.database.manager

interface IProgressListener {

    // on download completed and copy tempt file from ssd card to app folder (success)
    fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String)

    fun onDoesNotEnoughMemory() {}

    fun onDownloaded() {}

    fun deleteVideoIdWhenDownloadFailed(videoId: Int, fileName: String?, url: String?) {}

    fun updateVideoIdWhenDownloadFailed(videoId: Int) {}
}