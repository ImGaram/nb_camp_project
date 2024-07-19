package com.example.clone_ui.data.`object`

import com.example.clone_ui.data.SearchingData

object SearchingHistoryObject {
    private val history = mutableListOf(
        SearchingData(
            id = 1,
            searchText = "테스트 검색"
        )
    )

    fun getHistory(): List<SearchingData> = history
}