package com.example.imagelocker.view.navigation

import com.example.imagelocker.R

const val searchRoute = "route_search"
const val lockerRoute = "route_locker"

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val screenRoute: String
) {
    data object Search: BottomNavItem(title = "검색", icon = R.drawable.ic_search, screenRoute = searchRoute)
    data object Locker: BottomNavItem(title = "저장소", icon = R.drawable.ic_locker, screenRoute = lockerRoute)
}