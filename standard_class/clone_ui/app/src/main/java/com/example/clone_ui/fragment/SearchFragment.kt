package com.example.clone_ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.R
import com.example.clone_ui.adapter.SearchAdapter
import com.example.clone_ui.data.`object`.SearchObject
import com.example.clone_ui.databinding.FragmentSearchBinding
import com.example.clone_ui.fragment.search.SearchingFragment

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)

        val recyclerView = binding.searchRecyclerView
        val adapter = SearchAdapter(
            requireContext()
            // todo :: 요기에 클릭 리스너 넣고 안에 replace 넣으면 될듯. bundle도 같이.
        )

        adapter.submitList(SearchObject.getSearchList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        binding.searchCardLayout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchingFragment())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
}