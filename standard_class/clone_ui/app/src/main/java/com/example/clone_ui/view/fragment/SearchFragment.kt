package com.example.clone_ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.R
import com.example.clone_ui.databinding.FragmentSearchBinding
import com.example.clone_ui.view.adapter.SearchAdapter
import com.example.clone_ui.view.fragment.search.SearchingFragment
import com.example.clone_ui.viewmodel.SearchViewModel

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (searchViewModel.searchCategories.value.isNullOrEmpty()) {
            searchViewModel.getSearchCategory()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        val recyclerView = binding.searchRecyclerView
        val adapter = SearchAdapter(
            requireContext(),
            onCategoryCardClick = {
                val bundle = Bundle()
                bundle.putString("category", it)

                val searchingFragment = SearchingFragment()
                searchingFragment.arguments = bundle

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, searchingFragment)
                    .addToBackStack(null)
                    .commit()
            }
        )
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        searchViewModel.searchCategories.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) adapter.submitList(it)
        }

        binding.searchCardLayout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchingFragment())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
}