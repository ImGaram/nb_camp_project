package com.example.clone_ui.repository

import com.example.clone_ui.data.PopularChartData
import com.example.clone_ui.data.`object`.PopularChartObject

class PopularChartRepository {
    fun getPopularChart(): List<PopularChartData> {
        return PopularChartObject.getPopularRank()
    }
}