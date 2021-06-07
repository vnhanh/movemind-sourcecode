package player.wellnesssolutions.com.services.download

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import com.google.android.exoplayer2.upstream.DataSink
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.crypto.AesCipherDataSink
import com.google.android.exoplayer2.util.Util
import com.google.firebase.crashlytics.FirebaseCrashlytics
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.common.utils.FileUtil
import player.wellnesssolutions.com.network.network_connect.NetworkReceiver
import java.io.*
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL

class DownloadTask(private var context: Context?, callback: Callback) : AsyncTask<DownloadData, Int, Int>() {
    private var mWeakCallbacks = mutableListOf(WeakReference(callback))
    private var mDownloadData: DownloadData? = null
    private var mCookieValue = PreferenceHelper.getInstance()?.getString(ConstantPreference.SP_COOKIE, "").orEmpty()
    private var mReason = ""
    private var mFileLength = 0L
    private var mAvailableSpace = 0L

    private lateinit var savedFile: File
    private lateinit var connection: HttpURLConnection
    private lateinit var input: InputStream
    private lateinit var output: OutputStream
    private lateinit var aesCipherDataSink: AesCipherDataSink

    private var isFirstDownloadTask = true

    fun addListener(callback: Callback) {
        mWeakCallbacks.add(WeakReference(callback))
    }

    override fun doInBackground(vararg params: DownloadData?): Int {
        if (params.isEmpty()) {
            mReason = ERR_NO_URL
            return CODE_FAILED
        }
        val downloadData = params[0]
        this.mDownloadData = downloadData

        if (downloadData == null || downloadData.url.isEmpty()) {
            mReason = ERR_NO_URL
            return CODE_FAILED
        }

        //save with external
        if (downloadData.filePathExternal != null) {
            savedFile = File(downloadData.filePathExternal.orEmpty())
            return saveFileExternal(downloadData)
        } else {
            savedFile = File(downloadData.filePath.orEmpty())
            return saveFileInternal(downloadData)
        }
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)

        if (values.isEmpty()) return
        val progress = values[0] ?: return
        when (progress < 0) {
            true -> {

            }
            false -> {
                if (isFirstDownloadTask) {
                    isFirstDownloadTask = false
                    for (weakCallback in mWeakCallbacks) {
                        weakCallback.get()?.onDownloadStarted(mDownloadData?.videoId, mDownloadData?.name)
                    }
                }
                for (weakCallback in mWeakCallbacks) {
                    weakCallback.get()?.onDownloadUpdate(mDownloadData?.videoId, mDownloadData?.name, progress)
                }
            }
        }
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        if (isNetworkDisconnected()) mReason = ERR_NETWORK_DISCONNECTED

        when (result) {
            CODE_COMPLETED -> {
                for (weakCallback in mWeakCallbacks) {
                    weakCallback.get()?.onDownloadCompleted(mDownloadData?.videoId, mDownloadData?.name)
                }
            }
            else -> {
                when (mReason) {
                    ERR_INSUFFICIENT_SPACE -> {
                        for (weakCallback in mWeakCallbacks) {
                            weakCallback.get()?.onInsufficientSpace(mDownloadData?.videoId, mDownloadData?.name, mAvailableSpace / 1024 / 1024, mFileLength / 1024 / 1024)
                        }
                    }

                    else -> {
                        for (weakCallback in mWeakCallbacks) {
                            weakCallback.get()?.onDownloadFailed(mDownloadData?.videoId, mDownloadData?.name, mReason, mDownloadData?.url)
                        }
                    }
                }
            }
        }
        release()
    }

    private fun saveFileInternal(downloadData: DownloadData): Int {
        var isEncounteredOOM = false
        try {
            val httpURLConnection = URL(downloadData.url).openConnection() as HttpURLConnection
            connection = httpURLConnection
            connection.connectTimeout = 3000
            connection.setRequestProperty("Cookie", mCookieValue)

            var total = 0L

            var isAppend = false
            if (!savedFile.exists()) {
                savedFile.createNewFile()
            } else {
                total = savedFile.length()
                isAppend = true
                connection.setRequestProperty("Range", "bytes=" + savedFile.length() + "-")
            }

            connection.connect()

            val inputStream = BufferedInputStream(connection.inputStream)
            input = inputStream
            mFileLength = connection.contentLength.toLong() + total

            if (connection.responseCode != HttpURLConnection.HTTP_OK && connection.responseCode != HttpURLConnection.HTTP_PARTIAL) {
                mReason = connection.responseMessage
                return CODE_FAILED
            }

            mAvailableSpace = FileUtil.getAvailableInternalMemorySize()
            if (mFileLength >= mAvailableSpace) {
                mReason = ERR_INSUFFICIENT_SPACE
                return CODE_FAILED
            }

            val outputStream: OutputStream = FileOutputStream(downloadData.filePath
                ?: "/videos/video.mp4", isAppend)

            output = outputStream

            val bytes = ByteArray(4096)

            var count = input.read(bytes)

            aesCipherDataSink = AesCipherDataSink(Util.getUtf8Bytes("vovanhoan1234567"), object : DataSink {
                override fun open(dataSpec: DataSpec?) {

                }

                override fun write(buffer: ByteArray?, offset: Int, length: Int) {
                    output.write(bytes, offset, length)
                }

                override fun close() {
                    output.close()
                }

            })
            aesCipherDataSink.open(DataSpec(Uri.parse(downloadData.url)))
            var progress = 0
            while (count != -1) {
                if (isCancelled) {
                    closeAll()
                    mReason = ERR_CANCEL
                    return CODE_FAILED
                }
                total += count

                if (mFileLength > 0) {
                    val newProgress = ((total * 100) / mFileLength).toInt()
                    if (newProgress > progress) {
                        progress = newProgress
                        publishProgress(newProgress)
                    }
                }

                aesCipherDataSink.write(bytes, 0, count)
                count = input.read(bytes)
            }
//            closeAll()
        } catch (exOOM: OutOfMemoryError) {
            exOOM.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(exOOM)
            FirebaseCrashlytics.getInstance().log("download-save-error: OOM")

//            Log.d("LOG", this.javaClass.simpleName + " saveFileInternal() | error: ${exOOM.message}")
//            Log.e("LOG", this.javaClass.simpleName + " saveFileInternal() | error: ${exOOM.message}")
            isEncounteredOOM = true
            mReason = Constant.ERROR_OUT_OF_MEMORY
            return CODE_FAILED
        } catch (e: Exception) {
            e.printStackTrace()
            FirebaseCrashlytics.getInstance().recordException(e)
            FirebaseCrashlytics.getInstance().log("download-save-error: ${e.message}")
//            Log.d("LOG", this.javaClass.simpleName + " saveFileInternal() | error: ${e.message}")
//            Log.e("LOG", this.javaClass.simpleName + " saveFileInternal() | error: ${e.message}")
            if (!isEncounteredOOM) {
                mReason =
                    when (isNetworkDisconnected()) {
                        true -> ERR_NETWORK_DISCONNECTED
                        false -> e.message ?: ERR_UNKNOWN
                    }
                return CODE_FAILED
            }
        } finally {
            closeAll()
        }
        return CODE_COMPLETED
    }

    private fun saveFileExternal(downloadData: DownloadData): Int {
        var isEncounteredOOM = false
        try {
            val httpURLConnection = URL(downloadData.url).openConnection() as HttpURLConnection
            connection = httpURLConnection
            connection.connectTimeout = 3000
            connection.setRequestProperty("Cookie", mCookieValue)

            var total = 0L

            var isAppend = false
            if (!savedFile.exists()) {
                savedFile.createNewFile()
            } else {
                total = savedFile.length()
                isAppend = true
                connection.setRequestProperty("Range", "bytes=" + savedFile.length() + "-")
            }

            connection.connect()

            val inputStream = BufferedInputStream(connection.inputStream)
            input = inputStream
            mFileLength = connection.contentLength.toLong() + total

            if (connection.responseCode != HttpURLConnection.HTTP_OK && connection.responseCode != HttpURLConnection.HTTP_PARTIAL) {
                mReason = connection.responseMessage
                return CODE_FAILED
            }

            mAvailableSpace = FileUtil.getAvailableExternalMemorySize(context)
            if (mFileLength >= mAvailableSpace) {
                closeInAndConn()
                saveFileInternal(downloadData)
            }

            val outputStream: OutputStream = FileOutputStream(downloadData.filePathExternal
                ?: "/videos/video.mp4", isAppend)
            output = outputStream
            //outputCos = CipherOutputStream(outputStream, FileUtil.generateKeyAndEncryptFile())

            val bytes = ByteArray(4096)

            var count = input.read(bytes)
            aesCipherDataSink = AesCipherDataSink(Util.getUtf8Bytes("vovanhoan1234567"), object : DataSink {
                override fun open(dataSpec: DataSpec?) {

                }

                override fun write(buffer: ByteArray?, offset: Int, length: Int) {
                    output.write(bytes, offset, length)
                }

                override fun close() {
                    output.close()
                }

            })
            aesCipherDataSink.open(DataSpec(Uri.parse(downloadData.url)))
            var progress = 0
            while (count != -1) {
                if (isCancelled) {
                    closeAll()
                    mReason = ERR_CANCEL
                    return CODE_FAILED
                }
                total += count

                if (mFileLength > 0) {
                    val newProgress = ((total * 100) / mFileLength).toInt()
                    if (newProgress > progress) {
                        progress = newProgress
                        publishProgress(newProgress)
                    }
                }

                aesCipherDataSink.write(bytes, 0, count)
                count = input.read(bytes)
            }
        } catch (oom: OutOfMemoryError) {
            oom.printStackTrace()
//            Log.d("LOG", this.javaClass.simpleName + " saveFileExternal() - OOM | error: ${oom.message}")
//            Log.e("LOG", this.javaClass.simpleName + " saveFileExternal() - OOM | error: ${oom.message}")
            isEncounteredOOM = true
            mReason = Constant.ERROR_OUT_OF_MEMORY
            return CODE_FAILED

        } catch (e: Exception) {
            e.printStackTrace()
//            Log.d("LOG", this.javaClass.simpleName + " saveFileExternal() | error: ${e.message}")
//            Log.e("LOG", this.javaClass.simpleName + " saveFileExternal() | error: ${e.message}")
            if (!isEncounteredOOM) {
                mReason =
                    when (isNetworkDisconnected()) {
                        true -> ERR_NETWORK_DISCONNECTED
                        false -> e.message ?: ERR_UNKNOWN
                    }
                return CODE_FAILED
            }
        } finally {
            closeAll()
        }
        return CODE_COMPLETED
    }

    private fun closeAll() {
        if (::aesCipherDataSink.isInitialized) {
            aesCipherDataSink.close()
        }
        if (::input.isInitialized) {
            input.close()
        }
        if (::connection.isInitialized) {
            connection.disconnect()
        }
    }

    private fun closeInAndConn() {
        if (::input.isInitialized) {
            input.close()
        }
        if (::connection.isInitialized) {
            connection.disconnect()
        }
    }

    private fun isNetworkDisconnected(): Boolean {
        context?.also { context ->
            return !NetworkReceiver.getInstance().checkConnectState(context)
        }
        return false
    }

    fun release() {
        context = null
    }

    interface Callback {
        fun onDownloadStarted(id: Int?, name: String?)
        fun onDownloadUpdate(id: Int?, name: String?, progress: Int)
        fun onDownloadFailed(id: Int?, name: String?, reason: String, url: String?)
        fun onDownloadCompleted(id: Int?, name: String?)
        fun onInsufficientSpace(videoId: Int?, name: String?, availableSpace: Long, fileSize: Long)
    }

    companion object {
        const val CODE_COMPLETED = -100
        const val CODE_FAILED = -200
        const val ERR_NO_URL = "No downloaded url"
        const val ERR_CANCEL = "Download task is canceled"
        const val ERR_NETWORK_DISCONNECTED = "Network disconnected"
        const val ERR_INSUFFICIENT_SPACE = "Insufficient space"
        const val ERR_UNKNOWN = "Error unknown"
    }
}