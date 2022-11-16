package com.anonymous.bowlingscore

class ScoreCalculator {

    fun getFrameScore(frame: Frame): Int {
        return frame.firstRoll+ (frame.secondRoll ?: 0)
    }

}
