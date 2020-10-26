package com.example.coordinatorlayoutviewpager

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.toolbar
import kotlinx.android.synthetic.main.fragment_main_without_viewpage.*
import kotlinx.android.synthetic.main.fragment_view_pager.*


class MainFragmentWithOutViewPage : Fragment() {

    private lateinit var manager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val layoutId = R.layout.fragment_main_without_viewpage
        setHasOptionsMenu(true)
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragmentView(savedInstanceState)
    }

    private fun initFragmentView(savedInstanceState: Bundle?) {

        toolbar.title = "没有viewPage2"
        enableToolBar(toolbar)
        initTab()
        handleRecyclerView()
    }

    private fun enableToolBar(toolbar: Toolbar) {
        activity?.let {
            (activity as MainActivity).setSupportActionBar(toolbar)
        }
    }

    private fun handleRecyclerView() {

        val list = List<String>(2) { "RecyclerView$it" }
        val adapter = RecyclerViewAdapter(list)
        recycler_view_layout.adapter = adapter
        manager = LinearLayoutManager(context)
        recycler_view_layout.layoutManager = manager

        setTabText()
    }

    private fun setTabText() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recycler_view_layout.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                tab_layout.setScrollPosition(manager.findFirstVisibleItemPosition(), 0f, true)
            }
        }
    }

    private val titles =
        arrayOf("便民生活", "财富管理", "资金往来", "购物娱乐", "教育公益", "滴滴出行", "飞猪旅行", "大麦盒子", "租房买房", "第三方服务", "其他服务")

    private fun initTab() {
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(0)).setTag(Constants.TAG_ZERO))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(1)).setTag(Constants.TAG_ONE))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(2)).setTag(Constants.TAG_TWO))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(3)).setTag(Constants.TAG_THREE))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(4)).setTag(Constants.TAG_FOUR))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(5)).setTag(Constants.TAG_FIVE))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(6)).setTag(Constants.TAG_SIX))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(7)).setTag(Constants.TAG_SEVEN))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(8)).setTag(Constants.TAG_EIGHT))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(9)).setTag(Constants.TAG_NINE))
        tab_layout.addTab(tab_layout.newTab().setText(titles.get(10)).setTag(Constants.TAG_TEN))
    }

    private object Constants {
        const val TAG_ZERO = 0
        const val TAG_ONE = 1
        const val TAG_TWO = 2
        const val TAG_THREE = 3
        const val TAG_FOUR = 4
        const val TAG_FIVE = 5
        const val TAG_SIX = 6
        const val TAG_SEVEN = 7
        const val TAG_EIGHT = 8
        const val TAG_NINE = 9
        const val TAG_TEN = 10
    }
}