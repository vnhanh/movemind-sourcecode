package player.wellnesssolutions.com.ui.fragment_control.helpers

import android.animation.ValueAnimator
import android.view.View
import android.widget.ImageView

/**
 * This class help to show the menu animation
 * Use in NOW PLAYING screen and CONTROL FRAGMENT
 */
class MMMenuAnimationHelper : ValueAnimator.AnimatorUpdateListener {
    companion object {
        const val DURATION = 400L
        private const val WHOLE_CRICLE = 360
        private const val HALF_CIRCLE = 180
    }

    private lateinit var mAnimator: ValueAnimator

    private var mWillShowButton: ImageView? = null
    private var mWillHideButton: ImageView? = null
    private var mFloatMenu: View? = null
    private var mMenuFrame: View? = null
    private var mIsHideFloatMenu = false
    private var mIsAnimating = false

    // flag check if animation has moved from state 1 to state 2
    private var mIsStateTransfered = false

    init {
        init()
    }

    fun init() {
        mAnimator = ValueAnimator.ofInt(0, WHOLE_CRICLE).setDuration(DURATION)
        mAnimator.addUpdateListener(this)
    }

    fun restart() {
        init()
        mIsAnimating = false
    }

    override fun onAnimationUpdate(animator: ValueAnimator) {
        val value: Int = animator.animatedValue as Int
        val willShowButton: ImageView? = mWillShowButton
        val willHideButton: ImageView? = mWillHideButton
        val _floatMenu: View? = mFloatMenu
        val _menuFrame: View? = mMenuFrame
        if (willShowButton == null || willHideButton == null || _floatMenu == null || _menuFrame == null) return

        process(willShowButton, willHideButton, _floatMenu, _menuFrame, value)
    }

    private fun process(willShowButton: ImageView, willHideButton: ImageView, floatMenu: View, menuFrame: View, value: Int) {
        if (value <= HALF_CIRCLE) {
            rotateWillHideButton(willHideButton, value)
        } else {
            if (!mIsStateTransfered) {
                willHideButton.visibility = View.INVISIBLE
                willShowButton.alpha = 0f
                willShowButton.visibility = View.VISIBLE

                if (!mIsHideFloatMenu) {
                    floatMenu.alpha = 0f
                    floatMenu.visibility = View.VISIBLE
                    menuFrame.visibility = View.VISIBLE
                }

                mIsStateTransfered = true
            }

            roateWillShowButton(willShowButton, floatMenu, menuFrame, value - HALF_CIRCLE)

            if (value == WHOLE_CRICLE) {
                mIsAnimating = false
            }
        }
    }

    private fun roateWillShowButton(showButton: ImageView, floatMenu: View, menuFrame: View, value: Int) {
        showButton.rotation = value * 1f / HALF_CIRCLE * 360

        val ratio: Float = value * 1f / HALF_CIRCLE
        val _ratio: Float = ratio * 100

        showButton.alpha = _ratio
        if (mIsHideFloatMenu) {
            floatMenu.alpha = 1 - ratio
            if (ratio == 1f) {
                floatMenu.visibility = View.INVISIBLE
                menuFrame.visibility = View.INVISIBLE
            }
        } else {
            floatMenu.alpha = ratio
        }
    }

    private fun rotateWillHideButton(willHideButton: ImageView, value: Int) {
        val degree: Float = value * 1f / HALF_CIRCLE * 360
        willHideButton.rotation = degree

        val ratio: Float = (HALF_CIRCLE - value) * 1f / HALF_CIRCLE * 100

        willHideButton.alpha = ratio
    }

    fun release() {
        mAnimator.removeUpdateListener(this)
        mWillShowButton = null
        mWillHideButton = null
        mFloatMenu = null
    }

    // run showing or closing menu animation
    /**
     * if open menu:
     *      1. willShowButton: the CLOSE MENU button
     *      2. willHideButton: the MENU button
     *
     * else if close menu:
     *      1. willShowButton: the MENU button
     *      2. willHideButton: the CLOSE MENU button
     */
    fun startAnim(willShowButton: ImageView, willHideButton: ImageView, floatMenu: View, menuFrame: View, isHideFloatMenu: Boolean): Boolean {
        if (mIsAnimating) {
            return false
        }
        mIsAnimating = true

        this.mWillShowButton = willShowButton
        this.mWillHideButton = willHideButton
        this.mFloatMenu = floatMenu
        this.mMenuFrame = menuFrame
        this.mIsHideFloatMenu = isHideFloatMenu

        willHideButton.visibility = View.VISIBLE
        willShowButton.visibility = View.INVISIBLE

        if (!isHideFloatMenu) {
            floatMenu.visibility = View.INVISIBLE
            menuFrame.visibility = View.INVISIBLE
        }

        mIsStateTransfered = false
        mAnimator.start()

        return true
    }
}