package com.anonymous.bowlingscore

import androidx.activity.viewModels
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.anonymous.bowlingscore.R.string.app_name
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class BowlingScoreViewTest {

    @get:Rule(order = 1)
    internal val hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    internal val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        hiltTestRule.inject()
        composeTestRule.setContent {
            val viewModel = composeTestRule.activity.viewModels<MainViewModel>().value
            BowlingScoreView(viewModel)
        }
    }

    @Test
    fun shouldDisplayAppTitle(){
        composeTestRule.onNodeWithText(composeTestRule.activity.getString(app_name)).assertIsDisplayed()
    }

    @Test
    fun shouldDisplayFrameScoreText(){
        repeat(GAME_LENGTH){
            composeTestRule.onNodeWithTag("frame${it}_tag").assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayTotalScoreText(){
        composeTestRule.onNodeWithTag("total_tag").assertIsDisplayed()
    }

    @Test
    fun shouldDisplaySimulateRollButton(){
        composeTestRule.onNodeWithTag("simulate_btn_tag").assertIsDisplayed()
    }
}