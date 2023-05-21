package com.arturlasok.testapp

sealed class MainActivityUiState {
    object Loading : MainActivityUiState()
    object ScreenReady  : MainActivityUiState()

}
