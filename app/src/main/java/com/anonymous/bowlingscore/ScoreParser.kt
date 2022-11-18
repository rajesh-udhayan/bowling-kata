package com.anonymous.bowlingscore

import javax.inject.Inject

class ScoreParser @Inject constructor(){

    fun getRepresentation(frame: Frame?, bonus1: Int? = null, bonus2: Int? = null): String {
        if (frame == null) return ""
        val firstRoll = getCharacter(frame.firstRoll)
        val secondRoll = if (frame.isSpare) "/" else getCharacter(frame.secondRoll)
        val bonusRoll1 = getCharacter(bonus1)
        val bonusRoll2 = getCharacter(bonus2)
        return "$firstRoll $secondRoll $bonusRoll1 $bonusRoll2".trim()
    }

    private fun getCharacter(roll: Int?) = when(roll){
        0 -> "-"
        10 -> "x"
        null -> ""
        else -> roll.toString()
    }
}
