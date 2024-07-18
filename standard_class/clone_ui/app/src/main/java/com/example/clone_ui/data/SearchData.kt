package com.example.clone_ui.data

import android.os.Parcelable
import com.example.clone_ui.data.search.CategoryData
import kotlinx.parcelize.Parcelize

sealed class SearchData: Parcelable {
    @Parcelize
    data class SearchHeaderData(
        val id: Int,
        val title: String = ""
    ): SearchData()

    @Parcelize
    data class GameCategoryData(
        val id: Int,
        val list: List<CategoryData>
    ): SearchData()

    @Parcelize
    data class AppCategoryData(
        val id: Int,
        val list: List<CategoryData>
    ): SearchData()

    @Parcelize
    data class SearchSponsorAppData(
        val id: Int,
        val appIcon: Int = 0,
        val title: String = "",
        val category: String = "",
        val starRating: Double = 0.0,
        val downLoads: String = "",
        val link: String = ""
    ): SearchData()
}
