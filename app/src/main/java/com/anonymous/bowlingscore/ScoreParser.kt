package com.anonymous.bowlingscore

class ScoreParser {

    fun getRepresentation(frame: Frame): String {
        val secondRoll = if (frame.isSpare) "/" else frame.secondRoll.toString()
        return "${frame.firstRoll} $secondRoll"
    }

}
