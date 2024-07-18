package com.example.clone_ui.data.`object`

import com.example.clone_ui.R
import com.example.clone_ui.data.SearchData
import com.example.clone_ui.data.search.CategoryData

object SearchObject {
    private val searchList = mutableListOf<SearchData>()
    private val gameCategoryList = mutableListOf<CategoryData>()
    private val appCategoryList = mutableListOf<CategoryData>()

    init {
        with(gameCategoryList) {
            add(CategoryData(1, "액션"))
            add(CategoryData(2, "시뮬레이션"))
            add(CategoryData(3, "퍼즐"))
            add(CategoryData(4, "어드벤처"))
            add(CategoryData(5, "레이싱"))
            add(CategoryData(6, "롤플레잉"))
            add(CategoryData(7, "전략"))
            add(CategoryData(8, "스포츠"))
            add(CategoryData(9, "카드"))
            add(CategoryData(10, "보드"))
            add(CategoryData(11, "학습"))
            add(CategoryData(12, "단어"))
        }

        with(appCategoryList) {
            add(CategoryData(1, "엔터테인먼트"))
            add(CategoryData(2, "소셜"))
            add(CategoryData(3, "금융"))
            add(CategoryData(4, "커뮤니케이션"))
            add(CategoryData(5, "음악/오디오"))
            add(CategoryData(6, "사진"))
            add(CategoryData(7, "쇼핑"))
            add(CategoryData(8, "교육"))
            add(CategoryData(9, "예술/디자인"))
            add(CategoryData(10, "동영상 플레이어/편집기"))
            add(CategoryData(11, "날씨"))
            add(CategoryData(12, "뷰티"))
        }

        addSearchData(SearchData.SearchHeaderData(1, "게임 탐색"))
        addSearchData(SearchData.GameCategoryData(2, gameCategoryList))
        addSearchData(SearchData.SearchHeaderData(3, "스폰서・추천"))
        addSearchData(
            SearchData.SearchSponsorAppData(
                id = 4,
                appIcon = R.drawable.ic_search_sponsor_1,
                title = "Temu: 억만장자처럼 쇼핑하기",
                category = "Temu・쇼핑・온라인 마켓",
                starRating = 4.4,
                downLoads = "⬇\uFE0F 1억 이상",
                link = "https://play.google.com/store/apps/details?id=com.einnovation.temu"
            )
        )
        addSearchData(SearchData.SearchHeaderData(5, "앱 탐색"))
        addSearchData(SearchData.AppCategoryData(6, appCategoryList))
    }

    fun getSearchList() = searchList

    private fun addSearchData(item: SearchData) {
        searchList.add(item)
    }
}