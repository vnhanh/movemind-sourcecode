package player.wellnesssolutions.com.network.datasource

object RequestUtil {
    const val APP_JSON = "application/json"
    private const val BEARER = "Bearer"

    fun getTokenHeader(token:String) : String = String.format("%s %s", BEARER, token)
}