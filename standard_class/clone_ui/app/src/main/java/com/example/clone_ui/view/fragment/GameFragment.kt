package com.example.clone_ui.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clone_ui.R
import com.example.clone_ui.databinding.FragmentGameBinding
import com.example.clone_ui.view.fragment.tab.PopularChartFragment
import com.example.clone_ui.view.fragment.tab.RecommendFragment
import com.example.clone_ui.view.fragment.tab.SoonFragment
import com.google.android.material.tabs.TabLayout

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        changeFragment(RecommendFragment())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater)

        val tabTitle = listOf("추천", "인기 차트", "키즈", "신규", "프리미엄", "카테고리")
        with(binding) {
            repeat(tabTitle.size) {
                gameLayoutCategoryTab.addTab(gameLayoutCategoryTab.newTab().setText(tabTitle[it]))
            }
            gameLayoutCategoryTab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        0 -> changeFragment(RecommendFragment())
                        1 -> changeFragment(PopularChartFragment())
                        else -> changeFragment(SoonFragment())
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }

        return binding.root
    }

    private fun changeFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.game_fragment_container_view, fragment)
            .commit()
    }
}