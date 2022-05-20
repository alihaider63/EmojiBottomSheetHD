package com.haider.emojibottomsheet.view.recyclerview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomSheetPagesAdapter(fr: Fragment) : FragmentStateAdapter(fr) {

    private val fragmentList = mutableListOf<Fragment>()
    private val tabTitles = mutableListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        tabTitles.add(title)
    }

//    override fun getPageTitle(position: Int): CharSequence {
//        return tabTitles[position]
//
//    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}