package player.wellnesssolutions.com.network.network_connect

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


class NetworkReceiver : BroadcastReceiver() {

    private val listeners = ArrayList<IStateListener>()
    private var isFirst = true
    private var isConnected = false

    override fun onReceive(context: Context, intent: Intent) {
        isConnected = checkConnectState(context)
//        Log.d("LOG", "onReceive() | isConnected: $isConnected")
        if(isFirst && isConnected) {
            isFirst = false
            return
        }
        for (listener : IStateListener in listeners) {
            listener.onChangedState(isConnected)
        }
    }

    @Suppress("DEPRECATION")
    fun checkConnectState(context:Context?) : Boolean{
//        Log.d("LOG", this.javaClass.simpleName + " checkConnectState() | sdk version: ${Build.VERSION.SDK_INT}")
        if(context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val nw      = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    true
                }
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            val nwInfo = connectivityManager.activeNetworkInfo ?: return false
            return nwInfo.isConnected
        }
    }

    fun isNetworkConnected() :Boolean = isConnected

    fun addListener(listener: IStateListener) {
        if(listeners.contains(listener)) return
        listeners.add(listener)
    }

    fun isRegistered(listener: IStateListener) : Boolean = listeners.contains(listener)

    fun removeListener(listener: IStateListener) {
        listeners.remove(listener)
    }

    interface IStateListener {
        fun onChangedState(isConnected: Boolean)
    }

    companion object{
        private val INSTANCE = NetworkReceiver()

        fun getInstance() :NetworkReceiver = INSTANCE
    }
}