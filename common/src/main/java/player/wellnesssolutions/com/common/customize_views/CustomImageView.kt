package player.wellnesssolutions.com.common.customize_views

import android.content.Context
import androidx.annotation.DrawableRes
import android.util.AttributeSet
import android.widget.ImageView
import com.bumptech.glide.Glide

class CustomImageView: ImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr:Int) : super(context, attrs, defStyleAttr)

    var isLoadByUrl = true
    private var url:String?=null
    private var drawableRes:Int?=null
    @DrawableRes var errorDrawableRes:Int?=null

    fun setModeLoadByUrl(){
        isLoadByUrl = true
    }

    fun setModeLoadByDrawableResLocal(){
        isLoadByUrl = false
    }

    fun setImageUrl(url:String?){
        setModeLoadByUrl()
        this.url = url
        if(width == 0 || height == 0) return

        loadImage(url, width, height)
    }

    fun setDrawableRes(@DrawableRes res:Int){
        setModeLoadByDrawableResLocal()
        drawableRes = res
        if(width == 0 || height == 0) return
        loadImage(res, width, height)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        loadImage(w, h)
    }

    private fun loadImage(width: Int, height: Int){
        if(isLoadByUrl){
            url?.also {
                loadImage(it, width, height)
            }
        }
        else {
            drawableRes?.also {
                loadImage(it, width, height)
            }
        }
    }

    private fun loadImage(url:String?, width:Int, height:Int){
        when(errorDrawableRes!=null){
            true -> Glide.with(this).load(url).override(width, height).centerCrop().error(errorDrawableRes!!).into(this)
            false -> Glide.with(this).load(url).override(width, height).centerCrop().into(this)
        }

    }

    private fun loadImage(drawableRes: Int, width:Int, height:Int){
        when(errorDrawableRes!=null){
            true -> Glide.with(this).load(drawableRes).override(width, height).error(errorDrawableRes!!).into(this)
            false -> Glide.with(this).load(drawableRes).override(width, height).into(this)
        }
    }
}