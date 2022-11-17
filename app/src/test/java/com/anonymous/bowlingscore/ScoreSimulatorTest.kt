package com.anonymous.bowlingscore

import com.google.common.truth.Truth.*
import org.junit.Before
import org.junit.Test

class ScoreSimulatorTest {

    lateinit var scoreSimulator: ScoreSimulator

    @Before
    fun setUp(){
        scoreSimulator = ScoreSimulator()
    }

    @Test
    fun `should return 0 frames for new game`(){
        assertThat(scoreSimulator.game.frames.count()).isEqualTo(0)
    }

    @Test
    fun `should add roll to the game`(){
        scoreSimulator.addRoll(5)

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(1)
        assertThat(scoreSimulator.game.frames[0]).isEqualTo(Frame(5, null))
    }

}