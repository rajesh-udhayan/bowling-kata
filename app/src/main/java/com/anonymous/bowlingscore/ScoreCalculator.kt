package com.anonymous.bowlingscore

class ScoreCalculator {

    fun getFrameScore(frame: Frame, bonusRoll1: Int? = null, bonusRoll2: Int? = null): Int {
        return frame.firstRoll+
                (frame.secondRoll ?: 0) +
                (bonusRoll1 ?: 0)+
                (bonusRoll2 ?: 0)
    }

}
