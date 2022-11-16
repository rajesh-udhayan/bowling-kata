package com.anonymous.bowlingscore

import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ScoreCalculatorTest {

    @Test
    fun `should return 0 for frame score when two rolls are 0`(){
        val scoreCalculator = ScoreCalculator()
        val frame = Frame(0,0)

        val result = scoreCalculator.getFrameScore(frame)

        assertThat(result).isEqualTo(0)
    }
}