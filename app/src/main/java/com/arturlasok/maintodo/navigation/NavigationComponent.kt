package com.arturlasok.maintodo.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arturlasok.maintodo.ui.start_screen.StartScreen

@Composable
fun NavigationComponent(
    navController: NavHostController,
    setCurrentDestination:(route: String) -> Unit,
    currentDestination: String
) {

    NavHost(
    navController = navController,
    startDestination = Screen.Start.route
    ) {
        // Main Screen
        composable(Screen.Start.route) {

            navController.currentDestination?.route?.let { newRoute->
                setCurrentDestination(newRoute)
            }
            StartScreen()
        }

    }
}