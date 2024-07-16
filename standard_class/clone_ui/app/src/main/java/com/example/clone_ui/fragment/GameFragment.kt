package com.example.clone_ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clone_ui.R
import com.example.clone_ui.databinding.FragmentGameBinding
import com.example.clone_ui.fragment.tab.PopularChartFragment
import com.example.clone_ui.fragment.tab.RecommendFragment
import com.example.clone_ui.fragment.tab.SoonFragment
import com.google.android.material.tabs.TabLayout

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater)

        with(binding.gameLayoutCategoryTab) {
            childFragmentManager.beginTransaction()
                .add(R.id.game_fragment_container, RecommendFragment())
                .commit()

            addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    changeFragment(tab?.position)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }

        return binding.root
    }

    private fun changeFragment(position: Int?) {
        when (position) {
            0 -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.game_fragment_container, RecommendFragment())
                    .commit()
            }
            1 -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.game_fragment_container, PopularChartFragment())
                    .commit()
            }
            else -> {
                childFragmentManager.beginTransaction()
                    .replace(R.id.game_fragment_container, SoonFragment())
                    .commit()
            }
        }
    }
}