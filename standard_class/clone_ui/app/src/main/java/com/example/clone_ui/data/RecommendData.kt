package com.example.clone_ui.data

import android.os.Parcelable
import com.example.clone_ui.data.recommend.PremiumAppData
import com.example.clone_ui.data.recommend.SponsorAppData
import kotlinx.parcelize.Parcelize

sealed class RecommendData: Parcelable {
    // 헤더 정보.
    @Parcelize
    data class HeaderData(
        val id: Int,
        val headerTitle: String = ""
    ): RecommendData()

    @Parcelize
    data class SponsorAppDataList(
        val id: Int,
        val list: List<SponsorAppData>
    ): RecommendData()

    @Parcelize
    data class PremiumAppDataList(
        val id: Int,
        val list: List<PremiumAppData>
    ): RecommendData()

    // 이벤트 앱 정보
    @Parcelize
    data class EventAppData(
        val id: Int,
        val appIcon: Int = 0,
        val title: String = "",
        val banner: Int = 0,
        val category: String = "",
        val starRating: Double = 0.0,
        val more: String = "",
        val link: String = ""
    ): RecommendData()
}
