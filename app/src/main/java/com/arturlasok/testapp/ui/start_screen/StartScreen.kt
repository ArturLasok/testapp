package com.arturlasok.testapp.ui.start_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StartScreen(
    navigateTo: (route: String) -> Unit,
    isDarkModeOn: Boolean,
) {
    Text("START SCREEN")
}