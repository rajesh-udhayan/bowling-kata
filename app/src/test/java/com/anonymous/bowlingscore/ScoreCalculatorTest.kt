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

    @Test
    fun `should return correct frame score for single roll`(){
        val scoreCalculator = ScoreCalculator()
        val frame = Frame(5,null)

        val result = scoreCalculator.getFrameScore(frame)

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `should return correct frame score for two rolls`(){
        val scoreCalculator = ScoreCalculator()
        val frame = Frame(5,3)

        val result = scoreCalculator.getFrameScore(frame)

        assertThat(result).isEqualTo(8)
    }

    @Test
    fun `should return correct score for spare`(){
        val scoreCalculator = ScoreCalculator()
        val frame = Frame(5,3)
        val bonusRoll = 6

        val result = scoreCalculator.getFrameScore(frame, bonusRoll)

        assertThat(result).isEqualTo(14)
    }
}