package com.arturlasok.testapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arturlasok.testapp.ui.start_screen.StartScreen

@Composable
fun NavigationComponent(
    navController: NavHostController,
) {

    NavHost(
    navController = navController,
    startDestination = Screen.Start.route
    ) {
        // Main Screen
        composable(Screen.Start.route) {


            StartScreen(
                navigateTo = { route -> navController.navigate(route)  },
                isDarkModeOn = true
            )
        }

    }
}