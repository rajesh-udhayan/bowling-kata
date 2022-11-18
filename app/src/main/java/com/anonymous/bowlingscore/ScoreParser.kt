package com.anonymous.bowlingscore

class ScoreParser {
    fun getRepresentation(frame: Frame): String {
        return "${frame.firstRoll} ${frame.secondRoll}"
    }

}
