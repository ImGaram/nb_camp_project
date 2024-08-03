package com.example.clone_ui.view.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.view.adapter.PopularChartAdapter
import com.example.clone_ui.data.`object`.PopularChartObject
import com.example.clone_ui.databinding.FragmentPopularChartBinding

class PopularChartFragment : Fragment() {
    private lateinit var binding: FragmentPopularChartBinding
    private var popularList = PopularChartObject.getPopularRank()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularChartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popularChartRecyclerView = binding.popularChartRecyclerView
        val adapter = PopularChartAdapter(requireContext())
        adapter.submitList(popularList)

        popularChartRecyclerView.layoutManager = LinearLayoutManager(context)
        popularChartRecyclerView.adapter = adapter
    }
}