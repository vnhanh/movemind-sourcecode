package player.wellnesssolutions.com.network.datasource.time_network

interface IRequestTimeNetworkListener {
    fun onRecivedTime(timeDiffs:Long)
}