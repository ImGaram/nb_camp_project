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

    suspend fun getSearchImages(query: String): SearchImageResponse {
        return kakoApi.getSearchImages(query = query)
    }

    suspend fun getSearchVideos(query: String): SearchVideoResponse {
        return kakoApi.getSearchVideos(query = query)
    }

    fun combinationResult(images: SearchImageResponse, videos: SearchVideoResponse): List<ResultDocument> {
        return ResponseMapper.searchImageToResult(images).documents + ResponseMapper.searchVideoToResult(videos).documents
    }
}