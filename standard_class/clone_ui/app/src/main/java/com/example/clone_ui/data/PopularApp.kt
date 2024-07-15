package com.example.clone_ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularApp(
    val id: Int,
    val rank: Int,
    val appIcon: Int,
    val title: String,
    val category: String,
    val starRating: Double,
    val event: String
): Parcelable
