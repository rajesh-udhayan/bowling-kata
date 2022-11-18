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

    @Test
    fun `should add second roll to the frame`(){
        scoreSimulator.addRoll(5)
        scoreSimulator.addRoll(2)

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(1)
        assertThat(scoreSimulator.game.frames[0]).isEqualTo(Frame(5, 2))
    }

    @Test
    fun `should return correct frames for 3 strike in a row`(){
        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(10)

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(3)
        assertThat(scoreSimulator.game.frames[0]).isEqualTo(Frame(10, null))
        assertThat(scoreSimulator.game.frames[1]).isEqualTo(Frame(10, null))
        assertThat(scoreSimulator.game.frames[2]).isEqualTo(Frame(10, null))
    }

    @Test
    fun `should return bonus rolls for two strikes at last`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(2)
        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(2)
        scoreSimulator.addRoll(4)

        assertThat(scoreSimulator.game.frames.count()).isEqualTo(2)
        assertThat(scoreSimulator.game.frames[0]).isEqualTo(Frame(10, null))
        assertThat(scoreSimulator.game.frames[1]).isEqualTo(Frame(10, null))
        assertThat(scoreSimulator.game.bonusRoll1).isEqualTo(2)
        assertThat(scoreSimulator.game.bonusRoll2).isEqualTo(4)
    }

    @Test
    fun `should return false for not a spare or strike`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)
        scoreSimulator.addRoll(2)
        assertThat(scoreSimulator.hasRoll()).isTrue()
        scoreSimulator.addRoll(7)
        assertThat(scoreSimulator.hasRoll()).isFalse()
    }

    @Test
    fun `should return true for spare`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)
        scoreSimulator.addRoll(2)
        assertThat(scoreSimulator.hasRoll()).isTrue()
        scoreSimulator.addRoll(8)
        assertThat(scoreSimulator.hasRoll()).isTrue()
        scoreSimulator.addRoll(8)
        assertThat(scoreSimulator.hasRoll()).isFalse()
    }

    @Test
    fun `should return true for strike`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)
        scoreSimulator.addRoll(10)
        assertThat(scoreSimulator.hasRoll()).isTrue()
        scoreSimulator.addRoll(2)
        assertThat(scoreSimulator.hasRoll()).isTrue()
        scoreSimulator.addRoll(4)
        assertThat(scoreSimulator.hasRoll()).isFalse()
    }

    @Test
    fun `pins remaining is 10 on new frame`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)

        assertThat(scoreSimulator.pinsRemaining).isEqualTo(10)
    }

    @Test
    fun `pins remaining is 10 minus second roll`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)

        scoreSimulator.addRoll(2)

        assertThat(scoreSimulator.pinsRemaining).isEqualTo(8)
    }

    @Test
    fun `pins remaining should be 10 after strike`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)

        scoreSimulator.addRoll(10)

        assertThat(scoreSimulator.pinsRemaining).isEqualTo(10)
    }

    @Test
    fun `pins remaining should be 10 after first bonus strike`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)

        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(10)

        assertThat(scoreSimulator.pinsRemaining).isEqualTo(10)
    }

    @Test
    fun `pins remaining should be 10 minus first bonus roll`(){
        val scoreSimulator = ScoreSimulator()
        scoreSimulator.setGameLength(1)

        scoreSimulator.addRoll(10)
        scoreSimulator.addRoll(2)

        assertThat(scoreSimulator.pinsRemaining).isEqualTo(8)
    }
}