package com.example.clone_ui.data.`object`

import com.example.clone_ui.data.SearchHistoryData

object SearchHistoryObject {
    private val history = mutableListOf(
        SearchHistoryData(
            id = 1,
            searchText = "테스트 검색"
        )
    )

    fun getHistory(): List<SearchHistoryData> = history
}