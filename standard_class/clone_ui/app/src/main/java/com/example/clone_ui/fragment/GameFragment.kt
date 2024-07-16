package com.example.clone_ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clone_ui.adapter.GameViewPager2Adapter
import com.example.clone_ui.databinding.FragmentGameBinding
import com.google.android.material.tabs.TabLayoutMediator

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater)

        with(binding) {
            val tabTitle = listOf("추천", "인기 차트", "키즈", "신규", "프리미엄", "카테고리")
            gameViewPager2.adapter = GameViewPager2Adapter(requireActivity())
            TabLayoutMediator(gameLayoutCategoryTab, gameViewPager2) { tab, pos ->
                tab.text = tabTitle[pos]
            }.attach()
        }

        return binding.root
    }
}