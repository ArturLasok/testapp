package com.arturlasok.testapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class ActivityTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun textDarkModeChange() {

        rule.onNodeWithText("change light/dark").performClick()

        rule.onNodeWithText("Now Dark is: false").assertIsDisplayed()

        rule.onNodeWithText("change light/dark").performClick()

        rule.onNodeWithText("Now Dark is: true").assertIsDisplayed()


    }


}