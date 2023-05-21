package com.arturlasok.testapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.arturlasok.testapp.ui.start_screen.StartScreen
import org.junit.Rule
import org.junit.Test

class ComposeTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun buttonIsVisible() {
        rule.setContent { StartScreen(navigateTo = { route ->  }, isDarkModeOn = false) }

        rule.onNodeWithText("START SCREEN").assertIsDisplayed()

    }



}