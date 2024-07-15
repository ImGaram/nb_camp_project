package com.example.clone_ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clone_ui.R
import com.example.clone_ui.databinding.FragmentGameBinding
import com.google.android.material.tabs.TabLayoutMediator

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater)
        TabLayoutMediator(binding.gameLayoutCategoryTab, binding.gameLayoutViewPager) { tab, pos ->
            when (pos) {
                0 -> tab.text = "추천"
                1 -> tab.text = "인기 차트"
                2 -> tab.text = "키즈"
                3 -> tab.text = "신규"
                4 -> tab.text = "프리미엄"
                5 -> tab.text = "카테고리"
            }
        }

        return binding.root
    }
}