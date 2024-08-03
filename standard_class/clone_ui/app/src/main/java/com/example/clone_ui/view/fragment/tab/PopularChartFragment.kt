package com.example.clone_ui.view.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.view.adapter.PopularChartAdapter
import com.example.clone_ui.databinding.FragmentPopularChartBinding
import com.example.clone_ui.viewmodel.PopularChartViewModel

class PopularChartFragment : Fragment() {
    private lateinit var binding: FragmentPopularChartBinding
    private val popularChartViewModel: PopularChartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (popularChartViewModel.popularChart.value.isNullOrEmpty()) {
            popularChartViewModel.getPopularChart()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularChartBinding.inflate(inflater)
        val popularChartRecyclerView = binding.popularChartRecyclerView
        val adapter = PopularChartAdapter(requireContext())

        popularChartViewModel.popularChart.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) adapter.submitList(it)
        }

        popularChartRecyclerView.layoutManager = LinearLayoutManager(context)
        popularChartRecyclerView.adapter = adapter

        return binding.root
    }
}