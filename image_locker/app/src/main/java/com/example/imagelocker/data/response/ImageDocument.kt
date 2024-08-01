package com.example.imagelocker.data.response

import com.google.gson.annotations.SerializedName

data class ImageDocument(
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("display_sitename")
    val displaySiteName: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
)