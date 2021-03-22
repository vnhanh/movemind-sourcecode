package player.wellnesssolutions.com.common.utils

import android.os.Build
import androidx.annotation.AnimRes
import androidx.annotation.IdRes


object FragUtil {

    fun addOrShowFragment(fm: androidx.fragment.app.FragmentManager?, newFragment: androidx.fragment.app.Fragment, newFragmentTag:String, curFragTag:String?,
                          @IdRes frame_id:Int, isAddToBackStack: Boolean = true,
                          @AnimRes startAnim:Int? = null, @AnimRes endAnim:Int? = null){
        if (fm == null) return
        val ft = fm.beginTransaction()
        if(startAnim != null && endAnim != null)
            ft.setCustomAnimations(startAnim, endAnim)
        val curFragment = getFragmentByTagName(fm, curFragTag)
        val _newFragment = getFragmentByTagName(fm, newFragmentTag)
        if(_newFragment != null){
            ft.show(_newFragment)
        }else{
            ft.add(frame_id, newFragment, newFragmentTag)
        }
        if(curFragment != null)
            ft.hide(curFragment)

        if(isAddToBackStack)
            ft.addToBackStack(null)

        ft.commit()
    }

    private fun getFragmentByTagName(fm: androidx.fragment.app.FragmentManager, tagName: String?): androidx.fragment.app.Fragment? {
        if(tagName == null) return null
        var fragment: androidx.fragment.app.Fragment? = null
        val fragmentList: List<androidx.fragment.app.Fragment> = fm.fragments
        for (element in fragmentList) {
            if (element.tag != null)
                if (element.tag == tagName) {
                    fragment = element
                }
        }
        return fragment
    }

    fun <T1,T2> ifNotNull(value1:T1?, value2:T2?, runIfNotNull:(T1,T2) -> (Unit)){
        if(value1 != null && value2 != null){
            runIfNotNull(value1, value2)
        }
    }

    fun getSDKVersion() : Int = Build.VERSION.SDK_INT
}