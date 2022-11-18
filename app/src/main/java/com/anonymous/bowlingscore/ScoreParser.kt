package com.anonymous.bowlingscore

class ScoreParser {

    fun getRepresentation(frame: Frame?): String {
        if (frame == null) return ""
        val firstRoll = getCharacter(frame.firstRoll)
        val secondRoll = if (frame.isSpare) "/" else getCharacter(frame.secondRoll)
        return "$firstRoll $secondRoll".trim()
    }

    private fun getCharacter(roll: Int?) = when(roll){
        10 -> "x"
        null -> ""
        else -> roll.toString()
    }
}
