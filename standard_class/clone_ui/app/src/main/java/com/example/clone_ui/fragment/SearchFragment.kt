package com.example.clone_ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.adapter.SearchAdapter
import com.example.clone_ui.data.`object`.SearchObject
import com.example.clone_ui.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)

        val recyclerView = binding.searchRecyclerView
        val adapter = SearchAdapter(requireContext())

        adapter.submitList(SearchObject.getSearchList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        binding.searchCardLayout.setOnClickListener {  }

        return binding.root
    }
}