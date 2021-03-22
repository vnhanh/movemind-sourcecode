package player.wellnesssolutions.com.base.application

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class CustomGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val limitCacheSize: Long = 1024 * 1024 * 60L // 40mb
        builder.setDiskCache(ExternalPreferredCacheDiskCacheFactory(context, limitCacheSize))

        builder.setDefaultRequestOptions(
                RequestOptions().format(DecodeFormat.PREFER_RGB_565))
    }
}