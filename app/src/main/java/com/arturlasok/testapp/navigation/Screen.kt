package com.arturlasok.testapp.navigation

sealed class Screen(val route: String) {

    object Start : Screen("Start")

    object Settings : Screen("Settings")
}
