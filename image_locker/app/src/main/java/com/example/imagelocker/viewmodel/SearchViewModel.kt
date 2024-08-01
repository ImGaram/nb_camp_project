package com.example.imagelocker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagelocker.data.repository.KakaoSearchRepository
import com.example.imagelocker.data.response.ResultDocument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: KakaoSearchRepository = KakaoSearchRepository()): ViewModel() {
    private val _searchResult = MutableStateFlow<List<ResultDocument>>(emptyList())
    val searchResult: StateFlow<List<ResultDocument>> = _searchResult.asStateFlow()

    fun getSearchList(query: String) {
        viewModelScope.launch {
            val searchImages = repository.getSearchImages(query)
            val searchVideos = repository.getSearchVideos(query)

            val result = repository.combinationResult(searchImages, searchVideos)
            _searchResult.value = result
        }
    }
}