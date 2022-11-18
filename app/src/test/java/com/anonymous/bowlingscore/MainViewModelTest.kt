package com.anonymous.bowlingscore

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.mockk.spyk
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `live data should emit empty list of frames for new game`(){
        val simulator: ScoreSimulator = spyk()

        val viewModel = MainViewModel(simulator)

        viewModel.startNewGame()

        assertThat(viewModel.gameState.getValueForTest()?.frames).isEmpty()
    }
}