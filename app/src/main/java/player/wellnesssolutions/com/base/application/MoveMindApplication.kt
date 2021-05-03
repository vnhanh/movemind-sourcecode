package player.wellnesssolutions.com.base.application

import android.app.Application
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.realm.Realm
import io.realm.RealmConfiguration
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.common.sharedpreferences.ConstantPreference
import player.wellnesssolutions.com.common.sharedpreferences.PreferenceHelper
import player.wellnesssolutions.fontsizelibrary.TypefaceUtil


class MoveMindApplication : Application() {

    companion object {
        const val CHANNEL_ID = "MyApplication_MoveMind"
    }

    //    var token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM5YjUyYmYyYTJlMGIwYzk0ZDVkN2Q3YzBhZTI4MzMxOTVjNmMzZGNiNjlkMjUyZTQ2NjgzNjU1NjRmMGUwYWU4ODM2YWNlNzExMWY3ODEyIn0.eyJhdWQiOiIxIiwianRpIjoiYzliNTJiZjJhMmUwYjBjOTRkNWQ3ZDdjMGFlMjgzMzE5NWM2YzNkY2I2OWQyNTJlNDY2ODM2NTU2NGYwZTBhZTg4MzZhY2U3MTExZjc4MTIiLCJpYXQiOjE1NTk5MTIwMzksIm5iZiI6MTU1OTkxMjAzOSwiZXhwIjoxNTYwNTE2ODM5LCJzdWIiOiI3NSIsInNjb3BlcyI6W119.Mu_X0DwtVyG5pgJklzqupC3FvT-Qo09oTt2x6W_hl0hQoegk5-q4Dj1GvOfRH5sfZcxyCdC5Bs39n0RexZwN7YjwTxJjvcnPibV9JDM4EM-OiBcQjwUst-9prTmFRMoZ1viRaczS7hyACcW14vVJwzffH2dubV7yQaDhgoclHuFgL6ESPXauEoddcrga5YmAQPmQ3SLyelCjHIsgYU9sT4v40Dn5JrsuDMIaRz4zknOzrUYMWC7msc066QCoBR0VdJrkfSA9gqIQ2ZgvWxSmV1dx-ZYHyNPa5FxYugjkRnx0cM23lCsvtld181LD4dD1NYLZB5eQIJ7tHDOCJ77NpKs55ylPv9FRyLNu4Fpr1Oso2ZAd4zL7kqo4nI2FizIVt0VOTMtMmuUrvR6I59jmnKLb5G57X21S0gTlG05wxqV3eiIN01X9Qy23vUTJIi9l9TWoYoZ4viaWTbzAnMPbJMisQBTZcxfrjwclqbQGtajrnOZS3jZWEMGjsNqwWSkx_MUEOucME3r3jqrxMSGYvX7Lf2M2Cqp7LibXoH7WhfV1ipoqcIlmaclCSgqDybkIGA7XV3WynloH0UGs1EamvSaLbVmP2pGI7QZGCVET2i72BkaLxXmyDs2o4CWfKiYQ5FdgeYhHxbOKtYuqgBuwiN6_jElIDbbMdtsqACIv4bs"
    var token = ""

    override fun onCreate() {
        super.onCreate()
        FirebaseCrashlytics.getInstance().setUserId("12345")
        setupDB()
        setupDefaultFont()
    }

    private fun setupDB() {
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("move_mind.realm").deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }

    private fun setupDefaultFont() {
//        TypefaceUtil.overrideFont(applicationContext, "SERIF", getString(R.string.font_made_evolve_sans))
        TypefaceUtil.overrideFont(applicationContext, "SERIF", getString(R.string.font_made_evolve_sans_bold))

        //TODO hard code
//        storeBranding()
    }

    private fun storeBranding() {
        val mPref = PreferenceHelper.getInstance(this)
        mPref.putString(ConstantPreference.TOKEN, token)
        mPref.putString(ConstantPreference.DEVICE_ID, "233")
        mPref.putString(ConstantPreference.SS_BOTTOM_BAR_COLOR, "#041e41")
        mPref.putString(ConstantPreference.PRIMARY_COLOR, "#00c3b3")
        mPref.putString(ConstantPreference.SECONDARY_COLOR, "#ffffff")
//        mPref.putString(SPrefConstant.SS_COMPANY_LOGO, branding.companyLogo ?: "")
//        mPref.putStrings(SPrefConstant.SS_BACKGROUND_PICTURES, branding.backgroundPictures)
        mPref.putStrings(ConstantPreference.SS_BACKGROUND_PICTURES, fakeImageBG())
    }

    private fun fakeImageBG(): Array<String> {
        return arrayOf("https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2018/traininggym.jpg",
                "https://www.rider.edu/sites/default/files/styles/hero_image_-_no_play_icon/public/featuredimages/1920x1080%20Runner.jpg",
                "https://www.sheknows.com/wp-content/uploads/2019/03/this-is-how-you-should-recover-after-your-favorite-kind-of-workout.jpg",
                "https://wallpapershome.com/images/pages/pic_h/11085.jpg",
                "https://www.desktop-background.com/p/2011/06/11/217389_gymnastics-exercise-fitness-sexy-babe-sport-grace-artistic-art_1920x1200_h.jpg")
    }
}