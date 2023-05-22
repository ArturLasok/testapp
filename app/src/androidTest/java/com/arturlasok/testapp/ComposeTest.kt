package com.arturlasok.testapp

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.arturlasok.testapp.ui.start_screen.StartScreen
import org.junit.Rule
import org.junit.Test





class ComposeTest {


    @get:Rule

    val rulec = createComposeRule()


    @Test
    fun StartScreenTextIsVisible() {


        rulec.setContent { StartScreen(navigateTo = { route ->  }, isDarkModeOn = false) }

        rulec.onNodeWithText("START SCREEN").assertIsDisplayed()

    }



}