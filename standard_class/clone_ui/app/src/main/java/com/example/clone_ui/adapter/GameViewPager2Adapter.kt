package com.example.clone_ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.clone_ui.fragment.tab.PopularChartFragment
import com.example.clone_ui.fragment.tab.RecommendFragment
import com.example.clone_ui.fragment.tab.SoonFragment

class GameViewPager2Adapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 6

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> RecommendFragment()
        1 -> PopularChartFragment()
        else -> SoonFragment()
    }
}