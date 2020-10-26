package com.example.coordinatorlayoutviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setSupportActionBar(toolbar)

/*        val fragmentList = arrayListOf<Fragment>()
        for(i in 0..5){
            fragmentList.add(ViewPagerFragment(i))
        }

        val adapter = ViewPagerAdapter(supportFragmentManager, fragmentList)
        viewPager2.adapter = adapter*/

        //openBottomFragment(MainFragment())
        openBottomFragment(MainFragmentWithOutViewPage())
    }

    private fun openBottomFragment(fragment: Fragment) {
        replaceFragmentSlideFromBottom(
            R.id.main_fragment_container, fragment, false, fragment.tag
        )
    }

    private fun replaceFragmentSlideFromBottom(
        containerId: Int,
        fragment: Fragment,
        addToBackStack: Boolean,
        tag: String?
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.replace(containerId, fragment).commit()
    }
}
