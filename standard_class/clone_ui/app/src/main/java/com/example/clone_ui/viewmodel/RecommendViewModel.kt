package com.example.clone_ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clone_ui.data.RecommendData
import com.example.clone_ui.repository.RecommendRepository
import kotlinx.coroutines.launch

class RecommendViewModel(private val repository: RecommendRepository = RecommendRepository()): ViewModel() {
    private val _recommendList = MutableLiveData<List<RecommendData>>()
    val recommendList: LiveData<List<RecommendData>> = _recommendList

    fun getRecommendList() {
        viewModelScope.launch {
            _recommendList.value = repository.getRecommendList()
        }
    }
}