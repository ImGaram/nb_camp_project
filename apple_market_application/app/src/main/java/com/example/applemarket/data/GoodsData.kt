package com.example.applemarket.data

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
)