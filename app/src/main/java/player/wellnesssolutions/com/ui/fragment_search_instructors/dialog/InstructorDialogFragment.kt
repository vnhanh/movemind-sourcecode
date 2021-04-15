package player.wellnesssolutions.com.ui.fragment_search_instructors.dialog

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_dialog_instructor.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.utils.MessageUtils
import player.wellnesssolutions.com.network.models.screen_search.MMInstructor
import player.wellnesssolutions.com.ui.fragment_search_instructors.SearchInstructorsFragment
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil

class InstructorDialogFragment : androidx.fragment.app.DialogFragment() {
    private lateinit var data: MMInstructor

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = LayoutInflater.from(context).inflate(R.layout.fragment_dialog_instructor, container, false)

        dialog?.window?.also { window ->
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.requestFeature(Window.FEATURE_NO_TITLE)
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        setupDimensions()
        readArguments()
        setupUI()
    }

    private fun setupDimensions() {
        val width = context?.resources?.getDimensionPixelSize(R.dimen.width_instructor_dialog_in_search_screen)?:600
        val height = context?.resources?.getDimensionPixelSize(R.dimen.height_instructor_dialog_in_search_screen)?:540
        dialog?.window?.setLayout(width, height)
    }

    private fun readArguments() {
        arguments?.also { bundle ->
            if (bundle.containsKey(KEY_DATA)) {
                val instructor: MMInstructor? = bundle.getParcelable(KEY_DATA)
                if (instructor == null) {
                    MessageUtils.showToast(context, R.string.not_get_presenter_data, R.color.red)
                    dismiss()
                    return
                }

                this.data = instructor

                showInstructorData(instructor)
            }
        }
    }

    private fun showInstructorData(data: MMInstructor) {
        showInstructorInfo(data)

        loadInstructorAvatar(data.image)

        btnShowVideosByPresenter?.text = context?.getString(R.string.title_btn_show_videos_by_presenter_dialog, data.name?.toUpperCase()).orEmpty()
    }

    private fun showInstructorInfo(data: MMInstructor) {
        tvName?.text = data.name

        val tf: Typeface = TypefaceUtil.getTypeface(tvName?.context, getString(R.string.font_made_evolve_sans))
        tvDescription?.setTypeface(tf, Typeface.ITALIC)
        tvDescription?.text = data.profileInformation
    }

    private fun loadInstructorAvatar(image: String?) {
        avatar?.also { imageView ->
            context?.resources?.also { resources ->
                val imageSize = resources.getDimensionPixelSize(R.dimen.dialog_presenter_avatar_size_default)
                val padding = resources.getDimensionPixelSize(R.dimen.padding_for_small_size_wrapper_item_search)
                val loadSize = imageSize - padding * 2

                Glide.with(imageView).load(image)
                        .override(loadSize).circleCrop()
                        .placeholder(R.drawable.bg_sp_no_instructor).error(R.drawable.bg_sp_no_instructor)
                        .into(imageView)
            }
        }
    }

    private fun setupUI() {
        loadCloseIcon()

        btnCloseDialog?.setOnClickListener {
            dialog?.dismiss()
        }

        btnShowVideosByPresenter?.setOnClickListener {
            dialog?.dismiss()
            parentFragment?.also {
                if (it is SearchInstructorsFragment) {
                    it.onClickedShowVideosByInstructor(data)
                }
            }
        }
    }

    private fun loadCloseIcon() {
        btnCloseDialog?.also { button ->
            context?.resources?.also { resources ->
                val closeIconSize = resources.getDimensionPixelSize(R.dimen.dialog_presenter_button_close_size)
                val closeIconPadding = resources.getDimensionPixelSize(R.dimen.margin)
                val loadCloseSize = closeIconSize - closeIconPadding
                Glide.with(button).load(R.drawable.ic_close)
                        .override(loadCloseSize).into(button)
            }
        }
    }


    companion object {
        val TAG = "InstructorDialogFragment"
        val KEY_DATA = "NAME"

        fun getInstance(instructor: MMInstructor): InstructorDialogFragment {
            val fragment = InstructorDialogFragment()
            val bundle = Bundle()
            bundle.putParcelable(KEY_DATA, instructor)
            fragment.arguments = bundle

            return fragment
        }
    }
}