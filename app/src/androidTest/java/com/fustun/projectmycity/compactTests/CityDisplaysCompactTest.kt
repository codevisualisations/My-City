package com.fustun.projectmycity.compactTests

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.fustun.projectmycity.myCity.City
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CityDisplaysCompactTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            ProjectMyCityTheme {
                City().RunMyCity(windowSize = WindowWidthSizeClass.Compact)
            }
        }
    }

    @Test
    fun verifyStartOverButtonExists() {
        composeTestRule.onNodeWithText("LONDON").performClick()
        composeTestRule.onNodeWithText("START OVER").assertExists()
    }

    @Test
    fun verifyReturnToHomePageOnStartOver(){
        composeTestRule.onNodeWithText("LONDON").performClick()
        composeTestRule.onNodeWithText("START OVER").performClick()
        composeTestRule.onNodeWithText("My City!").assertExists()
    }

    @Test
    fun verifyBuckinghamPalace(){
        composeTestRule.onNodeWithText("LONDON").performClick()
        composeTestRule.onNodeWithText("Buckingham Palace").performClick()
        composeTestRule.onNodeWithTag("tagImage").assertExists()
    }

    @Test
    fun verifyBackButtonWorks(){
        composeTestRule.onNodeWithText("LONDON").performClick()
        composeTestRule.onNodeWithTag("backButton").performClick()
        composeTestRule.onNodeWithText("LONDON").assertExists()
    }
}