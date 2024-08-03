package com.example.clone_ui.view.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.databinding.FragmentRecommendBinding
import com.example.clone_ui.view.adapter.RecommendAdapter
import com.example.clone_ui.viewmodel.RecommendViewModel

class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecommendBinding
    private val recommendViewModel: RecommendViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (recommendViewModel.recommendList.value.isNullOrEmpty()) {
            recommendViewModel.getRecommendList()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendBinding.inflate(inflater)
        val adapter = RecommendAdapter(requireContext())
        val recyclerView = binding.recommendRecyclerView

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        recommendViewModel.recommendList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.submitList(recommendViewModel.recommendList.value)
            }
        }

        return binding.root
    }
}