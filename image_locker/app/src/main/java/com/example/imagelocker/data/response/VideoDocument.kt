package com.example.imagelocker.data.response

import com.google.gson.annotations.SerializedName

data class VideoDocument(
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
)