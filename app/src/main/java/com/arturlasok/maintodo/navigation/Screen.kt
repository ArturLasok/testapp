package com.arturlasok.maintodo.navigation

sealed class Screen(val route: String) {

    object Start : Screen("Start")

    object Settings : Screen("Settings")
}
