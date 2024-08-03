package com.example.clone_ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clone_ui.data.PopularChartData
import com.example.clone_ui.repository.PopularChartRepository
import kotlinx.coroutines.launch

class PopularChartViewModel(private val repository: PopularChartRepository = PopularChartRepository()): ViewModel() {
    private val _popularChart = MutableLiveData<List<PopularChartData>>()
    val popularChart: LiveData<List<PopularChartData>> = _popularChart

    // todo :: 나중에 API로 바뀝니다 언젠간.
    fun getPopularChart() {
        viewModelScope.launch {
            _popularChart.value = repository.getPopularChart()
        }
    }
}