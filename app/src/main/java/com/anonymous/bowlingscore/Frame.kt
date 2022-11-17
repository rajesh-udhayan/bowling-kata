package com.anonymous.bowlingscore

data class Frame(
    val firstRoll: Int,
    val secondRoll: Int?
){
    val isStrike = firstRoll == 10
    val isSpare = !isStrike && firstRoll + (secondRoll ?: 0) == 10
    val isFinished = isStrike || secondRoll != null
}
