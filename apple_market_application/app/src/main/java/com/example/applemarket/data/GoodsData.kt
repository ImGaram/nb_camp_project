package com.example.applemarket.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoodsData(
    val title: String,
    val address: String,
    val description: String,
    val seller: String,
    val price: Int,
    val goodsImage: Int,
    var chatCnt: Int,
    var likeCnt: Int,
    var isLike: Boolean = false
): Parcelable