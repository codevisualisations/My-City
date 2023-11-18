package com.fustun.projectmycity.expandedTests

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.fustun.projectmycity.models.CityModels
import com.fustun.projectmycity.myCity.City
import com.fustun.projectmycity.ui.theme.ProjectMyCityTheme
import com.fustun.projectmycity.R
import com.fustun.projectmycity.myCity.CityScreens
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CityDisplaysExpandedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp(){
        composeTestRule.setContent {
            ProjectMyCityTheme {
                City().RunMyCity(windowSize = WindowWidthSizeClass.Expanded)
            }
        }
    }

    @Test
    fun verifyOnClickNavigationLondon() {
        composeTestRule.onNodeWithText("LONDON").performClick()
        composeTestRule.onNodeWithText("Buckingham Palace").assertExists()
    }

    @Test
    fun verifyOnClickNavigationNewDelhi() {
        composeTestRule.onNodeWithText("NEW DELHI").performClick()
        composeTestRule.onNodeWithText("The Lotus Temple").assertExists()
    }

    @Test
    fun verifyExpandedAppTopBarExists(){
        composeTestRule.onNodeWithTag("tbTitle").assertExists()
    }

    @Test
    fun verifyExpandedAppTopBarDisplaysCorrectTitle(){
        composeTestRule.onNodeWithTag("tbTitle").assertTextEquals("My City!")
    }
}