package com.anonymous.bowlingscore.domain

import com.anonymous.bowlingscore.model.Frame
import com.anonymous.bowlingscore.model.Game
import javax.inject.Inject

class ScoreCalculator @Inject constructor(){

    fun getFrameScore(frame: Frame, bonusRoll1: Int? = null, bonusRoll2: Int? = null): Int {
        return frame.firstRoll +
                (frame.secondRoll ?: 0) +
                (bonusRoll1 ?: 0) +
                (bonusRoll2 ?: 0)
    }

    fun getGameScore(game: Game): Int {
        return List(game.frames.size) { i ->
            getFrameScore(game, i)!!
        }.takeIf { it.isNotEmpty() }?.reduce { acc, i -> acc + i } ?: 0
    }

    fun getFrameScore(game: Game, frameNumber: Int): Int? {
        if (game.frames.getOrNull(frameNumber) == null) return null
        val (bonusRoll1, bonusRoll2) = game.getBonusRolls(frameNumber)
        return getFrameScore(
            game.frames[frameNumber],
            bonusRoll1,
            bonusRoll2,
        )
    }

}
