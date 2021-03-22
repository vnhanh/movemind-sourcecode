package player.wellnesssolutions.com.network.datasource.time_network

import android.os.AsyncTask
import org.apache.commons.net.ntp.NTPUDPClient
import org.apache.commons.net.ntp.TimeInfo
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.InetAddress

/**
 * @return time diffrent remote network and local device. If can not acccess time server, it will return zero
 *
 */
class RequestTimeServer(listener : IRequestTimeNetworkListener?) : AsyncTask<Void, Void, Long>() {
    private var mWeakRef = WeakReference(listener)
    private val TIME_SERVER = "time-a.nist.govn"
    private var error = ""

    override fun doInBackground(vararg param : Void) : Long {
        try {
            return getNetworkTime() - System.currentTimeMillis()
        } catch (e : IOException) {
            error = e.message ?: ""
        } catch (e : Exception) {
            error = e.message ?: ""
        }

        return 0L
    }

    override fun onPostExecute(result : Long) {
        super.onPostExecute(result)
        mWeakRef.get()?.onRecivedTime(result)
        mWeakRef.clear()
    }

    @Throws(IOException::class)
    fun getNetworkTime() : Long {
        val timeClient = NTPUDPClient()
        val inetAddress : InetAddress = InetAddress.getByName(TIME_SERVER)
        val timeInfo : TimeInfo = timeClient.getTime(inetAddress)
        return timeInfo.message.receiveTimeStamp.time
    }
}