package com.anonymous.bowlingscore

class ScoreCalculator {

    fun getFrameScore(frame: Frame, bonusRoll1: Int? = null, bonusRoll2: Int? = null): Int {
        return frame.firstRoll+
                (frame.secondRoll ?: 0) +
                (bonusRoll1 ?: 0)+
                (bonusRoll2 ?: 0)
    }

    fun getGameScore(game: Game): Int {
        var score = 0
        game.frames.forEachIndexed { frameNumber, frame ->
            val remainingRolls = game.frames.drop(frameNumber + 1)
                .flatMap { listOf(it.firstRoll, it.secondRoll) }
            val rollsFollowing = (remainingRolls + game.bonusRoll1).filterNotNull()
            val nextRoll = rollsFollowing.getOrNull(0).takeIf { frame.let { it.isSpare || it.isStrike } }
            val secondNextRoll =  rollsFollowing.getOrNull(1).takeIf { frame.isStrike }
            score += getFrameScore(frame, nextRoll, secondNextRoll)
        }
        return score
    }

}
