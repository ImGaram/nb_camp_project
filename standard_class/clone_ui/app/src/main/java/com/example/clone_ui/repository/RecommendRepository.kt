package com.example.clone_ui.repository

import com.example.clone_ui.data.RecommendData
import com.example.clone_ui.data.`object`.RecommendObject

class RecommendRepository {
    fun getRecommendList(): List<RecommendData> {
        return RecommendObject.getRecommendList()
    }
}