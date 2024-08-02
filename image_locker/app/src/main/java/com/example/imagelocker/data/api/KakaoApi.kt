package com.example.imagelocker.data.api

import com.example.imagelocker.BuildConfig
import com.example.imagelocker.data.response.SearchImageResponse
import com.example.imagelocker.data.response.SearchVideoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoApi {
    @GET("v2/search/image")
    suspend fun getSearchImages(
        @Header("Authorization") authorization: String = "KakaoAK ${BuildConfig.KAKAO_API_KEY}",
        @Query("query") query: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int
    ): SearchImageResponse

    @GET("v2/search/vclip")
    suspend fun getSearchVideos(
        @Header("Authorization") authorization: String = "KakaoAK ${BuildConfig.KAKAO_API_KEY}",
        @Query("query") query: String,
        @Query("sort") sort: String = "recency",
        @Query("page") page: Int
    ): SearchVideoResponse
}