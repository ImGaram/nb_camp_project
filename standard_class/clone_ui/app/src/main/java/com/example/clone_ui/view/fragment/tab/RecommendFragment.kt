package com.example.clone_ui.view.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.view.adapter.RecommendAdapter
import com.example.clone_ui.data.`object`.RecommendObject
import com.example.clone_ui.databinding.FragmentRecommendBinding

class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecommendBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendBinding.inflate(inflater)
        val adapter = RecommendAdapter(requireContext())
        val recyclerView = binding.recommendRecyclerView

        adapter.submitList(RecommendObject.getRecommendList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }
}