package com.example.clone_ui.view.fragment.search

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clone_ui.R
import com.example.clone_ui.data.SearchHistoryData
import com.example.clone_ui.databinding.FragmentSearchingBinding
import com.example.clone_ui.view.adapter.SearchingAdapter
import com.example.clone_ui.view.fragment.SearchFragment
import com.example.clone_ui.viewmodel.SearchViewModel

class SearchingFragment : Fragment() {
    private lateinit var binding: FragmentSearchingBinding
    private lateinit var adapter: SearchingAdapter
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (searchViewModel.searchHistory.value.isNullOrEmpty()) {
            searchViewModel.getSearchHistory()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchingBinding.inflate(inflater)
        val res = arguments?.getString("category")
        val editText = binding.searchingEditText
        val recyclerView = binding.searchingHistoryRecyclerView

        editText.setText(res)
        editText.setKeyboard()

        adapter = SearchingAdapter { editText.setText(it) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        searchViewModel.searchHistory.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) adapter.submitList(it)
        }


        binding.searchingBackImage.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchFragment())
                .commit()
        }

        return binding.root
    }

    private fun EditText.setKeyboard() {
        requestFocus()
        postDelayed({
            // 키보드 열기.
            val inputMethodManager = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }, 30)

        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == IME_ACTION_SEARCH) {
                refreshRecycler(text.toString())

                // 키보드 닫기.
                val inputMethodManager = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                clearFocus()
            }
            true
        }
    }

    private fun refreshRecycler(search: String) {
        val historyList = adapter.currentList.toMutableList()
        historyList.add(
            SearchHistoryData(
                id = historyList.size + 1,
                searchText = search
            )
        )

        adapter.submitList(historyList)
    }
}