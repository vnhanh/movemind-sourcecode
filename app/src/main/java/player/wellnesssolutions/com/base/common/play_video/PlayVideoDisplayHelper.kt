package player.wellnesssolutions.com.base.common.play_video

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import player.wellnesssolutions.com.common.customize_views.MMProgressBar

object PlayVideoDisplayHelper {
    fun displayViewsOnBuffering(progress: ProgressBar?, btnPlay: View?, btnPause: View?) {
//        Log.d("LOG", this.javaClass.simpleName + " displayViewsOnBuffering()")
        displayLoading(progress = progress, isDisplayed = true)
        hideAllButtons(btnPlay, btnPause)
    }

    fun displayOnReady(isControllerVisible: Boolean, playWhenReady: Boolean, progressLoading: MMProgressBar?, btnPlayVideo: View?, btnPauseVideo: View?) {
//        Log.d("LOG", this.javaClass.simpleName + " displayOnReady() | playWhenReady: $playWhenReady")
        displayLoading(progress = progressLoading, isDisplayed = false)

        displayControllerPlayViews(isControllerVisible, playWhenReady, btnPlayVideo, btnPauseVideo)
    }

    fun displayOnEnded(progressLoading: MMProgressBar?, btnPlayVideo: ImageView?, btnPauseVideo: ImageView?) {
//        Log.d("LOG", this.javaClass.simpleName + " displayOnEnded()")
        displayLoading(progress = progressLoading, isDisplayed = false)
        displayPlayButton(btnPlayVideo, true)
        displayPauseButton(btnPauseVideo, false)
    }

    fun displayControllerPlayViews(controllerVisible: Boolean, playWhenReady: Boolean, btnPlayVideo: View?, btnPauseVideo: View?) {
        if (!controllerVisible) {
            hideAllButtons(btnPlayVideo, btnPauseVideo)
            return
        }

        displayControllerPlayViews(playWhenReady, btnPlayVideo, btnPauseVideo)
    }

    fun hideAllButtons(btnPlayVideo: View?, btnPauseVideo: View?) {
        displayPlayButton(btnPlayVideo, false)
        displayPauseButton(btnPauseVideo, false)
    }

    fun displayControllerPlayViews(playWhenReady: Boolean, btnPlayVideo: View?, btnPauseVideo: View?) {
        displayPlayButton(btnPlayVideo, !playWhenReady)
        displayPauseButton(btnPauseVideo, playWhenReady)
    }

    fun displayLoading(progress: ProgressBar?, isDisplayed: Boolean) {
        displayView(progress, isDisplayed)
    }

    fun displayPlayButton(btnPlayVideo: View?, isDisplayed: Boolean) {
        displayView(btnPlayVideo, isDisplayed)
    }

    fun displayPauseButton(btnPauseVideo: View?, isDisplayed: Boolean) {
        displayView(btnPauseVideo, isDisplayed)
    }

    fun displayView(view: View?, isDisplayed: Boolean) {
//        Log.d("LOG", this.javaClass.simpleName + " displayView() | view: $view | isDisplayed: $isDisplayed")
        when (isDisplayed) {
            true -> {
                view?.also {
                    it.visibility = View.VISIBLE
                }
            }

            false -> {
                view?.also {
                    it.visibility = View.GONE
                }
            }
        }
    }
}