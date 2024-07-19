package com.example.clone_ui.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchingData(
    val id: Int,
    val searchText: String = ""
): Parcelable
