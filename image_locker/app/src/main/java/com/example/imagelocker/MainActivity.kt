package com.example.imagelocker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.imagelocker.navigation.BottomNavHost
import com.example.imagelocker.navigation.LockerBottomNavigation
import com.example.imagelocker.navigation.searchRoute
import com.example.imagelocker.ui.theme.ImageLockerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ImageLockerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        LockerBottomNavigation(
                            navController = navController,
                            containerColor = Color.White
                        )
                    }
                ) { innerPadding ->
                    BottomNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navController,
                        startDestination = searchRoute
                    )
                }
            }
        }
    }
}