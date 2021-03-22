package player.wellnesssolutions.com.custom_exoplayer

import android.content.Context
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.TransferListener

class EncryptedDefaultDataSourceFactory(
        private val key: String?,
        context: Context,
        private val listener: TransferListener?,
        private val baseDataSourceFactory: DataSource.Factory) : DataSource.Factory {
    private val context: Context = context.applicationContext

    constructor(key: String?, context: Context, baseDataSourceFactory: DataSource.Factory) : this(key, context,  /* listener= */null, baseDataSourceFactory) {}

    override fun createDataSource(): DataSource {
        val dataSource = EncryptedDefaultDataSource(key, context, baseDataSourceFactory.createDataSource())
        if (listener != null) {
            dataSource.addTransferListener(listener)
        }
        return dataSource
    }

}