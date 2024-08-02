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
    private val _searchResult = MutableStateFlow<MutableList<ResultDocument>>(mutableListOf())
    val searchResult: StateFlow<List<ResultDocument>> = _searchResult.asStateFlow()

    private val _isLoading = MutableStateFlow<Boolean?>(null)
    val isLoading: StateFlow<Boolean?> = _isLoading.asStateFlow()

    fun getSearchList(query: String, page: Int) {
        viewModelScope.launch {
            _searchResult.value.clear()

            _isLoading.value = false
            val searchImages = repository.getSearchImages(query, page)
            val searchVideos = repository.getSearchVideos(query, page)

            val result = repository.combinationResult(searchImages, searchVideos)
            _searchResult.value = result.sortedByDescending { it.datetime }.toMutableList()

            if (result.isNotEmpty()) _isLoading.value = true
        }
    }

    // 다음 페이지의 리스트가 보여짐.
    fun getNextPageSearchList(query: String, page: Int) {
        viewModelScope.launch {
            _isLoading.value = false
            val searchImages = repository.getSearchImages(query, page)
            val searchVideos = repository.getSearchVideos(query, page)

            val result = repository.combinationResult(searchImages, searchVideos)
            _searchResult.value.addAll(result.sortedByDescending { it.datetime })

            if (result.isNotEmpty()) _isLoading.value = true
        }
    }
}