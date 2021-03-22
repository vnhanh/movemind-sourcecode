package player.wellnesssolutions.com.services.download

class DownloadData(var videoId: Int, var url: String) {
    var id: Long? = null
    var folder: String? = null
    var name: String? = null
    var filePath: String? = null
    var filePathExternal: String? = null
}