package com.arturlasok.testapp.ui.start_screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StartScreen(
    navigateTo: (route: String) -> Unit,
    isDarkModeOn: Boolean,
) {
    Text(text = "START SCREEN", style = MaterialTheme.typography.h6)
    Text(text = "START SCREEN is in darkMode: $isDarkModeOn", style = MaterialTheme.typography.h6)
}