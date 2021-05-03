package player.wellnesssolutions.com.base.utils

import androidx.annotation.IdRes
import androidx.fragment.app.*
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.ui.activity_main.MainActivity


object FragmentUtil {

    fun addNewFragment(fm: FragmentManager?, newFragment: Fragment, @IdRes frameId: Int) {
        if (fm == null) return
        fm.beginTransaction().add(frameId, newFragment).commit()
    }

    fun replaceFragment(fm: FragmentManager?, newFragment: Fragment, newFragmentTag: String, @IdRes frameId: Int, isAddToBackStack: Boolean = false, isRemoveOlds: Boolean = false) {
        if (fm == null) return
        val ft: FragmentTransaction = fm.beginTransaction()

//        if (isRemoveOlds) {
//            try {
//                fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }

        // if open new fragment: enter_fragment for new one, exit_fragment for old one
        // if back: fade_in_left for new one, fade_out_right for old one
        ft.setCustomAnimations(R.anim.enter_fragment, R.anim.exit_fragment, R.anim.fade_in_left, R.anim.fade_out_right)

        ft.replace(frameId, newFragment, newFragmentTag)

        if (isAddToBackStack) ft.addToBackStack(null)

        ft.commitAllowingStateLoss()

    }

    fun printActivityFragmentList(fragmentManager: FragmentManager, index: Int = 0) {
        // Get all Fragment list.
        val fragmentList = fragmentManager.fragments

        val size = fragmentList.size

        for (i in 0 until size) {
            val fragment = fragmentList[i]

            if (fragment != null) {
                val fragmentTag = fragment.tag
                val builder = StringBuilder()

                for (j in 0..index) {
                    builder.append("  ")
                }
                builder.append(fragmentTag)

                val childFm = fragment.childFragmentManager
                if (childFm.fragments.size > 0) {
                    printActivityFragmentList(childFm, index + 1)
                }
            }
        }
    }

    fun showDialogFragment(fm: FragmentManager, dialog: DialogFragment, dialogTag: String) {
        val ft = fm.beginTransaction()
        val showedDialog = fm.findFragmentByTag(dialogTag)
        if (showedDialog != null) {
            ft.remove(showedDialog)
        }
        ft.commit()
        dialog.show(fm, dialogTag)
    }

    fun onBackPressedActivity(activity: FragmentActivity?) {
        activity?.also {
            if (it is MainActivity) {
                it.onBackPreviousScreen()
            }
        }
    }
}