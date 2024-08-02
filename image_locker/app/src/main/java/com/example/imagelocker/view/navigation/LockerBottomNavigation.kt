package com.example.imagelocker.view.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun LockerBottomNavigation(
    navController: NavController,
    containerColor: Color = BottomAppBarDefaults.containerColor,
    contentColor: Color = contentColorFor(backgroundColor = containerColor),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val screens = listOf(
        BottomNavItem.Search,
        BottomNavItem.Locker
    )

    BottomAppBar(
        modifier = Modifier.shadow(elevation = 5.dp, spotColor = Color.DarkGray),
        containerColor = containerColor,
        contentColor = contentColor,
    ) {
        screens.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screenRoute,
                label = { Text(text = item.title) },
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(painter = painterResource(id = item.icon), contentDescription = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Cyan,
                    selectedTextColor = Color.Cyan,
                    unselectedIconColor = Color.LightGray,
                    unselectedTextColor = Color.LightGray
                )
            )
        }
    }
}