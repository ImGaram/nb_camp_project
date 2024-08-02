package com.example.imagelocker.data.repository

import com.example.imagelocker.data.api.KakaoApiClient
import com.example.imagelocker.data.mapper.ResponseMapper
import com.example.imagelocker.data.response.SearchImageResponse
import com.example.imagelocker.data.response.SearchVideoResponse
import com.example.imagelocker.data.response.ResultDocument

class KakaoSearchRepository {
    companion object {
        val kakoApi = KakaoApiClient.kakaoApi
    }

    suspend fun getSearchImages(query: String, page: Int): SearchImageResponse {
        return kakoApi.getSearchImages(query = query, page = page)
    }

    suspend fun getSearchVideos(query: String, page: Int): SearchVideoResponse {
        return kakoApi.getSearchVideos(query = query, page = page)
    }

    fun combinationResult(images: SearchImageResponse, videos: SearchVideoResponse): List<ResultDocument> {
        return ResponseMapper.searchImageToResult(images).documents + ResponseMapper.searchVideoToResult(videos).documents
    }
}