package com.anonymous.bowlingscore

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: MainViewModel
    lateinit var simulator: ScoreSimulator

    @Before
    fun setUp(){
        simulator = spyk()
        viewModel = MainViewModel(simulator)
    }

    @Test
    fun `live data should emit empty list of frames for new game`(){
        viewModel.startNewGame()

        assertThat(viewModel.gameState.getValueForTest()?.frames).isEmpty()
    }

    @Test
    fun `should return non empty frames after adding a roll`(){
        viewModel.addRoll()

        assertThat(viewModel.gameState.getValueForTest()?.frames).isNotEmpty()
    }
}