package com.example.clone_ui.data.recommend

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SponsorAppData(
    val id: Int,
    val appIcon: Int = 0,
    val title: String = "",
    val category: String = "",
    val starRating: Double = 0.0,
    val link: String = ""
): Parcelable
