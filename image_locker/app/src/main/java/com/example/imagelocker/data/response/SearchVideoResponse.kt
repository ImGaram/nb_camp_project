package com.example.imagelocker.data.response

import com.google.gson.annotations.SerializedName

data class SearchVideoResponse(
    @SerializedName("documents")
    val documents: List<VideoDocument>
)