package com.anonymous.bowlingscore.domain

import com.anonymous.bowlingscore.model.Frame
import com.anonymous.bowlingscore.model.Game
import javax.inject.Inject

class ScoreSimulator @Inject constructor() {
    private var gameLength: Int = 10
    var game = Game(emptyList())

    fun setGameLength(length: Int) {
        gameLength = length
    }

    val pinsRemaining: Int
        get() {
            val lastFrame = game.frames.lastOrNull()
            return if (game.frames.count { it.isFinished } < gameLength) {
                10 - (lastFrame?.firstRoll?.takeIf { !lastFrame.isFinished } ?: 0)
            } else {
                (10 - (game.bonusRoll1 ?: 0)).takeIf { it != 0 } ?: 10
            }
        }

    fun addRoll(roll: Int) {
        if (!hasRoll()) return
        if (game.frames.count { it.isFinished } == gameLength) {
            addBonusRoll(roll)
        } else {
            val lastFrame = game.frames.lastOrNull()
            val frames = if (lastFrame?.isFinished == false) {
                val newLast = Frame(lastFrame.firstRoll, roll)
                game.frames.dropLast(1) + newLast

            } else game.frames + Frame(roll, null)
            game = Game(frames)
        }
    }

    private fun addBonusRoll(roll: Int) {
        game = if (game.bonusRoll1 == null) {
            Game(game.frames, roll)
        } else {
            Game(game.frames, game.bonusRoll1, roll)
        }
    }

    fun hasRoll(): Boolean {
        if (game.frames.count { it.isFinished } < gameLength) return true
        val lastFrame = game.frames.last()
        return lastFrame.isSpare && game.bonusRoll1 == null || lastFrame.isStrike && game.bonusRoll2 == null
    }

}
