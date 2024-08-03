package com.example.clone_ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clone_ui.data.SearchData
import com.example.clone_ui.data.SearchHistoryData
import com.example.clone_ui.repository.SearchRepository
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: SearchRepository = SearchRepository()): ViewModel() {
    private val _searchCategories = MutableLiveData<List<SearchData>>()
    val searchCategories: LiveData<List<SearchData>> = _searchCategories

    private val _searchHistory = MutableLiveData<List<SearchHistoryData>>()
    val searchHistory: LiveData<List<SearchHistoryData>> = _searchHistory

    fun getSearchCategory() {
        viewModelScope.launch {
            _searchCategories.value = repository.getSearchCategory()
        }
    }

    fun getSearchHistory() {
        viewModelScope.launch {
            _searchHistory.value = repository.getSearchHistory()
        }
    }
}