package com.example.clone_ui.data.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryData(
    val id: Int,
    val category: String = ""
): Parcelable
