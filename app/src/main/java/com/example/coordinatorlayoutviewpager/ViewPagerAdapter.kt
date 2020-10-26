package com.example.coordinatorlayoutviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/*class ViewPagerAdapter (fm: FragmentManager, private val fragmentList: List<Fragment>) :
FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}*/

class ViewPagerAdapter(private val num: Int, fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return num
    }

    override fun createFragment(position: Int): ViewPagerFragment {
        return ViewPagerFragment(position)
    }
}