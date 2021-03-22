package player.wellnesssolutions.com.base.customs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragments = ArrayList<Fragment>()

    override fun getItem(index: Int): Fragment = if (index < count) fragments[index] else Fragment()

    override fun getCount(): Int = fragments.size

    fun addPage(fragment: Fragment) {
        fragments.add(fragment)
    }

    fun getFragments(): ArrayList<Fragment> = fragments

    fun release() {
        fragments.clear()
    }
}