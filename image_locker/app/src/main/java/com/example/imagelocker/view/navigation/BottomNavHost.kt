package com.example.imagelocker.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.imagelocker.view.screen.LockerScreen
import com.example.imagelocker.view.screen.SearchScreen

@Composable
fun BottomNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(searchRoute) { SearchScreen() }

        composable(lockerRoute) { LockerScreen() }
    }
}