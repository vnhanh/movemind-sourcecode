package player.wellnesssolutions.com.ui.fragment_search_brands.recyclerview

import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.vh_search_brand_less_4_items.view.*
import player.wellnesssolutions.com.base.utils.StringUtil
import player.wellnesssolutions.com.base.view.BaseVH
import player.wellnesssolutions.com.common.constant.Constant
import player.wellnesssolutions.com.common.customize_views.MMOptionTextView.Companion.colorBand
import player.wellnesssolutions.com.network.models.screen_search.MMBrand
import player.wellnesssolutions.com.ui.fragment_search_brands.ISearchBrandsContract


class SearchBrandVH(view: View, var imageSize: Int, private var presenter: ISearchBrandsContract.Presenter?) : BaseVH<MMBrand>(view) {
    private var mImageSize = 0

    init {
        setupTextFontDesciption()
        setupImageDimens()
        setupOnClickListener()
    }

    private fun setupImageDimens() {
        itemView.imgBrand?.also { imageView ->
            val innerSize: Int = imageSize - imageView.paddingLeft * 2

            mImageSize = (innerSize / 1.42f).toInt()
            val padding: Int = (imageSize - mImageSize) / 2

            imageView.setPadding(padding, padding, padding, padding)
        }
    }

    private fun setupOnClickListener() {
        itemView.imgBrand?.setOnClickListener {
            data?.also { data ->
                it.isEnabled = false
                itemView.imgBrand?.changeBgColorOnClick()
                presenter?.onChooseItem(data)
                it.isEnabled = true
                colorBand = data.id!!
            }
        }

    }

    private fun setupTextFontDesciption() {
        itemView.tvBrandDesc?.typeface = StringUtil.getTypefaceMadeEvolveSans(itemView.context)
    }

    override fun bind(data: MMBrand) {
        super.bind(data)

        itemView.tvBrandName?.text = data.helperText

        data.id?.also { brandId ->
            renderBgColor(brandId)
        }

        loadImage()
    }

    // mind: 1
    // move123: 2
    // move123 silver: 3
    private fun renderBgColor(brandId: Int) {
        val strBgColor: String =
                when (brandId % 3) {
                    2 -> Constant.MOVE_SILVER_BRAND_BG_COLOR

                    1 -> Constant.MIND_WELNESS_BRAND_BG_COLOR

                    // 2
                    else -> Constant.MOVE_EXCERCISE_BRAND_BG_COLOR
                }

        if (!strBgColor.isEmpty()) {
            itemView.imgBrand?.bgColor = Color.parseColor(strBgColor)
            itemView.imgBrand?.setupBackground()
        }
    }

    private fun loadImage() {
        if (mImageSize <= 0) return
        data?.also { data ->
            itemView.imgBrand?.also { imageView ->
                Glide.with(imageView).load(data.image)
                        .override(mImageSize, mImageSize).centerInside()
                        .diskCacheStrategy(DiskCacheStrategy.DATA)
                        .into(imageView)
            }
        }
    }

    override fun release() {
        super.release()
        presenter = null
    }
}