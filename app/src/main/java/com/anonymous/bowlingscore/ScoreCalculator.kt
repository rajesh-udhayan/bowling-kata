package com.anonymous.bowlingscore

class ScoreCalculator {

    fun getFrameScore(frame: Frame, bonusRoll1: Int? = null, bonusRoll2: Int? = null): Int {
        return frame.firstRoll +
                (frame.secondRoll ?: 0) +
                (bonusRoll1 ?: 0) +
                (bonusRoll2 ?: 0)
    }

    fun getGameScore(game: Game): Int {
        var score = 0
        game.frames.forEachIndexed { frameNumber, frame ->
            val (bonusRoll1, bonusRoll2) = game.getBonusRolls(frameNumber)
            score += getFrameScore(frame, bonusRoll1, bonusRoll2)
        }
        return score
    }

}
