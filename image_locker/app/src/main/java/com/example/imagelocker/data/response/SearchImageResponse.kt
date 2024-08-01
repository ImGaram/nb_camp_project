package com.example.imagelocker.data.response

import com.google.gson.annotations.SerializedName

data class SearchImageResponse(
    @SerializedName("documents")
    val documents: List<ImageDocument>
)