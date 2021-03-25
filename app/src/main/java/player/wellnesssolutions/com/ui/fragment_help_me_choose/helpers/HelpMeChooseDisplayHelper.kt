package player.wellnesssolutions.com.ui.fragment_help_me_choose.helpers

import android.content.res.Resources
import android.graphics.Typeface
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.base.utils.StringUtil.getString
import player.wellnesssolutions.com.base.utils.ViewUtil
import player.wellnesssolutions.com.common.customize_views.MMButton
import player.wellnesssolutions.com.common.customize_views.MMTextView
import player.wellnesssolutions.com.common.enums.StyleEnum
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseAnswer
import player.wellnesssolutions.com.network.models.help_me_choose.MMHelpMeChooseQuestion
import player.wellnesssolutions.com.ui.fragment_help_me_choose.IHelpMeChooseContract
import player.wellnesssolutions.com.ui.fragment_help_me_choose.recyclerview.HelpMeChooseQuestionsAdapter

object HelpMeChooseDisplayHelper {
    // parentView is a ConstraintLayout in a ScrollView
    fun showQuestionsAndAnswersFromLoadedData(presenter: IHelpMeChooseContract.Presenter?, data: ArrayList<MMHelpMeChooseQuestion>, hmcButtonText: String,
                                              parentView: ConstraintLayout): ArrayList<HelpMeChooseQuestionsAdapter> {
        if (presenter == null) return ArrayList()

        var flagShowText = 0

        val adapters = ArrayList<HelpMeChooseQuestionsAdapter>()

        val linesMargin = getMarginMiddleQuestionLines(parentView.resources)
        val questionTvWidth = parentView.resources.getDimensionPixelSize(R.dimen.screen_hmc_tv_question_width)
        val rvMarginLeft = parentView.resources.getDimensionPixelSize(R.dimen.screen_hmc_rv_margin_left)
        var prevView: View = parentView
        var isFirstView = true

        for (item: MMHelpMeChooseQuestion in data) {
            prevView = createTitleQuestionView(item.question, questionTvWidth, isFirstView, parentView, prevView, linesMargin)
            isFirstView = false

            prevView = createRecyclers(item.answers, parentView, prevView, rvMarginLeft, presenter, adapters)
            if (prevView.adapter != null) {
                prevView.adapter?.let {
                    if (it.itemCount > 4) {
                        flagShowText = 1
                    }
                }
            }
        }

        val btnHelpMeChoose = createButtonHelpMeChoose(hmcButtonText, parentView, prevView)

        ViewUtil.setupButton(btnHelpMeChoose, this::onClickedButtonHelpMeChoose, presenter)

        val textSwipe = createTextSwipeMoreOption(parentView, prevView)
        applyConstraintForTextSwipe(textSwipe, btnHelpMeChoose, parentView, prevView)

        if (flagShowText == 1) {
            textSwipe.visibility = View.VISIBLE
        } else {
            textSwipe.visibility = View.GONE
        }

        return adapters
    }


    private fun onClickedButtonHelpMeChoose(presenter: IHelpMeChooseContract.Presenter) {
        presenter.clickedButtonHelpMeChoose()
    }

    private fun getMarginMiddleQuestionLines(resources: Resources): Int =
            resources.getDimensionPixelSize(R.dimen.screen_hmc_tv_question_to_above_answers)

    private fun createTitleQuestionView(content: String, width: Int, isFirstView: Boolean,
                                        parentView: ConstraintLayout, prevView: View, lineMargin: Int): TextView {
        val tv = MMTextView(parentView.context, StyleEnum.BTN_COLOR)

        val params = ConstraintLayout.LayoutParams(width, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        tv.layoutParams = params
        tv.text = content

        tv.id = ViewCompat.generateViewId()
        tv.maxLines = 1
        tv.ellipsize = TextUtils.TruncateAt.END
        tv.setTypeface(null, Typeface.BOLD)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, parentView.resources.getDimensionPixelSize(R.dimen.screen_hmc_tv_question_text_size).toFloat())

        parentView.addView(tv)

        applyConstraintForCollectionTitle(tv, parentView, prevView, isFirstView, lineMargin)

        return tv
    }

    private fun createRecyclers(answers: ArrayList<MMHelpMeChooseAnswer>, parentView: ConstraintLayout,
                                prevView: View, marginLeft: Int, presenter: IHelpMeChooseContract.Presenter,
                                adapters: ArrayList<HelpMeChooseQuestionsAdapter>): RecyclerView {

        val rv = RecyclerView(parentView.context)
        rv.id = ViewCompat.generateViewId()
        rv.overScrollMode = View.OVER_SCROLL_NEVER
        rv.layoutParams = ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        rv.layoutManager = LinearLayoutManager(parentView.context, LinearLayoutManager.HORIZONTAL, false)

        parentView.addView(rv)

        applyConstraintForRecyclerview(rv, parentView, prevView, marginLeft)

        // add Adapter for Recyclerview
        val adapter = HelpMeChooseQuestionsAdapter(answers, presenter)
        adapters.add(adapter)
        rv.adapter = adapter

        return rv
    }

    private fun applyConstraintForRecyclerview(rv: RecyclerView, parentView: ConstraintLayout, prevView: View, marginLeft: Int) {
        val set = ConstraintSet()

        set.clone(parentView)

        set.connect(rv.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, marginLeft)
        set.connect(rv.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        set.connect(rv.id, ConstraintSet.TOP, prevView.id, ConstraintSet.TOP)
        set.connect(rv.id, ConstraintSet.BOTTOM, prevView.id, ConstraintSet.BOTTOM)

        set.applyTo(parentView)
    }

    private fun createButtonHelpMeChoose(hmcButtonText: String, parentView: ConstraintLayout, prevView: View): MMButton {
        val width = parentView.resources.getDimensionPixelSize(R.dimen.btn_hmc_width)
        val height = parentView.resources.getDimensionPixelSize(R.dimen.btn_main_height)
        val context = parentView.context

        val button = MMButton(context, true)
        button.text = if (hmcButtonText.isNotEmpty()) hmcButtonText else context.getString(R.string.btn_help_me_choose)

        button.id = R.id.btnHelpMeChoose

        val params = ConstraintLayout.LayoutParams(width, height)
        button.layoutParams = params

        button.setTypeface(null, Typeface.BOLD_ITALIC)
        button.setTextSize(TypedValue.COMPLEX_UNIT_PX, parentView.resources.getDimensionPixelSize(R.dimen.btn_previous_text_size).toFloat())
        button.gravity = Gravity.CENTER

        parentView.addView(button)

        applyConstraintForButtonHMC(button, parentView, prevView)

        return button
    }

    private fun createTextSwipeMoreOption(parentView: ConstraintLayout, prevView: View): TextView {
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT)
        val text = TextView(prevView.context).apply {
            text = getString(parentView.context, R.string.swipe_right_for_more_options)
            id = R.id.txtSwipeMoreOption
            setTypeface(this.typeface, Typeface.ITALIC)
            textSize = parentView.context.resources.getDimension(R.dimen.dip_11)
            layoutParams = params
            setTextColor(ContextCompat.getColor(parentView.context, R.color.color_d7))
            visibility = View.INVISIBLE
        }
        parentView.addView(text)
        return text
    }

    private fun applyConstraintForButtonHMC(button: View, parentView: ConstraintLayout, prevView: View) {
        val marginTop = parentView.resources.getDimensionPixelSize(R.dimen.screen_hmc_btn_hmc_margin_top)
        val set = ConstraintSet()

        set.clone(parentView)

        set.connect(button.id, ConstraintSet.TOP, prevView.id, ConstraintSet.BOTTOM, marginTop)
        set.connect(button.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 4)
        set.connect(button.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(button.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

        set.applyTo(parentView)
    }

    private fun applyConstraintForTextSwipe(text: View, button: View, parentView: ConstraintLayout, prevView: View) {
        val set = ConstraintSet()

        set.clone(parentView)

        set.connect(text.id, ConstraintSet.TOP, prevView.id, ConstraintSet.BOTTOM)
        set.connect(text.id, ConstraintSet.BOTTOM, button.id, ConstraintSet.TOP, 10)
        set.connect(text.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(text.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)

        set.applyTo(parentView)
    }

    private fun applyConstraintForCollectionTitle(appliedView: View, parentView: ConstraintLayout, prevView: View, isFirstView: Boolean, lineMargin: Int) {
        val set = ConstraintSet()

        set.clone(parentView)

        if (isFirstView)
            set.connect(appliedView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 8)
        else
            set.connect(appliedView.id, ConstraintSet.TOP, prevView.id, ConstraintSet.BOTTOM, lineMargin)

        set.connect(appliedView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)

        set.applyTo(parentView)
    }
}