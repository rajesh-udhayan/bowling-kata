package com.anonymous.bowlingscore

class ScoreCalculator {

    fun getFrameScore(frame: Frame, bonusRoll: Int? = null): Int {
        return frame.firstRoll+ (frame.secondRoll ?: 0) + (bonusRoll ?: 0)
    }

}
