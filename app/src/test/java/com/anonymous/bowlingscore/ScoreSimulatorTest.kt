package com.anonymous.bowlingscore

import com.google.common.truth.Truth.*
import org.junit.Test

class ScoreSimulatorTest {

    @Test
    fun `should return 0 frames for new game`(){
        val scoreSimulator = ScoreSimulator()

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(0)
    }

    @Test
    fun `should add roll to the game`(){
        val scoreSimulator = ScoreSimulator()

        scoreSimulator.addRoll(5)

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(1)
        assertThat(scoreSimulator.game.frames[0]).isEqualTo(Frame(5, null))
    }
}