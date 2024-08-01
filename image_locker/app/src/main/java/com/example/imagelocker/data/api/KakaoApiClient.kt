package com.example.imagelocker.data.api

import com.example.imagelocker.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KakaoApiClient {
    private const val BASE_URL = BuildConfig.KAKAO_BASE_URL

    private val okHttpClient = OkHttpClient.Builder().build()
    private val kakaoRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val kakaoApi = kakaoRetrofit.create(KakaoApi::class.java)
}