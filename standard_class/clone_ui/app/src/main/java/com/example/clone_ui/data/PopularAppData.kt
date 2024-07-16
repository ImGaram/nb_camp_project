package com.example.clone_ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularAppData(
    val id: Int,
    val rank: Int,
    val appIcon: Int = 0,
    val title: String = "",
    val category: String = "",
    val starRating: Double = 0.0,
    val event: String? = null,
    val link: String = ""
): Parcelable
