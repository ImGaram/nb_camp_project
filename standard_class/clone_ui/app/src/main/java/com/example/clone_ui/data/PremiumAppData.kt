package com.example.clone_ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PremiumAppData(
    val id: Int,
    val appIcon: Int = 0,
    val title: String = "",
    val description: String = "",
    val starRating: Double = 0.0,
    val price: Int = 0,
    val link: String = ""
): Parcelable
