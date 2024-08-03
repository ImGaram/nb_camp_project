package com.example.clone_ui.repository

import com.example.clone_ui.data.SearchData
import com.example.clone_ui.data.SearchHistoryData
import com.example.clone_ui.data.`object`.SearchObject
import com.example.clone_ui.data.`object`.SearchHistoryObject

class SearchRepository {
    fun getSearchCategory(): List<SearchData> {
        return SearchObject.getSearchList()
    }

    fun getSearchHistory(): List<SearchHistoryData> {
        return SearchHistoryObject.getHistory()
    }
}