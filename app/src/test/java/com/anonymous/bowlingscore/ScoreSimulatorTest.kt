package com.anonymous.bowlingscore

import com.google.common.truth.Truth.*
import org.junit.Test

class ScoreSimulatorTest {

    @Test
    fun `should return 0 frames for new game`(){
        val scoreSimulator = ScoreSimulator()

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(0)
    }
}