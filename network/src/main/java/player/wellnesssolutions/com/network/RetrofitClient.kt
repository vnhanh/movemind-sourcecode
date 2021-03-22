package player.wellnesssolutions.com.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        private val rets: HashMap<String, Retrofit> = HashMap()

        fun getClient(baseUrl: String): Retrofit {
            if (rets.containsKey(baseUrl)) {
                return rets[baseUrl]!!
            }

            val client = OkHttpClient.Builder()
                    .connectTimeout(180, TimeUnit.SECONDS)
                    .readTimeout(180, TimeUnit.SECONDS)
                    .callTimeout(180, TimeUnit.SECONDS)
                    .build()

            val ret: Retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                    .client(client)
                    .build()
            rets[baseUrl] = ret
            return ret
        }
    }
}