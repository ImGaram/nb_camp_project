package com.example.imagelocker.data.mapper

import com.example.imagelocker.data.response.ImageDocument
import com.example.imagelocker.data.response.SearchImageResponse
import com.example.imagelocker.data.response.SearchVideoResponse
import com.example.imagelocker.data.response.VideoDocument
import com.example.imagelocker.data.response.ResultDocument
import com.example.imagelocker.data.response.ResultResponse
import java.util.UUID

object ResponseMapper {
    fun searchImageToResult(searchImageResponse: SearchImageResponse): ResultResponse {
        return ResultResponse(
            documents = searchImageResponse.documents.map { imageDocumentToResult(it) }
        )
    }

    fun searchVideoToResult(searchVideoResponse: SearchVideoResponse): ResultResponse {
        return ResultResponse(
            documents = searchVideoResponse.documents.map { videoDocumentToResult(it) }
        )
    }

    private fun imageDocumentToResult(imageDocument: ImageDocument): ResultDocument {
        return ResultDocument(
            id = UUID.randomUUID().toString(),
            title = "[Image] ${imageDocument.displaySiteName}",
            imageUrl = imageDocument.thumbnailUrl,
            datetime = imageDocument.datetime
        )
    }

    private fun videoDocumentToResult(videoDocument: VideoDocument): ResultDocument {
        return ResultDocument(
            id = UUID.randomUUID().toString(),
            title = "[Video] ${videoDocument.title}",
            imageUrl = videoDocument.thumbnail,
            datetime = videoDocument.datetime
        )
    }
}