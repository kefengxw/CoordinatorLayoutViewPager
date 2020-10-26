package com.example.coordinatorlayoutviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val layoutId = R.layout.fragment_main
        setHasOptionsMenu(true)
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentView(savedInstanceState)
    }

    private fun initFragmentView(savedInstanceState: Bundle?){

        toolbar.title = "viewPage2的测试"
        enableToolBar(toolbar)

        handlePageAdapter()
    }

    private fun enableToolBar(toolbar: Toolbar) {
        activity?.let {
            (activity as MainActivity).setSupportActionBar(toolbar)
        }
    }

    private fun handlePageAdapter() {

        lateinit var tabMediator: TabLayoutMediator

        val pageAdapter = ViewPagerAdapter(3, this)
        viewPager2.adapter = pageAdapter

        //下边是个lambda变换
        tabMediator = TabLayoutMediator(trend_tabs, viewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "year"
                1 -> "week"
                2 -> "month"
                else -> "year"
            }
        }
        tabMediator.attach()

        // Google has a bug here
        // trend_tabs.getTabAt(2)!!.select()
        // trend_view_pager.setCurrentItem(2, true)
    }
}