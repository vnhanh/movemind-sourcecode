package player.wellnesssolutions.com.base.common.play_video

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat
import com.google.android.exoplayer2.ui.SubtitleView
import kotlinx.android.synthetic.main.custom_controller_player_screen_now_playing.view.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.com.network.models.now_playing.MMVideoLanguage
import java.lang.ref.WeakReference

class ClosedCaptionController(playerControllerView: ConstraintLayout, subtilteView: SubtitleView, showMode: ShowMode = ShowMode.INTERNAL) {
    private val mWeakPlayerControllerView = WeakReference(playerControllerView)
    private val mWeakSubtitleView = WeakReference(subtilteView)
    private val mWeakCCView = WeakReference(playerControllerView.exo_cc)
    private val mShowMode: ShowMode = showMode
    private var mPlayerManager: IPlayVideoContract.Manager? = null
    private var mWeakControllerSubtitleBoard: WeakReference<ConstraintLayout>? = null
    private var mCheckViews: HashMap<String, WeakReference<ImageView>> = HashMap()
    private var mLanguageTextViews: ArrayList<WeakReference<TextView>> = ArrayList()
    private var mLanguageBgViews: ArrayList<WeakReference<View>> = ArrayList()
    private var mMargin = 0
    private var mSubtitleBoardPadding = 0
    private var mVideoId: Int? = null
    private var mIsShownCheckViewOnInit = false
    private var mCheckViewSize = 0
    private val NoneLanguageKey = "-1"

    // the last language key (not none language)
    private var mLastLanguageKey: String? = null

    // for TV
    private var mOptionIndex = 0

    init {
        subtilteView.setBackgroundColor(Color.TRANSPARENT)
        playerControllerView.exo_cc.setOnClickListener {
            mWeakControllerSubtitleBoard?.get()?.also {
                if (it.visibility == View.VISIBLE)
                    it.visibility = View.GONE
                else
                    it.visibility = View.VISIBLE
            }
        }
        if (mMargin == 0) mMargin = playerControllerView.resources.getDimensionPixelSize(R.dimen.margin)
        if (mSubtitleBoardPadding == 0) mSubtitleBoardPadding = playerControllerView.resources.getDimensionPixelSize(R.dimen.marginx2)
    }

    fun createOrUpdateSubtitleBoardView(videoId: Int?, languages: ArrayList<MMVideoLanguage>?) {
        if (this.mVideoId == videoId) {
            updateSubtitleBoardView()
            resetData()
            return
        }
        this.mVideoId = videoId
        if (videoId == null) return

        val parentView = mWeakPlayerControllerView.get()
                ?: return
        clearLatestViews(parentView)

        if (languages == null) return

        val subtitleBoard = ConstraintLayout(parentView.context)
        subtitleBoard.id = R.id.closedCaptionController
        subtitleBoard.setBackgroundResource(R.drawable.bg_rectangle_black_corner_top_2dp)
        subtitleBoard.alpha = 0.8f

        createControllerBoard(parentView, subtitleBoard, languages)

        subtitleBoard.visibility = View.GONE

        mWeakControllerSubtitleBoard = WeakReference(subtitleBoard)
    }

    private fun updateSubtitleBoardView() {
        mWeakPlayerControllerView.get()?.context?.also {
            // show subtitle view if language option has been selected
            if (PreferenceHelper.getInstance(it).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey).equals(NoneLanguageKey)) {
                hideSubtitleView()
            } else {
                showSubtitleView()
            }
        }
    }

    private fun createControllerBoard(parentView: ConstraintLayout, subtitleBoard: ConstraintLayout, languages: java.util.ArrayList<MMVideoLanguage>) {
        val bottomBar = parentView.findViewById<View>(R.id.bgController)
        val minWidth = parentView.resources.getDimensionPixelSize(R.dimen.screen_now_playing_subtitle_board_width)
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        subtitleBoard.layoutParams = params
        subtitleBoard.minimumWidth = minWidth
//        subtitleBoard.setPadding(mSubtitleBoardPadding , mSubtitleBoardPadding, mSubtitleBoardPadding, mSubtitleBoardPadding)

        addChildViews(subtitleBoard, languages)

        parentView.addView(subtitleBoard)

        val set = ConstraintSet()
        set.clone(parentView)
        set.connect(subtitleBoard.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, mMargin * 2)
        set.connect(subtitleBoard.id, ConstraintSet.BOTTOM, bottomBar.id, ConstraintSet.TOP)
        set.applyTo(parentView)

    }

    private fun addChildViews(subtitleBoard: ConstraintLayout, languages: java.util.ArrayList<MMVideoLanguage>) {
        mIsShownCheckViewOnInit = false
        var index = 0

        val lastLanguageKey = PreferenceHelper.getInstance(subtitleBoard.context).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
        if (lastLanguageKey == NoneLanguageKey) {
            PreferenceHelper.getInstance(subtitleBoard.context).putString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
        }

        var iconCheck: View? = null
        if (languages.size == 0 || languages[0].id != -1)
            languages.add(0, MMVideoLanguage(-1, "None"))

        for (language: MMVideoLanguage in languages) {
            iconCheck = addIconCheck(subtitleBoard, iconCheck)

            val isSelected: Boolean = lastLanguageKey.equals(if (language.id != null) language.id.toString() else NoneLanguageKey)
            if (isSelected) {
                iconCheck.visibility = View.VISIBLE
                mIsShownCheckViewOnInit = true
                mLastLanguageKey = lastLanguageKey
                mOptionIndex = index
            }

            addTextLanguage(subtitleBoard, iconCheck, language)

            if (mShowMode == ShowMode.TV) {
                addBackgroundView(subtitleBoard = subtitleBoard, iconCheck = iconCheck, isSelected = isSelected, language = language)
            }

            index++
        }

        if (!mIsShownCheckViewOnInit) {
            PreferenceHelper.getInstance(subtitleBoard.context).putString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
            mCheckViews.get(NoneLanguageKey)?.get()?.visibility = View.VISIBLE

            // add background view if mode == TV
            if (mShowMode == ShowMode.TV && mLanguageBgViews.size > 0) {
                mLanguageBgViews[0].get()?.also {
                    it.setBackgroundResource(R.drawable.bg_closed_caption_language_selected)
                }
            }
            mLastLanguageKey = NoneLanguageKey
        }

        if (PreferenceHelper.getInstance(subtitleBoard.context).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey).equals(NoneLanguageKey)) {
            hideSubtitleView()
        } else {
            showSubtitleView()
        }
    }

    private fun addIconCheck(subtitleBoard: ConstraintLayout, aboveView: View?): ImageView {
        val checkView = ImageView(subtitleBoard.context)
        checkView.id = ViewCompat.generateViewId()
        checkView.setImageResource(R.drawable.ic_check_white_36dp_8dp)
        checkView.visibility = View.INVISIBLE

        if (mCheckViewSize == 0) mCheckViewSize = subtitleBoard.resources.getDimensionPixelSize(R.dimen.screen_now_playing_subtitle_check_view_size)

        checkView.layoutParams = ConstraintLayout.LayoutParams(mCheckViewSize, mCheckViewSize)
        checkView.setPadding(mSubtitleBoardPadding, 0, 0, 0) // set left/startTask padding

        subtitleBoard.addView(checkView)

        val set = ConstraintSet()
        set.clone(subtitleBoard)
        if (aboveView != null) {
            set.connect(checkView.id, ConstraintSet.TOP, aboveView.id, ConstraintSet.BOTTOM)
        } else {
            set.connect(checkView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
            set.connect(checkView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        }
        set.applyTo(subtitleBoard)

        return checkView
    }

    private fun addTextLanguage(subtitleBoard: ConstraintLayout, leftView: ImageView, videoLanguage: MMVideoLanguage): TextView {
        val textView = createTextLanguageView(subtitleBoard, leftView, videoLanguage)

        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, mCheckViewSize)
        textView.setPadding(0, 0, mSubtitleBoardPadding, 0) // set right/end padding
        textView.layoutParams = params
        textView.gravity = Gravity.START or Gravity.CENTER_VERTICAL

        subtitleBoard.addView(textView)

        val set = ConstraintSet()
        set.clone(subtitleBoard)
        set.connect(textView.id, ConstraintSet.START, leftView.id, ConstraintSet.END, mMargin)
        set.connect(textView.id, ConstraintSet.TOP, leftView.id, ConstraintSet.TOP)
        set.connect(textView.id, ConstraintSet.BOTTOM, leftView.id, ConstraintSet.BOTTOM)
        set.applyTo(subtitleBoard)

        return textView
    }

    private fun createTextLanguageView(subtitleBoard: ConstraintLayout, leftView: ImageView, videoLanguage: MMVideoLanguage): TextView {
        val textView = TextView(subtitleBoard.context)
        textView.id = View.generateViewId()
        textView.text = videoLanguage.name
        textView.setTextColor(Color.WHITE)
        textView.tag = videoLanguage

        textView.setOnClickListener {
            val value = it.tag

            // hide the frame view that contains list language options
            if (mShowMode == ShowMode.INTERNAL)
                mWeakControllerSubtitleBoard?.get()?.visibility = View.GONE

            if (value is MMVideoLanguage) {
                val lastLanguageKey: String = PreferenceHelper.getInstance(it.context).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
                // no change
                if (value.id == null || lastLanguageKey.equals(value.id.toString())) {
                    return@setOnClickListener
                }

                // hide the old icon check
                displayCheckView(context = it.context, isDisplay = false)

                // save the latest language key
                PreferenceHelper.getInstance(it.context).putString(ConstantPreference.LAST_LANGUAGE_KEY,
                        if (value.id != null) value.id.toString()
                        else NoneLanguageKey)
                PreferenceHelper.getInstance(it.context).putString(ConstantPreference.LAST_LANGUAGE_CODE, value.code
                        ?: "")

                // change icon cc
                displayCheckView(context = it.context, isDisplay = true)

                // clicked "None" option
                if (NoneLanguageKey == value.id.toString()) {
                    hideSubtitleView()
                    return@setOnClickListener
                }

                // clicked the old language option
                if (mLastLanguageKey != null && mLastLanguageKey != NoneLanguageKey
                        && lastLanguageKey == NoneLanguageKey && value.id != null
                        && mLastLanguageKey.equals(value.id.toString())) {
                    // guarantee the subtitle view always displayed
                    showSubtitleView()
                    return@setOnClickListener
                }

                // clicked new language option
                mLastLanguageKey = value.id.toString()    // always not null

                mPlayerManager?.onClickedLanguageSubtitle(value)
            }
        }

        if (videoLanguage.id != null)
            mCheckViews[videoLanguage.id.toString()] = WeakReference(leftView)

        mLanguageTextViews.add(WeakReference(textView))

        return textView
    }

    private fun addBackgroundView(subtitleBoard: ConstraintLayout, iconCheck: ImageView, isSelected: Boolean, language: MMVideoLanguage) {
        val bgView = View(subtitleBoard.context)
        bgView.id = View.generateViewId()
        bgView.layoutParams = ConstraintLayout.LayoutParams(0, 0)
        bgView.tag = language

        when (isSelected) {
            true -> bgView.setBackgroundResource(R.drawable.bg_closed_caption_language_selected)
            false -> {
            }
        }

        subtitleBoard.addView(bgView)
        mLanguageBgViews.add(WeakReference(bgView))

        val set = ConstraintSet()
        set.clone(subtitleBoard)
        set.connect(bgView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(bgView.id, ConstraintSet.TOP, iconCheck.id, ConstraintSet.TOP)
        set.connect(bgView.id, ConstraintSet.BOTTOM, iconCheck.id, ConstraintSet.BOTTOM)
        set.connect(bgView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        set.applyTo(subtitleBoard)
    }

    private fun showSubtitleView() {
        mWeakCCView.get()?.also {
            it.setImageResource(R.drawable.ic_closed_caption_white_28dp)
        }
        mWeakSubtitleView.get()?.also {
            if (it.visibility != View.VISIBLE) it.visibility = View.VISIBLE
        }
    }

    private fun hideSubtitleView() {

        mWeakCCView.get()?.also {
            it.setImageResource(R.drawable.ic_closed_caption_gray_28dp)
        }
        mWeakSubtitleView.get()?.also {
            if (it.visibility != View.GONE) it.visibility = View.GONE
        }
    }

    private fun displayCheckView(context: Context, isDisplay: Boolean) {
        val lastLanguageKey = PreferenceHelper.getInstance(context).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
        when (isDisplay) {
            true -> mCheckViews[lastLanguageKey]?.get()?.visibility = View.VISIBLE
            false -> mCheckViews[lastLanguageKey]?.get()?.visibility = View.INVISIBLE
        }

        if (!isDisplay) return // if hide icon, return

        // if show icon that not NONE, show the subtitle view and verse
        when (lastLanguageKey == NoneLanguageKey) {
            true -> {
                mWeakCCView.get()?.also {
                    it.setImageResource(R.drawable.ic_closed_caption_gray_28dp)
                }
            }

            false -> {
                mWeakCCView.get()?.also {
                    it.setImageResource(R.drawable.ic_closed_caption_white_28dp)
                }
            }
        }
    }

    private fun clearLatestViews(parentView: ConstraintLayout) {
        mCheckViews.clear()
        mLanguageTextViews.clear()
        mLanguageBgViews.clear()

        mWeakControllerSubtitleBoard?.get()?.also {
            parentView.removeView(it)
        }
        mWeakControllerSubtitleBoard?.clear()
    }

    fun setPlayerManager(playerManager: IPlayVideoContract.Manager) {
        this.mPlayerManager = playerManager
    }

    fun release() {
        mWeakPlayerControllerView.get()?.also { clearLatestViews(it) }
        mWeakPlayerControllerView.clear()
        mPlayerManager = null
    }

    fun showClosedCaptionView() {
        mWeakControllerSubtitleBoard?.get()?.also {
            if (it.visibility != View.VISIBLE) {
                it.visibility = View.VISIBLE
            }
        }
    }

    fun hideClosedCaptionView() {
        mWeakControllerSubtitleBoard?.get()?.also {
            if (it.visibility != View.GONE) {
                it.visibility = View.GONE
            }
        }
    }

    fun isShowClosedCaptionView(): Boolean = mWeakControllerSubtitleBoard?.get()?.visibility == View.VISIBLE

    fun slideNextLanguageCCOption() {
        if (mShowMode != ShowMode.TV) return
        showClosedCaptionView()

        if (mOptionIndex < 0 || mOptionIndex >= mLanguageBgViews.size) mOptionIndex = 0

        // remove select of old language
        mLanguageBgViews[mOptionIndex].get()?.also {
            it.setBackgroundResource(0)
        }

        when (isShowClosedCaptionView()) {
            true -> mOptionIndex++
            false -> showClosedCaptionView()
        }

        if (mOptionIndex < 0 || mOptionIndex >= mLanguageBgViews.size) mOptionIndex = 0

        mLanguageBgViews[mOptionIndex].get()?.also {
            it.setBackgroundResource(R.drawable.bg_closed_caption_language_selected)
        }
    }

    fun selectCurrentLanguageCCOption() {
        if (mOptionIndex < 0 || mOptionIndex >= mLanguageTextViews.size) mOptionIndex = 0
        mLanguageTextViews[mOptionIndex].get()?.performClick()
    }

    fun resetData() {
        mWeakCCView.get()?.context?.also { context ->
            val lastLanguageKey: String = PreferenceHelper.getInstance(context).getString(ConstantPreference.LAST_LANGUAGE_KEY, NoneLanguageKey)
            if (lastLanguageKey == NoneLanguageKey) mLastLanguageKey = NoneLanguageKey
        }
    }
}