package player.wellnesssolutions.database.manager

interface IProgressListener {

    fun onDownloadStarted(videoId: Int)

    fun onDownloadCompleted(videoId: Int, fileName: String?, isSuccess: Boolean, message: String)

    fun onDoesNotEnoughMemory() {}

    fun onDownloaded() {}

    fun deleteVideoIdWhenDownloadFailed(videoId: Int, fileName: String?, url: String?) {}

    fun updateVideoIdWhenDownloadFailed(videoId: Int) {}
}